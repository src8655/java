<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <div class="view_qna_write">
  	<div class="view_qna_write_h"><h1>여행리뷰 작성</h1></div>
  	<form action="mypage_review_post.o" method="post" id="review_write_form">
  		<input type="hidden" name="pages" value="${pages}" />
  		<input type="hidden" name="no" value="${no}" />
	  	<table cellspacing="0" cellpadding="5" border="0" style="width:95%;margin:0 auto;margin-top:15px;margin-bottom:15px;">
	  		<col width="70px" />
	  		<col width="50px" />
	  		<col width="200px" />
	  		<tr>
	  			<th style="border-top:1px solid #b9b9b9;">예약상품</th>
	  			<td style="border-top:1px solid #e7e7e7;text-align:center;width:90px;">
	  				<img src="./upload/${rdata.file1}" alt="pre" width="80px" height="80px" />
	  			</td>
	  			<td style="border-top:1px solid #e7e7e7;" colspan="3">
	  				${rdata.subject}
	  			</td>
	  		</tr>
	  		<tr>
	  			<th>여행상품평가</th>
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
	  			<th>후기</th>
	  			<td colspan="4">
	  				<textarea name="memo"></textarea>
	  			</td>
	  		</tr>
	  	</table>
	  	<div class="view_qna_write_b">
	  		<a href="#10" class="view_qna_write_btn1" onclick="review_write_form.submit();">등록</a>
	  		<a href="#10" class="view_qna_write_btn2" onclick="returnValue2('0');">취소</a>
	  	</div>
  	</form>
  </div>