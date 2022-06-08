package com.example.resful_webservice.Resource;

import com.example.resful_webservice.Entity.Product;
import com.example.resful_webservice.until.ConnectionHelper;
import com.example.resful_webservice.until.SqlConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InMemoryProductModel implements ProductModel {

    @Override
    public Product save(Product product) {
        try
        {
            System.out.println("Add");
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConfig.INSERT_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.execute();
            return product;
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product update(Product product, int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(SqlConfig.UPDATE_PRODUCT);
            statement.setInt(1,id);
            statement.setString(2, product.getName());
            statement.setInt(3, product.getPrice());
            statement.setInt(4, id);
            statement.execute();
            return product;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(SqlConfig.DELETE_PRODUCT);
            statement.setInt(1,id);
            statement.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> findall() {
        List<Product> list = new ArrayList<>();
        try {

            Connection connection = ConnectionHelper.getConnection();
            String sqlSelect = SqlConfig.LIST_PRODUCT;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()){
                int Id = resultSet.getInt("id");
                String Name = resultSet.getString("name");
                int Price = resultSet.getInt("price");
                Product pro = new Product(Id,Name,Price);
                list.add(pro);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Product findbyid(int id) {
        Product obj = null;
        Connection connection = null;
        try {
            connection = ConnectionHelper.getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SqlConfig.DETAIL_PRODUCT);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet resultSet = null;
        try {
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (resultSet.next()) {
                int Id = resultSet.getInt("id");
                String Name = resultSet.getString("name");
                int Price = resultSet.getInt("price");
                obj = new Product(Id,Name,Price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  obj;
    }
}
