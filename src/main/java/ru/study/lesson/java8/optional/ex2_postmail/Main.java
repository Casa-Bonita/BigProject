package ru.study.lesson.java8.optional.ex2_postmail;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        //Создать класс PostMail (почтовое отделение) с private полем List<Optional<Parcel>>.
        // Создать класс Parcel (посылка) с полем Наименование посылки.
        //В классе PostMail создать методы:
        //
        //addParcel(Parcel parcel) - добавляет посылку в список. Может принимать null.
        //
        //makeSend - запускает рассылку посылок. Метод должен обрабатывать объекты класса Parcel на null.
        // Если объект посылки null, программа должна вывести на консоль "Пустая посылка". Если объект не null,
        // программа должна выводить текст "Посылка [наименование посылки] отправлена"

        //Разница между of и ofNullable
        //Object ob = null;
//        Optional<Object> ob1 = Optional.of(ob); //Здесь будет NullPointerException
        //Optional<Object> ob2 = Optional.ofNullable(ob);

        //ob2.get(); //здесь будет NoSuchElementException

        PostMail postMail = new PostMail();
        for (int i = 0; i < 10; i++) {
            Optional<Parcel> generatedParceOpt = ParcelGenerator.generateParcel();
            generatedParceOpt.ifPresentOrElse(parcel -> postMail.addParcel(parcel), ()-> System.out.println("Посылка = null"));
        }
        System.out.println("Запущена рассылка!");
        postMail.makeSend();

        sum(2,3);
    }

    public static void sum(int a, int b){
        System.out.println(a+b);
    }
}
