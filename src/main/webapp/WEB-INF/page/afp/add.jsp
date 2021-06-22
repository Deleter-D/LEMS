<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>添加购买申请</title>
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
    <form class="layui-form" method="POST" id="AFPAdd" action="${ctx}/afp/afpsubmit">
        <c:if test="${not empty requestScope.editAFP.afp_ID}">
            <input type="hidden" name="afp_ID" id="afp_ID" value="${job.id }">
        </c:if>
        <div class="layui-form-item">
            <label for="AFPAdd" class="layui-form-label">
                <span class="x-red">*</span>名称
            </label>
            <div class="layui-input-inline">
                <input type="text" id="afp_name" name="afp_name" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${job.name }">
            </div>

        </div>
        <div class="layui-form-item">
            <label for="AFPAdd" class="layui-form-label">
                <span class="x-red">*</span>价格
            </label>
            <div class="layui-input-inline">
                <input type="text" id="afp_price" name="afp_price" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${job.card_id }">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="AFPAdd" class="layui-form-label">
                <span class="x-red">*</span>数量
            </label>
            <div class="layui-input-inline">
                <input type="text" id="afp_number" name="afp_number" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${job.sex }">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="AFPAdd" class="layui-form-label">
                <span class="x-red">*</span>购置日期
            </label>
            <div class="layui-input-inline">
                <input type="text" id="afp_dateForP" name="afp_dateForP" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${job.education }">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="AFPAdd" class="layui-form-label">
                <span class="x-red">*</span>制造商
            </label>
            <div class="layui-input-inline">
                <input type="text" id="afp_manufacturer" name="afp_manufacturer" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${job.email }">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="AFPAdd" class="layui-form-label">
                <span class="x-red">*</span>保质期
            </label>
            <div class="layui-input-inline">
                <input type="text" id="afp_shelfLife" name="afp_shelfLife" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${job.phone }">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="AFPAdd" class="layui-form-label">
                <span class="x-red">*</span>管理员
            </label>
            <div class="layui-input-inline">
                <select id="afp_adminID" name="afp_adminID">
                    <option value=""></option>
                    <c:forEach items="${requestScope.adminList}" var="admin" varStatus="stat">
                        <option
                                <c:if test="${requestScope.editAFP.afp_adminID==admin.u_ID}">selected</c:if>
                                value="${admin.u_ID}">${admin.u_name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="AFPAdd" class="layui-form-label">
                <span class="x-red">*</span>学院
            </label>
            <div class="layui-input-inline">
                <select id="afp_facultyID" name="afp_facultyID" class="valid">
                    <option value=""></option>
                    <c:forEach items="${requestScope.facultyList}" var="faculty" varStatus="stat">
                        <option value="${faculty.f_ID}"
                                <c:if test="${requestScope.editAFP.afp_facultyID== faculty.f_ID}">selected</c:if>>${faculty.f_name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="AFPAdd" class="layui-form-label">
            </label>
            <input type="submit" value=" 提交" class="layui-btn" lay-filter="add" lay-submit=""/>

        </div>
    </form>
</div>
<script>
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        laydate.render({
            elem: '#afp_dateForP'
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
                document.getElementById('AFPAdd').submit();
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