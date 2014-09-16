<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" scope="request" />

 
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
 <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        	商户管理
                        <small>商户列表</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> 商户管理   </a></li>
                        <li class="active">商户列表</li>
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
										<button class="btn btn-primary " data-toggle="modal" data-target="#myModal">新增用户</button>
										<button class="btn btn-primary " data-toggle="modal" data-target="#myModal">修改用户</button>
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
										<button class="btn btn-primary " data-toggle="modal" data-target="#myModal">新增用户</button>
										<button class="btn btn-primary " data-toggle="modal" data-target="#myModal">修改用户</button>
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
										<button class="btn btn-primary " data-toggle="modal" data-target="#myModal">新增用户</button>
										<button class="btn btn-primary " data-toggle="modal" data-target="#myModal">修改用户</button>
				        			</td>
				        		</tr>
				        </tbody>
				    </table>
<%-- 				   <tags:pagination paginator="${paginator }"></tags:pagination> --%>
				   
				   <!-- Modal -->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					  <div class="modal-dialog">
					    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					        <h4 class="modal-title" id="myModalLabel">新增客户</h4>
					      </div>
					      <div class="modal-body">
					         <form action="#" method="POST">
					         	    <div class="box-body">
                                        <div class="form-group">
                                            <label for="exampleInputEmail1">客户姓名</label>
                                            <input type="text" class="form-control" id="exampleInputEmail1" placeholder="客户姓名">
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputPassword1">性别</label>
                                            <input type="text" class="form-control" id="exampleInputPassword1" placeholder="性别">
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputFile">证件类型</label>
                                            <input type="text" class="form-control" id="exampleInputPassword1" placeholder="证件类型">
                                        </div>
                                         <div class="form-group">
                                            <label for="exampleInputEmail1">证件号码</label>
                                            <input type="text" class="form-control" id="exampleInputPassword1" placeholder="证件号码">
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputPassword1">手机号码</label>
                                            <input type="text" class="form-control" id="exampleInputPassword1" placeholder="手机号码">
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputFile">电子邮件</label>
                                            <input type="email" class="form-control" id="exampleInputPassword1" placeholder="电子邮件">
                                        </div>
                                         <div class="form-group">
                                            <label for="exampleInputFile">认证状态</label>
                                            <input type="text" class="form-control" id="exampleInputPassword1" placeholder="认证状态">
                                        </div>
                                        
                                    </div><!-- /.box-body -->

                                    <div class="box-footer">
                                        <button type="submit" class="btn btn-primary">Submit</button>
                                    </div>
					         	
					         </form>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					      </div>
					    </div>
					  </div>
					</div>
				    
				    <script type="text/javascript">
				    $(document).ready(function() {
				      
				    } );
				    </script>
                </section><!-- /.content -->
    </tiles:putAttribute>
</tiles:insertDefinition>