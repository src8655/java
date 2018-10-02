<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="basket_top">
	<h1 style="width:400px;">
		<div><img src="./images/basket.jpg" alt="장바구니" /></div>
		<p>판매상품 수정</p>
	</h1>
</div>

<form action="edit_post.o" method="post" enctype="multipart/form-data" name="userinput" onsubmit="return checkIt(this)">
<input type="file" name="file1" id="file1" onchange="change_img('file1_img', this);" class="hides" />
<input type="file" name="file2" id="file2" onchange="change_img('file2_img', this);" class="hides" />
<input type="file" name="file3" id="file3" onchange="change_img('file3_img', this);" class="hides" />
<input type="file" name="file4" id="file4" onchange="change_img('file4_img', this);" class="hides" />
<input type="file" name="file5" id="file5" onchange="change_img('file5_img', this);" class="hides" />
<input type="hidden" name="no" value="${ldata.no}" />
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
		    <option value="1" <c:if test="${ldata.category eq 1}">selected</c:if>>쌀/잡곡</option>
		    <option value="2" <c:if test="${ldata.category eq 2}">selected</c:if>>과일/채소</option>
		    <option value="3" <c:if test="${ldata.category eq 3}">selected</c:if>>축산물</option>
		    <option value="4" <c:if test="${ldata.category eq 4}">selected</c:if>>건강식품</option>
		    <option value="5" <c:if test="${ldata.category eq 5}">selected</c:if>>가공식품</option>
		    <option value="6" <c:if test="${ldata.category eq 6}">selected</c:if>>수산물</option>
		    <option value="7" <c:if test="${ldata.category eq 7}">selected</c:if>>김치/장류</option>
		    <option value="8" <c:if test="${ldata.category eq 8}">selected</c:if>>공예/공산품</option>
		  </select>
		</th>
	</tr>
	<tr>
	  <td rowspan="6" align="center">
	  	<c:if test="${ldata.file1 ne null}">
			<img src="./upload/${ldata.file1}" width="380px;" height="380px" id="file1_img" alt="대표이미지" />
		    <div class="edit_del_checkbox" style="width:380px;">
				<input type="checkbox" name="file_del1" id="file_del1" />
				<label for="file_del1"></label>
				<p>사진삭제</p>
			</div>
		</c:if>
		<c:if test="${ldata.file1 eq null}">
	    <a href="#100" onclick="open_file('file1');">
	      <img src="./images/x380.jpg" width="380px;" height="380px" id="file1_img" alt="대표이미지" />
	    </a>
	    </c:if>
	  </td>
		<th style="background:#d5e9ff;">제품명</th>
		<th style="padding:0 0 0 3px;" align="left"><input type="text" name="name" style="width:98%;" value="${ldata.name}" /></th>
	</tr>
	<tr>
		<th style="background:#d5e9ff;border:none;border-bottom:1px solid #A0A0A0;">판매금액</th>
		<td style="padding:0 0 0 3px;"><input type="text" name="money" value="${ldata.money}" /></td>
	</tr>
	<tr>
		<th style="background:#d5e9ff;border:none;border-bottom:1px solid #A0A0A0;">할인율</th>
		<td style="padding:0 0 0 3px;"><input type="text" name="discount" value="${ldata.discount}" /></td>
	</tr>
	<tr>
		<th style="background:#d5e9ff;border:none;border-bottom:1px solid #A0A0A0;">원산지</th>
		<td style="padding:0 0 0 3px;"><input type="text" name="made" value="${ldata.made}" /></td>
	</tr>
	<tr>
		<th style="background:#d5e9ff;border:none;border-bottom:1px solid #A0A0A0;">배송비용</th>
		<td style="padding:0 0 0 3px;"><input type="text" name="ship_money" value="${ldata.ship_money}" /> (0원일 경우 무료배송)</td>
	</tr>
	<tr>
		<th style="background:#d5e9ff;border:none;border-bottom:1px solid #A0A0A0;">택배회사</th>
		<td style="padding:0 0 0 3px;">
		  <select name="ship_company" class="selects">
		    <option value="CJ대한통운" <c:if test="${ship_company eq 1}">selected</c:if>>CJ대한통운</option>
		    <option value="우체국택배" <c:if test="${ship_company eq 2}">selected</c:if>>우체국택배</option>
		    <option value="한진택배" <c:if test="${ship_company eq 3}">selected</c:if>>한진택배</option>
		    <option value="로젠택배" <c:if test="${ship_company eq 4}">selected</c:if>>로젠택배</option>
		    <option value="CVSnet편의점" <c:if test="${ship_company eq 5}">selected</c:if>>CVSnet편의점</option>
		  </select>
		</td>
	</tr>
	<tr>
	  <td colspan="3" class="file_img_btn">
	  	<c:if test="${ldata.file2 ne null}">
	  	<a>
			<div class="file_img_bg"><img src="./upload/${ldata.file2}" width="235px;" id="file2_img" alt="이미지1" /></div>
		  	<div class="edit_del_checkbox" style="width:235px;">
				<input type="checkbox" name="file_del2" id="file_del2" />
				<label for="file_del2"></label>
				<p>사진삭제</p>
			</div>
		</a>
		</c:if>
		<c:if test="${ldata.file2 eq null}">
		    <a href="#100" onclick="open_file('file2');">
		      <div class="file_img_bg"><img src="./images/file.jpg" width="235px;" id="file2_img" alt="이미지1" /></div>
		    </a>
		</c:if>
		<c:if test="${ldata.file3 ne null}">
	  	<a>
			<div class="file_img_bg"><img src="./upload/${ldata.file3}" width="235px;" id="file2_img" alt="이미지1" /></div>
		  	<div class="edit_del_checkbox" style="width:235px;">
				<input type="checkbox" name="file_del3" id="file_del3" />
				<label for="file_del3"></label>
				<p>사진삭제</p>
			</div>
		</a>
		</c:if>
		<c:if test="${ldata.file3 eq null}">
	    <a href="#100" onclick="open_file('file3');">
	      <div class="file_img_bg"><img src="./images/file.jpg" width="235px;" id="file3_img" alt="이미지1" /></div>
	    </a>
		</c:if>
		<c:if test="${ldata.file4 ne null}">
	  	<a>
			<div class="file_img_bg"><img src="./upload/${ldata.file4}" width="235px;" id="file2_img" alt="이미지1" /></div>
		  	<div class="edit_del_checkbox" style="width:235px;">
				<input type="checkbox" name="file_del4" id="file_del4" />
				<label for="file_del4"></label>
				<p>사진삭제</p>
			</div>
		</a>
		</c:if>
		<c:if test="${ldata.file4 eq null}">
	    <a href="#100" onclick="open_file('file4');">
	      <div class="file_img_bg"><img src="./images/file.jpg" width="235px;" id="file4_img" alt="이미지1" /></div>
	    </a>
		</c:if>
		<c:if test="${ldata.file5 ne null}">
	  	<a>
			<div class="file_img_bg"><img src="./upload/${ldata.file5}" width="235px;" id="file2_img" alt="이미지1" /></div>
		  	<div class="edit_del_checkbox" style="width:235px;">
				<input type="checkbox" name="file_del5" id="file_del5" />
				<label for="file_del5"></label>
				<p>사진삭제</p>
			</div>
		</a>
		</c:if>
		<c:if test="${ldata.file5 eq null}">
	    <a href="#100" onclick="open_file('file5');">
	      <div class="file_img_bg"><img src="./images/file.jpg" width="235px;" id="file5_img" alt="이미지1" /></div>
	    </a>
		</c:if>
	  </td>
	</tr>
	
	<tr>
		<td align="center" colspan="3">
			<textarea name="memo" rows="100" cols="100" class="b_memo" id="memo">${ldata.memo}</textarea>
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
	<a href="#100" onclick="userinput.submit();">수정하기</a>
	<a href="#100" onclick="location.href='mypage_list.o'" style="margin-right:10px;">목록보기</a>
</div>
</form>


