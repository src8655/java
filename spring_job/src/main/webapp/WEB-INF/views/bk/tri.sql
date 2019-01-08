--------------------------------------------------------
--  파일이 생성됨 - 화요일-1월-08-2019   
--------------------------------------------------------
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
