<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="basket_top">
	<h1 style="width:400px;">
		<div><img src="./images/basket.jpg" alt="장바구니" /></div>
		<p>판매상품 등록</p>
	</h1>
</div>

<form action="write_post.o" method="post" enctype="multipart/form-data" name="userinput" onsubmit="return checkIt(this)">
<input type="file" name="files" id="file1" onchange="change_img('file1_img', this);" class="hides" />
<input type="file" name="files" id="file2" onchange="change_img('file2_img', this);" class="hides" />
<input type="file" name="files" id="file3" onchange="change_img('file3_img', this);" class="hides" />
<input type="file" name="files" id="file4" onchange="change_img('file4_img', this);" class="hides" />
<input type="file" name="files" id="file5" onchange="change_img('file5_img', this);" class="hides" />
<input type="hidden" name="seller" value="${member_info.no}" />
<table cellpadding="7" cellspacing="0" class="boards">
<col width="400px" />
<col width="200" />
<col width="410" />
	<tr>
	  <th>대표 이미지</th>
		<th style="background:#d5e9ff;">카테고리</th>
		<th colspan="2" style="padding:0 0 0 3px;" align="left">
		  <select name="category" class="selects">
		    <option value="1">쌀/잡곡</option>
		    <option value="2">과일/채소</option>
		    <option value="3">축산물</option>
		    <option value="4">건강식품</option>
		    <option value="5">가공식품</option>
		    <option value="6">수산물</option>
		    <option value="7">김치/장류</option>
		    <option value="8">공예/공산품</option>
		  </select>
		</th>
	</tr>
	<tr>
	  <td rowspan="6" align="center">
	    <a href="#100" onclick="open_file('file1');">
	      <img src="./images/x380.jpg" width="380px;" height="380px" id="file1_img" alt="대표이미지" />
	    </a>
	  </td>
		<th style="background:#d5e9ff;">제품명</th>
		<th style="padding:0 0 0 3px;" align="left"><input type="text" name="name" style="width:98%;" /></th>
	</tr>
	<tr>
		<th style="background:#d5e9ff;border:none;border-bottom:1px solid #A0A0A0;">판매금액</th>
		<td style="padding:0 0 0 3px;"><input type="text" name="money" value="0" /></td>
	</tr>
	<tr>
		<th style="background:#d5e9ff;border:none;border-bottom:1px solid #A0A0A0;">할인율</th>
		<td style="padding:0 0 0 3px;"><input type="text" name="discount" value="0" /></td>
	</tr>
	<tr>
		<th style="background:#d5e9ff;border:none;border-bottom:1px solid #A0A0A0;">원산지</th>
		<td style="padding:0 0 0 3px;"><input type="text" name="made" /></td>
	</tr>
	<tr>
		<th style="background:#d5e9ff;border:none;border-bottom:1px solid #A0A0A0;">배송비용</th>
		<td style="padding:0 0 0 3px;"><input type="text" name="ship_money" value="0" /> (0원일 경우 무료배송)</td>
	</tr>
	<tr>
		<th style="background:#d5e9ff;border:none;border-bottom:1px solid #A0A0A0;">택배회사</th>
		<td style="padding:0 0 0 3px;">
		  <select name="ship_company" class="selects">
		    <option value="CJ대한통운">CJ대한통운</option>
		    <option value="우체국택배">우체국택배</option>
		    <option value="한진택배">한진택배</option>
		    <option value="로젠택배">로젠택배</option>
		    <option value="CVSnet편의점">CVSnet편의점</option>
		  </select>
		</td>
	</tr>
	<tr>
	  <td colspan="3" class="file_img_btn">
	    <a href="#100" onclick="open_file('file2');">
	      <div class="file_img_bg"><img src="./images/file.jpg" width="235px;" id="file2_img" alt="이미지1" /></div>
	    </a>
	    <a href="#100" onclick="open_file('file3');">
	      <div class="file_img_bg"><img src="./images/file.jpg" width="235px;" id="file3_img" alt="이미지1" /></div>
	    </a>
	    <a href="#100" onclick="open_file('file4');">
	      <div class="file_img_bg"><img src="./images/file.jpg" width="235px;" id="file4_img" alt="이미지1" /></div>
	    </a>
	    <a href="#100" onclick="open_file('file5');">
	      <div class="file_img_bg"><img src="./images/file.jpg" width="235px;" id="file5_img" alt="이미지1" /></div>
	    </a>
	  </td>
	</tr>
	
	<tr>
		<td align="center" colspan="3">
			<textarea name="memo" rows="100" cols="100" class="b_memo" id="memo"></textarea>
			<script>
        CKEDITOR.replace( 'memo', {
    	    uiColor : '#d5e9ff',
    	    height : 350
        });
      </script>
		</td>
	</tr>
</table>
<div class="basket_b">
	<a href="#100" onclick="userinput.submit();">등록하기</a>
	<a href="#100" onclick="location.href='mypage_list.o'" style="margin-right:10px;">목록보기</a>
</div>
</form>

