<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="request" />
<!DOCTYPE html>
<html class="bg-black">
    <head>
        <meta charset="UTF-8">
        <title>系统登录页面</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- bootstrap 3.0.2 -->
        <link href="${ctx}/resources/static/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="${ctx}/resources/static/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="${ctx}/resources/static/css/AdminLTE.css" rel="stylesheet" type="text/css" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="bg-black">

        <div class="form-box" id="login-box">
            <div class="header">系统登录</div>
            <form action="${ctx}/j_spring_security_check" method="POST">
                <div class="body bg-gray">
                    <div class="form-group">
                        <input type="text" name="account" class="form-control" placeholder="User ID"/>
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" placeholder="Password"/>
                    </div>
<!--                     <div class="form-group"> -->
<!-- 	                    <div class="input-group input-group-lg"> -->
<!-- 	                        <input type="text" name="validateCode" class="form-control"  placeholder="验证码"/> -->
<!-- 		                   	<span class="input-group-addon"  style="padding-top: 4px;"> -->
<%-- 		                   		<img id="validateCodeImg"  src="${ctx}/validateCode" />&nbsp;&nbsp;<a href="#" onclick="javascript:reloadValidateCode();">看不清？</a> --%>
<!-- 		                    </span> -->
<!-- 	                    </div> -->
<!--                     </div>            -->
                    <div class="form-group">
                        <input type="checkbox" name="remember_me"/> 记住我
                    </div>
                </div>
                <div class="footer">                                                               
                    <button type="submit" class="btn bg-olive btn-block">登      录</button>  
                    
                    <p><a href="#">忘记密码</a></p>
                    
                    <a href="register.html" class="text-center">注册用户</a>
                </div>
            </form>

            <div class="margin text-center">
<!--                 <span>使用合作账户登录</span> -->
                <br/>
                <button class="btn bg-light-blue btn-circle"></button>
                <button class="btn bg-aqua btn-circle"></button>
                <button class="btn bg-red btn-circle"></button>

            </div>
        </div>


        <!-- jQuery 2.0.2 -->
        <script src="${ctx}/resources/static/js/jquery2.0.2.min.js"></script>
        <!-- Bootstrap -->
        <script src="${ctx}/resources/static/js/bootstrap.min.js" type="text/javascript"></script>        
        <script type="text/javascript">
			<!--
			function reloadValidateCode(){
				$("#validateCodeImg").attr("src","${ctx}/validateCode?data=" + new Date() + Math.floor(Math.random()*24));
			}
			//-->
			</script>
    </body>
</html>