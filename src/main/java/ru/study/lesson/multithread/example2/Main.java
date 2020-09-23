package ru.study.lesson.multithread.example2;

public class Main {

    public static void main(String[] args) {
        //есть три массива. Нати в разных потоках сумму, максимум, минимум для соответствующих массивов
        int[] arr1 = {1,4,2,5,1};
        int[] arr2 ={4,16,234,6,7};
        int[] arr3 = {8,15,4235,3};

        //int a = 2;
        Runnable runnableSum = ()->{
            int sum = 0;
            for (int i = 0; i < arr1.length; i++) {
                sum = sum + arr1[i];
            }
            System.out.println("Сумма = " + sum);

            //System.out.println(a);
        };

        Runnable runnableMax = ()->{
            int max = arr2[0];
            for (int i = 0; i < arr2.length; i++) {
                if(max < arr2[i]){
                    max = arr2[i];
                }
            }
            System.out.println("Максимум = " + max);
        };

        Runnable runnableMin = ()->{
            int min = arr3[0];
            for (int i = 0; i < arr3.length; i++) {
                if(min > arr3[i]){
                    min = arr3[i];
                }
            }
            System.out.println("Миниимум = " + min);
        };

        new Thread(runnableSum).start();
        new Thread(runnableMax).start();
        new Thread(runnableMin).start();




    }
}
