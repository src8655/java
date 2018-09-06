<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>






<script type="text/javascript">
var WIDTHS = 10;    //가로크기
var HEIGHTS = 25;   //세로크기
var start = 1;      //시작 플래그
var posx = 4;       //블럭 위치 x
var posy = 1;       //블럭 위치y
var change = 0;
var block = 2;
var rand = 0;
var isfirst = 1;
var gameover = 0;
var gamePoint = 0;
var linecount = 0;
var level = 1;
var SPEEDS = 1000;			//스피드
var now_speed = 1000;		//현재 스피드
var timeid;
var firststart = 1;


var blk = new Array();
for(var i=0;i<WIDTHS;i++) blk[i] = new Array();
for(var i=0;i<WIDTHS;i++) for(var j=0;j<HEIGHTS;j++) blk[i][j] = 0;

//임시변수
var blk_tmp = new Array();
for(var i=0;i<WIDTHS;i++) blk_tmp[i] = new Array();
for(var i=0;i<WIDTHS;i++) for(var j=0;j<HEIGHTS;j++) blk_tmp[i][j] = 0;

function styles() {
  switch(rand) {
		//ㄴ
		case 0:
			if(change > 3) change = 0;
			if(change < 0) change = 3;
			switch(change) {
			case 0:
				if(		posx+1 >= WIDTHS
						|| posy+1 >= HEIGHTS
						|| blk[posx][posy-1] != 0 
						|| blk[posx][posy+1] != 0
						|| blk[posx+1][posy+1] != 0) {
					change--;
					if(isfirst == 0) styles();	//첫번째 블럭인데 막혀있으면 안그리도록
					else gameOver();		//게임오버
					break;
				}
				blk[posx][posy-1] = block;
				blk[posx][posy] = block;
				blk[posx][posy+1] = block;
				blk[posx+1][posy+1] = block;
				isfirst = 0;
				break;
			case 1:
				if(		posx+1 >= WIDTHS
						|| posx-1 < 0
						|| posy+1 >= HEIGHTS
						|| blk[posx-1][posy+1] != 0 
						|| blk[posx-1][posy] != 0
						|| blk[posx+1][posy] != 0) {
					change--;
					styles();
					break;
				}
				blk[posx-1][posy+1] = block;
				blk[posx-1][posy] = block;
				blk[posx][posy] = block;
				blk[posx+1][posy] = block;
				break;
			case 2:
				if(		posx-1 < 0
						|| posy+1 >= HEIGHTS
						|| blk[posx-1][posy-1] != 0 
						|| blk[posx][posy-1] != 0
						|| blk[posx][posy+1] != 0) {
					change--;
					styles();
					break;
				}
				blk[posx-1][posy-1] = block;
				blk[posx][posy-1] = block;
				blk[posx][posy] = block;
				blk[posx][posy+1] = block;
				break;
			case 3:
				if(		posx+1 >= WIDTHS
						|| posx-1 < 0
						|| blk[posx+1][posy-1] != 0 
						|| blk[posx+1][posy] != 0
						|| blk[posx-1][posy] != 0) {
					change--;
					styles();
					break;
				}
				blk[posx+1][posy-1] = block;
				blk[posx+1][posy] = block;
				blk[posx][posy] = block;
				blk[posx-1][posy] = block;
				break;
			default:
				break;
			}
			break;
		
		//」
		case 1:
			if(change > 3) change = 0;
			if(change < 0) change = 3;
			switch(change) {
			case 0:
				if(		posx-1 < 0
						|| posy+1 >= HEIGHTS
						|| blk[posx][posy-1] != 0 
						|| blk[posx][posy+1] != 0
						|| blk[posx-1][posy+1] != 0) {
					change--;
					if(isfirst == 0)styles();
					else gameOver();
					break;
				}
				blk[posx][posy-1] = block;
				blk[posx][posy] = block;
				blk[posx][posy+1] = block;
				blk[posx-1][posy+1] = block;
				isfirst = 0;
				break;
			case 1:
				if(		posx+1 >= WIDTHS
						|| posx-1 < 0
						|| blk[posx-1][posy-1] != 0 
						|| blk[posx-1][posy] != 0
						|| blk[posx+1][posy] != 0) {
					change--;
					styles();
					break;
				}
				blk[posx-1][posy-1] = block;
				blk[posx-1][posy] = block;
				blk[posx][posy] = block;
				blk[posx+1][posy] = block;
				break;
			case 2:
				if(		posx+1 >= WIDTHS
						|| posy+1 >= HEIGHTS
						|| blk[posx+1][posy-1] != 0 
						|| blk[posx][posy-1] != 0
						|| blk[posx][posy+1] != 0) {
					change--;
					styles();
					break;
				}
				blk[posx+1][posy-1] = block;
				blk[posx][posy-1] = block;
				blk[posx][posy] = block;
				blk[posx][posy+1] = block;
				break;
			case 3:
				if(		posx+1 >= WIDTHS
						|| posx-1 < 0
						|| posy+1 >= HEIGHTS
						|| blk[posx+1][posy+1] != 0 
						|| blk[posx+1][posy] != 0
						|| blk[posx-1][posy] != 0) {
					change--;
					styles();
					break;
				}
				blk[posx+1][posy+1] = block;
				blk[posx+1][posy] = block;
				blk[posx][posy] = block;
				blk[posx-1][posy] = block;
				break;
			default:
				break;
			}
			break;
			
			
		//ㅁ
		case 2:
			if(		posy+1 >= HEIGHTS
					|| posx+1 >= WIDTHS
					|| blk[posx+1][posy] != 0 
					|| blk[posx][posy+1] != 0
					|| blk[posx+1][posy+1] != 0) {
				change--;
				if(isfirst == 0) styles();
				else gameOver();
				break;
			}
			blk[posx][posy] = block;
			blk[posx+1][posy] = block;
			blk[posx][posy+1] = block;
			blk[posx+1][posy+1] = block;
			isfirst = 0;
			break;
		//ㅣ
		case 3:
			if(change > 1) change = 0;
			if(change < 0) change = 1;
			switch(change) {
			case 0:
				if(		posy+1 >= HEIGHTS
						|| posy+2 >= HEIGHTS
						|| blk[posx][posy-1] != 0 
						|| blk[posx][posy+1] != 0
						|| blk[posx][posy+2] != 0) {
					change--;
					if(isfirst == 0)styles();
					else gameOver();
					break;
				}
				blk[posx][posy-1] = block;
				blk[posx][posy] = block;
				blk[posx][posy+1] = block;
				blk[posx][posy+2] = block;
				isfirst = 0;
				break;
			case 1:
				if(		posx+1 >= WIDTHS
						|| posx+2 >= WIDTHS
						|| posx-1 < 0
						|| blk[posx-1][posy] != 0 
						|| blk[posx+1][posy] != 0
						|| blk[posx+2][posy] != 0) {
					change--;
					styles();
					break;
				}
				blk[posx-1][posy] = block;
				blk[posx][posy] = block;
				blk[posx+1][posy] = block;
				blk[posx+2][posy] = block;
				break;
			default:
				break;
			}
			break;
			
			
		//ㅗ
		case 4:
			if(change > 3) change = 0;
			if(change < 0) change = 3;
			switch(change) {
			case 0:
				if(		posx+1 >= WIDTHS
						|| posx-1 < 0
						|| blk[posx][posy-1] != 0 
						|| blk[posx-1][posy] != 0
						|| blk[posx+1][posy] != 0) {
					change--;
					if(isfirst == 0) styles();
					else gameOver();
					break;
				}
				blk[posx][posy-1] = block;
				blk[posx][posy] = block;
				blk[posx-1][posy] = block;
				blk[posx+1][posy] = block;
				isfirst = 0;
				break;
			case 1:
				if(		posx+1 >= WIDTHS
						|| posy+1 >= HEIGHTS
						|| blk[posx][posy-1] != 0 
						|| blk[posx+1][posy] != 0
						|| blk[posx][posy+1] != 0) {
					change--;
					styles();
					break;
				}
				blk[posx][posy-1] = block;
				blk[posx][posy] = block;
				blk[posx+1][posy] = block;
				blk[posx][posy+1] = block;
				break;
			case 2:
				if(		posx+1 >= WIDTHS
						|| posx-1 < 0
						|| posy+1 >= HEIGHTS
						|| blk[posx][posy+1] != 0 
						|| blk[posx-1][posy] != 0
						|| blk[posx+1][posy] != 0) {
					change--;
					styles();
					break;
				}
				blk[posx][posy+1] = block;
				blk[posx][posy] = block;
				blk[posx-1][posy] = block;
				blk[posx+1][posy] = block;
				break;
			case 3:
				if(		posx-1 < 0
						|| posy+1 >= HEIGHTS
						|| blk[posx][posy-1] != 0 
						|| blk[posx-1][posy] != 0
						|| blk[posx][posy+1] != 0) {
					change--;
					styles();
					break;
				}
				blk[posx][posy-1] = block;
				blk[posx][posy] = block;
				blk[posx-1][posy] = block;
				blk[posx][posy+1] = block;
				break;
			default:
				break;
			}
			break;
			
			//-_
			case 5:
				if(change > 1) change = 0;
				if(change < 0) change = 1;
				switch(change) {
				case 0:
					if(		posy+1 >= HEIGHTS
							|| posx-1 < 0
							|| posx+1 >= WIDTHS
							|| blk[posx-1][posy] != 0 
							|| blk[posx][posy+1] != 0
							|| blk[posx+1][posy+1] != 0) {
						change--;
						if(isfirst == 0) styles();
						else gameOver();
						break;
					}
					blk[posx-1][posy] = block;
					blk[posx][posy] = block;
					blk[posx][posy+1] = block;
					blk[posx+1][posy+1] = block;
					isfirst = 0;
					break;
				case 1:
					if(		posy+1 >= HEIGHTS
							|| posx-1 < 0
							|| blk[posx][posy-1] != 0 
							|| blk[posx-1][posy] != 0
							|| blk[posx-1][posy+1] != 0) {
						change--;
						styles();
						break;
					}
					blk[posx][posy-1] = block;
					blk[posx][posy] = block;
					blk[posx-1][posy] = block;
					blk[posx-1][posy+1] = block;
					break;
				default:
					break;
				}
				break;	
			//_-
			case 6:
				if(change > 1) change = 0;
				if(change < 0) change = 1;
				switch(change) {
				case 0:
					if(		posy+1 >= HEIGHTS
							|| posx-1 < 0
							|| posx+1 >= WIDTHS
							|| blk[posx+1][posy] != 0 
							|| blk[posx][posy+1] != 0
							|| blk[posx-1][posy+1] != 0) {
						change--;
						if(isfirst == 0) styles();
						else gameOver();
						break;
					}
					blk[posx+1][posy] = block;
					blk[posx][posy] = block;
					blk[posx][posy+1] = block;
					blk[posx-1][posy+1] = block;
					isfirst = 0;
					break;
				case 1:
					if(		posy+1 >= HEIGHTS
							|| posx+1 >= WIDTHS
							|| blk[posx][posy-1] != 0 
							|| blk[posx+1][posy] != 0
							|| blk[posx+1][posy+1] != 0) {
						change--;
						styles();
						break;
					}
					blk[posx][posy-1] = block;
					blk[posx][posy] = block;
					blk[posx+1][posy] = block;
					blk[posx+1][posy+1] = block;
					break;
				default:
					break;
				}
				break;

		default:
		  break;
	}
}
alert('게임 시작');

