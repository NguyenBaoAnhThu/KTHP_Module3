<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Danh sách Hình Thức Thanh Toán</title>
</head>
<body>
<h1>Danh sách Hình Thức Thanh Toán</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Tên Hình Thức</th>
    </tr>
    <c:forEach var="hinhThuc" items="${hinhThucThanhToanList}">
        <tr>
            <td>${hinhThuc.id}</td>
            <td>${hinhThuc.tenHinhThuc}</td>
        </tr>
    </c:forEach>
</table>
<a href="HinhThucThanhToanCreate.jsp">Thêm Hình Thức Thanh Toán Mới</a>
</body>
</html>
