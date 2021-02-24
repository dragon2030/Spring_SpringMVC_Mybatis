<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath %>" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>userOperation</title>
    <script src="resources/js/jquary/jquery-2.1.0.js"></script>
</head>
<body>
    <form id="from1">
        <input type="text" id="userId" name="userId"/><br>
    </form>
    <button onclick="button1()">getUserById</button><br>
</body>
<script>
    function button1() {
        var data = {"userId" : $("#userId").val()};
        var url = "<%=basePath %>user/findById";
        console.info("data:"+JSON.stringify(data));
        console.info("url:"+url);
        $.ajax({
            url:url,    //请求的url地址
            type:"POST",   //请求方式
            contentType: "application/json;charset=UTF-8",
            data:JSON.stringify(data),
            //dataType:"json",
            success:function(req){//成功返回数据
                debugger;
                console.info(req);
            },
            error: function (xhr, textStatus, errorThrown) {/*错误信息处理*/
                console.info("进入error---"+"状态码："+xhr.status+"状态:"+xhr.readyState+"错误信息:"+xhr.statusText+"返回响应信息："
                    +xhr.responseText+"请求状态："+textStatus+errorThrown+"请求失败");
            }
        });
    }

</script>
</html>
