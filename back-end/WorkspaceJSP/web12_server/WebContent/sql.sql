create table lecturer_tbl(
    idx number(6) primary key, -- 번호
    name VARCHAR2(10),         -- 강사명
    major varchar2(30),        -- 전공
    field varchar2(30)         -- 연구분야
);

DROP TABLE lecturer_tbl;

select * from lecturer_tbl;

create SEQUENCE lecturer_tbl_seq
NOCACHE;

INSERT INTO lecturer_tbl
VALUES (lecturer_tbl_seq.nextval, '김교수', '소프트웨어 공학', '알고리즘');
INSERT INTO lecturer_tbl
VALUES (lecturer_tbl_seq.nextval, '이교수', '소프트웨어 공학', '인공지능');
INSERT INTO lecturer_tbl
VALUES (lecturer_tbl_seq.nextval, '박교수', '소프트웨어 공학', '소프트웨어 공학');
INSERT INTO lecturer_tbl
VALUES (lecturer_tbl_seq.nextval, '오교수', '소프트웨어 공학', '알고리즘');
INSERT INTO lecturer_tbl
VALUES (lecturer_tbl_seq.nextval, '최교수', '응용컴퓨터 공학', '임베디드 시스템');
INSERT INTO lecturer_tbl
VALUES (lecturer_tbl_seq.nextval, '강교수', '응용컴퓨터 공학', '멀티미디어');
INSERT INTO lecturer_tbl
VALUES (lecturer_tbl_seq.nextval, '황교수', '모바일 시스템 공학', '네트워크');
INSERT INTO lecturer_tbl  -- 샘플에서 더 추가해본 것
VALUES (lecturer_tbl_seq.nextval, '팽교수', '팽팽이 공학', '팽팽리즘');



create table course_tbl(
    id VARCHAR2(5) primary key, -- 교과목 아이디
    name VARCHAR2(40),          -- 교과목 이름
    credit NUMBER(6),           -- 학점
    lecturer NUMBER(6),         -- 강사
    week number(2),             -- 요일
    start_hour number(4),       -- 시작시간
    end_hour number(4)          -- 종료시간
);

DROP TABLE course_tbl;

select * from course_tbl;

INSERT INTO course_tbl
VALUES('10001', '프로그래밍', 2, 1, 1, 0900, 1100);
INSERT INTO course_tbl
VALUES('10002', '객체지향 프로그래밍', 2, 2, 2, 0900, 1200);
INSERT INTO course_tbl
VALUES('10003', '자료구조', 3, 4, 3, 0900, 1200);
INSERT INTO course_tbl
VALUES('10004', '알고리즘', 3, 4, 4, 0900, 1200);
INSERT INTO course_tbl
VALUES('20001', '시스템 프로그래밍', 2, 5, 1, 1300, 1600);
INSERT INTO course_tbl
VALUES('20002', '운영체제', 3, 5, 2, 1500, 1800);
INSERT INTO course_tbl
VALUES('20003', '오토마타와 컴파일러', 3, 5, 3, 1330, 1630);
INSERT INTO course_tbl
VALUES('30001', '소프트웨어 공학', 2, 3, 4, 1300, 1530);
INSERT INTO course_tbl
VALUES('30002', '시스템 분석 및 설계', 3, 3, 5, 0900, 1200);
INSERT INTO course_tbl
VALUES('40001', '데이터베이스', 3, 2, 5, 1300, 1600);

ALTER TABLE course_tbl
ADD CONSTRAINTS fk_course_tbl FOREIGN KEY (lecturer) 
REFERENCES lecturer_tbl(idx);

commit;

-- 2개의 테이블을 조인하여서 조회하는 sql문
select c.id, c.name, c.credit, l.name as l_name, c.week
from course_tbl c, lecturer_tbl l
where c.lecturer = l.idx
order by c.id asc;

select id, c.name, credit, l.name as l_name, week from course_tbl c, lecturer_tbl l where lecturer = idx order by id asc;

-- 몇개의 데이터가 조회되는지 조회하는 sql문
select count(*) cnt from course_tbl;

select id, c.name, credit, l.name as l_name, week from course_tbl c, lecturer_tbl l where lecturer = idx order by id asc
select count(*) 
from
(select c.id, c.name, c.credit, l.name, c.week
from course_tbl c, lecturer_tbl l
where c.lecturer = l.idx
order by c.id asc);


-- selectCourseByID sql문
select c.id, c.name, l.name as l_name, c.credit, c.week, c.start_hour, c.end_hour
from course_tbl c, lecturer_tbl l
where (c.lecturer = l.idx and id = '10001');


select * from course_tbl;
select * from lecturer_tbl;