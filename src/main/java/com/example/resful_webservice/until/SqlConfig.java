package com.example.resful_webservice.until;

public class SqlConfig {


//  Categories
    public static final String INSERT_CATEGORIES = "INSERT INTO categories (Name,Img) VALUES (?,?)";
    public static final String LIST_CATEGORIES = "SELECT * FROM categories";
    public static final String UPDATE_CATEGORIES = "UPDATE categories SET Id= ? ,Name = ?, Status = ? , Img= ? WHERE Id = ?";
    public static final String DELETE_CATEGORIES = "DELETE FROM categories WHERE Id = ?";
    public static final String DETAIL_CATEGORIES = "select * from categories where Id = ?";

//  Product
    public static final String INSERT_PRODUCT = "INSERT INTO product (name,price) VALUES (?,?)";
    public static final String LIST_PRODUCT = "SELECT * FROM product";
    public static final String UPDATE_PRODUCT =
            "UPDATE product SET Id=?,name=?,price=? WHERE Id = ?";
    public static final String DELETE_PRODUCT = "DELETE FROM product WHERE Id = ?";
    public static final String DETAIL_PRODUCT = "select * from product where Id = ?";

//  Acount
    public static final String INSERT_ACCOUNT ="INSERT INTO account (username, fullname, passwordHash, salt, CreatedAt, Status) VALUES (?, ?, ?, ?, ?,?);";
    public static final String LOCK_ACCOUNT = "update account set Status = ?,failureCount = ?,locktime= ? where username = ?";
    public static final String SELECT_ACCOUNT_BY_USERNAME = "select * from account where username=?";
    public static final String LIST_ACOUNT = "SELECT * FROM account";

}
