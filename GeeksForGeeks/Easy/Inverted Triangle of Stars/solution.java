import java.util.Scanner;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            // Print leading spaces
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            
            // Print stars: 2 * (n - i) - 1
            for (int j = 0; j < 2 * (n - i) - 1; j++) {
                System.out.print("*");
            }
            
            // Move to the next line
            System.out.println();
        }
    }
}