<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="head.jsp" %>
  <div id="main">
    <ul class="main_menu">
      <li>
        <img src="./images/left_menu_dot.jpg" alt="점" class="main_menu_dot" />
        <a href="list.o?searchs=1"><img src="./images/left_menu_01.jpg" alt="쌀/잡곡" /></a>
      </li>
      <li>
        <img src="./images/left_menu_dot.jpg" alt="점" class="main_menu_dot" />
        <a href="list.o?searchs=2"><img src="./images/left_menu_02.jpg" alt="과일/채소" /></a>
      </li>
      <li>
        <img src="./images/left_menu_dot.jpg" alt="점" class="main_menu_dot" />
        <a href="list.o?searchs=3"><img src="./images/left_menu_03.jpg" alt="축산물" /></a>
      </li>
      <li>
        <img src="./images/left_menu_dot.jpg" alt="점" class="main_menu_dot" />
        <a href="list.o?searchs=4"><img src="./images/left_menu_04.jpg" alt="건강식품" /></a>
      </li>
      <li>
        <img src="./images/left_menu_dot.jpg" alt="점" class="main_menu_dot" />
        <a href="list.o?searchs=5"><img src="./images/left_menu_05.jpg" alt="가공식품" /></a>
      </li>
      <li>
        <img src="./images/left_menu_dot.jpg" alt="점" class="main_menu_dot" />
        <a href="list.o?searchs=6"><img src="./images/left_menu_06.jpg" alt="수산물" /></a>
      </li>
      <li>
        <img src="./images/left_menu_dot.jpg" alt="점" class="main_menu_dot" />
        <a href="list.o?searchs=7"><img src="./images/left_menu_07.jpg" alt="김치/장류" /></a>
      </li>
      <li style="border:0px;">
        <img src="./images/left_menu_dot.jpg" alt="점" class="main_menu_dot" />
        <a href="list.o?searchs=8"><img src="./images/left_menu_08.jpg" alt="공예/공산품" /></a>
      </li>
    </ul>
    <div class="main_best">
      <div class="main_best_top">
        <h1><img src="./images/main_center_menu.jpg" alt="베스트셀러" /></h1>
        <ul>
          <li><a href="#10" id="mbt8" class="main_best_top_a" onmouseover="tab('tab_8',this,'none');">공예/공산품</a></li>
          <li><a href="#10" id="mbt7" class="main_best_top_a" onmouseover="tab('tab_7',this,'mbt8');">김치/장류</a></li>
          <li><a href="#10" id="mbt6" class="main_best_top_a" onmouseover="tab('tab_6',this,'mbt7');">수산물</a></li>
          <li><a href="#10" id="mbt5" class="main_best_top_a" onmouseover="tab('tab_5',this,'mbt6');">가공식품</a></li>
          <li><a href="#10" id="mbt4" class="main_best_top_a" onmouseover="tab('tab_4',this,'mbt5');">건강식품</a></li>
          <li><a href="#10" id="mbt3" class="main_best_top_a" onmouseover="tab('tab_3',this,'mbt4');">축산물</a></li>
          <li><a href="#10" id="mbt2" class="main_best_top_a_noborder" onmouseover="tab('tab_2',this,'mbt3');">과일/채소</a></li>
          <li><a href="#10" id="mbt1" class="main_best_top_hover" onmouseover="tab('tab_1',this,'mbt2');">쌀/잡곡</a></li>
        </ul>
      </div>
      
      <ul class="main_best_bottom" id="tab_1">
        <li>
          <a href="#">
            <img src="./images/test_product.jpg" alt="우렁이쌀(4kg)" /><br />
            <img src="./images/best.jpg" alt="best" /><br />
            우렁이쌀(4kg)<br />
            <span style="font-weight:bold;">15,000원</span>
          </a>
        </li>
        <li>
          <a href="#">
            <img src="./images/test_product.jpg" alt="우렁이쌀(4kg)" /><br />
            <img src="./images/best.jpg" alt="best" /><br />
            우렁이쌀(4kg)<br />
            <span style="font-weight:bold;">15,000원</span>
          </a>
        </li>
        <li>
          <a href="#">
            <img src="./images/test_product.jpg" alt="우렁이쌀(4kg)" /><br />
            <img src="./images/best.jpg" alt="best" /><br />
            우렁이쌀(4kg)<br />
            <span style="font-weight:bold;">15,000원</span>
          </a>
        </li>
        <li>
          <a href="#">
            <img src="./images/test_product.jpg" alt="우렁이쌀(4kg)" /><br />
            <img src="./images/best.jpg" alt="best" /><br />
            우렁이쌀(4kg)<br />
            <span style="font-weight:bold;">15,000원</span>
          </a>
        </li>
        <li>
          <a href="#">
            <img src="./images/test_product.jpg" alt="우렁이쌀(4kg)" /><br />
            <img src="./images/best.jpg" alt="best" /><br />
            우렁이쌀(4kg)<br />
            <span style="font-weight:bold;">15,000원</span>
          </a>
        </li>
        <li>
          <a href="#">
            <img src="./images/test_product.jpg" alt="우렁이쌀(4kg)" /><br />
            <img src="./images/best.jpg" alt="best" /><br />
            우렁이쌀(4kg)<br />
            <span style="font-weight:bold;">15,000원</span>
          </a>
        </li>
      </ul>
      
      
      <ul class="main_best_bottom" id="tab_2" style="display:none;">
        <li>
          <a href="#">
            <img src="./images/test_product2.jpg" alt="우렁이쌀(4kg)" /><br />
            <img src="./images/best.jpg" alt="best" /><br />
            우렁이쌀(4kg)<br />
            <span style="font-weight:bold;">15,000원</span>
          </a>
        </li>
        <li>
          <a href="#">
            <img src="./images/test_product2.jpg" alt="우렁이쌀(4kg)" /><br />
            <img src="./images/best.jpg" alt="best" /><br />
            우렁이쌀(4kg)<br />
            <span style="font-weight:bold;">15,000원</span>
          </a>
        </li>
        <li>
          <a href="#">
            <img src="./images/test_product2.jpg" alt="우렁이쌀(4kg)" /><br />
            <img src="./images/best.jpg" alt="best" /><br />
            우렁이쌀(4kg)<br />
            <span style="font-weight:bold;">15,000원</span>
          </a>
        </li>
        <li>
          <a href="#">
            <img src="./images/test_product2.jpg" alt="우렁이쌀(4kg)" /><br />
            <img src="./images/best.jpg" alt="best" /><br />
            우렁이쌀(4kg)<br />
            <span style="font-weight:bold;">15,000원</span>
          </a>
        </li>
        <li>
          <a href="#">
            <img src="./images/test_product2.jpg" alt="우렁이쌀(4kg)" /><br />
            <img src="./images/best.jpg" alt="best" /><br />
            우렁이쌀(4kg)<br />
            <span style="font-weight:bold;">15,000원</span>
          </a>
        </li>
        <li>
          <a href="#">
            <img src="./images/test_product2.jpg" alt="우렁이쌀(4kg)" /><br />
            <img src="./images/best.jpg" alt="best" /><br />
            우렁이쌀(4kg)<br />
            <span style="font-weight:bold;">15,000원</span>
          </a>
        </li>
      </ul>
      
      
      
      <ul class="main_best_bottom" id="tab_3" style="display:none;">
        <li>
          <a href="#">
            <img src="./images/test_product3.jpg" alt="우렁이쌀(4kg)" /><br />
            <img src="./images/best.jpg" alt="best" /><br />
            우렁이쌀(4kg)<br />
            <span style="font-weight:bold;">15,000원</span>
          </a>
        </li>
        <li>
          <a href="#">
            <img src="./images/test_product3.jpg" alt="우렁이쌀(4kg)" /><br />
            <img src="./images/best.jpg" alt="best" /><br />
            우렁이쌀(4kg)<br />
            <span style="font-weight:bold;">15,000원</span>
          </a>
        </li>
        <li>
          <a href="#">
            <img src="./images/test_product3.jpg" alt="우렁이쌀(4kg)" /><br />
            <img src="./images/best.jpg" alt="best" /><br />
            우렁이쌀(4kg)<br />
            <span style="font-weight:bold;">15,000원</span>
          </a>
        </li>
        <li>
          <a href="#">
            <img src="./images/test_product3.jpg" alt="우렁이쌀(4kg)" /><br />
            <img src="./images/best.jpg" alt="best" /><br />
            우렁이쌀(4kg)<br />
            <span style="font-weight:bold;">15,000원</span>
          </a>
        </li>
        <li>
          <a href="#">
            <img src="./images/test_product3.jpg" alt="우렁이쌀(4kg)" /><br />
            <img src="./images/best.jpg" alt="best" /><br />
            우렁이쌀(4kg)<br />
            <span style="font-weight:bold;">15,000원</span>
          </a>
        </li>
        <li>
          <a href="#">
            <img src="./images/test_product3.jpg" alt="우렁이쌀(4kg)" /><br />
            <img src="./images/best.jpg" alt="best" /><br />
            우렁이쌀(4kg)<br />
            <span style="font-weight:bold;">15,000원</span>
          </a>
        </li>
      </ul>
      
      
      
      
      <ul class="main_best_bottom" id="tab_4" style="display:none;">
        <li>
          <a href="#">
            <img src="./images/test_product3.jpg" alt="우렁이쌀(4kg)" /><br />
            <img src="./images/best.jpg" alt="best" /><br />
            4우렁이쌀(4kg)<br />
            <span style="font-weight:bold;">15,000원</span>
          </a>
        </li>
      </ul>
      
      
      
      <ul class="main_best_bottom" id="tab_5" style="display:none;">
        <li>
          <a href="#">
            <img src="./images/test_product3.jpg" alt="우렁이쌀(4kg)" /><br />
            <img src="./images/best.jpg" alt="best" /><br />
            5우렁이쌀(4kg)<br />
            <span style="font-weight:bold;">15,000원</span>
          </a>
        </li>
      </ul>
      
      
      <ul class="main_best_bottom" id="tab_6" style="display:none;">
        <li>
          <a href="#">
            <img src="./images/test_product3.jpg" alt="우렁이쌀(4kg)" /><br />
            <img src="./images/best.jpg" alt="best" /><br />
            6우렁이쌀(4kg)<br />
            <span style="font-weight:bold;">15,000원</span>
          </a>
        </li>
      </ul>
      
      
      <ul class="main_best_bottom" id="tab_7" style="display:none;">
        <li>
          <a href="#">
            <img src="./images/test_product3.jpg" alt="우렁이쌀(4kg)" /><br />
            <img src="./images/best.jpg" alt="best" /><br />
            7우렁이쌀(4kg)<br />
            <span style="font-weight:bold;">15,000원</span>
          </a>
        </li>
      </ul>
      
      
      <ul class="main_best_bottom" id="tab_8" style="display:none;">
        <li>
          <a href="#">
            <img src="./images/test_product3.jpg" alt="우렁이쌀(4kg)" /><br />
            <img src="./images/best.jpg" alt="best" /><br />
            8우렁이쌀(4kg)<br />
            <span style="font-weight:bold;">15,000원</span>
          </a>
        </li>
      </ul>
      
    </div>
  </div>
  
  <div class="main_list">
    <h1><img src="./images/center_list_01.jpg" alt="쌀/잡곡" /></h1>
    <ul>
