# Animal CRUD MVC Application

CRUD MVC App using JPA/Hibernate, MySQL, and ThymeLeaf.

## Project Overview

This project is a full-stack CRUD web application that manages animal objects. It allows users to create, read, update, and delete animal data through a user-friendly interface built using ThymeLeaf templates, with JPA and Hibernate handling database persistence and MySQL as the database.

## Technologies Used
- **Spring Boot**: For building the web application and managing dependencies.
- **JPA/Hibernate**: For object-relational mapping and handling database operations.
- **MySQL**: As the database for persistent data storage.
- **ThymeLeaf**: For generating dynamic HTML views.
  
## Setup Instructions

### Prerequisites

- Java 21
- MySQL (configured via XAMPP or any other MySQL server)
- Maven

### Steps

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   ```
   
2. **Configure MySQL database**:
   - Open `/src/main/resources/application.properties`.
   - Ensure your MySQL settings are correctly configured:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3307/assignment4?useSSL=false
     spring.datasource.username=root
     spring.datasource.password=
     ```
   - The database name is defined in the `spring.datasource.url` between the last `/` and the `?`. In this case, it's `assignment4`.

3. **Start XAMPP**:
   - Start the **Apache** and **MySQL** services in your XAMPP Control Panel.
   - Click on MySQL **Admin** to open up the DBMS and ensure the database you need is available.

4. **Build and Run the Application**:
   - Open the project in IntelliJ.
   - Run the `CrudapiApplication` main class.
   - The application will create necessary tables if they don’t already exist.

5. **Access the Application**:
   - Go to `http://localhost:8080/api/animals/all` to view the list of animals.

## Key Features

### Entity: Animal
The `Animal` class is annotated as an `@Entity`, mapping its attributes to a database table. This class represents an animal with the following attributes:
- `animalId`: A unique identifier (auto-generated).
- `name`: The animal’s name (non-null).
- `scientificName`: The scientific name (nullable).
- `species`: The animal’s species (non-null).
- `habitat`: The habitat where the animal lives (non-null).
- `description`: A description of the animal (nullable).

### Repository
The `AnimalRepository` extends the `JpaRepository` interface, providing prebuilt CRUD operations such as selecting, inserting, and deleting animals. It also allows for querying animals based on species or name.

### Controller
The `AnimalController` handles HTTP requests and returns HTML views. Mappings are as follows:
- `/api/animals/all`: Displays the list of all animals.
- `/api/animals/{animalId}`: Displays the details of a specific animal.
- `/api/animals/new`: Displays the form to create a new animal.
- `/api/animals/update/{animalId}`: Displays the form to update an existing animal.

### Views
All ThymeLeaf templates for the application are stored in `src/main/resources/templates`. These include:
- **animal-list.html**: Displays a list of animals.
- **animal-details.html**: Displays details of a specific animal.
- **animal-create.html**: A form for creating a new animal.
- **animal-update.html**: A form for updating an existing animal.

### Form Handling
Forms in ThymeLeaf are used to collect and send data to the backend. Field names in the form must match the corresponding attribute names in the `Animal` entity to bind correctly. Examples:
- `name="name"` binds to the animal's name.
- The update form pre-fills animal data using `${animal.attribute}` placeholders.

## Navigation Links
- The **animal-list** page provides links to view animal details, update, or delete animals.
- The **Create New Animal** button links to the animal creation form.
- All view pages contain necessary navigation links for smooth operation within the application.

## Example Endpoints

- **View all animals**: `http://localhost:8080/api/animals/all`
- **View an animal by ID**: `http://localhost:8080/api/animals/{animalId}`
- **Create a new animal**: `http://localhost:8080/api/animals/new`
- **Update an existing animal**: `http://localhost:8080/api/animals/update/{animalId}`
- **Delete an animal**: `http://localhost:8080/api/animals/delete/{animalId}`

## Running the Application
After starting the app, access the following URLs in your browser to interact with the application:
- **View all animals**: `http://localhost:8080/api/animals/all`
- **Create a new animal**: `http://localhost:8080/api/animals/new`

