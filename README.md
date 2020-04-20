# Course-Registration-System
#### ENSF 409 Term Project 
##### Branden Wong & Savipal Jessel
##### A program which manages students enrolling in courses. 
How to run our application:
1. Point the classpath to the driver jar. Note that the driver jar is contained 
in the lib folder within our project directory. Note that this varies from IDE to IDE.

2. If you do not already have a mySQL server over localhost port 3306, 
please create one. Please create a database within your mySQL server with the name
CourseRegistration. Alternatively, go the DBCredentials.java, and change the 
database name in DB_URL. 

3. Build the project. Note that you should see You should see three tables: student, course, and courseoffering.
4. Navigate to src/Server/RegistrationApp.java and run the code
    - This will start the server
5. Navigate to src/Client/ClientRegistrationApp.java and run the code
    - This will run the client, and connect to the server
    - You may run as many clients as you want since it is multithreaded
