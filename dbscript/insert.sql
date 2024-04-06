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
INSERT INTO yamuzip.tbl_service (service_code, dob_code, category_code, service_title, service_explain, service_content, service_price, service_status, service_created, thumbnail_url) VALUES (1, 1, 1, '원목 가구 청소', '원목 가구를 깨끗하게 청소해드립니다.', '우리의 청소 서비스는 고객의 요구와 예산에 맞춰 다양한 옵션을 제공합니다. 가정, 사무실, 상업 공간 등 어떤 종류의 청소에도 대응할 수 있습니다.
사용하는 모든 청소용품은 환경에 무해하고 안전하며, 청소 후에도 친환경적입니다. 이는 우리의 서비스가 고객의 건강과 환경을 중요시한다는 것을 보여줍니다.
우리의 전문적인 청소 인력은 청결과 위생에 중점을 두며, 각종 오염물질과 세균을 효과적으로 제거하여 안전하고 편안한 환경을 제공합니다.
청소 일정은 고객의 편의에 맞춰 유연하게 조정될 수 있으며, 필요에 따라 주기적으로 예약할 수 있는 옵션도 제공됩니다.
저희의 청소 서비스는 신속하고 효율적인 작업을 통해 고객의 시간과 비용을 절약하고, 항상 최상의 결과물을 보장합니다.', 80000, 'A', '2024-03-22 10:42:05', 'https://cdn.pixabay.com/photo/2014/06/04/16/36/man-362150_1280.jpg');
INSERT INTO yamuzip.tbl_service (service_code, dob_code, category_code, service_title, service_explain, service_content, service_price, service_status, service_created, thumbnail_url) VALUES (2, 1, 3, '정교 이사 최고의 포장재', '최고의 포장재와 정교한 조립으로 무결점 이사 보장.', '저희 이사 서비스는 고객들이 부담 없이 새로운 집으로 안전하고 원활하게 옮길 수 있도록 전문적으로 지원합니다. 이사 전문가들은 고객의 요구에 맞춰 철저한 계획을 세우고, 포장, 운반, 해체, 조립 등의 모든 과정을 신속하고 안전하게 진행합니다.
보관 서비스 또한 제공하여 이사 일정이 맞지 않거나 일시적으로 집을 비워야 할 때 고객의 물품을 안전하게 보관해드립니다. 보관 시설은 철저한 보안 시스템으로 지켜지며 필요 시 언제든지 접근 가능합니다.
우리 서비스는 개인 고객부터 기업 고객까지 다양한 Bed and Breakfast, 에어비앤비 및 숙박 시설 등에 이사 서비스를 제공합니다. 각종 규모와 형태의 이사에 대해 완벽한 솔루션을 제공합니다.
고객의 편의를 위해 이사 전 과정을 철저하게 관리하고, 문제가 발생할 경우 신속하고 적극적으로 대처하여 최상의 서비스를 제공합니다.
전문성, 안전성, 신속성을 바탕으로 우수한 이사 서비스를 제공하여 고객의 만족도를 최우선으로 합니다.', 70000, 'A', '2024-03-26 18:10:41', 'https://cdn.pixabay.com/photo/2015/07/28/20/55/tools-864983_1280.jpg');
INSERT INTO yamuzip.tbl_service (service_code, dob_code, category_code, service_title, service_explain, service_content, service_price, service_status, service_created, thumbnail_url) VALUES (3, 4, 3, '여름에 에어컨 설치 하셔야죠.', '시원한 에어컨 설치 다 맡기세요.', '1:1 솔루션 제공으로 어떠한 현장이든 컨디션에 맞는 완벽한 설계를 제공해드리고 있습니다.

1:1 솔루션 / 1:1 사후 관리를 진행하여 처음부터 끝까지 관리해드리고 있습니다.', 1000, 'A', '2024-03-26 18:10:43', 'https://cdn.pixabay.com/photo/2023/12/12/15/47/welding-8445458_1280.jpg');
INSERT INTO yamuzip.tbl_service (service_code, dob_code, category_code, service_title, service_explain, service_content, service_price, service_status, service_created, thumbnail_url) VALUES (4, 6, 2, '가전제품 다 맡겨', '가전제품, 배관, 전기 시스템 등 모든 종류의 수리를 신속하고 신뢰할 수 있는 서비스로 처리합니다.', '우리의 수리 서비스는 전문 기술자들로 구성된 팀이 고객의 가정 및 사무실의 모든 종류의 수리 및 유지 보수 작업을 담당합니다.
가전제품, 배관, 전기 시스템, 난방 및 냉난방 시스템 등 다양한 분야의 수리를 전문적으로 수행할 수 있습니다.
긴급한 수리가 필요한 상황에는 신속하고 적극적으로 대응하여 고객의 안전과 편의를 최우선으로 합니다.
고객의 요구에 따라 수리에 사용되는 모든 부품과 장비는 최고 품질의 것들을 선택하며, 항상 최신 기술과 도구를 사용합니다.
우리의 수리 서비스는 고객의 만족도를 최우선으로 하며, 항상 신속하고 친절한 서비스를 제공하여 고객들의 믿음을 얻고 있습니다.





', 70000, 'A', '2024-03-26 18:10:45', 'https://cdn.pixabay.com/photo/2015/12/07/10/55/electric-1080584_1280.jpg');
INSERT INTO yamuzip.tbl_service (service_code, dob_code, category_code, service_title, service_explain, service_content, service_price, service_status, service_created, thumbnail_url) VALUES (5, 7, 1, '사무실 청소 도비 깔끔', '효율적이고 신속한 일정으로 가정 및 사무실을 청소하는 편리한 서비스.', '우리의 청소 서비스는 고객의 요구와 예산에 맞춰 다양한 옵션을 제공합니다. 가정, 사무실, 상업 공간 등 어떤 종류의 청소에도 대응할 수 있습니다.
사용하는 모든 청소용품은 환경에 무해하고 안전하며, 청소 후에도 친환경적입니다. 이는 우리의 서비스가 고객의 건강과 환경을 중요시한다는 것을 보여줍니다.
우리의 전문적인 청소 인력은 청결과 위생에 중점을 두며, 각종 오염물질과 세균을 효과적으로 제거하여 안전하고 편안한 환경을 제공합니다.
청소 일정은 고객의 편의에 맞춰 유연하게 조정될 수 있으며, 필요에 따라 주기적으로 예약할 수 있는 옵션도 제공됩니다.
저희의 청소 서비스는 신속하고 효율적인 작업을 통해 고객의 시간과 비용을 절약하고, 항상 최상의 결과물을 보장합니다.', 1000, 'A', '2024-03-26 19:27:40', 'https://cdn.pixabay.com/photo/2016/07/10/19/19/the-interior-of-the-1508273_1280.jpg');
INSERT INTO yamuzip.tbl_service (service_code, dob_code, category_code, service_title, service_explain, service_content, service_price, service_status, service_created, thumbnail_url) VALUES (12, 8, 1, '친환경 청소 들어보셨나요', '환경 친화적이고 안전한 청소제를 사용하여 건강한 실내 환경을 제공하는 청소 서비스.', '우리의 청소 서비스는 고객의 요구와 예산에 맞춰 다양한 옵션을 제공합니다. 가정, 사무실, 상업 공간 등 어떤 종류의 청소에도 대응할 수 있습니다.
사용하는 모든 청소용품은 환경에 무해하고 안전하며, 청소 후에도 친환경적입니다. 이는 우리의 서비스가 고객의 건강과 환경을 중요시한다는 것을 보여줍니다.
우리의 전문적인 청소 인력은 청결과 위생에 중점을 두며, 각종 오염물질과 세균을 효과적으로 제거하여 안전하고 편안한 환경을 제공합니다.
청소 일정은 고객의 편의에 맞춰 유연하게 조정될 수 있으며, 필요에 따라 주기적으로 예약할 수 있는 옵션도 제공됩니다.
저희의 청소 서비스는 신속하고 효율적인 작업을 통해 고객의 시간과 비용을 절약하고, 항상 최상의 결과물을 보장합니다.', 500000, 'A', '2024-03-29 16:45:34', 'https://cdn.pixabay.com/photo/2014/06/04/16/36/man-362150_1280.jpg');
INSERT INTO yamuzip.tbl_service (service_code, dob_code, category_code, service_title, service_explain, service_content, service_price, service_status, service_created, thumbnail_url) VALUES (13, 9, 3, '완벽한 이사 완벽한 하루', '안전한 보관 시설과 신속한 배송으로 완벽한 이사 경험을 선사합니다.', '저희 이사 서비스는 고객들이 부담 없이 새로운 집으로 안전하고 원활하게 옮길 수 있도록 전문적으로 지원합니다. 이사 전문가들은 고객의 요구에 맞춰 철저한 계획을 세우고, 포장, 운반, 해체, 조립 등의 모든 과정을 신속하고 안전하게 진행합니다.
보관 서비스 또한 제공하여 이사 일정이 맞지 않거나 일시적으로 집을 비워야 할 때 고객의 물품을 안전하게 보관해드립니다. 보관 시설은 철저한 보안 시스템으로 지켜지며 필요 시 언제든지 접근 가능합니다.
우리 서비스는 개인 고객부터 기업 고객까지 다양한 Bed and Breakfast, 에어비앤비 및 숙박 시설 등에 이사 서비스를 제공합니다. 각종 규모와 형태의 이사에 대해 완벽한 솔루션을 제공합니다.
고객의 편의를 위해 이사 전 과정을 철저하게 관리하고, 문제가 발생할 경우 신속하고 적극적으로 대처하여 최상의 서비스를 제공합니다.
전문성, 안전성, 신속성을 바탕으로 우수한 이사 서비스를 제공하여 고객의 만족도를 최우선으로 합니다.', 80000, 'A', '2024-03-29 16:45:34', 'https://cdn.pixabay.com/photo/2015/07/28/20/55/tools-864983_1280.jpg');
INSERT INTO yamuzip.tbl_service (service_code, dob_code, category_code, service_title, service_explain, service_content, service_price, service_status, service_created, thumbnail_url) VALUES (14, 10, 2, '고오급 부품 수우리', '고품질 부품 및 최신 도구를 사용하여 지속적인 성능과 안전을 보장하는 수리 서비스를 제공합니다.', '우리의 수리 서비스는 전문 기술자들로 구성된 팀이 고객의 가정 및 사무실의 모든 종류의 수리 및 유지 보수 작업을 담당합니다.
가전제품, 배관, 전기 시스템, 난방 및 냉난방 시스템 등 다양한 분야의 수리를 전문적으로 수행할 수 있습니다.
긴급한 수리가 필요한 상황에는 신속하고 적극적으로 대응하여 고객의 안전과 편의를 최우선으로 합니다.
고객의 요구에 따라 수리에 사용되는 모든 부품과 장비는 최고 품질의 것들을 선택하며, 항상 최신 기술과 도구를 사용합니다.
우리의 수리 서비스는 고객의 만족도를 최우선으로 하며, 항상 신속하고 친절한 서비스를 제공하여 고객들의 믿음을 얻고 있습니다.





', 350000, 'A', '2024-03-29 16:45:34', 'https://cdn.pixabay.com/photo/2015/12/07/10/55/electric-1080584_1280.jpg');
INSERT INTO yamuzip.tbl_service (service_code, dob_code, category_code, service_title, service_explain, service_content, service_price, service_status, service_created, thumbnail_url) VALUES (15, 11, 2, '기인급 수리 수리', '긴급 수리가 필요한 상황에 신속히 대응하여 고객의 편의를 최우선으로 하는 전문 서비스.', '우리의 수리 서비스는 전문 기술자들로 구성된 팀이 고객의 가정 및 사무실의 모든 종류의 수리 및 유지 보수 작업을 담당합니다.
가전제품, 배관, 전기 시스템, 난방 및 냉난방 시스템 등 다양한 분야의 수리를 전문적으로 수행할 수 있습니다.
긴급한 수리가 필요한 상황에는 신속하고 적극적으로 대응하여 고객의 안전과 편의를 최우선으로 합니다.
고객의 요구에 따라 수리에 사용되는 모든 부품과 장비는 최고 품질의 것들을 선택하며, 항상 최신 기술과 도구를 사용합니다.
우리의 수리 서비스는 고객의 만족도를 최우선으로 하며, 항상 신속하고 친절한 서비스를 제공하여 고객들의 믿음을 얻고 있습니다.





', 1000000, 'A', '2024-03-29 16:45:34', 'https://cdn.pixabay.com/photo/2015/07/28/20/55/tools-864983_1280.jpg');
INSERT INTO yamuzip.tbl_service (service_code, dob_code, category_code, service_title, service_explain, service_content, service_price, service_status, service_created, thumbnail_url) VALUES (16, 11, 5, '인테리어도 합니다 오세요', '인테리어가 필요하십니까?', '1:1 솔루션 제공으로 어떠한 현장이든 컨디션에 맞는 완벽한 설계를 제공해드리고 있습니다.

1:1 솔루션 / 1:1 사후 관리를 진행하여 처음부터 끝까지 관리해드리고 있습니다.', 300000, 'A', '2024-03-29 16:45:34', 'https://cdn.pixabay.com/photo/2015/12/07/10/55/electric-1080584_1280.jpg');

