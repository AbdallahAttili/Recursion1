import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // Recursion : it means that the function call itself , and you have a big problem and small problems .

        int n = 5;

        // calculate n factorial using recursion:
        System.out.println(factorial1(n));

        // calculate n factorial using normal loop.
        System.out.println(factorial2(n));


        int a = 5;

        // calculate the sum of numbers from 1 to n using recursion.
        System.out.println(sum1(a));

        // calculate the sum of numbers from 1 to n using normal loop.
        System.out.println(sum2(a));

        // calculate the sum of numbers from 1 to n using simple math formula.
        System.out.println(sum3(a));


        System.out.println(power(2, 5));

        print(6);

        System.out.println();


        System.out.println("number of digits : " + numberOfDigits(456564565));

        System.out.println(Arrays.toString(allIndexes(new int[]{9, 8, 10, 8, 8}, 8)));

        System.out.println(multiplyTwoIntegers(3,5));

        System.out.println(countZerosRec(100001100));

        System.out.println(sumOfDigits(9));

    }

    // How to calculate n! using recursion :
    public static long factorial1(int n) {
        if(n == 0) return 1;

        return factorial1(n - 1) * n;
    }

    // How to calculate n! using normal loop.
    public static long factorial2(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    // How to calculate the sum from 1 to n using recursion : "IT'S A BAD IDEA".
    public static int sum1(int a) {
        if (a == 1) {
            return 1;
        }

        return a + sum1(a - 1);
    }

    // How to calculate the sum from 1 to n using normal loop : "IT'S ALSO A BAD IDEA".
    public static int sum2(int a) {
        int sum = 0;
        for (int i = 0; i <= a; i++) {
            sum += i;
        }

        return sum;
    }

    // How to calculate the sum from 1 to n using simple math formula : "optimal solution".
    public static int sum3(int a) {
        return a * (a + 1) / 2;
    }

    // How to find x to the power n using recursion.
    public static int power(int x, int n) {
        if (n == 1) { // base case
            return x;
        }

        return x * power(x, n - 1);
    }

    // How to print the numbers from 1 to n using recursion.
    public static void print(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        print(n - 1);
        System.out.print(n + " ");
    }

    // How to calculate the number of digits using recursion.
    public static int numberOfDigits(int n) {
        if (n == 0) {
            return 0;
        }

        return numberOfDigits(n / 10) + 1;
    }

    // function to find the indices that contains number x;
    public static int[] allIndexes(int [] input, int x) {

        int [] toStore = new int[5];

        return allIndexes(input,x,0,toStore);

    }

    public static int []  allIndexes(int [] input, int x, int startIndex, int [] toStore){

        if(startIndex == input.length){
            return toStore;
        }

        if(input[startIndex] == x){
            toStore[startIndex] = startIndex;
        }


        return allIndexes(input,x,startIndex + 1, toStore);

    }

     // multiply two integer recursively;
    public static int multiplyTwoIntegers(int m, int n){

        if(m == 1){
            return n;
        }

        return n + multiplyTwoIntegers(m - 1,n);
    }

    // count the number of zeroes in the input.
    public static int countZerosRec(int input){
       // if the input is already zero the answer will be 1
        if(input == 0){
            // called the function below;
            return countZerosRec(input,1);
        } else{
            return  countZerosRec(input,0);
        }
    }


    public static int countZerosRec(int input, int answer){

       if(input == 0){
           return answer;
       }
        // if the digit is zero answer++;
        if(input % 10 == 0){
           return  countZerosRec(input/10,answer+1);
        }

        // otherwise, divide the input by 10 and keep the answer;
        return countZerosRec(input/10,answer);
    }

   // sum of all digit in the input;
    public static int sumOfDigits(int input){

        if(input == 0){
            return 0;
        }

        return sumOfDigits(input/10) + input % 10;
    }
}
