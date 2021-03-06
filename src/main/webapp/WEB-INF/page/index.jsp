<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>实验室设备管理系统</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>

    <link rel="shortcut icon" href="${ctx}/public/logo.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="${ctx}/public/css/font.css">
    <link rel="stylesheet" href="${ctx}/public/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="${ctx}/public/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/public/js/xadmin.js"></script>

</head>
<body>
<!-- 顶部开始 -->
<div class="container">
    <div class="logo"><a href="./index.html">实验室设备管理系统</a></div>
    <div class="left_open">
        <i title="展开左侧栏" class="iconfont">&#xe699;</i>
    </div>

    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;"><i class="iconfont">&#xe753;</i> ${sessionScope.user.u_name}</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a onclick="userInfo('/userInfo')">个人信息</a></dd>
                <dd><a href="/">切换帐号</a></dd>
                <dd><a href="/">退出</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item to-index"><a>欢迎登录</a></li>
    </ul>

</div>
<!-- 顶部结束 -->
<!-- 中部开始 -->
<!-- 左侧菜单开始 -->
<div class="left-nav">
    <div id="side-nav">
        <ul id="nav">
            <li>
                <a href="javascript:;">
                    <i class="layui-icon">&#xe770;</i>
                    <cite>用户管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="${ctx }/user/list">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>用户列表</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="${ctx }/user/add">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>添加用户</cite>
                        </a>
                    </li>

                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="layui-icon">&#xe631;</i>
                    <cite>设备管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="${ctx }/device/list">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>设备列表</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="${ctx }/device/add">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>添加设备</cite>
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="layui-icon">&#xe60a;</i>
                    <cite>低值耗材管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="${ctx }/lpa/list">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>低值耗材列表</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="${ctx }/lpa/add">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>添加低值耗材</cite>
                        </a>
                    </li>
                </ul>
            </li>

            <li>
                <a href="javascript:;">
                    <i class="layui-icon">&#xe62d;</i>
                    <cite>购买申请</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="${ctx}/afp/list">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>购买申请列表</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="${ctx}/afp/add">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>添加购买申请</cite>
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="layui-icon">&#xe62d;</i>
                    <cite>设备借用申请</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="${ctx}/afb/list">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>借用申请列表</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="${ctx}/afb/add">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>添加借用申请</cite>
                        </a>
                    </li>


                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="layui-icon">&#xe62d;</i>
                    <cite>低值耗材领用</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="${ctx }/aflpa/list">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>领用申请列表</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="${ctx }/aflpa/add">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>添加领用申请</cite>
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</div>

<!-- 左侧菜单结束 -->
<!-- 右侧主体开始 -->
<div class="page-content">
    <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
        <ul class="layui-tab-title">
            <li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
        </ul>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='${ctx}/welcome' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
        </div>
    </div>
</div>
<div class="page-content-bg"></div>
<!-- 右侧主体结束 -->
<!-- 中部结束 -->
<!-- 底部开始 -->
<div class="footer">
    <div class="copyright">实验室设备管理系统 @2021 v1.0.0</div>
</div>
<!-- 底部结束 -->

</body>
<script>
    function userInfo(url) {
        layer.open({
            title: '个人信息'
            , type: 2
            , content: url
            , area: ['500px', '313px']
            , btn: ['返回']
            , btn1: function (index, layero) {
                layer.close(layer.index);
            }
        })
    }
</script>
</html>