package com.example.thi_module_3.controller;

import com.example.thi_module_3.dto.MotelRoomDto;
import com.example.thi_module_3.model.MotelRoom;
import com.example.thi_module_3.service.IMotelRoomService;
import com.example.thi_module_3.service.MotelRoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MVC", value = {"/admin"})
public class MotelRoomController extends HttpServlet {
    IMotelRoomService motelRoomService = new MotelRoomService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                req.getRequestDispatcher("/view/create.jsp").forward(req, resp);
                break;
            case "delete":
                String check = req.getParameter("stt");
                if (check != null) {
                    int stt = Integer.parseInt(check);
                    motelRoomService.deleteMotelRoom(stt);
                    req.setAttribute("list",motelRoomService.getMotelRooms());
                }
                req.getRequestDispatcher("/view/list.jsp").forward(req, resp);
                break;
            default:
                req.setAttribute("list", motelRoomService.getMotelRooms());
                req.getRequestDispatcher("/view/list.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                String code = req.getParameter("code");
                String tenantName = req.getParameter("tenant_name");
                String phone = req.getParameter("phone_number");
                String rentalDate = req.getParameter("rental_date");
                String note = req.getParameter("note");
                int idPay = Integer.parseInt(req.getParameter("id_pay"));
                MotelRoom motelRoom =  new MotelRoom(code, tenantName,  phone, rentalDate,  note, idPay);
                motelRoomService.addMotelRoom(motelRoom);
                resp.sendRedirect("/admin");
                break;
            case "search":
                    String codeSearch = req.getParameter("code");
                    if (codeSearch != null) {
                       List<MotelRoomDto> motelRoomDto= motelRoomService.searchMotelRoom(codeSearch);
                        req.setAttribute("list",motelRoomDto);
                    }
                    req.getRequestDispatcher("/view/list.jsp").forward(req, resp);
                break;
            default:
                req.setAttribute("list", motelRoomService.getMotelRooms());
                req.getRequestDispatcher("/view/list.jsp").forward(req, resp);
        }

    }
}
