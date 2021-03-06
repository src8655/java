--------------------------------------------------------
--  파일이 생성됨 - 목요일-11월-22-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table MIN_TSHOP_FAQ
--------------------------------------------------------

  CREATE TABLE "LSM8655"."MIN_TSHOP_FAQ" 
   (	"NO" NUMBER(*,0), 
	"CATEGORY" NUMBER(*,0), 
	"SUBJECT" VARCHAR2(2000 BYTE), 
	"MEMO" VARCHAR2(4000 BYTE), 
	"DATES" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table MIN_TSHOP_LIST
--------------------------------------------------------

  CREATE TABLE "LSM8655"."MIN_TSHOP_LIST" 
   (	"NO" NUMBER(*,0), 
	"CATEGORY" NUMBER(*,0), 
	"NAME" VARCHAR2(255 BYTE), 
	"MONEY" NUMBER(*,0), 
	"DISCOUNT" NUMBER(*,0), 
	"MADE" VARCHAR2(255 BYTE), 
	"SHIP_MONEY" NUMBER(*,0), 
	"SHIP_COMPANY" VARCHAR2(255 BYTE), 
	"FILE1" VARCHAR2(2000 BYTE), 
	"FILE2" VARCHAR2(2000 BYTE), 
	"FILE3" VARCHAR2(2000 BYTE), 
	"FILE4" VARCHAR2(2000 BYTE), 
	"FILE5" VARCHAR2(2000 BYTE), 
	"MEMO" VARCHAR2(3000 BYTE), 
	"USER_NO" VARCHAR2(255 BYTE), 
	"HIT" NUMBER(*,0), 
	"BUY" NUMBER(*,0), 
	"DATES" VARCHAR2(255 BYTE), 
	"RMONEY" NUMBER(*,0), 
	"SELLERS" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table MIN_TSHOP_MEMBER
--------------------------------------------------------

  CREATE TABLE "LSM8655"."MIN_TSHOP_MEMBER" 
   (	"NO" NUMBER(*,0), 
	"NAME" VARCHAR2(255 BYTE), 
	"USER_ID" VARCHAR2(255 BYTE), 
	"USER_PW" VARCHAR2(255 BYTE), 
	"EMAIL" VARCHAR2(255 BYTE), 
	"ZIPCODE" VARCHAR2(255 BYTE), 
	"ADDR" VARCHAR2(2000 BYTE), 
	"PHONE1" VARCHAR2(255 BYTE), 
	"PHONE2" VARCHAR2(255 BYTE), 
	"PHONE3" VARCHAR2(255 BYTE), 
	"COMPANY_NUMBER" VARCHAR2(255 BYTE), 
	"ORDERS" NUMBER(*,0), 
	"BANK" VARCHAR2(255 BYTE), 
	"BANK_NUM" VARCHAR2(255 BYTE), 
	"POINT" NUMBER(*,0), 
	"QUEST" NUMBER(*,0), 
	"ANSWER" VARCHAR2(2000 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table MIN_TSHOP_QNA
--------------------------------------------------------

  CREATE TABLE "LSM8655"."MIN_TSHOP_QNA" 
   (	"NO" NUMBER(*,0), 
	"SUBJECT" VARCHAR2(255 BYTE), 
	"MEMO" VARCHAR2(4000 BYTE), 
	"ANSWER" VARCHAR2(4000 BYTE), 
	"ISANSWER" NUMBER(*,0), 
	"DATES" VARCHAR2(255 BYTE), 
	"GUEST_NO" NUMBER(*,0), 
	"CATEGORY" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table MIN_TSHOP_SELL
--------------------------------------------------------

  CREATE TABLE "LSM8655"."MIN_TSHOP_SELL" 
   (	"NO" NUMBER(*,0), 
	"GUEST_NO" NUMBER(*,0), 
	"SELLERS_NO" NUMBER(*,0), 
	"PRODUCT_NO" NUMBER(*,0), 
	"PRODUCT_NAME" VARCHAR2(255 BYTE), 
	"COUNTS" NUMBER(*,0), 
	"MONEY" NUMBER(*,0), 
	"SHIP_MONEY" NUMBER(*,0), 
	"RMONEY" NUMBER(*,0), 
	"DATES" VARCHAR2(255 BYTE), 
	"SHIP_DATES" VARCHAR2(255 BYTE), 
	"SHIP_COMPANY" VARCHAR2(255 BYTE), 
	"STATUS" NUMBER(*,0), 
	"ADDR" VARCHAR2(255 BYTE), 
	"ZIPCODE" VARCHAR2(255 BYTE), 
	"SHIP_MEMO" VARCHAR2(500 BYTE), 
	"NAME" VARCHAR2(255 BYTE), 
	"PHONE1" VARCHAR2(255 BYTE), 
	"PHONE2" VARCHAR2(255 BYTE), 
	"PHONE3" VARCHAR2(255 BYTE), 
	"FILE1" VARCHAR2(255 BYTE), 
	"TIMES" VARCHAR2(500 BYTE), 
	"SHIP_NUM" VARCHAR2(500 BYTE), 
	"HASREVIEW" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table MIN_TSHOP_SELL_GROUP
--------------------------------------------------------

  CREATE TABLE "LSM8655"."MIN_TSHOP_SELL_GROUP" 
   (	"NO" NUMBER(*,0), 
	"MONEY" NUMBER(*,0), 
	"SHIP_MONEY" NUMBER(*,0), 
	"RMONEY" NUMBER(*,0), 
	"BANK" VARCHAR2(255 BYTE), 
	"BANK_NUM" VARCHAR2(255 BYTE), 
	"NAME" VARCHAR2(255 BYTE), 
	"ZIPCODE" VARCHAR2(255 BYTE), 
	"ADDR" VARCHAR2(500 BYTE), 
	"PHONE1" VARCHAR2(255 BYTE), 
	"PHONE2" VARCHAR2(255 BYTE), 
	"PHONE3" VARCHAR2(255 BYTE), 
	"SHIP_MEMO" VARCHAR2(255 BYTE), 
	"TIMES" VARCHAR2(500 BYTE), 
	"DATES" VARCHAR2(255 BYTE), 
	"GUEST_NO" NUMBER(*,0), 
	"STATUS" NUMBER(*,0), 
	"POINT" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table MIN_TSHOP_VIEW_QNA
--------------------------------------------------------

  CREATE TABLE "LSM8655"."MIN_TSHOP_VIEW_QNA" 
   (	"NO" NUMBER(*,0), 
	"PRODUCT_NO" NUMBER(*,0), 
	"GUEST_NO" NUMBER(*,0), 
	"GUEST_ID" VARCHAR2(255 BYTE), 
	"CATEGORY" NUMBER(*,0), 
	"MEMO" VARCHAR2(2000 BYTE), 
	"SECRET" NUMBER(*,0), 
	"DATES" VARCHAR2(255 BYTE), 
	"ANSWER" VARCHAR2(2000 BYTE), 
	"ISANSWER" NUMBER(*,0), 
	"SELLERS_NO" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table MIN_TSHOP_VIEW_REVIEW
--------------------------------------------------------

  CREATE TABLE "LSM8655"."MIN_TSHOP_VIEW_REVIEW" 
   (	"NO" NUMBER(*,0), 
	"GUEST_NO" NUMBER(*,0), 
	"PRODUCT_NO" NUMBER(*,0), 
	"STARS" NUMBER(*,0), 
	"REVIEW1" VARCHAR2(255 BYTE), 
	"REVIEW2" VARCHAR2(255 BYTE), 
	"MEMO" VARCHAR2(2000 BYTE), 
	"DATES" VARCHAR2(255 BYTE), 
	"GUEST_ID" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into LSM8655.MIN_TSHOP_FAQ
SET DEFINE OFF;
Insert into LSM8655.MIN_TSHOP_FAQ (NO,CATEGORY,SUBJECT,MEMO,DATES) values (202,3,'상품이 배송중인데, 취소할 수 있나요?','<p>&nbsp;</p>

<p><strong><img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCE0bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtbjJEYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2JG5%2BXmU0akR7eTI6ZUw6fiUjTV5sWDtLNV1FTko%3D" style="height:20px; width:20px" />상품 수령 후&nbsp;반품 신청 가능<img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqIyE1bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtXTJFYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2P246XmM0akR7eTI6ZUw6fiUjTV5sWDtLal1BTko%3D" style="height:20px; width:20px" /></strong></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>취소 신청은 입금대기중/결제완료/배송준비중(발송 전)에서만 가능하며,</p>

<p>배송중인 상품의 구매를 원하지 않는다면 수령 후 반품신청으로&nbsp;가능합니다.</p>

<p>&nbsp;</p>

<p>주문하신 상품이 이미 배송중이라면, 주문을 취소하실 수 없는 점 양해 부탁 드립니다.</p>

<p>&nbsp;</p>

<p>또한, 구매자 사유로 반품하는 경우, 왕복배송비를 판매자에게 지불하시면</p>

<p>최초 배송비를 포함한 결제금액 전액을 환불하여 드립니다.</p>

<p>&nbsp;</p>

<p>배송상태 별 취소처리는 아래와 같습니다.</p>

<p>&nbsp;</p>

<p><strong>&nbsp;1&nbsp;&nbsp;입금대기중/결제완료</strong></p>

<p>&nbsp;.-&nbsp; 주문서가 판매자에게 넘어가기 이전 단계이며,&nbsp;취소 신청 시 즉시 취소가 처리됩니다.</p>

<p>&nbsp;</p>

<p><strong>&nbsp;2&nbsp;&nbsp;배송준비중</strong></p>

<p>&nbsp;.-&nbsp; 주문서가 판매자에게 넘어간 단계이며,&nbsp;판매자의 상품 발송여부에 따라 취소가 처리됩니다.</p>

<p>&nbsp;.-&nbsp; 상품 발송작업이 진행되지 않은 경우, 취소 신청 시 즉시 취소가 처리됩니다.</p>

<p>&nbsp;.-&nbsp; 상품 발송작업이 진행된 경우, 취소 신청 시 취소가 거부되며 상품수령 후 반품으로 진행됩니다.</p>

<p>&nbsp;</p>

<p><strong>&nbsp;3&nbsp;&nbsp;배송중/배송완료</strong></p>

<p><strong>&nbsp;</strong>&nbsp;<strong>-&nbsp;</strong>상품 발송작업이 완료된 건으로, 상품 수령 후 반품 신청이 가능합니다.</p>
','2018-9-5');
Insert into LSM8655.MIN_TSHOP_FAQ (NO,CATEGORY,SUBJECT,MEMO,DATES) values (252,3,'취소했는데 취소내역은 어디서 확인하나요.','<p><strong><strong><img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCE0bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtbjJEYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2JG5%2BXmU0akR7eTI6ZUw6fiUjTV5sWDtLNV1FTko%3D" style="height:20px; width:20px" />취소/반품/교환 현황에서 확인<img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqIyE1bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtXTJFYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2P246XmM0akR7eTI6ZUw6fiUjTV5sWDtLal1BTko%3D" style="height:20px; width:20px" /></strong></strong></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><a href="http://www.11st.co.kr/order/OrderList.tmall?type=cancelRequest" target="_blank"><strong><img alt="새창 열림" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCEqbGx8XH0jIV4zLTVNKjRr%0AN3xjeUEtMzJtYDFtS2wsay80N31dKjorO2BsbjJ7MSltTGBOa3h7RCEzfCtcbnpcTjFMRTMwLERO%0AXTMrKSQufi9uQGo2LG5AXjE0akR7eTI6ZUx5fi0jQV4xWGtLNF1FTko%3D" />&nbsp;취소 신청 페이지</strong></a></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>취소신청 시 수신 동의 체크가 되어있다면&nbsp;SMS(혹은 알리미)로 취소내역이 전송됩니다.</p>

<p>&nbsp;</p>

<p>또한, 나의 11번가 취소/반품/교환 현황 페이지를 통해 확인 가능합니다.</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;&nbsp;</p>

<p><img alt="i·¨i？？e？´i？­i？？i？¸" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwlbSEpbDN8ayhhIVozTDRBZTlr%0AS3xjeUVhKlxaLTFrS2xtKS9aN31dIyUrLlgxbjJ7XiltX11tKT17RDYzfGpfbjlrTmVMKzNiJClE%0AWGwrKSROOi83QjUrbm1%2BNWw0S0RKeSs6bEwpfiojTV5jWGpLJl0hTi0%3D" style="height:150px; width:600px" /></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<table cellspacing="0" style="height:25px; width:500px">
	<tbody>
		<tr>
			<td style="background-color:#ffffff">
			<p><strong>&nbsp;참고</strong></p>
			</td>
		</tr>
	</tbody>
</table>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;※ 배송준비중 상태일 때 취소 시 판매처를 통해 상품의 발송 여부 확인 후 가능합니다.</p>

<p>&nbsp;※ 판매자와 연락이 어려운 경우, 주문한 상품 페이지 하단에 상품 Q&amp;A로 문의 부탁 드립니다.</p>
','2018-9-5');
Insert into LSM8655.MIN_TSHOP_FAQ (NO,CATEGORY,SUBJECT,MEMO,DATES) values (302,4,'취소와 반품의 차이점은 무엇인가요.','<p><strong><img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCE0bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtbjJEYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2JG5%2BXmU0akR7eTI6ZUw6fiUjTV5sWDtLNV1FTko%3D" style="height:20px; width:20px" />판매자가 상품을 발송을 했는지에 따라 구분<img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqIyE1bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtXTJFYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2P246XmM0akR7eTI6ZUw6fiUjTV5sWDtLal1BTko%3D" style="height:20px; width:20px" /></strong></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><a href="http://buy.11st.co.kr/order/OrderList.tmall" target="_blank"><strong><img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCEqbGx8XH0jIV4zLTVNKjRr%0AN3xjeUEtMzJtYDFtS2wsay80N31dKjorO2BsbjJ7MSltTGBOa3h7RCEzfCtcbnpcTjFMRTMwLERO%0AXTMrKSQufi9uQGo2LG5AXjE0akR7eTI6ZUx5fi0jQV4xWGtLNF1FTko%3D" />&nbsp;상품 발송여부 확인 페이지</strong></a></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>취소와 반품은 주문한 상품의 구매거절 의사를 표시하는 방법으로,</p>

<p>판매자의 상품 발송여부를 기준으로 구분이 됩니다.</p>

<p>바로가기로 이동한&nbsp;페이지 안의&nbsp;<img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqbiEubEp8fn15IV4zSjRNbX1r%0AK3xleSEtKjJaYDFtS2w4ayk0MX1dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKWQufi9fQDU2bm5%2BXmw0fEQueSE6ZUxEfi0jQV5lWEVLOV1NTi0%3D" style="height:20px; width:53px" />&nbsp;클릭 시&nbsp;확인 가능합니다.</p>

<p>&nbsp;</p>

<p><strong>&nbsp;1&nbsp;&nbsp;취소</strong></p>

<p><strong>&nbsp; -&nbsp;</strong>판매자가 상품을 발송하기 전에 가능 (입금대기중, 결제완료)</p>

<p>&nbsp;</p>

<p><strong>&nbsp;2&nbsp;&nbsp;반품</strong></p>

<p><strong>&nbsp; -&nbsp;</strong>판매자가 상품을 발송한 이후 가능 (배송준비중, 배송중, 배송완료)</p>
','2018-9-5');
Insert into LSM8655.MIN_TSHOP_FAQ (NO,CATEGORY,SUBJECT,MEMO,DATES) values (352,4,'판매자 주소는 어디서 확인하나요.','<p><strong><strong><img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCE0bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtbjJEYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2JG5%2BXmU0akR7eTI6ZUw6fiUjTV5sWDtLNV1FTko%3D" style="height:20px; width:20px" />주문/배송조회 페이지에서 확인<img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqIyE1bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtXTJFYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2P246XmM0akR7eTI6ZUw6fiUjTV5sWDtLal1BTko%3D%22" /></strong></strong></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><a href="http://buy.11st.co.kr/order/OrderList.tmall" target="_blank"><strong><img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCEqbGx8XH0jIV4zLTVNKjRr%0AN3xjeUEtMzJtYDFtS2wsay80N31dKjorO2BsbjJ7MSltTGBOa3h7RCEzfCtcbnpcTjFMRTMwLERO%0AXTMrKSQufi9uQGo2LG5AXjE0akR7eTI6ZUx5fi0jQV4xWGtLNF1FTko%3D" />&nbsp;주문/배송조회 페이지</strong></a></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>나의 11번가 주문/배송조회 페이지에서 판매자 아이디를 클릭하면 확인 가능합니다.</p>

<p>또한, 상품 상세페이지와 미니몰에서도 확인 가능합니다.</p>

<p>&nbsp;</p>

<p>단, 반품을 진행하는 경우 판매자주소와 반품 주소가 다를 수 있으므로</p>

<p>반품 주소를 꼭 확인 후 진행하시기 바랍니다.</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<table border="1" cellspacing="0">
	<tbody>
		<tr>
			<td style="background-color:#ffffff; border-color:#c8c8c8">
			<p><img alt="" src="http://help.11st.co.kr/enomix/crosseditor/binary/images/000035/20170918114014630_BKLU8YHV.jpg" /></p>
			</td>
		</tr>
	</tbody>
</table>
','2018-9-5');
Insert into LSM8655.MIN_TSHOP_FAQ (NO,CATEGORY,SUBJECT,MEMO,DATES) values (402,4,'상품을 반품했는데, 반송 운송장 번호는 어디에 입력을 하나요.','<p><strong><img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCE0bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtbjJEYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2JG5%2BXmU0akR7eTI6ZUw6fiUjTV5sWDtLNV1FTko%3D" style="height:20px; width:20px" />취소/반품/교환&nbsp;현황 페이지에서 입력<img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqIyE1bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtXTJFYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2P246XmM0akR7eTI6ZUw6fiUjTV5sWDtLal1BTko%3D" style="height:20px; width:20px" /></strong></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><a href="http://buy.11st.co.kr/order/CancelStatusList.tmall" target="_blank"><strong><img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCEqbGx8XH0jIV4zLTVNKjRr%0AN3xjeUEtMzJtYDFtS2wsay80N31dKjorO2BsbjJ7MSltTGBOa3h7RCEzfCtcbnpcTjFMRTMwLERO%0AXTMrKSQufi9uQGo2LG5AXjE0akR7eTI6ZUx5fi0jQV4xWGtLNF1FTko%3D" />&nbsp;반송장 번호 입력 페이지</strong></a></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>반품할 상품을 판매자에게 발송한 후,&nbsp;</p>

<p>택배기사에게 받은 반송 운송장 번호를&nbsp;11번가에 등록하면 빠른 반품처리에 도움이 됩니다.</p>

<p>&nbsp;</p>

<p><strong>&nbsp;1&nbsp;&nbsp;반품신청 한 상품의 &#39;상세내역&#39; 클릭</strong></p>

<p><img alt="i？？i？？e°？i？？_e°？i？¡i？´i？¡i？￥e²？i？¸i？？e?￥_1" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwlYSFebEp8XChlITQzSjRFPSZr%0AN3xjeUFhP1wyLWVrMmwuKS9aN31dIyUrLlgxbjJ7XiltX11tKT17RDYzfGpfbjlrTmVMKzNiJClE%0AWGwrKSROKy9jQi4rJW0yNWw0akR7eUE6Y0wqfnkjTV4xWDtLKF1BTi0%3D" style="height:180px; width:600px" /></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><strong>&nbsp;2&nbsp;&nbsp;택배사 선택 후 송장 번호 입력</strong></p>

<p><img alt="i？？i？？e°？i？？_e°？i？¡i？´i？¡i？￥e²？i？¸i？？e?￥_2" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwlLSFebEp8XChlITQzSjRFPSZr%0AN3xjeUFhLVwyLWVrMmwuKS9aN31dIyUrLlgxbjJ7XiltX11tKT17RDYzfGpfbjlrTmVMKzNiJClE%0AWGwrKSROKy9jQi4rJW1%2BNTE0akR7eUE6Y0wqfnkjTV4xWDtLKF1NTkw%3D" style="height:365px; width:600px" /></p>

<p>&nbsp;</p>
','2018-9-5');
Insert into LSM8655.MIN_TSHOP_FAQ (NO,CATEGORY,SUBJECT,MEMO,DATES) values (152,2,'실수로 구매확정을 눌렀어요','<p><img alt="e¨¸e|￢e§？i？？i？？" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCE0bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtbjJEYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2JG5%2BXmU0akR7eTI6ZUw6fiUjTV5sWDtLNV1FTko%3D" style="height:20px; width:20px" /><strong>&nbsp;구매확정 후 반품/교환은 판매자&nbsp;확인 후 처리</strong><img alt="e¨¸e|￢e§？e？？" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqIyE1bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtXTJFYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2P246XmM0akR7eTI6ZUw6fiUjTV5sWDtLal1BTko%3D" style="height:20px; width:20px" /></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<table align="left" cellspacing="0" style="width:500px">
	<tbody>
		<tr>
			<td style="border-color:#c8c8c8 currentColor"><img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYSFabDNqfjR5IV4zTDRBI3pr%0AanxleUEqYTJETG4qSyR7XzsqMS5dYThBNFhsbjp7XiluTEovKVkoQmstNy9cOXprTm5MRTMoL2th%0AemUrQiYtMitfNDtBSy1cWmU0N0QseSs6MUwpfi0jQV5lWEtLfV1BTi0%3D" style="height:128px; width:128px" /></td>
			<td style="border-color:#c8c8c8 currentColor">
			<p>&nbsp;</p>
			</td>
			<td style="border-color:#c8c8c8 currentColor">
			<p>&nbsp;</p>

			<p>구매확정은 상품을 구매하겠다는 최종적인 구매 의사 표현이며,</p>

			<p>구매확정&nbsp;후에는 판매자에게 상품의 대금이 송금되고 거래가 종료됩니다.</p>

			<p>&nbsp;</p>

			<p>따라서 반품/교환이 어려울 수 있으며,</p>

			<p>개별적으로 판매자에게 연락하여 처리를 진행하셔야 합니다.</p>

			<p>&nbsp;</p>

			<p>판매자와 협의가 되어 상품을 반송하는 경우</p>

			<p>빠른 처리를 위해 메모[성함, 연락처, 반품/교환사유, 교환상품, 11번가]</p>

			<p>동봉하여&nbsp;상품과 함께&nbsp;보내주시기 바랍니다.</p>

			<p>&nbsp;</p>
			</td>
			<td style="border-color:#c8c8c8 currentColor">&nbsp;</td>
		</tr>
	</tbody>
</table>

<p>&nbsp;</p>

<p>&nbsp;</p>
','2018-9-5');
Insert into LSM8655.MIN_TSHOP_FAQ (NO,CATEGORY,SUBJECT,MEMO,DATES) values (52,1,'[구매] [PAYCO] 서비스 해지는 어떻게 하나요.','<p><img alt="e¨¸e|￢e§？i？？i？？" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCE0bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtbjJEYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2JG5%2BXmU0akR7eTI6ZUw6fiUjTV5sWDtLNV1FTko%3D" style="height:20px; width:20px" /><strong>PAYCO 페이지를 통해 탈퇴</strong><img alt="e¨¸e|￢e§？e？？" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqIyE1bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtXTJFYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2P246XmM0akR7eTI6ZUw6fiUjTV5sWDtLal1BTko%3D" style="height:20px; width:20px" /></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><a href="http://www.payco.com/main.nhn" target="_blank"><img alt="NEW LINK" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqeSF9bC18XH0jIV4zLTVNKjRr%0AN3xjeUEtZTIpYGNtS2wsay80N31dKjorO2BsbjJ7MSltTGBOa3h7RCEzfCtcbnpcTjFMRTMwLERO%0AXTMrKSQufi9uQDQ2YG5%2BXmM0akR7eTI6ZUx5fi0jQV4xWCtLYl1BTjM%3D" style="height:20px; width:71px" /><strong>&nbsp;PAYCO 홈페이지</strong></a></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>PAYCO&nbsp;서비스를 해지하고 싶을 경우&nbsp;PAYCO 홈페이지 또는 모바일 앱을 통해&nbsp;탈퇴 가능합니다.</p>
','2018-9-5');
Insert into LSM8655.MIN_TSHOP_FAQ (NO,CATEGORY,SUBJECT,MEMO,DATES) values (102,2,'구매확정은 어디서 하나요?','<p><img alt="e¨¸e|￢e§？i？？i？？" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCE0bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtbjJEYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2JG5%2BXmU0akR7eTI6ZUw6fiUjTV5sWDtLNV1FTko%3D" style="height:20px; width:20px" /><strong>주문/배송 조회에서 가능</strong><img alt="e¨¸e|￢e§？e？？" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqIyE1bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtXTJFYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2P246XmM0akR7eTI6ZUw6fiUjTV5sWDtLal1BTko%3D" style="height:20px; width:20px" /></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><a href="http://buy.11st/.co.kr/order/orderlist.tmall" target="_blank"><img alt="e°？e¡？e°？e¸°" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqeSF9bC18XH0jIV4zLTVNKjRr%0AN3xjeUEtZTIpYGNtS2wsay80N31dKjorO2BsbjJ7MSltTGBOa3h7RCEzfCtcbnpcTjFMRTMwLERO%0AXTMrKSQufi9uQDQ2YG5%2BXmM0akR7eTI6ZUx5fi0jQV4xWCtLYl1BTjM%3D" style="height:20px; width:71px" />&nbsp;<strong>주문/배송 조회</strong></a>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>주문한 상품 수령 후&nbsp;반품/교환을 진행하지 않는다면&nbsp;구매확정이&nbsp;가능합니다.</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><strong>&nbsp;방법&nbsp;</strong>&nbsp;<strong>나의 11번가 &#39;주문/배송조회&#39;에서 &#39;구매확정&#39; 클릭</strong></p>

<p><img alt="i？？i·¨i？？i？¸" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQyMya2VCWlw%2FYSFebDN8XChlIX0zSjRBbnxr%0AO3xjeU0tYTIpM25rIWxbKTtaMSldZUAhfHplbjp7OylfZTNhKU4wKUUzMWprSjVcTnxMXzMoQ0Ru%0AWDErayZOMi9lQkUrXSpcXmU0a0ROeSs6Y0xafmUjTV4xYGs6KHhBTi0%3D" style="height:250px; width:600px" /></p>
','2018-9-5');
REM INSERTING into LSM8655.MIN_TSHOP_LIST
SET DEFINE OFF;
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (4302,3,'미트맨 풍미가득 통칼집 돼지목살 600g',7200,5,'독일',3000,'우체국택배','2018-9-19_1_ch3.jpg',null,'2018-9-19_1_ch3_1.jpg',null,null,null,'0',7,0,'2018-9-19',6840,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (4202,3,'미트맨 육즙가득 칼집 삼겹살 500g',5900,1,'독일',3000,'우체국택배','2018-9-19_1_ch1.jpg',null,null,null,'2018-9-19_1_ch1_1.jpg','<p>1</p>
','0',5,0,'2018-9-19',5841,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (4252,3,'미트맨 구이용 돼지 목살 500g',6500,1,'캐나다',3000,'CJ대한통운','2018-9-19_1_ch2.jpg',null,null,'2018-9-19_1_ch2_1.jpg',null,null,'0',60,12,'2018-9-19',6435,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (4352,3,'[행복한목장] No항생제 한우 국거리500g',61810,1,'국내산',0,'로젠택배','2018-9-19_1_ch4.jpg','2018-9-19_1_ch4_1.jpg',null,null,null,null,'0',6,2,'2018-9-19',61191,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (4402,3,'청정 대관령지역한우 육포세트 3호',160400,11,'국내산',0,'CJ대한통운','2018-9-19_1_ch5.jpg',null,null,null,'2018-9-19_1_ch5_1.jpg',null,'0',72,15,'2018-9-19',142756,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (4452,4,'천봉산삼 5~6년근 20뿌리 산양삼 장뇌삼 산양산삼 추석선물세트 건강식품 산삼/장뇌삼',60000,5,'국내-강원/평창군',0,'로젠택배','2018-9-27_1_ch6_1.jpg','2018-9-27_1_ch6_1_1.jpg',null,null,null,null,'0',1,0,'2018-9-27',57000,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (4502,4,'진삼코리아 산양 산삼 5~6 년근 5 뿌리 산삼/장뇌삼',40000,10,'국내-강원/횡성군',0,'CJ대한통운','2018-9-27_1_ch6_2.jpg','2018-9-27_1_ch6_2_1.jpg',null,null,null,null,'0',29,23,'2018-9-27',36000,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (4552,4,'정관장 홍삼원+한삼인 홍삼정/추석선물세트/홍삼가공/면역력/선물세트',70000,1,'국내산',0,'우체국택배','2018-9-27_1_ch6_3.jpg','2018-9-27_1_ch6_3_1.jpg',null,null,null,null,'0',1,1,'2018-9-27',69300,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (4602,4,'정한삼 고려 홍삼정 홍삼 추석선물세트 정관장 조영구홍삼가공',27900,5,'국내산',0,'우체국택배','2018-9-27_1_ch6_4.jpg','2018-9-27_1_ch6_4_1.jpg',null,null,null,null,'0',11,2,'2018-9-27',26505,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (4652,4,'정관장홍삼정 에브리타임10mlx30포/빠른배송 홍삼가공',88000,3,'국내산',0,'CJ대한통운','2018-9-27_1_ch6_5.jpg','2018-9-27_1_ch6_5_1.jpg',null,null,null,null,'0',4,0,'2018-9-27',85360,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (4702,4,'최상급 러시아 차가버섯1kg 차가버섯가루1kg 약용버섯',29900,3,'국내산',0,'CJ대한통운','2018-9-27_1_ch6_6.jpg','2018-9-27_1_ch6_6_1.jpg',null,null,null,null,'0',6,1,'2018-9-27',29003,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (2002,1,'2018년 햅쌀/남원농협 섬진강쌀10kg',30000,5,'국내산',0,'CJ대한통운','2018-9-14_4_test1.jpg',null,'2018-9-14_22_01_info.jpg',null,null,null,'0',7,11,'2018-9-14',28500,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (2052,1,'[단독특가] 17년 다시농협 나주쌀 20kg / 당일도정',48000,20,'국내산',0,'로젠택배','2018-9-14_6_test7.jpg',null,null,null,null,null,'0',15,1,'2018-9-14',38400,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (2102,1,'[17년산] 익산시농협 신동진쌀 20kg / 단일품종쌀',50000,2,'국내산',0,'CJ대한통운','2018-9-14_4_test6.jpg',null,null,null,null,null,'0',49,24,'2018-9-14',49000,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (2152,1,'하늘버금 경기미쌀 10kg',33000,10,'국내산',2500,'우체국택배','2018-9-14_4_test5.jpg',null,null,null,'2018-9-14_23_01_info.jpg',null,'0',40,2,'2018-9-14',29700,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (2202,1,'[17년산] 김제금만농협 신동진쌀 20kg / 단일품종쌀',49500,5,'국내산',0,'CJ대한통운','2018-9-14_5_test4.jpg',null,null,'2018-9-14_24_01_info.jpg',null,null,'0',9,7,'2018-9-14',47025,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (2252,2,'고급사과배혼합세트/가락청과시장 / 등급높은과일',79000,15,'국내산',0,'한진택배','2018-9-14_1_test8.jpg',null,null,null,null,null,'0',9,67,'2018-9-14',67150,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (2302,2,'랜덤특가/선물세트/카라바오 골드망고 5Kg/과수선택',30000,2,'국내산',0,'우체국택배','2018-9-14_1_test9.jpg',null,null,null,null,null,'0',0,2,'2018-9-14',29400,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (2352,2,'[농협] 추석 명절 달콤한 선물세트! 머스크 케이멜론 4kg 8kg',16000,5,'국내산',2500,'우체국택배','2018-9-14_1_test10.jpg',null,null,null,null,null,'0',36,5,'2018-9-14',15200,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (2402,2,'[2018추석선물세트] 특품 과일 선물세트/사과 배 곶감 아보카도 망고',19900,15,'국내산',0,'로젠택배','2018-9-14_1_11.jpg',null,null,null,null,null,'0',10,22,'2018-9-14',16915,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (2452,2,'[수현이네] 알뜰 햇사과 홍로 10KG',8000,5,'국내산',2500,'CJ대한통운','2018-9-14_1_test11.jpg',null,null,null,null,null,'0',19,2,'2018-9-14',7600,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (2502,2,'[특가]햇사과 출시/청송꿀사과 5kg/10kg/홍로',25800,7,'국내산',0,'우체국택배','2018-9-14_1_test12.jpg',null,null,null,null,null,'0',7,9,'2018-9-14',23994,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (2552,2,'달콤과즙 폭발 털복숭아 4.5kg 22과내외 중과',16900,11,'국내산',0,'한진택배','2018-9-14_1_test13.jpg',null,null,null,null,null,'0',5,0,'2018-9-14',15041,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (6452,4,'필네이쳐 리타 베트남 100% 노니원액 착즙주스 1000ml 진액 액기스',23900,8,'베트남',0,'한진택배','2018-10-4_1_ch6_2.jpg','2018-10-4_1_ch6_2_1.jpg',null,null,null,null,'0',4,0,'2018-10-4',21988,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (6552,5,'사조 팝콘치킨 2kg / 치킨너겟/핫도그/버팔로윙',6000,1,'국내산',3000,'로젠택배','2018-10-4_1_ch7_5.jpg','2018-10-4_1_ch7_5_1.jpg',null,null,null,null,'0',1,0,'2018-10-4',5940,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (6502,4,'건강즙 자연산 약초 진액 즙 액기스 원액 농축액 모음',120000,5,'국내산',0,'CJ대한통운','2018-10-4_1_ch6_1.jpg',null,null,'2018-10-4_1_ch6_1_1.jpg',null,null,'0',4,0,'2018-10-4',114000,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (6602,5,'쟌슨빌 명품 핫도그 3종 20팩 패키지!!',27000,2,'국내산',0,'CJ대한통운','2018-10-4_1_ch7_4.jpg','2018-10-4_1_ch7_4_1.jpg',null,null,null,null,'0',3,0,'2018-10-4',26460,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (6652,5,'쟌슨빌 냉동소시지1810g 2종',28000,2,'국내산',0,'CJ대한통운','2018-10-4_1_ch7_3.jpg','2018-10-4_1_ch7_3_1.jpg',null,null,null,null,'0',5,0,'2018-10-4',27440,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (6702,5,'프로라인치킨너겟1kg+1kg/가라아케/팝콘치킨/김말이',15000,5,'국내산',0,'한진택배','2018-10-4_1_ch7_2.jpg','2018-10-4_1_ch7_2_1.jpg',null,null,null,null,'0',4,0,'2018-10-4',14250,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (6752,5,'오뚜기 컵누들 소컵 우동맛/매콤한맛*30입 외',21000,2,'국내산',0,'CJ대한통운','2018-10-4_1_ch7_1.jpg','2018-10-4_1_ch7_1_1.jpg',null,null,null,null,'0',1,0,'2018-10-4',20580,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (6802,6,'[바다소리 직영몰] 한가위 기획세트/명절선물세트/수산물선물',17000,1,'국내',3000,'CJ대한통운','2018-10-4_2_ch7_5.jpg','2018-10-4_2_ch7_5_1.jpg',null,null,null,null,'0',2,0,'2018-10-4',16830,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (6852,6,'국산홍어1박스 날개살1kg이상 모듬살1.2kg이상 80점이상 10인분이상',68000,3,'국내산',0,'우체국택배','2018-10-4_2_ch7_4.jpg','2018-10-4_2_ch7_4_1.jpg',null,null,null,null,'0',4,0,'2018-10-4',65960,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (6902,6,'은하수산 자연산 자숙 통문어 900g-1.1kg 1마리',67000,2,'아프리카',0,'CJ대한통운','2018-10-4_2_ch7_3.jpg','2018-10-4_2_ch7_3_1.jpg',null,null,null,null,'0',1,0,'2018-10-4',65660,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (6952,6,'은하수산 완도 활전복 1kg내외 (10미/15미/20미)',53000,5,'국내산',0,'CJ대한통운','2018-10-4_2_ch7_2.jpg','2018-10-4_2_ch7_2_1.jpg',null,null,null,null,'0',1,0,'2018-10-4',50350,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (7002,6,'은하수산 항공직송 살아있는 랍스타 800g, 1100g 내외',37000,5,'캐나다',0,'로젠택배','2018-10-4_2_ch7_1.jpg','2018-10-4_2_ch7_1_1.jpg',null,null,null,null,'0',4,0,'2018-10-4',35150,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (7052,7,'파김치2KG 국산재료자용 당일생산 행사진행중 특가',24000,1,'국내산',2500,'우체국택배','2018-10-4_3_ch7_5.jpg','2018-10-4_3_ch7_5_1.jpg',null,null,null,null,'0',1,0,'2018-10-4',23760,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (7102,7,'담을김치 생 포기김치5kg/HACCP/포기김치',21000,1,'국내산',0,'CJ대한통운','2018-10-4_4_ch7_4.jpg','2018-10-4_4_ch7_4_1.jpg',null,null,null,null,'0',3,0,'2018-10-4',20790,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (7152,7,'[박광희김치]황제맛김치 입소문 유명한 특가정용',27500,14,'국내산',0,'CJ대한통운','2018-10-4_3_ch7_3.jpg','2018-10-4_3_ch7_3_1.jpg',null,null,null,null,'0',7,0,'2018-10-4',23650,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (7202,7,'[박광희김치] (국산) 올바른 총각김치 2kg',10900,10,'국내산',0,'CJ대한통운','2018-10-4_3_ch7_2.jpg','2018-10-4_3_ch7_2_1.jpg',null,null,null,null,'0',2,0,'2018-10-4',9810,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (7252,7,'[박광희김치] 생포기김치5Kg/10Kg/발송당일 버무린 김치[HACCP인증]',17000,1,'국내산',0,'CJ대한통운','2018-10-4_3_ch7_1.jpg','2018-10-4_3_ch7_1_1.jpg',null,null,null,null,'0',3,1,'2018-10-4',16830,1002);
REM INSERTING into LSM8655.MIN_TSHOP_MEMBER
SET DEFINE OFF;
Insert into LSM8655.MIN_TSHOP_MEMBER (NO,NAME,USER_ID,USER_PW,EMAIL,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,COMPANY_NUMBER,ORDERS,BANK,BANK_NUM,POINT,QUEST,ANSWER) values (3152,'sss','sss','9F6E680CFAE7749EB6C486619254B9C','sss@navercom','152-130','서울 구로구 금오로 867 ','11','22','33',null,1,null,null,0,4,'몰라');
Insert into LSM8655.MIN_TSHOP_MEMBER (NO,NAME,USER_ID,USER_PW,EMAIL,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,COMPANY_NUMBER,ORDERS,BANK,BANK_NUM,POINT,QUEST,ANSWER) values (4302,'유운민호','qwq6735','83ADCF56E1055BBB16772FB339127','qwq6735@naver.com','135-230','서울 강남구 광평로 61 수정빌딩','010','0000','0000',null,1,null,null,4680,3,'몰라');
Insert into LSM8655.MIN_TSHOP_MEMBER (NO,NAME,USER_ID,USER_PW,EMAIL,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,COMPANY_NUMBER,ORDERS,BANK,BANK_NUM,POINT,QUEST,ANSWER) values (2002,'222','lsm8655','81DC9BDB52D04DC2036DBD8313ED055','sdfoisdfsdf','480-822','경기 의정부시 거북로 4 ','1','2','3','12312222000',3,'국민','123123123',0,1,'몰라');
Insert into LSM8655.MIN_TSHOP_MEMBER (NO,NAME,USER_ID,USER_PW,EMAIL,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,COMPANY_NUMBER,ORDERS,BANK,BANK_NUM,POINT,QUEST,ANSWER) values (5302,'aaa111','aaa','47BCE5C74F589F4867DBD57E9CA9F88','aaa','135-860','서울 강남구 강남대로 238 스카이쏠라빌딩','111','111','111',null,1,null,null,0,1,'111');
Insert into LSM8655.MIN_TSHOP_MEMBER (NO,NAME,USER_ID,USER_PW,EMAIL,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,COMPANY_NUMBER,ORDERS,BANK,BANK_NUM,POINT,QUEST,ANSWER) values (1002,'윤민호','src8655','3162F8A6D36EC8DE769A2127BFFA651','src8655@naver.com','480-822','경기 의정부시 거북로 4 ','111','1111','1111','123456789',2,'99','99',0,2,'몰라');
Insert into LSM8655.MIN_TSHOP_MEMBER (NO,NAME,USER_ID,USER_PW,EMAIL,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,COMPANY_NUMBER,ORDERS,BANK,BANK_NUM,POINT,QUEST,ANSWER) values (2052,'민호','src8822','D064802D1B2D5346936161E4340A7E9','srcsdf123','480-822','경기 의정부시 거북로 21 ','11','22','33',null,1,null,null,24148,2,'몰라몰라');
Insert into LSM8655.MIN_TSHOP_MEMBER (NO,NAME,USER_ID,USER_PW,EMAIL,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,COMPANY_NUMBER,ORDERS,BANK,BANK_NUM,POINT,QUEST,ANSWER) values (4352,'2222222','55','6512BD43D9CAA6E02C99BA82652DCA','77','413-140','경기 파주시 고작골길 80 판인터','11','11','111','123123111',2,'22','33',0,2,'123');
REM INSERTING into LSM8655.MIN_TSHOP_QNA
SET DEFINE OFF;
Insert into LSM8655.MIN_TSHOP_QNA (NO,SUBJECT,MEMO,ANSWER,ISANSWER,DATES,GUEST_NO,CATEGORY) values (202,'관세란 무엇인가요?11','<p>해외배송에</p>

<p>&nbsp;</p>

<p>관세가 무엇인가요?</p>
',null,0,'2018-10-7',2052,2);
Insert into LSM8655.MIN_TSHOP_QNA (NO,SUBJECT,MEMO,ANSWER,ISANSWER,DATES,GUEST_NO,CATEGORY) values (52,'관심있는 상품만 모아볼 수 있나요?','<p>관심있는 상품만</p>

<p>보고싶어요</p>
','<p><img alt="e¨¸e|￢e§？i？？i？？" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCE0bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtbjJEYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2JG5%2BXmU0akR7eTI6ZUw6fiUjTV5sWDtLNV1FTko%3D" style="height:20px; width:20px" /><strong>나의11번가에서 한 번에 확인 가능</strong><img alt="e¨¸e|￢e§？e？？" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqIyE1bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtXTJFYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2P246XmM0akR7eTI6ZUw6fiUjTV5sWDtLal1BTko%3D" style="height:20px; width:20px" /></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>상품 페이지에서 찜한 상품은 [나의 11번가 - 나의 관심 목록 - 찜한 상품]에서 확인하실 수 있습니다.</p>

<p>또한, 찜한 상품 보기에서 장바구니로 이동 또는 삭제도 가능합니다.</p>

<p>&nbsp;</p>

<p><strong>&nbsp;1&nbsp;</strong>&nbsp;<strong>상품페이지&nbsp;&#39;♡&#39;&nbsp;버튼 클릭</strong></p>

<p>&nbsp;<img alt="i°？i？？ i？？i？？i？？i？´i§？" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQyMya2VCWlw%2FZSF9bDN8figjIU0zMzVBI3xr%0AO3xjeU0tYTJEM19rS2x4KUVaMSldZUAhfHplbjp7OylfZTNhKU4wKUUzMWprSjVcTnxMXzMoQ0Ru%0AWDEraztOOi98QiYrSypcXmU0a0ROeSs6Y0wyfiUjQV4xYEs6YnhNTko%3D" style="height:250px; width:400px" /></p>

<p>&nbsp;</p>

<p>&nbsp;2&nbsp;&nbsp;<strong>나의 11번가 &#39;찜한 상품&#39; 클릭</strong></p>

<p>&nbsp;<img alt="i°？i？？i？？i？？" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQyMya2VCWlw%2FbiEqbGx8aygjIU0zMzVBI3xr%0AO3xjeU0tYTJaM25rK2x4KUVaMSldZUAhfHplbjp7OylfZTNhKU4wKUUzMWprSjVcTnxMXzMoQ0Ru%0AWDEraztOOi9jQjsrXypcXmU0a0ROeSs6Y0wyfiUjQV4xYGo6NHhNTi0%3D" style="height:300px; width:400px" /></p>
',1,'2018-9-5',2052,5);
Insert into LSM8655.MIN_TSHOP_QNA (NO,SUBJECT,MEMO,ANSWER,ISANSWER,DATES,GUEST_NO,CATEGORY) values (102,'개인통관번호 발급은 어떻게 하나요?','<p>개인통관번호 발급은</p>

<p>&nbsp;</p>

<p>어떻게 하나요?</p>
','<p><strong><img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCE0bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtbjJEYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2JG5%2BXmU0akR7eTI6ZUw6fiUjTV5sWDtLNV1FTko%3D" style="height:20px; width:20px" />관세청 홈페이지에서 발급<img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqIyE1bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtXTJFYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2P246XmM0akR7eTI6ZUw6fiUjTV5sWDtLal1BTko%3D" style="height:20px; width:20px" /></strong></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><a href="http://portal.customs.go.kr/main.html" target="_blank"><strong><img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCEqbGx8XH0jIV4zLTVNKjRr%0AN3xjeUEtMzJtYDFtS2wsay80N31dKjorO2BsbjJ7MSltTGBOa3h7RCEzfCtcbnpcTjFMRTMwLERO%0AXTMrKSQufi9uQGo2LG5AXjE0akR7eTI6ZUx5fi0jQV4xWGtLNF1FTko%3D" />&nbsp;관세청 홈페이지</strong></a></p>

<p><a href="https://unipass.customs.go.kr/csp/persIndex.do" target="_blank"><strong><img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCEqbGx8XH0jIV4zLTVNKjRr%0AN3xjeUEtMzJtYDFtS2wsay80N31dKjorO2BsbjJ7MSltTGBOa3h7RCEzfCtcbnpcTjFMRTMwLERO%0AXTMrKSQufi9uQGo2LG5AXjE0akR7eTI6ZUx5fi0jQV4xWGtLNF1FTko%3D" />&nbsp;개인통관고유부호 발급 매뉴얼 보기</strong></a></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>회원가입 없이&nbsp;관세청 홈페이지에서 성명과 주민등록번호 입력 후,</p>

<p>공인인증서/휴대폰으로 인증하시면 발급받으실 수 있습니다.</p>

<p>&nbsp;</p>

<p>개인통관고유부호는 P로 시작하는 13자리 번호로 구성되며,</p>

<p>개인정보보호법 개정 시행에 따라 주민등록번호를 대체한 수단입니다.</p>
',1,'2018-9-5',2052,1);
Insert into LSM8655.MIN_TSHOP_QNA (NO,SUBJECT,MEMO,ANSWER,ISANSWER,DATES,GUEST_NO,CATEGORY) values (302,'1231231','<p>123123123</p>
',null,0,'2018-9-19',4302,3);
REM INSERTING into LSM8655.MIN_TSHOP_SELL
SET DEFINE OFF;
Insert into LSM8655.MIN_TSHOP_SELL (NO,GUEST_NO,SELLERS_NO,PRODUCT_NO,PRODUCT_NAME,COUNTS,MONEY,SHIP_MONEY,RMONEY,DATES,SHIP_DATES,SHIP_COMPANY,STATUS,ADDR,ZIPCODE,SHIP_MEMO,NAME,PHONE1,PHONE2,PHONE3,FILE1,TIMES,SHIP_NUM,HASREVIEW) values (4652,2052,1002,2252,'고급사과배혼합세트/가락청과시장 / 등급높은과일',1,79000,0,67150,'2018-9-8',null,'한진택배',5,'경기 의정부시 거북로 21 ','480-822',null,'민호','11','22','33','2018-9-14_1_test8.jpg','1538986548703slsl2052','222',1);
Insert into LSM8655.MIN_TSHOP_SELL (NO,GUEST_NO,SELLERS_NO,PRODUCT_NO,PRODUCT_NAME,COUNTS,MONEY,SHIP_MONEY,RMONEY,DATES,SHIP_DATES,SHIP_COMPANY,STATUS,ADDR,ZIPCODE,SHIP_MEMO,NAME,PHONE1,PHONE2,PHONE3,FILE1,TIMES,SHIP_NUM,HASREVIEW) values (4702,2052,1002,6452,'필네이쳐 리타 베트남 100% 노니원액 착즙주스 1000ml 진액 액기스',1,23900,0,21988,'2018-9-8',null,'한진택배',3,'경기 의정부시 거북로 21 ','480-822',null,'민호','11','22','33','2018-10-4_1_ch6_2.jpg','1538989823886slsl2052',null,0);
Insert into LSM8655.MIN_TSHOP_SELL (NO,GUEST_NO,SELLERS_NO,PRODUCT_NO,PRODUCT_NAME,COUNTS,MONEY,SHIP_MONEY,RMONEY,DATES,SHIP_DATES,SHIP_COMPANY,STATUS,ADDR,ZIPCODE,SHIP_MEMO,NAME,PHONE1,PHONE2,PHONE3,FILE1,TIMES,SHIP_NUM,HASREVIEW) values (4752,2052,1002,4502,'진삼코리아 산양 산삼 5~6 년근 5 뿌리 산삼/장뇌삼',7,280000,0,252000,'2018-9-8',null,'CJ대한통운',5,'경기 의정부시 거북로 21 ','480-822',null,'민호','11','22','33','2018-9-27_1_ch6_2.jpg','1538989823886slsl2052','123123',1);
Insert into LSM8655.MIN_TSHOP_SELL (NO,GUEST_NO,SELLERS_NO,PRODUCT_NO,PRODUCT_NAME,COUNTS,MONEY,SHIP_MONEY,RMONEY,DATES,SHIP_DATES,SHIP_COMPANY,STATUS,ADDR,ZIPCODE,SHIP_MEMO,NAME,PHONE1,PHONE2,PHONE3,FILE1,TIMES,SHIP_NUM,HASREVIEW) values (4802,2052,1002,2502,'[특가]햇사과 출시/청송꿀사과 5kg/10kg/홍로',4,103200,0,95976,'2018-9-8',null,'우체국택배',5,'경기 의정부시 거북로 21 ','480-822',null,'민호','11','22','33','2018-9-14_1_test12.jpg','1538989823886slsl2052','213123',1);
Insert into LSM8655.MIN_TSHOP_SELL (NO,GUEST_NO,SELLERS_NO,PRODUCT_NO,PRODUCT_NAME,COUNTS,MONEY,SHIP_MONEY,RMONEY,DATES,SHIP_DATES,SHIP_COMPANY,STATUS,ADDR,ZIPCODE,SHIP_MEMO,NAME,PHONE1,PHONE2,PHONE3,FILE1,TIMES,SHIP_NUM,HASREVIEW) values (4852,2052,1002,2202,'[17년산] 김제금만농협 신동진쌀 20kg / 단일품종쌀',1,49500,0,47025,'2018-9-8',null,'CJ대한통운',5,'경기 의정부시 거북로 21 ','480-822',null,'민호','11','22','33','2018-9-14_5_test4.jpg','1538989823886slsl2052','12312',1);
Insert into LSM8655.MIN_TSHOP_SELL (NO,GUEST_NO,SELLERS_NO,PRODUCT_NO,PRODUCT_NAME,COUNTS,MONEY,SHIP_MONEY,RMONEY,DATES,SHIP_DATES,SHIP_COMPANY,STATUS,ADDR,ZIPCODE,SHIP_MEMO,NAME,PHONE1,PHONE2,PHONE3,FILE1,TIMES,SHIP_NUM,HASREVIEW) values (6252,2052,1002,2202,'[17년산] 김제금만농협 신동진쌀 20kg / 단일품종쌀',3,148500,0,141075,'2018-10-7',null,'CJ대한통운',5,'경기 의정부시 거북로 21 ','480-822',null,'민호','11','22','33','2018-9-14_5_test4.jpg','1541593402256slsl2052','111',1);
Insert into LSM8655.MIN_TSHOP_SELL (NO,GUEST_NO,SELLERS_NO,PRODUCT_NO,PRODUCT_NAME,COUNTS,MONEY,SHIP_MONEY,RMONEY,DATES,SHIP_DATES,SHIP_COMPANY,STATUS,ADDR,ZIPCODE,SHIP_MEMO,NAME,PHONE1,PHONE2,PHONE3,FILE1,TIMES,SHIP_NUM,HASREVIEW) values (5302,4302,1002,4352,'[행복한목장] No항생제 한우 국거리500g',2,123620,0,122382,'2018-9-18',null,'로젠택배',5,'서울 강남구 광평로 61 수정빌딩','135-230','123123','유운민호','010','0000','0000','2018-9-19_1_ch4.jpg','1539860287479slsl4302','1232',1);
Insert into LSM8655.MIN_TSHOP_SELL (NO,GUEST_NO,SELLERS_NO,PRODUCT_NO,PRODUCT_NAME,COUNTS,MONEY,SHIP_MONEY,RMONEY,DATES,SHIP_DATES,SHIP_COMPANY,STATUS,ADDR,ZIPCODE,SHIP_MEMO,NAME,PHONE1,PHONE2,PHONE3,FILE1,TIMES,SHIP_NUM,HASREVIEW) values (7202,2052,1002,2202,'[17년산] 김제금만농협 신동진쌀 20kg / 단일품종쌀',5,247500,0,235125,'2018-10-8',null,'CJ대한통운',5,'경기 의정부시 거북로 21 ','480-822',null,'민호','11','22','33','2018-9-14_5_test4.jpg','1541659287739slsl2052','123',1);
Insert into LSM8655.MIN_TSHOP_SELL (NO,GUEST_NO,SELLERS_NO,PRODUCT_NO,PRODUCT_NAME,COUNTS,MONEY,SHIP_MONEY,RMONEY,DATES,SHIP_DATES,SHIP_COMPANY,STATUS,ADDR,ZIPCODE,SHIP_MEMO,NAME,PHONE1,PHONE2,PHONE3,FILE1,TIMES,SHIP_NUM,HASREVIEW) values (7302,2052,1002,4602,'정한삼 고려 홍삼정 홍삼 추석선물세트 정관장 조영구홍삼가공',5,139500,0,132525,'2018-10-12',null,'우체국택배',1,'경기 의정부시 거북로 21 ','480-822',null,'민호','11','22','33','2018-9-27_1_ch6_4.jpg','1542009918914slsl2052',null,0);
Insert into LSM8655.MIN_TSHOP_SELL (NO,GUEST_NO,SELLERS_NO,PRODUCT_NO,PRODUCT_NAME,COUNTS,MONEY,SHIP_MONEY,RMONEY,DATES,SHIP_DATES,SHIP_COMPANY,STATUS,ADDR,ZIPCODE,SHIP_MEMO,NAME,PHONE1,PHONE2,PHONE3,FILE1,TIMES,SHIP_NUM,HASREVIEW) values (5202,4302,1002,7252,'[박광희김치] 생포기김치5Kg/10Kg/발송당일 버무린 김치[HACCP인증]',2,34000,0,33660,'2018-9-18',null,'CJ대한통운',5,'서울 강남구 광평로 61 수정빌딩','135-230',null,'유운민호','010','0000','0000','2018-10-4_3_ch7_1.jpg','1539859094879slsl4302','22222',1);
REM INSERTING into LSM8655.MIN_TSHOP_SELL_GROUP
SET DEFINE OFF;
Insert into LSM8655.MIN_TSHOP_SELL_GROUP (NO,MONEY,SHIP_MONEY,RMONEY,BANK,BANK_NUM,NAME,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,SHIP_MEMO,TIMES,DATES,GUEST_NO,STATUS,POINT) values (2752,79000,0,67150,'농협','34627-42-10379341','민호','480-822','경기 의정부시 거북로 21 ','11','22','33',null,'1538986548703slsl2052','2018-9-8',2052,2,0);
Insert into LSM8655.MIN_TSHOP_SELL_GROUP (NO,MONEY,SHIP_MONEY,RMONEY,BANK,BANK_NUM,NAME,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,SHIP_MEMO,TIMES,DATES,GUEST_NO,STATUS,POINT) values (2802,456600,0,416989,'농협','17408-95-16460243','민호','480-822','경기 의정부시 거북로 21 ','11','22','33',null,'1538989823886slsl2052','2018-9-8',2052,2,1000);
Insert into LSM8655.MIN_TSHOP_SELL_GROUP (NO,MONEY,SHIP_MONEY,RMONEY,BANK,BANK_NUM,NAME,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,SHIP_MEMO,TIMES,DATES,GUEST_NO,STATUS,POINT) values (4052,148500,0,141075,'농협','70415-99-18349331','민호','480-822','경기 의정부시 거북로 21 ','11','22','33',null,'1541593402256slsl2052','2018-10-7',2052,2,0);
Insert into LSM8655.MIN_TSHOP_SELL_GROUP (NO,MONEY,SHIP_MONEY,RMONEY,BANK,BANK_NUM,NAME,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,SHIP_MEMO,TIMES,DATES,GUEST_NO,STATUS,POINT) values (3102,123620,0,122382,'농협','70903-62-10238067','유운민호','135-230','서울 강남구 광평로 61 수정빌딩','010','0000','0000','123123','1539860287479slsl4302','2018-9-18',4302,2,0);
Insert into LSM8655.MIN_TSHOP_SELL_GROUP (NO,MONEY,SHIP_MONEY,RMONEY,BANK,BANK_NUM,NAME,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,SHIP_MEMO,TIMES,DATES,GUEST_NO,STATUS,POINT) values (5002,247500,0,235125,'농협','32817-23-18801704','민호','480-822','경기 의정부시 거북로 21 ','11','22','33',null,'1541659287739slsl2052','2018-10-8',2052,2,0);
Insert into LSM8655.MIN_TSHOP_SELL_GROUP (NO,MONEY,SHIP_MONEY,RMONEY,BANK,BANK_NUM,NAME,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,SHIP_MEMO,TIMES,DATES,GUEST_NO,STATUS,POINT) values (5102,139500,0,132525,'농협','79806-82-18303767','민호','480-822','경기 의정부시 거북로 21 ','11','22','33',null,'1542009918914slsl2052','2018-10-12',2052,1,0);
Insert into LSM8655.MIN_TSHOP_SELL_GROUP (NO,MONEY,SHIP_MONEY,RMONEY,BANK,BANK_NUM,NAME,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,SHIP_MEMO,TIMES,DATES,GUEST_NO,STATUS,POINT) values (3002,34000,0,33660,'농협','15484-43-12896809','유운민호','135-230','서울 강남구 광평로 61 수정빌딩','010','0000','0000',null,'1539859094879slsl4302','2018-9-18',4302,2,0);
REM INSERTING into LSM8655.MIN_TSHOP_VIEW_QNA
SET DEFINE OFF;
Insert into LSM8655.MIN_TSHOP_VIEW_QNA (NO,PRODUCT_NO,GUEST_NO,GUEST_ID,CATEGORY,MEMO,SECRET,DATES,ANSWER,ISANSWER,SELLERS_NO) values (102,2252,2052,'src***',4,'sdfsdfs',0,'2018-9-1',null,0,1002);
Insert into LSM8655.MIN_TSHOP_VIEW_QNA (NO,PRODUCT_NO,GUEST_NO,GUEST_ID,CATEGORY,MEMO,SECRET,DATES,ANSWER,ISANSWER,SELLERS_NO) values (252,4602,2052,'src***',4,'sdfdsf',0,'2018-9-1','123123123',1,1002);
Insert into LSM8655.MIN_TSHOP_VIEW_QNA (NO,PRODUCT_NO,GUEST_NO,GUEST_ID,CATEGORY,MEMO,SECRET,DATES,ANSWER,ISANSWER,SELLERS_NO) values (302,4602,2052,'src***',1,'ㄴㅇㄹㅇㄴㄹㄴㅇㄹㅇㄴㄹㄴㅇㄹㄴㅇㄹㄴㅇㄹㅇㄴㄹㄴㅇㄹㅇㄴㄹㄴㅇㄹㄴㅇㄹㄴㅇㄹㅇㄴㄹㄴㅇㄹㅇㄴㄹㄴㅇㄹㄴㅇㄹㄴㅇㄹㅇㄴㄹㄴㅇㄹㅇㄴㄹㄴㅇㄹㄴㅇㄹㄴㅇㄹㅇㄴㄹㄴㅇㄹㅇㄴㄹㄴㅇㄹㄴㅇㄹㄴㅇㄹㅇㄴㄹㄴㅇㄹㅇㄴㄹㄴㅇㄹㄴㅇㄹㄴㅇㄹㅇㄴㄹㄴㅇㄹㅇㄴㄹㄴㅇㄹㄴㅇㄹㄴㅇㄹㅇㄴㄹㄴㅇㄹㅇㄴㄹㄴㅇㄹㄴㅇㄹㄴㅇㄹㅇㄴㄹㄴㅇㄹㅇㄴㄹㄴㅇㄹㄴㅇㄹㄴㅇㄹㅇㄴㄹㄴㅇㄹㅇㄴㄹㄴㅇㄹㄴㅇㄹㄴㅇㄹㅇㄴㄹㄴㅇㄹㅇㄴㄹㄴㅇㄹㄴㅇㄹㄴㅇㄹㅇㄴㄹㄴㅇㄹㅇㄴㄹㄴㅇㄹㄴㅇㄹㄴㅇㄹㅇㄴㄹㄴㅇㄹㅇㄴㄹㄴㅇㄹㄴㅇㄹㄴㅇㄹㅇㄴㄹㄴㅇㄹㅇㄴㄹㄴㅇㄹㄴㅇㄹㄴㅇㄹㅇㄴㄹㄴㅇㄹㅇㄴㄹㄴㅇㄹㄴㅇㄹ',0,'2018-9-1','답변입니다.',1,1002);
Insert into LSM8655.MIN_TSHOP_VIEW_QNA (NO,PRODUCT_NO,GUEST_NO,GUEST_ID,CATEGORY,MEMO,SECRET,DATES,ANSWER,ISANSWER,SELLERS_NO) values (352,4302,2052,'src***',1,'sdfdsfdsf',1,'2018-9-2',null,0,1002);
Insert into LSM8655.MIN_TSHOP_VIEW_QNA (NO,PRODUCT_NO,GUEST_NO,GUEST_ID,CATEGORY,MEMO,SECRET,DATES,ANSWER,ISANSWER,SELLERS_NO) values (1402,2502,2052,'src***',2,'dsdds',0,'2018-9-8',null,0,1002);
Insert into LSM8655.MIN_TSHOP_VIEW_QNA (NO,PRODUCT_NO,GUEST_NO,GUEST_ID,CATEGORY,MEMO,SECRET,DATES,ANSWER,ISANSWER,SELLERS_NO) values (1352,4402,2052,'src***',1,'2223232',0,'2018-9-8',null,0,1002);
Insert into LSM8655.MIN_TSHOP_VIEW_QNA (NO,PRODUCT_NO,GUEST_NO,GUEST_ID,CATEGORY,MEMO,SECRET,DATES,ANSWER,ISANSWER,SELLERS_NO) values (2502,2202,2052,'src***',4,'22',1,'2018-10-8','33',1,1002);
Insert into LSM8655.MIN_TSHOP_VIEW_QNA (NO,PRODUCT_NO,GUEST_NO,GUEST_ID,CATEGORY,MEMO,SECRET,DATES,ANSWER,ISANSWER,SELLERS_NO) values (2,2252,2052,'src***',2,'ㄴㅇㄹㄴㅇㄹㄴㅇㄹㄴㅇ
ㄹ
ㅇㄴㄹ
ㄴㅇㄹ
ㄴㅇㄹㄴㅇㄹ',0,'2018-9-1',null,0,1002);
Insert into LSM8655.MIN_TSHOP_VIEW_QNA (NO,PRODUCT_NO,GUEST_NO,GUEST_ID,CATEGORY,MEMO,SECRET,DATES,ANSWER,ISANSWER,SELLERS_NO) values (52,2252,2052,'src***',3,'ㄴㅇㅇㄴㄹㅇㄴㄹㅇㄴㄹ',1,'2018-9-1',null,0,1002);
Insert into LSM8655.MIN_TSHOP_VIEW_QNA (NO,PRODUCT_NO,GUEST_NO,GUEST_ID,CATEGORY,MEMO,SECRET,DATES,ANSWER,ISANSWER,SELLERS_NO) values (452,4602,2052,'src***',1,'sdfdsfdsfdsfs',0,'2018-9-2','213123',1,1002);
Insert into LSM8655.MIN_TSHOP_VIEW_QNA (NO,PRODUCT_NO,GUEST_NO,GUEST_ID,CATEGORY,MEMO,SECRET,DATES,ANSWER,ISANSWER,SELLERS_NO) values (502,4602,2052,'src***',3,'sdfsdffsdsdf',1,'2018-9-2',null,0,1002);
Insert into LSM8655.MIN_TSHOP_VIEW_QNA (NO,PRODUCT_NO,GUEST_NO,GUEST_ID,CATEGORY,MEMO,SECRET,DATES,ANSWER,ISANSWER,SELLERS_NO) values (552,4602,2052,'src***',3,'sdfsdfsdf',0,'2018-9-2',null,0,1002);
Insert into LSM8655.MIN_TSHOP_VIEW_QNA (NO,PRODUCT_NO,GUEST_NO,GUEST_ID,CATEGORY,MEMO,SECRET,DATES,ANSWER,ISANSWER,SELLERS_NO) values (1452,2152,4302,'qwq***',2,'qwewqewqeqwewqewww',1,'2018-9-19','2222222',1,1002);
Insert into LSM8655.MIN_TSHOP_VIEW_QNA (NO,PRODUCT_NO,GUEST_NO,GUEST_ID,CATEGORY,MEMO,SECRET,DATES,ANSWER,ISANSWER,SELLERS_NO) values (1502,2152,4302,'qwq***',4,'1111111111',0,'2018-9-19','dfsdfsdfsd',1,1002);
REM INSERTING into LSM8655.MIN_TSHOP_VIEW_REVIEW
SET DEFINE OFF;
Insert into LSM8655.MIN_TSHOP_VIEW_REVIEW (NO,GUEST_NO,PRODUCT_NO,STARS,REVIEW1,REVIEW2,MEMO,DATES,GUEST_ID) values (352,2052,2502,4,'보통이에요','보통이에요','dsfsdf','2018-9-8','src***');
Insert into LSM8655.MIN_TSHOP_VIEW_REVIEW (NO,GUEST_NO,PRODUCT_NO,STARS,REVIEW1,REVIEW2,MEMO,DATES,GUEST_ID) values (502,4302,4352,4,'보통이에요','좋아요','sdfsfdsfdsdfsdf','2018-9-18','qwq***');
Insert into LSM8655.MIN_TSHOP_VIEW_REVIEW (NO,GUEST_NO,PRODUCT_NO,STARS,REVIEW1,REVIEW2,MEMO,DATES,GUEST_ID) values (552,4302,7252,1,'별로에요','별로에요','dssdfdf

sdfdsf
dsf
dsf
sdf','2018-9-18','qwq***');
Insert into LSM8655.MIN_TSHOP_VIEW_REVIEW (NO,GUEST_NO,PRODUCT_NO,STARS,REVIEW1,REVIEW2,MEMO,DATES,GUEST_ID) values (252,2052,4602,3,'보통이에요','보통이에요','항상 쓰는거지만 매번 다른거 같아요.느낌이 그래서 그런가?바꿀때가 된건지..ㅜㅜ,조금씩 실앙이..','2018-9-4','src***');
Insert into LSM8655.MIN_TSHOP_VIEW_REVIEW (NO,GUEST_NO,PRODUCT_NO,STARS,REVIEW1,REVIEW2,MEMO,DATES,GUEST_ID) values (302,2052,2252,5,'좋아요','좋아요','ㅇㅇㅇ','2018-9-8','src***');
Insert into LSM8655.MIN_TSHOP_VIEW_REVIEW (NO,GUEST_NO,PRODUCT_NO,STARS,REVIEW1,REVIEW2,MEMO,DATES,GUEST_ID) values (152,2052,4602,1,'별로에요','별로에요','아기 물티슈 믿고 샀는데 물티슈에 곰방이가 핀걸 이제야 발견했습니다. 곰팡이 있는걸로 여태 아이 엉덩이랑 얼굴이랑 닦았다니 참담합니다. 몇개 업체의 물티슈를 써봤지만 이런경우는 첨이라서 당황스럽네요. ','2018-9-4','src***');
Insert into LSM8655.MIN_TSHOP_VIEW_REVIEW (NO,GUEST_NO,PRODUCT_NO,STARS,REVIEW1,REVIEW2,MEMO,DATES,GUEST_ID) values (202,2052,4602,5,'좋아요','좋아요','아기티슈는 앙블랑만 쓰는데 개인적으로 화이트가 제일 좋은 것 같네요. 아기입주위,엉덩이 등 민감한 피부에 닿아도 발진도 안생기고 마음에 듭니다^^','2018-9-4','src***');
Insert into LSM8655.MIN_TSHOP_VIEW_REVIEW (NO,GUEST_NO,PRODUCT_NO,STARS,REVIEW1,REVIEW2,MEMO,DATES,GUEST_ID) values (2402,2052,2202,4,'별로에요','별로에요','sdfsdf11111111111111111111111','2018-10-2','src***');
Insert into LSM8655.MIN_TSHOP_VIEW_REVIEW (NO,GUEST_NO,PRODUCT_NO,STARS,REVIEW1,REVIEW2,MEMO,DATES,GUEST_ID) values (3402,2052,2202,4,'별로에요','별로에요','111','2018-10-8','src***');
Insert into LSM8655.MIN_TSHOP_VIEW_REVIEW (NO,GUEST_NO,PRODUCT_NO,STARS,REVIEW1,REVIEW2,MEMO,DATES,GUEST_ID) values (3452,2052,2202,3,'보통이에요','보통이에요','dsfdf','2018-10-22','src***');
Insert into LSM8655.MIN_TSHOP_VIEW_REVIEW (NO,GUEST_NO,PRODUCT_NO,STARS,REVIEW1,REVIEW2,MEMO,DATES,GUEST_ID) values (1402,2052,4502,3,'보통이에요','보통이에요','sdffds','2018-9-19','src***');
--------------------------------------------------------
--  DDL for Index MIN_TSHOP_FAQ_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LSM8655"."MIN_TSHOP_FAQ_PK" ON "LSM8655"."MIN_TSHOP_FAQ" ("NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index MIN_TSHOP_LIST_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LSM8655"."MIN_TSHOP_LIST_PK" ON "LSM8655"."MIN_TSHOP_LIST" ("NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index MIN_TSHOP_MEMBER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LSM8655"."MIN_TSHOP_MEMBER_PK" ON "LSM8655"."MIN_TSHOP_MEMBER" ("NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index MIN_TSHOP_QNA_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LSM8655"."MIN_TSHOP_QNA_PK" ON "LSM8655"."MIN_TSHOP_QNA" ("NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index MIN_TSHOP_SELL_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LSM8655"."MIN_TSHOP_SELL_PK" ON "LSM8655"."MIN_TSHOP_SELL" ("NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index MIN_TSHOP_SELL_GROUP_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LSM8655"."MIN_TSHOP_SELL_GROUP_PK" ON "LSM8655"."MIN_TSHOP_SELL_GROUP" ("NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index MIN_TSHOP_VIEW_QNA_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LSM8655"."MIN_TSHOP_VIEW_QNA_PK" ON "LSM8655"."MIN_TSHOP_VIEW_QNA" ("NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index MIN_TSHOP_VIEW_REVIEW_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LSM8655"."MIN_TSHOP_VIEW_REVIEW_PK" ON "LSM8655"."MIN_TSHOP_VIEW_REVIEW" ("NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Trigger MIN_TSHOP_FAQ_TRI
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LSM8655"."MIN_TSHOP_FAQ_TRI" 
   before insert on "LSM8655"."MIN_TSHOP_FAQ" 
   for each row 
begin  
   if inserting then 
      if :NEW."NO" is null then 
         select MIN_TSHOP_FAQ_SEQ.nextval into :NEW."NO" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "LSM8655"."MIN_TSHOP_FAQ_TRI" ENABLE;
--------------------------------------------------------
--  DDL for Trigger MIN_TSHOP_LIST_TRI
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LSM8655"."MIN_TSHOP_LIST_TRI" 
   before insert on "LSM8655"."MIN_TSHOP_LIST" 
   for each row 
begin  
   if inserting then 
      if :NEW."NO" is null then 
         select MIN_TSHOP_LIST_SEQ.nextval into :NEW."NO" from dual; 
      end if; 
   end if; 
end;


/
ALTER TRIGGER "LSM8655"."MIN_TSHOP_LIST_TRI" ENABLE;
--------------------------------------------------------
--  DDL for Trigger MIN_TSHOP_MEMBER_TRI
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LSM8655"."MIN_TSHOP_MEMBER_TRI" 
   before insert on "LSM8655"."MIN_TSHOP_MEMBER" 
   for each row 
begin  
   if inserting then 
      if :NEW."NO" is null then 
         select MIN_TSHOP_MEMBER_SEQ.nextval into :NEW."NO" from dual; 
      end if; 
   end if; 
end;


/
ALTER TRIGGER "LSM8655"."MIN_TSHOP_MEMBER_TRI" ENABLE;
--------------------------------------------------------
--  DDL for Trigger MIN_TSHOP_QNA_TRI
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LSM8655"."MIN_TSHOP_QNA_TRI" 
   before insert on "LSM8655"."MIN_TSHOP_QNA" 
   for each row 
begin  
   if inserting then 
      if :NEW."NO" is null then 
         select MIN_TSHOP_QNA_SEQ.nextval into :NEW."NO" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "LSM8655"."MIN_TSHOP_QNA_TRI" ENABLE;
--------------------------------------------------------
--  DDL for Trigger MIN_TSHOP_SELL_TRI
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LSM8655"."MIN_TSHOP_SELL_TRI" 
   before insert on "LSM8655"."MIN_TSHOP_SELL" 
   for each row 
begin  
   if inserting then 
      if :NEW."NO" is null then 
         select MIN_TSHOP_SELL_SEQ.nextval into :NEW."NO" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "LSM8655"."MIN_TSHOP_SELL_TRI" ENABLE;
--------------------------------------------------------
--  DDL for Trigger MIN_TSHOP_SELL_GROUP_TRI
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LSM8655"."MIN_TSHOP_SELL_GROUP_TRI" 
   before insert on "LSM8655"."MIN_TSHOP_SELL_GROUP" 
   for each row 
begin  
   if inserting then 
      if :NEW."NO" is null then 
         select MIN_TSHOP_SELL_GROUP_SEQ.nextval into :NEW."NO" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "LSM8655"."MIN_TSHOP_SELL_GROUP_TRI" ENABLE;
--------------------------------------------------------
--  DDL for Trigger MIN_TSHOP_VIEW_QNA_TRI
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LSM8655"."MIN_TSHOP_VIEW_QNA_TRI" 
   before insert on "LSM8655"."MIN_TSHOP_VIEW_QNA" 
   for each row 
begin  
   if inserting then 
      if :NEW."NO" is null then 
         select MIN_TSHOP_VIEW_QNA_SEQ.nextval into :NEW."NO" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "LSM8655"."MIN_TSHOP_VIEW_QNA_TRI" ENABLE;
--------------------------------------------------------
--  DDL for Trigger MIN_TSHOP_VIEW_REVIEW_TRI
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LSM8655"."MIN_TSHOP_VIEW_REVIEW_TRI" 
   before insert on "LSM8655"."MIN_TSHOP_VIEW_REVIEW" 
   for each row 
begin  
   if inserting then 
      if :NEW."NO" is null then 
         select MIN_TSHOP_VIEW_REVIEW_SEQ.nextval into :NEW."NO" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "LSM8655"."MIN_TSHOP_VIEW_REVIEW_TRI" ENABLE;
--------------------------------------------------------
--  Constraints for Table MIN_TSHOP_FAQ
--------------------------------------------------------

  ALTER TABLE "LSM8655"."MIN_TSHOP_FAQ" ADD CONSTRAINT "MIN_TSHOP_FAQ_PK" PRIMARY KEY ("NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "LSM8655"."MIN_TSHOP_FAQ" MODIFY ("NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MIN_TSHOP_LIST
--------------------------------------------------------

  ALTER TABLE "LSM8655"."MIN_TSHOP_LIST" MODIFY ("NO" NOT NULL ENABLE);
  ALTER TABLE "LSM8655"."MIN_TSHOP_LIST" ADD CONSTRAINT "MIN_TSHOP_LIST_PK" PRIMARY KEY ("NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table MIN_TSHOP_MEMBER
--------------------------------------------------------

  ALTER TABLE "LSM8655"."MIN_TSHOP_MEMBER" MODIFY ("NO" NOT NULL ENABLE);
  ALTER TABLE "LSM8655"."MIN_TSHOP_MEMBER" ADD CONSTRAINT "MIN_TSHOP_MEMBER_PK" PRIMARY KEY ("NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table MIN_TSHOP_QNA
--------------------------------------------------------

  ALTER TABLE "LSM8655"."MIN_TSHOP_QNA" ADD CONSTRAINT "MIN_TSHOP_QNA_PK" PRIMARY KEY ("NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "LSM8655"."MIN_TSHOP_QNA" MODIFY ("NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MIN_TSHOP_SELL
--------------------------------------------------------

  ALTER TABLE "LSM8655"."MIN_TSHOP_SELL" ADD CONSTRAINT "MIN_TSHOP_SELL_PK" PRIMARY KEY ("NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "LSM8655"."MIN_TSHOP_SELL" MODIFY ("NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MIN_TSHOP_SELL_GROUP
--------------------------------------------------------

  ALTER TABLE "LSM8655"."MIN_TSHOP_SELL_GROUP" ADD CONSTRAINT "MIN_TSHOP_SELL_GROUP_PK" PRIMARY KEY ("NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "LSM8655"."MIN_TSHOP_SELL_GROUP" MODIFY ("NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MIN_TSHOP_VIEW_QNA
--------------------------------------------------------

  ALTER TABLE "LSM8655"."MIN_TSHOP_VIEW_QNA" ADD CONSTRAINT "MIN_TSHOP_VIEW_QNA_PK" PRIMARY KEY ("NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "LSM8655"."MIN_TSHOP_VIEW_QNA" MODIFY ("NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MIN_TSHOP_VIEW_REVIEW
--------------------------------------------------------

  ALTER TABLE "LSM8655"."MIN_TSHOP_VIEW_REVIEW" ADD CONSTRAINT "MIN_TSHOP_VIEW_REVIEW_PK" PRIMARY KEY ("NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "LSM8655"."MIN_TSHOP_VIEW_REVIEW" MODIFY ("NO" NOT NULL ENABLE);
