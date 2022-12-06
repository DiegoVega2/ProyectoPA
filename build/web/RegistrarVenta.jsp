<%-- 
    Document   : RegistrarVenta
    Created on : 19/11/2022, 4:12:31 p. m.
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
        <style>@media print{
                .parte01, .btn, .parte02{
                    display: none;
                }
            }
        </style>
        <title>Venta</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-4 parte01">
                <div class="card">
                    <form action="Controlador?menu=RegistrarVenta" method="POST">
                    <div class="card-body">
                        <div class="form-group">
                            <label>
                                Datos del Cliente
                            </label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6">
                                <input type="text" name="codigocliente" value="${objC.getDni()}" class="form-control" placeholder="Código">
                                <input type="submit" class="btn-outline-dark" name="accion" value="BuscarCliente"> 
                            </div>
                            <div class="col-sm-6">
                                <input type="text" name="nombrescliente" value="${objC.getNombres()}" class="form-control" placeholder="Datos Cliente" onlyread>
                            </div>    
                        </div> 
                        <!-- DATOS DEL PRODUCTO -->
                        <div class="form-group">
                            <label>Datos Producto</label>
                        </div> 
                        <div class="form-group d-flex">
                            <div class="col-sm-6">
                                <input type="text" name="codigoproducto" class="form-control" value="${producto.getId()}" placeholder="Código">
                                <button type="submit" class="btn-outline-dark" name="accion" value="BuscarProducto">Buscar</button>
                            </div>
                            <div class="col-sm-6">
                                <input type="text" name="nomproducto" value="${producto.getNombres()}" class="form-control" placeholder="Datos Producto" onlyread>
                            </div>  
                        </div> 
                        <div class="form-group d-flex">
                            <div class="col-sm-6">
                                <input type="text" name="precio" class="form-control" value="${producto.getPrecio()}" placeholder="$--" onlyread>
                            </div>
                            <div class="col-sm-3">
                                <input type="number" min="1" name="cant" value="1" class="form-control" placeholder="" required="">
                            </div>  
                            <div class="col-sm-3">
                                <input type="text" name="stock" class="form-control" value="${producto.getStock()}" placeholder="Stock" onlyread>
                            </div>  
                        </div> 
                            <!-- BOTON AGREGAR AL PRODUCTO REGISTRO -->
                        <div class="form-group">
                            <div class="col-sm">
                                <button type="submit" value="Agregar" name="accion" class="btn btn-dark">Agregar</button>
                                <button type="submit" value="Actualizar" name="accion" class="btn btn-warning">Actualizar</button>
                            </div>
                        </div>
                    </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body bd-example">
                        <div class="d-flex col-sm-6 ml-auto"><!-- ml-auto para ponerlo a la derecha -->
                            <img src="img/login.png" alt="login" height="70" width="170"/>
                            <label>Número Serie</label>
                        <input type="text" name="NroSerie" class="form-control" value="${nserie}">
                    </div> 
                        <br>
                        <table class="table table-hover">
                            <thead>   
                                <tr>
                                    <th scope="col">Nro</th><!-- columnas -->
                                    <th scope="col">Código</th><!-- comment -->
                                    <th scope="col">Descripción</th>
                                    <th scope="col">Precio</th>
                                    <th scope="col">Cantidad</th>
                                    <th scope="col">Subtotal</th>
                                    <th scope="col" class="parte02">Acciones</th>  
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                <tr>
                                    <td>${list.getItem()}</td>
                                    <td>${list.getIdProducto()}</td>
                                    <td>${list.getDescripcionp()}</td>
                                    <td>${list.getPrecio()}</td>
                                    <td>${list.getCantidad()}</td>
                                    <td>${list.getSubtotal()}</td>
                                    <td class="d-flex">
                                        <a class="btn btn-warning" style="margin-right: 0.3vw" href="Controlador?menu=RegistrarVenta&accion=Editar&idp=${list.getIdProducto()}&iditem=${list.getItem()}">
                                           Editar 
                                        </a>
                                        <a class="btn btn-danger" href="Controlador?menu=RegistrarVenta&accion=Eliminar&itemeli=${list.getItem()}">
                                            Eliminar
                                        </a>
                                    </td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table> 
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <a href="Controlador?menu=RegistrarVenta&accion=GenerarVenta" onclick="print()" class="btn btn-success">Generar Venta</a>
                            <a href="Controlador?menu=RegistrarVenta&accion=Cancelar"  class="btn btn-danger">Cancelar</a>
                        </div>
                        <div class="col-sm-4 ml-auto">
                            <input type="text" name="txtTotal"class="form-control" value="$ ${totalpagar}">
                        </div>
                    </div>
                </div>        
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
    </body>
</html>
