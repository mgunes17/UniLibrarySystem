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
        <p style="font-weight: bold; font-size: 30px; color: red;"> Merhaba Sistem Yöneticisi , n'aptın ? </p>
    </div>
    <div align="center">
        Lütfen eklemek istediğiniz envanter tipini seçiniz.
    </div>
    <div id="form" align="center">
        <form name="operate" method="post">
            <table id="choosetable">
                <tr>
                    <td align="left"><input type="submit" name="addbook" value="Kitap Ekle" formaction="addbookservletprep"></td><br>
                </tr>
                <tr>
                    <td align="right"><input type="submit" name="addjournal" value="Dergi Ekle" formaction="addjournalservletprep"></td>
                </tr>
            </table>
        </form>
    </div>
    <c:choose>
        <c:when test="${state eq 1}">
            <div align='center' id="alert2">
                -> Kitap sisteme eklendi.
            </div>
	</c:when>
	<c:when test="${state eq 2}">
            <div align='center' id="alert2">
                -> Dergi sisteme eklendi.
            </div>
	</c:when>
    </c:choose>
</body>
</html>
