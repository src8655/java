<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container">
  <div class="row">
    <div class="col-sm-1"></div>
    <div class="col-sm-10">
    
    <div class="review_write">
    	<c:if test="${memberInfo eq null}"><a href="login.o">새로운리뷰 작성하기</a></c:if>
    	<c:if test="${memberInfo ne null}"><a href="review_write.o?member_no=${member_no}&pages=${pages}&pages_r=${pages_r}&searchValue=${searchValue_utf}">새로운리뷰 작성하기</a></c:if>
    </div>
    
    
    
    
    
    
      <div class="contents">
        <div class="container">
          <div class="row">
            <div class="col-sm-4" style="width:220px;">
              <h1><img src="./images/review_h.jpg" alt="전체 리뷰 통계" /><span>전체</span> 리뷰 통계 (38명)</h1>
              <p>
                <div class="review_star_l">4.7</div>
                <div class="review_star_r">
                  <div class="review_star_line0"></div>
                  <!-- 68px -->
                  <div class="review_star_line1" style="width:63px;"></div>
                  <div class="review_star_line_b">총 만족도</div>
                </div>
              </p>
            </div>
            <div class="col-sm-5 col-md-6 col-lg-7">
              <h5>승진 기회 및 가능성</h5>
              <div class="r_bar_bg">
                <div class="r_bar1"><div class="r_bar2" style="width:75%;"></div></div>
                <div class="r_bar_score">7.5</div>
              </div>
              <div class="r_bar_bg">
                <h5>복지 및 급여</h5>
                <div class="r_bar1"><div class="r_bar2" style="width:65%;"></div></div>
                <div class="r_bar_score">7.5</div>
              </div>
              <div class="r_bar_bg">
                <h5>업무와 삶의 균형</h5>
                <div class="r_bar1"><div class="r_bar2" style="width:53%;"></div></div>
                <div class="r_bar_score">7.5</div>
              </div>
              <div class="r_bar_bg">
                <h5>사내문화</h5>
                <div class="r_bar1"><div class="r_bar2" style="width:80%;"></div></div>
                <div class="r_bar_score">7.5</div>
              </div>
              <div class="r_bar_bg">
                <h5>경영진</h5>
                <div class="r_bar1"><div class="r_bar2" style="width:96%;"></div></div>
                <div class="r_bar_score">7.5</div>
              </div>
            </div>
          </div>
        </div>
      </div>
    
    
    
    
    
    
    
    
    
    <div class="contents">
      <div class="review_header">
        IT/인터넷 | 전직원 | 2018-10-3
      </div>
      <div class="container">
        <div class="row">
          <div class="review_l col-sm-2 col-md-2">
            <div class="review_l_star">
              <img src="./images/stars00.jpg" alt="star" />
              <img src="./images/stars00.jpg" alt="star" />
              <img src="./images/stars00.jpg" alt="star" />
              <img src="./images/stars00.jpg" alt="star" />
              <img src="./images/stars11.jpg" alt="star" />
            </div>
            <div class="review_l_list hidden-xs">
              <h5>승진 기회 및 가능성</h5>
              <ul>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
              </ul>
              <h5>복지 및 급여</h5>
              <ul>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
              </ul>
              <h5>업무와 삶의 균형</h5>
              <ul>
                <li></li>
                <li></li>
                <li style="background:#dddddd;"></li>
                <li style="background:#dddddd;"></li>
                <li style="background:#dddddd;"></li>
              </ul>
              <h5>사내문화</h5>
              <ul>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li style="background:#dddddd;"></li>
              </ul>
              <h5>경영진</h5>
              <ul>
                <li></li>
                <li></li>
                <li></li>
                <li style="background:#dddddd;"></li>
                <li style="background:#dddddd;"></li>
              </ul>
            </div>
          </div>
          <div class="review_r col-sm-6 col-md-7">
            <h3>"현대의 이름만 남아있고 미래가 없는 회사. 여기 있으면 매너리즘에 빠지게 된다"</h3>
            <h5 style="color:#0f7ccf;">장점</h5>
            <p>
              분위기는 진짜 좋음. 윗사람들도 외국에 많이 나갔다 와서 마인드도 오픈 마인드. 어디가나 꼰대가 있지만 그런 비중이 적다는거. 그리고 퇴근시간이 사기업치고 매우 빠름.
            </p>
            <h5 style="color:#fc4a13;">단점</h5>
            <p>
              너무 만연한 매너리즘. 위기 탈출을 하려면 그에 맞는 구조조정이 필요할 것으로 보이나 받아들이지 않음. 물론 어디나 구조조정은 반대 하겠지만 여기는 심함. 하지만 컨설팅 업체가 개판으로 구조조정 하는것도 문제. 빨대만 꽂고 돈만 빨아가고 제대로 고치는건 없음. 컨설팅이 손대면 손댈수록 망해가는게 문제임.
            </p>
          </div>
        </div>
      </div>
    </div>
    <div class="contents">
      <div class="review_header">
        IT/인터넷 | 전직원 | 2018-10-3
      </div>
      <div class="container">
        <div class="row">
          <div class="review_l col-sm-2 col-md-2">
            <div class="review_l_star">
              <img src="./images/stars00.jpg" alt="star" />
              <img src="./images/stars00.jpg" alt="star" />
              <img src="./images/stars00.jpg" alt="star" />
              <img src="./images/stars00.jpg" alt="star" />
              <img src="./images/stars11.jpg" alt="star" />
            </div>
            <div class="review_l_list hidden-xs">
              <h5>승진 기회 및 가능성</h5>
              <ul>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
              </ul>
              <h5>복지 및 급여</h5>
              <ul>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
              </ul>
              <h5>업무와 삶의 균형</h5>
              <ul>
                <li></li>
                <li></li>
                <li style="background:#dddddd;"></li>
                <li style="background:#dddddd;"></li>
                <li style="background:#dddddd;"></li>
              </ul>
              <h5>사내문화</h5>
              <ul>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li style="background:#dddddd;"></li>
              </ul>
              <h5>경영진</h5>
              <ul>
                <li></li>
                <li></li>
                <li></li>
                <li style="background:#dddddd;"></li>
                <li style="background:#dddddd;"></li>
              </ul>
            </div>
          </div>
          <div class="review_r col-sm-6 col-md-7">
            <h3>"현대의 이름만 남아있고 미래가 없는 회사. 여기 있으면 매너리즘에 빠지게 된다"</h3>
            <h5 style="color:#0f7ccf;">장점</h5>
            <p>
              분위기는 진짜 좋음. 윗사람들도 외국에 많이 나갔다 와서 마인드도 오픈 마인드. 어디가나 꼰대가 있지만 그런 비중이 적다는거. 그리고 퇴근시간이 사기업치고 매우 빠름.
            </p>
            <h5 style="color:#fc4a13;">단점</h5>
            <p>
              너무 만연한 매너리즘. 위기 탈출을 하려면 그에 맞는 구조조정이 필요할 것으로 보이나 받아들이지 않음. 물론 어디나 구조조정은 반대 하겠지만 여기는 심함. 하지만 컨설팅 업체가 개판으로 구조조정 하는것도 문제. 빨대만 꽂고 돈만 빨아가고 제대로 고치는건 없음. 컨설팅이 손대면 손댈수록 망해가는게 문제임.
            </p>
          </div>
        </div>
      </div>
    </div>
    <div class="contents">
      <div class="review_header">
        IT/인터넷 | 전직원 | 2018-10-3
      </div>
      <div class="container">
        <div class="row">
          <div class="review_l col-sm-2 col-md-2">
            <div class="review_l_star">
              <img src="./images/stars00.jpg" alt="star" />
              <img src="./images/stars00.jpg" alt="star" />
              <img src="./images/stars00.jpg" alt="star" />
              <img src="./images/stars00.jpg" alt="star" />
              <img src="./images/stars11.jpg" alt="star" />
            </div>
            <div class="review_l_list hidden-xs">
              <h5>승진 기회 및 가능성</h5>
              <ul>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
              </ul>
              <h5>복지 및 급여</h5>
              <ul>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
              </ul>
              <h5>업무와 삶의 균형</h5>
              <ul>
                <li></li>
                <li></li>
                <li style="background:#dddddd;"></li>
                <li style="background:#dddddd;"></li>
                <li style="background:#dddddd;"></li>
              </ul>
              <h5>사내문화</h5>
              <ul>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li style="background:#dddddd;"></li>
              </ul>
              <h5>경영진</h5>
              <ul>
                <li></li>
                <li></li>
                <li></li>
                <li style="background:#dddddd;"></li>
                <li style="background:#dddddd;"></li>
              </ul>
            </div>
          </div>
          <div class="review_r col-sm-6 col-md-7">
            <h3>"현대의 이름만 남아있고 미래가 없는 회사. 여기 있으면 매너리즘에 빠지게 된다"</h3>
            <h5 style="color:#0f7ccf;">장점</h5>
            <p>
              분위기는 진짜 좋음. 윗사람들도 외국에 많이 나갔다 와서 마인드도 오픈 마인드. 어디가나 꼰대가 있지만 그런 비중이 적다는거. 그리고 퇴근시간이 사기업치고 매우 빠름.
            </p>
            <h5 style="color:#fc4a13;">단점</h5>
            <p>
              너무 만연한 매너리즘. 위기 탈출을 하려면 그에 맞는 구조조정이 필요할 것으로 보이나 받아들이지 않음. 물론 어디나 구조조정은 반대 하겠지만 여기는 심함. 하지만 컨설팅 업체가 개판으로 구조조정 하는것도 문제. 빨대만 꽂고 돈만 빨아가고 제대로 고치는건 없음. 컨설팅이 손대면 손댈수록 망해가는게 문제임.
            </p>
          </div>
        </div>
      </div>
    </div>
    
    
    
    
    
    
    
    
    
    
    
    </div>
    <div class="col-sm-1"></div>
  </div>
</div>