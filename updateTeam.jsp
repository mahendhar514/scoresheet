<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="scoresheet.TeamRegBean"
    import="java.util.*"
    %>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>Player Details</title>
<style>
	body  {
  background-image: url("cri.jpg");
}
	div {
		background-color:lightcyan;
		margin:auto;
		margin-top:150px;
		width:250px;
		padding:20px;
		border-radius:20px;
	}
	h2{
		margin-bottom:15px;
	}
	label{
		font-size:20px;
		margin-bottom:30px;
	}
	.but{
	font-size:20px;
	width:70px;
	padding:3px;
	border:none;
	border-radius:7px;
	cursor:pointer;
	margin-top:20px;
	margin-left:50px;
	background-color:blue;
	color:white;
	}
</style>
</head>
<body>
<%
	ArrayList<TeamRegBean> al=(ArrayList<TeamRegBean>)request.getAttribute("reg");
	Iterator<TeamRegBean> i=al.iterator();
	if(i.hasNext()){
		TeamRegBean pb=i.next();
%>
<div>
	<h2>Team Details</h2>
	<label>Team Name : </label><%=pb.getName() %><br>
	<label>Division : </label><%=pb.getDivision() %><br>
	<label>Club : </label><%=pb.getClub() %><br>
	<label>Primary Name : </label><%=pb.getPrimaryName() %><br>
	<label>Primary Number : </label><%=pb.getPrimaryNumber() %><br>
	<label>Primary Email  :</label><%=pb.getPrimaryEmail() %>
	<label>Secondary Name : </label><%=pb.getSccName() %><br>
	<label>Secondary Number : </label><%=pb.getSccNumber() %><br>
	<label>Secondary Email  :</label><%=pb.getSccEmail() %><br>
	<a href="index.html"><button class="but">Return</button></a>
</div>
<%
	}
%>
</body>
</html>