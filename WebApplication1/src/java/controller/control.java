/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.lyftApi;
import model.rideInfo;
import model.uberApi;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rohanarora
 */
public class control extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        String c = request.getParameter("from");
        String d = request.getParameter("to");
        
        int i = 0;
        String s =""; String t ="";
        for( i = 1; i < c.length();i++){
        if(c.charAt(i) != ','){
        String p = Character.toString(c.charAt(i));
        s = s + p;
         }
        else{break;}
        }
        for(int j = i + 2; j < c.length() - 1; j++){
        String p = Character.toString(c.charAt(j));
        t = t + p;
        }
        
         i = 0;
        String r =""; String n ="";
        for( i = 1; i < d.length();i++){
        if(d.charAt(i) != ','){
        String p = Character.toString(d.charAt(i));
        r = r + p;
         }
        else{break;}
        }
        for(int j = i + 2; j < d.length() - 1; j++){
        String p = Character.toString(d.charAt(j));
        n = n + p;
        }
        
        lyftApi l = new lyftApi();
        ArrayList arr1 = l.getPrice(s, t, r, n);
        uberApi u = new uberApi();
        ArrayList arr2 = u.getPrice(s, t, r, n);
        response.setContentType("text/html;charset=UTF-8");
        
        request.setAttribute("uber", arr2);
        request.setAttribute("lyft", arr1);
            RequestDispatcher asd =  request.getRequestDispatcher("result.jsp");
            asd.forward(request, response);
            
        
        
        try (PrintWriter out = response.getWriter()) {
            //out.println(c);
           // out.println("<br>"+ d );//+ "<br>" + i  + "<br>" + s + "<br>" + t + "<br>" + r + "<br>" + n);
            /*Iterator itr = arr2.iterator();
                 while(itr.hasNext()){
                     rideInfo r = (rideInfo) itr.next();
                 out.println(r.getrideType() + " : " + r.getprice() + "<br>");
                 }
                 out.println("<br>");
                 out.println("<br>");
                 Iterator itr1 = arr1.iterator();
                 while(itr1.hasNext()){
                     rideInfo r = (rideInfo) itr1.next();
                 out.println(r.getrideType() + " : " + "$" + r.getpriceMin() + "-" + r.getpriceMax() + "<br>");
                 }
        
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet control</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet control at " + request.getContextPath() + "</h1>" + c + d);
            out.println("</body>");
            out.println("</html>");*/
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(control.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(control.class.getName()).log(Level.SEVERE, null, ex);
        }
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
