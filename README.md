# TechStock Control 

A Inventory Management System for tracking electronic items across various warehouse locations. 
## Technologies
-Spring Boot
-Thymeleaf
-Bootstap

Clone the repository : git clone YOUR_REPOSITORY_URL 
Run application and open - http://localhost: 8080 

## Team 
Jodian Kennedy: -Product Entity
                - Controllers
                - Thymeleaf pages
                - Searching and sorting features 


## Deliverable 1 - Web Front-End & Database  Integration 
-Home page
-About page
-Contact Page
-Sample database records using data.sql



## Deliverabe 2 - Security and User Management 
- User Registration 
-Logout functionality
-Role-based authorization 

User roles: Admin
            Manager
            Staff


How to run: 
run: ./mvnw spring-boot:run
open: http://localhost:8080

Test Accounts: 
#Administrator : Username: admin
Password: admin123
Role: ADMIN

#Manager: Username: manager
Password: manager123
Role: MANAGER

#Staff: Username: staff
Password: staff123
Role: STAFF

# Team Contributions

Jodian Kennedy 
- Admin dashboard
- Role-based access control
- User registration
- User authentication

# Security Features
- Admin pages restricted to ADMIN role
- Unauthorized users receive access denied response