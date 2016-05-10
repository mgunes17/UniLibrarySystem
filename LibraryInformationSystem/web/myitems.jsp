<%-- 
    Document   : admin
    Created on : 10.May.2016, 21:59:30
    Author     : ercan
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sistem Yönetcisi</title>
</head>
<body>
    <div align="center">
        <p style="font-weight: bold; font-size: 30px; color: red;"> Merhaba Kullanıcı , n'aptın ? </p>
    </div>
    <div id="table" align="center">
        <table border="1">
            <thead>
                <tr>
                    <th>Envanter İsmi</th>
                    <th>Türü</th>
                    <th>Envanter No</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${items}">
                    <tr>
                        <td>${item.itemName}</td>
                        <c:choose>
                            <c:when test="${item.itemType eq 1}">
                                <div>
                                    <td>Kitap</td>
                                </div>
                            </c:when>
                            <c:when test="${item.itemType eq 2}">
                                <div>
                                    <td>Dergi</td>
                                </div>
                            </c:when>
                        </c:choose>
                        <td align='center'>${item.itemNo}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <form name="bookform" method="post" action="userpageservletprep">
        <table id="menu" align='center'>
            <tr>
                <td colspan='2' align="center"><input type="submit" value="Menüye Dön"></td>
            </tr>
        </table>
    </form>
</body>
</html>
