<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title" /></title>
<script src="../jquery.js"></script>
<script src="../ckeditor/ckeditor.js"></script>
<style type="text/css">
body {
font-family:'돋움';
margin:0px;
padding:0px;
font-size:12px;
}
.comments {
width:100%;
padding:10px;
margin:10px 0 0 0;
border-collapse:collapse;
}
.comments tr th {
border-top:1px solid #122942;
}
.comments tr td {
border:1px solid #bbbbbb;
}
.comments input {
background:#ffffff;
width:98%;
height:20px;
line-height:20px;
border:1px solid #cccccc;
font-size:15px;
}
.comments textarea {
width:99%;
font-size:15px;
}
.comments a {
font-size:12px;
color:#676767;
text-decoration:none;
}
.boards {
font-size:12px;
width:100%;
margin:0px;
border-collapse:collapse;
}
.boards th {
border-top:2px solid #122942;
border-bottom:1px solid #A0A0A0;
height:35px;
line-height:35px;
margin:0px;
padding:0px;
}
.boards td {
border-bottom:1px solid #A0A0A0;
padding:10px 3px 10px 3px;
}
.boards td a {
text-decoration:none;
color:#000000;
}
.boards_b {
width:100%;
height:26px;
margin:10px 0 0 0;
padding:0px;
overflow:hidden;
}
.boards_bl {
width:30%;
float:left;
text-align:left;
overflow:hidden;
}
.boards_br {
width:30%;
float:right;
text-align:right;
overflow:hidden;
}
.boards_bc {
width:40%;
height:26px;
line-height:26px;
float:left;
text-align:center;
overflow:hidden;
}
.boards_bc a {
text-decoration:none;
color:#000000;
margin:0 3px 0 0;
}
.boards input {
border:1px solid #cccccc;
width:150px;
height:25px;
line-height:25px;
font-size:15px;
margin:0px;
padding:0px;
overflow:hidden;
}
.btn_st {
border:0px;
border-radius:5px;
background:#666666;
color:#ffffff;
padding:0px;
width:83px;
height:24px;
line-height:24px;
text-decoration:none;
display:block;
font-size:12px;
text-align:center;
font-weight:bold;
overflow:hidden;
}
.b_memo {
border:1px solid #cccccc;
width:99%;
height:200px;
font-size:15px;
margin:0px;
padding:0px;
}
</style>

<script type="text/javascript">
function showhide(var1) {
	if(document.getElementById(var1).style.display == "none")
		document.getElementById(var1).style.display = "";
	else
		document.getElementById(var1).style.display = "none";
}


//decodeURIComponent
$(function(){
	//$("#search_btn").click(function(){
		
	$("#search_value").bind('keyup',function(e){
		$.ajax({
			url:'ajax_test2.do',
			method:'GET',
			datatype : "json",
			contentType: "application/json; charset=utf-8",
			data:{
				search_value:$("#search_value").val()
			},
			success:function(result){
				//alert(result);
				//alert(Object.keys(result.list).length);
				if($("#search_value").val() == "")
					$("#search_resultsss").html("");
				else{
					var htmls = "";
					var list_length = Object.keys(result).length;
					htmls += '<table cellpadding="7" cellspacing="0" class="boards">';
					htmls += '<col width="60" /><col width="240" /><col width="70" /><col width="70" /><col width="60" />';
					htmls += '<tr><td colspan="5"></td></tr>';
					var i=0;
					for(i=0;i<list_length;i++) {
						htmls += '<tr>';
						var ldata = result[i];
						htmls += '<td align="center">'+(i+1)+'</td>';
						htmls += '<td><a href="board_view.do?pages=${pages}&amp;no='+ldata.no+'&lang=${lang}">'+ldata.subject+'</a></td>';
						htmls += '<td align="center">'+ldata.name+'</td>';
						htmls += '<td align="center">'+ldata.dates+'</td>';
						htmls += '<td align="center">'+ldata.hit+'</td>';
						htmls += '</tr>';
					}
					htmls += '</table>';
					$("#search_resultsss").html(htmls);
				}
			},
			error:function(r,s,e) {
				alert('error');
			}
		});
	});
});
</script>
</head>
<body>

<div style="width:700px;margin:0 auto;overflow:hidden;">
<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="body" />
<tiles:insertAttribute name="footer" />
</div>

</body>
</html>