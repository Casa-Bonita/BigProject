package ru.study.homework.differenttasks.task3;

public class Operations{
    private int n;
    private int result = 0;
    private String str;
    private int sum = 0;
    private int a, b;
    private int count;

    public Operations(){

    }

// task 3 - start
    public int summa(int n){
        this.n = n;
        if (n == 0){
            return 0;
        }
        result = summa(n - 1) + n;
        return result;
    }
// task 3 - end


// task 4 - start
    public void printPrepare(String str) {
        char[] array = str.toCharArray();
        int i = 0;
        printed(i, array);
        //System.out.println("\n");
    }

    public char printed (int i, char[] arr){
        System.out.print(arr[i]);
        try {
            Thread.sleep(50);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (i == (arr.length - 1)) {
            return arr[i];
        }
        return printed(i + 1, arr);
    }

// task 4 - end


// task 5 - start
    public String degree(int n){
        this.n = n;
        if ((n % 2) == 0 && n == 2){
            return "YES";
        }
        result = n % 2;
        if (result != 0){
            return "NO";
        }
        return degree(n/2);
    }
// task 5 - end

// task 6 - start
    public int fibo (int n, int count){
        this.n = n;
        this.count = count;
        if (count == 1){
            sum = 1;
            System.out.println("число " + count + " равняется " + sum);
        } else if(count == 2){
            sum = 1;
            a = 1;
            b = 1;
            System.out.println("число " + count + " равняется " + sum);
        } else {
            sum = a + b;
            a = b;
            b = sum;
            System.out.println("число " + count + " равняется " + sum);
        }
//        System.out.println("Проверка sum = " + sum + " при этом count = " + count + " при этом a = " + a + " при этом b = " + b);

        if (count == n) {
            return sum;
        }

        return fibo(n, count + 1);
    }
// task 6 - end

}