CREATE TABLE IF NOT EXISTS `tbl_user`
(
    `user_code`    INT NOT NULL AUTO_INCREMENT COMMENT '회원번호',
    `user_id`    VARCHAR(255) NOT NULL COMMENT '아이디',
    `user_pwd`    VARCHAR(255) NOT NULL COMMENT '비밀번호',
    `user_name`    VARCHAR(255) NOT NULL COMMENT '이름',
    `user_nickname`    VARCHAR(255) COMMENT '닉네임',
    `phone`    VARCHAR(255) NOT NULL COMMENT '전화번호',
    `regist_datetime`    DATETIME NOT NULL DEFAULT NOW() COMMENT '가입일자',
    `quit_datetime`    DATETIME COMMENT '탈퇴일자',
    `user_status`    CHAR(1) NOT NULL DEFAULT 'A' COMMENT '회원상태',
    `unban`    DATETIME COMMENT '정지해제일',
    `user_img`    VARCHAR(255) COMMENT '회원 프로필 이미지',
    `auth`    ENUM('GENERAL', 'DOBBY', 'ADMIN') DEFAULT 'GENERAL' NOT NULL COMMENT '권한',
    `email`    VARCHAR(255) NOT NULL COMMENT '이메일',
    PRIMARY KEY ( `user_code` )
    ) ENGINE=INNODB COMMENT = '회원';


CREATE TABLE IF NOT EXISTS `tbl_category`
(
    `category_code`    INT NOT NULL AUTO_INCREMENT COMMENT '카테고리번호',
    `category_name`    VARCHAR(255) NOT NULL COMMENT '카테고리이름',
    `ref_category_code`    INT COMMENT '상위카테고리번호',
    PRIMARY KEY ( `category_code` ),
    FOREIGN KEY (`ref_category_code`) REFERENCES tbl_category(`category_code`)
    ) ENGINE=INNODB COMMENT = '카테고리';


CREATE TABLE IF NOT EXISTS `tbl_dobby`
(
    `dob_code`    INT NOT NULL AUTO_INCREMENT COMMENT '도비번호',
    `user_code`    INT NOT NULL COMMENT '회원번호',
    `dob_nickname`    VARCHAR(255) NOT NULL COMMENT '도비닉네임',
    `dob_img`    VARCHAR(255) COMMENT '도비프로필이미지',
    `dob_content`    VARCHAR(255) NOT NULL COMMENT '도비소개',
    `dob_area`    VARCHAR(255) NOT NULL COMMENT '지역',
    `dob_career_days`    VARCHAR(255) NOT NULL COMMENT '경력기간',
    PRIMARY KEY ( `dob_code` ),
    FOREIGN KEY (`user_code`) REFERENCES tbl_user(`user_code`)
    ) ENGINE=INNODB COMMENT = '도비';



CREATE TABLE IF NOT EXISTS `tbl_service`
(
    `service_code`    INT NOT NULL AUTO_INCREMENT COMMENT '서비스번호',
    `dob_code`    INT NOT NULL COMMENT '도비번호',
    `category_code`    INT NOT NULL COMMENT '카테고리번호',
    `service_title`    VARCHAR(255) NOT NULL COMMENT '제목',
    `service_explain`    VARCHAR(255) NOT NULL COMMENT '서비스소개',
    `service_content`    MEDIUMTEXT NOT NULL COMMENT '서비스본문',
    `service_price`    INT NOT NULL COMMENT '서비스가격',
    `service_status`    CHAR(1) NOT NULL DEFAULT 'A' COMMENT '서비스상태',
    `service_created`    DATETIME NOT NULL DEFAULT NOW() COMMENT '등록일자',
    PRIMARY KEY ( `service_code` ),
    FOREIGN KEY (dob_code) REFERENCES tbl_dobby(dob_code),
    FOREIGN KEY (category_code) REFERENCES tbl_category(category_code)
    ) ENGINE=INNODB COMMENT = '서비스';




