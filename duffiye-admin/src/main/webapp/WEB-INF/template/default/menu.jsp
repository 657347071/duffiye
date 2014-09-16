 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="ctx" value="${pageContext.request.contextPath}" scope="request" />
 <aside class="left-side sidebar-offcanvas">                
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="${ctx}/resources/static/img/avatar3.png" class="img-circle" alt="User Image" />
                        </div>
                        <div class="pull-left info">
                            <p>您好,</p>

                            <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
                        </div>
                    </div>
                    <!-- search form -->
                    <form action="#" method="get" class="sidebar-form">
                        <div class="input-group">
                            <input type="text" name="q" class="form-control" placeholder="搜索..."/>
                            <span class="input-group-btn">
                                <button type='submit' name='seach' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
                            </span>
                        </div>
                    </form>
                    <!-- /.search form -->
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu">
                        <li class="active">
                            <a href="${ctx }/index.html">
                                <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                            </a>
                        </li>
<!--                         <li> -->
<!--                             <a href="widgets.html"> -->
<!--                                 <i class="fa fa-th"></i> <span>Widgets</span> <small class="badge pull-right bg-green">new</small> -->
<!--                             </a> -->
<!--                         </li> -->
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-bar-chart-o"></i>
                                <span>系统设置</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="${ctx }/system/user/list"><i class="fa fa-angle-double-right"></i> 用户管理</a></li>
                                <li><a href="charts/flot.html"><i class="fa fa-angle-double-right"></i> 角色管理</a></li>
                                <li><a href="charts/inline.html"><i class="fa fa-angle-double-right"></i> 权限管理</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-laptop"></i>
                                <span>客户信息管理</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="<c:url value="/customer/list" />"><i class="fa fa-angle-double-right"></i> 客户信息列表</a></li>
                                <li><a href="<c:url value="/customer/auth/list" />"><i class="fa fa-angle-double-right"></i> 认证信息列表</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-edit"></i> <span>商户管理</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="forms/general.html"><i class="fa fa-angle-double-right"></i> 机构列表</a></li>
                                <li><a href="forms/advanced.html"><i class="fa fa-angle-double-right"></i> 商户列表</a></li>
                                <li><a href="forms/editors.html"><i class="fa fa-angle-double-right"></i> 商户黑白名单</a></li>                                
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-table"></i> <span>交易信息管理</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="tables/simple.html"><i class="fa fa-angle-double-right"></i>交易信息查询</a></li>
                                <li><a href="tables/simple.html"><i class="fa fa-angle-double-right"></i>金额变动查询</a></li>
                                <li><a href="tables/simple.html"><i class="fa fa-angle-double-right"></i>转账信息查询</a></li>
                                <li><a href="tables/data.html"><i class="fa fa-angle-double-right"></i> 对账管理</a></li>
                                <li><a href="tables/data.html"><i class="fa fa-angle-double-right"></i> 提现信息查询</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="calendar.html">
                                <i class="fa fa-calendar"></i> <span>账户信息查询</span>
                                <small class="badge pull-right bg-red"></small>
                            </a>
                        </li>
<!--                         <li> -->
<!--                             <a href="mailbox.html"> -->
<!--                                 <i class="fa fa-envelope"></i> <span>Mailbox</span> -->
<!--                                 <small class="badge pull-right bg-yellow">12</small> -->
<!--                             </a> -->
<!--                         </li> -->
<!--                         <li class="treeview"> -->
<!--                             <a href="#"> -->
<!--                                 <i class="fa fa-folder"></i> <span>Examples</span> -->
<!--                                 <i class="fa fa-angle-left pull-right"></i> -->
<!--                             </a> -->
<!--                             <ul class="treeview-menu"> -->
<!--                                 <li><a href="examples/invoice.html"><i class="fa fa-angle-double-right"></i> Invoice</a></li> -->
<!--                                 <li><a href="examples/login.html"><i class="fa fa-angle-double-right"></i> Login</a></li> -->
<!--                                 <li><a href="examples/register.html"><i class="fa fa-angle-double-right"></i> Register</a></li> -->
<!--                                 <li><a href="examples/lockscreen.html"><i class="fa fa-angle-double-right"></i> Lockscreen</a></li> -->
<!--                                 <li><a href="examples/404.html"><i class="fa fa-angle-double-right"></i> 404 Error</a></li> -->
<!--                                 <li><a href="examples/500.html"><i class="fa fa-angle-double-right"></i> 500 Error</a></li>                                 -->
<!--                                 <li><a href="examples/blank.html"><i class="fa fa-angle-double-right"></i> Blank Page</a></li> -->
<!--                             </ul> -->
<!--                         </li> -->
<!--                         <li class="treeview"> -->
<!--                             <a href="#"> -->
<!--                                 <i class="fa fa-folder"></i>  Multilevel Menu -->
<!--                                 <i class="fa fa-angle-left pull-right"></i> -->
<!--                             </a>                             -->

<!--                             <ul class="treeview-menu"> -->
<!--                                 <li class="treeview"> -->
<!--                                     <a href="#"> -->
<!--                                         First level -->
<!--                                         <i class="fa fa-angle-left pull-right"></i> -->
<!--                                     </a> -->

<!--                                     <ul class="treeview-menu"> -->
<!--                                         <li class="treeview"> -->
<!--                                             <a href="#"> -->
<!--                                                 Second level -->
<!--                                                 <i class="fa fa-angle-left pull-right"></i> -->
<!--                                             </a> -->

<!--                                             <ul class="treeview-menu"> -->
<!--                                                 <li> -->
<!--                                                     <a href="#">Third level</a> -->
<!--                                                 </li> -->
<!--                                             </ul> -->
<!--                                         </li> -->
<!--                                     </ul> -->
<!--                                 </li> -->
<!--                             </ul> -->
<!--                         </li> -->
                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>