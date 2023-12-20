<%@page import="Model.StudentDto1"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Student Information</title>
    <!-- Bootstrap CSS link -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .mt-4 {
            margin-top: 1.5rem;
        }

        
        tbody tr.percentage-below-40 td {
            color: red; 
            font-weight: bold; 
        }

        
        tbody tr:not(.percentage-below-40) td {
            color: green; 
            font-weight: bold; 
        }
    </style>
</head>
<body>
    <% Object data = request.getAttribute("STUDENT");
    ArrayList<StudentDto1> result1 = (ArrayList<StudentDto1>) data;
    %>

    <div class="container mt-4">
        <h2>Student Information</h2>
        <table class="table table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>ROLL NUMBER</th>
                    <th>EMAIL ID</th>
                    <th>CONTACT NUMBER</th>
                    <th>YEAR OF PASSOUT</th>
                    <th>TOTAL MARKS</th>
                    <th>OUT OF MARKS</th>
                    <th>PERCENTAGE</th>
                </tr>
            </thead>
            <tbody>
                <% for (StudentDto1 output1 : result1) { %>
                    <tr class="<%=(output1.getTotalMarks() * 100.0 / output1.getOutOfMarks() < 40) ? "percentage-below-40" : "" %>">
                        <td><%= output1.getRollNumber() %></td>
                        <td><%= output1.getEmailId() %></td>
                        <td><%= output1.getContactNumber() %></td>
                        <td><%= output1.getYearOfPassOut() %></td>
                        <td><%= output1.getTotalMarks() %></td>
                        <td><%= output1.getOutOfMarks() %></td>
                        <% double per = (output1.getTotalMarks() * 100.0 / output1.getOutOfMarks()); %>
                        <td><%= per %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>

</body>
</html>
