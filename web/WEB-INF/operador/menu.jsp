<!-- menu -->
<div class="navbar navbar-inverse">
    <div class="navbar-header">
        <a class="navbar-brand" href="/Hoteles-DAE-cliente-REST/operador/listadousuarios">Operador</a>
    </div>

    <div class="ollapse navbar-collapse navbar-ex1-collapse">
        <ul class="nav navbar-nav">
            <li class="${(param.op == 'usuarios')?'active':''}"><a href="/Hoteles-DAE-cliente-REST/operador/listadousuarios">Usuarios</a></li>
            <li class="${(param.op == 'busqueda')?'active':''}"><a href="/Hoteles-DAE-cliente-REST/operador/busqueda">Busqueda</a></li>
            <li class="${(param.op == 'reservas')?'active':''}"><a href="/Hoteles-DAE-cliente-REST/operador/listadoreservas">Reservas</a></li>
        </ul>                                    
    </div>
</div>
<!-- menu -->