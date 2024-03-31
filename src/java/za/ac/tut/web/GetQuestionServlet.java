/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  
import za.ac.tut.module.bl.QuizSBLocal;

/**
 *
 * @author taarb
 */
public class GetQuestionServlet extends HttpServlet {
@EJB QuizSBLocal sb;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        
        int num1 = sb.generateNumber();
        int num2 = sb.generateNumber();
        String question = sb.generateQuestion(num1, num2);
        
        session.setAttribute("num1", num1);
        session.setAttribute("num2", num2);
        session.setAttribute("question", question);
        
        RequestDispatcher disp = request.getRequestDispatcher("ask_question.jsp");
        disp.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
    }
}