//첫 로딩시
function loads() {
  if(start == 1) {
		allStop();				//모든 블럭 멈춘블럭으로
		findLine();
		posx = 4;					//첫 위치로
		posy = 1;
		start = 0;				//시작플래그를 false
		now_speed = SPEEDS;
		
		
		//블럭모양
		change = 0;                         //첫번째모양으로
		rand = parseInt(Math.random()*7);   //블럭모양 랜덤
		block = parseInt(Math.random()*6)+2;  //블럭색상 랜덤
		isfirst = 1;                        //첫번째블럭
	  styles();
	}
  down();
  timeid = setTimeout(function(){loads();}, now_speed);
}

//채워진 줄 찾기
function findLine() {
  var findcnt = 0;
	var count;
	for(var i=0;i<HEIGHTS;i++) {
		count = 0;
		for(var j=0;j<WIDTHS;j++) {
			if(blk[j][i] != 0 && blk[j][i] == 1) {
				count++;
			}
		}
		//채워진줄 찾으면
		if(count == WIDTHS) {
		  findcnt++;
		
  		//지우고
  		for(var jj=0;jj<WIDTHS;jj++) {
  			blk[jj][i] = 0;
  		}
  		//한칸 아래로
  		for(var ii=i-1;ii>=0;ii--) {
  			for(var jj=0;jj<WIDTHS;jj++) {
  				blk[jj][ii+1] = blk[jj][ii];
  				blk[jj][ii] = 0;
  			}
  		}
		}
	}
	
	
	gamePoint += findcnt*(100 * level*3);	//점수갱신
	linecount += findcnt;	//없어진 라인 누적
	//10라인 누적시 레벨업
	if(linecount >= 10) {
		level += 1;
		SPEEDS -= 80;
		linecount = 0;
	}
}

