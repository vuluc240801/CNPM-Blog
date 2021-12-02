<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="model.Content" %>
<%Content ct =(Content)session.getAttribute("content"); %>
<%String mode =(String)session.getAttribute("mode"); %>





<div id="page-wrapper">
<h2><%=mode%> Content</h2>
<hr />
<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">Contents Form Elements</h3>
  </div>
  
  


  <div class="panel-body">
    <form
      action="#CreateAndEditContentServlet"
      accept-charset="UTF-8"
      role="form"
      id="validate_add_content_form"
      method="post"
    >
       <input type="hidden" id="id" name="id" value=<%= ct.getId() %>>
       <input type="hidden" id="mode" name="mode" value=<%=mode%>>
      <fieldset>
        <label>Title</label>
        <div class="form-group">
          <input
            id = 'title'
            class="form-control"
            placeholder="Enter the title"
            name="title"
            type="text"
          />
        </div>

        <label>Brief</label>
        <div class="form-group">
          <textarea id="brief" class="form-control" name="brief" rows="3"></textarea>
        </div>

        <label>Content</label>
        <div class="form-group">
          <textarea id="content" class="form-control" name="content" rows="6"></textarea>
        </div>
        <button class="btn btn-default" type="submit" value="Add">
          Submit Button
        </button>
        <button class="btn btn-default"  onclick="fillData(rawData)">Reset Button</button>
      </fieldset>
    </form>
  </div>



<script type="text/javascript">
	var rawData = {
			"title" : "<%= ct.getTitle()%>",
			"brief" : "<%= ct.getBrief()%>",
			"content" : "<%= ct.getContent()%>",
	};
	
	
	const fillData = (data) => {
		for (const [key, value] of Object.entries(data)) {
			  if (value != 'null') {
			    $("#"+key).val(value);
			  }
			}
	}
	
	fillData(rawData);
	
</script>

</div>


</div>