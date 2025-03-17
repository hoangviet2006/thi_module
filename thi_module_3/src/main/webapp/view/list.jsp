<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <c:import url="../layout.jsp"></c:import>
</head>
<body>
<c:import url="../navbar.jsp"></c:import>
<div class="d-flex justify-content-between my-3 px-5">
    <a class="btn btn-success btn-sm" href="/admin?action=create">Thêm Mới</a>
    <form action="/admin?action=search" method="post" class="d-flex">
        <input class="form-control form-control-sm w-75" name="code" placeholder="Nhập mã phòng trọ cần tìm" value="${param.code}">
        <button class="btn btn-primary btn-sm mx-3">Tìm Kiếm</button>
    </form>
</div>
<table id="tableProduct" class="table table-striped table-hover table-bordered">
    <thead class="table-primary">
    <tr>
        <th>STT</th>
        <th>Mã phòng trọ</th>
        <th>Tên người thuê phòng</th>
        <th>Số điện thoại</th>
        <th>Ngaỳ bắt đầu thue</th>
        <th>Hình thức thanh toán</th>
        <th>Ghi chú</th>
        <th>Xóa</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="motelRoom">
        <tr>
            <td>${motelRoom.stt}</td>
            <td>${motelRoom.code}</td>
            <td>${motelRoom.tenantName}</td>
            <td>${motelRoom.phoneNumber}</td>
            <td>${motelRoom.rentalDate}</td>
            <td>${motelRoom.formOfPayment}</td>
            <td>${motelRoom.note}</td>
            <td>
                <button type="button" class="btn btn-primary btn-sm" onclick="deleteId('${motelRoom.stt}')" data-bs-toggle="modal" data-bs-target="#confirmDeleteModal">
                    Xóa</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
<!-- Modal Xác Nhận Xóa -->
<div class="modal fade" id="confirmDeleteModal" tabindex="-1" aria-labelledby="confirmDeleteLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/admin" method="get">
                <div class="modal-header bg-danger text-white">
                    <h5 class="modal-title" id="confirmDeleteLabel">Xác Nhận Xóa</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="stt" id="deleteId">
                    <input type="hidden" name="action" value="delete">
                    <p>Bạn có chắc chắn muốn xóa sản phẩm này không?</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                    <button type="submit" class="btn btn-danger">Xóa</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function() {
        $('#tableProduct').DataTable({
            "lengthChange": false,
            "autoWidth": false, // Tắt tự động điều chỉnh chiều rộng
            "info": false,// tắt info
            "pageLength": 5,
            "searching": false,
            "language": {
                "paginate": {
                    "previous": "Trước",
                    "next": "Tiếp"
                },
            },
            "scrollX": false, // tắt thanh lăn
        });
    });

    function deleteId(id) {
        document.getElementById("deleteId").value = id;
    }
</script>
</html>
