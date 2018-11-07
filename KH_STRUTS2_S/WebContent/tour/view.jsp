<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>





<script type="text/javascript">
<c:forEach items="${list}" var="lrdata">
var times_${lrdata.no} = ${lrdata.times_tmp};
function settime_${lrdata.no}() {
	var times_data = times_${lrdata.no};
	var times_second = times_data%60;		//초
	times_data = Math.floor(times_data/60);
	var times_minute = times_data%60;		//분
	times_data = Math.floor(times_data/60);
	var times_hour = times_data%24;			//시
	times_data = Math.floor(times_data/24);

	if(times_second < 10) times_second = "0"+times_second;
	if(times_minute < 10) times_minute = "0"+times_minute;
	if(times_hour < 10) times_hour = "0"+times_hour;
	
	document.getElementById("left_time_${lrdata.no}").innerHTML = "<span style='font-weight:bold;'>"+times_data+"</span> 일 <span style='font-weight:bold;'>"+times_hour+":"+times_minute+":"+times_second+"</span>";
	times_${lrdata.no} = times_${lrdata.no} - 1;
	setTimeout ("settime_${lrdata.no}();", 1000); 
}
</c:forEach>
function timers() {
	<c:forEach items="${list}" var="lrdata">
	settime_${lrdata.no}();
	</c:forEach>
}
</script>

  	</div>
  	<div class="contents_color">
  	<!--  -->
  	

	<div class="tour_view_bg">
		<h1>${ldata.subject}</h1>
		<div class="tour_view">
			<div class="tour_view_l">
				<img src="./upload/${ldata.file1}" alt="imgs" width="325px" height="219px" />
				<p><span style="font-weight:bold;">상품번호</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${ldata.no}</p>
				<p><span style="font-weight:bold;">여행도시</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${ldata.city}</p>
				<p><span style="font-weight:bold;">여행기간</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${ldata.days}일</p>
				<p><span style="font-weight:bold;">항공사명</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${ldata.air}</p>
				<p style="line-height:20px;">
					${ldata.memo1}
				</p>
			</div>
			<div class="tour_view_r">
				<table cellspacing="0" cellpadding="0" border="0">
				<col width="130px" />
				<col width="290px" />
				<col width="85px" />
				<col width="115px" />
				<col width="70px" />
					<tr>
						<th>출발/도착일</th>
						<th>상품명<c:if test="${level eq 3}">/마감시간</c:if></th>
						<th>인원선택</th>
						<th>상품가격</th>
						<th>담기</th>
					</tr>
					<c:if test="${level eq 3}">
					<tr>
						<form action="admin_list_reserve_post.o" method="post">
							<input type="hidden" name="list_no" value="${ldata.no}" />
							<input type="hidden" name="category" value="${category}" />
							<input type="hidden" name="searchs" value="${searchs}" />
								<td>
									<input type="date" name="startdates" class="tour_view_input" /><br />
									<input type="date" name="enddates" class="tour_view_input" />
								</td>
								<td>
									<input type="text" name="subject" class="tour_view_input" /><br />
									<input type="datetime-local" name="endtimes" class="tour_view_input" placeholder="마감일 0000-00-00T00:00" />
								</td>
								<td><input type="text" name="max_cnts" class="tour_view_input" /></td>
								<td>
									<input type="text" name="money" class="tour_view_input" /><br />
									<input type="checkbox" name="special" id="special" value="1" /><label for="special">특가상품</label>
								</td>
								<td><input type="submit" value="등록" class="tour_view_btn" /></td>
						</form>
					</tr>
					</c:if>
  					<c:forEach items="${list}" var="lrdata">
					<tr>
					<form action="basket_add.o" method="post" id="lr_form_${lrdata.no}">
					<input type="hidden" name="no" value="${lrdata.no}" />
						<td>
							<div class="left_time" id="left_time_${lrdata.no}"></div>
							<span style="color:#297fb8;font-weight:bold;">${lrdata.startdates}</span><br /><span style="font-weight:bold;">${lrdata.enddates}</span>
						</td>
						<td style="text-align:left;height:50px;">
						<c:if test="${lrdata.special eq 1}"><span style="font-weight:bold;color:red;">[!특가!]</span></c:if>
						${lrdata.subject}
						</td>
						<td>
							<select name="max_cnts">
								<c:forEach begin="1" end="${lrdata.max_cnts}" step="1" var="i">
								<option value="${i}">${i}명</option>
								</c:forEach>
							</select>
						</td>
						<td><span style="color:#ed4949;font-weight:bold;">${lrdata.moneys}원</span></td>
						<td>
							<a href="#100" onclick="lr_form_${lrdata.no}.submit();"><img src="./images/cart.jpg" alt="카트에 담기" /></a>
							<c:if test="${level eq 3}">
							<a href="admin_list_reserve_del.o?no=${lrdata.no}&list_no=${no}&pages=${pages}&searchs=${searchs_utf}&category=${category}"><img src="./images/del.jpg" alt="삭제" /></a>
							</c:if>
						</td>
					</form>
					</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		  <ul class="view_tab">
			  <li><a href="#10" id="v_t_m1" <c:if test="${tab eq 1}">class="view_tab_li_a_hover"</c:if> <c:if test="${tab ne 1}">class="view_tab_li_a"</c:if> onclick="tour_tab(this,'tour_view_tab1');">상품정보</a></li>
			  <li><a href="#10" id="v_t_m2" <c:if test="${tab eq 2}">class="view_tab_li_a_hover"</c:if> <c:if test="${tab ne 2}">class="view_tab_li_a"</c:if> onclick="tour_tab(this,'tour_view_tab2');">상품 리뷰(${paging.board_total})</a></li>
			  <li><a style="border-bottom:1px solid #bebebe;height:63px;"></a></li>
			  <li><a style="border-bottom:1px solid #bebebe;height:63px;"></a></li>
		</ul>
		<div class="tour_view_contents" id="tour_view_tab1" <c:if test="${tab ne 1}">style="display:none;"</c:if>>
			${ldata.memo2}
		</div>
		<div class="tour_view_contents" id="tour_view_tab2" <c:if test="${tab ne 2}">style="display:none;"</c:if>>
			<h1 id="tour_review_h">상품평 (${paging.board_total})</h1>
			<table cellspacing="0" cellpadding="0" border="0" class="tour_review_table">
			<col width="130px" />
			<col width="450px" />
			<col width="100px" />
			<col width="100px" />
				<tr>
					<th>평가</th>
					<th>한줄평</th>
					<th>작성일</th>
					<th>작성자</th>
				</tr>
				
				<c:forEach items="${list_review}" var="lrdata">
				<tr>
					<td>
						<c:forEach begin="1" end="${lrdata.stars}"><img src="./images/star_01.jpg" alt="별1" /></c:forEach>
						<c:forEach begin="1" end="${5-lrdata.stars}"><img src="./images/star_02.jpg" alt="별2" /></c:forEach>
					</td>
					<td style="text-align:left;">${lrdata.memo}</td>
					<td>${lrdata.dates}</td>
					<td>${lrdata.user_id}</td>
				</tr>
				</c:forEach>
				
			</table>
			
			<div class="list_page_rv">
				<a href="view.o?pages_rv=1&amp;searchs=${searchs_utf}&category=${category}&no=${no}&tab=2&pages=${pages}" class="list_page_a_rv">&lt;</a>
				<c:forEach begin="${paging.pstarts}" end="${paging.pends}" step="1" var="i">
					<a href="view.o?pages_rv=${i}&amp;searchs=${searchs_utf}&category=${category}&no=${no}&tab=2&pages=${pages}" <c:if test="${i ne pages_rv}"> class="list_page_a_rv"</c:if> <c:if test="${i eq pages_rv}"> class="list_page_a_hover_rv"</c:if>>${i}</a>
				</c:forEach>
				<a href="view.o?pages_rv=${paging.board_paging}&amp;searchs=${searchs_utf}&category=${category}&no=${no}&tab=2&pages=${pages}" class="list_page_a_rv">&gt;</a>
			</div>
	
		</div>
	</div>
	
  	<!--  -->
