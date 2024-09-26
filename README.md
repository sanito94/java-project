## User Management Application - back-end.
This is simple back-end User Managment Application.

## Requirements
IntelliJ IDEA 2024.2.1 or later <br>
Java 17 or later <br>
Docker latest version

## How to install the back-end part of our project.

1. First create a folder with the name back-end and open the same folder in the terminal (cmd or Powershell) and type git clone https://github.com/sanito94/java-project.git --> that is how we clone the back-end part of the  project.
2. Open Docker
3. Open IntelliJ.
4. File->Open and choose the project directory.
5. Open Terminal in Intellij with Ctrl+` and type docker-compose up. Make sure that port 3306 is free in order to run and also that the Docker is open.
6. Top right corner should be a green pointer (Run). Click on it to start the back-end of the project.
7. In order to test with Postman --> Go to Authorization --> Choose Basic Auth --> username: admin and password: admin123

That's how we start the back-end of our project.

---------------------

Also there is a way to create a jar file to open the back-end easier.

1. On the right side of the project should be a letter "m" (lower case).
2. Click on it.
3. Then click on "demo".
4. After that click on "Lifecycle".
5. Then double click on "package" to create a jar file.
6. After you receive the green message BUILD SUCCESS go to the directory of the project java-project\target
7. Open a terminal on this location and type java -jar demo-1.0.0.jar

   That's how we start the back-end of our project through jar file.

## Swagger
After the back-end project is started, you can access the Swagger through this link ---> http://localhost:9090/swagger-ui/index.html

## There is a front-end part of the project

You can find the front-end part of the project here ---> https://github.com/sanito94/java-project-frontend

