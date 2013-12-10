<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/operador/cabecera.jspf"/>

<!-- container -->

<jsp:include page="/WEB-INF/operador/menu.jsp?op=busqueda"/>
<section class="panel panel-default">
    <div class="panel-heading">
        <h1>Realizar consultas</h1>
        <a class="pull-right btn btn-success" href="/Hoteles-DAE-cliente-WS/operador/crearreserva">Crear reserva</a>
        <div class="clearfix"></div>
    </div>
    <div class="panel-body">
        <ul class="nav nav-tabs" id="myTab">
            <li class="${(tab==1)?'active':''}"><a href="#ciudad">Ciudad</a></li>
            <li class="${(tab==2)?'active':''}"><a href="#hotel">Hotel</a></li>
            <li class="${(tab==3)?'active':''}"><a href="#fecha">Fecha</a></li>
        </ul>

        <div class="tab-content">

            <div class="tab-pane ${(tab==1)?'active':''}" id="ciudad">
                <br />
                <form method="post" class="form-horizontal">
                    <label class="col-lg-3 control-label">Escribe el nombre de una ciudad</label>
                    <div class="input-group col-lg-6">
                        <input type="text" class="form-control" placeholder="Buscar" name="buscar">
                        <div class="input-group-btn">
                            <button class="btn btn-default" type="submit" name="ciudad"><i class="glyphicon glyphicon-search"></i></button>
                        </div>
                    </div>
                </form>
                <br /><br /><br />
                <table class="table table-striped table-condensed table-hover">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Dirección</th>
                            <th>Ciudad</th>
                            <th>Precio habitaciones simples</th>
                            <th>Precio habitaciones dobles</th>
                            <th>Precio habitaciones triples</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="u" items="${hotelesc}" varStatus="estado">

                            <c:if test="${u.nombre == null}">
                            </tbody>
                        </table>
                        <br />
                        <h3>Ciudades Cercanas</h3>
                        <table class="table table-striped table-condensed table-hover">
                            <thead>
                                <tr>
                                    <th>Nombre</th>
                                    <th>Dirección</th>
                                    <th>Ciudad</th>
                                    <th>Precio habitaciones simples</th>
                                    <th>Precio habitaciones dobles</th>
                                    <th>Precio habitaciones triples</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                            </c:if>
                            <c:if test="${u.nombre != null}">
                            <form role="form">
                                <tr>
                                    <td>${u.nombre}<input type="hidden" value="${u.nombre}" name="nombreH"/></td>
                                    <td>${u.direccion}</td>
                                    <td>${u.ciudad}</td>
                                    <td>${u.precioSimples}€</td>
                                    <td>${u.precioDobles}€</td>
                                    <td>${u.precioTriples}€</td>
                                    <td>
                                        <button type="submit" class="btn btn-success" name="cReserva"><i class="glyphicon glyphicon-plus-sign"></i></button>
                                    </td>
                                </tr>
                            </form>
                        </c:if>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

            <div class="tab-pane ${(tab==2)?'active':''}" id="hotel">
                <br />
                <form method="post" class="form-horizontal">
                    <label class="col-lg-3 control-label">Escribe el nombre de un hotel</label>
                    <div class="input-group col-lg-6">
                        <input type="text" class="form-control" placeholder="Buscar" name="buscar">
                        <div class="input-group-btn">
                            <button class="btn btn-default" type="submit" name="hotel"><i class="glyphicon glyphicon-search"></i></button>
                        </div>
                    </div>
                </form>
                <br /><br /><br />
                <table class="table table-striped table-condensed table-hover">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Dirección</th>
                            <th>Ciudad</th>
                            <th>Precio habitaciones simples</th>
                            <th>Precio habitaciones dobles</th>
                            <th>Precio habitaciones triples</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="u" items="${hotelesh}" varStatus="estado">
                            <form role="form">
                                <tr>
                                    <td>${u.nombre}<input type="hidden" class="form-control" value="${u.nombre}" name="nombreH"/></td>
                                    <td>${u.direccion}</td>
                                    <td>${u.ciudad}</td>
                                    <td>${u.precioSimples}€</td>
                                    <td>${u.precioDobles}€</td>
                                    <td>${u.precioTriples}€</td>
                                    <td>
                                        <button type="submit" class="btn btn-success" name="cReserva"><i class="glyphicon glyphicon-plus-sign"></i></button>
                                    </td>
                                </tr>
                            </form>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

            <div class="tab-pane ${(tab==3)?'active':''}" id="fecha">
                <br />
                <form method="post" class="form-horizontal">
                    <div class="form-group">
                        <label class="col-lg-2 control-label">Fecha de entrada</label>
                        <div class="col-lg-4">
                            <input type="date" name="fechaEntrada" class="form-control"/> 
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 control-label">Fecha de salida</label>
                        <div class="col-lg-4">
                            <input type="date" name="fechaSalida" class="form-control"/> 
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 control-label">Ciudad</label>
                        <div class="col-lg-4">
                            <input type="text" name="ciudadBusqueda" class="form-control"/> 
                        </div>
                        <div class="col-lg-4">
                            <button class="btn btn-default" type="submit" name="fecha"><i class="glyphicon glyphicon-search"></i> Buscar</button>
                        </div>
                    </div>
                </form>
                <br /><br /><br />
                <table class="table table-striped table-condensed table-hover">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Dirección</th>
                            <th>Ciudad</th>
                            <th>Precio habitaciones simples</th>
                            <th>Precio habitaciones dobles</th>
                            <th>Precio habitaciones triples</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="u" items="${hotelesf}" varStatus="estado">
                            <tr>
                                <td>${u.nombre}</td>
                                <td>${u.direccion}</td>
                                <td>${u.ciudad}</td>
                                <td>${u.precioSimples}€</td>
                                <td>${u.precioDobles}€</td>
                                <td>${u.precioTriples}€</td>
                                <td>
                                    <a class="label label-success" href="/Hoteles-DAE-cliente-WS/operador/crearreserva"><i class="glyphicon glyphicon-plus-sign"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>
<!-- container -->

<jsp:include page="/WEB-INF/operador/pie.jspf"/>