<c:forEach var="ldata" items="${list_1}">
      <li <c:if test="${ldata.cnt eq 5}">style="border-right:none"</c:if>>
      <a href="view.o?no=${ldata.no}&amp;searchs=1">
      	<c:if test="${ldata.file1 eq null}"><img src="./images/noimg.jpg" width="120px" height="120px" alt="${ldata.name}" /></c:if>
        <c:if test="${ldata.file1 ne null}"><img src="./upload/${ldata.file1}" width="120px" height="120px" alt="${ldata.name}" /></c:if>
        <br />
        <c:if test="${ldata.ship_money eq 0}"><img src="./images/free.jpg" alt="무료배송" /></c:if><br />
        <p style="text-align:center;height:15px;width:110px;padding:0px;margin:0 auto;overflow:hidden;">${ldata.name}</p>
        <span style="font-size:12px;color:#666666;">
        	<s>${ldata.moneys}원</s>
        </span><br />
        <span style="font-weight:bold;">${ldata.rmoneys}원</span>
      </a>
    </li>
</c:forEach>
    </ul>
  </div>
  
  
  
  
  
  <div class="main_list">
    <h1><img src="./images/center_list_02.jpg" alt="과일/채소" /></h1>
    <ul>
    
<c:forEach var="ldata" items="${list_2}">
      <li <c:if test="${ldata.cnt eq 5}">style="border-right:none"</c:if>>
      <a href="view.o?no=${ldata.no}&amp;searchs=2">
      	<c:if test="${ldata.file1 eq null}"><img src="./images/noimg.jpg" width="120px" height="120px" alt="${ldata.name}" /></c:if>
        <c:if test="${ldata.file1 ne null}"><img src="./upload/${ldata.file1}" width="120px" height="120px" alt="${ldata.name}" /></c:if>
        <br />
        <c:if test="${ldata.ship_money eq 0}"><img src="./images/free.jpg" alt="무료배송" /></c:if><br />
        <p style="text-align:center;height:15px;width:110px;padding:0px;margin:0 auto;overflow:hidden;">${ldata.name}</p>
        <span style="font-size:12px;color:#666666;">
        	<s>${ldata.moneys}원</s>
        </span><br />
        <span style="font-weight:bold;">${ldata.rmoneys}원</span>
      </a>
    </li>
