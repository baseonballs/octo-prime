package io.octoprime.game;

import java.util.Scanner;

// goal move disck from pole-1 to pole-3.  The middle pole is the aux.
// # of moves is 2^n -1 ; since it's  2 * previous move + 1;
public class TowerOfHanoi {

    static int count = 0;

    public void solve(int n, String start, String auxiliary, String end) {
        if (n == 1) {
            System.out.println(start + " -> " + end);
            count++;
        } else {
            solve(n - 1, start, end, auxiliary);
            System.out.println(start + " -> " + end);
            count++;
            solve(n - 1, auxiliary, start, end);
        }
    }

    public static void main(String[] args) {
        TowerOfHanoi towersOfHanoi = new TowerOfHanoi();
        System.out.print("Enter number of discs: ");
        Scanner scanner = new Scanner(System.in);
        int discs = scanner.nextInt();
        towersOfHanoi.solve(discs, "A", "B", "C");
        System.out.println("Number of moves: " + count);
    }

}
