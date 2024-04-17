<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 3/25/2024
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>sinh viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<form action="/sanPham/add" method="post">
        <div class="mb-3">
            <label for="maSv" class="form-label">mã sản phẩm</label>
            <input type="text" class="form-control" id="maSv" name="maSanPham">
        </div>
        <div class="mb-3">
            <label for="tenSv" class="form-label">tên sản phẩm</label>
            <input type="text" class="form-control" id="tenSv" name="tenSanPham">
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
        <div class="mb-3">
            <label for="" class="form-label">danh mục</label>
            <select class="form-select" aria-label="Default select example" name="danhMuc">
                <c:forEach items="${listDanhMuc}" var="dm">
                    <option value="${dm.id}">${dm.tenDanhMuc}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
</form>
<table class="table">
    <thead>
    <tr>
        <th >stt</th>
        <th >mã sản phẩm</th>
        <th >tên sản phẩm</th>
        <th >trang thái</th>
        <th>ngày tạo</th>
        <th>ngày sửa</th>
        <th>mã danh mục</th>
        <th>thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="sinhVien" varStatus="i">
        <tr>
            <td>${sinhVien.id}</td>
            <td>${sinhVien.maSanPham}</td>
            <td>${sinhVien.tenSanPham}</td>
            <td>${sinhVien.trangThai}</td>
            <td><fmt:formatDate value="${sinhVien.ngayTao}" pattern="dd-MM-yyyy"/></td>
            <td><fmt:formatDate value="${sinhVien.ngaySua}" pattern="dd-MM-yyyy"/></td>
            <td>${sinhVien.danhMuc.tenDanhMuc}</td>
            <td>
                <a href="/sanPham/detail?id=${sinhVien.id}" class="btn btn-success">detail</a>
                <a href="/sanPham/delete?id=${sinhVien.id}"><button class="btn btn-info">xóa</button></a>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