</c:forEach>
  </div>
  
  
  
  
  
  <div class="main_list">
    <h1><img src="./images/center_list_03.jpg" alt="축산물" /></h1>
    <ul>
 <c:forEach var="ldata" items="${list_3}">
      <li <c:if test="${ldata.cnt eq 5}">style="border-right:none"</c:if>>
      <a href="view.o?no=${ldata.no}&amp;searchs=3">
      	<c:if test="${ldata.file1 eq null}"><img src="./images/noimg.jpg" width="120px" height="120px" alt="${ldata.name}" /></c:if>
        <c:if test="${ldata.file1 ne null}"><img src="./upload/${ldata.file1}" width="120px" height="120px" alt="${ldata.name}" /></c:if>
        <br />
        <c:if test="${ldata.ship_money eq 0}"><img src="./images/free.jpg" alt="무료배송" /></c:if><br />
        <p style="text-align:center;height:15px;width:110px;padding:0px;margin:0 auto;overflow:hidden;">${ldata.name}</p>
        <span style="font-size:12px;color:#666666;">
        	<s>${ldata.moneys}원</s>
        </span><br />
        <span style="font-weight:bold;">${ldata.rmoneys}원</span>
      </a>
    </li>
</c:forEach>
  </div>
  
  
  
  
  <div class="main_list">
    <h1><img src="./images/center_list_04.jpg" alt="축산물" /></h1>
    <ul>
 <c:forEach var="ldata" items="${list_4}">
      <li <c:if test="${ldata.cnt eq 5}">style="border-right:none"</c:if>>
      <a href="view.o?no=${ldata.no}&amp;searchs=4">
      	<c:if test="${ldata.file1 eq null}"><img src="./images/noimg.jpg" width="120px" height="120px" alt="${ldata.name}" /></c:if>
        <c:if test="${ldata.file1 ne null}"><img src="./upload/${ldata.file1}" width="120px" height="120px" alt="${ldata.name}" /></c:if>
        <br />
        <c:if test="${ldata.ship_money eq 0}"><img src="./images/free.jpg" alt="무료배송" /></c:if><br />
        <p style="text-align:center;height:15px;width:110px;padding:0px;margin:0 auto;overflow:hidden;">${ldata.name}</p>
        <span style="font-size:12px;color:#666666;">
        	<s>${ldata.moneys}원</s>
        </span><br />
        <span style="font-weight:bold;">${ldata.rmoneys}원</span>
      </a>
    </li>
