<%-- 
    Document   : admin
    Created on : 10.May.2016, 21:18:16
    Author     : ercan
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kitap Ekle</title>
</head>
<body>
    <div id="bookdiv" align='center'>
        <form name="bookform" method="post" action="addbookservlet">
            <table id="booktable">
                <tr>
                    <td>Kitap İsmi</td>
                    <td><input type="text" value="" name="name" required/></td>
                </tr>
                <tr>
                    <td>Yazar</td>
                    <td><input type="text" value="" name="author" required/></td>
                </tr>
                <tr>
                    <td>Yayım Yılı</td>
                    <td><input type="text" value="" name="publicationyear" required /></td>
                </tr>
                <tr> 
                    <td>Yayım Evi</td>
                    <td><input type="text" value="" name="publisher" required /></td>
                </tr>
                <tr>
                    <td colspan='2' align="center"><input type="submit" value="Ekle"></td>
                </tr>
            </table>
        </form>
    </div>
    <form name="bookform" method="post" action="adminservletprep">
        <table id="booktable" align='center'>
            <tr>
                <td colspan='2' align="center"><input type="submit" value="Menüye Dön"></td>
            </tr>
        </table>
    </form>
    <c:choose>
        <c:when test="${state eq 1}">
            <div align='center' id="alert2">
                -> Kitap sisteme eklendi.
            </div>
	</c:when>
    </c:choose>
</body>
</html>
