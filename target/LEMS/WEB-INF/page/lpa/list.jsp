<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>低值耗材列表</title>
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
          <cite>耗材信息</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="${ctx }/lpa/list"
       title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row" style="" align="center">
        <form class="layui-form layui-col-md12 x-so" method="get" action="${ctx }/lpa/list">
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
            <th>价格</th>
            <th>数量</th>
            <th>购置日期</th>
            <th>制造商</th>
            <th>保质期</th>
            <th>管理员</th>
            <th>处理</th>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.lpaList}" var="lpa" varStatus="stat">
            <tr>
                <td>${lpa.lpa_ID}</td>
                <td>${lpa.lpa_name}</td>
                <td>${lpa.lpa_price}</td>
                <td>${lpa.lpa_number}</td>
                <td><fmt:formatDate value="${lpa.lpa_dateForP}" pattern="yyyy-MM-dd"/></td>
                <td>${lpa.lpa_manufacturer}</td>
                <td>${lpa.lpa_shelfLife}</td>
                <td>${lpa.admin.u_name}</td>
                <td class="td-manage">
                    <a title="编辑" href="${ctx}/lpa/add?id=${lpa.lpa_ID}">
                        <i class="layui-icon">&#xe642;</i>
                    </a>
                    <a title="删除" onclick="member_del(this,'${lpa.lpa_ID}')" href="javascript:;">
                        <i class="layui-icon">&#xe640;</i>
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

    function member_del(obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            $.get("${ctx}/lpa/delete?id=" + id);
            $(obj).parents("tr").remove();
            layer.msg('已删除!', {icon: 1, time: 1000});
        });
    }

</script>
</body>

</html>