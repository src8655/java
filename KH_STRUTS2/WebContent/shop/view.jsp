<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<c:if test="${order eq 1}">
<div class="basket_top" style="width:965px;margin:0 auto;margin-top:10px;margin-bottom:20px;">
	<h1 style="width:300px;">
		<div><img src="./images/basket.jpg" alt="장바구니" /></div>
		<p>&nbsp;베스트셀러</p>
	</h1>
	<div class="basket_b" style="float:right;width:152px;height:42px;">
		<a href="list.o" onclick="buys.submit()" style="width:150px;height:40px;line-height:40px;margin:0px;padding:0px;text-align:center;">모두보기</a>
	</div>
</div>
</c:if>
<c:if test="${order eq 2}">
<div class="basket_top" style="width:965px;margin:0 auto;margin-top:10px;margin-bottom:20px;">
	<h1 style="width:500px;">
		<div><img src="./images/basket.jpg" alt="장바구니" /></div>
		<p>&nbsp;영카트 추천상품</p>
	</h1>
	<div class="basket_b" style="float:right;width:152px;height:42px;">
		<a href="list.o" onclick="buys.submit()" style="width:150px;height:40px;line-height:40px;margin:0px;padding:0px;text-align:center;">모두보기</a>
	</div>
</div>
</c:if>
<c:if test="${order eq 3}">
<div class="basket_top" style="width:965px;margin:0 auto;margin-top:10px;margin-bottom:20px;">
	<h1 style="width:300px;">
		<div><img src="./images/basket.jpg" alt="장바구니" /></div>
		<p>&nbsp;무료배송</p>
	</h1>
	<div class="basket_b" style="float:right;width:152px;height:42px;">
		<a href="list.o" onclick="buys.submit()" style="width:150px;height:40px;line-height:40px;margin:0px;padding:0px;text-align:center;">모두보기</a>
	</div>
</div>
</c:if>


  <ul id="list_tab">
    <li><a href="list.o?searchs_value=${searchs_values}&order=${order}" <c:if test="${searchs ne -1}">class="list_tab_a"</c:if> <c:if test="${searchs eq -1}">class="list_tab_a_hover"</c:if>>전체상품</a></li>
    <li><a href="list.o?searchs=1&amp;searchs_value=${searchs_values}&order=${order}" <c:if test="${searchs eq 1}">class="list_tab_a_hover"</c:if><c:if test="${searchs ne 1}">class="list_tab_a"</c:if>>쌀/잡곡</a></li>
    <li><a href="list.o?searchs=2&amp;searchs_value=${searchs_values}&order=${order}" <c:if test="${searchs eq 2}">class="list_tab_a_hover"</c:if><c:if test="${searchs ne 2}">class="list_tab_a"</c:if>>과일/채소</a></li>
    <li><a href="list.o?searchs=3&amp;searchs_value=${searchs_values}&order=${order}" <c:if test="${searchs eq 3}">class="list_tab_a_hover"</c:if><c:if test="${searchs ne 3}">class="list_tab_a"</c:if>>축산물</a></li>
    <li><a href="list.o?searchs=4&amp;searchs_value=${searchs_values}&order=${order}" <c:if test="${searchs eq 4}">class="list_tab_a_hover"</c:if><c:if test="${searchs ne 4}">class="list_tab_a"</c:if>>건강식품</a></li>
    <li><a href="list.o?searchs=5&amp;searchs_value=${searchs_values}&order=${order}" <c:if test="${searchs eq 5}">class="list_tab_a_hover"</c:if><c:if test="${searchs ne 5}">class="list_tab_a"</c:if>>가공식품</a></li>
    <li><a href="list.o?searchs=6&amp;searchs_value=${searchs_values}&order=${order}" <c:if test="${searchs eq 6}">class="list_tab_a_hover"</c:if><c:if test="${searchs ne 6}">class="list_tab_a"</c:if>>수산물</a></li>
    <li><a href="list.o?searchs=7&amp;searchs_value=${searchs_values}&order=${order}" <c:if test="${searchs eq 7}">class="list_tab_a_hover"</c:if><c:if test="${searchs ne 7}">class="list_tab_a"</c:if>>김치/장류</a></li>
    <li><a href="list.o?searchs=8&amp;searchs_value=${searchs_values}&order=${order}" <c:if test="${searchs eq 8}">class="list_tab_a_hover"</c:if><c:if test="${searchs ne 8}">class="list_tab_a"</c:if>>공예/공산품</a></li>
  </ul>

