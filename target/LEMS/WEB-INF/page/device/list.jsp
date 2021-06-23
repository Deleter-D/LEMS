<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>设备信息</title>
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
          <cite>设备列表</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="${ctx}/device/list" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <form class="layui-form" method="post" action="/device/quary">
        <div class="layui-row">
            <div class="layui-col-md5 layui-col-md-offset3">
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
            <th>名称</th>
            <th>价格</th>
            <th>数量</th>
            <th>购置日期</th>
            <th>制造商</th>
            <th>保质期</th>
            <th>管理员</th>
            <th>学院</th>
            <th>借还状态</th>
            <th>处理</th>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.devicelist}" var="device" varStatus="stat">
            <tr>
                <td>${device.d_ID}</td>
                <td>${device.d_name}</td>
                <td>${device.d_price}</td>
                <td>${device.d_number}</td>
                <td><fmt:formatDate value="${device.d_dateForP}" pattern="yyyy-MM-dd"/></td>
                <td>${device.d_manufacturer}</td>
                <td>${device.d_shelfLife}</td>
                <td>${device.admin.u_name}</td>
                <td>${device.faculty.f_name}</td>
                <td>
                    <c:if test="${device.d_isBorrowed==0}">未借出</c:if>
                    <c:if test="${device.d_isBorrowed==1}">已借出</c:if>
                </td>
                <td class="td-manage">
                    <a title="编辑" onclick="x_admin_show('编辑','${ctx}/device/add?id=${device.d_ID}');"
                       href="javascript:;">
                        <i class="layui-icon">&#xe642;</i>
                    </a>
                    <a title="删除" onclick="member_del(this,'${device.d_ID}')" href="javascript:;">
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

    /*用户-删除*/
    function member_del(obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            //发异步删除数据
            //等以后再使用异步，这里先使用
            $.get("${ctx}/device/deletedevice?id=" + id);
            $(obj).parents("tr").remove();
            layer.msg('已删除!', {icon: 1, time: 1000});
        });
    }

</script>

</body>

</html>