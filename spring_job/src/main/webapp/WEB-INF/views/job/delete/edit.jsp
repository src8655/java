<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container">
  <div class="row">
    <div class="col-sm-1 col-md-2 col-lg-2"></div>
    <div class="col-sm-10 col-md-8 col-lg-8 align-center">
    
    
    
    
    
    
    
    <div class="login_box" id="join_01">
      <h1>기업정보 관리</h1>
      <form action="edit_post.o" method="post" enctype="multipart/form-data" onsubmit="return edit_submit(this);">
      	<input type="hidden" name="member_no" value="${cdata.member_no}" />
      	<input type="hidden" name="pages" value="${pages}" />
      	<input type="hidden" name="searchValue" value="${searchValue_utf}" />
      	<input type="file" name="files1" id="edit_file1" style="display:none;" onchange="change_img('edit_file1_img', this);" />
      	<input type="file" name="files2" id="edit_file2" style="display:none;" onchange="change_img('edit_file2_img', this);" />
      	<div class="join_quest">
        <div class="join_quest" style="width:102px;float:left;">
          <h4>회사로고</h4>
          <a href="#100" onclick="open_file('edit_file1');">
          	<c:if test="${cdata.file1 eq ''}"><img src="./images/company_logo.jpg" width="100px" height="100px" alt="logo" id="edit_file1_img" class="edit_imgs" /></c:if>
          	<c:if test="${cdata.file1 ne ''}"><img src="./upload/${cdata.file1}" width="100px" height="100px" alt="logo" id="edit_file1_img" class="edit_imgs" /></c:if>
          </a>
        </div>
        <div class="join_quest" style="width:202px;float:left;">
          <h4>회사배경</h4>
          <a href="#100" onclick="open_file('edit_file2');">
            <c:if test="${cdata.file2 eq ''}"><img src="./images/office_bk2.jpg" width="200px" height="100px" alt="logo" id="edit_file2_img" class="edit_imgs" /></c:if>
          	<c:if test="${cdata.file2 ne ''}"><img src="./upload/${cdata.file2}" width="200px" height="100px" alt="office_bg" id="edit_file2_img" class="edit_imgs" /></c:if>
          </a>
        </div>
        </div>
        <input type="text" name="name" placeholder="대표" value="${cdata.name}" class="login_input" onchange="name_edit_check(this);" />
        <div id="name_edit_msg" class="join_msg"></div>
        <input type="text" name="founding" placeholder="설립일 2000-00-00" value="${cdata.founding}" class="login_input" onchange="founding_edit_check(this);" />
        <div id="founding_edit_msg" class="join_msg"></div>
        <input type="text" name="count" placeholder="사원수 0,000명(2018)" value="${cdata.count}" class="login_input" onchange="count_edit_check(this);" />
        <div id="count_edit_msg" class="join_msg"></div>
        <input type="text" name="money" placeholder="매출액 0,000원(2018)" value="${cdata.money}" class="login_input" onchange="money_edit_check(this);" />
        <div id="money_edit_msg" class="join_msg"></div>
        <input type="text" name="url" placeholder="웹사이트" class="login_input" value="${cdata.url}" onchange="url_edit_check(this);" />
        <div id="url_edit_msg" class="join_msg"></div>
        <input type="text" name="addr" placeholder="본사" class="login_input" value="${cdata.addr}" onchange="addr_edit_check(this);" />
        <div id="addr_edit_msg" class="join_msg"></div>
        <div class="join_quest">
          <h4>기업형태</h4>
          <select name="company_type" class="join_select" onchange="company_type_edit_check(this);">
  			<option value="-1">선택</option>
  			<option value="1" <c:if test="${cdata.company_type eq 1}">selected</c:if>>대기업</option>
  			<option value="2" <c:if test="${cdata.company_type eq 2}">selected</c:if>>중소기업</option>
  			<option value="3" <c:if test="${cdata.company_type eq 3}">selected</c:if>>벤처기업</option>
  			</select>
        	<div id="company_type_edit_msg" class="join_msg"></div>
        </div>
        <div class="join_quest">
          <h4>기업설명</h4>
          <textarea rows="100" cols="100" class="edit_textarea" name="info">${cdata.info}</textarea>
        </div>
        
        <input type="submit" value="수정완료" class="login_btn" />
      </form>
    </div>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    </div>
    <div class="col-sm-1 col-md-2 col-lg-2"></div>
  </div>
</div>