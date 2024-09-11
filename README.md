# Student Data Management System
-------------------------------

## Description
The Student Data Management System is a web-based application built with Java and Spring Boot to manage student data efficiently. This system provides a set of RESTful APIs for performing CRUD operations (Create, Read, Update, Delete) on student information. It is designed to be scalable, efficient, and easily integrable with other systems, supporting educational institutions in managing student records.

## Features
- **Create, Read, Update, Delete (CRUD) Operations:** Manage student records easily with full CRUD functionality.
- **RESTful API:** All interactions are exposed through HTTP RESTful services for easy integration.
- **Spring Boot Framework:** Provides a rapid setup, configuration, and deployment environment for the application.
- **Java Persistence API (JPA):** Integrated for efficient database operations and management.
- **MySQL Database:** Robust and reliable relational database used for data storage and management.
- **Validation:** Input validation is handled at the API level using Hibernate Validator to ensure data integrity.
- **Scalable and Extensible:** Designed to be extended with new features or integrated with external services as needed.

## Tech Stack
- **Language:** Java
- **Framework:** Spring Boot
- **Database:** MySQL
- **Build Tool:** Maven
- **Testing:** JUnit 5, Spring Boot Test
- **API Documentation:** Swagger UI (for interactive API documentation and testing)

## Getting Started
### 1) Prerequisites
1. **Java:** Ensure that you have JDK 11 or later installed. You can download it from the Oracle website or use OpenJDK.
2. **Maven:** Make sure Maven is installed for building the project. You can download Maven from the Apache Maven website.
3. **MySQL:** Install MySQL for managing the database. You can download it from the MySQL website. Ensure that you have created a database for the application.
4. **IDE:** A Java Integrated Development Environment (IDE) like Eclipse, IntelliJ IDEA, or VSCode can help you manage and run the project efficiently.
5. **Swagger UI:** Ensure you have Swagger UI integrated with your Spring Boot application for interactive API documentation. You can access it via the provided URL in your application.

### 2) Setup
1. **Clone the Repository:**
    ```bash
    git clone https://github.com/RudraPrasad07/School-Data-Management-System.git
    ```
2. **Navigate to the Project Directory:**
    ```bash
    cd School-Data-Management-System
    ```
3. **Configure Database:**
   Update `src/main/resources/application.properties` with your MySQL database details:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    ```
4. **Build the Project:**
    ```bash
    mvn clean install
    ```
5. **Run the Application:**
    ```bash
    mvn spring-boot:run
    ```
6. **Access Swagger UI:**
   Once the application is running, you can access the Swagger UI documentation on your browser with the URL: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### 3) Running the Application
Once the application is up and running, you can access the REST API through the following endpoints:

#### AddressController
- **PUT /address/updateaddress/{id}:** Update the address information for the given ID. Requires the ID as a path variable and the updated details.
- **GET /address/fetch/{id}:** Retrieve the address information for the given ID. Requires the ID as a path variable.

#### ClassController
- **POST /class/save:** Create and save a new class. Returns the details of the created class.
- **PUT /class/update/{id}:** Update an existing class by its ID.
- **GET /class/fetch/{id}:** Retrieve a class by its ID.
- **GET /class/fetchByYear/{year}:** Retrieve a list of classes by the academic year.
- **DELETE /class/delete/{id}:** Delete a class by its ID.
- **DELETE /class/deleteByYear/{year}:** Delete all classes associated with the given academic year.

#### MarksController
- **POST /Mark/save:** Create and save a new mark. Requires studentId and subjectID as query parameters.
- **PUT /Mark/updateMark/{id}:** Update an existing mark by ID.
- **GET /Mark/fetchBymarkByID/{id}:** Retrieve a mark by its ID.
- **GET /Mark/fetchMarkByStudentId/{Id}:** Retrieve all marks by student ID.
- **GET /Mark/fetchMarkBySubjectId/{Id}:** Retrieve all marks by subject ID.
- **DELETE /Mark/deleteById/{Id}:** Delete a mark by its ID.

#### StudentController
- **POST /student/save:** Create and save a new student record.
- **PUT /student/Update/{id}:** Update an existing student by ID.
- **GET /student/fetchById/{id}:** Retrieve a student by ID.
- **GET /student/fetchByNumber/{number}:** Retrieve a student by phone number.
- **GET /student/fetchstudentByclassName/{classname}:** Retrieve students by class name.
- **DELETE /student/deleteStudentByID/{id}:** Delete a student by ID.
- **DELETE /student/deleteStudentByNumber/{number}:** Delete a student by phone number.

#### SubjectController
- **GET /subject/fetch/{id}:** Retrieve a specific subject by ID.
- **GET /subject/fetchBycode/{code}:** Retrieve a specific subject by subject code.
- **GET /subject/fetchByclassname/{className}:** Retrieve all subjects by class name.
- **GET /subject/fetchSubjecByStudentID/{sID}:** Retrieve all subjects associated with a specific student ID.
- **POST /subject/SaveSubject/{className}:** Create a new subject and associate it with the specified class name.
- **PUT /subject/Update/{id}:** Update a subject by ID.
- **DELETE /subject/deleteSubjecByID/{id}:** Delete a subject by ID.

#### TeacherController
- **GET /teacher/fetchByName/{Classname}:** Retrieve all teachers by class name.
- **GET /teacher/fetch/{id}:** Retrieve a specific teacher by ID.
- **GET /teacher/fetchByNumber/{number}:** Retrieve a specific teacher by phone number.
- **POST /teacher/saveteacher:** Create a new teacher.
- **PUT /teacher/UpdateTeacher/{id}:** Update teacher information.
- **DELETE /teacher/delete/{id}:** Delete a teacher by ID.
- **DELETE /teacher/DeleteByNumber/{Number}:** Delete a teacher by phone number.
  
### 4) API Documentation
You can explore and test the APIs using Swagger (if integrated) or tools like Postman. Below is an example of a sample API request in Postman:

### Sample API Request

- **Method**: POST
- **URL**: `http://localhost:8080/students`

- **Body**:
```json
{
    "name": "Name",
    "dob": "DOB",
    "gender": "Gender",
    "email": "Email",
    "password": "Password",
    "phoneno": "PhoneNumber"
}
```
### 5) Database Configuration
### Switching to MySQL

To use MySQL, update the `application.properties` file with the following configuration:

```properties
# MySQL Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
### 6) Testing
 - **Run tests using the following Maven command:**
    ```bash
    mvn test
    ```
    
### - Contributing
   **Feel free to contribute or provide feedback. Your support is greatly appreciated!**

</br>
  <div align="center">

 ***Thank You! For checking out my project! 🙏***



</div>






