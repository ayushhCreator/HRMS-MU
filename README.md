# Magadh University HRMS - Timetable Management

This project is a part of the Magadh University Human Resource Management System (HRMS), focusing on timetable management.

## Technologies Used

* Backend:
    * Java with Spring Boot
    * Spring Data JPA for database interactions
* Frontend:
    * HTML, CSS, Bootstrap for responsive design
    * Thymeleaf for dynamic data rendering
* Database:
    * MySQL

## Setup Instructions

### Prerequisites

Before running the application, ensure you have the following installed:

* JDK 11 or higher
* MySQL Database
* Maven (for project management)

### Installation

1.  **Clone the Repository**

    ```bash
    git clone [https://github.com/ayushhCreator/HRMS-MU.git](https://github.com/ayushhCreator/HRMS-MU.git)
    cd HRMS-MU
    ```
2.  **Configure the Database**

    * Set up a MySQL database.
    * Create an `application.properties` file in the `src/main/resources` directory with the following configuration:

        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
        spring.datasource.username=your_username
        spring.datasource.password=your_password
        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.show-sql=true
        ```

        Replace `your_database_name`, `your_username`, and `your_password` with your actual MySQL database credentials.
3.  **Build and Run the Application**

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

    The application will start on `http://localhost:8080`.

## Usage

Once the application is running:

* Access the homepage at `http://localhost:8080`.
* Navigate through the application to manage timetables and other HRMS functionalities.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any enhancements or bug fixes.

## License

This project is open-source and available under the [MIT License](LICENSE).

## Contact

For any questions or feedback, please contact [ayushhCreator](https://github.com/ayushhCreator).
