package com.qsp.lms.dao;

import java.sql.*;
import com.qsp.lms.model.Laptop;

public class LaptopDao {
    private static final String url = "jdbc:postgresql://localhost:******/shop?user=******&passowrd=******";
    private static Connection c;

    static {
        try {
            c = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveLaptop(Laptop l) throws SQLException {
        String sql = "INSERT INTO laptop (id, brand, price, model) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1, l.getId());
        ps.setString(2, l.getBrand());
        ps.setDouble(3, l.getPrice());
        ps.setString(4, l.getModel());
        ps.executeUpdate();
    }

    public static Laptop getLaptopById(int id) throws SQLException {
        String query = "SELECT * FROM laptop WHERE id = ?";
        PreparedStatement ps = c.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Laptop(
                rs.getInt("id"),
                rs.getString("brand"),
                rs.getDouble("price"),
                rs.getString("model")
            );
        }
        return null;
    }

    public static boolean deleteById(int id) throws SQLException {
        if (getLaptopById(id) == null) return false;
        String query = "DELETE FROM laptop WHERE id = ?";
        PreparedStatement ps = c.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
        return true;
    }

    public static void findAll() throws SQLException {
        String query = "SELECT * FROM laptop";
        Statement s = c.createStatement();
        ResultSet rs = s.executeQuery(query);

        while (rs.next()) {
            Laptop l = new Laptop(
                rs.getInt("id"),
                rs.getString("brand"),
                rs.getDouble("price"),
                rs.getString("model")
            );
            System.out.println(l);
        }
    }
    
 // Update price of a laptop by id
    public static boolean updateLaptopPrice(int id, double newPrice) throws SQLException {
        // First, check if the laptop exists
        Laptop existingLaptop = getLaptopById(id);
        if (existingLaptop == null) {
            return false; // No such laptop
        }

        // Prepare update query
        String query = "UPDATE laptop SET price = ? WHERE id = ?";
        PreparedStatement ps = c.prepareStatement(query);
        ps.setDouble(1, newPrice);
        ps.setInt(2, id);

        int rowsAffected = ps.executeUpdate();
        return rowsAffected > 0; // true if update was successful
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
