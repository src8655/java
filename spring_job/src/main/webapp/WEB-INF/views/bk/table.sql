--------------------------------------------------------
--  ������ ������ - �����-1��-12-2019   
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
	"DATES" VARCHAR2(255 BYTE), 
	"FOLLOW" VARCHAR2(2000 BYTE), 
	"KAKAO" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table MIN_JOB_RECRUIT
--------------------------------------------------------

  CREATE TABLE "LSM8655"."MIN_JOB_RECRUIT" 
   (	"NO" NUMBER, 
	"SUBJECT" VARCHAR2(1000 BYTE), 
	"KEYWORD" VARCHAR2(1000 BYTE), 
	"MEMO1" VARCHAR2(3000 BYTE), 
	"MEMO2" VARCHAR2(3000 BYTE), 
	"MEMO3" VARCHAR2(3000 BYTE), 
	"MEMO4" VARCHAR2(3000 BYTE), 
	"MEMO5" VARCHAR2(3000 BYTE), 
	"CONTACT" VARCHAR2(1000 BYTE), 
	"PROF" VARCHAR2(500 BYTE), 
	"EMPL" VARCHAR2(500 BYTE), 
	"GRADE" VARCHAR2(500 BYTE), 
	"MONEY" VARCHAR2(500 BYTE), 
	"POSITIONS1" VARCHAR2(500 BYTE), 
	"POSITIONS2" VARCHAR2(500 BYTE), 
	"ENDDATES" VARCHAR2(255 BYTE), 
	"DATES" VARCHAR2(255 BYTE), 
	"MEMBER_NO" NUMBER, 
	"STATUS" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table MIN_JOB_RECRUIT_LIST
--------------------------------------------------------

  CREATE TABLE "LSM8655"."MIN_JOB_RECRUIT_LIST" 
   (	"NO" NUMBER, 
	"NAME" VARCHAR2(255 BYTE), 
	"PHONE1" VARCHAR2(255 BYTE), 
	"PHONE2" VARCHAR2(255 BYTE), 
	"PHONE3" VARCHAR2(255 BYTE), 
	"EMAIL" VARCHAR2(500 BYTE), 
	"FILE1" VARCHAR2(1000 BYTE), 
	"FILE2" VARCHAR2(1000 BYTE), 
	"MEMBER_NO" NUMBER, 
	"DATES" VARCHAR2(255 BYTE), 
	"WRITER_NO" NUMBER, 
	"RECRUIT_NO" NUMBER, 
	"FILE3" VARCHAR2(1000 BYTE)
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
Insert into LSM8655.MIN_JOB_COMPANY (NO,MEMBER_NO,URL,INFO,NAME,FOUNDING,COUNT,COMPANY_TYPE,MONEY,ADDR,FILE1,FILE2) values (42,62,'www.kakaocorp.com','(��)īī���� �� ���� �� �������� �ۼ��� 303�� �������, 493�� ���������� �����ڵ鿡 ���� ����� 457�� �����ı�, �ǽð� 3�� ä��� ���� ���� Ȯ���ϼ���.','���μ�, ������','1995-02-16','2,465�� (2016)',1,'9,321.6�� �� ( 2015 )','����Ư����ġ�� ���ֽ� ÷�ܷ� 242','o1othumb_kakao.jpg','o2ooffice-2360063_1920.jpg');
Insert into LSM8655.MIN_JOB_COMPANY (NO,MEMBER_NO,URL,INFO,NAME,FOUNDING,COUNT,COMPANY_TYPE,MONEY,ADDR,FILE1,FILE2) values (43,63,'www.google.co.kr','�����ڸ���(��)�� �� ���� �� �������� �ۼ��� 80�� �������, 107�� ���������� �����ڵ鿡 ���� ����� 133�� �����ı�, �ǽð� 0�� ä��� ���� ���� Ȯ���ϼ���.','��Ʃ��ı��Ŀ��, ������','2004-03-15','100�� (2009)',2,'-','���� ������ ����1�� 737 �������̳������� 22��','o1othumb______.png','o1oapple-1868496_1920.jpg');
Insert into LSM8655.MIN_JOB_COMPANY (NO,MEMBER_NO,URL,INFO,NAME,FOUNDING,COUNT,COMPANY_TYPE,MONEY,ADDR,FILE1,FILE2) values (22,22,'55','77','11','22','33',2,'44','66','(2)test.jpg','o1ooffice_bk.jpg');
Insert into LSM8655.MIN_JOB_COMPANY (NO,MEMBER_NO,URL,INFO,NAME,FOUNDING,COUNT,COMPANY_TYPE,MONEY,ADDR,FILE1,FILE2) values (2,4,'http://newsroom.fb.com/company-info/','���̽����ڸ��ƴ� Ŀ�´�Ƽ�� �̷�� ��ΰ� ���� ��������� ������ ����ٴ� ��� �Ʒ� �ų� ������ �����ϰ� �ֽ��ϴ�. �����ο� �����⿡�� ��ȭ�� �ֵ��ϰ�, ���� �������� ������ ���� ū �׸��� ����� �� �� �ִ� �е��� ������ ��ٸ��ϴ�.','���̺���������ũ��, �����','2010.12.06','-',2,'-','���� ������ ���ﵿ 736-1 ĳ��ŻŸ��','o1othumb_______.png','o3ooffice-2360063_1920.jpg');
Insert into LSM8655.MIN_JOB_COMPANY (NO,MEMBER_NO,URL,INFO,NAME,FOUNDING,COUNT,COMPANY_TYPE,MONEY,ADDR,FILE1,FILE2) values (62,102,'www.kospo.co.kr','�ѱ����ι���(��)�� �� ���� �� �������� �ۼ��� 103�� �������, 129�� ���������� �����ڵ鿡 ���� ����� 67�� �����ı�, �ǽð� 0�� ä��� ���� ���� Ȯ���ϼ���.','������, ������','2001.04.02','2,072�� (2013)',2,'7.1�� �� ( 2013 )','�λ� ���� ����������','o1othumb_3717.JPG',null);
REM INSERTING into LSM8655.MIN_JOB_COUNT
SET DEFINE OFF;
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (15,'2018-12-26',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (16,'2018-12-26',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (215,'2019-01-10',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (238,'2019-01-10',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (263,'2019-01-12',63);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (264,'2019-01-12',62);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (265,'2019-01-12',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (266,'2019-01-12',102);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (267,'2019-01-12',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (268,'2019-01-12',63);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (278,'2019-01-12',63);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (279,'2019-01-12',102);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (96,'2019-01-03',62);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (97,'2019-01-03',63);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (175,'2019-01-09',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (224,'2019-01-10',22);
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
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (63,'2018-12-29',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (64,'2018-12-29',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (65,'2018-12-31',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (66,'2018-12-31',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (67,'2018-12-31',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (68,'2018-12-31',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (69,'2018-12-31',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (70,'2018-12-31',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (71,'2018-12-31',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (72,'2018-12-31',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (73,'2019-01-02',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (74,'2019-01-02',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (75,'2019-01-02',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (76,'2019-01-02',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (77,'2019-01-02',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (78,'2019-01-02',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (79,'2019-01-02',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (80,'2019-01-02',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (93,'2019-01-03',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (94,'2019-01-03',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (95,'2019-01-03',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (113,'2019-01-04',63);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (114,'2019-01-04',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (115,'2019-01-04',62);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (116,'2019-01-04',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (133,'2019-01-05',63);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (134,'2019-01-05',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (135,'2019-01-07',63);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (136,'2019-01-07',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (137,'2019-01-07',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (138,'2019-01-07',-1);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (155,'2019-01-08',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (156,'2019-01-08',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (157,'2019-01-08',63);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (158,'2019-01-08',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (159,'2019-01-08',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (160,'2019-01-08',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (161,'2019-01-08',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (162,'2019-01-08',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (195,'2019-01-09',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (196,'2019-01-10',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (217,'2019-01-10',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (218,'2019-01-10',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (219,'2019-01-10',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (220,'2019-01-10',63);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (221,'2019-01-10',62);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (222,'2019-01-10',102);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (223,'2019-01-10',62);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (225,'2019-01-10',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (237,'2019-01-10',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (239,'2019-01-11',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (259,'2019-01-12',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (260,'2019-01-12',62);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (261,'2019-01-12',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (262,'2019-01-12',102);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (269,'2019-01-12',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (270,'2019-01-12',102);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (271,'2019-01-12',63);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (272,'2019-01-12',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (273,'2019-01-12',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (274,'2019-01-12',62);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (275,'2019-01-12',62);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (276,'2019-01-12',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (277,'2019-01-12',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (22,'2018-12-27',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (23,'2018-12-27',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (176,'2019-01-09',62);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (177,'2019-01-09',102);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (178,'2019-01-09',102);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (179,'2019-01-09',102);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (216,'2019-01-10',62);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (240,'2019-01-11',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (241,'2019-01-11',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (242,'2019-01-11',102);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (243,'2019-01-11',63);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (244,'2019-01-11',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (245,'2019-01-11',62);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (246,'2019-01-11',4);
REM INSERTING into LSM8655.MIN_JOB_INCOME
SET DEFINE OFF;
Insert into LSM8655.MIN_JOB_INCOME (NO,MEMBER_NO,WRITER_NO,POSITIONS,MONEY,DATES,PROF,EMPL,STATUS) values (62,102,145,3,1900,'2019-01-12',3,3,-1);
Insert into LSM8655.MIN_JOB_INCOME (NO,MEMBER_NO,WRITER_NO,POSITIONS,MONEY,DATES,PROF,EMPL,STATUS) values (22,4,43,3,2000,'2018-12-28',1,3,-1);
Insert into LSM8655.MIN_JOB_INCOME (NO,MEMBER_NO,WRITER_NO,POSITIONS,MONEY,DATES,PROF,EMPL,STATUS) values (23,4,42,3,2600,'2018-12-28',3,3,-1);
Insert into LSM8655.MIN_JOB_INCOME (NO,MEMBER_NO,WRITER_NO,POSITIONS,MONEY,DATES,PROF,EMPL,STATUS) values (24,4,3,1,3000,'2018-12-28',2,3,-1);
Insert into LSM8655.MIN_JOB_INCOME (NO,MEMBER_NO,WRITER_NO,POSITIONS,MONEY,DATES,PROF,EMPL,STATUS) values (25,22,3,5,5000,'2018-12-28',2,3,-1);
Insert into LSM8655.MIN_JOB_INCOME (NO,MEMBER_NO,WRITER_NO,POSITIONS,MONEY,DATES,PROF,EMPL,STATUS) values (42,4,82,2,1900,'2019-01-07',2,3,-1);
REM INSERTING into LSM8655.MIN_JOB_INTERVIEW
SET DEFINE OFF;
Insert into LSM8655.MIN_JOB_INTERVIEW (NO,PROF,POSITIONS,DIFFICULTY,INTERVIEWDATE,INTERVIEWDIR,MEMO1,MEMO2,MEMO3,MEMO4,MEMO5,INTERVIEWRESULT,INTERVIEWEX,DATES,STATUS,MEMBER_NO,WRITER_NO) values (42,1,3,3,'2018-12',1,'���ϸ����̾ ���� �հ� ��, ���Ϸ� ������¥�� ���������� ���������� �뺸','ȸ�翡 ���� �ƴ� �� ���ϱ�, ������ �����, ������ �������� ��','���� ���α׷��� ������ ȸ��ν� ������ C�ڵ��� ���α׷����� �ƴ� GUI ���α׷��� �ô븦 ������, �� ȸ���� �Ͽ��� �ǰ� �;����ϴ�.','PT����, �׷����, ���θ���','20�� ��',1,2,'2019-01-12',-1,102,145);
Insert into LSM8655.MIN_JOB_INTERVIEW (NO,PROF,POSITIONS,DIFFICULTY,INTERVIEWDATE,INTERVIEWDIR,MEMO1,MEMO2,MEMO3,MEMO4,MEMO5,INTERVIEWRESULT,INTERVIEWEX,DATES,STATUS,MEMBER_NO,WRITER_NO) values (2,3,2,4,'2018-12',1,'������������������������','������������������������','������������������������������������','������������','������������������������',2,1,'2018-12-28',-1,4,3);
Insert into LSM8655.MIN_JOB_INTERVIEW (NO,PROF,POSITIONS,DIFFICULTY,INTERVIEWDATE,INTERVIEWDIR,MEMO1,MEMO2,MEMO3,MEMO4,MEMO5,INTERVIEWRESULT,INTERVIEWEX,DATES,STATUS,MEMBER_NO,WRITER_NO) values (3,1,1,3,'2018-11',1,'�ʱ⺸�� ������ �ǹ��� ���� �ӿ������ε� �ǹ������� �� ü���� ������ �ֽ��ϴ� ���̳� �״°��ؿ�','��Ƽ������ �������(����)�� ���� ��ʰ� ���Խ��ϴ�. ���ݸ����� ������ �Ǵ������ ���������� ��û�� ��쿡 �������� ������ ����� �ϴ����� ���� ����� �߽��ϴ�.','������翡 ���� ���� �� ����, �׸��� �μ������� ���� �Ǵ� ��ü������ �Ϲ� ������ �����ϰ� �̸� �������� ��ʿ� �����߽��ϴ�. ������ �ݴ��� ������ �����ֱ� ������ �ݴ��� ���忡�� �ٰŸ� ���߽��ϴ�.','�ʱ����, ��� ����','10�� ��',3,2,'2018-12-28',-1,4,42);
Insert into LSM8655.MIN_JOB_INTERVIEW (NO,PROF,POSITIONS,DIFFICULTY,INTERVIEWDATE,INTERVIEWDIR,MEMO1,MEMO2,MEMO3,MEMO4,MEMO5,INTERVIEWRESULT,INTERVIEWEX,DATES,STATUS,MEMBER_NO,WRITER_NO) values (4,6,1,2,'2018-12',4,'���� ��� �ϰ� ������ ġ�� 1�� 2�� ���� ���� ������ ����','������ 3.5���� �ε� ������ ���̷��� ����','�̷� �̷� �̷� ���� Ȱ������ ���� �ߴ� ���κ��� �̰� �� ���Ƽ� �߰� ������ �µ� ��ȸ���� �ʴ´�','�ʱ����, �������, ��и���, ���θ���','10�� ��',1,3,'2018-12-28',-1,4,43);
REM INSERTING into LSM8655.MIN_JOB_MEMBER
SET DEFINE OFF;
Insert into LSM8655.MIN_JOB_MEMBER (NO,EMAIL,PASSWORD,NAME,PHONE1,PHONE2,PHONE3,QUEST,ANSWER,COMPANY,COMPANY_CATE,COMPANY_NUM,ORDERS,DATES,FOLLOW,KAKAO) values (62,'src86552@naver.com','3162F8A6D36EC8DE769A2127BFFA651','���μ�','010','5555','6666',3,'����','����īī��',7,'128-25-66558',2,'2019-01-03',null,-1);
Insert into LSM8655.MIN_JOB_MEMBER (NO,EMAIL,PASSWORD,NAME,PHONE1,PHONE2,PHONE3,QUEST,ANSWER,COMPANY,COMPANY_CATE,COMPANY_NUM,ORDERS,DATES,FOLLOW,KAKAO) values (63,'src86553@naver.com','3162F8A6D36EC8DE769A2127BFFA651','��Ʃ��','010','7777','8888',2,'����','�����ڸ���(��)',7,'123-66-99887',2,'2019-01-03',null,-1);
Insert into LSM8655.MIN_JOB_MEMBER (NO,EMAIL,PASSWORD,NAME,PHONE1,PHONE2,PHONE3,QUEST,ANSWER,COMPANY,COMPANY_CATE,COMPANY_NUM,ORDERS,DATES,FOLLOW,KAKAO) values (82,'src88223@naver.com','D064802D1B2D5346936161E4340A7E9','�̳�','321','11','22',2,'����',null,-1,null,1,'2019-01-07','4',-1);
Insert into LSM8655.MIN_JOB_MEMBER (NO,EMAIL,PASSWORD,NAME,PHONE1,PHONE2,PHONE3,QUEST,ANSWER,COMPANY,COMPANY_CATE,COMPANY_NUM,ORDERS,DATES,FOLLOW,KAKAO) values (22,'src86551@naver.com','3162F8A6D36EC8DE769A2127BFFA651','��ȣ2','11','22','33',1,'����','���̹�',7,'12155-42-44556',2,'2018-12-24',null,-1);
Insert into LSM8655.MIN_JOB_MEMBER (NO,EMAIL,PASSWORD,NAME,PHONE1,PHONE2,PHONE3,QUEST,ANSWER,COMPANY,COMPANY_CATE,COMPANY_NUM,ORDERS,DATES,FOLLOW,KAKAO) values (122,'src88224@naver.com','D064802D1B2D5346936161E4340A7E9','������','1','2','3',4,'123',null,-1,null,1,'2019-01-10',null,-1);
Insert into LSM8655.MIN_JOB_MEMBER (NO,EMAIL,PASSWORD,NAME,PHONE1,PHONE2,PHONE3,QUEST,ANSWER,COMPANY,COMPANY_CATE,COMPANY_NUM,ORDERS,DATES,FOLLOW,KAKAO) values (164,'7A184790849FFD5DA64F4A21DC4D1791','7A184790849FFD5DA64F4A21DC4D1791','�弮��',null,null,null,-1,null,null,-1,null,1,'2019-01-12',null,1);
Insert into LSM8655.MIN_JOB_MEMBER (NO,EMAIL,PASSWORD,NAME,PHONE1,PHONE2,PHONE3,QUEST,ANSWER,COMPANY,COMPANY_CATE,COMPANY_NUM,ORDERS,DATES,FOLLOW,KAKAO) values (42,'src88221@naver.com','D064802D1B2D5346936161E4340A7E9','ȫ�浿','123','321','123',3,'����',null,-1,null,1,'2018-12-27','62',-1);
Insert into LSM8655.MIN_JOB_MEMBER (NO,EMAIL,PASSWORD,NAME,PHONE1,PHONE2,PHONE3,QUEST,ANSWER,COMPANY,COMPANY_CATE,COMPANY_NUM,ORDERS,DATES,FOLLOW,KAKAO) values (3,'src8822@naver.com','D064802D1B2D5346936161E4340A7E9','����ȣ','010','3324','4343',4,'����2',null,-1,null,1,'2018-12-27','62,4,102',-1);
Insert into LSM8655.MIN_JOB_MEMBER (NO,EMAIL,PASSWORD,NAME,PHONE1,PHONE2,PHONE3,QUEST,ANSWER,COMPANY,COMPANY_CATE,COMPANY_NUM,ORDERS,DATES,FOLLOW,KAKAO) values (4,'src8655@naver.com','3162F8A6D36EC8DE769A2127BFFA651','����ȣ','11','22','33',2,'����','���̽����ڸ���',7,'12344553',2,'2018-12-27','22,4',-1);
Insert into LSM8655.MIN_JOB_MEMBER (NO,EMAIL,PASSWORD,NAME,PHONE1,PHONE2,PHONE3,QUEST,ANSWER,COMPANY,COMPANY_CATE,COMPANY_NUM,ORDERS,DATES,FOLLOW,KAKAO) values (43,'src88222@naver.com','D064802D1B2D5346936161E4340A7E9','����ȣ2','321','123','321',5,'����',null,-1,null,1,'2018-12-27',null,-1);
Insert into LSM8655.MIN_JOB_MEMBER (NO,EMAIL,PASSWORD,NAME,PHONE1,PHONE2,PHONE3,QUEST,ANSWER,COMPANY,COMPANY_CATE,COMPANY_NUM,ORDERS,DATES,FOLLOW,KAKAO) values (102,'src86554@naver.com','3162F8A6D36EC8DE769A2127BFFA651','������','010','321','123',2,'����','�ѱ����ι���(��)',2,'123-55-66998',2,'2019-01-09',null,-1);
Insert into LSM8655.MIN_JOB_MEMBER (NO,EMAIL,PASSWORD,NAME,PHONE1,PHONE2,PHONE3,QUEST,ANSWER,COMPANY,COMPANY_CATE,COMPANY_NUM,ORDERS,DATES,FOLLOW,KAKAO) values (145,'C316898A6BACF6497CFB8F73497CAC12','C316898A6BACF6497CFB8F73497CAC12','����ȣ','1','2','3',1,'1',null,-1,null,1,'2019-01-11','63,62',1);
Insert into LSM8655.MIN_JOB_MEMBER (NO,EMAIL,PASSWORD,NAME,PHONE1,PHONE2,PHONE3,QUEST,ANSWER,COMPANY,COMPANY_CATE,COMPANY_NUM,ORDERS,DATES,FOLLOW,KAKAO) values (144,'src88225@naver.com','D064802D1B2D5346936161E4340A7E9','�ƾƾ�','1','2','3',2,'546',null,-1,null,1,'2019-01-11',null,-1);
REM INSERTING into LSM8655.MIN_JOB_RECRUIT
SET DEFINE OFF;
Insert into LSM8655.MIN_JOB_RECRUIT (NO,SUBJECT,KEYWORD,MEMO1,MEMO2,MEMO3,MEMO4,MEMO5,CONTACT,PROF,EMPL,GRADE,MONEY,POSITIONS1,POSITIONS2,ENDDATES,DATES,MEMBER_NO,STATUS) values (2,'(��)��Ʈ�ڸ��� Back-End ������ ������ ä��','������,������,����,����Ʈ������Ͼ�,�ý��ۿ����Ͼ�,��� 5�� �̻� ���','�ŷڿ� ������ ��Ʈ���� ���� ��ȣȭ�� �ŷ��� ��Ʈ�ڸ��� �Դϴ�. 
������ �����ϰ� �ִ� ��ȣȭ�� �ŷ����忡 ���ο� ������ �����մϴ�.','Back-End ����','�ٽ� ���� ����
- ��� 5�� �̻� 

- UNIX C ������ 

- Framework ������ 

- FEP ���߰����� 

- ��� ���α׷� ���� ������ 

- Visual C++ ������ 

- JAVA / JSP / Java Framework (Spring) ���� 

- Java Script / JQuery ���� 

- Oracle / MS SQL / MySQL DBMS ����� �𵨸� (����)
��� ����
- �ֽİŷ� �ý����� �Ÿ�, ����, �������� ���� 

- �ֽİŷ� �ý����� �����ⳳ, ���� ���� ���� ���α׷� ���� 

- ���ǻ� HTS ���� ���� 

- �ŷ��� ����Ʈ ������ 

- Java Daemon / Node.js ������','�������� - �ӿ����� - �հ��뺸','���� �� ���� 
? �� ���庸�� �ð���/���������� �� ���� �� �߱� 
? ���� ����� (���￪ 3�� �ⱸ ���� 1��) 
? ������ ����ȯ�� 
? �������� ���۷���/����/�������ź� ���� 
? �� 1ȸ�̻� �� ȸ�� �� ���� ƼŸ�� ���� 
? ���� ���࿡ �ʿ��� �ֽ����/����Ʈ���� ���� 
? �ְ��� ���� ȯ���� ���￪�� ���ֻ��Դϴ�. �ȶ��� ȯ��, ����/�� ���� �����ο� �̿�, Ŀ��, ���� ��������','��Ʈ�ڸ���,chongmu@naver.com,1800-9999,http://hitkorea.co','����Ʈ������Ͼ�, �ý��ۿ����Ͼ�, ������','������','�з¹���','���� (�ּ� 6,000���� ~ �ִ� 8,000����)','-','�����(����/����)','2019-03-02','2019-01-04',4,1);
Insert into LSM8655.MIN_JOB_RECRUIT (NO,SUBJECT,KEYWORD,MEMO1,MEMO2,MEMO3,MEMO4,MEMO5,CONTACT,PROF,EMPL,GRADE,MONEY,POSITIONS1,POSITIONS2,ENDDATES,DATES,MEMBER_NO,STATUS) values (22,'Java��JSP(Spring) ������ ä���մϴ�(��»��)','������,�뱸,��� 1�� �̻�,������','2005�� 3�� 14�Ͽ� ������ ��ǻ�ͽý��� ���� �ڹ� �� ���� ���񽺾� ������ �ý��� ����(����ȸ�Ƿ�,�˻�����,���ͳݰ����ý���)����,����/��Ű��� ����� �ϴ� �߼ұ���̸�, �ں����� 3��� ������� 37�� 6,600���� ������� 31���Դϴ�.

','�����ι� 

�����α׷� ����(JSP, Spring)
(���ӿ�����, ��������)


','�ڰݿ��

- �з� : ����

- ��� : ��� 1�� ~ 5��

- ���� : ����

- �����ο� : 1��


������

- �ش����� �ٹ�����

- ����ó�����

- ��ǻ��/�ý��۰���


��Ÿ ���ǻ���
�Ի����� ������ ��������� �߰ߵ� ���, ä��Ȯ�� ���Ķ� ä���� ��ҵ� �� �ֽ��ϴ�.
','�������� - ������� - �ӿ����� - �հ��뺸

���⼭�� : �ڱ�Ұ���, �̷¼�','
�ٹ�����	
������

�ٹ��μ�	���������
�ٹ�����/�ð�	�� 5��(��~��) ���� 9��~���� 6��
�ٹ�����	
�뱸 - �޼���

�޿�	ȸ�系�Կ� ����
ȸ���ּ�	(704-230) �뱸 �޼��� ȣ�굿 711','�����,053-581-0000,010-8850-0111','������','������','�з¹���','���� (�ּ� 2,600���� ~ �ִ� 3,600����)','-','-','2019-02-03','2019-01-03',22,1);
Insert into LSM8655.MIN_JOB_RECRUIT (NO,SUBJECT,KEYWORD,MEMO1,MEMO2,MEMO3,MEMO4,MEMO5,CONTACT,PROF,EMPL,GRADE,MONEY,POSITIONS1,POSITIONS2,ENDDATES,DATES,MEMBER_NO,STATUS) values (43,'����϶���� �������� ������ä��-����/���','CGI, HTML, JAVASCRIPT, LUA, LUCI, ASP, ������ ����, ��Ʈ��ũ','���� ������ ������ ���� ������� ����������ű��(�������ڸ���ġ,�����ͳ�������ġ)����,����/������� ����Ʈ���� ���� ����� �ϴ� �ܺΰ�����α���̸�, �ں����� 19�� 2,858���� ������� 46�� 5,894���� ������� 24���Դϴ�.','- ����� �����/������ �������� ����

- CGI, HTML, javascript, LUA, LUCI, ASP, ������ ����, ��Ʈ��ũ

(�븮, ����, �����)','�ڰݿ��

- �з� : ����

- ��� : ���� (���Ե� ���� ����)

- ���� : ����

- �����ο� : 0��


�ʼ�����

- ��ǻ��/�ý��۰���


������

- �ش����� �ٹ�����

- CGI

- HTML

- javascript

- LUA

- LUCI

- ASP

- ������ ����

- ��Ʈ��ũ ���� �ʿ�

- ����/���ڰ���','��������	������ �̷¼� ���� ������ ��� �Ұ��ڷ����� �� �����ɻ� �� ��������.
�ӿ� ���� �� �հ��� ��ǥ�̻� ��� �� ä�� ����
���⼭��	�̷¼� �� ���� ��¿� ���õ� �Ұ��ڷ�','�ٹ�����	
������(�����Ⱓ)-3����

�ٹ��μ�	��������
�ٹ�����/�ð�	�� 5��(��~��) ���� 9��~���� 6��
�ٹ�����	
��� - ������ �д籸

�޿�	������ ����
ȸ���ּ�	(463-400) ��� ������ �д籸 ���� 685 �̷����º�óŸ�� 9��
�α���ö	�źд缱 �Ǳ� ���� 1km �̳�','���Ƹ�,070-7730-9300','������, �ý��ۿ����Ͼ�, ��������','������','�з¹���','���� �� ����','-','-','2019-02-02','2019-01-12',4,1);
Insert into LSM8655.MIN_JOB_RECRUIT (NO,SUBJECT,KEYWORD,MEMO1,MEMO2,MEMO3,MEMO4,MEMO5,CONTACT,PROF,EMPL,GRADE,MONEY,POSITIONS1,POSITIONS2,ENDDATES,DATES,MEMBER_NO,STATUS) values (82,'[�κ�ö����] �鿣�� �� ������ ���','������,����,��� 3�� �̻�, ������','�κ�ö�����׷��� 39�� �� ������� �����ؿ� ������ũ ����Դϴ�. ���� ������ ���� ���� ���׶� ���������, ������ ��տ��� 30�� �ʹ�����, ���� ���� ��ġ�� ������� ���� �ǻ������ �������� �������� ��ŸƮ��ó�� ���մϴ�. ��ȭ���� NO 1. �귣���� ''�κ�ö����(UPHONE)''�� �츮�� �ַ� ����̸�, ȸ���� Mission�� �ְ��� ����� UX�� ����� ���� ''Work different''��� ���ΰ� �Ʒ� ���� ��𼭳� �� ��̰� �� ���ϰ� �н��� �� �ִ� ���񽺸� ������� ���� ����ϰ� ����ϸ� ������ ������ ������ �ֽ��ϴ�.','? Java ����� ���ο� �� ���� ���� �� ����(�鿣��) 
? �ٽ� ����Ͻ� ���� ����ȭ �� ���ο� �˰��� ���� 
? ��뷮 ������ �ϰ�ó�� �ý��� ���� 
? �κ�ö������ PC �� ����� �� ���� � �� ��������','�ٽ� ���� ����
? �䱸���׿� ���� �������� �м�, ������� ������ ������ �� �ִ� �� 
? �����ͺ��̽� ���� �� �м�, ���� Ȱ�� �ɷ��� ���߽� �� 
? Java, JSP, Javascript ���� �� ���� ������ ���߽� �� 
? ���� ��� 3�� �̻� (��� 8�� �̻��� �ôϾ� �鿣�� ������ ���� ���)
��� ����
? IT ���� ������ 
? ����ó����� �ڰ��� ������ 
? DB, Java ���� �ڰ��� ������ 
? SI ���� ������Ʈ ���� 
? ERD ���� ����','���� �ɻ� > 1�� ����(�ǹ�����) �� ���� ���� �׽�Ʈ > 2�� ����(�ھ��� ����) > 3�� ����(�ӿ�����) > �����հ�','? �������� ���� 1. - �� ���� �κ�ö���� ������� �������� (��������/���� ���� Ư������ ����)	
? �������� ���� 2. - Ƚ�� �� ��뿡 ������� ������ �ڱⰳ�� ��������	
? Work Hard, Play Hard �������� 1. - �ű����� �Ի�� �ش� ���� ���� 15�� �������� �ٷ� �߻�	
? Work Hard, Play Hard �������� 2. - �������� ���� ����ް�(2�� ����) ���	
? �μ� �������� �������� - �ſ� �δ� 4���� �� ������ ���� (�μ��� ������ ���� �ð�)	
? �μ�Ƽ�� ���� - �Ի� 1�� �� �� ���� ����Ϳ� ���� �μ�Ƽ�� ���� 
? �� 1ȸ �ǰ���������: ������ ��� 100���� ��� ���հ�����Ű������ ����(����������Ű�� ����)	
? ��ŷ�� ���� - �ٹ��ð� �� �ٹ���ҿ� ���� Flexibilty ���� (�� 2ȸ ȸ�� ��� �� ��� �� 10~17�� ���� �ٹ�)	
? ���ñٹ� ���� - �μ��� �������¿� ���� ���ñٹ� ���� (���� �������� �������� �� ���ñٹ� ����)	
? ������ ���� - �ӽű� ����ٹ�, �¾ư����ð�, ����ް�, ��������, Birth Gift ���� (�Ż��ƿ� ������Ʈ �ٱ��� ����)	
? ���� �������� �������� - �������� ���� ��ǰ�� �� ���� ����	
? ������� �� ������ �ް����� - ���� �����翡 ���� ������� �� ������ �ް� ����	
? �ұݺ������� - ���� �ݿ����� ������ ������� 
? Ÿ����Ʈ������ - �ұ��� ���� ���߿��� ������ Work & Life Balance�� ���Ѱ� �� �ֵ��� ���� ȿ��ȭ�� ���� �μ� ���� ���� ��Ʈ�� ���� � 
? �系 �������� �޽İ��� - �����鸸�� ���� ī��� ���� �޽İ���	
? �������Ժ� ���� - �ſ� �μ��� �������Ժ� ���� �� ���� ���� ��� �� ��ȭ ��ǰ�� ����	
? �系 Library � - ������ �系 Mini Library � (���� ���� �뿩/�ݳ� �ý���)	
? 1:1 ���� ���� - Open communication�� ���� �� ���� 1:1 �������� �	
? Ÿ��Ȧ Q&A ���� - CEO���� ����������� Direct ������ �ð� �	
? �������� ���� - ���� �������� ������ ��� ���� ���� ���������� ��� (�ݹ����� �����۵� OK)	
? ���� �ִ� ������� - 10�� ��� ~ 19�� ���','�κ�ö�����׷� ä��,recruit@bcm.co.kr,070-4000-2020,http://www.bcm.co.kr','������','������','-','���� �� ����','����/����, �븮, ����','-','2019-02-07','2019-01-11',63,1);
REM INSERTING into LSM8655.MIN_JOB_RECRUIT_LIST
SET DEFINE OFF;
Insert into LSM8655.MIN_JOB_RECRUIT_LIST (NO,NAME,PHONE1,PHONE2,PHONE3,EMAIL,FILE1,FILE2,MEMBER_NO,DATES,WRITER_NO,RECRUIT_NO,FILE3) values (84,'������','010','2312','5556','gusan232@naver.com','o5o20171106005324_1.jpg',null,4,'2019-01-12',42,2,'o1o11040350.jpg');
Insert into LSM8655.MIN_JOB_RECRUIT_LIST (NO,NAME,PHONE1,PHONE2,PHONE3,EMAIL,FILE1,FILE2,MEMBER_NO,DATES,WRITER_NO,RECRUIT_NO,FILE3) values (85,'������','010','3212','2132','tpaks12@gmail.com','o6o20171106005324_1.jpg',null,4,'2019-01-12',43,2,'o1o12322.jpg');
Insert into LSM8655.MIN_JOB_RECRUIT_LIST (NO,NAME,PHONE1,PHONE2,PHONE3,EMAIL,FILE1,FILE2,MEMBER_NO,DATES,WRITER_NO,RECRUIT_NO,FILE3) values (86,'������','010','2321','2233','wjdtnr1@naver.com','o7o20171106005324_1.jpg','o2o20171015221706_1.jpg',4,'2019-01-12',82,2,'o1o42.jpg');
Insert into LSM8655.MIN_JOB_RECRUIT_LIST (NO,NAME,PHONE1,PHONE2,PHONE3,EMAIL,FILE1,FILE2,MEMBER_NO,DATES,WRITER_NO,RECRUIT_NO,FILE3) values (82,'�弮��','010','2922','2222','tjrwns2922@nave.com','o4o20171106005324_1.jpg','o1o20180102234053_1.jpg',4,'2019-01-12',164,2,'o1oI_PAyKUft9T1xd6NFmQz0G4oeycM.jpg');
Insert into LSM8655.MIN_JOB_RECRUIT_LIST (NO,NAME,PHONE1,PHONE2,PHONE3,EMAIL,FILE1,FILE2,MEMBER_NO,DATES,WRITER_NO,RECRUIT_NO,FILE3) values (83,'����ȣ','010','3332','2223','src8655@naver.com','o2o20180224022631_1.jpg',null,4,'2019-01-12',3,2,'o1osss.jpg');
REM INSERTING into LSM8655.MIN_JOB_REVIEW
SET DEFINE OFF;
Insert into LSM8655.MIN_JOB_REVIEW (NO,TYPES,STARS,STARS1,STARS2,STARS3,STARS4,STARS5,MEMO1,MEMO2,MEMO3,MEMBER_NO,DATES,WRITER_NO,PROF,STATUS) values (64,2,3,2,3,3,4,4,'�ܱ��������� �����Ͼ�ν� ������� �о��� ����� ���� �� ������ ������ �ױ� ����ȸ��','���� �� ���� ������ �������迡�� ���� ����� ������ �����̸� ���� ����ȭ�� �ߵǾ� �ְ� ���� ����� �� �����ο� �ް� ����� ������','�濵�� ��κ� 15���� �̸����� ���޿� ���� ������� ������ ���������� ���� �ʾƺ��̸� �Ŵ��� �ְ����� �λ����� ���� ��å�� ���� ����� ���� ���� ��ȭ�� �系 �����Ⱑ �ſ� ȥ�������� ����ȭ�Ǳ� ���� �� ���� �ð��� �ɸ������� �Ǵܵ�',102,'2019-01-12',145,2,-1);
Insert into LSM8655.MIN_JOB_REVIEW (NO,TYPES,STARS,STARS1,STARS2,STARS3,STARS4,STARS5,MEMO1,MEMO2,MEMO3,MEMBER_NO,DATES,WRITER_NO,PROF,STATUS) values (22,2,4,3,4,2,2,5,'���ջ���� �پ��� ���� ��� ����. �׷��� ���� ������ ������.','�� �״�� �� ���踦 ���� �ϴ� �۷ι� ����̹Ƿ� �ڿ������� �ܱ���ɷ°� ���ε�� �þ� ��ü�� ���踦 ���ϴ� �ڽ��� �߰���. ��� ������ ������ ������ Ű��� å�ӹ����� ����. ���� �μ�Ƽ��� ���� �⺻���� �޲���.','���ջ�� ��, �߰������� �оߴ� ���濡 ����� �� ����. �������� �ؿܹ��� ������ ������ ���ջ���� ������ ������ �پ��� ö�� ȭ�п� �����ϱ⿡�� �ʵ� ���� ���ϴ� ���̶� ���� ��ü�� ������ �ſ� ������. �ż������ �߱��� ���� �ø��� ���� �ô뿡 IT������ �پ�� ���ڶ� �ǿ� ��ǻ� �Ұ�����. ȸ�系���� �ȶ��ϴٴ� ��ä��ŵ��� 70���� �̻� ����...',4,'2018-12-28',42,7,-1);
Insert into LSM8655.MIN_JOB_REVIEW (NO,TYPES,STARS,STARS1,STARS2,STARS3,STARS4,STARS5,MEMO1,MEMO2,MEMO3,MEMBER_NO,DATES,WRITER_NO,PROF,STATUS) values (23,2,3,3,3,4,4,1,'�޿��� ������ ������ ũ�� ������ ���ϰ� �뱸�� ���� �Ŀ��� �����ǰ��� �Ÿ� ������ ���������� �����ϰ� ����� �־ �޸�Ʈ�� �� �������� ���. 
������ ���� �������� ���鿡���� �Ǹ��ϴٰ� �����Ѵ�.','������ ��� �������� ��κ��� ������� �ٵ� �׷����� �پ ���� �����̴�. �������� �ִٺ��� �ϰ� ���� ������ �������� �ִٰ� �ǴܵǾ� ���� �Ѵ�. �뱸�� ������ ���� ���� ������ �� ã�� ����鵵 ���̱⵵ �ϰ� �ڱ��� �ð������� �� �Ǹ� ���� ���� ���� ���ٰ� �����Ѵ�.','������ ���� ����� LNG �о��� ������ ��ü Ȥ�� ���� ����� ����.�ڿ����� ����� �̸�� ���ο��� ���������� �ν� �� �� ��Ȥ���� ���Ͽ� ������ ���� ����µ� ���Ƹ԰� �մ� ��Ȳ�� ���� �ƽ��ٰ� �����Ѵ�. ������ �ڿ������� ������ �� ���� ��� �о��̹Ƿ� ���簡 ���������� ����� �ñ������� ������ ����� ������ ������ �Ѵٰ� �����Ѵ�.',4,'2018-12-28',3,1,-1);
Insert into LSM8655.MIN_JOB_REVIEW (NO,TYPES,STARS,STARS1,STARS2,STARS3,STARS4,STARS5,MEMO1,MEMO2,MEMO3,MEMBER_NO,DATES,WRITER_NO,PROF,STATUS) values (24,1,3,3,4,5,3,2,'������ �������迡 ���� �ټ� �������̳� �ð��� �ٹ��� �ϸ� �ð��� ��� ���� ����, �׷��� �߱��� ��κ� ���� �ϴ��� ���� �� �ޱ⋚���� ����鵵 �ƹ������� ����, �系 ��ȭ�� �Ϻ���� �����ο�, ���� ���� ����, ��������','������ ��� ��ġ ���� �Ⱥ��� �ǰ�, �ð� �� �ٹ� ���� �� ì����, ���� ���� ����� ��ġ�� ���⵵ ��, ����� 3~5�� ���� ����Ʈ 30��� ���Ѱ��� �༭ 3���ų�, ���� ���� , ������ 1�δ� 10���� ����, �Ϻ��� ���� �Ἥ ���� ����','���� �ʿ���, �μ� ���� �ָ� ��� �Ҽ���, ���� ������, ����� ��ǰ ���̰� Ŭ���� ���� �ϱ� ������ �δ㰨�� �ֽ��ϴ�.',4,'2018-12-28',43,6,-1);
Insert into LSM8655.MIN_JOB_REVIEW (NO,TYPES,STARS,STARS1,STARS2,STARS3,STARS4,STARS5,MEMO1,MEMO2,MEMO3,MEMBER_NO,DATES,WRITER_NO,PROF,STATUS) values (43,2,3,3,4,5,3,3,'KOSPI�����ü�μ�,����M/S�� ������ ��ġ�� ������ �ϰ� ������, �� ���µ��� ������ ������ �ϰ� �ִ� ��ü��.','������ �������� �� ��� �ټӿ��� ���� 10�� �̻����� �������� �����. ��ä�� ���� �������� �η������� ����Ǿ��ְ�, ü������ �������濡 ������ ȯ����','B2C����� �ƴϴٺ���, �Ϲ� �Һ��� �� �����ڵ鿡�� �������� ���� ������ ����. �Ǽ������ ������ ����.',4,'2019-01-07',82,9,-1);
Insert into LSM8655.MIN_JOB_REVIEW (NO,TYPES,STARS,STARS1,STARS2,STARS3,STARS4,STARS5,MEMO1,MEMO2,MEMO3,MEMBER_NO,DATES,WRITER_NO,PROF,STATUS) values (63,1,4,2,4,3,5,3,'�ѱ� ����ȭ�� �������� �ܱ��� ȸ�� �پ��� ������� �پ��� ������ �ϰ� ������ �ɷ¿� ���� ���� ��ȸ�� ���� �� �ִ� ȸ��','�ε��� ���� �ѹ� 1. �ѱ������� ���� �ѹ� 1.�� �ڶ��ϰ� �ִ�. �������� �����ɷ� ��󿡵� �Ű��� ���� ��','�ټ� ������� �λ籸��. ������ ����翡 ���� �������̾ ������ �η��� ���� ���ѱ�. ������� ��ŭ ������',62,'2019-01-12',3,1,-1);
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
--  DDL for Index MIN_JOB_RECRUIT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LSM8655"."MIN_JOB_RECRUIT_PK" ON "LSM8655"."MIN_JOB_RECRUIT" ("NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index MIN_JOB_RECRUIT_LIST_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LSM8655"."MIN_JOB_RECRUIT_LIST_PK" ON "LSM8655"."MIN_JOB_RECRUIT_LIST" ("NO") 
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
--  DDL for Trigger MIN_JOB_RECRUIT_TRI
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LSM8655"."MIN_JOB_RECRUIT_TRI" 
   before insert on "LSM8655"."MIN_JOB_RECRUIT" 
   for each row 
begin  
   if inserting then 
      if :NEW."NO" is null then 
         select MIN_JOB_RECRUIT_SEQ.nextval into :NEW."NO" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "LSM8655"."MIN_JOB_RECRUIT_TRI" ENABLE;
--------------------------------------------------------
--  DDL for Trigger MIN_JOB_RECRUIT_LIST_TRI
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LSM8655"."MIN_JOB_RECRUIT_LIST_TRI" 
   before insert on "LSM8655"."MIN_JOB_RECRUIT_LIST" 
   for each row 
begin  
   if inserting then 
      if :NEW."NO" is null then 
         select MIN_JOB_RECRUIT_LIST_SEQ.nextval into :NEW."NO" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "LSM8655"."MIN_JOB_RECRUIT_LIST_TRI" ENABLE;
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
--  Constraints for Table MIN_JOB_RECRUIT
--------------------------------------------------------

  ALTER TABLE "LSM8655"."MIN_JOB_RECRUIT" ADD CONSTRAINT "MIN_JOB_RECRUIT_PK" PRIMARY KEY ("NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "LSM8655"."MIN_JOB_RECRUIT" MODIFY ("NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MIN_JOB_RECRUIT_LIST
--------------------------------------------------------

  ALTER TABLE "LSM8655"."MIN_JOB_RECRUIT_LIST" ADD CONSTRAINT "MIN_JOB_RECRUIT_LIST_PK" PRIMARY KEY ("NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "LSM8655"."MIN_JOB_RECRUIT_LIST" MODIFY ("NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MIN_JOB_REVIEW
--------------------------------------------------------

  ALTER TABLE "LSM8655"."MIN_JOB_REVIEW" ADD CONSTRAINT "MIN_JOB_REVIEW_PK" PRIMARY KEY ("NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "LSM8655"."MIN_JOB_REVIEW" MODIFY ("NO" NOT NULL ENABLE);
