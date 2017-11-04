<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>pandafert</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/datepicker3.css" rel="stylesheet">
<link href="css/bootstrap-table.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">

<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->

</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><span>pandafert</span>后台管理</a>
				<ul class="user-menu">
					<li class="dropdown pull-right">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> ${sessionScope.user.uNeckName } <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#"><span class="glyphicon glyphicon-user"></span> 个人中心</a></li>
							<li><a href="#"><span class="glyphicon glyphicon-cog"></span> 设置</a></li>
							<li><a href="#"><span class="glyphicon glyphicon-log-out"></span> 退出登录</a></li>
						</ul>
					</li>
				</ul>
			</div>
							
		</div><!-- /.container-fluid -->
	</nav>
		
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<form role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
		</form>
		<ul class="nav menu">
			<li class="active"><a href="${pageContext.request.contextPath}/touser"><span class="glyphicon glyphicon-dashboard"></span> 用户管理</a></li>
			<li><a href="${pageContext.request.contextPath}/totoken"><span class="glyphicon glyphicon-stats"></span> 令牌管理</a></li>
			<li><a href="${pageContext.request.contextPath}/toorder"><span class="glyphicon glyphicon-list-alt"></span> 订单管理</a></li>
			<li><a href="${pageContext.request.contextPath}/torecord"><span class="glyphicon glyphicon-pencil"></span> 已完成订单管理</a></li>
			<li role="presentation" class="divider"></li>
			<li><a href="adminlogin.jsp"><span class="glyphicon glyphicon-user"></span> 登录页面</a></li>
		</ul>
		<div class="attribution">(c) Copyright 2017 Mrruan. All Rights Reserved.  </div>
	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">数据管理</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">数据管理</h1>
			</div>
		</div><!--/.row-->
				
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<button class="btn btn-primary" data-toggle="modal" data-target="#addpop">增加</button>
						<button class="btn btn-primary" name="delete" disabled="disabled" data-toggle="modal" data-target="#deletepop">删除</button>
						<button class="btn btn-primary" name="update" disabled="disabled" data-toggle="modal" data-target="#updatepop">修改</button>
					</div>
					<!-- 删除弹出框 -->
					<div class="modal fade" id="deletepop">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">×</button>
									<h4>确认删除？</h4>
								</div>
								<div class="modal-body">
									<div id="delete-info"></div>
								</div>
								<div class="modal-footer">
									<button type="button" id="cancelDel" class="btn btn-primary" data-dismiss="modal">取消</button>
									<button type="button" id="confirmDel" class="btn btn-primary" onclick="deleteUser()">确定</button>
								</div>
							</div>
						</div>
					</div>
					<!-- 删除弹出框结束 -->
					<!--   增加pop              -->
					<div class="modal fade" id="addpop">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">×</button>
									<h4>添加用戶</h4>
								</div>
								<div class="modal-body">
									<div id="add-info" class="input-group">
										<input class="form-control" type="text"  name="userneckname" id="userneckname" value="" placeholder="昵称"/>
										<input class="form-control" type="text" name="useraccount" id="useraccount" value="" placeholder="用户名/账号"/>
										<input class="form-control" type="text" name="userpassword" id="userpassword" value="" placeholder="密码"/>
										<input class="form-control" type="text" name="useroldpwd" id="useroldpwd" value="" placeholder="旧密码"/>
										<input class="form-control" type="tel" name="userphone" id="userphone" value="" placeholder="电话"/>
										<input class="form-control" type="email" name="usermail" id="usermail" value="" placeholder="邮箱"/>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
									<button type="button" class="btn btn-primary" onclick="addUser()" data-dismiss="modal">添加</button>
								</div>
							</div>
						</div>
					</div>
					<!--   增加pop結束              -->
					<!--   修改pop              -->
					<div class="modal fade" id="updatepop">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">×</button>
									<h4>修改信息</h4>
								</div>
								<div class="modal-body">
									<div id="update-info" class="input-group">
										<span>昵称:</span><input class="form-control" type="text"  name="userneckname" id="userneckname" value="" />
										</br><span>账号:</span><input class="form-control" type="text" name="useraccount" id="useraccount" value="" />
										</br><span>密码:</span><input class="form-control" type="text" name="userpassword" id="userpassword" value="" />
										</br><span>旧密码:</span><input class="form-control" type="text" name="useroldpwd" id="useroldpwd" value="" />
										</br><span>电话:</span><input class="form-control" type="tel" name="userphone" id="userphone" value="" />
										</br><span>邮箱:</span><input class="form-control" type="email" name="usermail" id="usermail" value="" />
									    </br><span>ID:</span><input class="form-control" type="text"  name="userid" id="userid" value="" disabled="disabled"/>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
									<button type="button" class="btn btn-primary" onclick="updateUser()" data-dismiss="modal">修改</button>
								</div>
							</div>
						</div>
					</div>
					<!--   修改pop結束              -->
					<div class="panel-body">
						<table id="table" data-toggle="table" data-url="querry?type=user" data-single-select="true" data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="user-row" data-pagination="true" data-sort-name="name" data-sort-order="desc">
						    <thead>
						    <tr>
						    	<th data-field="state" data-checkbox = "true" >选择</th>
						        <th data-field="uId" data-sortable="true" >ID</th>
						        <th data-field="uNeckName" data-sortable="true" >昵称</th>
						        <th data-field="uAccount" data-sortable="true" >账号</th>
						        <th data-field="uPassword" data-sortable="true" >密码</th>
						        <th data-field="uOldPwd" data-sortable="true">旧密码</th>
						        <th data-field="uPhone"  data-sortable="true">电话</th>
						        <th data-field="uMail" data-sortable="true">邮箱</th>
						    </tr>
						    </thead>
						</table>
					</div>
				</div>
			</div>
		</div><!--/.row-->
		
	</div><!--/.main-->

	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/bootstrap-table.js"></script>
	<script src="js/user.js"></script>
	<script>
		!function ($) {
			$(document).on("click","ul.nav li.parent > a > span.icon", function(){		  
				$(this).find('em:first').toggleClass("glyphicon-minus");	  
			}); 
			$(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
		}(window.jQuery);

		$(window).on('resize', function () {
		  if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
		})
		$(window).on('resize', function () {
		  if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
		})
	</script>	
</body>

</html>
