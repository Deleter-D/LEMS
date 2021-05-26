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
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="x-body">
    <form class="layui-form" method="POST" id="userAdd" action="${ctx}/user/usersubmit">
        <input type="hidden" name="u_ID" id="u_ID" value="${requestScope.editUser.u_ID}">
        <div class="layui-form-item">
            <label for="userAdd" class="layui-form-label">
                <span class="x-red">*</span>学工号
            </label>
            <div class="layui-input-inline">
                <input type="text" id="u_account" name="u_account" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${requestScope.editUser.u_account}">
            </div>

        </div>
        <div class="layui-form-item">
            <label for="userAdd" class="layui-form-label">
                <span class="x-red">*</span>密码
            </label>
            <div class="layui-input-inline">
                <input type="password" id="u_password" name="u_password" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${requestScope.editUser.u_password}">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="userAdd" class="layui-form-label">
                <span class="x-red">*</span>重复密码
            </label>
            <div class="layui-input-inline">
                <input type="password" id="repassword" name="repassword" required="" lay-verify="required|repass"
                       autocomplete="off" class="layui-input" value="${requestScope.editUser.u_password}">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="userAdd" class="layui-form-label">
                <span class="x-red">*</span>姓名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="u_name" name="u_name" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${requestScope.editUser.u_name}">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="userAdd" class="layui-form-label">
                <span class="x-red">*</span>电话
            </label>
            <div class="layui-input-inline">
                <input type="text" id="u_tele" name="u_tele" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${requestScope.editUser.u_tele}">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="userAdd" class="layui-form-label">
                <span class="x-red">*</span>学院
            </label>
            <%--<div class="layui-input-inline">
                <input type="text" id="faculty" name="faculty" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${job.password }">
            </div>--%>
            <div class="layui-input-inline">
                <select id="u_facultyID" name="u_facultyID">
                    <option value=""></option>
                    <option <c:if test="${requestScope.editUser.u_facultyID==1}"> selected </c:if> value="1">数学与计算机学院
                    </option>
                    <option <c:if test="${requestScope.editUser.u_facultyID==2}"> selected </c:if> value="2">电气与工程学院
                    </option>
                    <option <c:if test="${requestScope.editUser.u_facultyID==3}"> selected </c:if> value="3">机械工程学院
                    </option>
                    <option <c:if test="${requestScope.editUser.u_facultyID==4}"> selected </c:if> value="4">经济与管理学院
                    </option>
                    <option <c:if test="${requestScope.editUser.u_facultyID==5}"> selected </c:if> value="5">外国语学院
                    </option>
                    <option <c:if test="${requestScope.editUser.u_facultyID==6}"> selected </c:if> value="6">艺术与传媒学院
                    </option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="userAdd" class="layui-form-label">
                <span class="x-red">*</span>用户权限
            </label>
            <div class="layui-input-inline">
                <select id="u_identity" name="u_identity">
                    <option value=""></option>
                    <option <c:if test="${requestScope.editUser.u_identity==0}"> selected </c:if>value="0">普通用户</option>
                    <option <c:if test="${requestScope.editUser.u_identity==1}"> selected </c:if>value="1">管理员</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="userAdd" class="layui-form-label">
            </label>
            <input type="submit" value=" 提交" class="layui-btn" lay-filter="add" lay-submit/>
        </div>
        <%--<div class="layui-form-item">
            <div class="layui-input-block">
                <button id="submit" class="layui-btn" lay-submit lay-filter="add">提交</button>
            </div>
        </div>--%>
    </form>
</div>
<script>
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
            },
            pass: [/(.+){6,12}$/, '密码必须6到12位'],*/
            repass: function (value) {
                if ($('#u_password').val() !== $('#repassword').val()) {
                    return '两次密码不一致';
                }
            }
        });

        //监听提交
        form.on('submit(add)', function (data) {

            // layer.msg(JSON.stringify(data.field));
            console.log(JSON.stringify(data.field));
            //发异步，把数据提交给php
            layer.alert("增加成功", {icon: 6}, function () {
                document.getElementById('userAdd').submit();
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