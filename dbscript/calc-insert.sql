-- tbl_account
INSERT INTO yamuzip.tbl_account (acc_code, acc_number, acc_bank, acc_name, acc_status, dob_code) VALUES (1, '110-111-111222', '자바', '안경신', 'A', 7);
INSERT INTO yamuzip.tbl_account (acc_code, acc_number, acc_bank, acc_name, acc_status, dob_code) VALUES (2, '200-100-310400', '자바', '강감찬', 'A', 11);
INSERT INTO yamuzip.tbl_account (acc_code, acc_number, acc_bank, acc_name, acc_status, dob_code) VALUES (3, '300-10919-2039', '으리', '신사임당', 'A', 4);
INSERT INTO yamuzip.tbl_account (acc_code, acc_number, acc_bank, acc_name, acc_status, dob_code) VALUES (4, '299-800-080819', '시난', '이순신', 'A', 5);
INSERT INTO yamuzip.tbl_account (acc_code, acc_number, acc_bank, acc_name, acc_status, dob_code) VALUES (5, '234-123-135113', '시난', '서태석', 'A', 6);
INSERT INTO yamuzip.tbl_account (acc_code, acc_number, acc_bank, acc_name, acc_status, dob_code) VALUES (6, '123-124-236422', '자바', '권율', 'A', 9);
INSERT INTO yamuzip.tbl_account (acc_code, acc_number, acc_bank, acc_name, acc_status, dob_code) VALUES (7, '5676-4565-459', '자바', '장영실', 'A', 8);
INSERT INTO yamuzip.tbl_account (acc_code, acc_number, acc_bank, acc_name, acc_status, dob_code) VALUES (8, '456-3452-5473', '으리', '홍길동', 'A', 10);


-- tbl_payment
INSERT INTO yamuzip.tbl_payment (pay_code, order_code, pay_price, pay_type, pay_status, pay_datetime, refund_datetime) VALUES (4, 1, 10000, 'card', 'P', '2024-04-01 15:42:18', null);
INSERT INTO yamuzip.tbl_payment (pay_code, order_code, pay_price, pay_type, pay_status, pay_datetime, refund_datetime) VALUES (16, 2, 2000, 'card', 'P', '2024-02-02 15:50:20', null);
INSERT INTO yamuzip.tbl_payment (pay_code, order_code, pay_price, pay_type, pay_status, pay_datetime, refund_datetime) VALUES (2, 3, 30000, 'card', 'P', '2024-02-01 11:41:15', null);
INSERT INTO yamuzip.tbl_payment (pay_code, order_code, pay_price, pay_type, pay_status, pay_datetime, refund_datetime) VALUES (11, 7, 10000, 'card', 'P', '2024-04-01 16:11:51', null);
INSERT INTO yamuzip.tbl_payment (pay_code, order_code, pay_price, pay_type, pay_status, pay_datetime, refund_datetime) VALUES (1, 8, 170000, 'card', 'P', '2024-03-30 15:34:15', null);
INSERT INTO yamuzip.tbl_payment (pay_code, order_code, pay_price, pay_type, pay_status, pay_datetime, refund_datetime) VALUES (3, 9, 50000, 'card', 'P', '2024-04-01 12:54:18', null);
INSERT INTO yamuzip.tbl_payment (pay_code, order_code, pay_price, pay_type, pay_status, pay_datetime, refund_datetime) VALUES (17, 10, 4000, 'card', 'P', '2024-02-02 15:51:02', null);
INSERT INTO yamuzip.tbl_payment (pay_code, order_code, pay_price, pay_type, pay_status, pay_datetime, refund_datetime) VALUES (18, 11, 5000, 'card', 'P', '2024-02-02 15:51:33', null);
INSERT INTO yamuzip.tbl_payment (pay_code, order_code, pay_price, pay_type, pay_status, pay_datetime, refund_datetime) VALUES (9, 12, 10000, 'card', 'P', '2024-04-01 16:10:44', null);
INSERT INTO yamuzip.tbl_payment (pay_code, order_code, pay_price, pay_type, pay_status, pay_datetime, refund_datetime) VALUES (10, 13, 10000, 'card', 'P', '2024-04-01 16:11:27', null);


