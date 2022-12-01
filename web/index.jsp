<%-- 
    Document   : index
    Created on : Nov 12, 2022, 4:30:16 PM
    Author     : DieguilloPillo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <title>Ingreso</title>
    </head>
    <body style="background-image:url(img/one-piece-monkey-d-luffy-manga-hd-wallpaper-preview.jpg);
    background-attachment: fixed;
    background-size: contain;
    background-repeat: repeat">
        <div class="container mt-4 col-lg-4">
            <div class="card col-sm-10">
                <div class="card-body">
                    <form class="form-sign" action="Validar?accion=Ingresar" method="POST" >
                        <div class="form-group text-center">
                            <img src="img/login.png" alt="login" height="70" width="170"/>
                            <br><label>Bienvenido!</label>
                        </div>
                        <div class="form-group">
                            <label for="txtuser">Usuario:</label>
                            <input type="text" name="txtuser" class="form-control">
                        </div>
                        <div class="form-group">
                           <label for="txtpass">Contraseña:</label>
                            <input type="password" name="txtpass" class="form-control"> 
                        </div>
                        <input type="submit" name="tbnIngresar" value="Ingresar" class="btn btn-outline-dark btn-block">
                    </form>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
    </body>
</html>
