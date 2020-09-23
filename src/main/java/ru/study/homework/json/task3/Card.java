package ru.study.homework.json.task3;

public class Card {
    int cardNum;
    String cardStatus;
    String validTill;
    String product;

    public Card (int cardNum, String cardStatus, String validTill, String product){
        this.cardNum = cardNum;
        this.cardStatus = cardStatus;
        this.validTill = validTill;
        this.product = product;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNum=" + cardNum +
                ", cardStatus='" + cardStatus + '\'' +
                ", validTill='" + validTill + '\'' +
                ", product='" + product + '\'' +
                '}';
    }
}

