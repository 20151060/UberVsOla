<%-- 
    Document   : result
    Created on : Apr 23, 2019, 9:06:37 PM
    Author     : rohanarora
--%>

<%@page import="model.rideInfo"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>Hello, world!</title>
    <style>
        .navbar{
            margin-bottom: 0;
            border-radius: 0;
        }
       .padding{
            padding-left: 220px;
        }
    </style>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
        <span class="navbar-brand  h1">Home</span>
        </nav>
        
            <div class="row">        
            <div class="col-md-6" style="background-color: black; height:740px">
            <img src="u.jpg" alt="..." style="height : 200px" class="padding">
            <p class="padding" style="color: white">
                <%
                ArrayList arr = (ArrayList)request.getAttribute("uber");
                Iterator itr = arr.iterator();
                 while(itr.hasNext()){
                     rideInfo r = (rideInfo) itr.next();
                 out.println(r.getrideType() + " : " + r.getprice() + "<br>");
                 }
                %>
            </p>    
            </div>
            <div class="col-md-6" style="background-color: #EA0B8C; height:740px">
            <img src="l1.jpg" alt="..." style="height : 200px" class="padding">
            <p  class="padding" style="color: white">
              <%
                ArrayList arr1 = (ArrayList)request.getAttribute("lyft");
                Iterator itr1 = arr1.iterator();
                 while(itr1.hasNext()){
                     rideInfo r1 = (rideInfo) itr1.next();
                 out.println(r1.getrideType() + " : " + "$" + r1.getpriceMin() + "-" + r1.getpriceMax() + "<br>");
                 }
                %>
            </p>
            </div>   
            </div> 
        
        <div class="row">
        <div claas="col-md-6">
            
        </div>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.2.min.js"><\/script>');</script>

        <script src="js/vendor/bootstrap.min.js"></script>

        <script src="js/main.js"></script>
    </body>
</html>
