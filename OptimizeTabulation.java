package dynamicprogramming;

public class OptimizeTabulation {
    public static void main(String[] args) {
        int n = 5;
        int prev2 = 0;
        int prev = 1;
        int curr = 0;
        for(int i = 2; i <= n; i++){
            curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        System.out.println(prev);
    }
}
