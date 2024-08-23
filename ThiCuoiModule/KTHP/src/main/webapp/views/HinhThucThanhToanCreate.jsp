<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tạo Mới Hình Thức Thanh Toán</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1 class="my-4">Tạo Mới Hình Thức Thanh Toán</h1>
    <form action="HinhThucThanhToanController" method="post">
        <div class="form-group">
            <label for="tenHinhThuc">Tên Hình Thức Thanh Toán:</label>
            <input type="text" class="form-control" id="tenHinhThuc" name="tenHinhThuc" required>
        </div>
        <button type="submit" class="btn btn-primary">Tạo Mới</button>
        <a href="HinhThucThanhToan.jsp" class="btn btn-secondary">Hủy</a>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
