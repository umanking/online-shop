<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div>
    <form role="form" action="/order" method="post">
        <div>
            <label for="member">주문회원</label>
            <select name="memberId" id="member">
                <option value="">회원선택</option>
                <c:forEach var="member" items="${members}">
                    <option value="${member.id}">${member.name}</option>
                </c:forEach>
            </select>
        </div>

        <div>
            <label for="item">상품명</label>
            <select name="itemId" id="item">
                <option value="">상품선택</option>
                <c:forEach var="item" items="items">
                    <option value="${item.id}">${item.name}</option>
                </c:forEach>
            </select>
        </div>

        <div>
            <label for="count">주문수량</label>
            <input type="number" name="count" id="count" placeholder="주문 수량을 입력하세요"/>
        </div>

        <button type="submit">Submit</button>
    </form>


</div>
</body>
</html>