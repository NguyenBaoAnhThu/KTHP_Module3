<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Phòng Trọ Mới</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h1>Thêm Phòng Trọ Mới</h1>
    <form action="${pageContext.request.contextPath}/phongtro" method="post">
        <div class="form-group">
            <label for="tenNguoiThue">Tên Người Thuê</label>
            <input type="text" class="form-control" id="tenNguoiThue" name="tenNguoiThue" required>
        </div>
        <div class="form-group">
            <label for="soDienThoai">Số Điện Thoại</label>
            <input type="text" class="form-control" id="soDienThoai" name="soDienThoai" required>
        </div>
        <div class="form-group">
            <label for="hinhThucThanhToanId">Hình Thức Thanh Toán</label>
            <select id="hinhThucThanhToanId" name="hinhThucThanhToanId" class="form-control" required>
                <c:forEach var="hinhThuc" items="${hinhThucThanhToanList}">
                    <option value="${hinhThuc.id}">${hinhThuc.tenHinhThuc}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="ghiChu">Ghi Chú</label>
            <textarea class="form-control" id="ghiChu" name="ghiChu"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Thêm Phòng Trọ</button>
    </form>
    <a href="${pageContext.request.contextPath}/phongtro" class="btn btn-secondary mt-2">Quay lại</a>
</div>
</body>
</html>
