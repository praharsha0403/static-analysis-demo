package com.example;

import java.io.*;
import java.sql.*;
import java.util.*;

public class BankingApp {
    
    // SQL injection vulnerability
    public User getUserById(Connection conn, String userId) throws SQLException {
        String query = "SELECT * FROM users WHERE id = " + userId;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        if (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            return user;
        }
        return null;
    }
    
    // Resource leak - file not closed
    public void readFile(String filename) throws IOException {
        FileInputStream fis = new FileInputStream(filename);
        byte[] buffer = new byte[1024];
        fis.read(buffer);
        // Missing fis.close()
    }
    
    // Null pointer dereference potential
    public String processUser(User user) {
        return user.getName().toUpperCase(); // No null check
    }
    
    // Hardcoded password
    public boolean authenticate(String username) {
        String password = "admin123"; // Hardcoded credential
        return username.equals("admin") && password.equals("admin123");
    }
    
    // Inefficient string concatenation in loop
    public String buildReport(List<String> items) {
        String result = "";
        for (String item : items) {
            result += item + "\n"; // Inefficient concatenation
        }
        return result;
    }
    
    // Unused variable
    public void calculateInterest(double principal, double rate) {
        double interest = principal * rate / 100;
        double unused = 42.0; // Never used
        System.out.println("Interest calculated");
    }
    
    // Potential integer overflow
    public int calculateTotal(int[] amounts) {
        int total = 0;
        for (int amount : amounts) {
            total += amount; // No overflow check
        }
        return total;
    }
    
    // Method always returns true
    public boolean validateInput(String input) {
        if (input != null && !input.isEmpty()) {
            return true;
        }
        return true; // Always returns true
    }
    
    // Empty catch block
    public void riskyOperation() {
        try {
            // Some risky operation
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Empty catch block - exception swallowed
        }
    }
    
    // Class with equality issues
    static class User {
        private int id;
        private String name;
        private String email;
        
        // Getters and setters
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        
        // Missing equals() and hashCode() methods
    }
}
