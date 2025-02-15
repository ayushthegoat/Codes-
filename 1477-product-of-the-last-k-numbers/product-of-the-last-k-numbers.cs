using System;
using System.Collections.Generic;

public class ProductOfNumbers {
    private List<int> products;

    public ProductOfNumbers() {
        products = new List<int> { 1 }; // Initialize with 1 to simplify product calculations
    }
    
    public void Add(int num) {
        if (num == 0) {
            products.Clear();
            products.Add(1); // Reset with 1 to maintain multiplication logic
        } else {
            products.Add(products[^1] * num); // Use `^1` for the last element
        }
    }
    
    public int GetProduct(int k) {
        int n = products.Count;
        return k >= n ? 0 : products[^1] / products[^(k + 1)];
    }
}

/**
 * Example usage:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.Add(num);
 * int param_2 = obj.GetProduct(k);
 */
