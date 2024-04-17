<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 4/2/2024
  Time: 1:41 PM
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
<h1 class="text-center">thêm hóa đơn</h1>
<form action="/hoa-don/update?id=${hoaDon.id}" method="post">
    <div class="mb-3">
        <label for="" class="form-label">tên khách hàng</label>
        <select class="form-select" aria-label="Default select example" name="khachHang">
            <c:forEach items="${listKhachHang}" var="dm">
                <option value="${dm.id}"
                        <c:if test="${hoaDon.khachHang.id==dm.id}">selected</c:if>
                >${dm.hoTen}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label for="tenSv" class="form-label">địa chỉ</label>
        <input type="text" class="form-control" id="tenSv" name="diaChi" value="${hoaDon.diaChi}">
    </div>
    <div class="mb-3">
        <label for="tenSv" class="form-label">số điện thoại</label>
        <input type="text" class="form-control" id="sdt" name="sdt" value="${hoaDon.sdt}">
    </div>
    <div class="mb-3">
        <label for="" class="form-label">trạng thái</label>
        <div class="form-check" style="margin-left: 10%">
            <input class="form-check-input" type="radio" name="trangThai" value="Da thanh toan" id="flexRadioDefault1"
            <c:if test="${hoaDon.trangThai=='Da thanh toan'}">checked</c:if>
            >
            <label class="form-check-label" for="flexRadioDefault1">
                da thanh toan
            </label>
        </div>
        <div class="form-check" style="margin-left: 10%">
            <input class="form-check-input" type="radio" name="trangThai" value="Chua thanh toan" id="flexRadioDefault2"
                   <c:if test="${hoaDon.trangThai=='Chua thanh toan'}">checked</c:if>
            >
            <label class="form-check-label" for="flexRadioDefault2">
                chua thanh toan
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