</c:forEach>
  </div>
  
  
  <div class="main_list">
    <h1><img src="./images/center_list_05.jpg" alt="축산물" /></h1>
    <ul>
<c:forEach var="ldata" items="${list_5}">
      <li <c:if test="${ldata.cnt eq 5}">style="border-right:none"</c:if>>
      <a href="view.o?no=${ldata.no}&amp;searchs=5">
      	<c:if test="${ldata.file1 eq null}"><img src="./images/noimg.jpg" width="120px" height="120px" alt="${ldata.name}" /></c:if>
        <c:if test="${ldata.file1 ne null}"><img src="./upload/${ldata.file1}" width="120px" height="120px" alt="${ldata.name}" /></c:if>
        <br />
        <c:if test="${ldata.ship_money eq 0}"><img src="./images/free.jpg" alt="무료배송" /></c:if><br />
        <p style="text-align:center;height:15px;width:110px;padding:0px;margin:0 auto;overflow:hidden;">${ldata.name}</p>
        <span style="font-size:12px;color:#666666;">
        	<s>${ldata.moneys}원</s>
        </span><br />
        <span style="font-weight:bold;">${ldata.rmoneys}원</span>
      </a>
    </li>
</c:forEach>
  </div>
  
  
  
  <div class="main_list">
    <h1><img src="./images/center_list_06.jpg" alt="축산물" /></h1>
    <ul>
