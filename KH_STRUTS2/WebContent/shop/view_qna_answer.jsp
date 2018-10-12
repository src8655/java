<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <div class="view_qna_write">
  	<div class="view_qna_write_h"><h1>답글 작성</h1></div>
  	<form action="view_qna_answer_post.o" method="post" id="view_qna_write_form">
  		<input type="hidden" name="product_no" value="${product_no}" />
  		<input type="hidden" name="pages" value="${pages}" />
  		<input type="hidden" name="no" value="${no}" />
	  	<table cellspacing="0" cellpadding="5" border="0">
	  		<col width="100px" />
	  		<col width="500px" />
	  		<tr>
	  			<th>답글</th>
	  			<td>
	  				<textarea name="memo"></textarea>
	  			</td>
	  		</tr>
	  	</table>
	  	<div class="view_qna_write_b">
	  		<a href="#10" class="view_qna_write_btn1" onclick="view_qna_write_form.submit();">등록</a>
	  		<a href="#10" class="view_qna_write_btn2" onclick="returnValue2('0');">취소</a>
	  	</div>
  	</form>
  </div>