//모든 블럭 멈춘블럭으로
function allStop() {
  for(var i=0;i<HEIGHTS;i++) for(var j=0;j<WIDTHS;j++)
			if(blk[j][i] != 0 && blk[j][i] != 1) blk[j][i] = 1;
}

//출력
function show() {
  document.getElementById("test").innerHTML = "";
  for(var j=0;j<HEIGHTS;j++) {
    for(var i=0;i<WIDTHS;i++) {
      document.getElementById("test").innerHTML += blk[i][j];
    }
    document.getElementById("test").innerHTML += "<br />";
  }
}


//테스트출력
function show2() {
  /*document.getElementById("games").innerHTML = "";
  for(var j=0;j<HEIGHTS;j++) {
    for(var i=0;i<WIDTHS;i++) {
      if(blk[i][j] == 0)
        document.getElementById("games").innerHTML += "□";
      else
        document.getElementById("games").innerHTML += "■";
    }
    document.getElementById("games").innerHTML += "<br />";
  }*/
  //최초 한번은 그리기
  if(firststart == 1) {
    document.getElementById("games").innerHTML = "";
    for(var j=0;j<HEIGHTS;j++) {
      for(var i=0;i<WIDTHS;i++) {
        if(blk_tmp[i][j] == 0)
          document.getElementById("games").innerHTML += "<div style='width:35px;height:35px;float:left;background:url(./images/blk.png);' id='blks"+i+""+j+"' ></div>";
        else if(blk_tmp[i][j] == 1)
          document.getElementById("games").innerHTML += "<div style='width:35px;height:35px;float:left;background:url(./images/block.png);' id='blks"+i+""+j+"' ></div>";
        else
          document.getElementById("games").innerHTML += "<div style='width:35px;height:35px;float:left;background:url(./images/block"+(block-2)+".png)' id='blks"+i+""+j+"' ></div>";
      }
      document.getElementById("games").innerHTML += "<br />";
    }
    firststart = 0;
    
  }else{
    //기존거와 달라진 부분만 변경
    for(var j=0;j<HEIGHTS;j++) {
      for(var i=0;i<WIDTHS;i++) {
        //다른 부분이 있으면
        if(blk[i][j] != blk_tmp[i][j]) {
          blk_tmp[i][j] = blk[i][j];  //변경된부분 대입
          
          if(blk_tmp[i][j] == 0)
            document.getElementById("blks"+i+""+j+"").style.background="url(./images/blk.png)";
          else if(blk_tmp[i][j] == 1)
            document.getElementById("blks"+i+""+j+"").style.background="url(./images/block.png)";
          else
            document.getElementById("blks"+i+""+j+"").style.background="url(./images/block"+(block-2)+".png)";
        }
      }
    }
  }
  
  document.getElementById("scores").innerHTML = "";
    document.getElementById("scores").innerHTML += "점수 : "+gamePoint;
    document.getElementById("scores").innerHTML += "  ";
    document.getElementById("scores").innerHTML += "레벨 : "+level;
    document.getElementById("scores").innerHTML += "  ";
    document.getElementById("scores").innerHTML += "스피드 : "+SPEEDS;
}


