<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách phòng trọ</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        body {
            padding-top: 20px;
        }
        table {
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Danh sách phòng trọ</h1>

    <a href="${pageContext.request.contextPath}/phongtro?action=create" class="btn btn-success mb-4">Thêm phòng trọ mới</a>

    <form action="${pageContext.request.contextPath}/phongtro" method="get" class="mb-4">
        <div class="input-group">
            <input type="text" class="form-control" name="searchTerm" placeholder="Nhập từ khóa tìm kiếm" value="${param.searchTerm}">
            <div class="input-group-append">
                <button class="btn btn-primary" type="submit">Tìm kiếm</button>
            </div>
        </div>
    </form>

    <form action="${pageContext.request.contextPath}/phongtro" method="post">
        <input type="hidden" name="action" value="delete">
        <table class="table table-striped">
            <thead>
            <tr>
                <th><input type="checkbox" id="selectAll"></th>
                <th>Mã phòng trọ</th>
                <th>Tên người thuê</th>
                <th>Số điện thoại</th>
                <th>Ngày bắt đầu thuê</th>
                <th>Hình thức thanh toán</th>
                <th>Ghi chú</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="phongTro" items="${phongTroList}">
                <tr>
                    <td><input type="checkbox" name="ids" value="${phongTro.id}"></td>
                    <td>${phongTro.id}</td>
                    <td>${phongTro.tenNguoiThue}</td>
                    <td>${phongTro.soDienThoai}</td>
                    <td>${phongTro.ngayThue}</td>
                    <td>${phongTro.hinhThucThanhToan.tenHinhThuc}</td>
                    <td>${phongTro.ghiChu}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button type="submit" class="btn btn-danger">Xóa đã chọn</button>
    </form>
</div>
<script>
    document.getElementById('selectAll').onclick = function() {
        var checkboxes = document.querySelectorAll('input[name="ids"]');
        for (var checkbox of checkboxes) {
            checkbox.checked = this.checked;
        }
    };
</script>
</body>
</html>
