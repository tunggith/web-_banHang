<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 4/2/2024
  Time: 12:49 PM
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
<h1 class="text-center">thêm khách hàng</h1>
<form action="/khach-hang/add" method="post">
    <div class="mb-3">
        <label for="maSv" class="form-label">họ tên</label>
        <input type="text" class="form-control" id="maSv" name="hoTen">
    </div>
    <div class="mb-3">
        <label for="tenSv" class="form-label">địa chỉ</label>
        <input type="text" class="form-control" id="tenSv" name="diaChi">
    </div>
    <div class="mb-3">
        <label for="tenSv" class="form-label">số điện thoại</label>
        <input type="text" class="form-control" id="sdt" name="sdt">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<h1 class="text-center">bảng khách hàng</h1>
<table class="table">
    <thead>
    <tr>
        <th scope="col">stt</th>
        <th scope="col">id</th>
        <th scope="col">họ tên</th>
        <th scope="col">địa chỉ</th>
        <th scope="col">số điện thoại</th>
        <th scope="col">ngày sửa</th>
        <th scope="col">ngày tạo</th>
        <th scope="col">thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listKhachHang}" var="size" varStatus="i">
        <tr>
            <th scope="row">${i.index}</th>
            <td>${size.id}</td>
            <td>${size.hoTen}</td>
            <td>${size.diaChi}</td>
            <td>${size.sdt}</td>
            <td>${size.ngaySua}</td>
            <td>${size.ngayTao}</td>
            <td>
                <a href="/khach-hang/delete?id=${size.id}" type="button" class="btn btn-danger">delete</a>
                <a href="/khach-hang/detail?id=${size.id}" type="button" class="btn btn-info">detail</a>
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
