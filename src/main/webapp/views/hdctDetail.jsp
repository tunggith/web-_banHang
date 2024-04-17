<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 4/2/2024
  Time: 2:18 PM
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
<h1 class="text-center">chi tiết hóa đơn chi tiết</h1>
<form action="/hdct/update?id=${hdct.id}" method="post">
    <div class="mb-3">
        <label for="" class="form-label">hóa đơn</label>
        <select class="form-select" aria-label="Default select example" name="hoaDon">
            <c:forEach items="${listHoaDon}" var="dm">
                <option value="${dm.id}"
                        <c:if test="${hdct.hoaDon.id==dm.id}">selected</c:if>
                >${dm.id}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label for="" class="form-label">tên sản phẩm</label>
        <select class="form-select" aria-label="Default select example" name="sanPham">
            <c:forEach items="${listCtsp}" var="dm">
                <option value="${dm.id}"
                        <c:if test="${hdct.ctsp.id==dm.id}">selected</c:if>
                >${dm.sanPham.tenSanPham}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label for="tenSv" class="form-label">số lượng mua</label>
        <input type="text" class="form-control" id="tenSv" name="soLuongMua" value="${hdct.soLuongMua}">
    </div>
    <div class="mb-3">
        <label for="tenSv" class="form-label">giá bán</label>
        <input type="text" class="form-control" id="sdt" name="giaBan" value="${hdct.giaBan}">
    </div>
    <div class="mb-3">
        <label for="tenSv" class="form-label">tổng tiền</label>
        <input type="text" class="form-control" id="tongTien" name="tongTien" value="${hdct.tongTien}">
    </div>
    <div class="mb-3">
        <label for="" class="form-label">trạng thái</label>
        <div class="form-check" style="margin-left: 10%">
            <input class="form-check-input" type="radio" name="trangThai" value="da thanh toan" id="flexRadioDefault1">
            <label class="form-check-label" for="flexRadioDefault1">
                da thanh toan
            </label>
        </div>
        <div class="form-check" style="margin-left: 10%">
            <input class="form-check-input" type="radio" name="trangThai" value="chua thanh toan" id="flexRadioDefault2" checked>
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

