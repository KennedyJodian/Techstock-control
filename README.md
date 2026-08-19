# TechStock Control

An Electronics Inventory Management System for tracking electronic products
across different warehouse locations.

## Technologies

- Spring Boot
- Thymeleaf
- Spring Security
- Spring Data JPA
- Bootstrap
- H2 Database
- MySQL
-

## Features

- Product management
- Product searching and sorting
- Brand management
- User registration and login
- Logout functionality
- Authorization
- H2 database for development
- MySQL database for QA/production
- YAML configuration with multiple profiles

## Clone the Repository


git clone YOUR_REPOSITORY_URL
cd techstockcontrol

The application uses YAML files instead of application.properties.

application.yml 
application-dev.yml 
application-qa.yml 

SQL credentails : DB_USERNAME & DB_PASSWORD

## User Roles / Test Accounts
ADMIN 
Username: admin Pwd: admin123
MANAGER 
Username: manager Pwd: manager123
STAFF 
Username: staff PWd: staff123

## Security Features 
User login and logout
User registration
Role-based access control
Admin pages restricted to ADMIN Users


Deliverable 1 - Web Front-End & Database Integration
Home page
About page
Contact page
Product management
Sample database records using data.sql


Deliverable 2 - Security and User Management
User registration
Login functionality
Logout functionality
Role-based authorization
Admin dashboard


Deliverable 3 - Configuration, Profiles & Integration
Migrated from .properties to YAML configuration
Development profile using H2
Environment variables for MySQL credentials
Improved application stability and usability


## Team Contributions 
Jodian Kennedy
Product Entity
Controllers
Thymeleaf pages
Searching and sorting features
Admin dashboard
Role-based access control
User registration
User authentication
YAML profile configuration
Testing and integration