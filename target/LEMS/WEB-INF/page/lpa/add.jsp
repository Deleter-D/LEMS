<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="${ctx}/public/css/font.css">
    <link rel="stylesheet" href="${ctx}/public/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/public/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/public/js/xadmin.js"></script>
</head>

<body>
<div class="x-body">
    <form class="layui-form" method="POST" id="lpaadd" action="${ctx}/lpa/lpasubmit">
        <c:if test="${not empty requestScope.editLPA.lpa_ID}">
            <input type="hidden" name="lpa_ID" id="lpa_ID" value="${requestScope.editLPA.lpa_ID}">
        </c:if>
        <div class="layui-form-item">
            <label for="lpaadd" class="layui-form-label">
                <span class="x-red">*</span>名称
            </label>
            <div class="layui-input-inline">
                <input type="text" id="lpa_name" name="lpa_name" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${requestScope.editLPA.lpa_name}">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="lpaadd" class="layui-form-label">
                <span class="x-red">*</span>价格
            </label>
            <div class="layui-input-inline">
                <input type="text" id="lpa_price" name="lpa_price" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${requestScope.editLPA.lpa_price}">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="lpaadd" class="layui-form-label">
                <span class="x-red">*</span>数量
            </label>
            <div class="layui-input-inline">
                <input type="text" id="lpa_number" name="lpa_number" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${requestScope.editLPA.lpa_number}">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="lpaadd" class="layui-form-label">
                <span class="x-red">*</span>购置日期
            </label>
            <div class="layui-input-inline">
                <c:if test="${not empty requestScope.editLPA.lpa_ID}">
                    <fmt:formatDate value="${requestScope.editLPA.lpa_dateForP}" pattern="yyyy-MM-dd"
                                    var="lpa_dateForPFormated"/>
                </c:if>
                <input type="text" id="lpa_dateForP" name="lpa_dateForP" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${lpa_dateForPFormated}">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="lpaadd" class="layui-form-label">
                <span class="x-red">*</span>制造商
            </label>
            <div class="layui-input-inline">
                <input type="text" id="lpa_manufacturer" name="lpa_manufacturer" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${requestScope.editLPA.lpa_manufacturer}">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="lpaadd" class="layui-form-label">
                <span class="x-red">*</span>保质期
            </label>
            <div class="layui-input-inline">
                <input type="text" id="lpa_shelfLife" name="lpa_shelfLife" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${requestScope.editLPA.lpa_shelfLife}">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="lpaadd" class="layui-form-label">
                <span class="x-red">*</span>管理员
            </label>
            <div class="layui-input-inline">
                <select id="lpa_adminID" name="lpa_adminID">
                    <option value=""></option>
                    <c:forEach items="${requestScope.adminList}" var="admin" varStatus="stat">
                        <option
                                <c:if test="${requestScope.editLPA.lpa_adminID==admin.u_ID}">selected</c:if>
                                value="${admin.u_ID}">${admin.u_name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="lpaadd" class="layui-form-label">
            </label>
            <input type="submit" value=" 提交" class="layui-btn" lay-filter="add" lay-submit=""/>

        </div>
    </form>
</div>
<script>
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        laydate.render({
            elem: '#lpa_dateForP'
        });
    });
    layui.use(['form', 'layer'], function () {
        $ = layui.jquery;
        var form = layui.form
            , layer = layui.layer;

        //监听提交
        form.on('submit(add)', function (data) {

            console.log(JSON.stringify(data.field));
            //发异步，把数据提交给php
            layer.alert("增加成功", {icon: 6}, function () {
                document.getElementById('lpaadd').submit();
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);

            });
            return false;
        });


    });
</script>

</body>

</html>