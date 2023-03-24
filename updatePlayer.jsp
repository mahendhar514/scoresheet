<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="scoresheet.PlayerRegBean"
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
		width:300px;
		padding:30px;
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
	ArrayList<PlayerRegBean> al=(ArrayList<PlayerRegBean>)request.getAttribute("play");
	Iterator<PlayerRegBean> i=al.iterator();
	if(i.hasNext()){
		PlayerRegBean pb=i.next();
%>
<div>
	<h2>Player Details</h2>
	<label>Player Name : </label><%=pb.getName() %><br>
	<label>IC : </label><%=pb.getIc() %><br>
	<label>Team : </label><%=pb.getTeam() %><br>
	<label>Age : </label><%=pb.getAge() %><br>
	<label>Phone No. : </label><%=pb.getPhno() %><br>
	<label>Mail Id : </label><%=pb.getMail() %>
	<a href="index.html"><button class="but">Return</button></a>
</div>
<%
	}
%>
</body>
</html>