package com.example;

import java.util.*;

public class DataProcessor {
    
    // Array stored in public static field
    public static String[] CONFIG = {"localhost", "8080", "admin"};
    
    // Method with potential performance issue
    public List<String> filterData(List<String> data) {
        List<String> result = new ArrayList<>();
        for (String item : data) {
            if (item != null && item.length() > 5) {
                result.add(item);
            }
        }
        return result;
    }
    
    // Potential deadlock with synchronized methods
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    
    public void method1() {
        synchronized(lock1) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            synchronized(lock2) {
                System.out.println("Method1");
            }
        }
    }
    
    public void method2() {
        synchronized(lock2) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            synchronized(lock1) {
                System.out.println("Method2");
            }
        }
    }
    
    // Infinite loop potential
    public void processUntilCondition(List<Integer> numbers) {
        int i = 0;
        while (i < numbers.size()) {
            if (numbers.get(i) % 2 == 0) {
                i++; // Only increment for even numbers
            }
            System.out.println("Processing: " + numbers.get(i));
        }
    }
    
    // Comparison using == instead of equals()
    public boolean checkString(String input) {
        return input == "test"; // Should use .equals()
    }
    
    // Unused import
    import java.io.File; // This import is not used
    
    // Magic numbers
    public double calculateTax(double amount) {
        return amount * 0.0825; // Magic number for tax rate
    }
}
