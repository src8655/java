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
--  DDL for Table MIN_JOB_REPORT
--------------------------------------------------------

  CREATE TABLE "LSM8655"."MIN_JOB_REPORT" 
   (	"NO" NUMBER, 
	"MEMBER_NO" NUMBER, 
	"WRITER_NO" NUMBER, 
	"TAB" NUMBER, 
	"REPORT_VALUE" NUMBER, 
	"DATES" VARCHAR2(255 BYTE), 
	"TAB_NO" NUMBER
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
--  DDL for Index MIN_JOB_REPORT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LSM8655"."MIN_JOB_REPORT_PK" ON "LSM8655"."MIN_JOB_REPORT" ("NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
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
--  DDL for Trigger MIN_JOB_REPORT_TRI
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LSM8655"."MIN_JOB_REPORT_TRI" 
   before insert on "LSM8655"."MIN_JOB_REPORT" 
   for each row 
begin  
   if inserting then 
      if :NEW."NO" is null then 
         select MIN_JOB_REPORT_SEQ.nextval into :NEW."NO" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "LSM8655"."MIN_JOB_REPORT_TRI" ENABLE;
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
--  Constraints for Table MIN_JOB_REPORT
--------------------------------------------------------

  ALTER TABLE "LSM8655"."MIN_JOB_REPORT" ADD CONSTRAINT "MIN_JOB_REPORT_PK" PRIMARY KEY ("NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "LSM8655"."MIN_JOB_REPORT" MODIFY ("NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MIN_JOB_REVIEW
--------------------------------------------------------

  ALTER TABLE "LSM8655"."MIN_JOB_REVIEW" ADD CONSTRAINT "MIN_JOB_REVIEW_PK" PRIMARY KEY ("NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "LSM8655"."MIN_JOB_REVIEW" MODIFY ("NO" NOT NULL ENABLE);