<form action="" id="view_form">
<input type="hidden" name="order" value="1"	/>
<input type="hidden" name="no" value="${ldata.no}" />
  <div class="list_v_t">
    <h1>${ldata.name}</h1>
    <div class="list_v_t_l">
      <c:if test="${ldata.file1 eq null}"><img src="./images/x380.jpg" alt="${ldata.name}" width="380px" height="380px" /></c:if>
      <c:if test="${ldata.file1 ne null}"><img src="./upload/${ldata.file1}" alt="${ldata.name}" width="380px" height="380px" /></c:if>
    </div>
    <div class="list_v_t_r">
      <div class="list_v_t_r_t">
        <p class="list_v_dcl">${ldata.discount}<span style="font-size:24px;">%</span></p>
        <p class="list_v_dcr">
          <span style="font-size:12px;color:#666666;">
            <s>${ldata.moneys}원</s>
          </span>
          <br />
          ${ldata.rmoneys}
        </p>
      </div>
      <div class="list_v_t_r_box1">
        <img src="./images/view_truck.jpg" alt="truck" />
        &nbsp;&nbsp;&nbsp;
        <c:if test="${ldata.ship_money eq 0}">
        	<span style="color:#085a9f;">무료배송</span>
        </c:if>
        <c:if test="${ldata.ship_money ne 0}">
        	<span style="color:#085a9f;">배송비 ${ldata.ship_moneys}원</span>
        </c:if>
        (${ldata.ship_company})
      </div>
      
      <div class="list_v_t_r_box2">
        <p class="list_v_t_r_box2_l">
          <span style="color:#085a9f;">원산지</span>
        </p>
        <p class="list_v_t_r_box2_r">${ldata.made}</p>
      </div>
      
      
      <div class="list_v_t_r_box1">
        <p class="list_v_t_r_box2_l">
          <span style="color:#085a9f;">수량</span>
        </p>
        <p class="list_v_t_r_box2_r">
          <input type="button" value="-" onclick="counts_m()" class="view_btn" />
          <input type="text" value="1" name="counts" id="counts" class="view_input" />
          <input type="button" value="+" onclick="counts_p()" class="view_btn" />
        </p>
      </div>
      
      <div class="list_v_t_r_btn">
        <a href="#10" onclick="baskets()"><img src="./images/package.jpg" alt="장바구니 담기" /></a>
        <a href="#10" onclick="buys()"><img src="./images/buy.jpg" alt="구매하기" /></a>
      </div>
      
    </div>
  </div>
