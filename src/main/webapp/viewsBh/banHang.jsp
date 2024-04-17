<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 4/2/2024
  Time: 4:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<div class="row">
    <div class="col-7">
        <h2>Danh sách hoá đơn</h2>
        <table class="table">
            <thead>
            <tr>
                <td>STT</td>
                <td>ID</td>
                <td>Ten khach hang</td>
                <td>Ngay tao</td>
                <td>Tong tien</td>
                <td>Trang Thai</td>
                <td>Chuc nang</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listHoaDon}" var="hoaDon" varStatus="i">
                <tr>
                    <td>${i.index}</td>
                    <td>${hoaDon.id}</td>
                    <td>${hoaDon.khachHang.hoTen}</td>
                    <td>${hoaDon.ngayTao}</td>
                    <td>
                        <c:set var="tongTien" value="0"/>
                        <c:forEach items="${hdct}" var="hdct">
                            <c:if test="${hdct.hoaDon.id == hoaDon.id}">
                                <c:set var="tongTien" value="${tongTien + hdct.tongTien}"/>
                            </c:if>
                        </c:forEach>
                            ${tongTien}
                    </td>
                    <td>${hoaDon.trangThai}</td>
                    <td>
                        <a href="/ban-hang/detail?id=${hoaDon.id}" type="button" class="btn btn-primary">chọn</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <h2>Danh sách hoá đơn chi tiết</h2>
        <table class="table">
            <thead>
            <tr>
                <td>STT</td>
                <td>ID</td>
                <td>Ten san pham</td>
                <td>So luong</td>
                <td>Gia ban</td>
                <td>Tong tien</td>
                <td>Chuc nang</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listHdct}" var="hdct" varStatus="i">
                <tr>
                    <td>${i.index}</td>
                    <td>${hdct.id}</td>
                    <td>${hdct.ctsp.sanPham.tenSanPham}</td>
                    <td>${hdct.soLuongMua}</td>
                    <td>${hdct.giaBan}</td>
                    <td>${hdct.tongTien}</td>
                    <td>
                        <a href="/ban-hang/delete-san-pham?idCtsp=${hdct.id}" type="button" class="btn btn-danger">xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="col-5">
        <h2>Tạo hoá đơn</h2>
        <div class="row">
            <form action="">

            </form>
            <form action="/ban-hang/search" method="post">
                <div>
                    <div>
                        <label class="mb-3 col-3">Số điện thoại</label>
                        <input type="text" class="col-7" name="sdt" value="${khachHang.sdt}">
                    </div>
                    <button type="submit" class="btn btn-primary">Search</button>
                </div>
                <div class="mb-3">
                    <label class="col-3">Ten Khach hang</label>
                    <input type="text" class="col-7" readonly value="${khachHang.hoTen}">
                </div>
                <div class="mb-3">
                    <label class="col-3">ID Hoa don</label>
                    <input type="text" class="col-7" name="id" value="${hdctId.id}" readonly>
                </div>
                <div class="mb-3">
                    <label class="col-3">Tong tien</label>
                    <input type="text" class="col-7" value="${tongTienH}" readonly>
                </div>
                <div>
                    <a href="/ban-hang/addHoaDon?sdt=${khachHang.sdt}" type="button" class="btn btn-primary" >Tạo hoá đơn</a>
                    <a href="/ban-hang/thanh-toan?id=${hdctId.id}" type="button" class="btn btn-primary">Thanh toán</a>
                </div>
            </form>
        </div>

    </div>
</div>
<div>
    <h2>Danh sách chi tiếtsản phẩm</h2>
    <table class="table">
        <thead>
        <tr>
            <td>STT</td>
            <td>ID CTSP</td>
            <td>Ten san pham</td>
            <td>Mau sac</td>
            <td>Size</td>
            <td>Gia ban</td>
            <td>So luong ton</td>
            <td>Trang Thai</td>
            <td>Chuc nang</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listCtsp}" var="ctsp" varStatus="i">
            <tr>
                <td>${i.index}</td>
                <td>${ctsp.id}</td>
                <td>${ctsp.sanPham.tenSanPham}</td>
                <td>${ctsp.mauSac.tenMau}</td>
                <td>${ctsp.size.tenSz}</td>
                <td>${ctsp.giaBan}</td>
                <td>${ctsp.soLuongton}</td>
                <td>${ctsp.trangThai}</td>
                <td>
                    <a href="/ban-hang/add-san-pham?id_sanPham=${ctsp.id}" type="button" class="btn btn-primary">Chọn mua</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<% if (session.getAttribute("message") != null) { %>
<script>
    alert('<%= session.getAttribute("message") %>');
</script>
<% session.removeAttribute("message"); // Loại bỏ thông điệp để không hiển thị lại %>
<% } %>
