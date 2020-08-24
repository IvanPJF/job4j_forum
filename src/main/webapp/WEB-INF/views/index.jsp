<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script>
        function toPost(id) {
            window.location.href = "/post?id=" + id;
        }
    </script>
    <title>Форум job4j</title>
</head>
<body>
<div class="container">
    <div class="row justify-content-md-end text-right pt-2">
        <div class="col-3">
            Login as: <b>${user.username}</b> [<a href="<c:url value='/logout'/>">logout</a>]
        </div>
    </div>
    <div class="row justify-content-md-center text-center">
        <div class="col h4">
            Форум job4j
        </div>
    </div>
    <div class="row justify-content-md-end text-right">
        <div class="col-3">
            <a href="<c:url value='/edit'/>"><b>Добавить тему</b></a>
        </div>
    </div>
    <div class="row mt-1">
        <table class="table">
            <thead>
            <tr>
                <th scope="col" style="width: 20%">Тема</th>
                <th scope="col" style="width: 10%">Автор</th>
                <th scope="col" style="width: 50%">Описание</th>
                <th scope="col" style="width: 15%">Дата создания</th>
                <th scope="col" style="width: 5%"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${posts}" var="post">
                <tr onclick="toPost(${post.id})">
                    <td><c:out value="${post.name}"/></td>
                    <td><c:out value="${post.user.username}"/></td>
                    <td><c:out value="${post.desc}"/></td>
                    <td><c:out value="${post.created.time}"/></td>
                    <td>
                        <c:if test="${post.user.username == user.username}">
                            <form action="<c:url value='/edit'/>">
                                <input type="hidden" name="id" value="${post.id}">
                                <input type="submit" class="btn btn-block btn-warning" value="edit"/>
                            </form>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
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