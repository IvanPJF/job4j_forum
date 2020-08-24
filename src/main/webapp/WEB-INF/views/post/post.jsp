<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Create</title>
</head>
<body>
<div class="container">
    <div class="row text-right mt-2">
        <div class="col">
            <a href="<c:url value='/'/>"><b>На главную</b></a>
        </div>
    </div>
    <div class="row justify-content-start mt-2">
        <div class="col">
            <b>Тема: </b>${post.name}<br>
            <b>Автор: </b>${post.user.username}<br>
            <b>Описание: </b>${post.desc}
        </div>
    </div>
    <div class="row justify-content-start">
        <div class="col">
            <b>Комментарии:</b>
        </div>
    </div>
    <div class="row justify-content-md-end text-right">
        <div class="col">
            <a href="<c:url value='/post/comment/create?post.id=${post.id}'/>"><b>Добавить комментарий</b></a>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col" style="width: 20%">Автор</th>
                    <th scope="col" style="width: 50%">Текст</th>
                    <th scope="col" style="width: 20%">Дата создания</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${post.comments}" var="comment">
                    <tr>
                        <td><c:out value="${comment.user.username}"/></td>
                        <td><c:out value="${comment.desc}"/></td>
                        <td><c:out value="${comment.created.time}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>
