<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 4/1/2024
  Time: 10:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form action="/ctsp/update?id=${ctsp.id}" method="post">
    <div class="mb-3">
        <label for="giaBan" class="form-label">tên sản phẩm</label>
        <select class="form-select" aria-label="Default select example" name="sanPham">
            <c:forEach items="${listSanPham}" var="sp">
                <option value="${sp.id}"
                        <c:if test="${ctsp.sanPham.id==sp.id}">selected</c:if>
                >${sp.tenSanPham}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label for="giaBan" class="form-label">tên màu</label>
        <select class="form-select" aria-label="Default select example" name="mauSac">
            <c:forEach items="${listMauSac}" var="m">
                <option value="${m.id}"
                        <c:if test="${ctsp.mauSac.id==m.id}">selected</c:if>
                >${m.tenMau}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label for="giaBan" class="form-label">tên size</label>
        <select class="form-select" aria-label="Default select example" name="size">
            <c:forEach items="${listSize}" var="m">
                <option value="${m.id}"
                        <c:if test="${ctsp.size.id==m.id}">selected</c:if>
                >${m.tenSz}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label for="giaBan" class="form-label">giá bán</label>
        <input type="text" class="form-control" id="giaBan" name="giaBan" name="giaBan" value="${ctsp.giaBan}">
    </div>
    <div class="mb-3">
        <label for="giaBan" class="form-label">số lượng tồn</label>
        <input type="text" class="form-control" id="soLuongTon" name="soLuongTon" name="soLuongTon" value="${ctsp.soLuongton}">
    </div>
    <div class="mb-3">
        <label for="giaBan" class="form-label">trạng thái</label>
        <div class="form-check" style="margin-left: 10%">
            <input class="form-check-input" type="radio" name="trangThai" value="Active" id="flexRadioDefault1"
            <c:if test="${ctsp.trangThai=='Active'}">checked</c:if>
            >
            <label class="form-check-label" for="flexRadioDefault1">
                Active
            </label>
        </div>
        <div class="form-check" style="margin-left: 10%">
            <input class="form-check-input" type="radio" name="trangThai" value="Inactive" id="flexRadioDefault2"
                   <c:if test="${ctsp.trangThai=='Inactive'}">checked</c:if>
            >
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
