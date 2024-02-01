# Customer Management Service

Customer Management Service is a robust application designed to simplify the process of adding and managing customers for authorized users. It provides a user-friendly interface with convenient features such as custom search, easy addition, deletion, and updating of customer records.

## Technologies Used

The Customer Management Service leverages the following technologies:

1. **Java Spring Boot:** A powerful and flexible Java-based framework for building web applications.
2. **MySQL:** A relational database management system for storing customer records.
3. **JWT (JSON Web Tokens):** Used for secure authentication and authorization.
4. **Spring Security:** Ensures secure authentication and authorization within the application.
5. **Maven:** A widely-used build automation and project management tool for Java projects.

## Getting Started

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/arjunagi-a-rehman/customer_management_service.git
   cd customer-management-service
   ```

2. **Build and Run the Application:**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
   The application will start on [http://localhost:8080](http://localhost:8080).


## API Documentation

## CustomerController

1. **Create Customer:**
   - **Endpoint:** `POST /api/v0/customer/`
   - **Method:** `createCustomer(@RequestBody CustomerDto customerDto)`
   - **Description:** Creates a new customer using the provided `CustomerDto` and returns a `201 CREATED` response.

2. **Get All Customers:**
   - **Endpoint:** `GET /api/v0/customer/`
   - **Method:** `getAllCustomer()`
   - **Description:** Retrieves a list of all customers and returns a `200 OK` response with the list.

3. **Get Customer by ID:**
   - **Endpoint:** `GET /api/v0/customer/{id}`
   - **Method:** `getCustomerById(@PathVariable String id)`
   - **Description:** Retrieves a customer by ID and returns a `200 OK` response with the customer details.

4. **Get Customers by Page:**
   - **Endpoint:** `GET /api/v0/customer`
   - **Method:** `getCustomerPage(@RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize)`
   - **Description:** Retrieves a paginated list of customers and returns a `200 OK` response.

5. **Search Customers by Name, Email, City, or Phone:**
   - **Endpoint:** `GET /api/v0/customer/search/n`, `GET /api/v0/customer/search/e`, `GET /api/v0/customer/search/c`, `GET /api/v0/customer/search/p`
   - **Methods:** `getByName(@RequestParam String name)`, `getByEmail(@RequestParam String email)`, `getByCity(@RequestParam String city)`, `getByPhone(@RequestParam String phone)`
   - **Description:** Searches customers by the specified criteria and returns a `200 OK` response with the matching customers.

6. **Update Customer:**
   - **Endpoint:** `PUT /api/v0/customer/`
   - **Method:** `updateCustomer(@RequestBody CustomerDto customerDto)`
   - **Description:** Updates customer details and returns a `200 OK` response if successful; otherwise, returns a `500 INTERNAL SERVER ERROR` response.

7. **Delete Customer:**
   - **Endpoint:** `DELETE /api/v0/customer/{id}`
   - **Method:** `deleteCustomer(@PathVariable String id)`
   - **Description:** Deletes a customer by ID and returns a `200 OK` response.

## UserController

1. **Register User:**
   - **Endpoint:** `POST /api/v0/user/register`
   - **Method:** `registerUser(@RequestBody UserDto userDto)`
   - **Description:** Registers a new user using the provided `UserDto` and returns a `201 CREATED` response.

2. **Authenticate and Get Token:**
   - **Endpoint:** `POST /api/v0/user/generate`
   - **Method:** `authenticateAndGetToken(@RequestBody UserLoginDto authRequest)`
   - **Description:** Authenticates the user using the provided credentials, and if successful, generates a JWT token for the user.


## Project Structure

The project adheres to the standard Spring Boot structure. Key packages include:

- `com.example.customermanagementservice.controller`: API controllers
- `com.example.customermanagementservice.model`: Entity classes for customers
- `com.example.customermanagementservice.repository`: MySQL repository interfaces
- `com.example.customermanagementservice.service`: Service interfaces and implementations
- `com.example.customermanagementservice.dto`: All The Data transfer objects
- `com.example.customermanagementservice.exception`: The custom Exceptions and Exception handler
- `com.example.customermanagementservice.filer`: JWT filter
- `com.example.customermanagementservice.config`: All the configuration files including security config file 

## Security

The application uses JWT and Spring Security to ensure secure authentication and authorization for users.

## Contributing

Contributions to the project are welcome. Please follow the [contribution guidelines](CONTRIBUTING.md) for details.

## License

This project is licensed under the [MIT License](LICENSE).
