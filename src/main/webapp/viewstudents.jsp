<%@ page import="java.sql.*" %>

<html>
<head>
<title>All Students</title>
</head>
<body>

<h2>ALL STUDENTS</h2>

<table border="1" cellpadding="10">
<tr>
<th>ID</th>
<th>Name</th>
<th>City</th>
<th>Marks</th>
</tr>

<%
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection(
"jdbc:oracle:thin:@localhost:1521:XE",
"HR",
"hr"
);

PreparedStatement ps = conn.prepareStatement("SELECT * FROM student");
ResultSet rs = ps.executeQuery();

while(rs.next()) {
%>

<tr>
<td><%= rs.getInt("id") %></td>
<td><%= rs.getString("name") %></td>
<td><%= rs.getString("city") %></td>
<td><%= rs.getInt("marks") %></td>
</tr>

<%
}
conn.close();
%>

</table>
</body>
</html>
