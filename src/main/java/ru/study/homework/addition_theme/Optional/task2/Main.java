package ru.study.homework.addition_theme.Optional.task2;

import ru.study.homework.addition_theme.Optional.task1.Bill;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

//    2. Создать класс Message с полем текст сообщения.
//    Создать класс MessageGenerator с одним методом - public Optional<String> generateMessage() - возвращает сообщение с любым текстом, в том числе и null.
//
//    Создать класс MessageBuffer с полем ArrayDeque<Message> - коллекция входящих сообщений в виде очереди,
//    создать метод addMessage, который добавляет сообщения в порядке очередности их появления.
//
//    В Main запустить генерацию n сообщений и их чтение. Обработку null сообщений делать, используя средства Optional.
//    Если сообщение null, то просто выводить на консоль текст "Пустое сообщение", иначе нужно передать сообщение в метод addMessage.
//    В конце вывести на консоль все добавленные сообщения.
//    Для вывода на консоль успешных сообщений использовать уровень логера info. Для null сообщений использовать уровень warn.

        MessageBuffer messageBuffer = new MessageBuffer();
        Message message;

        for (int i = 0; i < 10; i++) {
            Optional<String> text = MessageGenerator.generateMessage();
            if(text.isPresent()){
                String temp = text.get();
                message = new Message(temp);
                messageBuffer.add(message);
                System.out.println("Сообщение " + i + " - сохранено.");
            }
            else{
                System.out.println("Сообщение " + i + " - пустое.");
            }
        }

        System.out.println("\n" + "Созданные сообщения:");

        messageBuffer.print();




    }
}
