<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Add New Employee</title>
<style>
body {
font-family: Arial, sans-serif;
margin: 0;
padding: 20px;
text-align: center;
}
h2 {
color: #333;
}
form {
max-width: 600px;
margin: 20px auto;
padding: 20px;
background-color: #f9f9f9;
border: 1px solid #ddd;
border-radius: 8px;
box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}
table {
width: 100%;
border-collapse: collapse;
margin-bottom: 20px;
}
th, td {
border: 1px solid #ddd;
padding: 12px;
text-align: left;
}
th {
background-color: #e9e9e9;
font-weight: bold;
}
input[type="text"] {
width: calc(100% - 24px);
padding: 10px;
box-sizing: border-box;
border: 1px solid #ccc;
border-radius: 4px;
}
.form-actions {
text-align: center;
}
input[type="submit"] {
padding: 12px 24px;
background-color: #007bff;
color: white;
border: none;
border-radius: 5px;
cursor: pointer;
font-size: 16px;
transition: background-color 0.3s ease;
}
input[type="submit"]:hover {
background-color: #0056b3;
}
.success-message {
color: #28a745;
font-weight: bold;
margin-bottom: 15px;
}
.employee-table {
margin-top: 30px;
text-align: center;
}
</style>
</head>
<body>
<h2>Add New Employee</h2>
<form action="add_employee" method="post">
<table>
<thead>
<tr>
<th>Employee Name</th>
<th>Salary</th>
</tr>
</thead>
<tbody>
<tr>
<td><input type="text" name="sname" required></td>
<td><input type="text" name="salary" required></td>
</tr>
</tbody>
</table>
<div class="form-actions">
<input type="submit" value="Submit">
</div>
</form>

<!-- Display success message and added employee details -->
<div class="employee-table">
<%
    // Check if the 'successMessage' attribute exists in the model
    String successMessage = (String) request.getAttribute("successMessage");
    if (successMessage != null) {
%>
    <h3 class="success-message"><%= successMessage %></h3>
    <table>
        <thead>
            <tr>
                <th>Employee Name</th>
                <th>Salary</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><%= ((com.anand.dto.EmployeeDto) request.getAttribute("addedEmployee")).getName() %></td>
                <td><%= ((com.anand.dto.EmployeeDto) request.getAttribute("addedEmployee")).getSalary() %></td>
            </tr>
        </tbody>
    </table>
<%
    }
%>
</div>
<a href="index.jsp">Back to Home</a>

</body>
</html>