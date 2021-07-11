/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0004<br>
 * Digital News<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-05-18    1.0        NangNN           First Version<br>
 */
package controller;

import dao.DigitalDAO;
import dao.impl.DigitalDAOImpl;
import entity.News;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class uses function in <code>DigitalDAO</code> to get the list of 6
 * most recent digital news then forward to <code>HomePage.jsp</code>
 *
 * @author nangnnhe130538
 */
@WebServlet(name = "  HomeControl", urlPatterns = {"/HomeControl"})
public class HomeController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods. 
     * Use <code>getTop</code> function in <code>DigitalDAO</code> class to get 
     * the list of 6 most recent digital news then forward 
     * to the page <code>HomePage.jsp</code>.
     *
     * @param request it is a object of
     * <code>javax.servlet.http.HttpServletRequest</code>
     * @param response it is a object of
     * <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            DigitalDAO digitalDAO = new DigitalDAOImpl();
            List<News> top6News = digitalDAO.getTop(6);
            request.setAttribute("top6", top6News);
            request.getRequestDispatcher("HomePage.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Call <code>processRequest</code> method
     *
     * @param request it is a object of
     * <code>javax.servlet.http.HttpServletRequest</code>
     * @param response it is a object of
     * <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Call <code>processRequest</code> method
     *
     * @param request it is a object of
     * <code>javax.servlet.http.HttpServletRequest</code>
     * @param response it is a object of
     * <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
