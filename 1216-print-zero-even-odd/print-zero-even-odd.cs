using System.Threading;

public class ZeroEvenOdd {
    private int n;
    private  Semaphore even = new Semaphore(0, 1);
    private  Semaphore odd = new Semaphore(0, 1);
    private  Semaphore zero = new Semaphore(1, 1);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void Zero(Action<int> printNumber) {
        for(int i = 1; i <= n; i++){
            zero.WaitOne();
            printNumber(0);
            if((i&1) != 0){
                odd.Release();
            }
            else{
                even.Release();
            }
        }
    }

    public void Even(Action<int> printNumber) {
        for(int i = 2; i <= n; i += 2){
            even.WaitOne();
            printNumber(i);
            zero.Release();
        }
    }

    public void Odd(Action<int> printNumber) {
        for(int i = 1; i <= n; i += 2){
            odd.WaitOne();
            printNumber(i);
            zero.Release();
        } 
    }
}