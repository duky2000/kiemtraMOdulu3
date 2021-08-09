package Controller;

import Dao.CategoryDao;
import Model.Category;
import Model.SanPham;
import Service.SanPhamSevice;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/sanpham")
public class Servlet extends HttpServlet {
    SanPhamSevice sanPhamSevice = new SanPhamSevice();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        try {
            List<Category> list = CategoryDao.show();
            String action = req.getParameter("action");
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "create":
                    req.setAttribute("listClass", list);
                    dispatcher = req.getRequestDispatcher("view/create.jsp");
                    dispatcher.forward(req, resp);
                    break;
                case "edit":
                    int idedit = Integer.parseInt(req.getParameter("index"));
                    req.setAttribute("editsp", sanPhamSevice.list.get(idedit));
                    req.setAttribute("listCategory", list);
                    dispatcher = req.getRequestDispatcher("view/edit.jsp");
                    dispatcher.forward(req, resp);
                    break;

                case "delete":
                    int index = Integer.parseInt(req.getParameter("index"));
                    sanPhamSevice.delete(index);
                    resp.sendRedirect("/sanpham");
                    break;
                case "find":
                    String nameFind = req.getParameter("find");
                    req.setAttribute("ListSP", sanPhamSevice.find(nameFind));
                    dispatcher = req.getRequestDispatcher("view/show.jsp");
                    dispatcher.forward(req, resp);
                    break;

                default:
                    req.setAttribute("listCategory", list);
                    req.setAttribute("ListSP", sanPhamSevice.list);
                    dispatcher = req.getRequestDispatcher("view/show.jsp");
                    dispatcher.forward(req, resp);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");

        String action = req.getParameter("action");
        switch (action) {
            case "create":
                int id = Integer.parseInt(req.getParameter("id"));
                String name = req.getParameter("name");
                int price = Integer.parseInt(req.getParameter("price"));
                int amount =Integer.parseInt( req.getParameter("amount"));
                String color = req.getParameter("color");
                String description = req.getParameter("description");
                int categoryId = Integer.parseInt(req.getParameter("categoryId"));
                SanPham sanPham = new SanPham(id, name, price, amount, color, description, categoryId);
                sanPhamSevice.create(sanPham);
                resp.sendRedirect("/sanpham");
                break;
            case "edit":
                int idedit = Integer.parseInt(req.getParameter("id"));
                String nameedit = req.getParameter("name");
                int priceedit = Integer.parseInt(req.getParameter("price"));
                int amountedit =Integer.parseInt( req.getParameter("amount"));
                String coloredit = req.getParameter("color");
                String descriptionedit = req.getParameter("description");
                int categoryIdedit = Integer.parseInt(req.getParameter("categoryId"));
                SanPham sanPhamedit = new SanPham(idedit, nameedit, priceedit, amountedit, coloredit, descriptionedit, categoryIdedit);
                int index = Integer.parseInt(req.getParameter("index"));
                sanPhamSevice.edit(sanPhamedit, index);
                resp.sendRedirect("/sanpham");
//                    req.setAttribute("listClass",list);
//                    req.setAttribute("newhocvien", hocVienService.list);
//                    dispatcher = req.getRequestDispatcher("view/show.jsp");
//                    dispatcher.forward(req, resp);}
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        }
    }
}
