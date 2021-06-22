<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人信息</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>

    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="${ctx}/public/css/font.css">
    <link rel="stylesheet" href="${ctx}/public/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="${ctx}/public/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/public/js/xadmin.js"></script>

</head>
<body class="login-bg">
<table class="layui-table" lay-even>
    <tbody>
    <tr>
        <td>用户姓名</td>
        <td>${sessionScope.user.u_name}</td>
    </tr>
    <tr>
        <td>个人账号</td>
        <td>${sessionScope.user.u_account}</td>
    </tr>
    <tr>
        <td>联系方式</td>
        <td>${sessionScope.user.u_tele}</td>
    </tr>
    <tr>
        <td>学院</td>
        <td>${sessionScope.user.faculty.f_name}</td>
    </tr>
    <tr>
        <td>权限</td>
        <td>
            <c:if test="${sessionScope.user.u_identity=='0'}">普通用户</c:if>
            <c:if test="${sessionScope.user.u_identity=='1'}">管理员</c:if>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>