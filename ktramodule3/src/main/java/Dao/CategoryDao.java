package Dao;

import Model.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    static Connection connection = ConnectionSanPham.getConnection();

    public static List<Category> show() throws SQLException {
        List<Category> list = new ArrayList<>();
        String select = "select * from category";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            list.add(new Category(id, name));
        }
        return list;
    }
}
