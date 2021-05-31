<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>设备借用申请</title>
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
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="x-body">
    <form class="layui-form" method="POST" id="AFBAdd" action="${ctx}/afb/afbSubmit">
        <c:if test="${not empty requestScope.editAFB.afb_ID}">
            <input type="hidden" name="id" id="id" value="${editAFB.afb_ID}">
        </c:if>
        <div class="layui-form-item">
            <label for="AFBAdd" class="layui-form-label">
                <span class="x-red">*</span>名称
            </label>
            <div class="layui-input-inline">
                <select name="afb_deviceID" id="afb_deviceID">
                    <option value=""></option>
                    <c:forEach items="${requestScope.deviceList}" var="device" varStatus="stat">
                        <option
                                <c:if test="${requestScope.editAFB.afb_deviceID==device.d_ID}">selected</c:if>
                                value="${device.d_ID}">${device.d_name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="AFBAdd" class="layui-form-label">
                <span class="x-red">*</span>数量
            </label>
            <div class="layui-input-inline">
                <input type="text" id="afb_number" name="afb_number" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${job.title }">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="AFBAdd" class="layui-form-label">
                <span class="x-red">*</span>借出日期
            </label>
            <div class="layui-input-inline">
                <input type="text" id="afb_bDate" name="afb_bDate" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${job.title }">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="AFBAdd" class="layui-form-label">
                <span class="x-red">*</span>归还日期
            </label>
            <div class="layui-input-inline">
                <input type="text" id="afb_rDate" name="afb_rDate" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${job.title }">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="AFBAdd" class="layui-form-label">
                <span class="x-red">*</span>用途
            </label>
            <div class="layui-input-inline">
                <input type="text" id="afb_usefor" name="afb_usefor" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${job.title }">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="AFBAdd" class="layui-form-label">
                <span class="x-red">*</span>姓名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="afb_bName" name="afb_bName" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${job.title }">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="AFBAdd" class="layui-form-label">
                <span class="x-red">*</span>电话
            </label>
            <div class="layui-input-inline">
                <input type="text" id="afb_bTele" name="afb_bTele" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${job.title }">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="AFBAdd" class="layui-form-label">
                <span class="x-red">*</span>学院
            </label>
            <div class="layui-input-inline">
                <select name="afb_facultyID" id="afb_facultyID">
                    <option value=""></option>
                    <c:forEach items="${requestScope.facultyList}" var="faculty" varStatus="stat">
                        <option
                                <c:if test="${requestScope.editAFB.afb_facultyID==faculty.f_ID}">selected</c:if>
                                value="${faculty.f_ID}">${faculty.f_name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <input type="hidden" id="afb_isPermited" name="afb_isPermited" value="0">
        <div class="layui-form-item">
            <label for="AFBAdd" class="layui-form-label">
            </label>
            <input type="submit" value=" 提交" class="layui-btn" lay-filter="add" lay-submit=""/>

        </div>
    </form>
</div>
<script>
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        laydate.render({
            elem: '#afb_bDate'
        });
    });
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        laydate.render({
            elem: '#afb_rDate'
        });
    });
    layui.use(['form', 'layer'], function () {
        $ = layui.jquery;
        var form = layui.form
            , layer = layui.layer;

        //自定义验证规则
        form.verify({
            /*nikename: function (value) {
                if (value.length < 5) {
                    return '昵称至少得5个字符啊';
                }
            }
            , pass: [/(.+){6,12}$/, '密码必须6到12位']
            , repass: function (value) {
                if ($('#L_pass').val() != $('#L_repass').val()) {
                    return '两次密码不一致';
                }
            }*/
        });

        //监听提交
        form.on('submit(add)', function (data) {

            console.log(JSON.stringify(data.field));
            //发异步，把数据提交给php
            layer.alert("增加成功", {icon: 6}, function () {
                document.getElementById('AFBAdd').submit();
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