-- tbl_order
INSERT INTO yamuzip.tbl_order (order_code, service_code, user_code, order_datetime, order_status, total_price, reserve_datetime, option_code, approval_datetime, cancel_datetime, reject_datetime, cancel_reason, reject_reason) VALUES (1, 1, 4, '2024-03-26 17:52:35', 'O', 100000, '2024-03-26 17:52:57', null, null, null, null, null, null);
INSERT INTO yamuzip.tbl_order (order_code, service_code, user_code, order_datetime, order_status, total_price, reserve_datetime, option_code, approval_datetime, cancel_datetime, reject_datetime, cancel_reason, reject_reason) VALUES (2, 2, 4, '2024-03-26 18:32:28', 'O', 100, '2024-03-26 18:32:42', null, null, null, null, null, null);
INSERT INTO yamuzip.tbl_order (order_code, service_code, user_code, order_datetime, order_status, total_price, reserve_datetime, option_code, approval_datetime, cancel_datetime, reject_datetime, cancel_reason, reject_reason) VALUES (3, 3, 8, '2024-03-26 18:32:30', 'O', 100, '2024-03-26 18:32:43', null, null, null, null, null, null);
INSERT INTO yamuzip.tbl_order (order_code, service_code, user_code, order_datetime, order_status, total_price, reserve_datetime, option_code, approval_datetime, cancel_datetime, reject_datetime, cancel_reason, reject_reason) VALUES (7, 4, 3, '2024-03-29 17:48:06', 'O', 140000, '2024-03-29 17:47:22', null, null, null, null, null, null);
INSERT INTO yamuzip.tbl_order (order_code, service_code, user_code, order_datetime, order_status, total_price, reserve_datetime, option_code, approval_datetime, cancel_datetime, reject_datetime, cancel_reason, reject_reason) VALUES (8, 5, 1, '2024-03-29 17:48:06', 'O', 170000, '2024-03-29 17:47:23', null, null, null, null, null, null);
INSERT INTO yamuzip.tbl_order (order_code, service_code, user_code, order_datetime, order_status, total_price, reserve_datetime, option_code, approval_datetime, cancel_datetime, reject_datetime, cancel_reason, reject_reason) VALUES (9, 6, 5, '2024-03-29 17:48:06', 'O', 210000, '2024-03-29 17:47:24', null, null, '2024-04-01 12:55:03', null, null, null);
INSERT INTO yamuzip.tbl_order (order_code, service_code, user_code, order_datetime, order_status, total_price, reserve_datetime, option_code, approval_datetime, cancel_datetime, reject_datetime, cancel_reason, reject_reason) VALUES (10, 7, 21, '2024-03-29 17:48:06', 'O', 20000, '2024-03-29 17:47:26', null, null, null, null, null, null);
INSERT INTO yamuzip.tbl_order (order_code, service_code, user_code, order_datetime, order_status, total_price, reserve_datetime, option_code, approval_datetime, cancel_datetime, reject_datetime, cancel_reason, reject_reason) VALUES (11, 8, 15, '2024-03-29 17:48:06', 'O', 200000, '2024-04-01 17:47:27', null, null, null, null, null, null);
INSERT INTO yamuzip.tbl_order (order_code, service_code, user_code, order_datetime, order_status, total_price, reserve_datetime, option_code, approval_datetime, cancel_datetime, reject_datetime, cancel_reason, reject_reason) VALUES (12, 9, 21, '2024-03-29 17:48:06', 'O', 1300000, '2024-02-29 17:47:28', null, null, null, null, null, null);
INSERT INTO yamuzip.tbl_order (order_code, service_code, user_code, order_datetime, order_status, total_price, reserve_datetime, option_code, approval_datetime, cancel_datetime, reject_datetime, cancel_reason, reject_reason) VALUES (13, 10, 15, '2024-03-29 17:48:06', 'O', 110000, '2024-04-01 18:47:31', null, null, null, null, null, null);


-- tbl_calculate
INSERT INTO yamuzip.tbl_calculate (cal_code, dob_code, acc_code, cal_datetime, cal_price, specs_img) VALUES (1, 11, 1, '2024-04-02 13:03:15', 1, null);
