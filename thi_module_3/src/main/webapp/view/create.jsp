<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/14/2025
  Time: 7:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <c:import url="../layout.jsp"></c:import>
</head>
<body>
<c:import url="../navbar.jsp"></c:import>
<form action="/admin?action=create" method="post">
    <input class="form-control mb-3" type="hidden" name="stt">
    <input class="form-control mb-3"  name="code" placeholder="Nhập mã phòng">
    <small id="errorCode"></small>
    <input class="form-control mb-3" onblur="checkName()" id="name" name="tenant_name" placeholder="Nhập tên người thuê">
    <small id="errorName"></small>
    <input class="form-control mb-3" onblur="checkPhone()" id="phone" name="phone_number" placeholder="Nhập số điện thoại">
    <small id="errorPhone"></small>
    <input class="form-control mb-3"  onblur="checkDate()" id="date" name="rental_date" placeholder="Nhập ngày bắt đầu thuê">
    <small id="errorDate"></small>
<%--    <input class="form-control mb-3"  name="form_of_payment" placeholder="Nhập phương thức thanh toán">--%>
    <input class="form-control mb-3"  name="note" placeholder="Nhập ghi chú">
    <small id="errorNote"></small>
    <select class="form-control mb-3" name="id_pay">
        <option value="1">Theo Quý</option>
        <option value="2">Theo Tháng</option>
        <option value="3">Theo Năm</option>
    </select>
    <div class="d-flex justify-content-center">
    <button class="btn btn-primary">Lưu</button>
    </div>
</form>
<script>
    function checkName() {
        let name = document.getElementById("name").value.trim();
        let nameRegex = /^[A-Za-zÀ-Ỹà-ỹ\s]+$/;
        if (name === "") {
            document.getElementById("errorName").innerText = "Không được để trống";
        } else if (!nameRegex.test(name)) {
            document.getElementById("errorName").innerText = "Tên chỉ được chứa chữ cái";
        } else {
            document.getElementById("errorName").innerText = "";
        }
    }
    function checkPhone() {
        let phone = document.getElementById("phone").value.trim();
        let phoneRegex = /^(0\d{9,10})$/;

        if (phone === "") {
            document.getElementById("errorPhone").innerText = "Không được để trống";
        } else if (!phoneRegex.test(phone)) {
            document.getElementById("errorPhone").innerText = "Số điện thoại không hợp lệ";
        } else {
            document.getElementById("errorPhone").innerText = "";
        }
    }
    function checkDate() {
        let date = document.getElementById("date").value.trim();
        let dateRegex = /^\d{4}-\d{2}-\d{2}$/;

        if (date === "") {
            document.getElementById("errorDate").innerText = "Không được để trống";
        } else if (!dateRegex.test(date)) {
            document.getElementById("errorDate").innerText = "Ngày không đúng định dạng YYYY-MM-DD";
        } else {
            document.getElementById("errorDate").innerText = "";
        }
    }
</script>
</body>
</html>
