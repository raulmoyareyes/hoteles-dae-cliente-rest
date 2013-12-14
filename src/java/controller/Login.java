/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Operador;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

/**
 *
 * @author raul
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
        defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
        Client cliente = Client.create(defaultClientConfig);

        /// comprobaciones para redirigir
        if (request.getParameter("login") != null) {

            WebResource recurso = cliente.resource("http://localhost:8080/Hoteles-DAE-REST/recursos/login").queryParam("usuario", request.getParameter("cif"));
            ClientResponse responseJSON = recurso.accept("application/json").get(ClientResponse.class);

            Operador op = responseJSON.getEntity(Operador.class);

            if (op != null) {
                request.getSession().setAttribute("operador", op);
                response.sendRedirect("operador/listadousuarios");
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login/index.jsp");
                rd.forward(request, response);
            }
        } else {

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login/index.jsp");
            rd.forward(request, response);
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
        processRequest(request, response);
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
