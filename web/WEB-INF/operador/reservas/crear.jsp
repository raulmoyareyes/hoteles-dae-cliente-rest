<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/operador/cabecera.jspf"/>

<!-- container -->

<jsp:include page="/WEB-INF/operador/menu.jsp?op=reservas"/>
<section class="panel panel-default">
    <div class="panel-heading">
        <h1>Nueva reserva</h1>
    </div>
    <div class="panel-body">
        <form method="post" class="form-horizontal">
            <div class="form-group">
                <label class="col-lg-2 control-label">Hotel</label>
                <div class="col-lg-6">
                    <input type="text" name="hotel" class="form-control" value="${nombreHotel}"/> 
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2 control-label">DNI usuario</label>
                <div class="col-lg-6">
                    <input type="text" name="dni" class="form-control"/> 
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2 control-label">Habitaciones simples</label>
                <div class="col-lg-6">
                    <input type="number" name="simples" class="form-control" value="0"/> 
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2 control-label">Habitaciones dobles</label>
                <div class="col-lg-6">
                    <input type="number" name="dobles" class="form-control" value="0"/> 
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2 control-label">Habitaciones triples</label>
                <div class="col-lg-6">
                    <input type="number" name="triples" class="form-control" value="0"/> 
                </div>
            </div>
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
            <div class="col-lg-offset-2 col-lg-10">
                <button type="submit" class="btn btn-success" name="crear">Crear</button>
                <button type="reset" class="btn btn-primary">Limpiar</button>
                <button type="submit" class="btn btn-danger" name="cancelar">Cancelar</button>
            </div>
        </form>
    </div>
</section>
<!-- container -->

<jsp:include page="/WEB-INF/operador/pie.jspf"/>

