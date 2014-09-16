<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

 
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
 <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>客户信息管理  <small>用户详情</small></h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> 客户信息管理</a></li>
                        <li class="active">用户详情</li>
                    </ol>
                 </section>

                <!-- Main content -->
                <section class="content">
                	 <form role="form">
                                    <div class="box-body">
                                        <div class="form-group">
                                            <label for="name">客户姓名</label>
                                            <input type="text" class="form-control" id="name" name="name" placeholder="客户姓名">
                                        </div>
                                        <div class="form-group">
                                            <label for="gender">客户性别</label>
                                            <label class="radio-inline">
											  <input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1"> 男
											</label>
											<label class="radio-inline">
											  <input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1"> 女
											</label>
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputFile">证件类型</label>
                                            <select>
                                            	<option value="01">身份证</option>
                                            	<option value="02">军官证</option>
                                            	<option value="03">护照</option>
                                            	<option value="04">回乡证</option>
                                            	<option value="05">台胞证</option>
                                            	<option value="06">警官证</option>
                                            	<option value="07">士兵证</option>
                                            	<option value="99">其它证件</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label for="idNum">证件号码</label>
                                            <input type="text" class="form-control" id="idNum" name="idNum" placeholder="证件号码">
                                        </div>
                                         <div class="form-group">
                                            <label for="mobile">客户手机号码</label>
                                            <input type="text" class="form-control" id="mobile" name="mobile" placeholder="客户手机号码">
                                        </div>
                                         <div class="form-group">
                                            <label for="email">客户邮箱</label>
                                            <input type="email" class="form-control" id="email" name="email" placeholder="客户邮箱">
                                        </div>
                                       
                                    </div><!-- /.box-body -->

                                    <div class="box-footer">
                                        <button type="submit" class="btn btn-primary btn-lg btn-block">保存客户信息</button>
                                    </div>
                                </form>
				  
				    
				    <script type="text/javascript">
				    $(document).ready(function() {
				      
				    } );
				    </script>
                </section><!-- /.content -->
    </tiles:putAttribute>
</tiles:insertDefinition>