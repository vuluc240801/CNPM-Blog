package dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.User;

public class UserDAO {
	
    private Connector conn = new Connector();
    
    private static final String INSERT_MEMBER_SQL = "INSERT INTO member" 
    			+ "  (username, email, password, CreatedDate) VALUES " 
    			+ " (?, ?, ?, current_timestamp);";

    private static final String SELECT_MEMBER = "select username, email, password from member "
    		+ "where username=? or email=? and password=?";
    private static final String UPDATE_USERS_SQL = "update member set firstname=?, lastname=?,  phone=?, description=?, UpdatedDate=? where email=?;";
    
    private static final String GET_MEMBER_BY_USERNAME = "select * from member "
    		+ "where email=?";
    
    
    public UserDAO() {}
    
    public boolean insertUser(User user) throws SQLException {
    	boolean rowInserted;
    	
        // try-with-resource statement will auto close the connection.
        try (Connection connection = conn.getConnection(); 
        		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MEMBER_SQL)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            
            rowInserted = (preparedStatement.executeUpdate() > 0);
        }
        return rowInserted;
    }
    
    
    public User getUserInfo(String email) throws SQLException {

    	User userInfo = new User();
        // try-with-resource statement will auto close the connection.
        try (Connection connection = conn.getConnection(); 
        		PreparedStatement preparedStatement = connection.prepareStatement(GET_MEMBER_BY_USERNAME)) {
            preparedStatement.setString(1, email);
            System.out.println(preparedStatement);
         // Step 3: Execute the query or update query
		ResultSet rs = preparedStatement.executeQuery();
		// Step 4: Process the ResultSet object.
		
		  while (rs.next()) { 
			  String firstname = rs.getString("firstname");
			  String lastname = rs.getString("lastname");
			  String phone = rs.getString("phone");
			  String description = rs.getString("description");
			  
			  System.out.println("DAO " + firstname);
			  userInfo.setEmail(email);
			  userInfo.setFirstname(firstname);
			  userInfo.setLastname(lastname);
			  userInfo.setPhone(phone);
			  userInfo.setDescription(description);  
			  
		
		  }
		  
        }
        catch (SQLException e) {
			printSQLException(e);
		}
        
        return userInfo;
        
    }
    
    public boolean selectUser(User user) {
    	boolean flag = false;
		// Step 1: Establishing a Connection
		try (Connection connection = conn.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MEMBER);) {
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			
			// Step 3: Execute the query or update query
			flag = preparedStatement.executeQuery().first();

			// Step 4: Process the ResultSet object.
			/*
			 * while (rs.next()) { String name = rs.getString("username"); String email =
			 * rs.getString("email"); String password = rs.getString("password"); user = new
			 * User(name, email, password); }
			 */
		} catch (SQLException e) {
			printSQLException(e);
		}
		return flag;
    }
    
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        Date CreatedDate= new Date(System.currentTimeMillis());
        
        try (Connection connection = conn.getConnection(); 
        		PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getFirstname());
            statement.setString(2, user.getLastname());
            statement.setString(3, user.getPhone());
            statement.setString(4, user.getDescription());
            statement.setDate(5, CreatedDate);
            statement.setString(6, user.getEmail());
            
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
