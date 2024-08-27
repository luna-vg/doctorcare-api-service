CREATE USER 'account'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON * . * TO 'account'@'localhost' WITH GRANT OPTION;

CREATE DATABASE doctorcare;
USE doctorcare;

CREATE TABLE roles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);

INSERT INTO `doctorcare`.`roles` (`name`) VALUES ('ROLE_ADMIN');
INSERT INTO `doctorcare`.`roles` (`name`) VALUES ('ROLE_USER');
INSERT INTO `doctorcare`.`roles` (`name`) VALUES ('ROLE_DOCTOR');
INSERT INTO `doctorcare`.`roles` (`name`) VALUES ('ROLE_PATIENT');

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(255),
    address VARCHAR(255),
    phone_number VARCHAR(255),
    gender VARCHAR(255),
    role_id INT NOT NULL,
    enabled TINYINT(1) NOT NULL,
    FOREIGN KEY (role_id)
        REFERENCES roles (id)
);

CREATE TABLE clinics (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    address VARCHAR(255),
    phone_number VARCHAR(255),
    description VARCHAR(255)
);

CREATE TABLE specializations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT
);

CREATE TABLE doctors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT UNIQUE NOT NULL,
    clinic_id INT NOT NULL,
    specialization_id INT NOT NULL,
    general_introduction TEXT,
    education VARCHAR(255),
    rewards VARCHAR(255),
    FOREIGN KEY (user_id)
        REFERENCES users (id),
    FOREIGN KEY (clinic_id)
        REFERENCES clinics (id),
    FOREIGN KEY (specialization_id)
        REFERENCES specializations (id)
);

CREATE TABLE patients (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT UNIQUE NOT NULL,
    description VARCHAR(255),
    FOREIGN KEY (user_id)
        REFERENCES users (id)
);

CREATE TABLE clinic_specialization (
    id INT PRIMARY KEY AUTO_INCREMENT,
    clinic_id INT NOT NULL,
    specialization_id INT NOT NULL,
    price INT,
    FOREIGN KEY (clinic_id)
        REFERENCES clinics (id),
    FOREIGN KEY (specialization_id)
        REFERENCES specializations (id)
);

CREATE TABLE appointments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    status INT,
    date VARCHAR(255) NOT NULL,
    time VARCHAR(255) NOT NULL,
    note VARCHAR(255),
    confirmed INT,
    reject_text VARCHAR(255),
    FOREIGN KEY (patient_id)
        REFERENCES patients (id),
    FOREIGN KEY (doctor_id)
        REFERENCES doctors (id)
);

CREATE TABLE locked_account (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT UNIQUE NOT NULL,
    reason VARCHAR(255),
    FOREIGN KEY (user_id)
        REFERENCES users (id)
);

use doctorcare;
select * from appointments;
select * from doctors;
select * from users;
select * from roles;
select * from clinics;
select * from patients;
select * from clinic_specialization;
select * from specializations;
select * from locked_account;