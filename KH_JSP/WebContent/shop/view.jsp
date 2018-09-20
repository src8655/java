<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>


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
        <p class="list_v_t_r_box2_r">중국산</p>
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

  <div class="list_v_c">
  	${ldata.memo}<br />
  	<c:if test="${ldata.file2 ne null}"><img src="./upload/${ldata.file2}" alt="${ldata.name}" /><br /></c:if>
  	<c:if test="${ldata.file3 ne null}"><img src="./upload/${ldata.file3}" alt="${ldata.name}" /><br /></c:if>
  	<c:if test="${ldata.file4 ne null}"><img src="./upload/${ldata.file4}" alt="${ldata.name}" /><br /></c:if>
  	<c:if test="${ldata.file5 ne null}"><img src="./upload/${ldata.file5}" alt="${ldata.name}" /></c:if>
  </div>

<%@ include file="foot.jsp" %>