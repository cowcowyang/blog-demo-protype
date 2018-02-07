package com.fyang.me.blogdemo.controller;

import com.alibaba.fastjson.JSON;
import com.fyang.me.blogdemo.common.enums.ResponseEnum;
import com.fyang.me.blogdemo.domain.OSSBody;
import com.fyang.me.blogdemo.domain.User;
import com.fyang.me.blogdemo.service.UserService;
import com.fyang.me.blogdemo.vo.Response;
import com.qiniu.common.Zone;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.InputStream;

@RequestMapping("/u")
@RestController
public class ProfileController {

    private static final Logger LOGGER = LogManager.getLogger(ProfileController.class);

    @Value("${file.server.ak}")
    private String accessKey;

    @Value("${file.server.sk}")
    private String secretKey;

    @Value("${file.server.bucket}")
    private String bucketName;

    @Value("${file.server.host}")
    private String host;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @GetMapping("/{username}/profile")
    @PreAuthorize("authentication.name.equals(#username)")
    public ModelAndView profile(@PathVariable("username") String username, Model model) {
        User user = (User)userDetailsService.loadUserByUsername(username);
        model.addAttribute("user", user);
        return new ModelAndView("/userspace/profile", "userModel", model);
    }



    @PostMapping("/{username}/profile")
    @PreAuthorize("authentication.name.equals(#username)")
    public String saveProfile(@PathVariable("username") String username,User user) {
        User originalUser = userService.queryUserById(user.getId());
        originalUser.setEmail(user.getEmail());
        originalUser.setUserName(user.getUserName());

        // 判断密码是否做了变更
        String rawPassword = originalUser.getPassword();
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePasswd = encoder.encode(user.getPassword());
        boolean isMatch = encoder.matches(rawPassword, encodePasswd);
        if (!isMatch) {
            originalUser.setEncodedPassword(user.getPassword());
        }

        userService.saveUser(originalUser);
        return "redirect:/u/" + username + "/profile";
    }


    @GetMapping("/{username}/avatar")
    @PreAuthorize("authentication.name.equals(#username)")
    public ModelAndView avatar(@PathVariable("username") String username, Model model) {
        User  user = (User)userDetailsService.loadUserByUsername(username);
        model.addAttribute("user", user);
        return new ModelAndView("/userspace/avatar", "userModel", model);
    }

    @RequestMapping("/upload")
    @ResponseBody
    public Response<String> uploadAvatar(@RequestParam("file")MultipartFile file){
        String imgURL = StringUtils.EMPTY;
        Response<String> resp = new Response<>(ResponseEnum.Success);

        try {
            InputStream io = file.getInputStream();

            Configuration config = new Configuration(Zone.zone0());
            UploadManager uploadManager = new UploadManager(config);
            String accessToken = Auth.create(accessKey, secretKey).uploadToken(bucketName);

            com.qiniu.http.Response uploadResp = uploadManager.put(io,null,accessToken,null,null);
            OSSBody oSSBody = JSON.parseObject(uploadResp.bodyString(), OSSBody.class);
            resp.setData(host + oSSBody.getKey());
        }catch(Exception e){
            resp.setResponse(ResponseEnum.Fail);
        }
        return resp;
    }

    @PostMapping("/{username}/avatar")
    @PreAuthorize("authentication.name.equals(#username)")
    public ResponseEntity<Response> saveAvatar(@PathVariable("username") String username, @RequestBody User user) {
        String avatarUrl = user.getAvatar();

        User originalUser = userService.queryUserById(user.getId());
        originalUser.setAvatar(avatarUrl);
        userService.saveUser(originalUser);

        return ResponseEntity.ok().body(new Response(ResponseEnum.Success,avatarUrl));
    }

}
