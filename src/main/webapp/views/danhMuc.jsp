<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 3/26/2024
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>sinh viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body class="container">
<div>
    <h1>đây là trang sửa</h1>
    <form action="/danhMuc/add" method="post">
        <div class="mb-3">
            <label for="maSv" class="form-label">mã danh mục</label>
            <input type="text" class="form-control" id="maSv" name="maDanhMuc">
        </div>
        <div class="mb-3">
            <label for="tenSv" class="form-label">tên danh mục</label>
            <input type="text" class="form-control" id="tenSv" name="tenDanhMuc">
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
</div>
<hr>
<table class="table">
    <thead>
    <tr>
        <th>STT</th>
        <th>MÃ DANH MỤC</th>
        <th>TÊN DANH MỤC</th>
        <th>TRẠNG THÁI</th>
        <th>NGÀY TẠO</th>
        <th>NGÀY SỬA</th>
        <th>THAO TÁC</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listDanhMuc}" var="d">
        <tr>
            <td>${d.id}</td>
            <td>${d.maDanhMuc}</td>
            <td>${d.tenDanhMuc}</td>
            <td>${d.trangThai}</td>
            <td><fmt:formatDate value="${d.ngayTao}" pattern="dd-MM-yyyy" /></td>
            <td><fmt:formatDate value="${d.ngaySua}" pattern="dd-MM-yyyy" /></td>
<%--            <td>${d.ngayTao}</td>--%>
<%--            <td>${d.ngaySua}</td>--%>
            <td>
                <a href="/danhMuc/detail?id=${d.id}" class="btn btn-info">Cập nhật</a>
                <a href="/danhMuc/delete?id=${d.id}" class="btn btn-danger">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
