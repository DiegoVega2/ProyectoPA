<%-- 
    Document   : principal
    Created on : Nov 12, 2022, 4:32:45 PM
    Author     : DieguilloPillo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <title>Venta Mangas</title>
    </head>
    <body>
        <!-- Barra de Navegación -->
<!-- Image and text -->
<header>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand">
      <img src="img/logo.png" width="30" height="30" class="d-inline-block align-top" alt="logo">
      M/A-Store</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown" align="right">
    <ul class="navbar-nav">
      <li class="nav-item active">
          <a class="nav-link" href="Controlador?menu=Producto&accion=Listar" target="myFrame">Producto<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Empleado</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Controlador?menu=Clientes&accion=Listar" target="myFrame">Clientes</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Controlador?menu=RegistrarVenta&accion=default&idempleado1=${usuario.getId()}" target="myFrame">Venta Nueva</a>
      </li>
    </ul>
  </div>
      <div class="dropdown" style="text-align: right">
  <button class="btn btn-outline-dark dropdown-toggle" type="button" data-toggle="dropdown" aria-expanded="false">
    ${usuario.getNombre()}
  </button>
  <div class="dropdown-menu text-center">
    <a class="dropdown-item" href="#"><img src="img/usuario.png" alt="usuario" height="60" width="60"/></a>  
    <a class="dropdown-item" href="#">${usuario.getUser()}</a>
    <a class="dropdown-item" href="#">Id: ${usuario.getId()}</a>
    <div class="dropdown-divider"></div>
    <form action="Validar" method="POST">
    <button name="accion" value="salir" class="dropdown-item btn btn-danger" href="#">Salir</button>
    </form>
  </div>
</div>
</nav>
    </header>
    <div class="m-4" style="height: 550px">
        <iframe name="myFrame" style="height: 100%; width: 100%; border: none"></iframe>
    </div>
    
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
    </body>
</html>