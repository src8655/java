var id_check = 0;	//아이디 검사 여부

//아이디 중복확인 버튼 눌렀을때sdf
function btn_check(){
	//input의 아이디값을 찾아서 GET방식으로 팝업창 오픈
	var user_id = document.getElementById("user_ids").value;
	var url = "./join_check.jsp?user_id="+user_id;
	
	if(user_id != "")
  	window.open(url, 'form', 'width=520, height=110, '
  			+'toolbar=no, scrollbars=yes, resizable=no');
	else alert("아이디를 입력해 주세요.");
}
//아이디 중복확인 팝업창 결과
function btn_check_return(result) {
	id_check = result;	//아이디가 비정상이면 0, 정상이면 1
	if(result == 1)
		document.getElementById("id_ch_value").innerHTML="사용 가능한 아이디입니다.";
	else 
		document.getElementById("id_ch_value").innerHTML="중복 확인 절차를 거쳐야 합니다.";
}
//아이디 중복확인 여부
function join_submit() {
	if(id_check == 0) alert("아이디 중복확인을 해주세요.");
	else document.getElementById("join").submit();
}
//우편번호 검색 버튼 눌렀을때
function btn_find(){
	//팝업창 오픈
	var url = "./join_find.jsp"
	window.open(url, 'form', 'width=520, height=480, '
			+'toolbar=no, scrollbars=yes, resizable=no');
}
//우편번호 검색 팝업창 결과
function btn_find_return(num, addr) {
	//찾은 우편번호와 주소를 input에 입력
	document.getElementById("addr_code").value = num;
	document.getElementById("addr").value = addr;
}

//다음우편번호
function btn_find_daum() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
        	document.getElementById("addr_code").value = data.postcode;
        	document.getElementById("addr").value = data.address+" "+data.buildingName;
        }
    }).open();
}