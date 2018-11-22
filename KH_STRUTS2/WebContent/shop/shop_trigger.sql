--------------------------------------------------------
--  颇老捞 积己凳 - 格夸老-11岿-22-2018   
--------------------------------------------------------
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
