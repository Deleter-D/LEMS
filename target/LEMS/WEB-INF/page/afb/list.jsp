<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>公告信息</title>
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
</head>

<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a>
          <cite>借用申请列表</cite></a>
      </span>
    <button type="button" onclick="location.href='${ctx}/afb/add'" class="layui-btn layui-btn-small"
            style="line-height:1.6em;margin-top:3px;float:innert;margin-left:75%;;"><i class="layui-icon"></i>增加
    </button>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="${ctx }/afb/list"
       title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row" style="" align="center">
        <form class="layui-form layui-col-md12 x-so" method="get" action="${ctx }/afb/list">
            <!-- <input class="layui-input" placeholder="开始日" name="start" id="start">
            <input class="layui-input" placeholder="截止日" name="end" id="end"> -->
            <input type="text" name="content" style="width:50%;" placeholder="请输入查找内容" autocomplete="off"
                   class="layui-input">
            <button class="layui-btn" lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>

    <table class="layui-table">
        <thead>
        <tr>
            <th>ID</th>
            <th>名称</th>
            <th>数量</th>
            <th>借出日期</th>
            <th>归还日期</th>
            <th>用途</th>
            <th>姓名</th>
            <th>电话</th>
            <th>学院</th>
            <th>状态</th>
            <th>处理</th>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.afbList}" var="afb" varStatus="stat">
            <tr>
                <td>${afb.afb_ID}</td>
                <td>${afb.device.d_name}</td>
                <td>${afb.afb_number}</td>
                <td>
                    <fmt:formatDate value="${afb.afb_bDate}" pattern="yyyy-MM-dd"/>
                </td>
                <td>
                    <fmt:formatDate value="${afb.afb_rDate}" pattern="yyyy-MM-dd"/>
                </td>
                <td>${afb.afb_usefor}</td>
                <td>${afb.afb_bName}</td>
                <td>${afb.afb_bTele}</td>
                <td>${afb.faculty.f_name}</td>
                <td>
                    <c:if test="${afb.afb_isPermited=='0'}">未处理</c:if>
                    <c:if test="${afb.afb_isPermited=='1'}">已批准</c:if>
                    <c:if test="${afb.afb_isPermited=='-1'}">已驳回</c:if>
                </td>
                <td class="td-manage">
                    <a title="批准" href="${ctx}/afb/permit?id=${afb.afb_ID}">
                        <i class="layui-icon">&#xe605;</i>
                    </a>
                    <a title="驳回" href="${ctx}/afb/dispermit?id=${afb.afb_ID}">
                        <i class="layui-icon">&#x1006;</i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<script>
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

</script>

</body>

</html>