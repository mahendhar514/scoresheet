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
	ArrayList<PlayerRegBean> al=(ArrayList<PlayerRegBean>)request.getAttribute("player");
	Iterator<PlayerRegBean> i=al.iterator();
	if(i.hasNext()){
		PlayerRegBean pb=i.next();
%>
<div>
	<h2>Player Details</h2>
	<form action="playermodify" method="post">
	<label>Player Name : </label><input type="text" value="<%=pb.getName() %>" name="name"><br>
	<label>IC : </label><input type="text" value="<%=pb.getIc() %>" name="ic"><br>
	<label>Team : </label><input type="text" value="<%=pb.getTeam() %>" name="team"><br>
	<label>Age : </label><input type="text" value="<%=pb.getAge() %>" name="age"><br>
	<label>Phone No. : </label><input type="text" value="<%=pb.getPhno() %>" name="phno"><br>
	<label>Mail Id : </label><input type="text" value="<%=pb.getMail() %>" name="email">
	<input type="submit" name="sub" value="Modify" class="but">&emsp;
	<input type="submit" name="sub" value="Delete" class="but" onclick="deleteCon()">
	</form>
</div>
<%
	}
%>
 <script>
	function deleteCon(){
	const res=confirm("Are you want to delete?");
	if(res){
		document.getElementById("delete").click();
		}
	}
 </script>
</body>
</html>