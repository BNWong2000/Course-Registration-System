# ENSF 409 Term Project 
##### Branden Wong - 30040675 - branden.wong1@ucalgary.ca
##### Savipal Jessel - 30039257 - savipal.jessel@ucalgary.ca
How to run our application:
1. Point the classpath to the driver jar. Note that the driver jar is contained 
in the lib folder within our project directory. Note that this varies from IDE to IDE.

2. If you do not already have a mySQL server over localhost port 3306, 
please create one. Please create a database within your mySQL with the name
CourseRegistration. Alternatively, go the DBCredentials.java, and change the 
database name in DB_URL. You should see three tables: student, course, and courseoffering.


4. Build the project
3. Navigate to src/Server/RegistrationApp.java and run the code
    - This will start the server
4. Navigate to src/Client/ClientRegistrationApp.java and run the code
    - This will run the client, and connect to the server
    - You may run as many clients as you want since it is multithreaded
    



