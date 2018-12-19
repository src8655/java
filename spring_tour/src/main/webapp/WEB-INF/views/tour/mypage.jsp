<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>





<script type="text/javascript">
<c:forEach items="${list}" var="rdata">
<c:if test="${rdata.status eq 1}">
var times_${rdata.no} = ${rdata.times_tmp};
function settime_${rdata.no}() {
	var times_data = times_${rdata.no};
	var times_second = times_data%60;		//초
	times_data = Math.floor(times_data/60);
	var times_minute = times_data%60;		//분
	times_data = Math.floor(times_data/60);
	var times_hour = times_data%24;			//시
	times_data = Math.floor(times_data/24);

	if(times_second < 10) times_second = "0"+times_second;
	if(times_minute < 10) times_minute = "0"+times_minute;
	if(times_hour < 10) times_hour = "0"+times_hour;
	
	document.getElementById("left_time_${rdata.no}").innerHTML = "<span style='font-weight:bold;'>"+times_data+"</span> 일 <span style='font-weight:bold;'>"+times_hour+":"+times_minute+":"+times_second+"</span>";
	times_${rdata.no} = times_${rdata.no} - 1;
	setTimeout ("settime_${rdata.no}();", 1000); 
}
</c:if>
</c:forEach>
function timers() {
	<c:forEach items="${list}" var="rdata">
	<c:if test="${rdata.status eq 1}">
	settime_${rdata.no}();
	</c:if>
	</c:forEach>
}
</script>






<div class="basket_top">
	<h1 style="width:300px;">
		<div><img src="./images/basket.jpg" alt="예약정보" /></div>
		<p>&nbsp;예약확인</p>
	</h1>
</div>


<h1 class="mypage_h"><img src="./images/mypage_h_03.jpg" alt="진행 중인 예약" /></h1>
<ul class="mypage_p">
	<li class="mypage_p_01">
		<img src="./images/mypage_t_h_01.jpg" alt="입금대기중" />
		<div>
			<p>${process1}</p>
			<img src="./images/mypage_t_01.jpg" alt="입금대기중" />
		</div>
	</li>
	<li class="mypage_p_02"></li>
	<li class="mypage_p_01">
		<img src="./images/mypage_t_h_02.jpg" alt="결제완료" />
		<div>
			<p>${process2}</p>
			<img src="./images/mypage_t_02.jpg" alt="결제완료" />
		</div>
	</li>
	<li class="mypage_p_02"></li>
	<li class="mypage_p_01">
		<img src="./images/mypage_t_h_03.jpg" alt="리뷰완료" />
		<div>
			<p>${process3}</p>
			<img src="./images/mypage_t_03.jpg" alt="리뷰완료" />
		</div>
	</li>
	<li class="mypage_p_02"></li>
	<li class="mypage_p_01">
		<img src="./images/mypage_t_h_04.jpg" alt="예약취소" />
		<div>
			<p>${process4}</p>
			<img src="./images/mypage_t_05.jpg" alt="예약취소" />
		</div>
	</li>
</ul>
<h1 class="mypage_h"><img src="./images/mypage_h_01.jpg" alt="최근 예약 정보" /></h1>

<table cellpadding="5" cellspacing="0" class="basket_table" style="width:770px;margin:0 auto;">
<col width="100" />
<col width="100" />
<col width="300" />
<col width="100" />
<col width="100" />
<col width="100" />
<col width="100" />
	<tr>
		<th>예약일자</th>
		<th colspan="2">예약상품정보</th>
		<th>출발/도착일</th>
		<th>금액(인원)</th>
		<th>예약상태</th>
		<th>확인/취소</th>
	</tr>
	<tr>
	<c:forEach items="${list}" var="rdata">
		<td>
			${rdata.dates}<br />
			<input type="button" value="상세보기" class="basket_delete" onclick="location.href='mypage_view.o?no=${rdata.no}&pages=${pages}'" />
		</td>
		<td><a href="view.o?no=${rdata.list_no}" target="_BLANK"><img src="./upload/${rdata.file1}" alt="${sdata.file1}" width="50px" height="50px" /></a></td>
		<td style="text-align:left;">
			<c:if test="${rdata.status eq 1}">
			<div class="left_time" id="left_time_${rdata.no}">&nbsp;</div>
			</c:if>
			<a href="view.o?no=${rdata.list_no}" target="_BLANK">${rdata.subject}</a>
		</td>
		<td>
			<span style="color:#297fb8;font-weight:bold;">${rdata.startdates}</span><br /><span style="font-weight:bold;">${rdata.enddates}</span>
		</td>
		<td>
			<span style="color:red;font-weight:bold;">${rdata.moneys}원</span><br />
			(${rdata.cnts}명)
		</td>
		<td>
			<c:if test="${rdata.status eq 1}">입금대기중</c:if>
			<c:if test="${rdata.status eq 2}">결제완료</c:if>
			<c:if test="${rdata.status eq 3}">리뷰완료</c:if>
			<c:if test="${rdata.status eq 4}">예약취소</c:if>
		</td>
		<td>
			<c:if test="${rdata.status eq 2}"><input type="button" value="리뷰작성" class="basket_order" onclick="view_review('mypage_review.o?no=${rdata.no}&pages=${pages}')" /><br /></c:if>
			<c:if test="${rdata.status ne 3}"><c:if test="${rdata.status ne 4}">
				<input type="button" value="예약취소" class="basket_delete" onclick="location.href='mypage_cancel.o?no=${rdata.no}&pages=${pages}'" />
			</c:if></c:if>
		</td>
	</tr>
	</c:forEach>
</table>



  <div class="list_page">
	<a href="mypage.o?pages=1" class="list_page_a">◀</a>
	<c:forEach begin="${paging.pstarts}" end="${paging.pends}" step="1" var="i">
		<a href="mypage.o?pages=${i}" <c:if test="${i ne pages}"> class="list_page_a"</c:if> <c:if test="${i eq pages}"> class="list_page_a_hover"</c:if>>${i}</a>
	</c:forEach>
	<a href="mypage.o?pages=${paging.board_paging}" class="list_page_a">▶</a>
  </div>
  
   
   