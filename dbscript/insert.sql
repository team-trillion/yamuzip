-- 관리자 계정 추가 (pwd 전부 1234로 통일)
INSERT INTO tbl_user (user_id, user_pwd, user_name, user_nickname, phone, auth, email)
VALUES ('admin', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '관리자', '관리자', '01012345678', 'ADMIN', 'admin@ohgiraffers.com');
-- 일반 계정 추가
INSERT INTO tbl_user (user_id, user_pwd, user_name, user_nickname, phone, auth, email)
VALUES ('user01', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '홍길동', '길동', '01087654321', 'DOBBY', 'user01@ohgiraffers.com');
INSERT INTO tbl_user (user_id, user_pwd, user_name, user_nickname, phone, email)
VALUES ('user02', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '유관순', '관순', '01065845651', 'user02@ohgiraffers.com');
INSERT INTO tbl_user (user_id, user_pwd, user_name, user_nickname, phone, email)
VALUES ('user03', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '신사임당', '사임당', '01064812354', 'user03@ohgiraffers.com');
INSERT INTO tbl_user (user_id, user_pwd, user_name, user_nickname, phone, auth, email)
VALUES ('user04', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '이순신', '순신', '01098765432', 'DOBBY', 'user04@ohgiraffers.com');
INSERT INTO tbl_user (user_id, user_pwd, user_name, user_nickname, phone, email)
VALUES ('user05', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '강감찬', '감찬', '01078901234', 'user05@ohgiraffers.com');
INSERT INTO tbl_user (user_id, user_pwd, user_name, user_nickname, phone, email)
VALUES ('user06', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '을지문덕', '문덕', '01012345678', 'user06@ohgiraffers.com');
INSERT INTO tbl_user (user_id, user_pwd, user_name, user_nickname, phone, email)
VALUES ('user07', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '이도범', '도범', '01023456789', 'user07@ohgiraffers.com');
INSERT INTO tbl_user (user_id, user_pwd, user_name, user_nickname, phone, auth, email)
VALUES ('user08', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '윤봉길', '봉길', '01034567890', 'DOBBY', 'user08@ohgiraffers.com');
INSERT INTO tbl_user (user_id, user_pwd, user_name, user_nickname, phone, email)
VALUES ('user09', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '안중근', '중근', '01045678901', 'user09@ohgiraffers.com');
INSERT INTO tbl_user (user_id, user_pwd, user_name, user_nickname, phone, email)
VALUES ('user10', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '김구', '구', '01056789012', 'user10@ohgiraffers.com');
INSERT INTO tbl_user (user_id, user_pwd, user_name, user_nickname, phone, auth, email)
VALUES ('user11', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '서태석', '태석', '01067890123', 'DOBBY', 'user11@ohgiraffers.com');
INSERT INTO tbl_user (user_id, user_pwd, user_name, user_nickname, phone, email)
VALUES ('user12', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '홍범도', '범도', '01078901234', 'user12@ohgiraffers.com');
INSERT INTO tbl_user (user_id, user_pwd, user_name, user_nickname, phone, email)
VALUES ('user13', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '안중근', '중근', '01089012345', 'user13@ohgiraffers.com');
INSERT INTO tbl_user (user_id, user_pwd, user_name, user_nickname, phone, email)
VALUES ('user14', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '이성계', '성계', '01001234567', 'user14@ohgiraffers.com');
INSERT INTO tbl_user (user_id, user_pwd, user_name, user_nickname, phone, email)
VALUES ('user15', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '이성계', '성계', '01001234567', 'user15@ohgiraffers.com');
INSERT INTO tbl_user (user_id, user_pwd, user_name, user_nickname, phone, auth, email)
VALUES ('user16', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '안경신', '경신', '01098765432', 'DOBBY', 'user16@ohgiraffers.com');
INSERT INTO tbl_user (user_id, user_pwd, user_name, user_nickname, phone, email)
VALUES ('user17', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '김원균', '원균', '01087654321', 'user17@ohgiraffers.com');
INSERT INTO tbl_user (user_id, user_pwd, user_name, user_nickname, phone, email)
VALUES ('user18', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '황희', '희', '01076543210', 'user18@ohgiraffers.com');
INSERT INTO tbl_user (user_id, user_pwd, user_name, user_nickname, phone, email)
VALUES ('user19', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '이이', '이', '01065432109', 'user19@ohgiraffers.com');
INSERT INTO tbl_user (user_id, user_pwd, user_name, user_nickname, phone, email)
VALUES ('user20', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '이황', '황', '01054321098', 'user20@ohgiraffers.com');
INSERT INTO tbl_user (user_id, user_pwd, user_name, user_nickname, phone, auth, email)
VALUES ('user21', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '장영실', '영실', '01043210987', 'DOBBY', 'user21@ohgiraffers.com');
INSERT INTO tbl_user (user_id, user_pwd, user_name, user_nickname, phone, auth, email)
VALUES ('user22', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '권율', '율', '01032109876', 'DOBBY', 'user22@ohgiraffers.com');
INSERT INTO tbl_user (user_id, user_pwd, user_name, user_nickname, phone, email)
VALUES ('user23', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '이봉구', '봉구', '01021098765', 'user23@ohgiraffers.com');
INSERT INTO tbl_user (user_id, user_pwd, user_name, user_nickname, phone, email)
VALUES ('user24', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '이봉창', '봉창', '01010987654', 'user24@ohgiraffers.com');
INSERT INTO tbl_user (user_id, user_pwd, user_name, user_nickname, phone, email)
VALUES ('user25', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '김시민', '시민', '01009876543', 'user25@ohgiraffers.com');
INSERT INTO tbl_user (user_id, user_pwd, user_name, user_nickname, phone, auth, email)
VALUES ('user26', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '홍길동', '길동', '01098765432', 'DOBBY', 'user26@ohgiraffers.com');
INSERT INTO tbl_user (user_id, user_pwd, user_name, user_nickname, phone, email)
VALUES ('user27', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '이순신', '순신', '01087654321', 'user27@ohgiraffers.com');
INSERT INTO tbl_user (user_id, user_pwd, user_name, user_nickname, phone, auth, email)
VALUES ('user28', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '강감찬', '감찬', '01076543210', 'DOBBY', 'user28@ohgiraffers.com');
INSERT INTO tbl_user (user_id, user_pwd, user_name, user_nickname, phone, email)
VALUES ('user29', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '이화림', '화림', '01012345678', 'user29@trillon.com');
INSERT INTO tbl_user (user_id, user_pwd, user_name, user_nickname, phone, email)
VALUES ('user30', '$2a$10$N34MRj4tKVD0AxwvEcC8eOLUyBpXloPKE7Yw.S4/kj5fD1OU5BWsi', '손용우', '용우', '01023456789', 'user30@trillon.com');


