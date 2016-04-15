<%-- 
    Document   : index
    Created on : 15.Nis.2016, 00:56:39
    Author     : must
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Anasayfa</title>
</head>
<body>
    <h2>Aydınlık Üniversitesi Kütüphane Bilgi Sistemine Hoşgeldiniz! </h2>
    <h3>Lütfen Giriş Yapınız </h3>
    
    <form action ="logincontrolservlet" method ="POST">
        Akıllı Kart Numaranız:</br>
        <input type="text" name="card_no"/></br>
        Akıllı Kart Şifreniz:</br>
        <input type="password" name="password"/></br>
        <input type="submit" value="Giriş Yap"/>
    </form>
</body>
</html>
