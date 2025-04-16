Access Swagger UI:
API Endpoint: http://localhost:8080/swagger-ui/index.html#/account-controller/addAccount

To Stop the Server:
Open the terminal and type: tasklist

Search for the PID of the running process.

Kill the task by running: taskkill /PID <PID> /F (e.g., taskkill /PID 12345 /F).

Verify the task list again to ensure the process has been terminated.

To Build the Application:
Run the following command:
mvn clean install

To Run the Application:
Start the Spring Boot application by using:
mvn spring-boot:run

swing ui: terminal cmd => .\run_swing_ui.bat

using postman:
 http://localhost:8080/api/customers
