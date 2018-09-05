<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="head2.jsp" %>

	<div id="noticech">
		<h1>공지사항</h1>
		<ul>
<?
$string_len = 13;   //제목 노출 글자수
while($db1 = mysql_fetch_array($rb1)) {
if($db1[id] == "free") $bname = "자유게시판";
if($db1[id] == "notice") $bname = "공지사항";
if($db1[id] == "q") $bname = "문의하기";
$dates = explode(" ",$db1[date2]);
?>
			<li>
				<a href="board_view.php?id=<?=$db1[id]?>&amp;no=<?=$db1[no]?>">
				  <span style="font-weight:bold;">[<?=$bname?>]</span>
				  <?=mb_substr($db1[subject],0,$string_len,'UTF-8')?><? if(mb_strlen($db1[subject],"UTF-8") > $string_len){?>...<? }?>
				  <? if($db1[secret] == 1) {?><img src="./images/secret.gif" alt="비밀글" /><? }?>
				  <? if($dates[0] == date("Y")."-".date("m")."-".date("d")) {?><span style="font-size:11px;color:red;">New</span><? }?></a><p>[<?=$db1[date]?>]</p>
			</li>
<?
}
?>
		</ul>
	</div>
	<div class="icons" id="icons_1">
		<a href="board_write.php?id=q">온라인문의</a>
	</div>
	<div class="icons" id="icons_2">
		<a href="map.php?id=map">오시는길</a>
	</div>
	<div class="icons" id="icons_3">
		<a href="#">전화문의</a>
	</div>
<%@ include file="foot2.jsp" %>