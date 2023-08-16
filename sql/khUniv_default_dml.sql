--- PROFESSOR_LEVEL
INSERT INTO PROFESSOR_LEVEL VALUES ('전임');
INSERT INTO PROFESSOR_LEVEL VALUES ('명예');
INSERT INTO PROFESSOR_LEVEL VALUES ('출강');
commit;

-- TABLE "DEPARTMENT"
--DESC DEPARTMENT;
INSERT ALL INTO DEPARTMENT VALUES(DEPARTMENT_NO, DEPARTMENT_NAME, CAPACITY)
SELECT DEPARTMENT_NO, DEPARTMENT_NAME, CAPACITY
FROM TB_DEPARTMENT
;

-- TABLE "PROFESSOR"
--DESC PROFESSOR;
INSERT ALL INTO PROFESSOR VALUES 
(PROFESSOR_NO, PROFESSOR_NAME, PROFESSOR_PHONE, PROFESSOR_LEVEL, DEPARTMENT_NO, PROFESSOR_PWD)
SELECT 
 PROFESSOR_NO
, PROFESSOR_NAME
, CONCAT('010-',CONCAT((SUBSTR(PROFESSOR_SSN,1,4)),(SUBSTR(PROFESSOR_SSN,7,5)))) PROFESSOR_PHONE
, (CASE
        WHEN (SUBSTR(PROFESSOR_SSN,14,1) >= 1) AND (SUBSTR(PROFESSOR_SSN,14,1) <= 3) THEN '명예'
        WHEN (SUBSTR(PROFESSOR_SSN,14,1) >= 4) AND (SUBSTR(PROFESSOR_SSN,14,1) <=6) THEN '출강'
        ELSE '전임'
    END)PROFESSOR_LEVEL
, DEPARTMENT_NO
, CONCAT(PROFESSOR_NO,(SUBSTR(PROFESSOR_SSN,8,4)) )PROFESSOR_PWD

FROM TB_PROFESSOR
WHERE DEPARTMENT_NO IS NOT NULL
;

-- TABLE "CLASS"
--DESC CLASS;
INSERT ALL INTO CLASS VALUES
(CLASS_NO, CLASS_NAME, DEPARTMENT_NO)
SELECT
CLASS_NO, CLASS_NAME, DEPARTMENT_NO
FROM TB_CLASS
WHERE CLASS_NO IS NOT NULL
;

-- TABLE "PROFESSOR_CLASS"
--DESC PROFESSOR_CLASS;
INSERT ALL INTO PROFESSOR_CLASS VALUES (PROFESSOR_NO, CLASS_NO)
SELECT PROFESSOR_NO, CLASS_NO
FROM PROFESSOR JOIN CLASS USING (DEPARTMENT_NO)
;

-- TABLE "NOTICE"

-- TABLE "STUDENT"
--DESC STUDENT;
INSERT ALL INTO STUDENT VALUES (STUDENT_NO, STUDENT_NAME, STUDENT_PHONE, STUDENT_ADDRESS, DEPARTMENT_NO, STUDENT_PWD)
SELECT STUDENT_NO
, STUDENT_NAME
, CONCAT('010-',CONCAT((SUBSTR(STUDENT_SSN,1,4)),(SUBSTR(STUDENT_SSN,7,5)))) STUDENT_PHONE
, STUDENT_ADDRESS
, DEPARTMENT_NO
, CONCAT(STUDENT_NO,(SUBSTR(STUDENT_SSN,8,4)))STUDENT_PWD
FROM TB_STUDENT
WHERE SUBSTR(STUDENT_NO,1,1) LIKE 'A'
;

-- TABLE "STUDENT_CLASS"
--DESC PROFESSOR_CLASS;
INSERT ALL INTO STUDENT_CLASS VALUES (STUDENT_NO, CLASS_NO)
SELECT STUDENT_NO, CLASS_NO
FROM STUDENT JOIN CLASS USING (DEPARTMENT_NO)
;
--
--CREATE SEQUENCE NOTICE_SEQ
--START WITH 0
--INCREMENT BY 1
--NOCACHE;

--COMMIT;
--

CREATE SEQUENCE COMMENT_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE;

COMMIT;