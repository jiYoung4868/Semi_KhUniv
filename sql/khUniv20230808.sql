--desc notice;
--insert into notice values (1, '첫글', '첫글의 내용', sysdate, 'P082');
--
--SELECT NOTICE_NO, NOTICE_TITLE, TO_CHAR(NWRITTEN_TIME, 'YYYY-MM-DD HH24:MI:SS') NWRITTEN_TIME, WRITER FROM NOTICE where writer = 'P082';
--commit;
--
--INSERT INTO NOTICE VALUES (2, '두번째글', '두번째글의 내용', sysdate, 'P083');
--
--
--
--SELECT NOTICE_NO, NOTICE_TITLE, TO_CHAR(NWRITTEN_TIME, 'YYYY-MM-DD HH24:MI:SS') NWRITTEN_TIME, PROFESSOR_NAME AS WRITER
--FROM NOTICE JOIN PROFESSOR ON WRITER = PROFESSOR_NO
--WHERE NOTICE_NO = 1;
--
--CREATE VIEW NOTICELIST AS
--SELECT NOTICE_NO, NOTICE_TITLE, TO_CHAR(NWRITTEN_TIME, 'YYYY-MM-DD HH24:MI:SS') NWRITTEN_TIME, PROFESSOR_NAME AS WRITER
--FROM NOTICE JOIN PROFESSOR ON WRITER = PROFESSOR_NO
--ORDER BY NOTICE_NO ASC;
--
--COMMIT;
--
--SELECT NOTICE_NO, NOTICE_TITLE, NWRITTEN_TIME, WRITER
--FROM NOTICELIST
--WHERE NOTICE_NO = 1;

--SELECT COUNT(*) CNT FROM NOTICE;

--DESC COMMENT;
--
--INSERT INTO "COMMENT" VALUES (1, SYSDATE, 2, 'P082', '안녕하세요');

--*****오류발생
--명령의 30 행에서 시작하는 중 오류 발생 -
--INSERT INTO COMMENT VALUES (1, SYSDATE, 2, 'P082', '안녕하세요')
--오류 발생 명령행: 30 열: 13
--오류 보고 -
--SQL 오류: ORA-00903: 테이블명이 부적합합니다
--00903. 00000 -  "invalid table name"
--*Cause:    
--*Action:
--
--1 행 이(가) 삽입되었습니다.
--COMMENT가 오라클 내에서 사용하는 명령어이기 때문에 "" 넣어줘야함.

--SELECT COMMENTER, COMMENT_CONTENT, CWRITTEN_TIME FROM "COMMENT" WHERE NOTICE_NO=2;
--
--commit;

--CREATE VIEW NOTICELIST AS
--SELECT NOTICE_NO, NOTICE_TITLE, TO_CHAR(NWRITTEN_TIME, 'YYYY-MM-DD HH24:MI:SS') NWRITTEN_TIME, PROFESSOR_NAME AS WRITER
--FROM NOTICE JOIN PROFESSOR ON WRITER = PROFESSOR_NO
--ORDER BY NOTICE_NO ASC;


--CREATE VIEW MEMBER AS 
--    SELECT PROFESSOR_NO MEMBER_NO, PROFESSOR_NAME MEMBER_NAME 
--    FROM PROFESSOR 
--    UNION 
--    SELECT STUDENT_NO, STUDENT_NAME FROM STUDENT; 
    
--SELECT MEMBER_NO, MEMBER_NAME
--FROM MEMBER M JOIN "COMMENT" C ON (M.MEMBER_NO = C.COMMENTER);
--
--CREATE VIEW CMEMBER AS SELECT MEMBER_NO, MEMBER_NAME FROM MEMBER M JOIN "COMMENT" C ON (M.MEMBER_NO = C.COMMENTER);

INSERT INTO "COMMENT" 