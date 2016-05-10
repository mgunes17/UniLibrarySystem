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
    <div id="journaldiv" align='center'>
        <form name="journalform" method="post" action="addjournalservlet">
            <table id="journaltable">
                <tr>
                    <td>Dergi İsmi</td>
                    <td><input type="text" value="" name="name" /></td>
                </tr>
                <tr>
                    <td>Editor</td>
                    <td><input type="text" value="" name="editor" /></td>
                </tr>
                <tr>
                    <td>Sayısı</td>
                    <td><input type="text" value="" name="issue"  /></td>
                </tr>
                <tr> 
                    <td>Yayınlanma Tarihi</td>
                    <td><input type="text" value="" name="publicationdate"  /></td>
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
	<c:when test="${state eq 2}">
            <div align='center' id="alert2">
                -> Dergi sisteme eklendi.
            </div>
	</c:when>
    </c:choose>
</body>
</html>
