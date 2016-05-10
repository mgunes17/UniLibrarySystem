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
    <div align="center">
        Yapmak istediğiniz işlemi seçin.
    </div>
    <div id="form" align="center">
        <form name="user" method="post">
            <table id="choosetable">
                <tr>
                    <td align="center"><input type="submit" name="addbalance" value="Bakiye Yükle" formaction="addbalanceservletprep"></td><br>
                </tr>
                <tr>
                    <td align="center"><input type="submit" name="myitems" value="Üzerimdekiler" formaction="showmyitemsservlet"></td>
                </tr>
                <tr>
                    <td align="center"><input type="submit" name="myitems" value="Kioska Git" formaction="kioskprep"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
