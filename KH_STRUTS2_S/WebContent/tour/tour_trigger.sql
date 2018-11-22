--------------------------------------------------------
--  颇老捞 积己凳 - 格夸老-11岿-22-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Trigger MIN_TOUR_LIST_RESERVE_TRI
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LSM8655"."MIN_TOUR_LIST_RESERVE_TRI" 
   before insert on "LSM8655"."MIN_TOUR_LIST_RESERVE" 
   for each row 
begin  
   if inserting then 
      if :NEW."NO" is null then 
         select MIN_TOUR_LIST_RESERVE_SEQ.nextval into :NEW."NO" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "LSM8655"."MIN_TOUR_LIST_RESERVE_TRI" ENABLE;
--------------------------------------------------------
--  DDL for Trigger MIN_TOUR_LIST_TRI
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LSM8655"."MIN_TOUR_LIST_TRI" 
   before insert on "LSM8655"."MIN_TOUR_LIST" 
   for each row 
begin  
   if inserting then 
      if :NEW."NO" is null then 
         select MIN_TOUR_LIST_SEQ.nextval into :NEW."NO" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "LSM8655"."MIN_TOUR_LIST_TRI" ENABLE;
--------------------------------------------------------
--  DDL for Trigger MIN_TOUR_MEMBER_TRI
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LSM8655"."MIN_TOUR_MEMBER_TRI" 
   before insert on "LSM8655"."MIN_TOUR_MEMBER" 
   for each row 
begin  
   if inserting then 
      if :NEW."NO" is null then 
         select MIN_TOUR_MEMBER_SEQ.nextval into :NEW."NO" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "LSM8655"."MIN_TOUR_MEMBER_TRI" ENABLE;
--------------------------------------------------------
--  DDL for Trigger MIN_TOUR_NOTICE_TRI
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LSM8655"."MIN_TOUR_NOTICE_TRI" 
   before insert on "LSM8655"."MIN_TOUR_NOTICE" 
   for each row 
begin  
   if inserting then 
      if :NEW."NO" is null then 
         select MIN_TOUR_NOTICE_SEQ.nextval into :NEW."NO" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "LSM8655"."MIN_TOUR_NOTICE_TRI" ENABLE;
--------------------------------------------------------
--  DDL for Trigger MIN_TOUR_QNA
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LSM8655"."MIN_TOUR_QNA" 
   before insert on "LSM8655"."MIN_TOUR_QNA" 
   for each row 
begin  
   if inserting then 
      if :NEW."NO" is null then 
         select MIN_TOUR_QNA_SEQ.nextval into :NEW."NO" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "LSM8655"."MIN_TOUR_QNA" ENABLE;
--------------------------------------------------------
--  DDL for Trigger MIN_TOUR_RESERVE_TRI
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LSM8655"."MIN_TOUR_RESERVE_TRI" 
   before insert on "LSM8655"."MIN_TOUR_RESERVE" 
   for each row 
begin  
   if inserting then 
      if :NEW."NO" is null then 
         select MIN_TOUR_RESERVE_SEQ.nextval into :NEW."NO" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "LSM8655"."MIN_TOUR_RESERVE_TRI" ENABLE;
--------------------------------------------------------
--  DDL for Trigger MIN_TOUR_REVIEW_TRI
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "LSM8655"."MIN_TOUR_REVIEW_TRI" 
   before insert on "LSM8655"."MIN_TOUR_REVIEW" 
   for each row 
begin  
   if inserting then 
      if :NEW."NO" is null then 
         select MIN_TOUR_REVIEW_SEQ.nextval into :NEW."NO" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "LSM8655"."MIN_TOUR_REVIEW_TRI" ENABLE;
