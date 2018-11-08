<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <div class="view_qna_write">
  	<div class="view_qna_write_h"><h1>문의내용 작성</h1></div>
  	<form action="view_qna_write_post.o" method="post" id="view_qna_write_form">
  		<input type="hidden" name="product_no" value="${no}" />
  		<input type="hidden" name="sellers_no2" value="${sellers_no}" />
	  	<table cellspacing="0" cellpadding="5" border="0">
	  		<col width="100px" />
	  		<col width="500px" />
	  		<tr>
	  			<th style="border-top:1px solid #b9b9b9;">문의유형</th>
	  			<td style="border-top:1px solid #e7e7e7;">
	  				<input type="radio" name="category" value="1" id="category1" />
	  				<label for="category1">상품</label>
	  				<input type="radio" name="category" value="2" id="category2" />
	  				<label for="category2">배송</label>
	  				<input type="radio" name="category" value="3" id="category3" />
	  				<label for="category3">반품/취소</label>
	  				<input type="radio" name="category" value="4" id="category4" />
	  				<label for="category4">교환/변경</label>
	  				<input type="radio" name="category" value="5" id="category5" />
	  				<label for="category5">기타</label>
	  			</td>
	  		</tr>
	  		<tr>
	  			<th>내용</th>
	  			<td>
	  				<textarea name="memo"></textarea>
	  			</td>
	  		</tr>
	  		<tr>
	  			<td colspan="2">
	  				<input type="checkbox" name="secret" value="1" id="secret" />
	  				<label for="secret">비밀글로 문의하기</label>
	  			</td>
	  		</tr>
	  	</table>
	  	<div class="view_qna_write_b">
	  		<a href="#10" class="view_qna_write_btn1" onclick="view_qna_write_form.submit();">등록</a>
	  		<a href="#10" class="view_qna_write_btn2" onclick="returnValue3('0');">취소</a>
	  	</div>
  	</form>
  </div>