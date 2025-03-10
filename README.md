# SwiftStore API

<p>
   <a href="#prerequisites">Prerequisites</a> 
   &nbsp; | &nbsp;
   <a href="#getting-started">Getting Started</a> 
   &nbsp; | &nbsp; 
   <a href="#routes">API Endpoints</a> 
   &nbsp; | &nbsp;
   <a href="#colab">Collaborators</a> 
   &nbsp; | &nbsp;
   <a href="#contribute">Contribute</a> 
</p>

<p>
   This project is a RESTful API for the SwiftStore e-commerce platform, developed using Spring Boot and following the MVC
   architecture pattern. The API enables secure and efficient management of products, orders, and user authentication
   through JWT tokens.
</p>

<h2 id="prerequisites">📌 Prerequisites</h2>

Before running the **SwiftStore API** project, make sure you have the following installed:

### 🔧 Development Environment

- **Java 21**
- **Maven 3.8+**
- **Recommended IDE:** IntelliJ IDEA / Eclipse / VS Code

### 📦 Main Dependencies

This project uses the following dependencies with **Spring Boot 3.4.2**:

- **Spring Boot Starter Web** → To create the REST API
- **Spring Boot Starter Data JPA** → For database integration
- **Spring Boot Starter Security** → For authentication and security
- **Spring Boot Starter Validation** → For data validation
- **MapStruct** → For object mapping
- **Lombok** → To reduce boilerplate code
- **Java JWT** → For authentication using JWT tokens

### 💾 Database

This project supports the following databases:

- **H2 Database** (for testing)
- **PostgreSQL** (for production)

If using PostgreSQL, configure your credentials in `application.properties`.


<h2 id="getting-started">🚀 Getting Started</h2>

Follow these steps to set up and run the SwiftStore API locally:

1. Clone the repository and set up your environment
   ```shell
   git clone https://github.com/your-username/swiftstore-api.git
   cd swiftstore-api
   ```
2. Configure the database in `src/main/resources/application.properties`
   ```properties
   spring.datasource.url=
   spring.datasource.username=
   spring.datasource.password=
   ```

3. Install dependencies using Maven
   ```shell
   mvn clean install
   ```

4. Run the application
   ```shell
   mvn spring-boot:run
   ```

5. Access the API via Postman or an integrated frontend.


<h2 id="routes">📍 API Endpoints</h2>

| Method   | Endpoint         | Description               |
|----------|------------------|---------------------------|
| `GET`    | `/products`      | Retrieves all products    |
| `GET`    | `/products/{id}` | Retrieves a product by ID |
| `POST`   | `/products`      | Creates a new product     |
| `PUT`    | `/products/{id}` | Updates a product by ID   |
| `DELETE` | `/products/{id}` | Deletes a product by ID   |
| `GET`    | `/orders/{id}`   | Retrieves an order by ID  |
| `POST`   | `/orders`        | Creates a new order       |
| `POST`   | `/auth/login`    | Authenticates a user      |
| `POST`   | `/auth/register` | Registers a new user      |
| `GET`    | `/categories`    | Retrieves all categories  |

<h3 id="post-auth-detail">POST /auth/login</h3>

**REQUEST**

```json
{
  "email": "example@example.com",
  "password": "examplePassword"
}
```

**RESPONSE**

```json
{
  "accessToken": "eyJhbGciOiJGUzI4NihsInu5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6ImpvYW8udmljdG9yQGV4YW1wbGUuY29tIiwiZXhwIjoxNzQxNjIyOTg5fQ.wp7HMvD519LptAfow4o-Pv4txRiLC1FmtFtvKQq1gzQ",
  "expiresAt": "2025-02-31T16:00:00Z",
  "userId": 9999,
  "email": "example@example.com",
  "name": "Name Lastname",
  "roles": [
    "ROLE_ADMIN",
    "ROLE_USER"
  ]
}
```

<h2 id="colab">🤝 Collaborators</h2>

Special thank you for all people that contributed for this project.

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/SEU-NOME-DE-USUARIO">
        <img src="https://github.com/joaovictorcmd.png" width="100px;" alt="João Victor Profile Picture"/><br>
        <sub>
          <b>João Victor Machado</b>
        </sub>
      </a>
    </td>
  </tr>
</table>


<h2 id="contribute">📫 Contribute</h2>

Want to contribute? Follow these steps to help improve **Swift Store**!

1. Fork the repository and clone it:
   ```sh
   git clone https://github.com/joaovictorcmd/swift_store.git
   ```

2. Create a new branch following the naming convention:
   ```sh
   git checkout -b feature/your-feature-name
   ```

3. Follow the commit message pattern (e.g., feat: added new product API or fix: corrected authentication issue)

4. Push your changes to your fork and open a Pull Request (PR):
    - Provide a clear description of the issue solved or feature added.
    - If applicable, attach screenshots of visual modifications.
    - Wait for the review and feedback! 🚀

### Documentations that might help

[📝 How to create a Pull Request](https://www.atlassian.com/br/git/tutorials/making-a-pull-request)

[💾 Commit pattern](https://github.com/iuricode/padroes-de-commits)
