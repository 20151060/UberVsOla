<%-- 
    Document   : result
    Created on : Mar 18, 2019, 8:52:13 PM
    Author     : rohanarora
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>result Page</title>
    </head>
    <body>
      
        <h1>Beer Recommendations</h1>
        <p>
            <%
            String styles = (String)request.getAttribute("styles");
            out.print("<br>try : " + styles);
            %>
        </p>
    </body>
</html>
