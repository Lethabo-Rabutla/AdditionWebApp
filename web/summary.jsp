<%-- 
    Document   : summary
    Created on : 26 Mar 2024, 20:22:45
    Author     : taarb
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Summary Page</title>
    </head>
    <body>
        <h1>Summary</h1>
        <%
            List<String> questions = (List<String>)session.getAttribute("question");
            List<String> answers = (List<String>)session.getAttribute("answers");
            List<String> userAnswers = (List<String>)session.getAttribute("userAnswers");
            int numberQuestionAsked = (Integer) session.getAttribute("numberQuestionAsked");
            int numberCorrectAnswer = (Integer) session.getAttribute("numberCorrectAnswer");
            int numberWrongAnswer = (Integer) session.getAttribute("numberWrongAnswer");
        %>
        <p>
            Below is the summary.
        </p>
        <table>
            <tr>
                <td>number of question asked:</td>
                <td><%=numberQuestionAsked%></td>
            </tr>
            <tr>
                <td>Number of correct answers.</td>
                <td><%=numberCorrectAnswer%></td>
            </tr>
            <tr>
                <td>Number of wrong answers.</td>
                <td><%=numberWrongAnswer%></td>
            </tr>
            <%
                if (numberQuestionAsked > 0) {
                        for (int i = 0; i < questions.size(); i++) {
                                String question = questions.get(i);
                                String answer = answers.get(i);
                                String userAnswer = userAnswers.get(i);
                                %>
                                <tr>
                                    <td>Question <%=i+1%></td>
                                    <td><%=question%></td>
                                </tr>
                                <tr>
                                    <td>Answer:</td>
                                    <td><%=answer%></td>
                                </tr>
                                <tr>
                                    <td>User Answer:</td>
                                    <td><%=userAnswers%></td>
                                </tr><%
                            }
                    }
            %>
        </table>
        <p>
            <a href="GetQuestionServlet.do">continue</a> <br> or <br> <a href="EndSessionServlet.do">End Session</a>
        </p>
    </body>
</html>
