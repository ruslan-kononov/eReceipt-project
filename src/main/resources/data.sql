INSERT INTO user (user_id, email, first_name, last_name, password, role, username)
    VALUES
  (UUID(), 'admin1@gmail.com', 'Stepan', 'Rudnyi','admin01','ADMIN' ,'admin01');

INSERT INTO admins (user_id, created_at)
    VALUES ((SELECT user_id from user where username = 'admin01' and password = 'admin01'),'2020-08-21');


INSERT INTO hospitals (hospital_id,name)
    VALUES (100,'The Mayo Clinic');
INSERT INTO hospitals (hospital_id,name)
    VALUES (101,'John Hopkins Clinic');
INSERT INTO hospitals (hospital_id,name)
    VALUES (102,'Cleveland Clinic');


INSERT INTO user (user_id, email, first_name, last_name, password, role, username)
    VALUES
  (UUID(), 'doctor1@gmail.com', 'Ivan', 'Ukrainets','doctor01','DOCTOR' ,'doctor01');

INSERT INTO user (user_id, email, first_name, last_name, password, role, username)
    VALUES
  (UUID(), 'doctor2@gmail.com', 'Lesia', 'Stepanenko','doctor02','DOCTOR' ,'doctor02');


INSERT INTO doctors (user_id, hospital_id)
    VALUES ((SELECT user_id from user where username = 'doctor01' and password = 'doctor01'),100);

INSERT INTO doctors (user_id, hospital_id)
    VALUES ((SELECT user_id from user where username = 'doctor02' and password = 'doctor02'),102);

INSERT INTO user (user_id, email, first_name, last_name, password, role, username)
    VALUES
  (UUID(), 'pharma1@gmail.com', 'Halyna', 'Kiryk','pharma01','PHARMA' ,'pharma01');

INSERT INTO pharmacists (user_id)
    VALUES ((SELECT user_id from user where username = 'pharma01' and password = 'pharma01'));