-- 카테고리 추가
INSERT INTO tbl_category (category_name)
VALUES ('청소'), ('수리'), ('이사'), ('설치'), ('인테리어');
INSERT INTO tbl_category (category_name, ref_category_code)
VALUES ('가구 청소', 1), ('가전제품 청소', 1), ('하수구 청소', 1),
       ('컴퓨터 수리', 2), ('가전제품 수리', 2),
       ('가정 이사', 3), ('원룸/소형 이사', 3), ('사무실 이사', 3),
       ('에어컨 설치', 4), ('난방기구 설치', 4),
       ('단열 시공', 5);

-- 도비 관련 정보 추가
INSERT INTO tbl_dobby (user_code, dob_nickname, dob_content, dob_area, dob_career_days)
VALUES (1, '홍청소', '청소왕 홍길동입니다.', '서울시 중구', '5년 이상');
INSERT INTO tbl_workday (day_week, dob_code)
VALUES (1, 1), (2, 1), (3, 1), (4, 1), (5, 1);
-- 일월화수목금토 0123456
INSERT INTO tbl_dob_career (category_code, dob_code)
VALUES (6, 1), (8, 1);

-- 서비스 추가
INSERT INTO tbl_service (dob_code, category_code, service_title, service_explain, service_content, service_price)
VALUES (1, 6, '원목 가구 청소', '원목 가구를 깨끗하게 청소해드립니다.', '서비스 상세설명', 80000);
INSERT INTO tbl_option (option_name, option_price, service_code)
VALUES ('가구 1개 추가', 60000, 1);
