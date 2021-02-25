package service;

import model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements ICategoryService{
    Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3308/productmanager",
                    "root",
                    "123456"
            );
        } catch (ClassNotFoundException e) {
            System.out.println("không có thư viện");
        } catch (SQLException throwables) {
            System.out.println("không có kết nối");
        }
        System.out.println("kết nối thành công");
        return connection;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from category");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Category category = new Category(id,name);
                categories.add(category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categories;
    }


    @Override
    public Category save( Category category) {
        return null;
    }

    @Override
    public Category edit(int id, Category category) {
        return null;
    }

    @Override
    public Category findById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
