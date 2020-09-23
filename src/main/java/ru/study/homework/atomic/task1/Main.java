package ru.study.homework.atomic.task1;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {



//    TASK 1.
//    Создать программу для мойки тарелок. Тарелки моются по принципу последний вошел - первый вышел.
//    То есть последняя тарелка, находящаяся вверху стопки грязных тарелок, будет помыта первой, а первая тарелка, находящаяся внизу,
//    будет помыта последней. При этом в раковину могут добавляться новые тарелки.
//
//    Создать класс Plate (тарелка) с private полем:
//    - номер тарелки.
//    Переопределить метод toString.
//    Остальную структуру класса Plate дополнить по необходимости.
//
//    Создать класс DishWasher (мойщик посуды) с private полем в виде стека.
//    Создать метод startWash() - запускает мытье тарелок, добавленных в стек по принципу последний вошел - первый вышел.
//    Остальную структуру класса DishWasher дополнить по необходимости.
//
//    В main сгенерировать число m - начальное количество грязных тарелок и заполнить стек грязными тарелками. Номера у тарелок должны быть в порядке их добавления в стопку.
//    Программа должна запустить процесс мойки тарелок в виде вывода текста на консоль "Тарелка № 1 помыта". Также должна быть предусмотрена возможность
//    добавления новых грязных тарелок в стек за счет ввода с консоли в процессе мойки (параллельно процессу мойки).
//    Новые добавленные тарелки должны быть помыты первыми за счет принципа последний вошел - первый вышел.




//        Random rnd = new Random();
//        int startVolume = rnd.nextInt(29) + 1;
        int startVolume = 7;
        System.out.println("Начальное количество грязных тарелок = " + startVolume);

        System.out.println("В раковине следующие тарелки:");
        List<Plate> listPlate = Collections.synchronizedList(new Stack());


        Runnable runnable1 = () -> {
            synchronized (listPlate) {
                System.out.println("\n" + Thread.currentThread().getName() + "\n");
                for (int i = 0; i < startVolume; i++) {
                    String line = "Тарелка " + i;
                    Plate plate = new Plate(line);
                    System.out.println(line);
                    listPlate.add(plate);
                }
            }
        };

        DishWasher dishWasher = new DishWasher();

        Runnable runnable2 = () -> {
            System.out.println("\n" + Thread.currentThread().getName() + "\n");
            for (int i = (listPlate.size() - 1); i >= 0; i--) {
                try{
                    synchronized (dishWasher) {
                        dishWasher.startWash(listPlate, i);
                        Thread.sleep(2000);
                    }
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };

        Thread thread1 = new Thread(runnable1, "Поток загрузки тарелок в мойку");
        Thread thread2 = new Thread(runnable2, "Поток процесса мытья тарелок");
        thread1.start();
        try {
            thread1.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        thread2.start();


        Scanner scn = new Scanner(System.in);
        String choice = "";
        System.out.println("Добавить дополнительные грязные тарелки в мойку: \"да\" или \"нет\"?");
        choice = scn.nextLine();
        if (choice.equals("да")){
            String input = "";
            System.out.println("Введите количество дополнительных грязных тарелок:");
            input = scn.nextLine();
            try {
                int addedPlates = Integer.parseInt(input);
                System.out.println("Добавлено " + addedPlates + " дополнительных грязных тарелок.");
                for(int i = 0; i < addedPlates; i++){
                    String line = "Дополнительная тарелка " + i;
                    Plate plate = new Plate(line);
                    System.out.println(line);
                    listPlate.add(plate);
                }
            }catch (NumberFormatException e){
                System.out.println("Некорректный ввод.");
                System.out.println("Количество дополнительных грязных тарелок = 0.");
                System.out.println("Все тарелки вымыты.");
            }


            System.out.println("\n" + "Начинаем мыть грязные тарелки.");
//            dishWasher.startWash(listPlate);


        }else if(choice.equals("no")){
            System.out.println("Грязных тарелок больше нет.");

        }else {
            System.out.println("Некорректный ввод.");
        }



    }
}
