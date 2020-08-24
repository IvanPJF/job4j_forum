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
    <div class="row justify-content-md-center pt-5">
        <h2>
            Напишите комментарий
        </h2>
    </div>
    <div class="row justify-content-center pt-5">
        <div class="col-auto">
            <form action="<c:url value='/post/comment/save?post.id=${post.id}'/>" method="post" id="formSave">
                <div class="form-group row">
                    <label for="desc">Комментарий:</label>
                    <textarea class="form-control" id="desc" name="desc" rows="5"></textarea>
                </div>
            </form>
            <div class="row">
                <div class="col">
                    <form action="<c:url value='/post'/>">
                        <input type="hidden" name="id" value="${post.id}"/>
                        <input type="submit" class="btn btn-block btn-success" value="Отмена"/>
                    </form>
                </div>
                <div class="col">
                    <input form="formSave" type="submit" class="btn btn-block btn-success" value="Сохранить"/>
                </div>
            </div>
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
