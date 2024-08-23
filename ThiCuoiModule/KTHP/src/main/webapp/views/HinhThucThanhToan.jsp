<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Hình Thức Thanh Toán</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1 class="my-4">Danh Sách Hình Thức Thanh Toán</h1>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Tên Hình Thức Thanh Toán</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="hinhThuc" items="${hinhThucList}">
            <tr>
                <td>${hinhThuc.id}</td>
                <td>${hinhThuc.tenHinhThuc}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="HinhThucThanhToanCreate.jsp" class="btn btn-primary">Tạo Mới</a>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
