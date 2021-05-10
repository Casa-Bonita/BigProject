package ru.study.homework.addition_theme.Optional.task2;

import java.util.ArrayDeque;

public class MessageBuffer {
    private Message message;
    private ArrayDeque<Message> queueMessage = new ArrayDeque<>();

    public void add(Message message){
        queueMessage.add(message);
    }

    public void print(){
        while(queueMessage.peek() != null){
            // извлечение c начала
            System.out.println(queueMessage.pop().getMessageText());
        }
    }
}