CREATE TABLE IF NOT EXISTS `tbl_cs`
(
    `cs_code`    INT NOT NULL AUTO_INCREMENT COMMENT '문의번호',
    `section`    CHAR(1) NOT NULL COMMENT '구분',
    `writer_user_code`    INT NOT NULL COMMENT '작성자',
    `cs_created`    DATETIME NOT NULL DEFAULT NOW() COMMENT '등록일자',
    `cs_status`    CHAR(1) NOT NULL DEFAULT 'A' COMMENT '문의상태',
    `cs_type`    VARCHAR(255) NOT NULL COMMENT '문의유형',
    `cs_secret`    CHAR(1) NOT NULL DEFAULT 'N' COMMENT '비밀글여부',
    `cs_modify`    DATETIME COMMENT '수정일자',
    `cs_title`    VARCHAR(255) NOT NULL COMMENT '제목',
    `cs_content`    MEDIUMTEXT NOT NULL COMMENT '내용',
    `service_code`    INT COMMENT '서비스번호',
    PRIMARY KEY ( `cs_code` ),
    FOREIGN KEY (writer_user_code) REFERENCES tbl_user(user_code),
    FOREIGN KEY (service_code) REFERENCES tbl_service(service_code)
    ) ENGINE=INNODB COMMENT = '문의';


CREATE TABLE IF NOT EXISTS `tbl_cs_rep`
(
    `cs_rep_code`    INT NOT NULL AUTO_INCREMENT COMMENT '답변번호',
    `cs_rep_content`    MEDIUMTEXT NOT NULL COMMENT '답변내용',
    `cs_rep_created`    DATETIME NOT NULL DEFAULT NOW() COMMENT '답변작성일자',
    `cs_rep_status`    CHAR(1) NOT NULL DEFAULT 'A' COMMENT '답변상태',
    `cs_code`    INT NOT NULL COMMENT '문의번호',
    `writer_user_code`    INT NOT NULL COMMENT '작성자',
    `cs_rep_modify`    DATETIME COMMENT '수정일자',
    PRIMARY KEY ( `cs_rep_code` ),
    FOREIGN KEY (writer_user_code) REFERENCES tbl_user(user_code),
    FOREIGN KEY (cs_code) REFERENCES tbl_cs(cs_code)
    ) ENGINE=INNODB COMMENT = '문의답변';



CREATE TABLE IF NOT EXISTS `tbl_dob_apply`
(
    `apply_code`    INT NOT NULL AUTO_INCREMENT COMMENT '신청번호',
    `user_code`    INT NOT NULL COMMENT '회원번호',
    `apply_status`    CHAR(1) NOT NULL DEFAULT 'C' COMMENT '처리상태',
    `apply_datetime`    DATETIME NOT NULL DEFAULT NOW() COMMENT '신청일자',
    `apply_done`    DATETIME COMMENT '처리일자',
    `apply_reject_reason`    VARCHAR(255) COMMENT '반려사유',
    `apply_career`    VARCHAR(255) NOT NULL COMMENT '전문분야',
    PRIMARY KEY ( `apply_code` ),
    FOREIGN KEY (user_code) REFERENCES tbl_user(user_code)
    ) ENGINE=INNODB COMMENT = '신규도비신청';


CREATE TABLE IF NOT EXISTS `tbl_dob_career`
(
    `category_code`    INT NOT NULL COMMENT '카테고리번호',
    `dob_code`    INT NOT NULL COMMENT '도비번호',
    PRIMARY KEY ( `dob_code`,`category_code` ),
    FOREIGN KEY (dob_code) REFERENCES tbl_dobby(dob_code),
    FOREIGN KEY (category_code) REFERENCES tbl_category(category_code)
    ) ENGINE=INNODB COMMENT = '도비전문분야';



CREATE TABLE IF NOT EXISTS `tbl_notice`
(
    `notice_code`    INT NOT NULL AUTO_INCREMENT COMMENT '공지사항 번호',
    `notice_content`    MEDIUMTEXT NOT NULL COMMENT '공지사항 내용',
    `notice_created`    DATETIME NOT NULL DEFAULT NOW() COMMENT '작성일자',
    `notice_hits`    INT NOT NULL DEFAULT 0 COMMENT '조회수',
    `notice_title`    VARCHAR(255) NOT NULL COMMENT '제목',
    `notice_fixed`    CHAR(1) NOT NULL DEFAULT 'N' COMMENT '고정여부',
    `notice_status`    CHAR(1) NOT NULL DEFAULT 'A' COMMENT '공지사항 상태',
    `writer_user_code`    INT NOT NULL COMMENT '작성자',
    `notice_modify`    DATETIME COMMENT '수정일자',
    PRIMARY KEY ( `notice_code` ),
    FOREIGN KEY (writer_user_code) REFERENCES tbl_user(user_code)
    ) ENGINE=INNODB COMMENT = '공지사항';



