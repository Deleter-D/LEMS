<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="shortcut icon" href="${ctx}/public/logo.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="${ctx}/public/css/font.css">
    <link rel="stylesheet" href="${ctx}/public/css/xadmin.css">
</head>
<body>
<div class="x-body layui-anim layui-anim-up">
    <blockquote class="layui-elem-quote">欢迎：
        <span class="x-red">${sessionScope.user.u_name}</span>！当前时间:${sessionScope.currentTime}
    </blockquote>
    <fieldset class="layui-elem-field">
        <legend>系统通知</legend>
        <div class="layui-field-box">
            <table class="layui-table" lay-skin="line">
                <tbody>
                <tr>
                    <td>欢迎进入实验室设备管理系统</td>
                </tr>
                <tr>
                    <td>请遵守实验室安全规章制度，安全实验，快乐学习</td>
                </tr>
                </tbody>
            </table>
        </div>
    </fieldset>
    <fieldset class="layui-elem-field">
        <legend>系统信息</legend>
        <div class="layui-field-box">
            <table class="layui-table">
                <tbody>
                <tr>
                    <th>系统版本</th>
                    <td>1.0.0</td>
                </tr>
                <tr>
                    <th>服务器状态</th>
                    <td>正常</td>
                </tr>
                <tr>
                    <th>操作系统</th>
                    <td>Windows 10</td>
                </tr>
                <tr>
                    <th>运行环境</th>
                    <td>Tomcat 9.0.40</td>
                </tr>
                <tr>
                    <th>MYSQL版本</th>
                    <td>8.0.22</td>
                </tr>
                </tbody>
            </table>
        </div>
    </fieldset>
    <fieldset class="layui-elem-field">
        <legend>开发团队</legend>
        <div class="layui-field-box">
            <table class="layui-table">
                <tbody>
                <tr>
                    <th>版权所有</th>
                    <td>王彦澎
                        <a href="https://github.com/Deleter-D/LEMS" class='x-a' target="_blank">访问项目github</a></td>
                </tr>
                <tr>
                    <th>开发者</th>
                    <td>王彦澎(QQ:867909454)</td>
                </tr>
                </tbody>
            </table>
        </div>
    </fieldset>
    <blockquote class="layui-elem-quote layui-quote-nm">本系统由layui,Spring,Mybatis提供技术支持</blockquote>
</div>
</body>
</html>