<c:forEach var="ldata" items="${list_6}">
      <li <c:if test="${ldata.cnt eq 5}">style="border-right:none"</c:if>>
      <a href="view.o?no=${ldata.no}&amp;searchs=6">
      	<c:if test="${ldata.file1 eq null}"><img src="./images/noimg.jpg" width="120px" height="120px" alt="${ldata.name}" /></c:if>
        <c:if test="${ldata.file1 ne null}"><img src="./upload/${ldata.file1}" width="120px" height="120px" alt="${ldata.name}" /></c:if>
        <br />
        <c:if test="${ldata.ship_money eq 0}"><img src="./images/free.jpg" alt="무료배송" /></c:if><br />
        <p style="text-align:center;height:15px;width:110px;padding:0px;margin:0 auto;overflow:hidden;">${ldata.name}</p>
        <span style="font-size:12px;color:#666666;">
        	<s>${ldata.moneys}원</s>
        </span><br />
        <span style="font-weight:bold;">${ldata.rmoneys}원</span>
      </a>
    </li>
</c:forEach>
  </div>



  <div class="main_list">
    <h1><img src="./images/center_list_07.jpg" alt="김치/장류" /></h1>
    <ul>
<c:forEach var="ldata" items="${list_7}">
      <li <c:if test="${ldata.cnt eq 5}">style="border-right:none"</c:if>>
      <a href="view.o?no=${ldata.no}&amp;searchs=7">
      	<c:if test="${ldata.file1 eq null}"><img src="./images/noimg.jpg" width="120px" height="120px" alt="${ldata.name}" /></c:if>
        <c:if test="${ldata.file1 ne null}"><img src="./upload/${ldata.file1}" width="120px" height="120px" alt="${ldata.name}" /></c:if>
        <br />
        <c:if test="${ldata.ship_money eq 0}"><img src="./images/free.jpg" alt="무료배송" /></c:if><br />
        <p style="text-align:center;height:15px;width:110px;padding:0px;margin:0 auto;overflow:hidden;">${ldata.name}</p>
        <span style="font-size:12px;color:#666666;">
        	<s>${ldata.moneys}원</s>
        </span><br />
        <span style="font-weight:bold;">${ldata.rmoneys}원</span>
      </a>
    </li>
</c:forEach>
  </div>
  
  
    <div class="main_list">
    <h1><img src="./images/center_list_08.jpg" alt="공예/공산품" /></h1>
    <ul>
<c:forEach var="ldata" items="${list_8}">
      <li <c:if test="${ldata.cnt eq 5}">style="border-right:none"</c:if>>
      <a href="view.o?no=${ldata.no}&amp;searchs=8">
      	<c:if test="${ldata.file1 eq null}"><img src="./images/noimg.jpg" width="120px" height="120px" alt="${ldata.name}" /></c:if>
        <c:if test="${ldata.file1 ne null}"><img src="./upload/${ldata.file1}" width="120px" height="120px" alt="${ldata.name}" /></c:if>
        <br />
        <c:if test="${ldata.ship_money eq 0}"><img src="./images/free.jpg" alt="무료배송" /></c:if><br />
        <p style="text-align:center;height:15px;width:110px;padding:0px;margin:0 auto;overflow:hidden;">${ldata.name}</p>
        <span style="font-size:12px;color:#666666;">
        	<s>${ldata.moneys}원</s>
        </span><br />
        <span style="font-weight:bold;">${ldata.rmoneys}원</span>
      </a>
    </li>
</c:forEach>
  </div>
  
<%@ include file="foot.jsp" %>