--------------------------------------------------------
--  ������ ������ - �����-12��-29-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table MIN_JOB_COMPANY
--------------------------------------------------------

  CREATE TABLE "LSM8655"."MIN_JOB_COMPANY" 
   (	"NO" NUMBER(*,0), 
	"MEMBER_NO" NUMBER, 
	"URL" VARCHAR2(2000 BYTE), 
	"INFO" VARCHAR2(3000 BYTE), 
	"NAME" VARCHAR2(255 BYTE), 
	"FOUNDING" VARCHAR2(255 BYTE), 
	"COUNT" VARCHAR2(1000 BYTE), 
	"COMPANY_TYPE" NUMBER, 
	"MONEY" VARCHAR2(1000 BYTE), 
	"ADDR" VARCHAR2(2000 BYTE), 
	"FILE1" VARCHAR2(1000 BYTE), 
	"FILE2" VARCHAR2(1000 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table MIN_JOB_COUNT
--------------------------------------------------------

  CREATE TABLE "LSM8655"."MIN_JOB_COUNT" 
   (	"NO" NUMBER, 
	"DATES" VARCHAR2(255 BYTE), 
	"MEMBER_NO" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table MIN_JOB_INCOME
--------------------------------------------------------

  CREATE TABLE "LSM8655"."MIN_JOB_INCOME" 
   (	"NO" NUMBER, 
	"MEMBER_NO" NUMBER, 
	"WRITER_NO" NUMBER, 
	"POSITIONS" NUMBER, 
	"MONEY" NUMBER, 
	"DATES" VARCHAR2(255 BYTE), 
	"PROF" NUMBER, 
	"EMPL" NUMBER, 
	"STATUS" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table MIN_JOB_INTERVIEW
--------------------------------------------------------

  CREATE TABLE "LSM8655"."MIN_JOB_INTERVIEW" 
   (	"NO" NUMBER, 
	"PROF" NUMBER, 
	"POSITIONS" NUMBER, 
	"DIFFICULTY" NUMBER, 
	"INTERVIEWDATE" VARCHAR2(255 BYTE), 
	"INTERVIEWDIR" NUMBER, 
	"MEMO1" VARCHAR2(3000 BYTE), 
	"MEMO2" VARCHAR2(3000 BYTE), 
	"MEMO3" VARCHAR2(3000 BYTE), 
	"MEMO4" VARCHAR2(3000 BYTE), 
	"MEMO5" VARCHAR2(3000 BYTE), 
	"INTERVIEWRESULT" NUMBER, 
	"INTERVIEWEX" NUMBER, 
	"DATES" VARCHAR2(255 BYTE), 
	"STATUS" NUMBER, 
	"MEMBER_NO" NUMBER, 
	"WRITER_NO" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table MIN_JOB_MEMBER
--------------------------------------------------------

  CREATE TABLE "LSM8655"."MIN_JOB_MEMBER" 
   (	"NO" NUMBER(*,0), 
	"EMAIL" VARCHAR2(1000 BYTE), 
	"PASSWORD" VARCHAR2(1000 BYTE), 
	"NAME" VARCHAR2(255 BYTE), 
	"PHONE1" VARCHAR2(255 BYTE), 
	"PHONE2" VARCHAR2(255 BYTE), 
	"PHONE3" VARCHAR2(255 BYTE), 
	"QUEST" NUMBER, 
	"ANSWER" VARCHAR2(1000 BYTE), 
	"COMPANY" VARCHAR2(1000 BYTE), 
	"COMPANY_CATE" NUMBER, 
	"COMPANY_NUM" VARCHAR2(1000 BYTE), 
	"ORDERS" NUMBER, 
	"DATES" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table MIN_JOB_REVIEW
--------------------------------------------------------

  CREATE TABLE "LSM8655"."MIN_JOB_REVIEW" 
   (	"NO" NUMBER, 
	"TYPES" NUMBER, 
	"STARS" NUMBER, 
	"STARS1" NUMBER, 
	"STARS2" NUMBER, 
	"STARS3" NUMBER, 
	"STARS4" NUMBER, 
	"STARS5" NUMBER, 
	"MEMO1" VARCHAR2(3000 BYTE), 
	"MEMO2" VARCHAR2(3000 BYTE), 
	"MEMO3" VARCHAR2(3000 BYTE), 
	"MEMBER_NO" NUMBER, 
	"DATES" VARCHAR2(255 BYTE), 
	"WRITER_NO" NUMBER, 
	"PROF" NUMBER, 
	"STATUS" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into LSM8655.MIN_JOB_COMPANY
SET DEFINE OFF;
Insert into LSM8655.MIN_JOB_COMPANY (NO,MEMBER_NO,URL,INFO,NAME,FOUNDING,COUNT,COMPANY_TYPE,MONEY,ADDR,FILE1,FILE2) values (22,22,'55','77','11','22','33',2,'44','66','(2)test.jpg','o1ooffice_bk.jpg');
Insert into LSM8655.MIN_JOB_COMPANY (NO,MEMBER_NO,URL,INFO,NAME,FOUNDING,COUNT,COMPANY_TYPE,MONEY,ADDR,FILE1,FILE2) values (2,4,'http://newsroom.fb.com/company-info/','���̽����ڸ��ƴ� Ŀ�´�Ƽ�� �̷�� ��ΰ� ���� ��������� ������ ����ٴ� ��� �Ʒ� �ų� ������ �����ϰ� �ֽ��ϴ�. �����ο� �����⿡�� ��ȭ�� �ֵ��ϰ�, ���� �������� ������ ���� ū �׸��� ����� �� �� �ִ� �е��� ������ ��ٸ��ϴ�.','���̺���������ũ��, �����','2010.12.06','-',1,'-','���� ������ ���ﵿ 736-1 ĳ��ŻŸ��','o1othumb_______.png','o2ooffice_bk.jpg');
REM INSERTING into LSM8655.MIN_JOB_COUNT
SET DEFINE OFF;
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (15,'2018-12-26',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (16,'2018-12-26',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (2,'2018-12-26',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (3,'2018-12-26',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (4,'2018-12-23',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (5,'2018-12-25',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (6,'2018-12-25',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (7,'2018-12-26',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (8,'2018-12-24',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (9,'2018-12-24',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (10,'2018-12-24',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (11,'2018-12-26',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (12,'2018-12-26',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (13,'2018-12-26',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (14,'2018-12-26',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (42,'2018-12-28',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (43,'2018-12-28',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (62,'2018-12-29',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (22,'2018-12-27',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (23,'2018-12-27',4);
REM INSERTING into LSM8655.MIN_JOB_INCOME
SET DEFINE OFF;
Insert into LSM8655.MIN_JOB_INCOME (NO,MEMBER_NO,WRITER_NO,POSITIONS,MONEY,DATES,PROF,EMPL,STATUS) values (22,4,43,3,2000,'2018-12-28',1,3,-1);
Insert into LSM8655.MIN_JOB_INCOME (NO,MEMBER_NO,WRITER_NO,POSITIONS,MONEY,DATES,PROF,EMPL,STATUS) values (23,4,42,3,2600,'2018-12-28',3,3,-1);
Insert into LSM8655.MIN_JOB_INCOME (NO,MEMBER_NO,WRITER_NO,POSITIONS,MONEY,DATES,PROF,EMPL,STATUS) values (24,4,3,1,3000,'2018-12-28',2,3,-1);
Insert into LSM8655.MIN_JOB_INCOME (NO,MEMBER_NO,WRITER_NO,POSITIONS,MONEY,DATES,PROF,EMPL,STATUS) values (25,22,3,5,5000,'2018-12-28',2,3,-1);
REM INSERTING into LSM8655.MIN_JOB_INTERVIEW
SET DEFINE OFF;
Insert into LSM8655.MIN_JOB_INTERVIEW (NO,PROF,POSITIONS,DIFFICULTY,INTERVIEWDATE,INTERVIEWDIR,MEMO1,MEMO2,MEMO3,MEMO4,MEMO5,INTERVIEWRESULT,INTERVIEWEX,DATES,STATUS,MEMBER_NO,WRITER_NO) values (2,3,2,4,'2018-12',1,'������������������������','������������������������','������������������������������������','������������','������������������������',2,1,'2018-12-28',-1,4,3);
Insert into LSM8655.MIN_JOB_INTERVIEW (NO,PROF,POSITIONS,DIFFICULTY,INTERVIEWDATE,INTERVIEWDIR,MEMO1,MEMO2,MEMO3,MEMO4,MEMO5,INTERVIEWRESULT,INTERVIEWEX,DATES,STATUS,MEMBER_NO,WRITER_NO) values (3,1,1,3,'2018-11',1,'�ʱ⺸�� ������ �ǹ��� ���� �ӿ������ε� �ǹ������� �� ü���� ������ �ֽ��ϴ� ���̳� �״°��ؿ�','��Ƽ������ �������(����)�� ���� ��ʰ� ���Խ��ϴ�. ���ݸ����� ������ �Ǵ������ ���������� ��û�� ��쿡 �������� ������ ����� �ϴ����� ���� ����� �߽��ϴ�.','������翡 ���� ���� �� ����, �׸��� �μ������� ���� �Ǵ� ��ü������ �Ϲ� ������ �����ϰ� �̸� �������� ��ʿ� �����߽��ϴ�. ������ �ݴ��� ������ �����ֱ� ������ �ݴ��� ���忡�� �ٰŸ� ���߽��ϴ�.','�ʱ����, ��� ����','10�� ��',3,2,'2018-12-28',-1,4,42);
Insert into LSM8655.MIN_JOB_INTERVIEW (NO,PROF,POSITIONS,DIFFICULTY,INTERVIEWDATE,INTERVIEWDIR,MEMO1,MEMO2,MEMO3,MEMO4,MEMO5,INTERVIEWRESULT,INTERVIEWEX,DATES,STATUS,MEMBER_NO,WRITER_NO) values (4,6,1,2,'2018-12',4,'���� ��� �ϰ� ������ ġ�� 1�� 2�� ���� ���� ������ ����','������ 3.5���� �ε� ������ ���̷��� ����','�̷� �̷� �̷� ���� Ȱ������ ���� �ߴ� ���κ��� �̰� �� ���Ƽ� �߰� ������ �µ� ��ȸ���� �ʴ´�','�ʱ����, �������, ��и���, ���θ���','10�� ��',1,3,'2018-12-28',-1,4,43);
REM INSERTING into LSM8655.MIN_JOB_MEMBER
SET DEFINE OFF;
Insert into LSM8655.MIN_JOB_MEMBER (NO,EMAIL,PASSWORD,NAME,PHONE1,PHONE2,PHONE3,QUEST,ANSWER,COMPANY,COMPANY_CATE,COMPANY_NUM,ORDERS,DATES) values (22,'src86551@naver.com','3162F8A6D36EC8DE769A2127BFFA651','��ȣ2','11','22','33',1,'����','���̹�',7,'12155-42-44556',2,'2018-12-24');
Insert into LSM8655.MIN_JOB_MEMBER (NO,EMAIL,PASSWORD,NAME,PHONE1,PHONE2,PHONE3,QUEST,ANSWER,COMPANY,COMPANY_CATE,COMPANY_NUM,ORDERS,DATES) values (42,'src88221@naver.com','D064802D1B2D5346936161E4340A7E9','ȫ�浿','123','321','123',3,'����',null,-1,null,1,'2018-12-27');
Insert into LSM8655.MIN_JOB_MEMBER (NO,EMAIL,PASSWORD,NAME,PHONE1,PHONE2,PHONE3,QUEST,ANSWER,COMPANY,COMPANY_CATE,COMPANY_NUM,ORDERS,DATES) values (3,'src8822@naver.com','D064802D1B2D5346936161E4340A7E9','����ȣ','010','3324','4343',1,'����',null,-1,null,1,null);
Insert into LSM8655.MIN_JOB_MEMBER (NO,EMAIL,PASSWORD,NAME,PHONE1,PHONE2,PHONE3,QUEST,ANSWER,COMPANY,COMPANY_CATE,COMPANY_NUM,ORDERS,DATES) values (4,'src8655@naver.com','3162F8A6D36EC8DE769A2127BFFA651','��ȣ','11','22','33',2,'����','���̽����ڸ���',7,'127-24-447788',2,null);
Insert into LSM8655.MIN_JOB_MEMBER (NO,EMAIL,PASSWORD,NAME,PHONE1,PHONE2,PHONE3,QUEST,ANSWER,COMPANY,COMPANY_CATE,COMPANY_NUM,ORDERS,DATES) values (43,'src88222@naver.com','D064802D1B2D5346936161E4340A7E9','����ȣ2','321','123','321',5,'����',null,-1,null,1,'2018-12-27');
REM INSERTING into LSM8655.MIN_JOB_REVIEW
SET DEFINE OFF;
Insert into LSM8655.MIN_JOB_REVIEW (NO,TYPES,STARS,STARS1,STARS2,STARS3,STARS4,STARS5,MEMO1,MEMO2,MEMO3,MEMBER_NO,DATES,WRITER_NO,PROF,STATUS) values (22,2,4,3,4,2,2,5,'���ջ���� �پ��� ���� ��� ����. �׷��� ���� ������ ������.','�� �״�� �� ���踦 ���� �ϴ� �۷ι� ����̹Ƿ� �ڿ������� �ܱ���ɷ°� ���ε�� �þ� ��ü�� ���踦 ���ϴ� �ڽ��� �߰���. ��� ������ ������ ������ Ű��� å�ӹ����� ����. ���� �μ�Ƽ��� ���� �⺻���� �޲���.','���ջ�� ��, �߰������� �оߴ� ���濡 ����� �� ����. �������� �ؿܹ��� ������ ������ ���ջ���� ������ ������ �پ��� ö�� ȭ�п� �����ϱ⿡�� �ʵ� ���� ���ϴ� ���̶� ���� ��ü�� ������ �ſ� ������. �ż������ �߱��� ���� �ø��� ���� �ô뿡 IT������ �پ�� ���ڶ� �ǿ� ��ǻ� �Ұ�����. ȸ�系���� �ȶ��ϴٴ� ��ä��ŵ��� 70���� �̻� ����...',4,'2018-12-28',42,7,-1);
Insert into LSM8655.MIN_JOB_REVIEW (NO,TYPES,STARS,STARS1,STARS2,STARS3,STARS4,STARS5,MEMO1,MEMO2,MEMO3,MEMBER_NO,DATES,WRITER_NO,PROF,STATUS) values (23,2,3,3,3,4,4,1,'�޿��� ������ ������ ũ�� ������ ���ϰ� �뱸�� ���� �Ŀ��� �����ǰ��� �Ÿ� ������ ���������� �����ϰ� ����� �־ �޸�Ʈ�� �� �������� ���. 
������ ���� �������� ���鿡���� �Ǹ��ϴٰ� �����Ѵ�.','������ ��� �������� ��κ��� ������� �ٵ� �׷����� �پ ���� �����̴�. �������� �ִٺ��� �ϰ� ���� ������ �������� �ִٰ� �ǴܵǾ� ���� �Ѵ�. �뱸�� ������ ���� ���� ������ �� ã�� ����鵵 ���̱⵵ �ϰ� �ڱ��� �ð������� �� �Ǹ� ���� ���� ���� ���ٰ� �����Ѵ�.','������ ���� ����� LNG �о��� ������ ��ü Ȥ�� ���� ����� ����.�ڿ����� ����� �̸�� ���ο��� ���������� �ν� �� �� ��Ȥ���� ���Ͽ� ������ ���� ����µ� ���Ƹ԰� �մ� ��Ȳ�� ���� �ƽ��ٰ� �����Ѵ�. ������ �ڿ������� ������ �� ���� ��� �о��̹Ƿ� ���簡 ���������� ����� �ñ������� ������ ����� ������ ������ �Ѵٰ� �����Ѵ�.',4,'2018-12-28',3,1,-1);
Insert into LSM8655.MIN_JOB_REVIEW (NO,TYPES,STARS,STARS1,STARS2,STARS3,STARS4,STARS5,MEMO1,MEMO2,MEMO3,MEMBER_NO,DATES,WRITER_NO,PROF,STATUS) values (24,1,3,3,4,5,3,2,'������ �������迡 ���� �ټ� �������̳� �ð��� �ٹ��� �ϸ� �ð��� ��� ���� ����, �׷��� �߱��� ��κ� ���� �ϴ��� ���� �� �ޱ⋚���� ����鵵 �ƹ������� ����, �系 ��ȭ�� �Ϻ���� �����ο�, ���� ���� ����, ��������','������ ��� ��ġ ���� �Ⱥ��� �ǰ�, �ð� �� �ٹ� ���� �� ì����, ���� ���� ����� ��ġ�� ���⵵ ��, ����� 3~5�� ���� ����Ʈ 30��� ���Ѱ��� �༭ 3���ų�, ���� ���� , ������ 1�δ� 10���� ����, �Ϻ��� ���� �Ἥ ���� ����','���� �ʿ���, �μ� ���� �ָ� ��� �Ҽ���, ���� ������, ����� ��ǰ ���̰� Ŭ���� ���� �ϱ� ������ �δ㰨�� �ֽ��ϴ�.',4,'2018-12-28',43,6,-1);
--------------------------------------------------------
--  DDL for Index MIN_JAB_COMPANY_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LSM8655"."MIN_JAB_COMPANY_PK" ON "LSM8655"."MIN_JOB_COMPANY" ("NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index MIN_JOB_COUNT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LSM8655"."MIN_JOB_COUNT_PK" ON "LSM8655"."MIN_JOB_COUNT" ("NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index MIN_JOB_INCOME_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LSM8655"."MIN_JOB_INCOME_PK" ON "LSM8655"."MIN_JOB_INCOME" ("NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index MIN_JOB_INTERVIEW_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LSM8655"."MIN_JOB_INTERVIEW_PK" ON "LSM8655"."MIN_JOB_INTERVIEW" ("NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index MIN_JOB_MEMBER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LSM8655"."MIN_JOB_MEMBER_PK" ON "LSM8655"."MIN_JOB_MEMBER" ("NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index MIN_JOB_REVIEW_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LSM8655"."MIN_JOB_REVIEW_PK" ON "LSM8655"."MIN_JOB_REVIEW" ("NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Trigger MIN_JOB_COMPANY_TRI
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LSM8655"."MIN_JOB_COMPANY_TRI" 
   before insert on "LSM8655"."MIN_JOB_COMPANY" 
   for each row 
begin  
   if inserting then 
      if :NEW."NO" is null then 
         select MIN_JOB_COMPANY_SEQ.nextval into :NEW."NO" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "LSM8655"."MIN_JOB_COMPANY_TRI" ENABLE;
--------------------------------------------------------
--  DDL for Trigger MIN_JOB_COUNT_TRI
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LSM8655"."MIN_JOB_COUNT_TRI" 
   before insert on "LSM8655"."MIN_JOB_COUNT" 
   for each row 
begin  
   if inserting then 
      if :NEW."NO" is null then 
         select MIN_JOB_COUNT_SEQ.nextval into :NEW."NO" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "LSM8655"."MIN_JOB_COUNT_TRI" ENABLE;
--------------------------------------------------------
--  DDL for Trigger MIN_JOB_INCOME_TRI
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LSM8655"."MIN_JOB_INCOME_TRI" 
   before insert on "LSM8655"."MIN_JOB_INCOME" 
   for each row 
begin  
   if inserting then 
      if :NEW."NO" is null then 
         select MIN_JOB_INCOME_SEQ.nextval into :NEW."NO" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "LSM8655"."MIN_JOB_INCOME_TRI" ENABLE;
--------------------------------------------------------
--  DDL for Trigger MIN_JOB_INTERVIEW_TRI
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LSM8655"."MIN_JOB_INTERVIEW_TRI" 
   before insert on "LSM8655"."MIN_JOB_INTERVIEW" 
   for each row 
begin  
   if inserting then 
      if :NEW."NO" is null then 
         select MIN_JOB_INTERVIEW_SEQ.nextval into :NEW."NO" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "LSM8655"."MIN_JOB_INTERVIEW_TRI" ENABLE;
--------------------------------------------------------
--  DDL for Trigger MIN_JOB_MEMBER_TRI
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LSM8655"."MIN_JOB_MEMBER_TRI" 
   before insert on "LSM8655"."MIN_JOB_MEMBER" 
   for each row 
begin  
   if inserting then 
      if :NEW."NO" is null then 
         select MIN_JOB_MEMBER_SEQ.nextval into :NEW."NO" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "LSM8655"."MIN_JOB_MEMBER_TRI" ENABLE;
--------------------------------------------------------
--  DDL for Trigger MIN_JOB_REVIEW_TRI
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LSM8655"."MIN_JOB_REVIEW_TRI" 
   before insert on "LSM8655"."MIN_JOB_REVIEW" 
   for each row 
begin  
   if inserting then 
      if :NEW."NO" is null then 
         select MIN_JOB_REVIEW_SEQ.nextval into :NEW."NO" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "LSM8655"."MIN_JOB_REVIEW_TRI" ENABLE;
--------------------------------------------------------
--  Constraints for Table MIN_JOB_COMPANY
--------------------------------------------------------

  ALTER TABLE "LSM8655"."MIN_JOB_COMPANY" ADD CONSTRAINT "MIN_JAB_COMPANY_PK" PRIMARY KEY ("NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "LSM8655"."MIN_JOB_COMPANY" MODIFY ("NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MIN_JOB_COUNT
--------------------------------------------------------

  ALTER TABLE "LSM8655"."MIN_JOB_COUNT" ADD CONSTRAINT "MIN_JOB_COUNT_PK" PRIMARY KEY ("NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "LSM8655"."MIN_JOB_COUNT" MODIFY ("NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MIN_JOB_INCOME
--------------------------------------------------------

  ALTER TABLE "LSM8655"."MIN_JOB_INCOME" ADD CONSTRAINT "MIN_JOB_INCOME_PK" PRIMARY KEY ("NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "LSM8655"."MIN_JOB_INCOME" MODIFY ("NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MIN_JOB_INTERVIEW
--------------------------------------------------------

  ALTER TABLE "LSM8655"."MIN_JOB_INTERVIEW" ADD CONSTRAINT "MIN_JOB_INTERVIEW_PK" PRIMARY KEY ("NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "LSM8655"."MIN_JOB_INTERVIEW" MODIFY ("NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MIN_JOB_MEMBER
--------------------------------------------------------

  ALTER TABLE "LSM8655"."MIN_JOB_MEMBER" ADD CONSTRAINT "MIN_JOB_MEMBER_PK" PRIMARY KEY ("NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "LSM8655"."MIN_JOB_MEMBER" MODIFY ("NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MIN_JOB_REVIEW
--------------------------------------------------------

  ALTER TABLE "LSM8655"."MIN_JOB_REVIEW" ADD CONSTRAINT "MIN_JOB_REVIEW_PK" PRIMARY KEY ("NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "LSM8655"."MIN_JOB_REVIEW" MODIFY ("NO" NOT NULL ENABLE);
