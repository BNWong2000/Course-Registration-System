package Server.Controller;

/**
 * An interface to manage the JDBC Driver, URL, and username/password for the mySQL connection
 */
public interface DBCredentials {
	
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/CourseRegistration";

	   //  Database credentials
	   static final String USERNAME = "root";
	   static final String PASSWORD = "JesselWong1";

}