CREATE TABLE IF NOT EXISTS `tbl_option`
(
    `option_code`    INT NOT NULL AUTO_INCREMENT COMMENT '옵션번호',
    `option_name`    VARCHAR(255) NOT NULL COMMENT '옵션명',
    `option_price`    INT NOT NULL COMMENT '가격',
    `service_code`    INT NOT NULL COMMENT '서비스번호',
    PRIMARY KEY ( `option_code` ),
    FOREIGN KEY (service_code) REFERENCES tbl_service(service_code)
    ) ENGINE=INNODB COMMENT = '옵션';



CREATE TABLE IF NOT EXISTS `tbl_order`
(
    `order_code`    INT NOT NULL AUTO_INCREMENT COMMENT '주문번호',
    `service_code`    INT NOT NULL COMMENT '서비스번호',
    `user_code`    INT NOT NULL COMMENT '회원번호',
    `order_datetime`    DATETIME NOT NULL DEFAULT NOW() COMMENT '주문일자',
    `order_status`    CHAR(1) NOT NULL DEFAULT 'O' COMMENT '주문상태',
    `total_price`    INT NOT NULL COMMENT '결제금액',
    `reserve_datetime`    DATETIME NOT NULL COMMENT '서비스진행일자',
    `option_code`    INT COMMENT '주문옵션',
    `approval_datetime`    DATETIME COMMENT '승인일',
    `cancel_datetime`    DATETIME COMMENT '취소일',
    `reject_datetime`    DATETIME COMMENT '반려일',
    `cancel_reason`    VARCHAR(255) COMMENT '취소사유',
    `reject_reason`    VARCHAR(255) COMMENT '예약불가사유',
    PRIMARY KEY ( `order_code` ),
    FOREIGN KEY (service_code) REFERENCES tbl_service(service_code),
    FOREIGN KEY (user_code) REFERENCES tbl_user(user_code),
    FOREIGN KEY (option_code) REFERENCES tbl_option(option_code)
    ) ENGINE=INNODB COMMENT = '주문';



CREATE TABLE IF NOT EXISTS `tbl_payment`
(
    `pay_code`    INT NOT NULL AUTO_INCREMENT COMMENT '결제번호',
    `order_code`    INT NOT NULL COMMENT '주문번호',
    `pay_price`    INT NOT NULL COMMENT '결제금액',
    `pay_type`    VARCHAR(255) NOT NULL COMMENT '결제방법',
    `pay_status`    VARCHAR(255) NOT NULL COMMENT '결제상태',
    `pay_datetime`    DATETIME NOT NULL DEFAULT NOW() COMMENT '결제시간',
    `refund_datetime`    DATETIME COMMENT '환불시간',
    PRIMARY KEY ( `pay_code` ),
    FOREIGN KEY (order_code) REFERENCES tbl_order(order_code)
    ) ENGINE=INNODB COMMENT = '결제';




CREATE TABLE IF NOT EXISTS `tbl_account`
(
    `acc_code`    INT NOT NULL AUTO_INCREMENT COMMENT '계좌코드',
    `acc_number`    VARCHAR(255) NOT NULL COMMENT '계좌번호',
    `acc_bank`    VARCHAR(255) NOT NULL COMMENT '은행명',
    `acc_name`    VARCHAR(255) NOT NULL COMMENT '예금주',
    `acc_status`    CHAR(1) NOT NULL DEFAULT 'A' COMMENT '상태',
    `dob_code`    INT NOT NULL COMMENT '도비번호',
    PRIMARY KEY ( `acc_code` ),
    FOREIGN KEY (dob_code) REFERENCES tbl_dobby(dob_code)
    ) ENGINE=INNODB COMMENT = '계좌정보';




CREATE TABLE IF NOT EXISTS `tbl_calculate`
(
    `cal_code`    INT NOT NULL AUTO_INCREMENT COMMENT '정산번호',
    `dob_code`    INT NOT NULL COMMENT '도비번호',
    `acc_code`    INT NOT NULL COMMENT '계좌코드',
    `cal_datetime`    DATETIME NOT NULL DEFAULT NOW() COMMENT '정산일자',
    `cal_price`    INT NOT NULL COMMENT '결제금액',
    `specs_img`    VARCHAR(255) COMMENT '명세서',
    PRIMARY KEY ( `cal_code` ),
    FOREIGN KEY (dob_code) REFERENCES tbl_dobby(dob_code),
    FOREIGN KEY (acc_code) REFERENCES tbl_account(acc_code)
    ) ENGINE=INNODB COMMENT = '정산이력';



