--------------------------------------------------------
--  파일이 생성됨 - 화요일-1월-08-2019   
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
	"FOLLOW" VARCHAR2(2000 BYTE)
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
	"MEMO1" VARCHAR2(2000 BYTE), 
	"MEMO2" VARCHAR2(2000 BYTE), 
	"MEMO3" VARCHAR2(2000 BYTE), 
	"MEMO4" VARCHAR2(2000 BYTE), 
	"MEMO5" VARCHAR2(2000 BYTE), 
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
	"RECRUIT_NO" NUMBER
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
Insert into LSM8655.MIN_JOB_COMPANY (NO,MEMBER_NO,URL,INFO,NAME,FOUNDING,COUNT,COMPANY_TYPE,MONEY,ADDR,FILE1,FILE2) values (42,62,'www.kakaocorp.com','(주)카카오의 전 직원 현 직원들이 작성한 303개 기업리뷰, 493개 연봉정보와 구직자들에 의해 제출된 457개 면접후기, 실시간 3개 채용과 뉴스 등을 확인하세요.','여민수, 조수용','1995-02-16','2,465명 (2016)',1,'9,321.6억 원 ( 2015 )','제주특별자치도 제주시 첨단로 242','o1othumb_kakao.jpg','o2ooffice-2360063_1920.jpg');
Insert into LSM8655.MIN_JOB_COMPANY (NO,MEMBER_NO,URL,INFO,NAME,FOUNDING,COUNT,COMPANY_TYPE,MONEY,ADDR,FILE1,FILE2) values (43,63,'www.google.co.kr','구글코리아(유)의 전 직원 현 직원들이 작성한 80개 기업리뷰, 107개 연봉정보와 구직자들에 의해 제출된 133개 면접후기, 실시간 0개 채용과 뉴스 등을 확인하세요.','매튜스캇쥬커먼, 염동훈','2004-03-15','100명 (2009)',2,'-','서울 강남구 역삼1동 737 강남파이낸스센터 22층','o1othumb______.png','o1oapple-1868496_1920.jpg');
Insert into LSM8655.MIN_JOB_COMPANY (NO,MEMBER_NO,URL,INFO,NAME,FOUNDING,COUNT,COMPANY_TYPE,MONEY,ADDR,FILE1,FILE2) values (22,22,'55','77','11','22','33',2,'44','66','(2)test.jpg','o1ooffice_bk.jpg');
Insert into LSM8655.MIN_JOB_COMPANY (NO,MEMBER_NO,URL,INFO,NAME,FOUNDING,COUNT,COMPANY_TYPE,MONEY,ADDR,FILE1,FILE2) values (2,4,'http://newsroom.fb.com/company-info/','페이스북코리아는 커뮤니티를 이루어 모두가 더욱 가까워지는 세상을 만든다는 사명 아래 매년 빠르게 성장하고 있습니다. 자유로운 분위기에서 변화를 주도하고, 여러 사람들과의 협업을 통해 큰 그림을 만들어 갈 수 있는 분들의 지원을 기다립니다.','데이비드드윌리암크링, 조용범','2010.12.06','-',2,'-','서울 강남구 역삼동 736-1 캐피탈타워','o1othumb_______.png','o3ooffice-2360063_1920.jpg');
REM INSERTING into LSM8655.MIN_JOB_COUNT
SET DEFINE OFF;
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (15,'2018-12-26',22);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (16,'2018-12-26',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (96,'2019-01-03',62);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (97,'2019-01-03',63);
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
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (22,'2018-12-27',4);
Insert into LSM8655.MIN_JOB_COUNT (NO,DATES,MEMBER_NO) values (23,'2018-12-27',4);
REM INSERTING into LSM8655.MIN_JOB_INCOME
SET DEFINE OFF;
Insert into LSM8655.MIN_JOB_INCOME (NO,MEMBER_NO,WRITER_NO,POSITIONS,MONEY,DATES,PROF,EMPL,STATUS) values (22,4,43,3,2000,'2018-12-28',1,3,-1);
Insert into LSM8655.MIN_JOB_INCOME (NO,MEMBER_NO,WRITER_NO,POSITIONS,MONEY,DATES,PROF,EMPL,STATUS) values (23,4,42,3,2600,'2018-12-28',3,3,-1);
Insert into LSM8655.MIN_JOB_INCOME (NO,MEMBER_NO,WRITER_NO,POSITIONS,MONEY,DATES,PROF,EMPL,STATUS) values (24,4,3,1,3000,'2018-12-28',2,3,-1);
Insert into LSM8655.MIN_JOB_INCOME (NO,MEMBER_NO,WRITER_NO,POSITIONS,MONEY,DATES,PROF,EMPL,STATUS) values (25,22,3,5,5000,'2018-12-28',2,3,-1);
Insert into LSM8655.MIN_JOB_INCOME (NO,MEMBER_NO,WRITER_NO,POSITIONS,MONEY,DATES,PROF,EMPL,STATUS) values (42,4,82,2,1900,'2019-01-07',2,3,-1);
REM INSERTING into LSM8655.MIN_JOB_INTERVIEW
SET DEFINE OFF;
Insert into LSM8655.MIN_JOB_INTERVIEW (NO,PROF,POSITIONS,DIFFICULTY,INTERVIEWDATE,INTERVIEWDIR,MEMO1,MEMO2,MEMO3,MEMO4,MEMO5,INTERVIEWRESULT,INTERVIEWEX,DATES,STATUS,MEMBER_NO,WRITER_NO) values (2,3,2,4,'2018-12',1,'ㄴㅇㄹㄴㅇㄹㄴㅇㄹㄴㅇㄹ','ㄴㅇㄹㄴㅇㄹㄴㅇㄹㄴㅇㄹ','ㄴㅇㄹㄴㅇㄹㄴㅇㄹㄴㅇㄹㄴㅇㄹㄴㅇㄹ','ㄴㅇㄹㄴㅇㄹ','ㄴㅇㄹㄴㅇㄹㄴㅇㄹㄴㅇㄹ',2,1,'2018-12-28',-1,4,3);
Insert into LSM8655.MIN_JOB_INTERVIEW (NO,PROF,POSITIONS,DIFFICULTY,INTERVIEWDATE,INTERVIEWDIR,MEMO1,MEMO2,MEMO3,MEMO4,MEMO5,INTERVIEWRESULT,INTERVIEWEX,DATES,STATUS,MEMBER_NO,WRITER_NO) values (3,1,1,3,'2018-11',1,'필기보고 면접은 실무진 면접 임원면접인데 실무진면접 중 체육관 면적이 있습니다 도미노 쌓는거해요','피티면접은 변제충당(법학)에 대한 사례가 나왔습니다. 찬반면접은 가상의 악덕기업이 무역보험을 신청할 경우에 무보에서 보험을 해줘야 하는지에 대한 토론을 했습니다.','변제충당에 대한 개념 및 취지, 그리고 부수적으로 관련 되는 실체법상의 일반 개념을 설명하고 이를 바탕으로 사례에 대입했습니다. 찬성과 반대의 입장을 정해주기 때문에 반대의 입장에서 근거를 말했습니다.','필기시험, 논술 시험','10일 후',3,2,'2018-12-28',-1,4,42);
Insert into LSM8655.MIN_JOB_INTERVIEW (NO,PROF,POSITIONS,DIFFICULTY,INTERVIEWDATE,INTERVIEWDIR,MEMO1,MEMO2,MEMO3,MEMO4,MEMO5,INTERVIEWRESULT,INTERVIEWEX,DATES,STATUS,MEMBER_NO,WRITER_NO) values (4,6,1,2,'2018-12',4,'서류 통과 하고 인적성 치고 1차 2차 면접 여느 대기업과 같음','학점이 3.5정도 인데 학점이 왜이렇게 낮냐','이런 이런 이런 여러 활동들을 많이 했다 공부보다 이게 더 좋아서 했고 성과를 냈따 후회하지 않는다','필기시험, 영어면접, 토론면접, 개인면접','10일 후',1,3,'2018-12-28',-1,4,43);
Insert into LSM8655.MIN_JOB_INTERVIEW (NO,PROF,POSITIONS,DIFFICULTY,INTERVIEWDATE,INTERVIEWDIR,MEMO1,MEMO2,MEMO3,MEMO4,MEMO5,INTERVIEWRESULT,INTERVIEWEX,DATES,STATUS,MEMBER_NO,WRITER_NO) values (22,3,3,5,'2018-02',2,'33','111','222','333','444',2,1,'2019-01-08',-1,4,82);
REM INSERTING into LSM8655.MIN_JOB_MEMBER
SET DEFINE OFF;
Insert into LSM8655.MIN_JOB_MEMBER (NO,EMAIL,PASSWORD,NAME,PHONE1,PHONE2,PHONE3,QUEST,ANSWER,COMPANY,COMPANY_CATE,COMPANY_NUM,ORDERS,DATES,FOLLOW) values (62,'src86552@naver.com','3162F8A6D36EC8DE769A2127BFFA651','여민수','010','5555','6666',3,'몰라','다음카카오',7,'128-25-66558',2,'2019-01-03',null);
Insert into LSM8655.MIN_JOB_MEMBER (NO,EMAIL,PASSWORD,NAME,PHONE1,PHONE2,PHONE3,QUEST,ANSWER,COMPANY,COMPANY_CATE,COMPANY_NUM,ORDERS,DATES,FOLLOW) values (63,'src86553@naver.com','3162F8A6D36EC8DE769A2127BFFA651','매튜스','010','7777','8888',2,'몰라','구글코리아(유)',7,'123-66-99887',2,'2019-01-03',null);
Insert into LSM8655.MIN_JOB_MEMBER (NO,EMAIL,PASSWORD,NAME,PHONE1,PHONE2,PHONE3,QUEST,ANSWER,COMPANY,COMPANY_CATE,COMPANY_NUM,ORDERS,DATES,FOLLOW) values (82,'src88223@naver.com','D064802D1B2D5346936161E4340A7E9','미노','321','11','22',2,'몰라',null,-1,null,1,'2019-01-07','4');
Insert into LSM8655.MIN_JOB_MEMBER (NO,EMAIL,PASSWORD,NAME,PHONE1,PHONE2,PHONE3,QUEST,ANSWER,COMPANY,COMPANY_CATE,COMPANY_NUM,ORDERS,DATES,FOLLOW) values (22,'src86551@naver.com','3162F8A6D36EC8DE769A2127BFFA651','민호2','11','22','33',1,'몰라','네이버',7,'12155-42-44556',2,'2018-12-24',null);
Insert into LSM8655.MIN_JOB_MEMBER (NO,EMAIL,PASSWORD,NAME,PHONE1,PHONE2,PHONE3,QUEST,ANSWER,COMPANY,COMPANY_CATE,COMPANY_NUM,ORDERS,DATES,FOLLOW) values (42,'src88221@naver.com','D064802D1B2D5346936161E4340A7E9','홍길동','123','321','123',3,'몰라',null,-1,null,1,'2018-12-27',null);
Insert into LSM8655.MIN_JOB_MEMBER (NO,EMAIL,PASSWORD,NAME,PHONE1,PHONE2,PHONE3,QUEST,ANSWER,COMPANY,COMPANY_CATE,COMPANY_NUM,ORDERS,DATES,FOLLOW) values (3,'src8822@naver.com','D064802D1B2D5346936161E4340A7E9','윤민호','010','3324','4343',1,'몰라',null,-1,null,1,null,null);
Insert into LSM8655.MIN_JOB_MEMBER (NO,EMAIL,PASSWORD,NAME,PHONE1,PHONE2,PHONE3,QUEST,ANSWER,COMPANY,COMPANY_CATE,COMPANY_NUM,ORDERS,DATES,FOLLOW) values (4,'src8655@naver.com','3162F8A6D36EC8DE769A2127BFFA651','민호','11','22','33',2,'몰라','페이스북코리아',5,'127-24-447788',2,null,'22,4');
Insert into LSM8655.MIN_JOB_MEMBER (NO,EMAIL,PASSWORD,NAME,PHONE1,PHONE2,PHONE3,QUEST,ANSWER,COMPANY,COMPANY_CATE,COMPANY_NUM,ORDERS,DATES,FOLLOW) values (43,'src88222@naver.com','D064802D1B2D5346936161E4340A7E9','윤민호2','321','123','321',5,'몰라',null,-1,null,1,'2018-12-27',null);
REM INSERTING into LSM8655.MIN_JOB_RECRUIT
SET DEFINE OFF;
Insert into LSM8655.MIN_JOB_RECRUIT (NO,SUBJECT,KEYWORD,MEMO1,MEMO2,MEMO3,MEMO4,MEMO5,CONTACT,PROF,EMPL,GRADE,MONEY,POSITIONS1,POSITIONS2,ENDDATES,DATES,MEMBER_NO,STATUS) values (2,'(주)히트코리아 Back-End 개발자 정규직 채용','정규직,웹개발,서울,소프트웨어엔지니어,시스템엔지니어,경력 5년 이상 우대','신뢰와 소통의 알트코인 전문 암호화폐 거래소 히트코리아 입니다. 
빠르게 성장하고 있는 암호화폐 거래시장에 새로운 방향을 제시합니다.','Back-End 개발','핵심 직무 역량
- 경력 5년 이상 

- UNIX C 전문가 

- Framework 경험자 

- FEP 개발경험자 

- 통신 프로그램 개발 경험자 

- Visual C++ 개발자 

- JAVA / JSP / Java Framework (Spring) 경험 

- Java Script / JQuery 경험 

- Oracle / MS SQL / MySQL DBMS 기반의 모델링 (설계)
우대 사항
- 주식거래 시스템의 매매, 결제, 계정개발 경험 

- 주식거래 시스템의 계좌출납, 집계 등의 업무 프로그램 경험 

- 증권사 HTS 개발 경험 

- 거래소 사이트 경험자 

- Java Daemon / Node.js 경험자','서류전형 - 임원면접 - 합격통보','혜택 및 복지 
? 전 직장보다 시간적/경제적으로 더 나은 삶 추구 
? 편리한 출퇴근 (역삼역 3번 출구 도보 1분) 
? 자율적 업무환경 
? 업무관련 컨퍼런스/교육/도서구매비 지원 
? 월 1회이상 팀 회식 및 수시 티타임 제공 
? 직무 수행에 필요한 최신장비/소프트웨어 제공 
? 최고의 업무 환경인 역삼역점 입주사입니다. 안락한 환경, 국내/외 지점 자유로운 이용, 커피, 간식 무한제공','히트코리아,chongmu@naver.com,1800-9999,http://hitkorea.co','소프트웨어엔지니어, 시스템엔지니어, 웹개발','정규직','학력무관','연봉 (최소 6,000만원 ~ 최대 8,000만원)','-','팀장급(팀장/실장)','2019-03-02','2019-01-04',4,1);
Insert into LSM8655.MIN_JOB_RECRUIT (NO,SUBJECT,KEYWORD,MEMO1,MEMO2,MEMO3,MEMO4,MEMO5,CONTACT,PROF,EMPL,GRADE,MONEY,POSITIONS1,POSITIONS2,ENDDATES,DATES,MEMBER_NO,STATUS) values (22,'Java·JSP(Spring) 정규직 채용합니다(경력사원)','웹개발,대구,경력 1년 이상,정규직','2005년 3월 14일에 설립된 컴퓨터시스템 통합 자문 및 구축 서비스업 업종의 시스템 통합(영상회의록,검색엔진,인터넷관리시스템)구축,설계/통신공사 사업을 하는 중소기업이며, 자본금은 3억원 매출액은 37억 6,600만원 사원수는 31명입니다.

','모집부문 

웹프로그램 개발(JSP, Spring)
(주임연구원, 연구원급)


','자격요건

- 학력 : 무관

- 경력 : 경력 1년 ~ 5년

- 성별 : 무관

- 모집인원 : 1명


우대사항

- 해당직무 근무경험

- 정보처리기사

- 컴퓨터/시스템공학


기타 유의사항
입사지원 서류에 허위사실이 발견될 경우, 채용확정 이후라도 채용이 취소될 수 있습니다.
','서류전형 - 기술면접 - 임원면접 - 합격통보

제출서류 : 자기소개서, 이력서','
근무형태	
정규직

근무부서	기술연구소
근무요일/시간	주 5일(월~금) 오전 9시~오후 6시
근무지역	
대구 - 달서구

급여	회사내규에 따름
회사주소	(704-230) 대구 달서구 호산동 711','사람인,053-581-0000,010-8850-0111','웹개발','정규직','학력무관','연봉 (최소 2,600만원 ~ 최대 3,600만원)','-','-','2019-02-03','2019-01-03',22,1);
Insert into LSM8655.MIN_JOB_RECRUIT (NO,SUBJECT,KEYWORD,MEMO1,MEMO2,MEMO3,MEMO4,MEMO5,CONTACT,PROF,EMPL,GRADE,MONEY,POSITIONS1,POSITIONS2,ENDDATES,DATES,MEMBER_NO,STATUS) values (43,'모바일라우터 웹개발자 정규직채용-신입/경력','CGI, HTML, JAVASCRIPT, LUA, LUCI, ASP, 웹서버 포팅, 네트워크','유선 통신장비 제조업 업종 기업으로 유선정보통신기기(광가입자망장치,광인터넷접속장치)제조,도매/정보통신 소프트웨어 개발 사업을 하는 외부감사법인기업이며, 자본금은 19억 2,858만원 매출액은 46억 5,894만원 사원수는 24명입니다.','- 모바일 라우터/공유기 웹페이지 개발

- CGI, HTML, javascript, LUA, LUCI, ASP, 웹서버 포팅, 네트워크

(대리, 과장, 사원급)','자격요건

- 학력 : 무관

- 경력 : 무관 (신입도 지원 가능)

- 성별 : 무관

- 모집인원 : 0명


필수사항

- 컴퓨터/시스템공학


우대사항

- 해당직무 근무경험

- CGI

- HTML

- javascript

- LUA

- LUCI

- ASP

- 웹서버 포팅

- 네트워크 지식 필요

- 전기/전자공학','전형절차	지원시 이력서 포함 간단한 경력 소개자료제출 후 서류심사 후 면접진행.
임원 면접 후 합격자 대표이사 면담 후 채용 결정
제출서류	이력서 및 개발 경력에 관련된 소개자료','근무형태	
정규직(수습기간)-3개월

근무부서	연구개발
근무요일/시간	주 5일(월~금) 오전 9시~오후 6시
근무지역	
경기 - 성남시 분당구

급여	면접후 결정
회사주소	(463-400) 경기 성남시 분당구 삼평동 685 미래에셋벤처타워 9층
인근전철	신분당선 판교 에서 1km 이내','엄아름,070-7730-9300','웹개발, 시스템엔지니어, 웹디자인','정규직','학력무관','면접 후 결정','-','-','2019-02-02','2019-01-08',4,1);
REM INSERTING into LSM8655.MIN_JOB_RECRUIT_LIST
SET DEFINE OFF;
Insert into LSM8655.MIN_JOB_RECRUIT_LIST (NO,NAME,PHONE1,PHONE2,PHONE3,EMAIL,FILE1,FILE2,MEMBER_NO,DATES,WRITER_NO,RECRUIT_NO) values (2,'윤민호','11','22','33','222','o1o20171027171215_1.jpg','o1o20190101014740_1.jpg',4,'2019-01-03',3,2);
Insert into LSM8655.MIN_JOB_RECRUIT_LIST (NO,NAME,PHONE1,PHONE2,PHONE3,EMAIL,FILE1,FILE2,MEMBER_NO,DATES,WRITER_NO,RECRUIT_NO) values (3,'홍길동','123','456','789','ㅇㅇ55','o1oDO it! 프런트앤드 웹디자인 입문3.pdf',null,4,'2019-01-03',42,2);
Insert into LSM8655.MIN_JOB_RECRUIT_LIST (NO,NAME,PHONE1,PHONE2,PHONE3,EMAIL,FILE1,FILE2,MEMBER_NO,DATES,WRITER_NO,RECRUIT_NO) values (22,'철수','010','9999','9999','src88222@naver.com','o1o20171027181853_1.jpg',null,4,'2019-01-04',43,2);
Insert into LSM8655.MIN_JOB_RECRUIT_LIST (NO,NAME,PHONE1,PHONE2,PHONE3,EMAIL,FILE1,FILE2,MEMBER_NO,DATES,WRITER_NO,RECRUIT_NO) values (46,'123','123','123','1231','23','o2o20171127000241_1.jpg','o4oTETRIS.jar',4,'2019-01-08',82,43);
REM INSERTING into LSM8655.MIN_JOB_REVIEW
SET DEFINE OFF;
Insert into LSM8655.MIN_JOB_REVIEW (NO,TYPES,STARS,STARS1,STARS2,STARS3,STARS4,STARS5,MEMO1,MEMO2,MEMO3,MEMBER_NO,DATES,WRITER_NO,PROF,STATUS) values (22,2,4,3,4,2,2,5,'종합상사의 다양한 경험 취득 가능. 그러나 업종 전망은 불투명.','말 그대로 전 세계를 상대로 하는 글로벌 기업이므로 자연스럽게 외국어능력과 마인드와 시야 자체가 세계를 향하는 자신을 발견함. 사원 때부터 본인의 역량을 키우고 책임범위가 넓음. 연말 인센티브로 낮은 기본급을 메꿔줌.','종합상사 즉, 중개무역업 분야는 사양길에 접어든 지 오래. 제조업의 해외법인 설립이 많아져 종합상사의 입지는 갈수록 줄어들고 철강 화학에 의존하기에는 너도 나도 다하는 것이라 업종 자체의 전망은 매우 불투명. 신수종사업 발굴에 열을 올리나 요즘 시대에 IT업종을 뛰어들어도 모자란 판에 사실상 불가능함. 회사내에서 똑똑하다는 공채출신들은 70프로 이상 이직...',4,'2018-12-28',42,7,-1);
Insert into LSM8655.MIN_JOB_REVIEW (NO,TYPES,STARS,STARS1,STARS2,STARS3,STARS4,STARS5,MEMO1,MEMO2,MEMO3,MEMBER_NO,DATES,WRITER_NO,PROF,STATUS) values (23,2,3,3,3,4,4,1,'급여는 정부의 규제로 크게 오르지 못하고 대구로 이전 후에는 수도권과의 거리 문제도 여러가지를 불편하게 만들고 있어서 메리트가 좀 떨어지는 기업. 
하지만 아직 안정성의 측면에서는 훌륭하다고 생각한다.','직원의 고용 안정성이 대부분의 공기업이 다들 그렇지만 뛰어난 것이 장점이다. 안정성이 있다보니 일과 삶의 균형도 맞춰지고 있다고 판단되어 지긴 한다. 대구로 내려간 이후 삶의 여유를 더 찾는 사람들도 보이기도 하고 자기의 시간관리가 잘 되면 더할 나위 없이 좋다고 생각한다.','공사의 본래 사업이 LNG 분야의 성장이 정체 혹은 퇴보할 우려가 많다.자원개발 사업을 이명박 정부에서 수행했으나 부실 및 비리 의혹으로 인하여 공사의 본래 경쟁력도 갉아먹고 잇는 상황이 많이 아쉽다고 생각한다. 하지만 자원개발은 포기할 수 없는 사업 분야이므로 공사가 전사적으로 어려운 시기이지만 꾸준히 사업을 영위해 나가야 한다고 생각한다.',4,'2018-12-28',3,1,-1);
Insert into LSM8655.MIN_JOB_REVIEW (NO,TYPES,STARS,STARS1,STARS2,STARS3,STARS4,STARS5,MEMO1,MEMO2,MEMO3,MEMBER_NO,DATES,WRITER_NO,PROF,STATUS) values (24,1,3,3,4,5,3,2,'연봉은 동종업계에 비해 다소 적은편이나 시간외 근무를 하면 시간당 배로 돈을 쳐줌, 그래서 야근이 대부분 없고 하더라도 돈을 다 받기떄문에 사람들도 아무말없이 잘함, 사내 문화는 일본계라 자유로움, 꼽질 별로 없음, 존중해줌','연차나 퇴근 눈치 많이 안봐도 되고, 시간 외 근무 돈을 다 챙겨줌, 일은 별로 어렵지 않치만 많기도 함, 기숙사 3~5년 제공 아파트 30평대 방한개씩 줘서 3명살거나, 원룸 제공 , 공과금 1인당 10만원 제공, 일본어 자주 써서 배울수 있음','자차 필요함, 부서 별로 주말 출근 할수도, 교통 별로임, 만드는 제품 고가이고 클린룸 업무 하기 떄문에 부담감이 있습니다.',4,'2018-12-28',43,6,-1);
Insert into LSM8655.MIN_JOB_REVIEW (NO,TYPES,STARS,STARS1,STARS2,STARS3,STARS4,STARS5,MEMO1,MEMO2,MEMO3,MEMBER_NO,DATES,WRITER_NO,PROF,STATUS) values (43,2,3,3,4,5,3,3,'KOSPI상장업체로서,국내M/S의 독점적 위치를 공고히 하고 있으며, 긴 업력동안 꾸준한 성장을 하고 있는 업체임.','독점적 시장지위 및 평균 근속연수 또한 10년 이상으로 안정적인 기업임. 공채를 통한 안정적인 인력인프라가 구축되어있고, 체계적인 업무습득에 유리한 환경임','B2C기업이 아니다보니, 일반 소비자 및 구직자들에게 인지도가 낮은 측면이 있음. 건설경기의 영향을 받음.',4,'2019-01-07',82,9,-1);
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
