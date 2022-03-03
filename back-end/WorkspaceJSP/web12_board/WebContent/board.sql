create table board(
    num number(5) primary key,
    pass varchar2(30),
    name varchar2(30),
    email varchar2(30),
    title varchar2(50),
    content varchar2(1000),
    readCount number(4) default 0, -- 조회수
    writedate date default sysdate
);
create SEQUENCE board_seq
nocache; -- nocache를 적어줘야 시퀀스가 안 튄다. 1,2,3,10,11 이런 경우

insert into board
values(BOARD_SEQ.nextval,'1234','고길동','ko@naver.com','첫 방문','반갑습니다.', 0, sysdate);
insert into board
values(BOARD_SEQ.nextval,'1234','홍길동','hong@naver.com','흔적을 남기다','이젠 이건 제 겁니다',0, sysdate);
insert into board
values(BOARD_SEQ.nextval,'1234','고길동','ko@naver.com','두번째 방문','건강하시죠?',0, sysdate);
insert into board
values(BOARD_SEQ.nextval,'1234','박길동','park@naver.com','보험료 문의하셨죠?','평생을 함께하는XX보험사',0, sysdate);
insert into board (num,pass,name,email,title,content)
values(BOARD_SEQ.nextval,'1234','김길동','kim@naver.com','게시판 체크','췍췍');

commit;

select * from board;

create or replace PROCEDURE dummiData
is

begin
    for i in 1.. 935 loop
        insert into board (num,pass,name,email,title,content)
        values(BOARD_SEQ.nextval,'1234','name'||i,'name'||i||'@naver.com','title'||i,'content : '||i);
    end loop;
end;

EXECUTE dummiData;

commit;

SELECT * FROM board ORDER BY num DESC;