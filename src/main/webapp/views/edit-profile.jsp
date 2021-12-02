<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


	
            

<div id="page-wrapper">
<h2 id="loading"></h2>
<h2>Edit Profile</h2>
<hr />
<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">Profile Form Elements</h3>
  </div>

  <div class="panel-body">
    <form action="Profile" role="form" id="validate_edit_profile_form" method="post">
      <fieldset>
        <label>First Name</label>
        <div class="form-group">
          <input
            id = "firstname" 
            class="form-control"
            placeholder="Enter the first name"
            name="firstName"
            type="text"
          />
        </div>
        <label>Last Name</label>
        <div class="form-group">
          <input
            id = "lastname" 
            class="form-control"
            placeholder="Enter the last name"
            name="lastName"
            type="text"
            value=""
          />
        </div>
        <label>Email</label>
        <div class="form-group">
          <input
            id = "email" 
            class="form-control"
            name="email"
            type="email"
            value=""
            readonly
          />
        </div>

        <label>Phone</label>
        <div class="form-group">
          <input
            id = "phone" 
            class="form-control"
            placeholder="Enter your phone number"
            name="phone"
            type="text"
            value=""
          />
        </div>
        <label>Description</label>
        <div class="form-group">
          <textarea  id = "description"  class="form-control" name="description" >
          </textarea>
        </div>
        <button class="btn btn-default" type="submit" value="Add">
          Submit Button
        </button>
        <button class="btn btn-default" onclick="fillData(rawData)">Reset Button</button>
      </fieldset>
    </form>
  </div>
</div>



<%@ page import="model.User" %>

<%User user =(User)session.getAttribute("user"); %>

<script type="text/javascript">
	var rawData = {
			"firstname" : "<%= user.getFirstname()%>",
			"lastname" : "<%= user.getLastname()%>",
			"email" : "<%= user.getEmail()%>",
			"phone" : "<%= user.getPhone()%>",
			"description" : "<%= user.getDescription()%>",
	};
	
	
	const fillData = (data) => {
		for (const [key, value] of Object.entries(data)) {
			  if (value != 'null') {
			    $("#"+key).val(value);
			  }
			  console.log(value);
			}
	}
	
	fillData(rawData);
	
</script>
	<!-- /.container-fluid -->
</div>