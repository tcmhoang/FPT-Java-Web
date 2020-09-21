<%-- 
    Document   : index
    Created on : Sep 21, 2020, 4:52:50 AM
    Author     : Camer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Pinterest</title>
        <link rel="stylesheet" href= "${pageContext.request.contextPath}/static/style.css" type="text/css"/>
        <script src="${pageContext.request.contextPath}/static/script.js"></script>
    </head>
    <body>
        <header class="pinterest-header">
            <h3 class="header-logo">Pinterest</h3>
            <div class="header-item">Explore</div>
            <div class="input-wrapper">
                <input
                    type="text"
                    placeholder="Search for easy dinners, fashion, etc"
                    />
            </div>
        </header>
            <div class="container">
            <c:forEach begin="1" end="${initParam['tile-quantity']}" step="1">
                <div class="col"></div>
            </c:forEach>
        </div>
    </body>
</html>
