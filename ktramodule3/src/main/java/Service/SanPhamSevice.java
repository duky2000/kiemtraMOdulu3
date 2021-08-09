package Service;

import Dao.QuanLySanPham;
import Model.SanPham;

import java.sql.SQLException;
import java.util.ArrayList;

public class SanPhamSevice {
    public ArrayList<SanPham> list = new ArrayList<>();

    public SanPhamSevice() {
        try {
            list = QuanLySanPham.show();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void create(SanPham sanPham) {
        try {
            QuanLySanPham.create(sanPham);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        list.add(sanPham);
    }

    public void edit(SanPham sanPham, int id) {

        try {
            QuanLySanPham.edit(sanPham);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        list.set(id, sanPham);
    }

    public void delete(int id) {
        try {
            QuanLySanPham.delete(list.get(id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        list.remove(id);
    }

    public ArrayList<SanPham> find(String name) throws SQLException {
        return QuanLySanPham.findByName(name);
    }
}
