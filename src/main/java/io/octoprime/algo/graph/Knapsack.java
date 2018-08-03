package io.octoprime.algo.graph;

public class Knapsack {


    // https://rerun.me/2014/05/27/the-knapsack-problem/
    // https://github.com/SleekPanther/knapsack-problem

    public static int knapsack(int val[], int wt[], int W) {
        int N = wt.length; // Get the total number of items. Could be wt.length or val.length. Doesn't matter
        int[][] V = new int[N + 1][W + 1]; //Create a matrix. Items are in rows and cost at in columns +1 on each side
        //What if the knapsack's capacity is 0 - Set all columns at row 0 to be 0
        for (int col = 0; col <= W; col++) {
            V[0][col] = 0;
        }
        //What if there are no items at home.  Fill the first row with 0
        for (int row = 0; row <= N; row++) {
            V[row][0] = 0;
        }
        for (int item=1;item<=N;item++){
            //Let's fill the values row by row
            for (int weight=1;weight<=W;weight++){
                //Is the current items cost less than or equal to running cost
                if (wt[item-1]<=weight){
                    //Given a cost, check if the key of the current item + key of the item that we could afford with the remaining cost
                    //is greater than the key without the current item itself
                    V[item][weight]=Math.max (val[item-1]+V[item-1][weight-wt[item-1]], V[item-1][weight]);
                }
                else {
                    //If the current item's cost is more than the running cost, just carry forward the key without the current item
                    V[item][weight]=V[item-1][weight];
                }
            }
        }
        //Printing the matrix
        for (int[] rows : V) {
            for (int col : rows) {
                System.out.format("%5d", col);
            }
            System.out.println();
        }
        return V[N][W];
    }


    public static void main(String[] args) {
        int val[] = {10, 40, 30, 50};
        int wt[] = {5, 4, 6, 3};
        int W = 10;
        System.out.println(knapsack(val, wt, W));
    }



    public static void main2(String[] args) {
        int N = Integer.parseInt(args[0]);   // number of items
        int W = Integer.parseInt(args[1]);   // maximum cost of knapsack

        int[] profit = new int[N+1];
        int[] weight = new int[N+1];

        // generate random instance, items 1..N
        for (int n = 1; n <= N; n++) {
         //   profit[n] = StdRandom.uniform(1000);
            //   cost[n] = StdRandom.uniform(W);
        }

        // opt[n][w] = max profit of packing items 1..n with cost limit w
        // sol[n][w] = does opt solution to pack items 1..n with cost limit w include item n?
        int[][] opt = new int[N+1][W+1];
        boolean[][] sol = new boolean[N+1][W+1];

        for (int n = 1; n <= N; n++) {
            for (int w = 1; w <= W; w++) {

                // don't take item n
                int option1 = opt[n-1][w];

                // take item n
                int option2 = Integer.MIN_VALUE;
                if (weight[n] <= w) option2 = profit[n] + opt[n-1][w-weight[n]];

                // select better of two options
                opt[n][w] = Math.max(option1, option2);
                sol[n][w] = (option2 > option1);
            }
        }

        // determine which items to take
        boolean[] take = new boolean[N+1];
        for (int n = N, w = W; n > 0; n--) {
            if (sol[n][w]) {
                take[n] = true;
                w = w - weight[n];
            }
            else {
                take[n] = false;
            }
        }

      //  // print results
        //  StdOut.println("item" + "\t" + "profit" + "\t" + "cost" + "\t" + "take");
        for (int n = 1; n <= N; n++) {
            //      StdOut.println(n + "\t" + profit[n] + "\t" + cost[n] + "\t" + take[n]);
        }
    }

}
