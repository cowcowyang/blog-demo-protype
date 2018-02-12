/**
 * Bolg main JS.
 * Created by waylau.com on 2017/3/9.
 */
"use strict";
//# sourceURL=main.js

// DOM 加载完再执行
$(function () {

    // 返回顶部的效果事件
    NProgress.start();

    $(window).scroll(function () {  //只要窗口滚动,就触发下面代码
        var scrollt = document.documentElement.scrollTop + document.body.scrollTop; //获取滚动后的高度
        if (scrollt > 200) {  //判断滚动后高度超过200px,就显示
            $("#goToTop").fadeIn(400); //淡出
        } else {
            $("#goToTop").stop().fadeOut(400); //如果返回或者没有超过,就淡入.必须加上stop()停止之前动画,否则会出现闪动
        }
    });
    $("#goToTop").click(function () { //当点击标签的时候,使用animate在200毫秒的时间内,滚到顶部
        $("html,body").animate({scrollTop: "0px"}, 200);
    });
    NProgress.done();

    // ajax
    //设置ajax当前状态(是否可以发送);
 /*   var ajaxStatus = true;

// ajax封装
    function ajax(url, data, success, cache, alone, async, type, dataType, error) {
        var type = type || 'post';//请求类型
        var dataType = dataType || 'json';//接收数据类型
        var async = async || true;//异步请求
        var alone = alone || false;//独立提交（一次有效的提交）
        var cache = cache || false;//浏览器历史缓存
        var success = success || function (data) {
            /!*console.log('请求成功');*!/
            setTimeout(function () {
                toastr.error(data.msg);
            }, 500);
            if (data.success) {//服务器处理成功
                setTimeout(function () {
                    if (data.url) {
                        location.replace(data.url);
                    } else {
                        location.reload(true);
                    }
                }, 1500);
            } else {//服务器处理失败
                if (alone) {//改变ajax提交状态
                    ajaxStatus = true;
                }
            }
        };
        var error = error || function (data) {
            /!*console.error('请求成功失败');*!/
            /!*data.status;//错误状态吗*!/
            layer.closeAll('loading');
            setTimeout(function () {
                if (data.status == 404) {
                    toastr.error('请求失败，请求未找到');
                } else if (data.status == 503) {
                    toastr.error('请求失败，服务器内部错误');
                } else {
                    layer.error('请求失败,网络连接超时');
                }
                ajaxStatus = true;
            }, 500);
        };
        /!*判断是否可以发送请求*!/
        if (!ajaxStatus) {
            return false;
        }
        ajaxStatus = false;//禁用ajax请求
        /!*正常情况下1秒后可以再次多个异步请求，为true时只可以有一次有效请求（例如添加数据）*!/
        if (!alone) {
            setTimeout(function () {
                ajaxStatus = true;
            }, 1000);
        }
        $.ajax({
            'url': url,
            'data': data,
            'type': type,
            'dataType': dataType,
            'async': async,
            'success': success,
            'error': error,
            'jsonpCallback': 'jsonp' + (new Date()).valueOf().toString().substr(-4),
        });
    }

// submitAjax(post方式提交)
    function submitAjax(form, success, cache, alone) {
        cache = cache || true;
        var form = $(form);
        var url = form.attr('action');
        var data = form.serialize();
        ajax(url, data, success, cache, alone, false, 'post', 'json');
    }

    /!*!//调用实例
    $(function () {
        $('#form-login').submit(function () {
            submitAjax('#form-login');
            return false;
        });
    });*!/

// ajax提交(post方式提交)
    function post(url, data, success, cache, alone) {
        ajax(url, data, success, cache, alone, false, 'post', 'json');
    }

// ajax提交(get方式提交)
    function get(url, success, cache, alone) {
        ajax(url, {}, success, alone, false, 'get', 'json');
    }

// jsonp跨域请求(get方式提交)
    function jsonp(url, success, cache, alone) {
        ajax(url, {}, success, cache, alone, false, 'get', 'jsonp');
    }*/

});