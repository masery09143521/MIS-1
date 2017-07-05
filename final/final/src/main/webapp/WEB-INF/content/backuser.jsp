<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/public/backpublic.jsp"%>
<title>后台管理页面</title>
<script>

function search() {
	$('#back-user').datagrid('load', {
	serialNumber : $.trim($('input[name="serialNumber"]').val()), 	
	price : $.trim($('input[name="price"]').val()),
	model : $.trim($('input[name="model"]').val()),
	builder : $.trim($('input[name="builder"]').val()),
	type : $.trim($('input[name="type"]').val()),
	backWood : $.trim($('input[name="backWood"]').val()),
	topWood : $.trim($('input[name="topWood"]').val()),
	});
}
function updateRole() {
	$('#edit').window('open');  // open   
	var row = $('#back-user').datagrid('getSelected');
	$("#name").setValue(row.username);
}



$(function(){
	$('#edit').window('close');  // close 
 	var editorRow=undefined;
 	
 
 	

 	
 

 	

	$('#back-user').datagrid({    
	    with:600,
	    title:'用户管理',
	    treeField:'name',
	    fit: true,
	    idField:'id',
	    pageSize:10,
	    pageList:[10,15,20],
	    columns:[[    
	        {field:'serialNumber',title:'serialNumber',width:200,formatter: function(value,row,index){
				if (row.serialNumber==undefined&&index==0){
				  return "sorry ,nothing exist to you";
				} else{
				  return row.serialNumber
				}
			}},  
	        {field:'builder',title:'builder',width:200,} , 	     
	        {field:'price',title:'price',width:200,},    
	        {field:'model',title:'model',sortable:true,width:200,},	
	        {field:'type',title:'type',sortable:true,width:200,},
	        {field:'backWood',title:'backWood',sortable:true,width:200,},
	        {field:'topWood',title:'topWood',sortable:true,width:200,},	          	             	        
	    ]],   
		fitColumns:true,
		pagination:true,
		remoteSort:false,
		multiSort:true,
		nowrap:false,
		rownumbers:true,
		toolbar:'#tb',
	    striped:true,
	    url:'guitar_queryAllGuitar.action',    
		onDblClickRow: function (rowIndex,rowData){
		 $('#submit,#redo').show();
		 if(editorRow!=undefined){
		 $('#back-user').datagrid('endEdit',editorRow);
		 }
		  if(editorRow==undefined){
		  $('#back-user').datagrid('beginEdit',rowIndex);
		  editorRow=rowIndex;
		  }
		 },	  
		 
		   onAfterEdit:function(index, row, changes){
			     
			     
			     var updated=$('#back-user').datagrid('getChanges','updated');//将更新的数据赋值给updated
			    //新增用户
			  			    
			    if(updated.length>0){
			    var updategood=updated[0];
							    $.ajax({
									type:'POST',
									url:'Model_update',
									data:{
										//以这种形式传id
								    mid:updategood.id,
							        modelName:updategood.canvasName,
							        price:updategood.price,
							        //把更新的数据传到后台
								    },
								   
								beforeSend:function(){
									$('#back-modelCategory').datagrid('loading');
								},
								success:function(data){
									if(data){
										$('#back-user').datagrid('loaded');
										$('#back-user').datagrid('load');
										$('#back-user').datagrid('unselectAll');
										$.messager.show({
				                              title:'提示',
				                              msg:'已被修改!',
											});
									}
								},
							});
			       }			    
						    $('#submi,#redo').hide();
						    editorRow=undefined;
			    },	
	  });
});
</script>
</head>
<body>
	<table id="back-user"></table>
	<div id="tb">
		<div style="padding: 5px;">

			<!--  <a
				id="save" href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-save'" onClick="obj.save();"
				style="display: none;">保存</a> <a id="redo" href="#"
				class="easyui-linkbutton" data-options="iconCls:'icon-undo'"
				onclick="obj.redo();" style="display: none;">取消编辑</a>  -->
			serialNumber<select class="easyui-textbox" id="serialNumber"
				name="serialNumber" data-options="iconCls:'icon-search'"
				style="width: 180px" prompt="请输入你要查询的用户名"></select> price<select
				class="easyui-textbox" id="price" name="price"
				data-options="iconCls:'icon-search'" style="width: 180px"
				prompt="请输入你要查询的用户名">
			</select>model <select class="easyui-textbox" id="model" name="model"
				data-options="iconCls:'icon-search'" style="width: 180px"
				prompt="请输入你要查询的用户名"></select>builder <select class="easyui-textbox"
				id="builder" name="builder" data-options="iconCls:'icon-search'"
				style="width: 180px" prompt="请输入你要查询的用户名"></select>type <select
				class="easyui-textbox" id="type" name="type"
				data-options="iconCls:'icon-search'" style="width: 180px"
				prompt="请输入你要查询的用户名"></select>backWood<select class="easyui-textbox"
				id="backWood" name="backWood" data-options="iconCls:'icon-search'"
				style="width: 180px" prompt="请输入你要查询的用户名"></select>topWood<select
				class="easyui-textbox" id="topWood" name="topWood"
				data-options="iconCls:'icon-search'" style="width: 180px"
				prompt="请输入你要查询的用户名"></select>
			<button id="btn" class="easyui-linkbutton"
				data-options="iconCls:'icon-search'" onClick="search()">查询</button>


		</div>

	</div>
	<div id="back-modelCategory"></div>

	<div id="win"
		data-options="collapsible:false,minimizable:false,maximizable:false,modal:true"></div>
	<div id="edit" class="easyui-window" title="权限修改"
		style="width: 600px; height: 400px"
		data-options="iconCls:'icon-save',modal:true">
		<form id="editrole" action="">
			<input id="name" class="easyui-textbox"
				data-options="iconCls:'icon-search'" style="width: 300px" readonly>
			<input id="cc" class="easyui-combobox" name="dept"
				data-options="valueField:'id',textField:'text',url:'role_queryAllCombo'" />
		</form>
	</div>

</body>
</html>