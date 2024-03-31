<%-- 
    Document   : outcome
    Created on : 26 Mar 2024, 20:08:21
    Author     : taarb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Outcome Page</title>
    </head>
    <body>
        <h1>Outcome</h1>
        <%
            String question = (String) session.getAttribute("question");
            String userAnswer = (String) request.getAttribute("userAnswer");
            String correctAnswer = (String) request.getAttribute("correctAnswer");
            String outcome = (String) request.getAttribute("outcome");
        %>
        <p>
            Below is the outcome.
        </p>
        <table>
            <tr>
                <td>Question</td>
                <td><%=question%></td>
            </tr>
            <tr>
                <td>Answer by user: </td>
                <td><%=userAnswer%></td>
            </tr>
            <tr>
                <td>Correct Answer</td>
                <td><%=correctAnswer%></td>
            </tr>
            <tr>
                <td>Outcome</td>
                <td><%=outcome%></td>
            </tr>
        </table>
            
            <p>
                <a href="GetQuestionServlet.do">Continue</a> <br>
                or <br>
                 <a href="summary.jsp">summary</a> <br>
            </p>
    </body>
</html>
