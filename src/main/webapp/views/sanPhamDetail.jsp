<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 3/27/2024
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form action="/sanPham/update?id=${sanPham.id}" method="post">
    <div class="mb-3">
        <label for="maSv" class="form-label">mã sản phẩm</label>
        <input type="text" class="form-control" id="maSv" name="maSanPham" value="${sanPham.maSanPham}">
    </div>
    <div class="mb-3">
        <label for="tenSv" class="form-label">tên sản phẩm</label>
        <input type="text" class="form-control" id="tenSv" name="tenSanPham" value="${sanPham.tenSanPham}">
    </div>
    <div class="mb-3">
        <label for="flexRadioDefault1" class="form-label">trạng thái</label>
        <div class="form-check" style="margin-left: 10%">
            <input class="form-check-input" type="radio" name="trangThai" value="Active" id="flexRadioDefault1"
                   <c:if test="${sanPham.trangThai == 'Active'}">checked</c:if>
            >
            <label class="form-check-label" for="flexRadioDefault1">
                Active
            </label>
        </div>
        <div class="form-check" style="margin-left: 10%">
            <input class="form-check-input" type="radio" name="trangThai" value="Inactive" id="flexRadioDefault2"
                   <c:if test="${sanPham.trangThai == 'Inactive'}">checked</c:if>
            >
            <label class="form-check-label" for="flexRadioDefault2">
                Inactive
            </label>
        </div>
    </div>
    <div class="mb-3">
        <label for="" class="form-label">danh mục</label>
        <select class="form-select" aria-label="Default select example" name="danhMuc">
            <c:forEach items="${listDanhMuc}" var="dm">
                <option value="${dm.id}"
                        <c:if test="${sanPham.danhMuc==dm}">selected</c:if>
                >${dm.tenDanhMuc}</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
