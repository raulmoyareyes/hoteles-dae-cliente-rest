<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/operador/cabecera.jspf"/>

<!-- container -->

<jsp:include page="/WEB-INF/operador/menu.jsp?op=usuarios"/>
<section class="panel panel-default">
    <div class="panel-heading">
        <h1>Modificar usuario</h1>
    </div>
    <div class="panel-body">
        <form method="post" class="form-horizontal">
            <div class="form-group">
                <label class="col-lg-2 control-label">Nombre</label>
                <div class="col-lg-6">
                    <input type="text" name="nombre" class="form-control" value="${usuario.nombre}"/> 
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2 control-label">DNI</label>
                <div class="col-lg-6">
                    <input type="text" disabled="true" class="form-control" value="${usuario.dni}"/> 
                    <input type="hidden" name="dni" class="form-control" value="${usuario.dni}"/> 
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2 control-label">Dirección</label>
                <div class="col-lg-6">
                    <input type="text" name="direccion" class="form-control" value="${usuario.direccion}"/> 
                </div>
            </div>
            <div class="col-lg-offset-2 col-lg-10">
                <button type="submit" class="btn btn-success" name="modificar">Modificar</button>
                <button type="reset" class="btn btn-primary">Limpiar</button>
                <button type="submit" class="btn btn-danger" name="cancelar">Cancelar</button>
            </div>
        </form>
    </div>
</section>
<!-- container -->

<jsp:include page="/WEB-INF/operador/pie.jspf"/>

