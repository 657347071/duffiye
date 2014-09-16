<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

 
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
 <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        	客户管理
                        <small>实名认证信息列表</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> 客户管理</a></li>
                        <li class="active">实名认证信息列表</li>
                    </ol>
                </section>

                <!-- Main content -->
                <section class="content">
                	   <div>
				   			<!-- condition -->
					   </div>
					<table id="example" class="display" cellspacing="0" width="100%">
				        <thead>
				            <tr>
				                <th>客户编号</th>
				                <th>客户姓名</th>
				                <th>性别</th>
				                <th>证件类型</th>
				                <th>证件号码</th>
				                <th>手机号码</th>
				                <th>电子邮件</th>
				                <th>认证状态</th>
				                <th>操作</th>
				            </tr>
				        </thead>
				        <tbody>
				        		<tr>
				        			<td>100100002</td>
				        			<td>李玉刚</td>
				        			<td>男</td>
				        			<td>身份证</td>
				        			<td>430721198704027233</td>
				        			<td>13874918923</td>
				        			<td>qimanfei@kingpass.cn</td>
				        			<td>已实名认证</td>
				        			<td>
				        				<!-- Button trigger modal -->
										<a href="<c:url value="/customer/auth/detail" /> "> <button class="btn btn-primary">用户详情</button></a>
				        			</td>
				        		</tr>	<tr>
				        			<td>100100002</td>
				        			<td>李玉刚</td>
				        			<td>男</td>
				        			<td>身份证</td>
				        			<td>430721198704027233</td>
				        			<td>13874918923</td>
				        			<td>qimanfei@kingpass.cn</td>
				        			<td>已实名认证</td>
				        			<td>
				        				<!-- Button trigger modal -->
										<a href="<c:url value="/customer/auth/detail" /> "> <button class="btn btn-primary">用户详情</button></a>
				        			</td>
				        		</tr>	<tr>
				        			<td>100100002</td>
				        			<td>李玉刚</td>
				        			<td>男</td>
				        			<td>身份证</td>
				        			<td>430721198704027233</td>
				        			<td>13874918923</td>
				        			<td>qimanfei@kingpass.cn</td>
				        			<td>已实名认证</td>
				        			<td>
				        				<!-- Button trigger modal -->
										<a href="<c:url value="/customer/auth/detail" /> "> <button class="btn btn-primary">用户详情</button></a>
				        			</td>
				        		</tr>
				        </tbody>
				    </table>
<%-- 				   <tags:pagination paginator="${paginator }"></tags:pagination> --%>
				   
	
				    
				    <script type="text/javascript">
				    $(document).ready(function() {
				      
				    });
				    </script>
                </section><!-- /.content -->
    </tiles:putAttribute>
</tiles:insertDefinition>