CREATE TABLE IF NOT EXISTS `tbl_calc_fin`
(
    `pay_code`    INT NOT NULL COMMENT '결제번호',
    `cal_code`    INT NOT NULL COMMENT '정산번호',
    PRIMARY KEY ( `pay_code`,`cal_code` ),
    FOREIGN KEY (pay_code) REFERENCES tbl_payment(pay_code),
    FOREIGN KEY (cal_code) REFERENCES tbl_calculate(cal_code)
    ) ENGINE=INNODB COMMENT = '정산결제내역';



CREATE TABLE IF NOT EXISTS `tbl_review`
(
    `review_code`    INT NOT NULL AUTO_INCREMENT COMMENT '리뷰번호',
    `order_code`    INT NOT NULL COMMENT '주문번호',
    `writer_user_code`    INT NOT NULL COMMENT '작성자',
    `review_grade`    FLOAT NOT NULL COMMENT '별점',
    `review_created`    DATETIME NOT NULL DEFAULT NOW() COMMENT '등록일자',
    `review_status`    CHAR(1) NOT NULL DEFAULT 'A' COMMENT '리뷰상태',
    `review_modify`    DATETIME COMMENT '수정일자',
    PRIMARY KEY ( `review_code` ),
    FOREIGN KEY (writer_user_code) REFERENCES tbl_user(user_code),
    FOREIGN KEY (order_code) REFERENCES tbl_order(order_code)
    ) ENGINE=INNODB COMMENT = '리뷰';



CREATE TABLE IF NOT EXISTS `tbl_wish`
(
    `wish_code` INT NOT NULL AUTO_INCREMENT COMMENT '찜번호',
    `user_code`    INT NOT NULL COMMENT '회원번호',
    `service_code`    INT NOT NULL COMMENT '서비스번호',
    PRIMARY KEY ( `wish_code` ),
    FOREIGN KEY (user_code) REFERENCES tbl_user(user_code),
    FOREIGN KEY (service_code) REFERENCES tbl_service(service_code)
    ) ENGINE=INNODB COMMENT = '찜';



CREATE TABLE IF NOT EXISTS `tbl_workday`
(
    `day_week`    INT NOT NULL COMMENT '요일',
    `dob_code`    INT NOT NULL COMMENT '도비번호',
    PRIMARY KEY ( `day_week`,`dob_code` ),
    FOREIGN KEY (dob_code) REFERENCES tbl_dobby(dob_code)
    ) ENGINE=INNODB COMMENT = '영업일정';


CREATE TABLE IF NOT EXISTS `tbl_img`
(
    `img_code`    INT NOT NULL AUTO_INCREMENT COMMENT '이미지번호',
    `img_url`    VARCHAR(255) NOT NULL COMMENT '이미지경로',
    `img_origin_name`    VARCHAR(255) NOT NULL COMMENT '이미지원본명',
    `img_name`    VARCHAR(255) NOT NULL COMMENT '이미지이름',
    `section`    CHAR(1) NOT NULL COMMENT '게시판구분',
    `notice_code`    INT COMMENT '공지사항 번호',
    `service_code`    INT COMMENT '서비스번호',
    `review_code`    INT COMMENT '리뷰번호',
    `cs_code`    INT COMMENT '문의번호',
    PRIMARY KEY ( `img_code` ),
    FOREIGN KEY (notice_code) REFERENCES tbl_notice(notice_code),
    FOREIGN KEY (service_code) REFERENCES tbl_service(service_code),
    FOREIGN KEY (review_code) REFERENCES tbl_review(review_code),
    FOREIGN KEY (cs_code) REFERENCES tbl_cs(cs_code)
    ) ENGINE=INNODB COMMENT = '이미지';

ALTER TABLE tbl_service
    ADD COLUMN thumbnail_url VARCHAR(255) DEFAULT NULL;
ALTER TABLE tbl_review
    ADD COLUMN review_content mediumtext NOT NULL;