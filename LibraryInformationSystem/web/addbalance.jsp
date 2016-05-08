<%-- 
    Document   : addbalance
    Created on : 09.May.2016, 00:25:50
    Author     : must
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Bakiye Yükle</title>
</head>
<body>
    <h1>Akıllı kartınıza para yükleyin</h1>
    
    <form method="POST" action="">
        Kredi kartı numaranız</br>
        <input type="text" name="cardNo"/></br>
        Yüklemek istediğiniz değer</br>
        <input type="text" name="amount"/></br></br>
        
        <input type="submit" value="Yükle"/>
    </form>
    
    <%-- AddBalanceServletteki yorumları yazdır --%>
</body>
</html>