//다운
function down() {
if(gameover == 0) {
  //이동 가능한지 확인(start가 false이면 이동가능)
	for(var i=HEIGHTS-1;i>=0;i--) {
		for(var j=0;j<WIDTHS;j++) {
			//현재 null이 아니고
			if(blk[j][i] != 0 && blk[j][i] != 1) {
				if(i == HEIGHTS-1) {
					start = 1;
					break;
				}
				
				//다음꺼가 존재하고 멈춰있는거면 재시작
				if(blk[j][i+1] != 0 && blk[j][i+1] == 1) {
					start = 1;
					break;
				}
			}
		}
		if(start == 1) break;
	}


  for(var i=0;i<WIDTHS;i++) {
    for(var j=HEIGHTS-2;j>=0;j--) {
      if(blk[i][j] != 1&&blk[i][j] != 0) {
        if(start == 0) {
          blk[i][j+1] = blk[i][j];
          blk[i][j] = 0;
        }
      }
    }
  }
  if(start == 0) posy += 1;	//현재위치갱신
  
  show2();
}
}


//왼쪽으로 이동
function left() {
if(gameover == 0) {
	var flag = 0;	//정지 플래그
			
	//이동 가능한지 확인(flag가 false이면 이동가능)
	for(var i=HEIGHTS-1;i>=0;i--) {
		for(var j=0;j<WIDTHS;j++)	{
			if(blk[j][i] != 0 && blk[j][i] != 1) {
				//왼쪽 벽에 위치하면 이동불가
				if(j == 0) {
					flag = 1;
					break;
				}
				
				//왼쪽거가 존재하고 멈춘블럭이면 이동불가
				if(blk[j-1][i] != 0 && blk[j-1][i] == 1) {
					flag = 1;
					break;
				}
				
			}
		}
		if(flag == 1) break;
	}
	
	//가능하면 이동
	for(var i=HEIGHTS-1;i>=0;i--) {
		for(var j=0;j<WIDTHS;j++)	{
			if(blk[j][i] != 0 && blk[j][i] != 1) {
				if(flag == 0) {
					//왼쪽으로 이동
					blk[j-1][i] = blk[j][i];
					blk[j][i] = 0;
				}
			}
		}
	}
	if(flag == 0) posx -= 1;	//현재위치갱신
	show2();
}
}



