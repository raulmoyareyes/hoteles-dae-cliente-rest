<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/operador/cabecera.jspf"/>

<!-- container -->

<jsp:include page="/WEB-INF/operador/menu.jsp?op=usuarios"/>
<section class="panel panel-default">
    <div class="panel-heading">
        <h1>Listado de usuarios</h1>
        <a class="pull-right btn btn-success" href="/Hoteles-DAE-cliente-WS/operador/nuevousuario">Nuevo usuario</a>
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
                    <th>Nombre</th>
                    <th>DNI</th>
                    <th>Dirección</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="u" items="${usuarios}" varStatus="estado">
                    <tr>
                        <td>${u.nombre}</td>
                        <td>${u.dni}</td>
                        <td>${u.direccion}</td>
                        <td>
                            <!--<a href="#modalElimina" data-toggle="modal" class="elimina"><i class="icon-remove"></i></a>-->
                            <a href="/Hoteles-DAE-cliente-WS/operador/eliminarusuario?dni=${u.dni}"><i class="glyphicon glyphicon-remove"></i></a>
                            <a href="/Hoteles-DAE-cliente-WS/operador/modificarusuario?dni=${u.dni}"><i class="glyphicon glyphicon-pencil"></i></a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</section>
<!-- container -->

<jsp:include page="/WEB-INF/operador/pie.jspf"/>
