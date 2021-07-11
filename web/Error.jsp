<%--  
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0004<br>
 * Digital News<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-05-18    1.0        NangNN           First Version<br>
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div class="container">
            <%@include file="Header.jsp"%>
            <div class="content"><b>${message}</b>  
                <div class="main">
                    <h3>${error}</h3>
                </div>
                <%@include file="Right.jsp"%> 
            </div>
            <%@include file="Footer.jsp"%>
        </div>
    </body>
</html>
