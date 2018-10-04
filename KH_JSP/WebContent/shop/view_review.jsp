<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <div class="view_qna_write">
  	<div class="view_qna_write_h"><h1>상품리뷰 작성</h1></div>
  	<form action="view_review_post.o" method="post" id="view_qna_write_form">
  		<input type="hidden" name="pages" value="${pages}" />
  		<input type="hidden" name="product_no" value="${product_no}" />
  		<input type="hidden" name="no" value="${no}" />
	  	<table cellspacing="0" cellpadding="5" border="0" style="width:95%;margin:0 auto;margin-top:15px;margin-bottom:15px;">
	  		<col width="100px" />
	  		<col width="100px" />
	  		<col width="100px" />
	  		<col width="100px" />
	  		<col width="100px" />
	  		<tr>
	  			<th style="border-top:1px solid #b9b9b9;">구매상품</th>
	  			<td style="border-top:1px solid #e7e7e7;text-align:center;">
	  				<img src="./upload/${ldata.file1}" alt="pre" width="80px" height="80px" />
	  			</td>
	  			<td style="border-top:1px solid #e7e7e7;" colspan="3">
	  				${ldata.name}
	  			</td>
	  		</tr>
	  		<tr>
	  			<th>상품평가</th>
	  			<td colspan="4" class="stars_label">
	  				<input type="checkbox" id="star_img1" onchange="view_review_star(1)" /><label for="star_img1"></label>
	  				<input type="checkbox" id="star_img2" onchange="view_review_star(2)" /><label for="star_img2"></label>
	  				<input type="checkbox" id="star_img3" onchange="view_review_star(3)" /><label for="star_img3"></label>
	  				<input type="checkbox" id="star_img4" onchange="view_review_star(4)" /><label for="star_img4"></label>
	  				<input type="checkbox" id="star_img5" onchange="view_review_star(5)" /><label for="star_img5"></label>
	  				<input type="hidden" name="stars" id="stars" value="-1" />
	  			</td>
	  		</tr>
	  		<tr>
	  			<th rowspan="2">만족도평가</th>
	  			<td style="font-weight:bold;">배송속도</td>
	  			<td>
	  				<input type="radio" name="review1" id="rv1" value="별로에요" />
	  				<label for="rv1">느려요</label>
	  			</td>
	  			<td>
	  				<input type="radio" name="review1" id="rv2" value="보통이에요" />
	  				<label for="rv2">보통이에요</label>
	  			</td>
	  			<td>
	  				<input type="radio" name="review1" id="rv3" value="좋아요" />
	  				<label for="rv3">빨라요</label>
	  			</td>
	  		</tr>
	  		<tr>
	  			<td style="font-weight:bold;">상품품질</td>
	  			<td>
	  				<input type="radio" name="review2" id="rvs1" value="별로에요" />
	  				<label for="rvs1">별로에요</label>
	  			</td>
	  			<td>
	  				<input type="radio" name="review2" id="rvs2" value="보통이에요" />
	  				<label for="rvs2">보통이에요</label>
	  			</td>
	  			<td>
	  				<input type="radio" name="review2" id="rvs3" value="좋아요" />
	  				<label for="rvs3">좋아요</label>
	  			</td>
	  		</tr>
	  		<tr>
	  			<th>내용</th>
	  			<td colspan="4">
	  				<textarea name="memo"></textarea>
	  			</td>
	  		</tr>
	  	</table>
	  	<div class="view_qna_write_b">
	  		<a href="#10" class="view_qna_write_btn1" onclick="view_qna_write_form.submit();">등록</a>
	  		<a href="#10" class="view_qna_write_btn2" onclick="returnValue4('0');">취소</a>
	  	</div>
  	</form>
  </div>