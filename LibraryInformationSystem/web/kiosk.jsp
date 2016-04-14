<%-- 
    Document   : kiosk
    Created on : 15.Nis.2016, 00:17:18
    Author     : ercan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Kiosk Makinesi</title>
</head>
<body>
    <div id="form">
        İşlem yapmak istediğiniz kart no ve envanter no giriniz.
        <form name="operate" method="post">
            <table id="choosetable">
                <tr>
                    <td>Kart no:</td>
                    <td><input type="text" value="" name="cardNo"/></td>
                </tr>
                <tr>
                    <td>Envanter no:</td>
                    <td><input type="text" value="" name="itemNo"/></td>
                </tr>
                <tr>
                    <td colspan="2" align="left"><input type="submit" name="borrow" value="Ödünç Al" formaction="borrowservlet"></td>
                    <td colspan="2" align="right"><input type="submit" name="return" value="İade Et" formaction="returnservlet"></td>
                </tr>
            </table>
        </form>
    </div>
    <div>
</div>        
</body>
</html>

