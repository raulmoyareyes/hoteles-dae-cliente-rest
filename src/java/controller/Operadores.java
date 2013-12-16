/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.Base64;
import com.sun.xml.xsom.impl.util.Uri;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.Hotel;
import modelos.Operador;
import modelos.Reserva;
import modelos.Usuario;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

/**
 *
 * @author raul
 */
@WebServlet(name = "Operador", urlPatterns = {"/operador/*"})
public class Operadores extends HttpServlet {

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

        String action = (request.getPathInfo() != null ? request.getPathInfo() : "");

        DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
        defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
        Client cliente = Client.create(defaultClientConfig);

        switch (action) {
            case "/listadousuarios": {

                WebResource recurso = cliente.resource("http://localhost:8080/Hoteles-DAE-REST/recursos/usuarios");
                ClientResponse responseJSON = recurso.accept("application/json").header("Authorization", "Basic " + new String(Base64.encode("11111111A:123456"))).get(ClientResponse.class);
                List<Usuario> usuarios = responseJSON.getEntity(List.class);
                request.setAttribute("usuarios", usuarios);
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/operador/usuarios/listado.jsp");
                rd.forward(request, response);
                break;
            }

            case "/nuevousuario": {
                if (request.getParameter("crear") != null) {
                    String nombre = request.getParameter("nombre");
                    String direccion = request.getParameter("direccion");
                    String dni = request.getParameter("dni");

                    WebResource recurso = cliente.resource("http://localhost:8080/Hoteles-DAE-REST/recursos/usuarios/" + dni);
                    recurso.type("application/json").put(ClientResponse.class, new Usuario(nombre, direccion, dni));

                    response.sendRedirect("/Hoteles-DAE-cliente-REST/operador/listadousuarios");
                } else if (request.getParameter("cancelar") != null) {
                    response.sendRedirect("/Hoteles-DAE-cliente-REST/operador/listadousuarios");
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/operador/usuarios/nuevo.jsp");
                    rd.forward(request, response);
                }
                break;
            }

            case "/modificarusuario": {
                if (request.getParameter("modificar") != null) {
                    String nombre = request.getParameter("nombre");
                    String direccion = request.getParameter("direccion");
                    String dni = request.getParameter("dni");

                    WebResource recurso = cliente.resource("http://localhost:8080/Hoteles-DAE-REST/recursos/usuarios/" + dni);
                    recurso.type("application/json").post(ClientResponse.class, new Usuario(nombre, direccion, dni));

                    response.sendRedirect("/Hoteles-DAE-cliente-REST/operador/listadousuarios");

                } else if (request.getParameter("cancelar") != null) {
                    response.sendRedirect("/Hoteles-DAE-cliente-REST/operador/listadousuarios");
                } else {
                    WebResource recurso = cliente.resource("http://localhost:8080/Hoteles-DAE-REST/recursos/usuarios/" + (String) request.getParameter("dni"));
                    ClientResponse responseJSON = recurso.accept("application/json").get(ClientResponse.class);

                    Usuario usuario = responseJSON.getEntity(Usuario.class);
                    request.setAttribute("usuario", usuario);
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/operador/usuarios/modificar.jsp");
                    rd.forward(request, response);
                }
                break;
            }

            case "/eliminarusuario": {
                WebResource recurso = cliente.resource("http://localhost:8080/Hoteles-DAE-REST/recursos/usuarios/" + (String) request.getParameter("dni"));
                recurso.delete();

                response.sendRedirect("/Hoteles-DAE-cliente-REST/operador/listadousuarios");
                break;
            }

            case "/busqueda": {
                if (request.getParameter("ciudad") != null) {
                    request.setAttribute("tab", 1);
                    String ciudad = request.getParameter("buscar");

                    WebResource recurso = cliente.resource("http://localhost:8080/Hoteles-DAE-REST/recursos/" + ciudad + "/hoteles");
                    ClientResponse responseJSON = recurso.accept("application/json").get(ClientResponse.class);
                    List<Hotel> hoteles = responseJSON.getEntity(List.class);

                    request.setAttribute("hotelesc", hoteles);
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/operador/reservas/busqueda.jsp");
                    rd.forward(request, response);
                } else if (request.getParameter("hotel") != null) {
                    request.setAttribute("tab", 2);
                    String hotel = request.getParameter("buscar");

                    WebResource recurso = cliente.resource("http://localhost:8080/Hoteles-DAE-REST/recursos/hoteles/busqueda").queryParam("nombre", hotel);
                    ClientResponse responseJSON = recurso.accept("application/json").get(ClientResponse.class);
                    List<Hotel> hoteles = responseJSON.getEntity(List.class);

                    request.setAttribute("hotelesh", hoteles);
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/operador/reservas/busqueda.jsp");
                    rd.forward(request, response);
                } else if (request.getParameter("fecha") != null) {
                    request.setAttribute("tab", 3);
                    String ciudad = request.getParameter("ciudadBusqueda");
                    String fEntrada = request.getParameter("fechaEntrada");
                    String fSalida = request.getParameter("fechaSalida");

                    WebResource recurso = cliente.resource("http://localhost:8080/Hoteles-DAE-REST/recursos/" + ciudad + "/hoteles").queryParam("entrada", fEntrada).queryParam("salida", fSalida);
                    ClientResponse responseJSON = recurso.accept("application/json").get(ClientResponse.class);
                    List<Hotel> hoteles = responseJSON.getEntity(List.class);

                    request.setAttribute("hotelesf", hoteles);
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/operador/reservas/busqueda.jsp");
                    rd.forward(request, response);
                } else if (request.getParameter("cReserva") != null) {

                    String nombreH = request.getParameter("nombreH");
                    request.setAttribute("nombreHotel", nombreH);

                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/operador/reservas/crear.jsp");
                    rd.forward(request, response);

                } else {
                    request.setAttribute("tab", 1);

                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/operador/reservas/busqueda.jsp");
                    rd.forward(request, response);
                }
                break;
            }

            case "/listadoreservas": {
                WebResource recurso = cliente.resource("http://localhost:8080/Hoteles-DAE-REST/recursos/reservas");
                ClientResponse responseJSON = recurso.accept("application/json").get(ClientResponse.class);
                List<Reserva> reservas = responseJSON.getEntity(List.class);

                request.setAttribute("reservas", reservas);
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/operador/reservas/listado.jsp");
                rd.forward(request, response);
                break;
            }

            case "/crearreserva": {
                if (request.getParameter("crear") != null) {
                    String hotel = request.getParameter("hotel");
                    String dni = request.getParameter("dni");
                    int simples = Integer.parseInt(request.getParameter("simples"));
                    int dobles = Integer.parseInt(request.getParameter("dobles"));
                    int triples = Integer.parseInt(request.getParameter("triples"));
                    String fEntrada = request.getParameter("fechaEntrada");
                    String fSalida = request.getParameter("fechaSalida");
                    Date fechaEntradaD = new Date(Integer.parseInt(fEntrada.substring(0, 4)) - 1900, Integer.parseInt(fEntrada.substring(5, 7)) - 1, Integer.parseInt(fEntrada.substring(8, 10)));
                    Date fechaSalidaD = new Date(Integer.parseInt(fSalida.substring(0, 4)) - 1900, Integer.parseInt(fSalida.substring(5, 7)) - 1, Integer.parseInt(fSalida.substring(8, 10)));

                    WebResource recurso = cliente.resource("http://localhost:8080/Hoteles-DAE-REST/recursos/hoteles/" + Uri.escapeDisallowedChars(hotel));
                    ClientResponse responseJSON = recurso.accept("application/json").get(ClientResponse.class);
                    Hotel ho = responseJSON.getEntity(Hotel.class);

                    WebResource recurso2 = cliente.resource("http://localhost:8080/Hoteles-DAE-REST/recursos/usuarios/" + dni);
                    ClientResponse responseJSON2 = recurso2.accept("application/json").get(ClientResponse.class);
                    Usuario u = responseJSON2.getEntity(Usuario.class);

                    WebResource recurso3 = cliente.resource("http://localhost:8080/Hoteles-DAE-REST/recursos/reservas/");
                    recurso3.type("application/json").put(ClientResponse.class, new Reserva(fechaEntradaD, fechaSalidaD, simples, dobles, triples, u, ho));

                    response.sendRedirect("/Hoteles-DAE-cliente-REST/operador/listadoreservas");
                } else if (request.getParameter("cancelar") != null) {
                    response.sendRedirect("/Hoteles-DAE-cliente-REST/operador/listadoreservas");
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/operador/reservas/crear.jsp");
                    rd.forward(request, response);
                }
                break;
            }

            case "/modificarreserva": {

                if (request.getParameter("modificar") != null) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    String hotel = request.getParameter("hotel");
                    String usuario = request.getParameter("usuario");
                    int simples = Integer.parseInt(request.getParameter("simples"));
                    int dobles = Integer.parseInt(request.getParameter("dobles"));
                    int triples = Integer.parseInt(request.getParameter("triples"));
                    String fEntrada = request.getParameter("fechaentrada");
                    String fSalida = request.getParameter("fechasalida");
                    Date fechaEntradaD = new Date(Integer.parseInt(fEntrada.substring(0, 4)) - 1900, Integer.parseInt(fEntrada.substring(5, 7)) - 1, Integer.parseInt(fEntrada.substring(8, 10)));
                    Date fechaSalidaD = new Date(Integer.parseInt(fSalida.substring(0, 4)) - 1900, Integer.parseInt(fSalida.substring(5, 7)) - 1, Integer.parseInt(fSalida.substring(8, 10)));

                    WebResource recurso = cliente.resource("http://localhost:8080/Hoteles-DAE-REST/recursos/hoteles/" + Uri.escapeDisallowedChars(hotel));
                    ClientResponse responseJSON = recurso.accept("application/json").get(ClientResponse.class);
                    Hotel ho = responseJSON.getEntity(Hotel.class);

                    WebResource recurso2 = cliente.resource("http://localhost:8080/Hoteles-DAE-REST/recursos/usuarios/" + usuario);
                    ClientResponse responseJSON2 = recurso2.accept("application/json").get(ClientResponse.class);
                    Usuario u = responseJSON2.getEntity(Usuario.class);

                    WebResource recurso3 = cliente.resource("http://localhost:8080/Hoteles-DAE-REST/recursos/reservas/");
                    recurso3.type("application/json").put(ClientResponse.class, new Reserva(fechaEntradaD, fechaSalidaD, simples, dobles, triples, u, ho));

                    response.sendRedirect("/Hoteles-DAE-cliente-REST/operador/listadoreservas");

                } else if (request.getParameter("cancelar") != null) {
                    response.sendRedirect("/Hoteles-DAE-cliente-REST/operador/listadoreservas");
                } else {
                    WebResource recurso = cliente.resource("http://localhost:8080/Hoteles-DAE-REST/recursos/reservas/" + request.getParameter("id"));
                    ClientResponse responseJSON = recurso.accept("application/json").get(ClientResponse.class);
                    Reserva reserva = responseJSON.getEntity(Reserva.class);
                    request.setAttribute("reserva", reserva);
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/operador/reservas/modificar.jsp");
                    rd.forward(request, response);
                }
                break;
            }

            case "/eliminarreserva": {
                WebResource recurso = cliente.resource("http://localhost:8080/Hoteles-DAE-REST/recursos/reservas/" + (String) request.getParameter("id"));
                recurso.delete();
                response.sendRedirect("/Hoteles-DAE-cliente-REST/operador/listadoreservas");
                break;
            }
            default: {
                response.sendRedirect("/Hoteles-DAE-cliente-REST/operador/listadousuarios");
                break;
            }
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
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response
    )
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
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
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response
    )
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
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
