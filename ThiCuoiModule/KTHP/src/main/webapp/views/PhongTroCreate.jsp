<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.kthp.entity.PhongTro" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách phòng trọ</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container mt-4">
    <h1>Danh sách phòng trọ</h1>
    <form action="phongtro" method="post">
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
            <%
                List<PhongTro> phongTroList = (List<PhongTro>) request.getAttribute("phongTroList");
                if (phongTroList != null && !phongTroList.isEmpty()) {
                    for (PhongTro phongTro : phongTroList) {
            %>
            <tr>
                <td><input type="checkbox" name="ids" value="<%= phongTro.getId() %>"></td>
                <td><%= phongTro.getId() %></td>
                <td><%= phongTro.getTenNguoiThue() %></td>
                <td><%= phongTro.getSoDienThoai() %></td>
                <td><%= phongTro.getNgayThue() %></td>
                <td><%= phongTro.getHinhThucThanhToan() %></td>
                <td><%= phongTro.getGhiChu() %></td>
            </tr>
            <%
                }
            } else {
            %>
            <tr>
                <td colspan="7">Không có dữ liệu.</td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
        <button type="submit" class="btn btn-danger">Xóa đã chọn</button>
    </form>
</div>

<script>
    document.getElementById('selectAll').addEventListener('click', function() {
        const checkboxes = document.querySelectorAll('input[name="ids"]');
        checkboxes.forEach(checkbox => checkbox.checked = this.checked);
    });
</script>
</body>
</html>
