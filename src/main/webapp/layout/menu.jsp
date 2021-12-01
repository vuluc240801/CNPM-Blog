<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
<div class="collapse navbar-collapse navbar-ex1-collapse">
	<ul class="nav navbar-nav side-nav">
		<li>
			<form class="navbar-form" role="search">
				<div class="input-group">
					<input id="system-search" type="text" class="form-control" placeholder="Search..."
						name="q">
					<div class="input-group-btn">
						<button class="btn btn-default" type="submit">
							<i class="fa fa-search"></i>
						</button>
					</div>
				</div>
			</form>
		</li>
		<li><a href="ViewContentServlet" id="need"><i class="fa fa-table""></i> View
				Contents</a></li>
		<li><a href="CreateAndEditContentServlet?mode=0"><i class="fa fa-pencil-square-o"></i> Form
				Content</a></li>
	</ul>
</div>
<script src="resources/js/search.js" type="text/javascript"></script>

<script src="resources/js/datatable.js" type="text/javascript"></script>
<!-- /.navbar-collapse -->

