/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import modelos.Usuario;

/**
 *
 * @author raul
 */
@WebServlet(name = "Operador", urlPatterns = {"/operador/*"})
public class Operador extends HttpServlet {

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

//        Client cliente = new Client();
//        WebResource recurso = cliente.resource("http://localhost:8080/Hoteles-DAE-REST/recursos/usuarios/77358477R");
//        ClientResponse responseJSON = recurso.accept("application/json").get(ClientResponse.class);
//        Usuario usuario = responseJSON.getEntity(Usuario.class);
        
//        switch (action) {
//            case "/listadousuarios": {
//                request.setAttribute("usuarios", servicioOperador.listaUsuarios());
//                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/operador/usuarios/listado.jsp");
//                rd.forward(request, response);
//                break;
//            }
//
//            case "/nuevousuario": {
//                if (request.getParameter("crear") != null) {
//                    String nombre = request.getParameter("nombre");
//                    String direccion = request.getParameter("direccion");
//                    String dni = request.getParameter("dni");
//
//                    try {
//                        servicioOperador.altaUsuario(nombre, direccion, dni);
//                    } catch (UsuarioErrorDatos_Exception | UsuarioErrorPersistir_Exception ex) {
//                        Logger.getLogger(Operador.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//
//                    response.sendRedirect("/Hoteles-DAE-cliente-WS/operador/listadousuarios");
//                } else if(request.getParameter("cancelar")!= null){
//                    response.sendRedirect("/Hoteles-DAE-cliente-WS/operador/listadousuarios");
//                }else{
//                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/operador/usuarios/nuevo.jsp");
//                    rd.forward(request, response);
//                }
//                break;
//            }
//
//            case "/modificarusuario": {
//                if (request.getParameter("modificar") != null) {
//                    String nombre = request.getParameter("nombre");
//                    String direccion = request.getParameter("direccion");
//                    String dni = request.getParameter("dni");
//
//                    try {
//                        servicioOperador.modificarUsuario(nombre, dni, direccion);
//                    } catch (UsuarioErrorActualizar_Exception ex) {
//                        Logger.getLogger(Operador.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//
//                    response.sendRedirect("/Hoteles-DAE-cliente-WS/operador/listadousuarios");
//
//                } else if (request.getParameter("cancelar") != null) {
//                    response.sendRedirect("/Hoteles-DAE-cliente-WS/operador/listadousuarios");
//                } else {
//                    Usuario usuario = servicioOperador.obtenerUsuario((String) request.getParameter("dni"));
//                    request.setAttribute("usuario", usuario);
//                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/operador/usuarios/modificar.jsp");
//                    rd.forward(request, response);
//                }
//                break;
//            }
//
//            case "/eliminarusuario": {
//                try {
//                    servicioOperador.bajaUsuario(request.getParameter("dni"));
//                } catch (UsuarioErrorEliminar_Exception | UsuarioNoEncontrado_Exception | ReservaErrorCambiarUsuario_Exception ex) {
//                    System.out.println("No se ha podido eliminar el usuario");
//                }
//                response.sendRedirect("/Hoteles-DAE-cliente-WS/operador/listadousuarios");
//                break;
//            }
//
//            case "/listadoreservas": {
//                request.setAttribute("reservas", servicioOperador.listadoReservas());
//                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/operador/reservas/listado.jsp");
//                rd.forward(request, response);
//                break;
//            }
//
//            case "/busqueda": {
//                if (request.getParameter("ciudad") != null) {
//                    request.setAttribute("tab", 1);
//                    String ciudad = request.getParameter("buscar");
//                    request.setAttribute("hotelesc", servicioOperador.consultaCiudad(ciudad));
//                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/operador/reservas/busqueda.jsp");
//                    rd.forward(request, response);
//                } else if (request.getParameter("hotel") != null) {
//                    request.setAttribute("tab", 2);
//                    String hotel = request.getParameter("buscar");
//                    request.setAttribute("hotelesh", servicioOperador.consultaNombreHotel(hotel));
//                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/operador/reservas/busqueda.jsp");
//                    rd.forward(request, response);
//                } else if (request.getParameter("fecha") != null) {
//                    request.setAttribute("tab", 3);
//                    String ciudad = request.getParameter("ciudadBusqueda");
//                    String fEntrada = request.getParameter("fechaEntrada");
//                    String fSalida = request.getParameter("fechaSalida");
//                    Date fechaEntradaD = new Date(Integer.parseInt(fEntrada.substring(0, 4)) - 1900, Integer.parseInt(fEntrada.substring(5, 7)) - 1, Integer.parseInt(fEntrada.substring(8, 10)));
//                    Date fechaSalidaD = new Date(Integer.parseInt(fSalida.substring(0, 4)) - 1900, Integer.parseInt(fSalida.substring(5, 7)) - 1, Integer.parseInt(fSalida.substring(8, 10)));
//                    GregorianCalendar feg = new GregorianCalendar();
//                    GregorianCalendar fsg = new GregorianCalendar();
//                    feg.setTime(fechaEntradaD);
//                    fsg.setTime(fechaSalidaD);
//                    try {
//                        XMLGregorianCalendar fechaEntrada = DatatypeFactory.newInstance().newXMLGregorianCalendar(feg);
//                        XMLGregorianCalendar fechaSalida = DatatypeFactory.newInstance().newXMLGregorianCalendar(fsg);
//                        request.setAttribute("hotelesf", servicioOperador.consultaFecha(ciudad, fechaEntrada, fechaSalida));
//                    } catch (DatatypeConfigurationException ex) {
//                        //
//                    }
//                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/operador/reservas/busqueda.jsp");
//                    rd.forward(request, response);
//                } else if (request.getParameter("cReserva") != null) {
//
//                    String nombreH = request.getParameter("nombreH");
//                    request.setAttribute("nombreHotel", nombreH);
//
//                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/operador/reservas/crear.jsp");
//                    rd.forward(request, response);
//                    
//                } else {
//                    request.setAttribute("tab", 1);
//
//                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/operador/reservas/busqueda.jsp");
//                    rd.forward(request, response);
//                }
//                break;
//            }
//
//            case "/crearreserva": {
//                if (request.getParameter("crear") != null) {
//                    String hotel = request.getParameter("hotel");
//                    String dni = request.getParameter("dni");
//                    int simples = Integer.parseInt(request.getParameter("simples"));
//                    int dobles = Integer.parseInt(request.getParameter("dobles"));
//                    int triples = Integer.parseInt(request.getParameter("triples"));
//                    String fEntrada = request.getParameter("fechaEntrada");
//                    String fSalida = request.getParameter("fechaSalida");
//                    Date fechaEntradaD = new Date(Integer.parseInt(fEntrada.substring(0, 4)) - 1900, Integer.parseInt(fEntrada.substring(5, 7)) - 1, Integer.parseInt(fEntrada.substring(8, 10)));
//                    Date fechaSalidaD = new Date(Integer.parseInt(fSalida.substring(0, 4)) - 1900, Integer.parseInt(fSalida.substring(5, 7)) - 1, Integer.parseInt(fSalida.substring(8, 10)));
//                    GregorianCalendar feg = new GregorianCalendar();
//                    GregorianCalendar fsg = new GregorianCalendar();
//                    feg.setTime(fechaEntradaD);
//                    fsg.setTime(fechaSalidaD);
//                    try {
//                        XMLGregorianCalendar fechaEntrada = DatatypeFactory.newInstance().newXMLGregorianCalendar(feg);
//                        XMLGregorianCalendar fechaSalida = DatatypeFactory.newInstance().newXMLGregorianCalendar(fsg);
//                        servicioOperador.crearReserva(fechaEntrada, fechaSalida, simples, dobles, triples, dni, hotel);
//                    } catch (UsuarioNoEncontrado_Exception | HotelErrorBloquear_Exception | HotelNoEncontrado_Exception | ReservaErrorDatos_Exception | ReservaNoPosible_Exception | HotelErrorActualizar_Exception ex) {
//                        System.out.println("No se ha podido crear la reserva");
//                    } catch (DatatypeConfigurationException ex) {
//
//                    }
//
//                    response.sendRedirect("/Hoteles-DAE-cliente-WS/operador/listadoreservas");
//                } else if (request.getParameter("cancelar") != null) {
//                    response.sendRedirect("/Hoteles-DAE-cliente-WS/operador/listadoreservas");
//                } else {
//                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/operador/reservas/crear.jsp");
//                    rd.forward(request, response);
//                }
//                break;
//            }
//
//            case "/modificarreserva": {
//
//                if (request.getParameter("modificar") != null) {
//                    int id = Integer.parseInt(request.getParameter("id"));
//                    String hotel = request.getParameter("hotel");
//                    String usuario = request.getParameter("usuario");
//                    int simples = Integer.parseInt(request.getParameter("simples"));
//                    int dobles = Integer.parseInt(request.getParameter("dobles"));
//                    int triples = Integer.parseInt(request.getParameter("triples"));
//                    String fEntrada = request.getParameter("fechaentrada");
//                    String fSalida = request.getParameter("fechasalida");
//                    Date fechaEntradaD = new Date(Integer.parseInt(fEntrada.substring(0, 4)) - 1900, Integer.parseInt(fEntrada.substring(5, 7)) - 1, Integer.parseInt(fEntrada.substring(8, 10)));
//                    Date fechaSalidaD = new Date(Integer.parseInt(fSalida.substring(0, 4)) - 1900, Integer.parseInt(fSalida.substring(5, 7)) - 1, Integer.parseInt(fSalida.substring(8, 10)));
//                    GregorianCalendar feg = new GregorianCalendar();
//                    GregorianCalendar fsg = new GregorianCalendar();
//                    feg.setTime(fechaEntradaD);
//                    fsg.setTime(fechaSalidaD);
//                    try {
//                        XMLGregorianCalendar fechaEntrada = DatatypeFactory.newInstance().newXMLGregorianCalendar(feg);
//                        XMLGregorianCalendar fechaSalida = DatatypeFactory.newInstance().newXMLGregorianCalendar(fsg);
//                        servicioOperador.modificarReserva(id, fechaEntrada, fechaSalida, simples, dobles, triples, hotel, usuario);
//                    } catch (ReservaErrorActualizar_Exception | DatatypeConfigurationException ex) {
//                        Logger.getLogger(Operador.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//
//                    response.sendRedirect("/Hoteles-DAE-cliente-WS/operador/listadoreservas");
//
//                } else if (request.getParameter("cancelar") != null) {
//                    response.sendRedirect("/Hoteles-DAE-cliente-WS/operador/listadoreservas");
//                } else {
//                    Reserva reserva = servicioOperador.obtenerReserva(Integer.parseInt(request.getParameter("id")));
//                    request.setAttribute("reserva", reserva);
//                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/operador/reservas/modificar.jsp");
//                    rd.forward(request, response);
//                }
//                break;
//            }
//
//            case "/eliminarreserva": {
//                try {
//                    servicioOperador.eliminarReserva(Integer.parseInt(request.getParameter("id")));
//                } catch (HotelErrorActualizar_Exception | ReservaNoEncontrada_Exception ex) {
//                    System.out.println("No se ha podido eliminar la reserva");
//                }
//                response.sendRedirect("/Hoteles-DAE-cliente-WS/operador/listadoreservas");
//                break;
//            }
//
//            default: {
//                response.sendRedirect("/Hoteles-DAE-cliente-WS/operador/listadousuarios");
//                break;
//            }
//        }
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
