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
                        	系统管理
                        <small>用户列表</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> 系统管理</a></li>
                        <li class="active">用户列表</li>
                    </ol>
                </section>

                <!-- Main content -->
                <section class="content">
                	   <div>
				   			<form id="searchForm" name="searchForm" action="${ctx}/system/user/list" method="post">
				   			<input name="pageIndex" id="pageIndex" value="${paginator.pageIndex}"/>
				   			<input  type="submit" class="btn btn-default" value="查询"/>
				   			</form>
					   </div>
					<table id="example" class="display" cellspacing="0" width="100%">
				        <thead>
				            <tr>
				                <th>ID</th>
				                <th>Account</th>
				                <th>NickName</th>
				                <th>Password</th>
				                <th>操作</th>
				            </tr>
				        </thead>
				        <tbody>
				        	<c:forEach var="user" items="${data }">
				        		<tr>
				        			<td>${user.account }</td>
				        			<td>${user.account }</td>
				        			<td>${user.account }</td>
				        			<td>${user.account }</td>
				        			<td>
				        				<!-- Button trigger modal -->
										<button class="btn btn-primary " data-toggle="modal" data-target="#myModal">
										  新增用户
										</button>
										<a href="${ctx }/system/user/detail">新增用户</a>
				        			</td>
				        		</tr>
				        	</c:forEach>
				        </tbody>
				    </table>
				   <tags:pagination paginator="${paginator }"></tags:pagination>
				   
				   <!-- Modal -->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					  <div class="modal-dialog">
					    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					        <h4 class="modal-title" id="myModalLabel">新增</h4>
					      </div>
					      <div class="modal-body">
					         <form action="${ctx }/system/user/save" method="POST">
					         	Account : <input type="text" name="account" /><br/>
					         	
					         	
					         	<button type="submit" class="btn btn-primary">保存</button>
					         	
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