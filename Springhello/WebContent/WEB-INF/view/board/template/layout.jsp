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



//댓글입력 ajax
function comment_btn(var2) {
	var board_no = document.getElementById(var2).board_no.value;
	var rt_no = document.getElementById(var2).rt_no.value;
	var name = document.getElementById(var2).name.value;
	var password = document.getElementById(var2).password.value;
	var memo = document.getElementById(var2).memo.value;
	
	$.ajax({
		url:'board_comment_post_ajax.do',
		method:'GET',
		datatype : "json",
		contentType: "application/json; charset=utf-8",
		data:{
			board_no:board_no,
			rt_no:rt_no,
			name:name,
			password:password,
			memo:memo
		},
		success:function(result){
			//alert(result);
	
			if(result.map.result == false) alert(result.map.msg);
			else{
				document.getElementById(var2).name.value = "";
				document.getElementById(var2).password.value = "";
				document.getElementById(var2).memo.value = "";
				
				var list = result.map.list;
				var list_length = Object.keys(list).length;
				//alert(list_length);
				var i=0;
				$("#comment_list").html("");
				var htmls = "";
				for(i=0;i<list_length;i++) {
					var data = list[i];
					htmls += '<table cellpadding="7" cellspacing="0" class="comments">';
					htmls += '<tr>';
					htmls += '<td style="width:'+(data.levels*20)+'px;border:0px;padding:0px;overflow:hidden;"></td>';
					htmls += '<th style="width:100px;background:#d5e9ff;border:none;border:1px solid #A0A0A0;">'+data.name;
					htmls += '<span style="font-weight:normal;">';
					htmls += '<br />'+data.dates+'<br />';
					htmls += '<a href="board_comment_del.do?no='+data.no+'&amp;board_no='+data.board_no+'&amp;pages='+result.map.pages+'&amp;lang='+result.map.lang+'">[삭제]</a>';
					htmls += '<a href="#100" onclick="showhide(\'cmm'+data.no+'\')">[답글]</a>';
					htmls += '</span>';
					htmls += '</th>';
					htmls += '<td valign="top">';
					htmls += data.memo;

					htmls += '<form action="#100" id="cmm'+data.no+'" style="display:none;">';
					htmls += '<input type="hidden" name="rt_no" value="'+data.no+'" />';
					htmls += '<input type="hidden" name="board_no" value="'+data.board_no+'" />';
					htmls += '<input type="hidden" name="pages" value="'+result.map.pages+'" />';
					htmls += '<input type="hidden" name="lang" value="'+result.map.lang+'" />';
					htmls += '<table cellpadding="7" cellspacing="0" class="comments">';
					htmls += '<col width="20%" />';
					htmls += '<col width="30%" />';
					htmls += '<col width="20%" />';
					htmls += '<col width="20%" />';
					htmls += '<tr>';
					htmls += '<th style="background:#d5e9ff;border-left:1px solid #bbbbbb;">이름</th>';
					htmls += '<td style="border-top:1px solid #122942;"><input type="text" name="name" /></td>';
					htmls += '<th style="background:#d5e9ff;">비밀번호</th>';
					htmls += '<td style="border-top:1px solid #122942;" colspan="2"><input type="password" name="password" /></td>';
					htmls += '</tr>';
					htmls += '<tr>';
					htmls += '<td style="border-left:none;border-right:none;" colspan="4"><textarea name="memo" rows="100" cols="100" editable="0" style="border:1px solid #b8c0cc;width:98%;height:40px;"></textarea></td>';
					htmls += '<td style="text-align:center;width:80px;border-left:none;border-right:none;"><input type="button" value="등록" onclick="comment_btn(\'cmm'+data.no+'\')" style="background:#d5e9ff;border:1px solid #122942;width:98%;height:45px;font-size:12px;font-weight:bold;" /></td>';
					htmls += '</tr></table></form></td></tr></table>';
				}
				$("#comment_list").html(htmls);
				
			}
			
			
		},
		error:function(r,s,e) {
			alert('error');
		}
	});
}
/*
window.onload = function() {
var a = document.getElementById("search_value");
a.addEventListener("mouseover",tmp22);
}
function tmp22() {
	alert("in");
}
*/
//decodeURIComponent
$(function(){
		
	
		
		
		
		
	$("#search_value").bind('keyup',function(e){
		$.ajax({
			url:'toxml2.do',
			method:'GET',
			datatype : "xml",
			data:{
				search_value:$("#search_value").val(),
				subject:$("#search_value").val(),
				name:'ajax요청'
			},
			success:function(result){
				//alert(result);
				//alert(Object.keys(result.list).length);
				
				var list = $(result).find("list");
				if($("#search_value").val() == "")
					$("#search_resultsss").html("");
				else{
					var htmls = "";
					var list_length = $(result).find("allCount").text();
					htmls += '<table cellpadding="7" cellspacing="0" class="boards">';
					htmls += '<col width="60" /><col width="240" /><col width="70" /><col width="70" /><col width="60" />';
					htmls += '<tr><td colspan="5"></td></tr>';
					var i=0;
					for(i=0;i<list_length;i++) {
						htmls += '<tr>';
						var ldata = list[i];
						htmls += '<td align="center">'+(i+1)+'</td>';
						htmls += '<td><a href="board_view.do?pages=${pages}&amp;no='+$(ldata).find("no").text()+'&lang=${lang}">'+$(ldata).find("subject").text()+'</a></td>';
						htmls += '<td align="center">'+$(ldata).find("name").text()+'</td>';
						htmls += '<td align="center">'+$(ldata).find("dates").text()+'</td>';
						htmls += '<td align="center">'+$(ldata).find("hit").text()+'</td>';
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








//test
function ajaxs() {
	var xhr = new XMLHttpRequest();
    xhr.open('GET', 'ajax_test22.do');
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            //alert(xhr.responseText);
            var doc = JSON.parse(xhr.responseText);
            //alert(doc);
            
			var list = doc.list;
			
				var htmls = "";
				var list_length = Object.keys(list).length;
				htmls += '<table cellpadding="7" cellspacing="0" class="boards">';
				htmls += '<col width="60" /><col width="240" /><col width="70" /><col width="70" /><col width="60" />';
				htmls += '<tr><td colspan="5"></td></tr>';
				var i=0;
				for(i=0;i<list_length;i++) {
					htmls += '<tr>';
					var ldata = list[i];
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
    }
    xhr.send(); 
}
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