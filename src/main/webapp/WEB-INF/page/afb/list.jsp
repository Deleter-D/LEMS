<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
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
    <%-- <xblock>
<!--        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button> -->
      <button class="layui-btn" onclick="x_admin_show('添加用户','${ctx}/dept/add')"><i class="layui-icon"></i>添加</button>
      <span class="x-right" style="line-height:40px">共有数据：88 条</span>
    </xblock> --%>


    <table class="layui-table">
        <thead>
        <tr>
            <%--<th>
              <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>--%>
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
                    <%--<td>
                      <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div>
                    </td>--%>
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
                    <a title="编辑" href="${ctx}/afb/add?id=${dept.id }">
                        <i class="layui-icon">&#xe642;</i>
                    </a>
                    <a title="删除" onclick="member_del(this,'${dept.id }')" href="javascript:;">
                        <i class="layui-icon">&#xe640;</i>
                    </a>
                </td>
            </tr>

        </c:forEach>


        </tbody>
    </table>
    <%--<div class="page">
        <div>
            <a class="prev" href="">&lt;&lt;</a>
            <a class="num" href="">1</a>
            <span class="current">2</span>
            <a class="num" href="">3</a>
            <a class="num" href="">489</a>
            <a class="next" href="">&gt;&gt;</a>
        </div>
    </div>--%>

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

    /*用户-停用*/
    /*function member_stop(obj, id) {
        layer.confirm('确认要停用吗？', function (index) {

            if ($(obj).attr('title') == '启用') {

                //发异步把用户状态进行更改
                $(obj).attr('title', '停用')
                $(obj).find('i').html('&#xe62f;');

                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                layer.msg('已停用!', {icon: 5, time: 1000});

            } else {
                $(obj).attr('title', '启用')
                $(obj).find('i').html('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已启用!', {icon: 5, time: 1000});
            }

        });
    }*/

    /*用户-删除*/
    /*function member_del(obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            //发异步删除数据
            //等以后再使用异步，这里先使用
            $.get("${ctx}/notice/delete?id=" + id);
            $(obj).parents("tr").remove();
            layer.msg('已删除!', {icon: 1, time: 1000});
        });
    }*/


    /*function delAll(argument) {

        var data = tableCheck.getData();

        layer.confirm('确认要删除吗？' + data, function (index) {
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
        });
    }*/
</script>
<script>var _hmt = _hmt || [];
(function () {
    var hm = document.createElement("script");
    hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
})();</script>
</body>

</html>