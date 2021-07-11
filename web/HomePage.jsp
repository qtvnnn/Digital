<%--  
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0004<br>
 * Digital News<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-05-18    1.0        NangNN           First Version<br>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body> 
       <div class="container">
           <%@include file="Header.jsp"%>
            <div class="content">
                <div class="main">
                    <div class="tittle">
                        ${top6.get(0).title}
                    </div>
                    <div class="image">
                        <img src="images/${top6.get(0).image}"/>
                    </div>
                    <div class="text">
                        ${top6.get(0).description} 
                    </div>
                    <div class="signature">
                        <div class="icon1"></div>
                        <div class="icon2"></div>
                        By ${top6.get(0).author} | ${top6.get(0).timePost}
                    </div>
                </div>
                <%@include file="Right.jsp"%> 
            </div>
            <%@include file="Footer.jsp"%>
        </div>
    </body>
</html>
