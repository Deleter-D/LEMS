<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>用户列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="shortcut icon" href="${ctx}/public/logo.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="${ctx}/public/css/font.css">
    <link rel="stylesheet" href="${ctx}/public/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/public/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/public/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a>
          <cite>用户信息</cite></a>
      </span>
    <button type="button" onclick="location.href='${ctx}/user/add'" class="layui-btn layui-btn-small"
            style="line-height:1.6em;margin-top:3px;float:innert;margin-left:75%;;"><i class="layui-icon"></i>增加
    </button>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="${ctx}/user/list"
       title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <form class="layui-form" method="post" action="/user/quary">
        <div class="layui-row">
            <div class="layui-col-md2 layui-col-md-offset2">
                <select name="quaryFlag" id="quaryFlag">
                    <option value=""></option>
                    <option <c:if test="${requestScope.quaryFlag=='1'}"> selected </c:if> value="1">姓名查找</option>
                    <option <c:if test="${requestScope.quaryFlag=='2'}"> selected </c:if> value="2">学号查找</option>
                </select>
            </div>
            <div class="layui-col-md5">
                <input type="text" id="content" name="content" style="width:100%;" placeholder="请输入查找内容"
                       autocomplete="off"
                       class="layui-input" value="${requestScope.content}">
            </div>
            <div class="layui-col-md1">
                <input type="submit" value="搜索" class="layui-btn" lay-submit lay-filter="quary">
            </div>
        </div>
    </form>
    <table class="layui-table">
        <thead>
        <tr>
            <th>ID</th>
            <th>账号</th>
            <th>姓名</th>
            <th>电话</th>
            <th>学院</th>
            <th>权限</th>
            <th>处理</th>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.userlist}" var="user" varStatus="stat">
            <tr>
                <td>${user.u_ID}</td>
                <td>${user.u_account}</td>
                <td>${user.u_name}</td>
                <td>${user.u_tele}</td>
                <td>${user.faculty.f_name}</td>
                <td>
                    <c:if test="${user.u_identity=='0'}">
                        普通用户
                    </c:if>
                    <c:if test="${user.u_identity=='1'}">
                        管理员
                    </c:if>
                </td>
                <td class="td-manage">
                    <a title="编辑" href="${ctx}/user/add?id=${user.u_ID}">
                        <i class="layui-icon">&#xe642;</i>
                    </a>
                    <a title="删除" onclick="member_del(this,'${user.u_ID}')" href="javascript:;">
                        <i class="layui-icon">&#xe640;</i>
                    </a>
                </td>
            </tr>
        </c:forEach>


        </tbody>
    </table>

</div>
<script>
    layui.use('form', function () {
        var form = layui.form();
    });
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });
    });

    function member_del(obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            //发异步删除数据
            //等以后再使用异步，这里先使用
            $.get("${ctx}/user/deleteuser?id=" + id);
            $(obj).parents("tr").remove();
            layer.msg('已删除!', {icon: 1, time: 1000});
        });
    }

</script>
<script>
    var _hmt = _hmt || [];
    (function () {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
</body>

</html>