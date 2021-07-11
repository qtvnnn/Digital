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
        <title>Right</title>
        <link href="css/right.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div class="right">
                <div class="newst">
                    <div class="titleNews">
                        <span>Digital News</span>
                    </div>
                    <div class="contentNews">
                        ${top6.get(0).shortDes}
                    </div>
                </div>
                <div class="newst">
                    <div class="titleNews">
                        Search
                    </div>
                    <form action="SearchControl" method="post">
                        <c:if test="${search == null}">
                        <input class="searchBox" type="text" name="txtSearch" size="15" required pattern="^([a-zA-Z0-9]+\s)*[a-zA-Z0-9]+$">
                        </c:if>
                        <c:if test="${search != null}">
                        <input class="searchBox" type="text" name="txtSearch" size="15" value="${search.trim()}" required pattern="^([a-zA-Z0-9]+\s)*[a-zA-Z0-9]+$">
                        </c:if>
                        <input class="searchButton" type="submit" name="btnGo" value="Go">
                    </form>                        
                </div>
                <div class="newst">
                    <div class="titleNews">
                        <span>Last Articles</span><br>
                    </div>
                    <c:forEach items="${top6}" begin="1" end="5" var="i">
                    <div class="lastArticles">
                        <a href="DetailControl?id=${i.id}">${i.title}</a>
                    </div>
                </c:forEach>
            </div>
        </div>    
    </body>
</html>
