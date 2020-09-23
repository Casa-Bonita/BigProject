package ru.study.lesson.multithread.example5_synchronized;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //синхронизация доступа потоков к общему ресурсу

        //Оба потока используют одну переменную и увеличивают ее на 1 каждый по 20 раз. В итоге переменная должна быть равна 40
//        Wrapper wrapper = new Wrapper();
//        Runnable r1 = ()->{
//
//            for (int i = 0; i < 20; i++) {
//                int curr = wrapper.i;
//                //thread1: curr = 0;
//                curr++;
//                //thread1: curr = 1
//                //прерывается поток
//                Thread.yield();
//                wrapper.i = curr;
//                //thread2: i = 1
//            }
//        };
//
//        Runnable r2 = ()->{
//            for (int i = 0; i < 20; i++) {
//                int curr = wrapper.i;
//                //thread2: curr = 0
//                curr++;
//                //thread2: curr = 1
//                wrapper.i = curr;
//                //thread2: i = 1
//
//            }
//        };
//
//
//        Thread th1 = new Thread(r1);
//        th1.start();
//        Thread th2 = new Thread(r2);
//        th2.start();
//
//        th1.join();
//        th2.join();
//        System.out.println("Итоговое i = "+wrapper.i);


        //для синхронизации доступа потоков к общему ресурсу используется synchronized
        Wrapper wrapper = new Wrapper();
        Runnable r1 = ()->{
            for (int i = 0; i < 20; i++) {
                synchronized (wrapper) {
                    int curr = wrapper.i;
                    curr++;
                    Thread.yield(); //уже не прервет поток
                    wrapper.i = curr;
                }

            }
        };

        Runnable r2 = ()->{
            for (int i = 0; i < 20; i++) {
                synchronized (wrapper) {
                    int curr = wrapper.i;
                    curr++;
                    wrapper.i = curr;
                }
            }
        };


        Thread th1 = new Thread(r1);
        th1.start();
        Thread th2 = new Thread(r2);
        th2.start();

        th1.join();
        th2.join();
        System.out.println("Итоговое i = "+wrapper.i);

        //Второй вариант синхронизации - синхрозация метода - смотреть в следующем примере
    }

}

class Wrapper{
    int i;
}
