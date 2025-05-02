package com.example;
import java.sql.*;
import java.util.*;

public class ProductDAO {

    public static List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products";

        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                products.add(new Product(rs.getInt("id"),
                                         rs.getString("name"),
                                         rs.getString("description"),
                                         rs.getInt("quantity"),
                                         rs.getDouble("price")));
            }
        }
        return products;
    }

    public static void addProduct(Product product) throws SQLException {
        String query = "INSERT INTO products (name, description, quantity, price) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, product.getName());
            pstmt.setString(2, product.getDescription());
            pstmt.setInt(3, product.getQuantity());
            pstmt.setDouble(4, product.getPrice());

            pstmt.executeUpdate();
        }
    }

    public static void updateProduct(Product product) throws SQLException {
        String query = "UPDATE products SET name = ?, description = ?, quantity = ?, price = ? WHERE id = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, product.getName());
            pstmt.setString(2, product.getDescription());
            pstmt.setInt(3, product.getQuantity());
            pstmt.setDouble(4, product.getPrice());
            pstmt.setInt(5, product.getId());

            pstmt.executeUpdate();
        }
    }

    public static void deleteProduct(int productId) throws SQLException {
        String query = "DELETE FROM products WHERE id = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, productId);
            pstmt.executeUpdate();
        }
    }
}
