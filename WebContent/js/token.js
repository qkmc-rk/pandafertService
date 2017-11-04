/* 按鈕是否打開的函數   */
$(document).ready(function(){
	//打开按钮
	$("#table").on("check.bs.table",function(row,elem){
	$("button[name='delete']").removeAttr("disabled");
	$("button[name='update']").removeAttr("disabled");
	//bootstrapTable方法使用
		var rows = $("#table").bootstrapTable('getSelections');
		$("#delete-info").html(($(rows).last())[0].tokenId +" | " + ($(rows).last())[0].token +" | "
			+($(rows).last())[0].userId);
		
		//修改update pop框中的内容
		var uelems = $("#update-info").children('input');
		$(uelems[0]).val($(rows).last()[0].token);
		$(uelems[1]).val($(rows).last()[0].userId);
		$(uelems[2]).val($(rows).last()[0].tokenId);
	});
	
	//关闭按钮
	$("#table").on("uncheck.bs.table",function(row,elem){
		$("button[name='delete']").attr("disabled","disabled");
		$("button[name='update']").attr("disabled","disabled");
	});
});
//刪除一個元素
function deleteToken(){
	var rows = $("#table").bootstrapTable('getSelections');
	//請求服務器刪除數據
	var tid = $(rows).last()[0].tokenId;
	$.ajax({
		type:"get",
		url:"delete",
		async:false,
		data:{type:"token", tokenid:tid},
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

function addToken(){
	var addinfo = $("#add-info").children("input");
	var tk = addinfo[0].value;
	var uid = addinfo[1].value;
	
	$.ajax({
		type:"get",
		url:"add",
		dataType:"json",
		async:false,
		data:{type:"token",token:tk, userid:uid},
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


function updateToken(){
	//1.点击修改按钮后弹出修改框，框中的内容必须用勾选的信息填充，在勾选时，就要将信息填入info div当中，因此这一步在checktable监听函数中进行。
	//2.点击确认修改按钮后，调用此函数
	
	//首先获取各个输入框中的内容
	var updateinfo = $("#update-info").children("input");
	var tk = updateinfo[0].value;
	var uid = updateinfo[1].value;
	var tid = updateinfo[2].value;
	//ajax进行更新操作
	$.ajax({
		type:"get",
		url:"update",
		dataType:"json",
		async:false,
		data:{type:"token",tokenid:tid,token:tk, userid:uid},
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
