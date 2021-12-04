package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utilities.ErrorHandler;

import model.Content;
import model.User;


public class ContentDAO {
	private Connector conn = new Connector();
	
	public ContentDAO() {}
	
	private ErrorHandler er = new ErrorHandler();
	

	
	private static final String INSERT_CONTENT_SQL = "INSERT INTO content" 
			+ "  (title, brief, content, author_id, CreatedDate) VALUES " 
			+ " (?, ?, ?, ?, current_timestamp);";
	
	private static final String UPDATE_CONTENT_SQL = "update content set title=?, brief=?,  content=?, author_id=? , UpdatedDate=current_timestamp where id=?;";
	
	
	private static final String SELECT_CONTENT_SQL = "select * from content;";
	
	
	
	private static final String SELECT_CONTENT_SQL_BY_ID = "select * from content where id=?;";
	
	private static final String DELETE_CONTENT_SQL = "delete from content where id=?;";
	
	public boolean insertContent(Content insertContent) throws SQLException {
    	boolean rowInserted;
    	
        // try-with-resource statement will auto close the connection.
        try (Connection connection = conn.getConnection(); 
        		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTENT_SQL)) {
            preparedStatement.setString(1, insertContent.getTitle());
            preparedStatement.setString(2, insertContent.getBrief());
            preparedStatement.setString(3, insertContent.getContent());
            preparedStatement.setString(4, insertContent.getAuthorID());
            
            rowInserted = (preparedStatement.executeUpdate() > 0);
        }
        return rowInserted;
    }
	
	
	
	public boolean updateContent(Content content) throws SQLException {
        boolean rowUpdated;
        Date CreatedDate= new Date(System.currentTimeMillis());
        
        try (Connection connection = conn.getConnection(); 
        		PreparedStatement statement = connection.prepareStatement(UPDATE_CONTENT_SQL);) {
        	
            statement.setString(1, content.getTitle());
            statement.setString(2, content.getBrief());
            statement.setString(3, content.getContent());
            statement.setInt(4, Integer.parseInt(content.getAuthorID()));
            statement.setInt(5, content.getId());
            
            
            System.out.println(statement);
            
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
	
	
	public boolean deleteContent(int id) throws SQLException {
        boolean rowUpdated;
        Date CreatedDate= new Date(System.currentTimeMillis());
        
        try (Connection connection = conn.getConnection(); 
        		PreparedStatement statement = connection.prepareStatement(DELETE_CONTENT_SQL);) {
            statement.setInt(1, id );
  
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
	
	public ArrayList<Content> selecContent() {
		ArrayList<Content> contents = new ArrayList<Content>();
		// Step 1: Establishing a Connection
		try (Connection connection = conn.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTENT_SQL);) {

			
			// Step 3: Execute the query or update query
			ResultSet rs= preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			
			  while (rs.next()) { 
				  int id = Integer.parseInt(rs.getString("id")); 
				  String title = rs.getString("title"); 
				  String brief = rs.getString("brief"); 
				  String content = rs.getString("content");
				  String author_id = rs.getString("author_id");
				  String createDate = rs.getString("CreatedDate");
				  String updateDate = rs.getString("UpdatedDate");
				  Content newContent = new Content(
						  		id, title, brief,  content, author_id, createDate, updateDate
						  );
				  contents.add(newContent);

			  }
			 
		} catch (SQLException e) {
			er.printSQLException(e);
		}
		return contents;
    }
	
	
	public Content getContentByID(int content_id) throws SQLException {

		Content selectedContent = new Content();
        // try-with-resource statement will auto close the connection.
        try (Connection connection = conn.getConnection(); 
        		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTENT_SQL_BY_ID)) {
            preparedStatement.setInt(1, content_id);
            System.out.println(preparedStatement);
         // Step 3: Execute the query or update query
		ResultSet rs = preparedStatement.executeQuery();
		// Step 4: Process the ResultSet object.
		
		  while (rs.next()) { 
			  int id = Integer.parseInt(rs.getString("id")); 
			  String title = rs.getString("title"); 
			  String brief = rs.getString("brief"); 
			  String content = rs.getString("content");
			  String author_id = rs.getString("author_id");
			  String createDate = rs.getString("CreatedDate");
			  String updateDate = rs.getString("UpdatedDate");
			  selectedContent = new Content(
					  		id, title, brief,  content, author_id, createDate, updateDate
					  );
		
		  }
		  
        }
        catch (SQLException e) {
			er.printSQLException(e);
		}
        
        return selectedContent;
        
    }
}
