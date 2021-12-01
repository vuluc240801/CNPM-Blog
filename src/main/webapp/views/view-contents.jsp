<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div id="page-wrapper">
<h2>View Content</h2>
<hr />
<div class="panel panel-default">
  <div class="panel-heading">View Content List</div>
  <div class="panel-body">
    <table id="dataTable" class="table table-bordered table-striped table-responsive">
      <thead>
        <tr>
          <th>#</th>
          <th>Title</th>
          <th>Brief</th>
          <th>Created Date</th>
          <th class="text-center">Action</th>
        </tr>
      </thead>
      <tbody>
      
        <%@ page import="model.Content" %>  
        <%@ page import="java.util.ArrayList" %>
       <%
       ArrayList<Content> contents= (ArrayList<Content>)session.getAttribute("contents"); 
       System.out.println(contents.size());
       
		  for (Content content: contents) {   
		%>
		  <tr>
          <td><%= content.getId()%> </td>
          <td><%= content.getTitle()%></td>
          <td>
            <%= content.getContent()%>
          </td>
          <td><%= content.getCreateDate() %></td>
          <td class="text-center">
            <a class="btn btn-info btn-xs" href="CreateAndEditContentServlet?content_id=<%=content.getId()%>&mode=1"
              ><span class="glyphicon glyphicon-edit"></span> Edit</a
            >
            <a href="#" class="btn btn-danger btn-xs"
              ><span class="glyphicon glyphicon-remove"></span> Del</a
            >
          </td>
        </tr>
		<%}
		%>

        
      </tbody>
    </table>
  </div>
</div>




</div>