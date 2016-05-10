<%-- 
    Document   : addbalance
    Created on : 09.May.2016, 00:25:50
    Author     : must
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Bakiye Yükle</title>
</head>
<body>
    <p align='center' style="font-weight: bold; font-size: 30px; color: red;"> Akıllı kartınıza para yükleyin </p>
    
    <form align='center' method="POST" action="addbalanceservlet">
        Kredi kartı numaranız</br>
        <input type="text" name="cardNo"/></br>
        Yüklemek istediğiniz değer</br>
        <input type="text" name="amount"/></br></br>
        
        <input type="submit" value="Yükle"/>
    </form>
    <form name="bookform" method="post" action="userpageservletprep">
        <table id="menu" align='center'>
            <tr>
                <td colspan='2' align="center"><input type="submit" value="Menüye Dön"></td>
            </tr>
        </table>
    </form>
    <c:choose>
        <c:when test="${result eq 0}">
            <div align='center'>
                -> Bakiye yükleme işlemi gerçekleştirilemedi. <br>
                Bakiyeniz +0 olacak şekilde para yükleyebilirsiniz.
            </div>
        </c:when>
        <c:when test="${result eq 1}">
            <div align='center'>
                -> Bakiye yükleme işlemi başarıyla gerçekleşti. <br>
            Mevcut bakiyeniz : ${balance}
            </div>  
        </c:when>
    </c:choose>
    
    <%-- AddBalanceServletteki yorumları yazdır --%>
</body>
</html>
