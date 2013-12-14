<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="/WEB-INF/operador/cabecera.jspf"/>

<!-- container -->

<jsp:include page="/WEB-INF/operador/menu.jsp?op=reservas"/>
<section class="panel panel-default">
    <div class="panel-heading">
        <h1>Listado de reservas</h1>
        <a class="pull-right btn btn-success" href="/Hoteles-DAE-cliente-REST/operador/crearreserva">Crear reserva</a>
        <div class="clearfix"></div>
    </div>
    <div class="panel-body">
        <c:if test="${noEliminado == 'true'}">
            <div class="alert alert-error">
                El usuario no ha sido eliminado.
            </div>
        </c:if>
        <table class="table table-striped table-condensed table-hover">
            <thead>
                <tr>
                    <th>Fecha de entrada</th>
                    <th>Fecha de salida</th>
                    <th>Habitaciones simples</th>
                    <th>Habitaciones dobles</th>
                    <th>Habitaciones triples</th>
                    <th>DNI del usuario</th>
                    <th>Nombre del hotel</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="r" items="${reservas}" varStatus="estado">
                    <tr>
                        <td>${fn:substring(r.fechaEntrada, 0, 10)}</td>
                        <td>${fn:substring(r.fechaSalida, 0, 10)}</td>
                        <td>${r.simples}</td>
                        <td>${r.dobles}</td>
                        <td>${r.triples}</td>
                        <td>${r.usuario.dni}</td>
                        <td>${r.hotel.nombre}</td>
                        <td>
                            <!--<a href="#modalElimina" data-toggle="modal" class="elimina"><i class="icon-remove"></i></a>-->
                            <a href="/Hoteles-DAE-cliente-REST/operador/eliminarreserva?id=${r.id}"><i class="glyphicon glyphicon-remove"></i></a>
                            <a href="/Hoteles-DAE-cliente-REST/operador/modificarreserva?id=${r.id}"><i class="glyphicon glyphicon-pencil"></i></a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</section>
<!-- container -->

<jsp:include page="/WEB-INF/operador/pie.jspf"/>
