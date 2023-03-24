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
		width:350px;
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
	ArrayList<TeamRegBean> al=(ArrayList<TeamRegBean>)request.getAttribute("team");
	Iterator<TeamRegBean> i=al.iterator();
	if(i.hasNext()){
		TeamRegBean pb=i.next();
%>
<div>
	<h2 align="center" style="color:blue;">Team Details</h2>
	<form action="up" method="post">
	<label>Team Name : </label><input type="text" value="<%=pb.getName() %>" name="name" readonly><br>
	<label>Division : </label><input type="text" value="<%=pb.getDivision() %>" name="div"><br>
	<label>Club : </label><input type="text" value="<%=pb.getClub() %>" name="club"><br>
	<label>Primary Name : </label><input type="text" value="<%=pb.getPrimaryName() %>" name="pname"><br>
	<label>Primary Number : </label><input type="text" value="<%=pb.getPrimaryNumber() %>" name="pnum"><br>
	<label>Primary Email  :</label><input type="text" value="<%=pb.getPrimaryEmail() %>" name="pmail"><br>
	<label>Secondary Name : </label><input type="text" value="<%=pb.getSccName() %>" name="sname"><br>
	<label>Secondary Number : </label><input type="text" value="<%=pb.getSccNumber() %>" name="snum"><br>
	<label>Secondary Email  :</label><input type="text" value="<%=pb.getSccEmail() %>" name="smail"><br>
	<input type="submit" name="sub" value="Modify" class="but">&emsp;&emsp;
	<input type="submit" name="sub" value="Delete" class="but">
	</form>
</div>
<%
	}
%>
</body>
</html>