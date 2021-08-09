package Dao;

import Model.SanPham;

import java.sql.*;
import java.util.ArrayList;

public class QuanLySanPham {

    static Connection connection = ConnectionSanPham.getConnection();

    public static ArrayList<SanPham> show() throws SQLException {
        ArrayList<SanPham> list = new ArrayList<>();
        String select = "select * from sanpham";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int price = resultSet.getInt("price");
            int amount = resultSet.getInt("amount");
            String color = resultSet.getString("color");
            String description = resultSet.getString("description");
            int categoryId = resultSet.getInt("categoryId");
            list.add(new SanPham(id,name, price, amount, color, description, categoryId));
        }
        return list;
    }
    public static void create(SanPham sanPham) throws SQLException {
        String create = "insert into sanpham value(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(create);
        preparedStatement.setInt(1,sanPham.getId());
        preparedStatement.setString(2,sanPham.getName());
        preparedStatement.setInt(3,sanPham.getPrice());
        preparedStatement.setInt(4,sanPham.getAmount());
        preparedStatement.setString(5,sanPham.getColor());
        preparedStatement.setString(6,sanPham.getDescription());
        preparedStatement.setInt(7,sanPham.getCategoryId());
        preparedStatement.execute();
    }
    public static void edit(SanPham sanPham) throws SQLException {
        String edit = "update sanpham set name = ? ,price = ?,amount = ?,color = ?,description = ?, categoryId = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(edit);
        preparedStatement.setInt(7,sanPham.getId());
        preparedStatement.setString(1,sanPham.getName());
        preparedStatement.setInt(2,sanPham.getPrice());
        preparedStatement.setInt(3,sanPham.getAmount());
        preparedStatement.setString(4,sanPham.getColor());
        preparedStatement.setString(5,sanPham.getDescription());
        preparedStatement.setInt(6,sanPham.getCategoryId());

        preparedStatement.execute();
    }
    public static void delete(SanPham sanPham) throws SQLException {
        String delete = "delete from sanpham where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1,sanPham.getId());
        preparedStatement.execute();
    }
    public static ArrayList<SanPham> findByName(String ten) throws SQLException {
        ArrayList<SanPham> findlist = new ArrayList<>();
        String find = "select * from sanpham where name like '%"+ten+"%' ";
        PreparedStatement preparedStatement = connection.prepareStatement(find);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int price = resultSet.getInt("price");
            int amount = resultSet.getInt("amount");
            String color = resultSet.getString("color");
            String description = resultSet.getString("description");
            int categoryId = resultSet.getInt("categoryId");
            findlist.add(new SanPham(id,name, price, amount, color, description, categoryId));
        }
        return findlist;
    }
}
