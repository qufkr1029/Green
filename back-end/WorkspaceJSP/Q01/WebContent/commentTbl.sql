CREATE TABLE POSTTBL(
    P_CODE NUMBER PRIMARY KEY
);

CREATE SEQUENCE POSTTBL_seq
NOCACHE;

INSERT INTO POSTTBL
VALUES(POSTTBL_seq.nextval);
INSERT INTO POSTTBL
VALUES(POSTTBL_seq.nextval);
INSERT INTO POSTTBL
VALUES(POSTTBL_seq.nextval);

SELECT * FROM POSTTBL;

CREATE TABLE commenttbl(
    C_code number PRIMARY KEY,
    B_code number NOT NULL,
    C_user varchar2(20) NOT NULL,
    C_Comment varchar2(1000) NOT NULL,
    C_Password varchar2(10) NOT NULL,
    C_regDate date NOT NULL,
    CONSTRAINT FK_COMMENTTBL FOREIGN KEY(B_CODE)
    REFERENCES POSTTBL(P_CODE)
);

SELECT * FROM COMMENTTBL;

CREATE SEQUENCE comment_seq
NOCACHE;

INSERT INTO commenttbl
VALUES(comment_seq.nextval, 1, '박준범', '댓글내용입니다', '1234', to_date(sysdate,'yyyy.mm.dd hh24:mi'));
INSERT INTO commenttbl
VALUES(comment_seq.nextval, 2, '박준범2', '댓글내용입니다2', '1234', to_date(sysdate,'yyyy.mm.dd hh24:mi'));
INSERT INTO commenttbl
VALUES(comment_seq.nextval, 3, '박준범3', '댓글내용입니다3', '1234', to_date(sysdate,'yyyy.mm.dd hh24:mi'));


SELECT *FROM COMMENTTBL;

COMMIT;