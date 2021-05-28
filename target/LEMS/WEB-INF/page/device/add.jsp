<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>添加设备</title>
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
    <form class="layui-form" method="POST" id="deviceAdd" action="${ctx}/device/divicesubmit">
        <c:if test="${not empty requestScope.editDevice.d_ID}">
            <input type="hidden" name="d_ID" id="d_ID" value="${requestScope.editDevice.d_ID}">
        </c:if>
        <div class="layui-form-item">
            <label for="deviceAdd" class="layui-form-label">
                <span class="x-red">*</span>名称
            </label>
            <div class="layui-input-inline">
                <input type="text" id="d_name" name="d_name" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${requestScope.editDevice.d_name}">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="deviceAdd" class="layui-form-label">
                <span class="x-red">*</span>价格
            </label>
            <div class="layui-input-inline">
                <input type="text" id="d_price" name="d_price" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${requestScope.editDevice.d_price}">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="deviceAdd" class="layui-form-label">
                <span class="x-red">*</span>数量
            </label>
            <div class="layui-input-inline">
                <input type="text" id="d_number" name="d_number" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${requestScope.editDevice.d_number}">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="deviceAdd" class="layui-form-label">
                <span class="x-red">*</span>购置日期
            </label>
            <div class="layui-input-inline">
                <input type="text" id="d_dateForP" name="d_dateForP" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${requestScope.editDevice.d_dateForP}">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="deviceAdd" class="layui-form-label">
                <span class="x-red">*</span>制造商
            </label>
            <div class="layui-input-inline">
                <input type="text" id="d_manufacturer" name="d_manufacturer" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${requestScope.editDevice.d_manufacturer}">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="deviceAdd" class="layui-form-label">
                <span class="x-red">*</span>保质期
            </label>
            <div class="layui-input-inline">
                <input type="text" id="d_shelfLife" name="d_shelfLife" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${requestScope.editDevice.d_shelfLife}">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="deviceAdd" class="layui-form-label">
                <span class="x-red">*</span>管理员
            </label>
            <div class="layui-input-inline">
                <select id="d_adminID" name="d_adminID">
                    <option value=""></option>
                    <c:forEach items="${requestScope.adminList}" var="admin" varStatus="stat">
                        <option
                                <c:if test="${requestScope.editDevice.d_adminID==admin.u_ID}">selected</c:if>
                                value="${admin.u_ID}">${admin.u_name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="deviceAdd" class="layui-form-label">
                <span class="x-red">*</span>学院
            </label>
            <%--<div class="layui-input-inline">
                <input type="text" id="faculty" name="faculty" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${job.password }">
            </div>--%>
            <div class="layui-input-inline">
                <select id="d_facultyID" name="d_facultyID">
                    <option value=""></option>
                    <option <c:if test="${requestScope.editDevice.d_facultyID==1}"> selected </c:if> value="1">数学与计算机学院
                    </option>
                    <option <c:if test="${requestScope.editDevice.d_facultyID==2}"> selected </c:if> value="2">电气与工程学院
                    </option>
                    <option <c:if test="${requestScope.editDevice.d_facultyID==3}"> selected </c:if> value="3">机械工程学院
                    </option>
                    <option <c:if test="${requestScope.editDevice.d_facultyID==4}"> selected </c:if> value="4">经济与管理学院
                    </option>
                    <option <c:if test="${requestScope.editDevice.d_facultyID==5}"> selected </c:if> value="5">外国语学院
                    </option>
                    <option <c:if test="${requestScope.editDevice.d_facultyID==6}"> selected </c:if> value="6">艺术与传媒学院
                    </option>
                </select>
            </div>
        </div>
        <input type="hidden" id="d_isBorrowed" name="d_isBorrowed" value="0">
        <div class="layui-form-item">
            <label for="deviceAdd" class="layui-form-label"></label>
            <input type="submit" value=" 提交" class="layui-btn" lay-filter="add" lay-submit/>
        </div>
    </form>
</div>
<script>
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        laydate.render({
            elem: '#d_dateForP'
        });
    });
    layui.use(['form', 'layer'], function () {
        $ = layui.jquery;
        var form = layui.form
            , layer = layui.layer;

        //自定义验证规则
        /*form.verify({
            nikename: function (value) {
                if (value.length < 5) {
                    return '昵称至少得5个字符啊';
                }
            }
            , pass: [/(.+){6,12}$/, '密码必须6到12位']
            , repass: function (value) {
                if ($('#L_pass').val() != $('#L_repass').val()) {
                    return '两次密码不一致';
                }
            }
        });*/

        //监听提交
        form.on('submit(add)', function (data) {

            console.log(JSON.stringify(data.field));
            //发异步，把数据提交给php
            layer.alert("增加成功", {icon: 6}, function () {
                document.getElementById('deviceAdd').submit();
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