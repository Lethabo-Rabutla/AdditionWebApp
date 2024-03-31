<%-- 
    Document   : ask_question
    Created on : 26 Mar 2024, 19:03:23
    Author     : taarb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Question Page</title>
    </head>
    <body>
        <h1>question</h1>
        <%
            String computerName = pageContext.getServletContext().getInitParameter("computer_name");
            String username = pageContext.getServletContext().getInitParameter("user_name");
            String question = (String)session.getAttribute("question");
        %>
        
        <form action="OutcomeServlet.do" method="POST">
            <table>
                <tr>
                    <td><%=computerName%></td>
                    <td><%=question%></td>
                </tr>
                <tr>
                    <td><%=username%></td>
                    <td><input type="text" name="answer" required=""/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="SUBMIT"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
