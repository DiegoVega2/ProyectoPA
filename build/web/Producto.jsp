<%-- 
    Document   : Producto
    Created on : 19/11/2022, 4:11:50 p. m.
    Author     : DieguilloPillo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Producto</title>
    </head>
    <body>
               <div class="d-flex">
        <div class="card col-sm-3" ><!-- style="width: 24rem;" -->
  <div class="card-body">
      <form action="Controlador?menu=Producto" method="POST">
          <div class="form-group">
              <label>Nombres</label>
              <input type="text" value="${producto.getNombres()}" name="txtNombres" class="form-control" required="">                  
          </div>
          <div class="form-group">
              <label>Precio</label>
              <input type="text" value="${producto.getPrecio()}" name="txtPrecio" class="form-control" required="">                  
          </div>
           <div class="form-group">
              <label>Stock</label>
              <input type="number" min="10" value="${producto.getStock()}" name="txtStock" class="form-control" required="">                  
          </div>
          <div class="form-group">
              <label>Estado</label>
              <input type="text" value="${producto.getEstado()}" name="txtEstado" class="form-control" required="">                  
          </div>
          <input type="submit" name="accion" value="Agregar" class="btn btn-outline-dark">
          <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
      </form>
  </div>
            </div>
            <div class="col-sm-8"> 
                <table class="table table-hover">
                    <thead class="thead-dark">
                    <th>ID</th>
                    <th>NOMBRES</th>
                    <th>PRECIO</th>
                    <th>STOCK</th>
                    <th>ESTADO</th>
                    <th>ACCIONES</th>
                    </thead>
                    <tbody>
                    <c:forEach var="pr" items="${listaproductos}">                     
                        <tr>
                         <td>${pr.getId()}</td>
                         <td>${pr.getNombres()}</td>
                         <td>${pr.getPrecio()}</td>
                         <td>${pr.getStock()}</td>
                         <td>${pr.getEstado()}</td>
                         <td>
                   <a href="Controlador?menu=Producto&accion=Editar&id=${pr.getId()}" class="btn btn-warning">Editar</a>                         
                       <a href="Controlador?menu=Producto&accion=Delete&id=${pr.getId()}" class="btn btn-danger">Eliminar</a>        
                         </td>
                        </tr>
                     </c:forEach>
                    </tbody>
                </table>  
            </div>
    </div>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</html>
