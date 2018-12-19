<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  	</div>
  	<div class="contents_color">

  	<form action="admin_list_edit_post.o" method="post" enctype="multipart/form-data" id="tour_write_form">
  	<input type="hidden" name="no" value="${ldata.no}" />
  	<input type="hidden" name="pages" value="${pages}" />
  	<input type="hidden" name="searchs" value="${searchs}" />
  	<input type="file" name="file1" id="file1" onchange="change_img('file1_img', this);" style="display:none;" />
	<div class="tour_view_bg">
		<h1><input type="text" name="subject" class="tour_write_input" placeholder="상품명을 입력하세요." style="width:1096px;" value="${ldata.subject}" /></h1>
		<div class="tour_view">
			<div class="tour_view_l">
				<a href="#100" onclick="open_file('file1');">
					<img src="./upload/${ldata.file1}" width="325px" height="219px" id="file1_img" alt="대표이미지" />
				</a>
				<p>
					<textarea rows="100" cols="100" name="memo1" id="memo1" class="tour_write_textarea1" editable="0">${ldata.memo1}</textarea>
				</p>
			</div>
			<div class="tour_view_r">
				<div class="tour_view_l">
					<p><span style="font-weight:bold;">카테고리</span></p>
					<p>
						<select name="categorys" class="tour_write_input">
							<option value="-1">선택하세요</option>
							<option value="1" <c:if test="${ldata.category eq 1}">selected</c:if>>국내여행</option>
							<option value="2" <c:if test="${ldata.category eq 2}">selected</c:if>>중국/몽골</option>
							<option value="3" <c:if test="${ldata.category eq 3}">selected</c:if>>동남아</option>
							<option value="4" <c:if test="${ldata.category eq 4}">selected</c:if>>괌/사이판</option>
							<option value="5" <c:if test="${ldata.category eq 5}">selected</c:if>>남태평양</option>
							<option value="6" <c:if test="${ldata.category eq 6}">selected</c:if>>미주/중남미</option>
							<option value="7" <c:if test="${ldata.category eq 7}">selected</c:if>>유럽/중동</option>
						</select>
					</p>
					<p><span style="font-weight:bold;">여행도시</span></p>
					<p><input type="text" name="city" class="tour_write_input" placeholder="여행도시를 입력하세요." value="${ldata.city}" /></p>
					<p><span style="font-weight:bold;">여행기간</span></p>
					<p><input type="text" name="days" class="tour_write_input" placeholder="여행기간을 입력하세요." value="${ldata.days}" /></p>
					<p><span style="font-weight:bold;">항공사명</span></p>
					<p><input type="text" name="air" class="tour_write_input" placeholder="항공사명을 입력하세요." value="${ldata.air}" /></p>
					<p><span style="font-weight:bold;">금액</span></p>
					<p><input type="text" name="money" class="tour_write_input" placeholder="금액을 입력하세요." value="${ldata.money}" /></p>
				</div>
			</div>
		</div>
		
<script type="text/javascript" src="./alditor/alditor2.js"></script>
		<div class="tour_view_contents">
			<textarea rows="100" cols="100" name="memo2" id="memo2" class="tour_write_textarea">${ldata.memo2}</textarea>
		</div>
	</div>
  	</form>
  	<div class="bottom_btn">
		<a href="#100" onclick="tour_write_form.submit();">수정하기</a>
	</div>

