<%-- 
    Document   : kiosk
    Created on : 15.Nis.2016, 00:17:18
    Author     : ercan
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Kiosk Makinesi</title>
</head>
<body>
    <div id="form" align='center'>
        İşlem yapmak istediğiniz kart no ve envanter no giriniz.
        <form name="operate" method="post">
            <table id="choosetable">
                <tr>
                    <td colspan="1">Kart no:</td>
                    <td colspan="2"><input type="text" value="" name="cardNo"/></td>
                </tr>
                <tr>
                    <td colspan="1">Envanter no:</td>
                    <td colspan="2"><input type="text" value="" name="itemNo"/></td>
                </tr>
                <tr>
                    <td align="left"><input type="submit" name="borrow" value="Ödünç Al" formaction="borrowitemservlet"></td>
                    <td align="center"><input type="submit" name="return" value="İade Et" formaction="returnitemservlet"></td>
                    <td align="right"><input type="submit" name="reserve" value="Rezerve Et" formaction="reserveitemservlet"></td>
                </tr>
            </table>
        </form>
    </div>
    <form name="bookform" method="post" action="userpageservletprep">
        <table id="booktable" align='center'>
            <tr>
                <td colspan='2' align="center"><input type="submit" value="Menüye Dön"></td>
            </tr>
        </table>
    </form>
    <div align='center'>
        <c:choose>
            <c:when test="${state eq 0}">
                    <div id="alert2">
                        -> Böyle bir akıllı kart bulunamadı. Lütfen kart numaranızı tekrar giriniz.
                    </div>
            </c:when>
            <c:when test="${state eq 1}">
                    <div id="alert2">
                        -> Böyle bir envanter bulunamadı. Lütfen envanter numarasını tekrar giriniz.
                    </div>
            </c:when>
            <c:when test="${state eq 2}">
                    <div id="alert">
                        -> Ödünç almaya çalıştığınız envanter boşta değildir. <br>
                        Bu envanteri ödünç alamazsınız.
                    </div>
            </c:when>
            <c:when test="${state eq 3}">
                    <div id="alert">
                        -> Envanter ödünç alma kapasiteniz dolmuştur.
                    </div>
            </c:when>
            <c:when test="${state eq 4}">
                    <div id="alert">
                        -> Envanter ödünç alınmıştır. K.gele.
                    </div>
            </c:when>
            <c:when test="${state eq 5}">
                    <div id="alert">
                        -> Bu envanter sizin üzerinize kayıtlı değildir. İade işlemi yapamazsınız.
                    </div>
            </c:when>
            <c:when test="${state eq 7}">
                    <div id="alert">
                        -> İade işleminiz tamamlanmıştır.
                    </div>
            </c:when>
            <c:when test="${state eq 8}">
                    <div id="alert">
                        -> Yeterli bakiyeniz bulunmamaktadır.
                    </div>
            </c:when>
            <c:when test="${state eq 9}">
                    <div id="alert">
                        -> Envanteri geç getirdiğiniz için ceza uygulanmıştır. <br>
                        Ceza miktarı : ${amount} TL , Yeni Bakiye : ${newbalance}
                    </div>
            </c:when>
            <c:when test="${state eq 10}">
                    <div id="alert">
                        -> Rezever etmeye çalıştığınız envanter zaten rezervelidir. <br>
                        Bu envanteri rezerve edemezsiniz.
                    </div>
            </c:when>
            <c:when test="${state eq 11}">
                    <div id="alert">
                        -> Envanter rezerve edilmiştir. K.gele.
                    </div>
            </c:when>
        </c:choose>
    </div>
</body>
</html>

