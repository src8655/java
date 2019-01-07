<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="view_contents">
    


<div class="container">
  <div class="row">
    <div class="col-sm-1"></div>
    <div class="col-sm-10">
    
    
    
    
      <div class="contents">
        
        <h3>기업정보</h3>
        <p>
          ${cdata.info}
        </p>
        <table cellspacing="0" cellpadding="0" class="info_table">
          <tr>
            <th width="10%"><div style="width:60px;overflow:hidden;">대표</div></th>
            <td width="40%">${cdata.name}</td>
            <th width="10%"><div style="width:50px;overflow:hidden;">설립일</div></th>
            <td width="40%">${cdata.founding}</td>
          </tr>
          <tr>
            <th>카테고리</th>
            <td>
			  <c:if test="${cdata.company_cate eq 1}">서비스업</c:if>
              <c:if test="${cdata.company_cate eq 2}">제조/화학</c:if>
              <c:if test="${cdata.company_cate eq 3}">의료/제약/복지</c:if>
              <c:if test="${cdata.company_cate eq 4}">유통/무역/운송</c:if>
              <c:if test="${cdata.company_cate eq 5}">교육업</c:if>
              <c:if test="${cdata.company_cate eq 6}">건설업</c:if>
              <c:if test="${cdata.company_cate eq 7}">IT/웹/통신</c:if>
              <c:if test="${cdata.company_cate eq 8}">미디어/디자인</c:if>
              <c:if test="${cdata.company_cate eq 9}">은행/금융업</c:if>
              <c:if test="${cdata.company_cate eq 10}">기관/협회</c:if>
			</td>
            <th>사원수</th>
            <td>${cdata.count}</td>
          </tr>
          <tr>
            <th>기업형태</th>
            <td>
            	<c:if test="${cdata.company_type eq 1}">대기업</c:if>
	  			<c:if test="${cdata.company_type eq 2}">중소기업</c:if>
	  			<c:if test="${cdata.company_type eq 3}">벤처기업</c:if>
            </td>
            <th>매출액</th>
            <td>${cdata.money}</td>
          </tr>
          <tr>
            <th>웹사이트</th>
            <td colspan="3">${cdata.url}</td>
          </tr>
          <tr>
            <th>본사</th>
            <td colspan="3">${cdata.addr}</td>
          </tr>
        </table>
      </div>


    </div>
    <div class="col-sm-1"></div>
  </div>
</div>

</div>

<div class="container" id="hitcount_bg" style="">
  <div class="row">
    <div class="col-sm-1"></div>
    <div class="col-sm-10">
      <div class="contents">
        <h3>기업 콘텐츠 조회수</h3>
        
        <script type="text/javascript">
          google.charts.load('current', {'packages':['bar']});
          google.charts.setOnLoadCallback(drawChart);
          function drawChart() {
            var data = google.visualization.arrayToDataTable([
              ['Month', 'HIT'],
              ['${dates5}', ${counts5}],
              ['${dates4}', ${counts4}],
              ['${dates3}', ${counts3}],
              ['${dates2}', ${counts2}],
              ['${dates1}', ${counts1}],
              ['${dates0}', ${counts0}]
            ]);
            var options = {
              chart: {
                title: '기업 콘텐츠 조회수',
                subtitle: '최근 6일간 조회수',
              },
              legend: { position: "none" },
            };
            var chart = new google.charts.Bar(document.getElementById('columnchart_material'));
            chart.draw(data, google.charts.Bar.convertOptions(options));
          }
        </script>
        <div id="columnchart_material" style="width:100%; height:500px;"></div>
      </div>
      
      
      
      
    </div>
    <div class="col-sm-1"></div>
  </div>
</div>