-- Skapa databas
CREATE DATABASE IF NOT EXISTS fitlog;
USE fitlog;


-- USERS

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100)
);

INSERT INTO users (name, email, password) VALUES
('Stina Ander', 'stina@fitlog.se', 'hemligt123'),
('Anni Kan', 'anni@fitlog.se', 'lösen456');


-- TRAINERS

CREATE TABLE trainers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    specialty VARCHAR(100),
    email VARCHAR(100) UNIQUE
);

INSERT INTO trainers (name, specialty, email) VALUES
('Maja Muskler', 'Styrketräning', 'maja@fitlog.se'),
('Kalle Kondis', 'Konditionsträning', 'kalle@fitlog.se'),
('Ylva Yoga', 'Yoga och rörlighet', 'ylva@fitlog.se');


-- WORKOUT_LOGS

CREATE TABLE workout_logs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    exercise_name VARCHAR(100),
    type VARCHAR(50),
    date DATETIME,
    trainer_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (trainer_id) REFERENCES trainers(id)
);

INSERT INTO workout_logs (user_id, exercise_name, type, date, trainer_id) VALUES
(1, '5K Morning Run', 'running', '2025-03-24 07:00:00', 2),
(2, 'CrossFit WOD', 'crossfit', '2025-03-23 18:00:00', 1),
(1, 'Yoga Stretch', 'yoga', '2025-03-22 19:00:00', 3);


-- ACTIVITY_LOGS
CREATE TABLE activity_logs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    activity_type VARCHAR(100),
    duration_minutes INT,
    date DATETIME,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

INSERT INTO activity_logs (user_id, activity_type, duration_minutes, date) VALUES
(1, 'Meditation', 15, '2025-03-24 06:30:00'),
(2, 'Power Walk', 30, '2025-03-23 08:00:00'),
(1, 'Foam Rolling', 10, '2025-03-22 20:00:00');

-- (JOINS)

-- Visa träningspass med användarnamn
SELECT
    wl.id AS workout_id,
    u.name AS user_name,
    wl.exercise_name,
    wl.type,
    wl.date,
    t.name AS trainer_name
FROM workout_logs wl
JOIN users u ON wl.user_id = u.id
LEFT JOIN trainers t ON wl.trainer_id = t.id;

-- Visa alla aktiviteter från activity_logs
SELECT
    a.id,
    u.name AS user_name,
    a.activity_type,
    a.duration_minutes,
    a.date
FROM activity_logs a
JOIN users u ON a.user_id = u.id;
