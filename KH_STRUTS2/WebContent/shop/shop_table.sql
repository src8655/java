--------------------------------------------------------
--  ������ ������ - �����-11��-22-2018   
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
Insert into LSM8655.MIN_TSHOP_FAQ (NO,CATEGORY,SUBJECT,MEMO,DATES) values (202,3,'��ǰ�� ������ε�, ����� �� �ֳ���?','<p>&nbsp;</p>

<p><strong><img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCE0bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtbjJEYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2JG5%2BXmU0akR7eTI6ZUw6fiUjTV5sWDtLNV1FTko%3D" style="height:20px; width:20px" />��ǰ ���� ��&nbsp;��ǰ ��û ����<img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqIyE1bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtXTJFYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2P246XmM0akR7eTI6ZUw6fiUjTV5sWDtLal1BTko%3D" style="height:20px; width:20px" /></strong></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>��� ��û�� �Աݴ����/�����Ϸ�/����غ���(�߼� ��)������ �����ϸ�,</p>

<p>������� ��ǰ�� ���Ÿ� ������ �ʴ´ٸ� ���� �� ��ǰ��û����&nbsp;�����մϴ�.</p>

<p>&nbsp;</p>

<p>�ֹ��Ͻ� ��ǰ�� �̹� ������̶��, �ֹ��� ����Ͻ� �� ���� �� ���� ��Ź �帳�ϴ�.</p>

<p>&nbsp;</p>

<p>����, ������ ������ ��ǰ�ϴ� ���, �պ���ۺ� �Ǹ��ڿ��� �����Ͻø�</p>

<p>���� ��ۺ� ������ �����ݾ� ������ ȯ���Ͽ� �帳�ϴ�.</p>

<p>&nbsp;</p>

<p>��ۻ��� �� ���ó���� �Ʒ��� �����ϴ�.</p>

<p>&nbsp;</p>

<p><strong>&nbsp;1&nbsp;&nbsp;�Աݴ����/�����Ϸ�</strong></p>

<p>&nbsp;.-&nbsp; �ֹ����� �Ǹ��ڿ��� �Ѿ�� ���� �ܰ��̸�,&nbsp;��� ��û �� ��� ��Ұ� ó���˴ϴ�.</p>

<p>&nbsp;</p>

<p><strong>&nbsp;2&nbsp;&nbsp;����غ���</strong></p>

<p>&nbsp;.-&nbsp; �ֹ����� �Ǹ��ڿ��� �Ѿ �ܰ��̸�,&nbsp;�Ǹ����� ��ǰ �߼ۿ��ο� ���� ��Ұ� ó���˴ϴ�.</p>

<p>&nbsp;.-&nbsp; ��ǰ �߼��۾��� ������� ���� ���, ��� ��û �� ��� ��Ұ� ó���˴ϴ�.</p>

<p>&nbsp;.-&nbsp; ��ǰ �߼��۾��� ����� ���, ��� ��û �� ��Ұ� �źεǸ� ��ǰ���� �� ��ǰ���� ����˴ϴ�.</p>

<p>&nbsp;</p>

<p><strong>&nbsp;3&nbsp;&nbsp;�����/��ۿϷ�</strong></p>

<p><strong>&nbsp;</strong>&nbsp;<strong>-&nbsp;</strong>��ǰ �߼��۾��� �Ϸ�� ������, ��ǰ ���� �� ��ǰ ��û�� �����մϴ�.</p>
','2018-9-5');
Insert into LSM8655.MIN_TSHOP_FAQ (NO,CATEGORY,SUBJECT,MEMO,DATES) values (252,3,'����ߴµ� ��ҳ����� ��� Ȯ���ϳ���.','<p><strong><strong><img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCE0bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtbjJEYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2JG5%2BXmU0akR7eTI6ZUw6fiUjTV5sWDtLNV1FTko%3D" style="height:20px; width:20px" />���/��ǰ/��ȯ ��Ȳ���� Ȯ��<img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqIyE1bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtXTJFYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2P246XmM0akR7eTI6ZUw6fiUjTV5sWDtLal1BTko%3D" style="height:20px; width:20px" /></strong></strong></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><a href="http://www.11st.co.kr/order/OrderList.tmall?type=cancelRequest" target="_blank"><strong><img alt="��â ����" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCEqbGx8XH0jIV4zLTVNKjRr%0AN3xjeUEtMzJtYDFtS2wsay80N31dKjorO2BsbjJ7MSltTGBOa3h7RCEzfCtcbnpcTjFMRTMwLERO%0AXTMrKSQufi9uQGo2LG5AXjE0akR7eTI6ZUx5fi0jQV4xWGtLNF1FTko%3D" />&nbsp;��� ��û ������</strong></a></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>��ҽ�û �� ���� ���� üũ�� �Ǿ��ִٸ�&nbsp;SMS(Ȥ�� �˸���)�� ��ҳ����� ���۵˴ϴ�.</p>

<p>&nbsp;</p>

<p>����, ���� 11���� ���/��ǰ/��ȯ ��Ȳ �������� ���� Ȯ�� �����մϴ�.</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;&nbsp;</p>

<p><img alt="i����i����e����i����i����i����" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwlbSEpbDN8ayhhIVozTDRBZTlr%0AS3xjeUVhKlxaLTFrS2xtKS9aN31dIyUrLlgxbjJ7XiltX11tKT17RDYzfGpfbjlrTmVMKzNiJClE%0AWGwrKSROOi83QjUrbm1%2BNWw0S0RKeSs6bEwpfiojTV5jWGpLJl0hTi0%3D" style="height:150px; width:600px" /></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<table cellspacing="0" style="height:25px; width:500px">
	<tbody>
		<tr>
			<td style="background-color:#ffffff">
			<p><strong>&nbsp;����</strong></p>
			</td>
		</tr>
	</tbody>
</table>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;�� ����غ��� ������ �� ��� �� �Ǹ�ó�� ���� ��ǰ�� �߼� ���� Ȯ�� �� �����մϴ�.</p>

<p>&nbsp;�� �Ǹ��ڿ� ������ ����� ���, �ֹ��� ��ǰ ������ �ϴܿ� ��ǰ Q&amp;A�� ���� ��Ź �帳�ϴ�.</p>
','2018-9-5');
Insert into LSM8655.MIN_TSHOP_FAQ (NO,CATEGORY,SUBJECT,MEMO,DATES) values (302,4,'��ҿ� ��ǰ�� �������� �����ΰ���.','<p><strong><img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCE0bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtbjJEYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2JG5%2BXmU0akR7eTI6ZUw6fiUjTV5sWDtLNV1FTko%3D" style="height:20px; width:20px" />�Ǹ��ڰ� ��ǰ�� �߼��� �ߴ����� ���� ����<img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqIyE1bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtXTJFYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2P246XmM0akR7eTI6ZUw6fiUjTV5sWDtLal1BTko%3D" style="height:20px; width:20px" /></strong></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><a href="http://buy.11st.co.kr/order/OrderList.tmall" target="_blank"><strong><img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCEqbGx8XH0jIV4zLTVNKjRr%0AN3xjeUEtMzJtYDFtS2wsay80N31dKjorO2BsbjJ7MSltTGBOa3h7RCEzfCtcbnpcTjFMRTMwLERO%0AXTMrKSQufi9uQGo2LG5AXjE0akR7eTI6ZUx5fi0jQV4xWGtLNF1FTko%3D" />&nbsp;��ǰ �߼ۿ��� Ȯ�� ������</strong></a></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>��ҿ� ��ǰ�� �ֹ��� ��ǰ�� ���Ű��� �ǻ縦 ǥ���ϴ� �������,</p>

<p>�Ǹ����� ��ǰ �߼ۿ��θ� �������� ������ �˴ϴ�.</p>

<p>�ٷΰ���� �̵���&nbsp;������ ����&nbsp;<img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqbiEubEp8fn15IV4zSjRNbX1r%0AK3xleSEtKjJaYDFtS2w4ayk0MX1dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKWQufi9fQDU2bm5%2BXmw0fEQueSE6ZUxEfi0jQV5lWEVLOV1NTi0%3D" style="height:20px; width:53px" />&nbsp;Ŭ�� ��&nbsp;Ȯ�� �����մϴ�.</p>

<p>&nbsp;</p>

<p><strong>&nbsp;1&nbsp;&nbsp;���</strong></p>

<p><strong>&nbsp; -&nbsp;</strong>�Ǹ��ڰ� ��ǰ�� �߼��ϱ� ���� ���� (�Աݴ����, �����Ϸ�)</p>

<p>&nbsp;</p>

<p><strong>&nbsp;2&nbsp;&nbsp;��ǰ</strong></p>

<p><strong>&nbsp; -&nbsp;</strong>�Ǹ��ڰ� ��ǰ�� �߼��� ���� ���� (����غ���, �����, ��ۿϷ�)</p>
','2018-9-5');
Insert into LSM8655.MIN_TSHOP_FAQ (NO,CATEGORY,SUBJECT,MEMO,DATES) values (352,4,'�Ǹ��� �ּҴ� ��� Ȯ���ϳ���.','<p><strong><strong><img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCE0bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtbjJEYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2JG5%2BXmU0akR7eTI6ZUw6fiUjTV5sWDtLNV1FTko%3D" style="height:20px; width:20px" />�ֹ�/�����ȸ ���������� Ȯ��<img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqIyE1bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtXTJFYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2P246XmM0akR7eTI6ZUw6fiUjTV5sWDtLal1BTko%3D%22" /></strong></strong></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><a href="http://buy.11st.co.kr/order/OrderList.tmall" target="_blank"><strong><img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCEqbGx8XH0jIV4zLTVNKjRr%0AN3xjeUEtMzJtYDFtS2wsay80N31dKjorO2BsbjJ7MSltTGBOa3h7RCEzfCtcbnpcTjFMRTMwLERO%0AXTMrKSQufi9uQGo2LG5AXjE0akR7eTI6ZUx5fi0jQV4xWGtLNF1FTko%3D" />&nbsp;�ֹ�/�����ȸ ������</strong></a></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>���� 11���� �ֹ�/�����ȸ ���������� �Ǹ��� ���̵� Ŭ���ϸ� Ȯ�� �����մϴ�.</p>

<p>����, ��ǰ ���������� �̴ϸ������� Ȯ�� �����մϴ�.</p>

<p>&nbsp;</p>

<p>��, ��ǰ�� �����ϴ� ��� �Ǹ����ּҿ� ��ǰ �ּҰ� �ٸ� �� �����Ƿ�</p>

<p>��ǰ �ּҸ� �� Ȯ�� �� �����Ͻñ� �ٶ��ϴ�.</p>

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
Insert into LSM8655.MIN_TSHOP_FAQ (NO,CATEGORY,SUBJECT,MEMO,DATES) values (402,4,'��ǰ�� ��ǰ�ߴµ�, �ݼ� ����� ��ȣ�� ��� �Է��� �ϳ���.','<p><strong><img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCE0bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtbjJEYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2JG5%2BXmU0akR7eTI6ZUw6fiUjTV5sWDtLNV1FTko%3D" style="height:20px; width:20px" />���/��ǰ/��ȯ&nbsp;��Ȳ ���������� �Է�<img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqIyE1bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtXTJFYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2P246XmM0akR7eTI6ZUw6fiUjTV5sWDtLal1BTko%3D" style="height:20px; width:20px" /></strong></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><a href="http://buy.11st.co.kr/order/CancelStatusList.tmall" target="_blank"><strong><img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCEqbGx8XH0jIV4zLTVNKjRr%0AN3xjeUEtMzJtYDFtS2wsay80N31dKjorO2BsbjJ7MSltTGBOa3h7RCEzfCtcbnpcTjFMRTMwLERO%0AXTMrKSQufi9uQGo2LG5AXjE0akR7eTI6ZUx5fi0jQV4xWGtLNF1FTko%3D" />&nbsp;�ݼ��� ��ȣ �Է� ������</strong></a></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>��ǰ�� ��ǰ�� �Ǹ��ڿ��� �߼��� ��,&nbsp;</p>

<p>�ù��翡�� ���� �ݼ� ����� ��ȣ��&nbsp;11������ ����ϸ� ���� ��ǰó���� ������ �˴ϴ�.</p>

<p>&nbsp;</p>

<p><strong>&nbsp;1&nbsp;&nbsp;��ǰ��û �� ��ǰ�� &#39;�󼼳���&#39; Ŭ��</strong></p>

<p><img alt="i����i����e�ƣ�i����_e�ƣ�i����i����i����i����e����i����i����e?��_1" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwlYSFebEp8XChlITQzSjRFPSZr%0AN3xjeUFhP1wyLWVrMmwuKS9aN31dIyUrLlgxbjJ7XiltX11tKT17RDYzfGpfbjlrTmVMKzNiJClE%0AWGwrKSROKy9jQi4rJW0yNWw0akR7eUE6Y0wqfnkjTV4xWDtLKF1BTi0%3D" style="height:180px; width:600px" /></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><strong>&nbsp;2&nbsp;&nbsp;�ù�� ���� �� ���� ��ȣ �Է�</strong></p>

<p><img alt="i����i����e�ƣ�i����_e�ƣ�i����i����i����i����e����i����i����e?��_2" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwlLSFebEp8XChlITQzSjRFPSZr%0AN3xjeUFhLVwyLWVrMmwuKS9aN31dIyUrLlgxbjJ7XiltX11tKT17RDYzfGpfbjlrTmVMKzNiJClE%0AWGwrKSROKy9jQi4rJW1%2BNTE0akR7eUE6Y0wqfnkjTV4xWDtLKF1NTkw%3D" style="height:365px; width:600px" /></p>

<p>&nbsp;</p>
','2018-9-5');
Insert into LSM8655.MIN_TSHOP_FAQ (NO,CATEGORY,SUBJECT,MEMO,DATES) values (152,2,'�Ǽ��� ����Ȯ���� �������','<p><img alt="e����e|��e�ף�i����i����" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCE0bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtbjJEYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2JG5%2BXmU0akR7eTI6ZUw6fiUjTV5sWDtLNV1FTko%3D" style="height:20px; width:20px" /><strong>&nbsp;����Ȯ�� �� ��ǰ/��ȯ�� �Ǹ���&nbsp;Ȯ�� �� ó��</strong><img alt="e����e|��e�ף�e����" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqIyE1bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtXTJFYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2P246XmM0akR7eTI6ZUw6fiUjTV5sWDtLal1BTko%3D" style="height:20px; width:20px" /></p>

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

			<p>����Ȯ���� ��ǰ�� �����ϰڴٴ� �������� ���� �ǻ� ǥ���̸�,</p>

			<p>����Ȯ��&nbsp;�Ŀ��� �Ǹ��ڿ��� ��ǰ�� ����� �۱ݵǰ� �ŷ��� ����˴ϴ�.</p>

			<p>&nbsp;</p>

			<p>���� ��ǰ/��ȯ�� ����� �� ������,</p>

			<p>���������� �Ǹ��ڿ��� �����Ͽ� ó���� �����ϼž� �մϴ�.</p>

			<p>&nbsp;</p>

			<p>�Ǹ��ڿ� ���ǰ� �Ǿ� ��ǰ�� �ݼ��ϴ� ���</p>

			<p>���� ó���� ���� �޸�[����, ����ó, ��ǰ/��ȯ����, ��ȯ��ǰ, 11����]</p>

			<p>�����Ͽ�&nbsp;��ǰ�� �Բ�&nbsp;�����ֽñ� �ٶ��ϴ�.</p>

			<p>&nbsp;</p>
			</td>
			<td style="border-color:#c8c8c8 currentColor">&nbsp;</td>
		</tr>
	</tbody>
</table>

<p>&nbsp;</p>

<p>&nbsp;</p>
','2018-9-5');
Insert into LSM8655.MIN_TSHOP_FAQ (NO,CATEGORY,SUBJECT,MEMO,DATES) values (52,1,'[����] [PAYCO] ���� ������ ��� �ϳ���.','<p><img alt="e����e|��e�ף�i����i����" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCE0bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtbjJEYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2JG5%2BXmU0akR7eTI6ZUw6fiUjTV5sWDtLNV1FTko%3D" style="height:20px; width:20px" /><strong>PAYCO �������� ���� Ż��</strong><img alt="e����e|��e�ף�e����" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqIyE1bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtXTJFYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2P246XmM0akR7eTI6ZUw6fiUjTV5sWDtLal1BTko%3D" style="height:20px; width:20px" /></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><a href="http://www.payco.com/main.nhn" target="_blank"><img alt="NEW LINK" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqeSF9bC18XH0jIV4zLTVNKjRr%0AN3xjeUEtZTIpYGNtS2wsay80N31dKjorO2BsbjJ7MSltTGBOa3h7RCEzfCtcbnpcTjFMRTMwLERO%0AXTMrKSQufi9uQDQ2YG5%2BXmM0akR7eTI6ZUx5fi0jQV4xWCtLYl1BTjM%3D" style="height:20px; width:71px" /><strong>&nbsp;PAYCO Ȩ������</strong></a></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>PAYCO&nbsp;���񽺸� �����ϰ� ���� ���&nbsp;PAYCO Ȩ������ �Ǵ� ����� ���� ����&nbsp;Ż�� �����մϴ�.</p>
','2018-9-5');
Insert into LSM8655.MIN_TSHOP_FAQ (NO,CATEGORY,SUBJECT,MEMO,DATES) values (102,2,'����Ȯ���� ��� �ϳ���?','<p><img alt="e����e|��e�ף�i����i����" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCE0bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtbjJEYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2JG5%2BXmU0akR7eTI6ZUw6fiUjTV5sWDtLNV1FTko%3D" style="height:20px; width:20px" /><strong>�ֹ�/��� ��ȸ���� ����</strong><img alt="e����e|��e�ף�e����" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqIyE1bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtXTJFYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2P246XmM0akR7eTI6ZUw6fiUjTV5sWDtLal1BTko%3D" style="height:20px; width:20px" /></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><a href="http://buy.11st/.co.kr/order/orderlist.tmall" target="_blank"><img alt="e�ƣ�e����e�ƣ�e����" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqeSF9bC18XH0jIV4zLTVNKjRr%0AN3xjeUEtZTIpYGNtS2wsay80N31dKjorO2BsbjJ7MSltTGBOa3h7RCEzfCtcbnpcTjFMRTMwLERO%0AXTMrKSQufi9uQDQ2YG5%2BXmM0akR7eTI6ZUx5fi0jQV4xWCtLYl1BTjM%3D" style="height:20px; width:71px" />&nbsp;<strong>�ֹ�/��� ��ȸ</strong></a>&nbsp;</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>�ֹ��� ��ǰ ���� ��&nbsp;��ǰ/��ȯ�� �������� �ʴ´ٸ�&nbsp;����Ȯ����&nbsp;�����մϴ�.</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><strong>&nbsp;���&nbsp;</strong>&nbsp;<strong>���� 11���� &#39;�ֹ�/�����ȸ&#39;���� &#39;����Ȯ��&#39; Ŭ��</strong></p>

<p><img alt="i����i����i����i����" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQyMya2VCWlw%2FYSFebDN8XChlIX0zSjRBbnxr%0AO3xjeU0tYTIpM25rIWxbKTtaMSldZUAhfHplbjp7OylfZTNhKU4wKUUzMWprSjVcTnxMXzMoQ0Ru%0AWDErayZOMi9lQkUrXSpcXmU0a0ROeSs6Y0xafmUjTV4xYGs6KHhBTi0%3D" style="height:250px; width:600px" /></p>
','2018-9-5');
REM INSERTING into LSM8655.MIN_TSHOP_LIST
SET DEFINE OFF;
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (4302,3,'��Ʈ�� ǳ�̰��� ��Į�� ������� 600g',7200,5,'����',3000,'��ü���ù�','2018-9-19_1_ch3.jpg',null,'2018-9-19_1_ch3_1.jpg',null,null,null,'0',7,0,'2018-9-19',6840,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (4202,3,'��Ʈ�� ���󰡵� Į�� ���� 500g',5900,1,'����',3000,'��ü���ù�','2018-9-19_1_ch1.jpg',null,null,null,'2018-9-19_1_ch1_1.jpg','<p>1</p>
','0',5,0,'2018-9-19',5841,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (4252,3,'��Ʈ�� ���̿� ���� ��� 500g',6500,1,'ĳ����',3000,'CJ�������','2018-9-19_1_ch2.jpg',null,null,'2018-9-19_1_ch2_1.jpg',null,null,'0',60,12,'2018-9-19',6435,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (4352,3,'[�ູ�Ѹ���] No�׻��� �ѿ� ���Ÿ�500g',61810,1,'������',0,'�����ù�','2018-9-19_1_ch4.jpg','2018-9-19_1_ch4_1.jpg',null,null,null,null,'0',6,2,'2018-9-19',61191,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (4402,3,'û�� ����������ѿ� ������Ʈ 3ȣ',160400,11,'������',0,'CJ�������','2018-9-19_1_ch5.jpg',null,null,null,'2018-9-19_1_ch5_1.jpg',null,'0',72,15,'2018-9-19',142756,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (4452,4,'õ����� 5~6��� 20�Ѹ� ���� ����� ����� �߼�������Ʈ �ǰ���ǰ ���/�����',60000,5,'����-����/��â��',0,'�����ù�','2018-9-27_1_ch6_1.jpg','2018-9-27_1_ch6_1_1.jpg',null,null,null,null,'0',1,0,'2018-9-27',57000,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (4502,4,'�����ڸ��� ��� ��� 5~6 ��� 5 �Ѹ� ���/�����',40000,10,'����-����/Ⱦ����',0,'CJ�������','2018-9-27_1_ch6_2.jpg','2018-9-27_1_ch6_2_1.jpg',null,null,null,null,'0',29,23,'2018-9-27',36000,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (4552,4,'������ ȫ���+�ѻ��� ȫ����/�߼�������Ʈ/ȫ�ﰡ��/�鿪��/������Ʈ',70000,1,'������',0,'��ü���ù�','2018-9-27_1_ch6_3.jpg','2018-9-27_1_ch6_3_1.jpg',null,null,null,null,'0',1,1,'2018-9-27',69300,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (4602,4,'���ѻ� ��� ȫ���� ȫ�� �߼�������Ʈ ������ ������ȫ�ﰡ��',27900,5,'������',0,'��ü���ù�','2018-9-27_1_ch6_4.jpg','2018-9-27_1_ch6_4_1.jpg',null,null,null,null,'0',11,2,'2018-9-27',26505,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (4652,4,'������ȫ���� ���긮Ÿ��10mlx30��/������� ȫ�ﰡ��',88000,3,'������',0,'CJ�������','2018-9-27_1_ch6_5.jpg','2018-9-27_1_ch6_5_1.jpg',null,null,null,null,'0',4,0,'2018-9-27',85360,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (4702,4,'�ֻ�� ���þ� ��������1kg ������������1kg ������',29900,3,'������',0,'CJ�������','2018-9-27_1_ch6_6.jpg','2018-9-27_1_ch6_6_1.jpg',null,null,null,null,'0',6,1,'2018-9-27',29003,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (2002,1,'2018�� �ݽ�/�������� ��������10kg',30000,5,'������',0,'CJ�������','2018-9-14_4_test1.jpg',null,'2018-9-14_22_01_info.jpg',null,null,null,'0',7,11,'2018-9-14',28500,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (2052,1,'[�ܵ�Ư��] 17�� �ٽó��� ���ֽ� 20kg / ���ϵ���',48000,20,'������',0,'�����ù�','2018-9-14_6_test7.jpg',null,null,null,null,null,'0',15,1,'2018-9-14',38400,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (2102,1,'[17���] �ͻ�ó��� �ŵ����� 20kg / ����ǰ����',50000,2,'������',0,'CJ�������','2018-9-14_4_test6.jpg',null,null,null,null,null,'0',49,24,'2018-9-14',49000,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (2152,1,'�ϴù��� ���̽� 10kg',33000,10,'������',2500,'��ü���ù�','2018-9-14_4_test5.jpg',null,null,null,'2018-9-14_23_01_info.jpg',null,'0',40,2,'2018-9-14',29700,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (2202,1,'[17���] �����ݸ����� �ŵ����� 20kg / ����ǰ����',49500,5,'������',0,'CJ�������','2018-9-14_5_test4.jpg',null,null,'2018-9-14_24_01_info.jpg',null,null,'0',9,7,'2018-9-14',47025,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (2252,2,'��޻����ȥ�ռ�Ʈ/����û������ / ��޳�������',79000,15,'������',0,'�����ù�','2018-9-14_1_test8.jpg',null,null,null,null,null,'0',9,67,'2018-9-14',67150,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (2302,2,'����Ư��/������Ʈ/ī��ٿ� ������ 5Kg/��������',30000,2,'������',0,'��ü���ù�','2018-9-14_1_test9.jpg',null,null,null,null,null,'0',0,2,'2018-9-14',29400,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (2352,2,'[����] �߼� ���� ������ ������Ʈ! �ӽ�ũ ���̸�� 4kg 8kg',16000,5,'������',2500,'��ü���ù�','2018-9-14_1_test10.jpg',null,null,null,null,null,'0',36,5,'2018-9-14',15200,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (2402,2,'[2018�߼�������Ʈ] Ưǰ ���� ������Ʈ/��� �� ���� �ƺ�ī�� ����',19900,15,'������',0,'�����ù�','2018-9-14_1_11.jpg',null,null,null,null,null,'0',10,22,'2018-9-14',16915,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (2452,2,'[�����̳�] �˶� �޻�� ȫ�� 10KG',8000,5,'������',2500,'CJ�������','2018-9-14_1_test11.jpg',null,null,null,null,null,'0',19,2,'2018-9-14',7600,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (2502,2,'[Ư��]�޻�� ���/û�۲ܻ�� 5kg/10kg/ȫ��',25800,7,'������',0,'��ü���ù�','2018-9-14_1_test12.jpg',null,null,null,null,null,'0',7,9,'2018-9-14',23994,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (2552,2,'���ް��� ���� �к����� 4.5kg 22������ �߰�',16900,11,'������',0,'�����ù�','2018-9-14_1_test13.jpg',null,null,null,null,null,'0',5,0,'2018-9-14',15041,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (6452,4,'�ʳ����� ��Ÿ ��Ʈ�� 100% ��Ͽ��� �����ֽ� 1000ml ���� �ױ⽺',23900,8,'��Ʈ��',0,'�����ù�','2018-10-4_1_ch6_2.jpg','2018-10-4_1_ch6_2_1.jpg',null,null,null,null,'0',4,0,'2018-10-4',21988,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (6552,5,'���� ����ġŲ 2kg / ġŲ�ʰ�/�ֵ���/���ȷ���',6000,1,'������',3000,'�����ù�','2018-10-4_1_ch7_5.jpg','2018-10-4_1_ch7_5_1.jpg',null,null,null,null,'0',1,0,'2018-10-4',5940,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (6502,4,'�ǰ��� �ڿ��� ���� ���� �� �ױ⽺ ���� ����� ����',120000,5,'������',0,'CJ�������','2018-10-4_1_ch6_1.jpg',null,null,'2018-10-4_1_ch6_1_1.jpg',null,null,'0',4,0,'2018-10-4',114000,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (6602,5,'�򽼺� ��ǰ �ֵ��� 3�� 20�� ��Ű��!!',27000,2,'������',0,'CJ�������','2018-10-4_1_ch7_4.jpg','2018-10-4_1_ch7_4_1.jpg',null,null,null,null,'0',3,0,'2018-10-4',26460,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (6652,5,'�򽼺� �õ��ҽ���1810g 2��',28000,2,'������',0,'CJ�������','2018-10-4_1_ch7_3.jpg','2018-10-4_1_ch7_3_1.jpg',null,null,null,null,'0',5,0,'2018-10-4',27440,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (6702,5,'���ζ���ġŲ�ʰ�1kg+1kg/�������/����ġŲ/�踻��',15000,5,'������',0,'�����ù�','2018-10-4_1_ch7_2.jpg','2018-10-4_1_ch7_2_1.jpg',null,null,null,null,'0',4,0,'2018-10-4',14250,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (6752,5,'���ѱ� �Ŵ��� ���� �쵿��/�����Ѹ�*30�� ��',21000,2,'������',0,'CJ�������','2018-10-4_1_ch7_1.jpg','2018-10-4_1_ch7_1_1.jpg',null,null,null,null,'0',1,0,'2018-10-4',20580,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (6802,6,'[�ٴټҸ� ������] �Ѱ��� ��ȹ��Ʈ/����������Ʈ/���깰����',17000,1,'����',3000,'CJ�������','2018-10-4_2_ch7_5.jpg','2018-10-4_2_ch7_5_1.jpg',null,null,null,null,'0',2,0,'2018-10-4',16830,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (6852,6,'����ȫ��1�ڽ� ������1kg�̻� ����1.2kg�̻� 80���̻� 10�κ��̻�',68000,3,'������',0,'��ü���ù�','2018-10-4_2_ch7_4.jpg','2018-10-4_2_ch7_4_1.jpg',null,null,null,null,'0',4,0,'2018-10-4',65960,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (6902,6,'���ϼ��� �ڿ��� �ڼ� �빮�� 900g-1.1kg 1����',67000,2,'������ī',0,'CJ�������','2018-10-4_2_ch7_3.jpg','2018-10-4_2_ch7_3_1.jpg',null,null,null,null,'0',1,0,'2018-10-4',65660,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (6952,6,'���ϼ��� �ϵ� Ȱ���� 1kg���� (10��/15��/20��)',53000,5,'������',0,'CJ�������','2018-10-4_2_ch7_2.jpg','2018-10-4_2_ch7_2_1.jpg',null,null,null,null,'0',1,0,'2018-10-4',50350,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (7002,6,'���ϼ��� �װ����� ����ִ� ����Ÿ 800g, 1100g ����',37000,5,'ĳ����',0,'�����ù�','2018-10-4_2_ch7_1.jpg','2018-10-4_2_ch7_1_1.jpg',null,null,null,null,'0',4,0,'2018-10-4',35150,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (7052,7,'�ı�ġ2KG ��������ڿ� ���ϻ��� ��������� Ư��',24000,1,'������',2500,'��ü���ù�','2018-10-4_3_ch7_5.jpg','2018-10-4_3_ch7_5_1.jpg',null,null,null,null,'0',1,0,'2018-10-4',23760,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (7102,7,'������ġ �� �����ġ5kg/HACCP/�����ġ',21000,1,'������',0,'CJ�������','2018-10-4_4_ch7_4.jpg','2018-10-4_4_ch7_4_1.jpg',null,null,null,null,'0',3,0,'2018-10-4',20790,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (7152,7,'[�ڱ����ġ]Ȳ������ġ �Լҹ� ������ Ư������',27500,14,'������',0,'CJ�������','2018-10-4_3_ch7_3.jpg','2018-10-4_3_ch7_3_1.jpg',null,null,null,null,'0',7,0,'2018-10-4',23650,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (7202,7,'[�ڱ����ġ] (����) �ùٸ� �Ѱ���ġ 2kg',10900,10,'������',0,'CJ�������','2018-10-4_3_ch7_2.jpg','2018-10-4_3_ch7_2_1.jpg',null,null,null,null,'0',2,0,'2018-10-4',9810,1002);
Insert into LSM8655.MIN_TSHOP_LIST (NO,CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS) values (7252,7,'[�ڱ����ġ] �������ġ5Kg/10Kg/�߼۴��� ������ ��ġ[HACCP����]',17000,1,'������',0,'CJ�������','2018-10-4_3_ch7_1.jpg','2018-10-4_3_ch7_1_1.jpg',null,null,null,null,'0',3,1,'2018-10-4',16830,1002);
REM INSERTING into LSM8655.MIN_TSHOP_MEMBER
SET DEFINE OFF;
Insert into LSM8655.MIN_TSHOP_MEMBER (NO,NAME,USER_ID,USER_PW,EMAIL,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,COMPANY_NUMBER,ORDERS,BANK,BANK_NUM,POINT,QUEST,ANSWER) values (3152,'sss','sss','9F6E680CFAE7749EB6C486619254B9C','sss@navercom','152-130','���� ���α� �ݿ��� 867 ','11','22','33',null,1,null,null,0,4,'����');
Insert into LSM8655.MIN_TSHOP_MEMBER (NO,NAME,USER_ID,USER_PW,EMAIL,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,COMPANY_NUMBER,ORDERS,BANK,BANK_NUM,POINT,QUEST,ANSWER) values (4302,'�����ȣ','qwq6735','83ADCF56E1055BBB16772FB339127','qwq6735@naver.com','135-230','���� ������ ����� 61 ��������','010','0000','0000',null,1,null,null,4680,3,'����');
Insert into LSM8655.MIN_TSHOP_MEMBER (NO,NAME,USER_ID,USER_PW,EMAIL,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,COMPANY_NUMBER,ORDERS,BANK,BANK_NUM,POINT,QUEST,ANSWER) values (2002,'222','lsm8655','81DC9BDB52D04DC2036DBD8313ED055','sdfoisdfsdf','480-822','��� �����ν� �źϷ� 4 ','1','2','3','12312222000',3,'����','123123123',0,1,'����');
Insert into LSM8655.MIN_TSHOP_MEMBER (NO,NAME,USER_ID,USER_PW,EMAIL,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,COMPANY_NUMBER,ORDERS,BANK,BANK_NUM,POINT,QUEST,ANSWER) values (5302,'aaa111','aaa','47BCE5C74F589F4867DBD57E9CA9F88','aaa','135-860','���� ������ ������� 238 ��ī�̽�����','111','111','111',null,1,null,null,0,1,'111');
Insert into LSM8655.MIN_TSHOP_MEMBER (NO,NAME,USER_ID,USER_PW,EMAIL,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,COMPANY_NUMBER,ORDERS,BANK,BANK_NUM,POINT,QUEST,ANSWER) values (1002,'����ȣ','src8655','3162F8A6D36EC8DE769A2127BFFA651','src8655@naver.com','480-822','��� �����ν� �źϷ� 4 ','111','1111','1111','123456789',2,'99','99',0,2,'����');
Insert into LSM8655.MIN_TSHOP_MEMBER (NO,NAME,USER_ID,USER_PW,EMAIL,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,COMPANY_NUMBER,ORDERS,BANK,BANK_NUM,POINT,QUEST,ANSWER) values (2052,'��ȣ','src8822','D064802D1B2D5346936161E4340A7E9','srcsdf123','480-822','��� �����ν� �źϷ� 21 ','11','22','33',null,1,null,null,24148,2,'�������');
Insert into LSM8655.MIN_TSHOP_MEMBER (NO,NAME,USER_ID,USER_PW,EMAIL,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,COMPANY_NUMBER,ORDERS,BANK,BANK_NUM,POINT,QUEST,ANSWER) values (4352,'2222222','55','6512BD43D9CAA6E02C99BA82652DCA','77','413-140','��� ���ֽ� ���۰�� 80 ������','11','11','111','123123111',2,'22','33',0,2,'123');
REM INSERTING into LSM8655.MIN_TSHOP_QNA
SET DEFINE OFF;
Insert into LSM8655.MIN_TSHOP_QNA (NO,SUBJECT,MEMO,ANSWER,ISANSWER,DATES,GUEST_NO,CATEGORY) values (202,'������ �����ΰ���?11','<p>�ؿܹ�ۿ�</p>

<p>&nbsp;</p>

<p>������ �����ΰ���?</p>
',null,0,'2018-10-7',2052,2);
Insert into LSM8655.MIN_TSHOP_QNA (NO,SUBJECT,MEMO,ANSWER,ISANSWER,DATES,GUEST_NO,CATEGORY) values (52,'�����ִ� ��ǰ�� ��ƺ� �� �ֳ���?','<p>�����ִ� ��ǰ��</p>

<p>����;��</p>
','<p><img alt="e����e|��e�ף�i����i����" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCE0bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtbjJEYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2JG5%2BXmU0akR7eTI6ZUw6fiUjTV5sWDtLNV1FTko%3D" style="height:20px; width:20px" /><strong>����11�������� �� ���� Ȯ�� ����</strong><img alt="e����e|��e�ף�e����" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqIyE1bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtXTJFYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2P246XmM0akR7eTI6ZUw6fiUjTV5sWDtLal1BTko%3D" style="height:20px; width:20px" /></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>��ǰ ���������� ���� ��ǰ�� [���� 11���� - ���� ���� ��� - ���� ��ǰ]���� Ȯ���Ͻ� �� �ֽ��ϴ�.</p>

<p>����, ���� ��ǰ ���⿡�� ��ٱ��Ϸ� �̵� �Ǵ� ������ �����մϴ�.</p>

<p>&nbsp;</p>

<p><strong>&nbsp;1&nbsp;</strong>&nbsp;<strong>��ǰ������&nbsp;&#39;��&#39;&nbsp;��ư Ŭ��</strong></p>

<p>&nbsp;<img alt="i�ƣ�i���� i����i����i����i����i�ף�" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQyMya2VCWlw%2FZSF9bDN8figjIU0zMzVBI3xr%0AO3xjeU0tYTJEM19rS2x4KUVaMSldZUAhfHplbjp7OylfZTNhKU4wKUUzMWprSjVcTnxMXzMoQ0Ru%0AWDEraztOOi98QiYrSypcXmU0a0ROeSs6Y0wyfiUjQV4xYEs6YnhNTko%3D" style="height:250px; width:400px" /></p>

<p>&nbsp;</p>

<p>&nbsp;2&nbsp;&nbsp;<strong>���� 11���� &#39;���� ��ǰ&#39; Ŭ��</strong></p>

<p>&nbsp;<img alt="i�ƣ�i����i����i����" src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQyMya2VCWlw%2FbiEqbGx8aygjIU0zMzVBI3xr%0AO3xjeU0tYTJaM25rK2x4KUVaMSldZUAhfHplbjp7OylfZTNhKU4wKUUzMWprSjVcTnxMXzMoQ0Ru%0AWDEraztOOi9jQjsrXypcXmU0a0ROeSs6Y0wyfiUjQV4xYGo6NHhNTi0%3D" style="height:300px; width:400px" /></p>
',1,'2018-9-5',2052,5);
Insert into LSM8655.MIN_TSHOP_QNA (NO,SUBJECT,MEMO,ANSWER,ISANSWER,DATES,GUEST_NO,CATEGORY) values (102,'���������ȣ �߱��� ��� �ϳ���?','<p>���������ȣ �߱���</p>

<p>&nbsp;</p>

<p>��� �ϳ���?</p>
','<p><strong><img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCE0bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtbjJEYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2JG5%2BXmU0akR7eTI6ZUw6fiUjTV5sWDtLNV1FTko%3D" style="height:20px; width:20px" />����û Ȩ���������� �߱�<img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqIyE1bEp8XCgtIU0zTF5NbTRr%0AN3xjeUEtXTJFYGxtIWwsay80N31dKj8rfWBsbjJ7Tik4TFhOKS5DRCNKY3xcP3pfTmNMRTMmLClO%0AXTMrKSQufi9lQDI2P246XmM0akR7eTI6ZUw6fiUjTV5sWDtLal1BTko%3D" style="height:20px; width:20px" /></strong></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><a href="http://portal.customs.go.kr/main.html" target="_blank"><strong><img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCEqbGx8XH0jIV4zLTVNKjRr%0AN3xjeUEtMzJtYDFtS2wsay80N31dKjorO2BsbjJ7MSltTGBOa3h7RCEzfCtcbnpcTjFMRTMwLERO%0AXTMrKSQufi9uQGo2LG5AXjE0akR7eTI6ZUx5fi0jQV4xWGtLNF1FTko%3D" />&nbsp;����û Ȩ������</strong></a></p>

<p><a href="https://unipass.customs.go.kr/csp/persIndex.do" target="_blank"><strong><img src="https://help.11st.co.kr/servlet/DownLoadAttach?fileInfo=KTllLV9rTGNCS0JsMEJDLksvfERfK3kjQC5lNC9dQ3kyL2VCWlwqYCEqbGx8XH0jIV4zLTVNKjRr%0AN3xjeUEtMzJtYDFtS2wsay80N31dKjorO2BsbjJ7MSltTGBOa3h7RCEzfCtcbnpcTjFMRTMwLERO%0AXTMrKSQufi9uQGo2LG5AXjE0akR7eTI6ZUx5fi0jQV4xWGtLNF1FTko%3D" />&nbsp;�������������ȣ �߱� �Ŵ��� ����</strong></a></p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p>ȸ������ ����&nbsp;����û Ȩ���������� ����� �ֹε�Ϲ�ȣ �Է� ��,</p>

<p>����������/�޴������� �����Ͻø� �߱޹����� �� �ֽ��ϴ�.</p>

<p>&nbsp;</p>

<p>�������������ȣ�� P�� �����ϴ� 13�ڸ� ��ȣ�� �����Ǹ�,</p>

<p>����������ȣ�� ���� ���࿡ ���� �ֹε�Ϲ�ȣ�� ��ü�� �����Դϴ�.</p>
',1,'2018-9-5',2052,1);
Insert into LSM8655.MIN_TSHOP_QNA (NO,SUBJECT,MEMO,ANSWER,ISANSWER,DATES,GUEST_NO,CATEGORY) values (302,'1231231','<p>123123123</p>
',null,0,'2018-9-19',4302,3);
REM INSERTING into LSM8655.MIN_TSHOP_SELL
SET DEFINE OFF;
Insert into LSM8655.MIN_TSHOP_SELL (NO,GUEST_NO,SELLERS_NO,PRODUCT_NO,PRODUCT_NAME,COUNTS,MONEY,SHIP_MONEY,RMONEY,DATES,SHIP_DATES,SHIP_COMPANY,STATUS,ADDR,ZIPCODE,SHIP_MEMO,NAME,PHONE1,PHONE2,PHONE3,FILE1,TIMES,SHIP_NUM,HASREVIEW) values (4652,2052,1002,2252,'��޻����ȥ�ռ�Ʈ/����û������ / ��޳�������',1,79000,0,67150,'2018-9-8',null,'�����ù�',5,'��� �����ν� �źϷ� 21 ','480-822',null,'��ȣ','11','22','33','2018-9-14_1_test8.jpg','1538986548703slsl2052','222',1);
Insert into LSM8655.MIN_TSHOP_SELL (NO,GUEST_NO,SELLERS_NO,PRODUCT_NO,PRODUCT_NAME,COUNTS,MONEY,SHIP_MONEY,RMONEY,DATES,SHIP_DATES,SHIP_COMPANY,STATUS,ADDR,ZIPCODE,SHIP_MEMO,NAME,PHONE1,PHONE2,PHONE3,FILE1,TIMES,SHIP_NUM,HASREVIEW) values (4702,2052,1002,6452,'�ʳ����� ��Ÿ ��Ʈ�� 100% ��Ͽ��� �����ֽ� 1000ml ���� �ױ⽺',1,23900,0,21988,'2018-9-8',null,'�����ù�',3,'��� �����ν� �źϷ� 21 ','480-822',null,'��ȣ','11','22','33','2018-10-4_1_ch6_2.jpg','1538989823886slsl2052',null,0);
Insert into LSM8655.MIN_TSHOP_SELL (NO,GUEST_NO,SELLERS_NO,PRODUCT_NO,PRODUCT_NAME,COUNTS,MONEY,SHIP_MONEY,RMONEY,DATES,SHIP_DATES,SHIP_COMPANY,STATUS,ADDR,ZIPCODE,SHIP_MEMO,NAME,PHONE1,PHONE2,PHONE3,FILE1,TIMES,SHIP_NUM,HASREVIEW) values (4752,2052,1002,4502,'�����ڸ��� ��� ��� 5~6 ��� 5 �Ѹ� ���/�����',7,280000,0,252000,'2018-9-8',null,'CJ�������',5,'��� �����ν� �źϷ� 21 ','480-822',null,'��ȣ','11','22','33','2018-9-27_1_ch6_2.jpg','1538989823886slsl2052','123123',1);
Insert into LSM8655.MIN_TSHOP_SELL (NO,GUEST_NO,SELLERS_NO,PRODUCT_NO,PRODUCT_NAME,COUNTS,MONEY,SHIP_MONEY,RMONEY,DATES,SHIP_DATES,SHIP_COMPANY,STATUS,ADDR,ZIPCODE,SHIP_MEMO,NAME,PHONE1,PHONE2,PHONE3,FILE1,TIMES,SHIP_NUM,HASREVIEW) values (4802,2052,1002,2502,'[Ư��]�޻�� ���/û�۲ܻ�� 5kg/10kg/ȫ��',4,103200,0,95976,'2018-9-8',null,'��ü���ù�',5,'��� �����ν� �źϷ� 21 ','480-822',null,'��ȣ','11','22','33','2018-9-14_1_test12.jpg','1538989823886slsl2052','213123',1);
Insert into LSM8655.MIN_TSHOP_SELL (NO,GUEST_NO,SELLERS_NO,PRODUCT_NO,PRODUCT_NAME,COUNTS,MONEY,SHIP_MONEY,RMONEY,DATES,SHIP_DATES,SHIP_COMPANY,STATUS,ADDR,ZIPCODE,SHIP_MEMO,NAME,PHONE1,PHONE2,PHONE3,FILE1,TIMES,SHIP_NUM,HASREVIEW) values (4852,2052,1002,2202,'[17���] �����ݸ����� �ŵ����� 20kg / ����ǰ����',1,49500,0,47025,'2018-9-8',null,'CJ�������',5,'��� �����ν� �źϷ� 21 ','480-822',null,'��ȣ','11','22','33','2018-9-14_5_test4.jpg','1538989823886slsl2052','12312',1);
Insert into LSM8655.MIN_TSHOP_SELL (NO,GUEST_NO,SELLERS_NO,PRODUCT_NO,PRODUCT_NAME,COUNTS,MONEY,SHIP_MONEY,RMONEY,DATES,SHIP_DATES,SHIP_COMPANY,STATUS,ADDR,ZIPCODE,SHIP_MEMO,NAME,PHONE1,PHONE2,PHONE3,FILE1,TIMES,SHIP_NUM,HASREVIEW) values (6252,2052,1002,2202,'[17���] �����ݸ����� �ŵ����� 20kg / ����ǰ����',3,148500,0,141075,'2018-10-7',null,'CJ�������',5,'��� �����ν� �źϷ� 21 ','480-822',null,'��ȣ','11','22','33','2018-9-14_5_test4.jpg','1541593402256slsl2052','111',1);
Insert into LSM8655.MIN_TSHOP_SELL (NO,GUEST_NO,SELLERS_NO,PRODUCT_NO,PRODUCT_NAME,COUNTS,MONEY,SHIP_MONEY,RMONEY,DATES,SHIP_DATES,SHIP_COMPANY,STATUS,ADDR,ZIPCODE,SHIP_MEMO,NAME,PHONE1,PHONE2,PHONE3,FILE1,TIMES,SHIP_NUM,HASREVIEW) values (5302,4302,1002,4352,'[�ູ�Ѹ���] No�׻��� �ѿ� ���Ÿ�500g',2,123620,0,122382,'2018-9-18',null,'�����ù�',5,'���� ������ ����� 61 ��������','135-230','123123','�����ȣ','010','0000','0000','2018-9-19_1_ch4.jpg','1539860287479slsl4302','1232',1);
Insert into LSM8655.MIN_TSHOP_SELL (NO,GUEST_NO,SELLERS_NO,PRODUCT_NO,PRODUCT_NAME,COUNTS,MONEY,SHIP_MONEY,RMONEY,DATES,SHIP_DATES,SHIP_COMPANY,STATUS,ADDR,ZIPCODE,SHIP_MEMO,NAME,PHONE1,PHONE2,PHONE3,FILE1,TIMES,SHIP_NUM,HASREVIEW) values (7202,2052,1002,2202,'[17���] �����ݸ����� �ŵ����� 20kg / ����ǰ����',5,247500,0,235125,'2018-10-8',null,'CJ�������',5,'��� �����ν� �źϷ� 21 ','480-822',null,'��ȣ','11','22','33','2018-9-14_5_test4.jpg','1541659287739slsl2052','123',1);
Insert into LSM8655.MIN_TSHOP_SELL (NO,GUEST_NO,SELLERS_NO,PRODUCT_NO,PRODUCT_NAME,COUNTS,MONEY,SHIP_MONEY,RMONEY,DATES,SHIP_DATES,SHIP_COMPANY,STATUS,ADDR,ZIPCODE,SHIP_MEMO,NAME,PHONE1,PHONE2,PHONE3,FILE1,TIMES,SHIP_NUM,HASREVIEW) values (7302,2052,1002,4602,'���ѻ� ��� ȫ���� ȫ�� �߼�������Ʈ ������ ������ȫ�ﰡ��',5,139500,0,132525,'2018-10-12',null,'��ü���ù�',1,'��� �����ν� �źϷ� 21 ','480-822',null,'��ȣ','11','22','33','2018-9-27_1_ch6_4.jpg','1542009918914slsl2052',null,0);
Insert into LSM8655.MIN_TSHOP_SELL (NO,GUEST_NO,SELLERS_NO,PRODUCT_NO,PRODUCT_NAME,COUNTS,MONEY,SHIP_MONEY,RMONEY,DATES,SHIP_DATES,SHIP_COMPANY,STATUS,ADDR,ZIPCODE,SHIP_MEMO,NAME,PHONE1,PHONE2,PHONE3,FILE1,TIMES,SHIP_NUM,HASREVIEW) values (5202,4302,1002,7252,'[�ڱ����ġ] �������ġ5Kg/10Kg/�߼۴��� ������ ��ġ[HACCP����]',2,34000,0,33660,'2018-9-18',null,'CJ�������',5,'���� ������ ����� 61 ��������','135-230',null,'�����ȣ','010','0000','0000','2018-10-4_3_ch7_1.jpg','1539859094879slsl4302','22222',1);
REM INSERTING into LSM8655.MIN_TSHOP_SELL_GROUP
SET DEFINE OFF;
Insert into LSM8655.MIN_TSHOP_SELL_GROUP (NO,MONEY,SHIP_MONEY,RMONEY,BANK,BANK_NUM,NAME,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,SHIP_MEMO,TIMES,DATES,GUEST_NO,STATUS,POINT) values (2752,79000,0,67150,'����','34627-42-10379341','��ȣ','480-822','��� �����ν� �źϷ� 21 ','11','22','33',null,'1538986548703slsl2052','2018-9-8',2052,2,0);
Insert into LSM8655.MIN_TSHOP_SELL_GROUP (NO,MONEY,SHIP_MONEY,RMONEY,BANK,BANK_NUM,NAME,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,SHIP_MEMO,TIMES,DATES,GUEST_NO,STATUS,POINT) values (2802,456600,0,416989,'����','17408-95-16460243','��ȣ','480-822','��� �����ν� �źϷ� 21 ','11','22','33',null,'1538989823886slsl2052','2018-9-8',2052,2,1000);
Insert into LSM8655.MIN_TSHOP_SELL_GROUP (NO,MONEY,SHIP_MONEY,RMONEY,BANK,BANK_NUM,NAME,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,SHIP_MEMO,TIMES,DATES,GUEST_NO,STATUS,POINT) values (4052,148500,0,141075,'����','70415-99-18349331','��ȣ','480-822','��� �����ν� �źϷ� 21 ','11','22','33',null,'1541593402256slsl2052','2018-10-7',2052,2,0);
Insert into LSM8655.MIN_TSHOP_SELL_GROUP (NO,MONEY,SHIP_MONEY,RMONEY,BANK,BANK_NUM,NAME,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,SHIP_MEMO,TIMES,DATES,GUEST_NO,STATUS,POINT) values (3102,123620,0,122382,'����','70903-62-10238067','�����ȣ','135-230','���� ������ ����� 61 ��������','010','0000','0000','123123','1539860287479slsl4302','2018-9-18',4302,2,0);
Insert into LSM8655.MIN_TSHOP_SELL_GROUP (NO,MONEY,SHIP_MONEY,RMONEY,BANK,BANK_NUM,NAME,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,SHIP_MEMO,TIMES,DATES,GUEST_NO,STATUS,POINT) values (5002,247500,0,235125,'����','32817-23-18801704','��ȣ','480-822','��� �����ν� �źϷ� 21 ','11','22','33',null,'1541659287739slsl2052','2018-10-8',2052,2,0);
Insert into LSM8655.MIN_TSHOP_SELL_GROUP (NO,MONEY,SHIP_MONEY,RMONEY,BANK,BANK_NUM,NAME,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,SHIP_MEMO,TIMES,DATES,GUEST_NO,STATUS,POINT) values (5102,139500,0,132525,'����','79806-82-18303767','��ȣ','480-822','��� �����ν� �źϷ� 21 ','11','22','33',null,'1542009918914slsl2052','2018-10-12',2052,1,0);
Insert into LSM8655.MIN_TSHOP_SELL_GROUP (NO,MONEY,SHIP_MONEY,RMONEY,BANK,BANK_NUM,NAME,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,SHIP_MEMO,TIMES,DATES,GUEST_NO,STATUS,POINT) values (3002,34000,0,33660,'����','15484-43-12896809','�����ȣ','135-230','���� ������ ����� 61 ��������','010','0000','0000',null,'1539859094879slsl4302','2018-9-18',4302,2,0);
REM INSERTING into LSM8655.MIN_TSHOP_VIEW_QNA
SET DEFINE OFF;
Insert into LSM8655.MIN_TSHOP_VIEW_QNA (NO,PRODUCT_NO,GUEST_NO,GUEST_ID,CATEGORY,MEMO,SECRET,DATES,ANSWER,ISANSWER,SELLERS_NO) values (102,2252,2052,'src***',4,'sdfsdfs',0,'2018-9-1',null,0,1002);
Insert into LSM8655.MIN_TSHOP_VIEW_QNA (NO,PRODUCT_NO,GUEST_NO,GUEST_ID,CATEGORY,MEMO,SECRET,DATES,ANSWER,ISANSWER,SELLERS_NO) values (252,4602,2052,'src***',4,'sdfdsf',0,'2018-9-1','123123123',1,1002);
Insert into LSM8655.MIN_TSHOP_VIEW_QNA (NO,PRODUCT_NO,GUEST_NO,GUEST_ID,CATEGORY,MEMO,SECRET,DATES,ANSWER,ISANSWER,SELLERS_NO) values (302,4602,2052,'src***',1,'������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������',0,'2018-9-1','�亯�Դϴ�.',1,1002);
Insert into LSM8655.MIN_TSHOP_VIEW_QNA (NO,PRODUCT_NO,GUEST_NO,GUEST_ID,CATEGORY,MEMO,SECRET,DATES,ANSWER,ISANSWER,SELLERS_NO) values (352,4302,2052,'src***',1,'sdfdsfdsf',1,'2018-9-2',null,0,1002);
Insert into LSM8655.MIN_TSHOP_VIEW_QNA (NO,PRODUCT_NO,GUEST_NO,GUEST_ID,CATEGORY,MEMO,SECRET,DATES,ANSWER,ISANSWER,SELLERS_NO) values (1402,2502,2052,'src***',2,'dsdds',0,'2018-9-8',null,0,1002);
Insert into LSM8655.MIN_TSHOP_VIEW_QNA (NO,PRODUCT_NO,GUEST_NO,GUEST_ID,CATEGORY,MEMO,SECRET,DATES,ANSWER,ISANSWER,SELLERS_NO) values (1352,4402,2052,'src***',1,'2223232',0,'2018-9-8',null,0,1002);
Insert into LSM8655.MIN_TSHOP_VIEW_QNA (NO,PRODUCT_NO,GUEST_NO,GUEST_ID,CATEGORY,MEMO,SECRET,DATES,ANSWER,ISANSWER,SELLERS_NO) values (2502,2202,2052,'src***',4,'22',1,'2018-10-8','33',1,1002);
Insert into LSM8655.MIN_TSHOP_VIEW_QNA (NO,PRODUCT_NO,GUEST_NO,GUEST_ID,CATEGORY,MEMO,SECRET,DATES,ANSWER,ISANSWER,SELLERS_NO) values (2,2252,2052,'src***',2,'����������������������
��
������
������
������������',0,'2018-9-1',null,0,1002);
Insert into LSM8655.MIN_TSHOP_VIEW_QNA (NO,PRODUCT_NO,GUEST_NO,GUEST_ID,CATEGORY,MEMO,SECRET,DATES,ANSWER,ISANSWER,SELLERS_NO) values (52,2252,2052,'src***',3,'����������������������',1,'2018-9-1',null,0,1002);
Insert into LSM8655.MIN_TSHOP_VIEW_QNA (NO,PRODUCT_NO,GUEST_NO,GUEST_ID,CATEGORY,MEMO,SECRET,DATES,ANSWER,ISANSWER,SELLERS_NO) values (452,4602,2052,'src***',1,'sdfdsfdsfdsfs',0,'2018-9-2','213123',1,1002);
Insert into LSM8655.MIN_TSHOP_VIEW_QNA (NO,PRODUCT_NO,GUEST_NO,GUEST_ID,CATEGORY,MEMO,SECRET,DATES,ANSWER,ISANSWER,SELLERS_NO) values (502,4602,2052,'src***',3,'sdfsdffsdsdf',1,'2018-9-2',null,0,1002);
Insert into LSM8655.MIN_TSHOP_VIEW_QNA (NO,PRODUCT_NO,GUEST_NO,GUEST_ID,CATEGORY,MEMO,SECRET,DATES,ANSWER,ISANSWER,SELLERS_NO) values (552,4602,2052,'src***',3,'sdfsdfsdf',0,'2018-9-2',null,0,1002);
Insert into LSM8655.MIN_TSHOP_VIEW_QNA (NO,PRODUCT_NO,GUEST_NO,GUEST_ID,CATEGORY,MEMO,SECRET,DATES,ANSWER,ISANSWER,SELLERS_NO) values (1452,2152,4302,'qwq***',2,'qwewqewqeqwewqewww',1,'2018-9-19','2222222',1,1002);
Insert into LSM8655.MIN_TSHOP_VIEW_QNA (NO,PRODUCT_NO,GUEST_NO,GUEST_ID,CATEGORY,MEMO,SECRET,DATES,ANSWER,ISANSWER,SELLERS_NO) values (1502,2152,4302,'qwq***',4,'1111111111',0,'2018-9-19','dfsdfsdfsd',1,1002);
REM INSERTING into LSM8655.MIN_TSHOP_VIEW_REVIEW
SET DEFINE OFF;
Insert into LSM8655.MIN_TSHOP_VIEW_REVIEW (NO,GUEST_NO,PRODUCT_NO,STARS,REVIEW1,REVIEW2,MEMO,DATES,GUEST_ID) values (352,2052,2502,4,'�����̿���','�����̿���','dsfsdf','2018-9-8','src***');
Insert into LSM8655.MIN_TSHOP_VIEW_REVIEW (NO,GUEST_NO,PRODUCT_NO,STARS,REVIEW1,REVIEW2,MEMO,DATES,GUEST_ID) values (502,4302,4352,4,'�����̿���','���ƿ�','sdfsfdsfdsdfsdf','2018-9-18','qwq***');
Insert into LSM8655.MIN_TSHOP_VIEW_REVIEW (NO,GUEST_NO,PRODUCT_NO,STARS,REVIEW1,REVIEW2,MEMO,DATES,GUEST_ID) values (552,4302,7252,1,'���ο���','���ο���','dssdfdf

sdfdsf
dsf
dsf
sdf','2018-9-18','qwq***');
Insert into LSM8655.MIN_TSHOP_VIEW_REVIEW (NO,GUEST_NO,PRODUCT_NO,STARS,REVIEW1,REVIEW2,MEMO,DATES,GUEST_ID) values (252,2052,4602,3,'�����̿���','�����̿���','�׻� ���°����� �Ź� �ٸ��� ���ƿ�.������ �׷��� �׷���?�ٲܶ��� �Ȱ���..�̤�,���ݾ� �Ǿ���..','2018-9-4','src***');
Insert into LSM8655.MIN_TSHOP_VIEW_REVIEW (NO,GUEST_NO,PRODUCT_NO,STARS,REVIEW1,REVIEW2,MEMO,DATES,GUEST_ID) values (302,2052,2252,5,'���ƿ�','���ƿ�','������','2018-9-8','src***');
Insert into LSM8655.MIN_TSHOP_VIEW_REVIEW (NO,GUEST_NO,PRODUCT_NO,STARS,REVIEW1,REVIEW2,MEMO,DATES,GUEST_ID) values (152,2052,4602,1,'���ο���','���ο���','�Ʊ� ��Ƽ�� �ϰ� ��µ� ��Ƽ���� �����̰� �ɰ� ������ �߰��߽��ϴ�. ������ �ִ°ɷ� ���� ���� �����̶� ���̶� �۾Ҵٴ� �����մϴ�. � ��ü�� ��Ƽ���� ������� �̷����� ÷�̶� ��Ȳ�����׿�. ','2018-9-4','src***');
Insert into LSM8655.MIN_TSHOP_VIEW_REVIEW (NO,GUEST_NO,PRODUCT_NO,STARS,REVIEW1,REVIEW2,MEMO,DATES,GUEST_ID) values (202,2052,4602,5,'���ƿ�','���ƿ�','�Ʊ�Ƽ���� �Ӻ���� ���µ� ���������� ȭ��Ʈ�� ���� ���� �� ���׿�. �Ʊ�������,������ �� �ΰ��� �Ǻο� ��Ƶ� ������ �Ȼ���� ������ ��ϴ�^^','2018-9-4','src***');
Insert into LSM8655.MIN_TSHOP_VIEW_REVIEW (NO,GUEST_NO,PRODUCT_NO,STARS,REVIEW1,REVIEW2,MEMO,DATES,GUEST_ID) values (2402,2052,2202,4,'���ο���','���ο���','sdfsdf11111111111111111111111','2018-10-2','src***');
Insert into LSM8655.MIN_TSHOP_VIEW_REVIEW (NO,GUEST_NO,PRODUCT_NO,STARS,REVIEW1,REVIEW2,MEMO,DATES,GUEST_ID) values (3402,2052,2202,4,'���ο���','���ο���','111','2018-10-8','src***');
Insert into LSM8655.MIN_TSHOP_VIEW_REVIEW (NO,GUEST_NO,PRODUCT_NO,STARS,REVIEW1,REVIEW2,MEMO,DATES,GUEST_ID) values (3452,2052,2202,3,'�����̿���','�����̿���','dsfdf','2018-10-22','src***');
Insert into LSM8655.MIN_TSHOP_VIEW_REVIEW (NO,GUEST_NO,PRODUCT_NO,STARS,REVIEW1,REVIEW2,MEMO,DATES,GUEST_ID) values (1402,2052,4502,3,'�����̿���','�����̿���','sdffds','2018-9-19','src***');
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
