DROP TABLE BOARD;

CREATE TABLE board(
    num NUMBER(5) PRIMARY KEY,
    pass VARCHAR2(30),
    name VARCHAR2(30),
    email VARCHAR2(30),
    title VARCHAR2(50),
    content VARCHAR2(2000),
    readcount NUMBER(4) DEFAULT 0,
    writedate DATE DEFAULT SYSDATE
);

CREATE SEQUENCE board_seq 
NOCACHE;

INSERT INTO board 
VALUES(board_seq.nextval,'1234','고길동','ko@naver.com','첫 방문','반갑습니다.',0,sysdate);
INSERT INTO board 
VALUES(board_seq.nextval,'1234','홍길동','hong@naver.com','흔적을 남기다.','이젠 이건 제겁니다.',0,sysdate);
INSERT INTO board 
VALUES(board_seq.nextval,'1234','고길동','ko@naver.com','두번째 방문','건강하시죠??',0,sysdate);
INSERT INTO board 
VALUES(board_seq.nextval,'1234','박길동','park@naver.com','보험료 문의하셨죠??','평생을 함께하는 OO보험사',0,sysdate);
INSERT INTO board (num,pass,name,email,title,content)
VALUES(board_seq.nextval,'1234','김길동','kim@naver.com','게시판 체크','췍췍췍췍췍!!!');
COMMIT;

SELECT * FROM board ORDER BY num DESC;

CREATE OR REPLACE PROCEDURE dummuData
IS
BEGIN
    FOR i in 1.. 935 LOOP
        INSERT INTO board (num,pass,name,email,title,content)
        VALUES(board_seq.nextval,'1234','name'||i,'name'||i||'@naver.com','title'||i,'content : '||i);
    END LOOP;
END;

EXECUTE dummuData;

COMMIT;

SELECT * FROM board ORDER BY num DESC;