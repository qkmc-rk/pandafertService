/* 按鈕是否打開的函數   */
$(document).ready(function(){
	//开函数
	$("#table").on("check.bs.table",function(row,elem){
		$("button[name='delete']").removeAttr("disabled");
		$("button[name='update']").removeAttr("disabled");//使修改按钮可用
		//bootstrapTable方法使用
		var rows = $("#table").bootstrapTable('getSelections');
		$("#delete-info").html(($(rows).last())[0].uId +" | " + ($(rows).last())[0].uNeckName +" | "
			+($(rows).last())[0].uAccount +" | " + ($(rows).last())[0].uMail +" | " 
			+($(rows).last())[0].uPhone +" | " +($(rows).last())[0].uPassword);
		//修改update popmenu中的内容
		var uelems = $("#update-info").children('input');
		$(uelems[0]).val($(rows).last()[0].uNeckName);
		$(uelems[1]).val($(rows).last()[0].uAccount);
		$(uelems[2]).val($(rows).last()[0].uPassword);
		$(uelems[3]).val($(rows).last()[0].uOldPwd);
		$(uelems[4]).val($(rows).last()[0].uPhone);
		$(uelems[5]).val($(rows).last()[0].uMail);
		$(uelems[6]).val($(rows).last()[0].uId);
	});
	//闭函数
	$("#table").on("uncheck.bs.table",function(row,elem){
		$("button[name='delete']").attr("disabled","disabled");
		$("button[name='update']").attr("disabled","disabled");//使修改按钮不可用
	});
});
//刪除一個元素
function deleteUser(){
	var rows = $("#table").bootstrapTable('getSelections');
	//請求服務器刪除數據
	var uid = $(rows).last()[0].uId;
	$.ajax({
		type:"get",
		url:"delete",
		async:false,
		data:{type:"user", userid:uid},
		dataType: "json",
		success:function(data){
			if(data.result == 'true'){
				$('#table').bootstrapTable('refresh');
				$("#deletepop").modal('hide');
				
				//操作完成后关闭按钮功能
				$("button[name='delete']").attr("disabled","disabled");
				$("button[name='update']").attr("disabled","disabled");//使修改按钮不可用
			}
		}
	});
	//等待1秒
	//刷新表格
}

function addUser(){
	var addinfo = $("#add-info").children("input");
	var unn = addinfo[0].value;
	var uac = addinfo[1].value;
	var upwd = addinfo[2].value;
	var uop = addinfo[3].value;
	var uph = addinfo[4].value;
	var uml = addinfo[5].value;
	
	$.ajax({
		type:"get",
		url:"add",
		dataType:"json",
		async:false,
		data:{type:"user",userneckname:unn, useraccount:uac, userpassword:upwd, useroldpwd:uop, userphone:uph, usermail:uml},
		success:function(data){
			if(data.result == 'true'){
				$('#table').bootstrapTable('refresh');
				$("#addpop").modal('hide');
				
				//操作完成后关闭按钮功能
				$("button[name='delete']").attr("disabled","disabled");
				$("button[name='update']").attr("disabled","disabled");//使修改按钮不可用
			}
		}
	}); 
}

function updateUser(){
	//1.点击修改按钮后弹出修改框，框中的内容必须用勾选的信息填充，在勾选时，就要将信息填入info div当中，因此这一步在checktable监听函数中进行。
	//2.点击确认修改按钮后，调用此函数
	
	//首先获取各个输入框中的内容
	var updateinfo = $("#update-info").children("input");
	var unn = updateinfo[0].value;
	var uac = updateinfo[1].value;
	var upwd = updateinfo[2].value;
	var uop = updateinfo[3].value;
	var uph = updateinfo[4].value;
	var uml = updateinfo[5].value;
	var uid = updateinfo[6].value;
	//ajax进行更新操作
	$.ajax({
		type:"get",
		url:"update",
		dataType:"json",
		async:false,
		data:{type:"user",userid:uid,userneckname:unn, useraccount:uac, userpwd:upwd, useroldpwd:uop, userphone:uph, usermail:uml},
		success:function(data){
			if(data.result == 'true'){
				//前台更新
				$('#table').bootstrapTable('refresh');
				$("#updatepop").modal('hide');
				
				//操作完成后关闭按钮功能
				$("button[name='delete']").attr("disabled","disabled");
				$("button[name='update']").attr("disabled","disabled");//使修改按钮不可用
			}
		}
	}); 
}
