<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %><%	String path = request.getContextPath();	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";%><!-- BEGIN PAGE LEVEL STYLES --><link rel="stylesheet" type="text/css" href="media/css/select2_metro.css" /><link rel="stylesheet" href="media/css/DT_bootstrap.css" /><link rel="stylesheet" href="media/zTree/css/zTreeStyle.css" type="text/css"><!-- END PAGE LEVEL STYLES --><!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM--><div id="portlet-config" class="modal hide">	<div class="modal-header">		<button data-dismiss="modal" class="close" type="button"></button>		<h3>portlet Settings</h3>	</div>	<div class="modal-body">		<p>Here will be a configuration form</p>	</div></div><!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM--><!-- BEGIN PAGE HEADER--><div class="row-fluid">	<div class="span12">		<!-- BEGIN PAGE TITLE & BREADCRUMB-->		<h3 class="page-title">			${pd.USER_TITLE} <small>${pd.USER_SUBTITLE}</small>		</h3>		<ul class="breadcrumb">			<li>				<i class="icon-home"></i>				<a href="index.html">${pd.HOME}</a>				<i class="icon-angle-right"></i>			</li>			<li>				<a href="#">${pd.USER_TITLE}</a>				<i class="icon-angle-right"></i>			</li>			<li><a href="#">${pd.USER_SUBTITLE}</a></li>		</ul>		<!-- END PAGE TITLE & BREADCRUMB-->	</div></div><!-- END PAGE HEADER--><!-- BEGIN PAGE CONTENT--><div class="row-fluid">	<div class="span12">		<!-- BEGIN EXAMPLE TABLE PORTLET-->		<div class="portlet box yellow">			<div class="portlet-title">				<div class="caption">					<i class="icon-coffee"></i>${pd.USER_TITLE}				</div>				<div class="tools">					<a href="javascript:;" class="collapse"></a>					<a href="#portlet-config" data-toggle="modal" class="config"></a>					<a href="javascript:void(0);" class="reload" id="refresh"></a>					<a href="javascript:;" class="remove"></a>				</div>			</div>			<div class="portlet-body">				<div class="clearfix">					<!-- Add New Start -->					<div class="btn-group">						<a href="javascript:void(0);" class="btn yellow" onclick="addNewBtn()"  id="addNewHref" data-toggle="modal">${pd.USER_ADD} <i class="icon-plus"></i></a>					</div>					<!-- Add New End -->					<div class="btn-group pull-right">						<button class="btn dropdown-toggle" data-toggle="dropdown">${pd.TOOLS} <i class="icon-angle-down"></i>						</button>						<ul class="dropdown-menu pull-right">							<li><a href="#">${pd.PRINT}</a></li>							<li><a href="#">${pd.PDF}</a></li>							<li><a href="#">${pd.EXCEL}</a></li>						</ul>					</div>				</div>					<table class="table table-bordered table-hover" id="baseTable">						<thead>							<tr>								<th>${pd.INDEX}</th>								<th hidden></th>								<th hidden></th>								<th hidden></th>								<th hidden></th>								<th>${pd.USER_LOGINAME}</th>								<th>${pd.USER_EMAIL}</th>								<th>${pd.USER_CREATE}</th>								<th>${pd.USER_UPDATE}</th>								<th>${pd.USER_DELETE}</th>								<th>${pd.DELETE}</th>							</tr>						</thead>						<tbody>							<c:choose>								<c:when test="${not empty userlist}">									<c:forEach items="${userlist}" var="userlist" varStatus="user">										<tr class="">											<td>${user.index+1}</td>											<td hidden>${userlist.USER_ID}</td>											<td hidden>${userlist.CREATERIGHT}</td>											<td hidden>${userlist.UPDATERIGHT}</td>											<td hidden>${userlist.DELETERIGHT}</td>											<td>${userlist.USERNAME}</td>											<td>${userlist.EMAIL}</td>											<th>												<a href="javascript:void(0);" class="btn green icn-only" onclick="assignCreatBtn(this)"><i class="icon-user icon-white"></i></a>											</th>											<th>												<a href="javascript:void(0);" class="btn green icn-only" onclick="assignUpdateBtn(this)"><i class="icon-user icon-white"></i></a>											</th>											<th>												<a href="javascript:void(0);" class="btn green icn-only" onclick="assignDeleteBtn(this)"><i class="icon-user icon-white"></i></a>											</th>											<td>												<a href="javascript:void(0);" class="btn red" onclick="userDeleBtn(this)" data-toggle="modal"><i class="icon-trash"></i></a>											</td>										</tr>									</c:forEach>								</c:when>							</c:choose>						</tbody>					</table>				<div id="addNew" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel3" aria-hidden="true">					<div class="modal-header">						<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>						<h3 id="myModalLabel3">Confirm Header</h3>					</div>					<div class="modal-body">						<div class="portlet-body form">							<form action="#" class="form-horizontal form-bordered">								<div class="control-group">									<label class="control-label">First Name</label>									<div class="controls">										<input type="text" placeholder="small" class="m-wrap span12" />										<span class="help-inline">This is inline help</span>									</div>								</div>								<div class="control-group">									<label class="control-label">Last Name</label>									<div class="controls">										<input type="text" placeholder="medium" class="m-wrap span12" />										<span class="help-inline">This is inline help</span>									</div>								</div>								<div class="control-group">									<label class="control-label">Gender</label>									<div class="controls">										<select  class="m-wrap span12">											<option value="">Male</option>											<option value="">Female</option>										</select>									</div>								</div>							</form>						</div>					</div>					<div class="modal-footer">						<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>						<button data-dismiss="modal" class="btn blue" id="confirmBtn">Confirm</button>					</div>				</div>				<div id="deletehref" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2" aria-hidden="true">					<div class="modal-header">						<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>						<h3 id="myModalLabel2">${pd.DELETE_TITLE}</h3>					</div>					<div class="modal-body">						<p>${pd.DELETE_CONFIRM} <span id="username"></span><span hidden id="userID"></span></p>					</div>					<div class="modal-footer">						<button class="btn" data-dismiss="modal" aria-hidden="true">${pd.CLOSE}</button>						<button data-dismiss="modal" id="userDeleteBtn" class="btn blue">${pd.CONFIRM}</button>					</div>				</div>				<div id="userButtonAssignment" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">					<div class="modal-header">						<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>						<h3 id="roleAssignmentLabel">${pd.USER_ASSIGNMENT} <span id="user_ID" hidden></span><span id="operationType" hidden></span></h3>					</div>					<div class="modal-body">						<form  class="form-horizontal" id="assignment">							<div class="zTreeDemoBackground">								<ul id="treeDemo" class="ztree"></ul>							</div>							<div class="form-actions">								<button class="btn" id="userAssignRoleBtn" data-dismiss="modal" aria-hidden="true">${pd.CONFIRM}</button>							</div>						</form>					</div>				</div>			</div>		</div>		<!-- END EXAMPLE TABLE PORTLET-->	</div></div><!-- END PAGE CONTENT --><!-- BEGIN PAGE LEVEL PLUGINS --><script type="text/javascript" src="media/js/select2.min.js"></script><script type="text/javascript" src="media/js/jquery.dataTables.js"></script><script type="text/javascript" src="media/js/DT_bootstrap.js"></script><!-- END PAGE LEVEL PLUGINS --><!-- BEGIN PAGE LEVEL SCRIPTS --><script src="media/js/app.js"></script><script src="media/js/table-editable.js"></script><script type="text/javascript" src="media/zTree/js/jquery.ztree.core.js"></script><script type="text/javascript" src="media/zTree/js/jquery.ztree.excheck.js"></script><script type="text/javascript" src="media/zTree/js/zTree-check.js"></script><!-- END PAGE LEVEL SCRIPTS --><script type="text/javascript">	jQuery(document).ready(function() {		TableEditable.init();		ZTreeCheck.init();	});</script><script type="text/javascript">	function addNewBtn(){		$("#addNew").modal('show');	}</script><script type="text/javascript">	$(function () {		$("#confirmBtn").click(function () {			$.ajax({				type : 'post',				url : 'addUser',				async : true,				data : {"time" : new Date()},				success : function (data) {					$("#baseTable").html(data);				}			});		});	});</script><script type="text/javascript">	function userDeleBtn(obj){		var ob = $(obj).parent().parent().find('td');		$("#userID").html(ob.eq(1).text())		$("#username").html(ob.eq(2).text());		$("#deletehref").modal('show');	}</script><script type="text/javascript">	$(function(){		$("#userDeleteBtn").click(function(){			var id = $("#userID").html();			$.ajax({				type : 'post',				url : 'deleteUser',				async : true,				data : {"time" : new Date(),'id':id},				success : function (data) {					$("#baseTable").html(data);				}			});		});	});</script><script type="text/javascript">	function assignCreatBtn(obj) {		var tree = $.fn.zTree.getZTreeObj("treeDemo");		var ob = $(obj).parent().parent().find('td');		var createRights = ob.eq(2).text();		var userID = ob.eq(1).text();		$("#user_ID").html(userID);		$("#operationType").html("CREATERIGHT");		$.ajax({			type : 'post',			url : 'getMenu',			async : false,			data : {"rights" : createRights},			success : function (data) {				var nodes = data.nodes;				for(var i=0;i<nodes.length;i++){					var local = nodes[i].id;					var childNode = tree.getNodeByParam("id", local, null); //获取父节点					var checkflag = nodes[i].checked;					if(checkflag){						childNode.checked = true;						tree.checkNode(childNode,true,true,true);					}else{						childNode.checked = false;						tree.checkNode(childNode,false,true,true);					}				}			}		});		$("#userButtonAssignment").modal('show');	}</script><script type="text/javascript">	function assignUpdateBtn(obj) {		var tree = $.fn.zTree.getZTreeObj("treeDemo");		var ob = $(obj).parent().parent().find('td');		var updateRights = ob.eq(3).text();		var userID = ob.eq(1).text();		$("#user_ID").html(userID);		$("#operationType").html("UPDATERIGHT");		$.ajax({			type : 'post',			url : 'getMenu',			async : false,			data : {"rights" : updateRights},			success : function (data) {				var nodes = data.nodes;				for(var i=0;i<nodes.length;i++){					var local = nodes[i].id;					var childNode = tree.getNodeByParam("id", local, null); //获取父节点					var checkflag = nodes[i].checked;					if(checkflag){						childNode.checked = true;						tree.checkNode(childNode,true,true,true);					}else{						childNode.checked = false;						tree.checkNode(childNode,false,true,true);					}				}			}		});		$("#userButtonAssignment").modal('show');	}</script><script type="text/javascript">	function assignDeleteBtn(obj) {		var tree = $.fn.zTree.getZTreeObj("treeDemo");		var ob = $(obj).parent().parent().find('td');		var deleteRights = ob.eq(4).text();		var userID = ob.eq(1).text();		$("#user_ID").html(userID);		$("#operationType").html("DELETERIGHT");		$.ajax({			type : 'post',			url : 'getMenu',			async : false,			data : {"rights" : deleteRights},			success : function (data) {				var nodes = data.nodes;				for(var i=0;i<nodes.length;i++){					var local = nodes[i].id;					var childNode = tree.getNodeByParam("id", local, null); //获取父节点					var checkflag = nodes[i].checked;					if(checkflag){						childNode.checked = true;						tree.checkNode(childNode,true,true,true);					}else{						childNode.checked = false;						tree.checkNode(childNode,false,true,true);					}				}			}		});		$("#userButtonAssignment").modal('show');	}</script><script type="text/javascript">	$(function(){		$("#userAssignRoleBtn").click(function () {			//获取zTree 选中的node			var t = $.fn.zTree.getZTreeObj("treeDemo");			var checkCount = t.getCheckedNodes(true);			var result = [];			for(var i=0;i<checkCount.length;i++) {				result[i] = checkCount[i].id;			}			var userID =  $("#user_ID").html();			var opertaionType = $("#operationType").html();			var params = result.join('@');			$.ajax({				type : 'post',				url : 'btnSaveRights',				data : {"right":params,"userID":userID,"whereConditon":opertaionType},				async : false,				success : function (data) {					$("#baseTable").html(data);				}			});		});	})</script><script type="text/javascript">	$(function () {		$("#refresh").click(function () {			$.ajax({				type : 'post',				url  : 'refresh',				data : {"refreshType" : "user"},				success : function (data) {					$("#baseTable").html(data);				}			});		});	})</script>