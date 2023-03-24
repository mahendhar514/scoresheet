<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" import="scoresheet.ScheduleBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Schedule</title>
<style type="text/css">

body{
	background-image: url("cri.jpg");
	/* color: linear-gradient(45deg, #49a09d, #5f2c82);  */
	
	font-family: sans-serif;
	font-weight: 100;
}


#tab{
width:300px;
height:auto;
margin:auto;
box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;
}
.box{
float:right;
border:none;
border-radius:2px;
opacity:0.3s;
font:bold;
}

.button {
	background-color: green;
	border: none;
	color: red;
	padding: 15px 32px;
	text-decoration: none;
	display: inline;
	transition-duration: 0.4s;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	border-radius: 200px;
}
td, th {
    padding: 15px;
	background-color: rgba(255,255,255,0.2);
}
 
 th{
 	text-align: left;
 	color:black;
 }
 td{
 	color:4f4f4f;
 }
table {
    width: 800px;
	border-collapse: collapse;
	overflow: hidden;
	box-shadow: 0 0 20px rgba(0,0,0,0.1);
}

tbody {
	tr {
		&:hover {
			background-color: rgba(255,255,255,0.3);
		}
	}
	td {
		position: relative;
		&:hover {
			&:before {
				content: "";
				position: absolute;
				left: 0;
				right: 0;
				top: -9999px;
				bottom: -9999px;
				background-color: rgba(255,255,255,0.2);
				z-index: -1;
			}
		}
	}
	
	#back{
		text-decoration:none;
	}
</style>
</head>
<body>
<a href="menu.html" id="back" ><button  class="button">Return</button></a>
<h3 align="center" >SCHEDULES</h3>
	<table align="center">
		 <tr>
		    <th>Team1</th>
		    <th>Team2</th>
		    <th>Day</th>
		    <th>Date
		    	<form action="viewsch" method="post">
					<input type="date" name="dates" required><br>
<!-- 					<input type="submit" value="view"  >
 -->					<button id="dview" role="button">views</button><br>
				</form>
		    </th>
		    <th>MatchCode</th>
		    <th>Time</th>
		    <th>Session</th>
		    <th>Division</th>
		    <th>Round</th>
	  	</tr>
		<tbody>
<%
ArrayList<ScheduleBean> al=(ArrayList<ScheduleBean>)session.getAttribute("schedule");
	Iterator<ScheduleBean> it=al.iterator();
	int i=0;
	while(it.hasNext()){ 
		ScheduleBean sb=it.next();
	%>
		<tr>
		    <td><%=sb.getTeam1() %></td>
		    <td><%=sb.getTeam2() %></td>
		    <td><%=sb.getDay() %></td>
		    <td><%=sb.getDate() %></td>
		    <td><%=sb.getCode() %></td>
		    <td><%=sb.getTime() %></td>
		    <td><%=sb.getSeason() %></td>
		    <td><%=sb.getDivison() %></td>
		    <td><%=sb.getRound() %></td>
  		</tr>
	
			<%
			
		/* out.println(++i); */
}
	
%>
	</tbody>
	</table>
</body>
</html>