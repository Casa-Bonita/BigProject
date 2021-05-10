package ru.study.homework.addition_theme.Optional.task2;

public class Message {

    private String messageText;

    public Message() {
    }

    public Message(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    @Override
    public String toString() {
        return "messageText = " + messageText;
    }
}
