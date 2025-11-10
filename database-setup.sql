-- PostgreSQL Database Setup Script for Hotel Reservation System
-- Run this script to set up the database from scratch

-- Drop existing database if it exists (optional)
-- DROP DATABASE IF EXISTS hotel_db;

-- Create the database
CREATE DATABASE hotel_db;

-- Connect to the database (in psql, use: \c hotel_db)

-- Note: Tables will be automatically created by Hibernate when you run the application
-- with spring.jpa.hibernate.ddl-auto=update setting

-- To reset the database and start fresh:
-- 1. Stop the Spring Boot application
-- 2. Drop all tables:
--    DROP TABLE IF EXISTS reservations CASCADE;
--    DROP TABLE IF EXISTS rooms CASCADE;
--    DROP TABLE IF EXISTS hotels CASCADE;
-- 3. Restart the Spring Boot application
-- 4. Tables will be recreated and sample data will be inserted

-- Verify database connection
SELECT version();

-- After running the application, you can query the data:
-- SELECT * FROM hotels;
-- SELECT * FROM rooms;
-- SELECT * FROM reservations;

