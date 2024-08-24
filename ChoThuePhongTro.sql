CREATE DATABASE CHOTHUEPHONGTRO; 
USE CHOTHUEPHONGTRO;

CREATE TABLE HINHTHUCTHANHTOAN (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    TenHinhThuc VARCHAR(20) NOT NULL
);

CREATE TABLE PHONGTRO (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    TenNguoiThue VARCHAR(50) NOT NULL,
    SoDienThoai VARCHAR(10) NOT NULL,  -- Số điện thoại chỉ nên là 10 ký tự
    NgayThue DATE NOT NULL,
    HinhThucThanhToan INT NOT NULL,
    GhiChu VARCHAR(200),
    FOREIGN KEY (HinhThucThanhToan) REFERENCES HINHTHUCTHANHTOAN(Id)
);

INSERT INTO HINHTHUCTHANHTOAN (TenHinhThuc) VALUES 
    ('Theo tháng'),
    ('Theo quý'),
    ('Theo năm');

-- Thêm thêm dữ liệu phòng trọ vào bảng PHONGTRO
INSERT INTO PHONGTRO (TenNguoiThue, SoDienThoai, NgayThue, HinhThucThanhToan, GhiChu) VALUES 
    ('Võ Thị F', '0967890123', '2024-09-01', 1, 'Gần trung tâm thành phố, phòng mới sửa.'),
    ('Ngô Văn G', '0978901234', '2024-09-05', 2, 'Có phòng tắm riêng, tiện lợi.'),
    ('Đặng Thị H', '0989012345', '2024-09-10', 1, 'Gần bến xe, thuận tiện đi lại.'),
    ('Bùi Văn I', '0990123456', '2024-09-15', 3, 'Phòng rộng, có ban công, thích hợp cho gia đình.'),
    ('Nguyễn Thị J', '0901234567', '2024-09-20', 2, 'Gần trường học, môi trường yên tĩnh.'),
    ('Lê Thị K', '0912345670', '2024-09-25', 1, 'Có chỗ để xe, gần chợ.'),
    ('Trương Văn L', '0923456781', '2024-10-01', 3, 'Phòng đẹp, có sân vườn.'),
    ('Phan Thị M', '0934567892', '2024-10-05', 1, 'Gần siêu thị, đầy đủ nội thất.'),
    ('Hà Văn N', '0945678903', '2024-10-10', 2, 'Có internet, sạch sẽ, yên tĩnh.'),
    ('Lý Thị O', '0956789014', '2024-10-15', 3, 'Có thang máy, thuận tiện đi lại.'),
    ('Vũ Văn P', '0967890125', '2024-10-20', 1, 'Gần khu công nghiệp, phòng thoáng mát.'),
    ('Đoàn Thị Q', '0978901236', '2024-10-25', 2, 'Có máy lạnh, gần bệnh viện.'),
    ('Tôn Văn R', '0989012347', '2024-11-01', 3, 'Có phòng khách, phòng ngủ riêng biệt.'),
    ('Nguyễn Văn S', '0990123458', '2024-11-05', 1, 'Gần công viên, an ninh tốt.'),
    ('Trần Thị T', '0901234568', '2024-11-10', 2, 'Có bãi đậu xe rộng rãi, gần trường đại học.');

select*from PHONGTRO;
