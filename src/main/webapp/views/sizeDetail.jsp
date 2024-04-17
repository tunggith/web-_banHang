<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 4/2/2024
  Time: 9:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<h1 class="text-center">chi tiết size</h1>
<form action="/size/update?id=${size.id}" method="post">
    <div class="mb-3">
        <label for="maSv" class="form-label">ma size</label>
        <input type="text" class="form-control" id="maSv" name="maSz" value="${size.maSz}">
    </div>
    <div class="mb-3">
        <label for="tenSv" class="form-label">tên size</label>
        <input type="text" class="form-control" id="tenSv" name="tenSz" value="${size.tenSz}">
    </div>
    <div class="mb-3">
        <label for="" class="form-label">trạng thái</label>
        <div class="form-check" style="margin-left: 10%">
            <input class="form-check-input" type="radio" name="trangThai" value="Active" id="flexRadioDefault1"
            <c:if test="${size.trangThai == 'Active'}">checked</c:if>
            >
            <label class="form-check-label" for="flexRadioDefault1">
                Active
            </label>
        </div>
        <div class="form-check" style="margin-left: 10%">
            <input class="form-check-input" type="radio" name="trangThai" value="Inactive" id="flexRadioDefault2"
                   <c:if test="${size.trangThai == 'Inactive'}">checked</c:if>>
            <label class="form-check-label" for="flexRadioDefault2">
                Inactive
            </label>
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
