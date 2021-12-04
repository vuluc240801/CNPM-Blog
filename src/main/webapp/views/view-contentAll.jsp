<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div id="page-wrapper">
	<div style="margin-left:50px">
	<h2>View Content All</h2>
	<hr style="width:220px;margin-left:0;height:2px;border:none;color:#828282;background-color:#828282;"/>
	</div>
	<div class="">

		<div class="">

			<%@ page import="model.Content"%>
			<%@ page import="java.util.ArrayList"%>
			<%
			ArrayList<Content> contents = (ArrayList<Content>) session.getAttribute("contents");
			System.out.println(contents.size());

			for (Content content : contents) {
			%>

			<div style="margin-left:50px">
			<p style="font-style:italic;font-size:24px;font-family:Times New Roman;color:#639cb4;"><%=content.getTitle()%></p>
			<p style="font-size:16px;font-family:Times New Roman;color:#828282;"><%=content.getCreateDate()%></p>
			<p style="font-size:20px;font-family:Times New Roman;word-break: break-word;"><%=content.getContent()%></p>
			</div>
			<br> <br>

			<%
			}
			%>
		</div>
	</div>




</div>