<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tiles:importAttribute name="stylesheets"/>
<tiles:importAttribute name="javascripts"/>
<!DOCTYPE html>
<html>
<head>
<title><tiles:getAsString name="title" /></title>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
    
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js" type="text/javascript"></script>

    
    <script type="text/javascript" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
    
	    <!-- stylesheets -->
    <c:forEach var="css" items="${stylesheets}">
        <link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
    </c:forEach>
    <!-- end stylesheets -->
    
    <!-- javascripts -->
    <c:forEach var="js" items="${javascripts}">
    	<script type="text/javascript" src="<c:url value="${js}"/>"></script>
    </c:forEach>
    
    <!-- end js -->
</head>
<body>
<div id="wrapper">
	<header>
		<tiles:insertAttribute name="header" />
	</header>
	
	<div>
		<aside>
			<tiles:insertAttribute name="menu" />
		</aside>
		<section>
			<tiles:insertAttribute name="body" />
		</section>
	</div>
</div>

<script type="text/javascript">
var viewContentBar = document.querySelector('#view_content');
var formContentBar = document.querySelector('#form_content');
var editProfileBar = document.querySelector('#edit_profile');
var viewContent = document.querySelector('#page-wrapper');
viewContentBar.onclick = function(e) {
    viewContent.innerHTML = '<h2 >Loading</h2>';
    e.preventDefault();
    var serviceURL = '/WebMVCProject/ViewContentServlet';
    var model = null;
    setTimeout(function() {
        $.ajax({
            type: "GET",
            url: serviceURL,
            data: JSON.stringify(model),
            contentType: "application/json; charset=utf-8",
            dataType: 'html',
            success: function(data) {
                $('body').load(serviceURL);
            },
            error: function(data, errorThrown) {
                alert(errorThrown);
            }
        });
    }, 3000);
}
formContentBar.onclick = function(e) {
    viewContent.innerHTML = '<h2 >Loading</h2>';
    e.preventDefault();
    var serviceURL = '/WebMVCProject/CreateAndEditContentServlet?mode=0';
    var model = null;
    setTimeout(function() {
        $.ajax({
            type: "GET",
            url: serviceURL,
            data: JSON.stringify(model),
            contentType: "application/json; charset=utf-8",
            dataType: 'html',
            success: function(data) {
                $('body').load(serviceURL);
            },
            error: function(data, errorThrown) {
                alert(errorThrown);
            }
        });
    }, 3000);
}
editProfileBar.onclick = function(e) {
    viewContent.innerHTML = '<h2 >Loading</h2>';
    e.preventDefault();
    var serviceURL = '/WebMVCProject/Profile';
    var model = null;
    setTimeout(function() {
        $.ajax({
            type: "GET",
            url: serviceURL,
            data: JSON.stringify(model),
            contentType: "application/json; charset=utf-8",
            dataType: 'html',
            success: function(data) {
                $('body').load(serviceURL);
            },
            error: function(data, errorThrown) {
                alert(errorThrown);
            }
        });
    }, 3000);
}
</script>

</body>
</html>