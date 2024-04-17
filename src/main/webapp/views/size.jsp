<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 3/22/2024
  Time: 3:33 PM
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
<h1 class="text-center">thêm size</h1>
<form action="/size/add" method="post">
    <div class="mb-3">
        <label for="maSv" class="form-label">ma size</label>
        <input type="text" class="form-control" id="maSv" name="maSz">
    </div>
    <div class="mb-3">
        <label for="tenSv" class="form-label">tên size</label>
        <input type="text" class="form-control" id="tenSv" name="tenSz">
    </div>
    <div class="mb-3">
        <label for="" class="form-label">trạng thái</label>
        <div class="form-check" style="margin-left: 10%">
            <input class="form-check-input" type="radio" name="trangThai" value="Active" id="flexRadioDefault1">
            <label class="form-check-label" for="flexRadioDefault1">
                Active
            </label>
        </div>
        <div class="form-check" style="margin-left: 10%">
            <input class="form-check-input" type="radio" name="trangThai" value="Inactive" id="flexRadioDefault2" checked>
            <label class="form-check-label" for="flexRadioDefault2">
                Inactive
            </label>
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<h1 class="text-center">bảng size</h1>
<table class="table">
    <thead>
    <tr>
        <th scope="col">stt</th>
        <th scope="col">id</th>
        <th scope="col">mã size</th>
        <th scope="col">ten size</th>
        <th scope="col">trang thái</th>
        <th scope="col">ngày sửa</th>
        <th scope="col">ngày tạo</th>
        <th scope="col">thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listSize}" var="size" varStatus="i">
        <tr>
            <th scope="row">${i.index}</th>
            <td>${size.id}</td>
            <td>${size.maSz}</td>
            <td>${size.tenSz}</td>
            <td>${size.trangThai}</td>
            <td>${size.ngaySua}</td>
            <td>${size.ngayTao}</td>
            <td>
                <a href="/size/delete?id=${size.id}" type="button" class="btn btn-danger">delete</a>
                <a href="/size/detail?id=${size.id}" type="button" class="btn btn-info">detail</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
