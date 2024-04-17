<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 3/27/2024
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>chi tiết sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="container">
<form action="/ctsp/add" method="post">
    <div class="mb-3">
        <label for="giaBan" class="form-label">tên sản phẩm</label>
        <select class="form-select" aria-label="Default select example" name="sanPham">
            <c:forEach items="${listSanPham}" var="sp">
                <option value="${sp.id}">${sp.tenSanPham}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label for="giaBan" class="form-label">tên màu</label>
        <select class="form-select" aria-label="Default select example" name="mauSac">
            <c:forEach items="${listMauSac}" var="m">
                <option value="${m.id}">${m.tenMau}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label for="giaBan" class="form-label">tên size</label>
        <select class="form-select" aria-label="Default select example" name="size">
            <c:forEach items="${listSize}" var="m">
                <option value="${m.id}">${m.tenSz}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label for="giaBan" class="form-label">giá bán</label>
        <input type="text" class="form-control" id="giaBan" name="giaBan" name="giaBan">
    </div>
    <div class="mb-3">
        <label for="giaBan" class="form-label">số lượng tồn</label>
        <input type="text" class="form-control" id="soLuongTon" name="soLuongTon" name="soLuongTon">
    </div>
    <div class="mb-3">
        <label for="giaBan" class="form-label">trạng thái</label>
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

<table class="table">
    <thead>
    <tr>
        <th scope="col">stt</th>
        <th scope="col">tên màu</th>
        <th scope="col">tên size</th>
        <th scope="col">tên sản phẩm</th>
        <th scope="col">tên danh mục</th>
        <th scope="col">giá bán</th>
        <th scope="col">số lượng</th>
        <th scope="col">trạng thái</th>
        <th scope="col">ngày tạo</th>
        <th scope="col">ngày sửa</th>
        <th scope="col">thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listCtsp}" var="ctsp">
        <tr>
            <th scope="row">${ctsp.id}</th>
            <td>${ctsp.mauSac.tenMau}</td>
            <td>${ctsp.size.tenSz}</td>
            <td>${ctsp.sanPham.tenSanPham}</td>
            <td>${ctsp.sanPham.danhMuc.tenDanhMuc}</td>
            <td>${ctsp.giaBan}</td>
            <td>${ctsp.soLuongton}</td>
            <td>${ctsp.trangThai}</td>
            <td><fmt:formatDate value="${ctsp.ngayTao}" pattern="dd-MM-yyyy"/></td>
            <td><fmt:formatDate value="${ctsp.ngaySua}" pattern="dd-YY-yyyy"/></td>
            <td>
                <a href="/ctsp/delete?id=${ctsp.id}" type="button" class="btn btn-danger">xóa</a>
                <a href="/ctsp/detail?id=${ctsp.id}" type="button" class="btn btn-info">detail</a>
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