</form>
  <ul class="view_tab">
	  <li><a href="#10" id="v_t_m1" <c:if test="${tab eq 1}">class="view_tab_li_a_hover"</c:if><c:if test="${tab ne 1}">class="view_tab_li_a"</c:if> onclick="view_tab('v_t_m1','view_tab1');">상품정보</a></li>
	  <li><a href="#10" id="v_t_m2" <c:if test="${tab eq 2}">class="view_tab_li_a_hover"</c:if><c:if test="${tab ne 2}">class="view_tab_li_a"</c:if> onclick="view_tab('v_t_m2','view_tab2');location.href='view.o?no=${no}&tab=2';">상품 리뷰(${review_total})</a></li>
	  <li><a href="#10" id="v_t_m3" <c:if test="${tab eq 3}">class="view_tab_li_a_hover"</c:if><c:if test="${tab ne 3}">class="view_tab_li_a"</c:if> onclick="view_tab('v_t_m3','view_tab3');location.href='view.o?no=${no}&tab=3';">Q&A(${board_total})</a></li>
	  <li><a href="#10" id="v_t_m4" <c:if test="${tab eq 4}">class="view_tab_li_a_hover"</c:if><c:if test="${tab ne 4}">class="view_tab_li_a"</c:if> onclick="view_tab('v_t_m4','view_tab4');">판매자정보</a></li>
  </ul>
  <div class="list_v_c" id="view_tab1" <c:if test="${tab ne 1}">style="display:none;"</c:if>>
  	${ldata.memo}<br />
  	<c:if test="${ldata.file2 ne null}"><img src="./upload/${ldata.file2}" alt="${ldata.name}" /><br /></c:if>
  	<c:if test="${ldata.file3 ne null}"><img src="./upload/${ldata.file3}" alt="${ldata.name}" /><br /></c:if>
  	<c:if test="${ldata.file4 ne null}"><img src="./upload/${ldata.file4}" alt="${ldata.name}" /><br /></c:if>
  	<c:if test="${ldata.file5 ne null}"><img src="./upload/${ldata.file5}" alt="${ldata.name}" /></c:if>
  </div>
  
  <div class="list_v_c" id="view_tab2" <c:if test="${tab ne 2}">style="display:none;"</c:if>>
  	<table cellspacing="0" cellpadding="10" border="0" class="view_qna_table">
  		<col width="400px" />
  		<col width="80px" />
  		
<c:forEach var="vrdata" items="${review_list}">
  		<tr>
  			<td style="border-bottom:0px;text-align:left;">
  				<div class="review_box_l">
					<c:forEach var="i" begin="1" end="${vrdata.star_01}" step="1">
						<img src="./images/star_01.jpg" alt="별" />
					</c:forEach>
					<c:forEach var="i" begin="1" end="${vrdata.star_02}" step="1">
						<img src="./images/star_02.jpg" alt="별" />
					</c:forEach>
				</div>
				<div class="review_box">배송속도 ${vrdata.review1}</div>
				<div class="review_box">상품품질 ${vrdata.review2}</div>
			</td>
  			<td style="border-bottom:0px;text-align:right;">${vrdata.guest_id} ${vrdata.dates}</td>
  		</tr>
  		<tr>
  			<td colspan="2" style="text-align:left;padding:20px;">${vrdata.memo}</td>
  		</tr>
</c:forEach>
  	</table>
  	<div class="list_page">
	  <a href="view.o?pages=1&amp;no=${no}&amp;tab=2" class="list_page_a">◀</a>
	  <c:forEach begin="${review_pstarts}" end="${review_pends}" step="1" var="i">
		<a href="view.o?pages=${i}&amp;no=${no}&amp;tab=2" <c:if test="${i ne pages_int}"> class="list_page_a"</c:if> <c:if test="${i eq pages_int}"> class="list_page_a_hover"</c:if>>${i}</a>
	  </c:forEach>
	  <a href="view.o?pages=${review_paging}&amp;no=${no}&amp;tab=2" class="list_page_a">▶</a>
    </div>
  </div>
  <div class="list_v_c" id="view_tab3" <c:if test="${tab ne 3}">style="display:none;"</c:if>>
  	<table cellspacing="0" cellpadding="10" border="0" class="view_qna_table">
  		<col width="80px" />
  		<col width="80px" />
  		<col width="300px" />
  		<col width="100px" />
  		<col width="120px" />
  		<tr>
  			<th>문의유형</th>
  			<th colspan="2">문의/답변</th>
  			<th>작성자</th>
  			<th>작성일</th>
  		</tr>
