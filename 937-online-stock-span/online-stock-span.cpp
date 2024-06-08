class StockSpanner {
public:
    stack<pair<int,int>>stk;
    StockSpanner() {
        
    }
    
    int next(int price) {
        int span = 1;
                
        while(!stk.empty() && stk.top().first <= price){
            auto it = stk.top();
            int currPrice = it.first;
            int currSpan = it.second;
            span+= currSpan;
            stk.pop();
        
        }
        stk.push({price, span});

        return span;
    }
};

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner* obj = new StockSpanner();
 * int param_1 = obj->next(price);
 */