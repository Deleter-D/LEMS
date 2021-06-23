<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>文档信息</title>
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
          <cite>领用申请列表</cite></a>
      </span>
    <button class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:innert;margin-left:75%;;"
            lay-submit="" lay-filter="sreach"><i class="layui-icon"></i>增加
    </button>

    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="${ctx }/aflpa/list" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <form class="layui-form" method="post" action="/aflpa/quary">
        <div class="layui-row">
            <div class="layui-col-md2 layui-col-md-offset9">
                <select name="facultyID" id="facultyID">
                    <option value=""></option>
                    <c:forEach items="${requestScope.facultyList}" var="faculty">
                        <option <c:if test="${requestScope.facultyID==faculty.f_ID}"> selected </c:if>
                                value="${faculty.f_ID}">${faculty.f_name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="layui-col-md1">
                <input type="submit" value="筛选" class="layui-btn" lay-submit lay-filter="quary">
            </div>
        </div>
    </form>
    <table class="layui-table">
        <thead>
        <tr>
            <th>ID</th>
            <th>名称</th>
            <th>数量</th>
            <th>申领日期</th>
            <th>用途</th>
            <th>姓名</th>
            <th>电话</th>
            <th>学院</th>
            <th>状态</th>
            <th>处理</th>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.aflpaList}" var="aflpa" varStatus="stat">
            <tr>
                <td>${aflpa.aflpa_ID}</td>
                <td>${aflpa.lpa.lpa_name}</td>
                <td>${aflpa.aflpa_number}</td>
                <td>
                    <fmt:formatDate value="${aflpa.aflpa_bDate}" pattern="yyyy-MM-dd"/>
                </td>
                <td>${aflpa.aflpa_useFor}</td>
                <td>${aflpa.aflpa_bName}</td>
                <td>${aflpa.aflpa_bTele}</td>
                <td>${aflpa.faculty.f_name}</td>
                <td>
                    <c:if test="${aflpa.aflpa_isPermited=='0'}">未处理</c:if>
                    <c:if test="${aflpa.aflpa_isPermited=='1'}">已批准</c:if>
                    <c:if test="${aflpa.aflpa_isPermited=='-1'}">已驳回</c:if>
                </td>
                <td class="td-manage">
                    <a title="批准" href="${ctx}/aflpa/permit?id=${aflpa.aflpa_ID}">
                        <i class="layui-icon">&#xe605;</i>
                    </a>
                    <a title="驳回" href="${ctx}/aflpa/dispermit?id=${aflpa.aflpa_ID}">
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