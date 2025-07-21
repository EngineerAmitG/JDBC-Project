How to Run the Project After Download
Download or Clone the Project

Download the ZIP from GitHub and extract it
OR

Use Git to clone the project:

bash
Copy
Edit
git clone https://github.com/your-username/laptop-management-system.git
Open the Project in an IDE

Open the folder in IntelliJ IDEA, Eclipse, or any Java IDE.

Set Up PostgreSQL Database

Make sure PostgreSQL is installed and running.

Create a database named shop.

Create a table using this SQL:

sql
Copy
Edit
CREATE TABLE laptop (
    id INT PRIMARY KEY,
    brand VARCHAR(50),
    price DOUBLE PRECISION,
    model VARCHAR(50)
);
Check JDBC Connection

In LaptopDao.java, update the connection details:

java
Copy
Edit
private static final String URL = "jdbc:postgresql://localhost:5432/shop";
private static final String USER = "postgres";
private static final String PASSWORD = "your-password";
Add PostgreSQL JDBC Driver

Make sure the PostgreSQL JDBC driver is added to your project’s classpath.

Run the Program

Run the LaptopDriver.java file.

Follow the menu shown in the console to perform operations.