//오른쪽으로 이동
function right() {
if(gameover == 0) {
	var flag = 0;
			
	//이동 가능한지 확인(flag가 false이면 이동가능)
	for(var i=HEIGHTS-1;i>=0;i--) {
		for(var j=WIDTHS-1;j>=0;j--) {
			if(blk[j][i] != 0 && blk[j][i] != 1) {
				//왼쪽 벽에 위치하면 이동불가
				if(j == WIDTHS-1) {
					flag = 1;
					break;
				}
				
				//왼쪽거가 존재하고 멈춘블럭이면 이동불가
				if(blk[j+1][i] != 0 && blk[j+1][i] == 1) {
					flag = 1;
					break;
				}
				
			}
		}
		if(flag == 1) break;
	}
	
	//가능하면 이동
	for(var i=HEIGHTS-1;i>=0;i--) {
		for(var j=WIDTHS-1;j>=0;j--) {
			if(blk[j][i] != 0 && blk[j][i] != 1) {
				if(flag == 0) {
					blk[j+1][i] = blk[j][i];
					blk[j][i] = 0;
				}
				
			}
		}
		if(flag == 1) break;
	}
	if(!flag) posx += 1;	//현재위치갱신
	show2();
}
}

//움직이는 블럭 삭제
function moveClear() {
  for(var i=HEIGHTS-1;i>=0;i--) {
		for(var j=0;j<WIDTHS;j++) {
			if(blk[j][i] != 0 && blk[j][i] != 1) {
				blk[j][i] = 0;
			}
		}
	}
}

function gameOver() {
  alert("gameover");
}



document.onkeydown=key_func;
 
function key_func(){
  //↑
  if(window.event.keyCode==38){
    if(gameover == 0) {
    if(start == 0) {
      moveClear();
      change++;
      styles();
      show2();
    }
    }
  }
  //←
  if(window.event.keyCode==37){
    left();
  }
  //→
  if(window.event.keyCode==39){
    right();
  }
  //↓
  if(window.event.keyCode==40){
    down();
  }
  //스페이스
  if(window.event.keyCode==32){
    now_speed = 0;
    window.clearTimeout(timeid);
    loads();
  }
}
</script>
<div id="games" style="margin:0 auto;width:350px;" onload="loads()">

</div>
<div id="scores" style="margin:0 auto;width:350px;text-align:center;">

</div>

















<%@ include file="foot.jsp" %>