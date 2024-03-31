/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.model.bl.LogInDetailsSBLocal;

/**
 *
 * @author taarb
 */
public class StartSessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
@EJB private LogInDetailsSBLocal sb;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        
        //perform business logic here
        
        String correctUsername = getServletContext().getInitParameter("user_name");
        String correctpassword = getServletContext().getInitParameter("correct_password");
        
        Boolean outcome = sb.checkLogInDetails(username, password, correctUsername, correctpassword);
        
        if (outcome) {
            HttpSession session = request.getSession(true);
            initialiazeSession(session);
            RequestDispatcher disp = request.getRequestDispatcher("session_started.jsp");
            disp.forward(request, response);
        }else{
            response.sendRedirect("login.html");
        }
    }

    private void initialiazeSession(HttpSession session) {
        
        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        List<String> userAnswers = new ArrayList<>();
        Integer numberQuestionAsked = 0, numberCorrectAnswers = 0, numberWrongAnswers = 0;
        
        session.setAttribute("question", questions);
        session.setAttribute("answer", answers);
        session.setAttribute("userAnswer", userAnswers);
        session.setAttribute("numberQuestionAsked", numberQuestionAsked);
        session.setAttribute("numberCorrectAnswers", numberCorrectAnswers);
        session.setAttribute("numberWrongAnswers", numberWrongAnswers);
    }

}
