# Magadh University HRMS - Timetable Management

This project is a part of the Magadh University HRMS.

## Technologies Used

- **Backend:**
  - Java with Spring Boot
  - Spring Data JPA for database interactions
  - Thymeleaf for rendering views
  
- **Frontend:**
  - HTML, CSS, Bootstrap for responsive design
  - Thymeleaf for dynamic data rendering
  
- **Database:**
  - MySQL

## Setup Instructions

### Prerequisites
Before running the application, ensure you have the following installed:
- JDK 11 or higher
- MySQL Database
- Maven  (for project management)

### Clone the repository
```bash
git clone https://github.com/yourusername/magadh-university-hrms.git
cd magadh-university-hrms


### Configure the Database
Set up a MySQL database.
Create a .env or application.properties file with the following configuration:
properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/hrms
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update

### Run the Application
Use Maven or Gradle to run the application:

Maven: mvn spring-boot:run
