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
    <form class="layui-form" method="POST" id="aflpaAdd" action="${ctx}/aflpa/aflpasubmit">
        <input type="hidden" name="id" id="id" value="${job.id }">
        <div class="layui-form-item">
            <label for="aflpaAdd" class="layui-form-label">
                <span class="x-red">*</span>耗材名称
            </label>
            <div class="layui-input-inline">
                <select name="aflpa_lpaID" id="aflpa_lpaID">
                    <option value=""></option>
                    <c:forEach items="${requestScope.LPAList}" var="lpa" varStatus="stat">
                        <option value="${lpa.lpa_ID}">${lpa.lpa_name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="aflpaAdd" class="layui-form-label">
                <span class="x-red">*</span>数量
            </label>
            <div class="layui-input-inline">
                <input type="text" id="aflpa_number" name="aflpa_number" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${job.remark }">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="aflpaAdd" class="layui-form-label">
                <span class="x-red">*</span>申请日期
            </label>
            <div class="layui-input-inline">
                <input type="text" id="aflpa_bDate" name="aflpa_bDate" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${job.remark }">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="aflpaAdd" class="layui-form-label">
                <span class="x-red">*</span>用途
            </label>
            <div class="layui-input-inline">
                <input type="text" id="aflpa_useFor" name="aflpa_useFor" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${job.remark }">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="aflpaAdd" class="layui-form-label">
                <span class="x-red">*</span>姓名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="aflpa_bName" name="aflpa_bName" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${job.remark }">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="aflpaAdd" class="layui-form-label">
                <span class="x-red">*</span>电话
            </label>
            <div class="layui-input-inline">
                <input type="text" id="aflpa_bTele" name="aflpa_bTele" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${job.remark }">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="aflpaAdd" class="layui-form-label">
                <span class="x-red">*</span>学院
            </label>
            <div class="layui-input-inline">
                <select name="aflpa_facultyID" id="aflpa_facultyID">
                    <option value=""></option>
                    <c:forEach items="${requestScope.facultyList}" var="faculty" varStatus="stat">
                        <option value="${faculty.f_ID}">${faculty.f_name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <input type="hidden" name="aflpa_isPermited" id="aflpa_isPermited" value="0">
        <div class="layui-form-item">
            <label for="aflpaAdd" class="layui-form-label">
            </label>
            <input type="submit" value=" 提交" class="layui-btn" lay-filter="add" lay-submit=""/>

        </div>
    </form>
</div>
<script>
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        laydate.render({
            elem: '#aflpa_bDate'
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
                document.getElementById('aflpaAdd').submit();
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