<c:forEach var="vqdata" items="${list}">
  		<tr>
  			<td>
				<c:if test="${vqdata.category eq 1}">상품</c:if>
				<c:if test="${vqdata.category eq 2}">배송</c:if>
				<c:if test="${vqdata.category eq 3}">반품/취소</c:if>
				<c:if test="${vqdata.category eq 4}">교환/변경</c:if>
				<c:if test="${vqdata.category eq 5}">기타</c:if>
			</td>
  			<td>
  				<c:if test="${vqdata.isanswer eq 0}">
  					<div class="view_qna_table_label1">미완료</div>
  				</c:if>
  				<c:if test="${vqdata.isanswer eq 1}">
  					<div class="view_qna_table_label2">답변완료</div>
  				</c:if>
  			</td>
  			<td style="text-align:left;">
  				<a href="#10" onclick="view_qna_view('view_qna_view_${vqdata.no}');">${vqdata.subject}</a>
  			</td>
  			<td>${vqdata.guest_id}</td>
  			<td>${vqdata.dates}</td>
  		</tr>
  		<tr id="view_qna_view_${vqdata.no}" style="display:none;">
  			<td colspan="5" style="padding:0 10px 0 10px;">
  				<table cellspacing="0" cellpadding="10" border="0" style="width:100%;">
			  		<col width="80px" />
			  		<col width="300px" />
  					<tr>
  						<th style="border-top:0px;background:#f5f5f5;"><img src="./images/qna_q.jpg" alt="q" /></th>
  						<td style="text-align:left;background:#f5f5f5;">
  							${vqdata.memo}
  							<c:if test="${vqdata.guest_no eq mdata.no}">
  								<br />
  								<a href="view_qna_del.o?no=${vqdata.no}&pages=${pages}&product_no=${no}">[삭제]</a>
  							</c:if>
  							<c:if test="${vqdata.sellers_no eq mdata.no}">
  							<c:if test="${vqdata.isanswer eq 0}">
  								<br />
  								<a href="#10" onclick="view_qna_answer('${no}', '${pages}', '${vqdata.no}')">[답변]</a>
  							</c:if>
  							</c:if>
  						</td>
  					</tr>
  					<c:if test="${vqdata.isanswer eq 1}">
  					<tr>
  						<th style="border-top:0px;border-bottom:0px;background:#f5f5f5;"><img src="./images/qna_a.jpg" alt="a" /></th>
  						<td style="border-bottom:0px;text-align:left;background:#f5f5f5;">${vqdata.answer}</td>
  					</tr>
  					</c:if>
  				</table>
  			</td>
  		</tr>
 </c:forEach>
  	</table>
  	<c:if test="${member_orders eq 1}">
	  	<div class="view_qna_b">
	  		<a href="#10" onclick="view_qna_write('${no}','${ldata.sellers}')">상품 문의하기</a>
	  	</div>
  	</c:if>
  	<div class="list_page">
	  <a href="view.o?pages=1&amp;no=${no}&amp;tab=3" class="list_page_a">◀</a>
	  <c:forEach begin="${pstarts}" end="${pends}" step="1" var="i">
		<a href="view.o?pages=${i}&amp;no=${no}&amp;tab=3" <c:if test="${i ne pages_int}"> class="list_page_a"</c:if> <c:if test="${i eq pages_int}"> class="list_page_a_hover"</c:if>>${i}</a>
	  </c:forEach>
	  <a href="view.o?pages=${board_paging}&amp;no=${no}&amp;tab=3" class="list_page_a">▶</a>
    </div>
  </div>
  <div class="list_v_c" id="view_tab4" <c:if test="${tab ne 4}">style="display:none;"</c:if>>
  	<table cellspacing="0" cellpadding="25" border="0" class="view_info_table">
  		<col width="150px" />
  		<col width="200px" />
  		<col width="150px" />
  		<col width="200px" />
  		
  		<tr>
  			<th style="border-top:1px solid #cccccc;">판매자</th>
  			<td style="border-top:1px solid #cccccc;">${sellers.name}</td>
  			<th style="border-top:1px solid #cccccc;">사업자 등록번호</th>
  			<td style="border-top:1px solid #cccccc;">${sellers.company_number}</td>
  		</tr>
  		<tr>
  			<th>고객문의 대표번호</th>
  			<td colspan="3">${sellers.phone1} - ${sellers.phone2} - ${sellers.phone3}</td>
  		</tr>
  		<tr>
  			<th>e-mail</th>
  			<td colspan="3">${sellers.email}</td>
  		</tr>
  		<tr>
  			<th>영업소재지</th>
  			<td colspan="3">(${sellers.zipcode}) ${sellers.addr}</td>
  		</tr>
  	</table>
  </div>
  