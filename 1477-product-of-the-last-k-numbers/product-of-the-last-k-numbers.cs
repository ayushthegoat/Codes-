public class ProductOfNumbers {
    private List<int> products;
    public ProductOfNumbers() {
        products = new List<int>();
    }
    
    public void Add(int num) {
        if(num == 0) {
            products.Clear();            
        } else {
            products.Add(num * (products.Count == 0 ? 1 : products[products.Count - 1]));
        }
    }
    
    public int GetProduct(int k) {
        int n = products.Count;
        if (n == 0 || k > n) return 0;
        if (k == n) return products[n - 1];
        return products[n - 1] / products[n - k - 1];
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.Add(num);
 * int param_2 = obj.GetProduct(k);
 */