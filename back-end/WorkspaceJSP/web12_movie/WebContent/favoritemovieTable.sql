CREATE TABLE favoritemovie(
    code NUMBER(10),
    title VARCHAR2(50),
    director VARCHAR2(30),
    actor VARCHAR2(50),
    price VARCHAR2(50),
    star NUMBER(10)
);

CREATE SEQUENCE favoritemovie_seq 
NOCACHE;

INSERT INTO favoritemovie 
VALUES(favoritemovie_seq.nextval,'스파이더맨','박준범','톰홀랜드','10000',9);
INSERT INTO favoritemovie 
VALUES(favoritemovie_seq.nextval,'슈퍼맨','박준범','슈퍼맨배우','20000',8.9);
INSERT INTO favoritemovie 
VALUES(favoritemovie_seq.nextval,'배트맨','박준범','배트맨배우','30000',9.6);

select * from favoritemovie;

COMMIT;