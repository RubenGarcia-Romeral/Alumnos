<%-- 
    Document   : mensajeAlumnos
    Created on : 5 feb. 2021, 10:38:08
    Author     : User
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Alumno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <title>JSP Page</title>
    </head>
    <body>
        
        
        <%
        String grupoSeleccionado = (String)request.getAttribute("grupo");
        ArrayList<Alumno> seleccionados = (ArrayList<Alumno>) request.getAttribute("seleccionados");
        %>
        
        
        <div class="container">
            
            
            <div class="row">
                
                <div class="col-mb">
                    
                    
                    <h3 style="font-family: Arial; color: #00ffcc">Alumno del grupo seleccionado: <%=grupoSeleccionado%></h3>
                    
                    
                    <form action="AlumnosServlet" method="post">
                        
                        
                        <table class="table">
                            
                            <tr>
                                <th></th>
                                <th>Nombre del alumno: </th>
                                <th>Apellidos del alumno: </th>
                                <th>Email del alumno:</th>
                            </tr>
                            
                            
                                <%for(Alumno a: seleccionados){%>
                            <tr>
                                
                                
                                <td><%= a.getNombre() %></td>
                                <td><%= a.getApellidos() %></td>
                                <td><%= a.getEmail() %></td>
                            </tr>
                            
                            
                            <%}%>
                        </table> 
                        
                        
                        <textarea style="background-color: #99ffff" class="form-control" name="mensaje"></textarea><br>
                        
                        
                        <input class="brn btn-primary" type="submit" value="Enviar mensaje" style="border-radius: 10px; background-color: red; border-color: green;">
                        
                        
                        
                    </form>
                        
                </div>
            </div>
                        
        </div>
                        
    </body>
    
    
</html>
