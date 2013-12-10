<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/operador/cabecera.jspf"/>

<!-- container -->

<jsp:include page="/WEB-INF/operador/menu.jsp?op=usuarios"/>
<section class="panel panel-default">
    <div class="panel-heading">
        <h1>Nuevo usuario</h1>
    </div>
    <div class="panel-body">
        <form method="post" class="form-horizontal">
            <div class="form-group">
                <label class="col-lg-2 control-label">Nombre</label>
                <div class="col-lg-6">
                    <input type="text" name="nombre" class="form-control"/> 
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2 control-label">DNI</label>
                <div class="col-lg-6">
                    <input type="text" name="dni" class="form-control"/> 
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2 control-label">Dirección</label>
                <div class="col-lg-6">
                    <input type="text" name="direccion" class="form-control"/> 
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

