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
    <p align='center' style="font-weight: bold; font-size: 30px; color: red;"> Aydınlık Üniversitesi Kütüphane Bilgi Sistemine Hoşgeldiniz! </p>
    <p align='center' style="font-weight: bold; font-size: 30px; color: red;"> Lütfen Giriş Yapınız  </p>
    <form align='center' action ="logincontrolservlet" method ="POST">
        Akıllı Kart Numaranız:</br>
        <input type="text" name="card_no"/></br>
        Akıllı Kart Şifreniz:</br>
        <input type="password" name="password"/></br>
        <input type="submit" value="Giriş Yap"/>
    </form>
</body>
</html>
