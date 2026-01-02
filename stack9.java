import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        String[] input = sc.nextLine().split(" ");
        int n = input.length;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();  

    
        for (int i = n - 1; i >= 0; i--) {
            
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {  
                stack.pop();
            }


            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            
            stack.push(arr[i]);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }

        sc.close();
    }
}

        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    
