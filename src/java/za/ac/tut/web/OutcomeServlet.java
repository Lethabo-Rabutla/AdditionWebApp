/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class OutcomeServlet extends HttpServlet {
@EJB QuizSBLocal sb;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String userAnswer = (String)request.getAttribute("answer");
        int num1 = (Integer)session.getAttribute("num1");
        int num2 = (Integer)session.getAttribute("num2");
        String correctAnswer = sb.getAnswer(num1, num2);
        
        String outcome = sb.determineOutcome(userAnswer, correctAnswer);
        updateSession(session,outcome,userAnswer,correctAnswer);
        
        request.setAttribute("userAnswer", userAnswer);
        request.setAttribute("correctAnswer", correctAnswer);
        request.setAttribute("outcome", outcome);
        
        RequestDispatcher disp = request.getRequestDispatcher("outcome.jsp");
        disp.forward(request, response);
    }

    private void updateSession(HttpSession session, String outcome, String userAnswer, String correctAnswer) {
        List<String> questions = (List<String>)session.getAttribute("questions");
        List<String> answers = (List<String>)session.getAttribute("answers");
        List<String> userAnswers = (List<String>)session.getAttribute("userAnswers");
        String question = (String)session.getAttribute("question");
        int numberQuestionAsked = (Integer)session.getAttribute("numberQuestionAsked");
        int numberCorrectAnswers = (Integer)session.getAttribute("numberCorrectAnswers");
        int numberWrongAnswers = (Integer)session.getAttribute("numberWrongAnswers");
        
        if(outcome.equals("Correct")){
            numberCorrectAnswers++;
            session.setAttribute("numberCorrectAnswers", numberCorrectAnswers);
        }else{
            numberWrongAnswers++;
            session.setAttribute("numberWrongAnswers", numberWrongAnswers);
        }
        
        questions.add(question);
        session.setAttribute("questions", questions);
        
        answers.add(correctAnswer);
        session.setAttribute("answers", answers);
        
        userAnswers.add(userAnswer);
        session.setAttribute("userAnswers", userAnswers);
        
        numberQuestionAsked++;
        session.setAttribute("numberQuestionAsked", numberQuestionAsked);
    }

  
}
