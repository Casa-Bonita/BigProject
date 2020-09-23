package ru.study.homework.json.task3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, ParseException, ClassCastException {

//    3. Создать JSON файл, содержащий банковского пользователя, который имеет много карт:
//    {
//        "name": "Ivan",
//            "surname": "Ivanov",
//            "birthDate": "10.10.2010",
//            "cards": [
//        {
//            "cardNum": "1234567890123456",
//                "cardStatus": "+",
//                "validTill": "11/20",
//                "product": "VISA"
//        },
//        {
//            "cardNum": "2234567890128567",
//                "cardStatus": "H",
//                "validTill": "12/20",
//                "product": "VISA GOLD"
//        },
//        {
//            "cardNum": "3234567890121687",
//                "cardStatus": "X",
//                "validTill": "12/21",
//                "product": "MC STANDARD"
//        },
//        {
//            "cardNum": "4234567890123456",
//                "cardStatus": "X",
//                "validTill": "12/21",
//                "product": "MAESTRO"
//        }
//      ]
//    }
//    Считать файл, создать на его основе объект пользователя и вывести его параметры на консоль.


        char symbol = 0;

        String pathFile = "src/main/java/ru/study/homework/json/task3/jsonFile.json";
//        FileInputStream fis = new FileInputStream(pathFile);
//        InputStreamReader isr = new InputStreamReader(fis);
//        BufferedReader br = new BufferedReader(isr);
//        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(pathFile)));

        JSONParser parser = new JSONParser();

//        try (FileReader fr = new FileReader ("src/main/java/ru/study/homework/json/task3/jsonFile.json")){
        Client client = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(pathFile)))){
            JSONObject jsonObjectClient = (JSONObject) parser.parse(br);
            String name = (String) jsonObjectClient.get("name");
            String surname = (String) jsonObjectClient.get("surname");
            String birthDate = (String) jsonObjectClient.get("birthDate");

            System.out.println("name = " + name + "   " + "surname = " + surname + "   " + "birthDate = " + birthDate);

            List<Card> listCard = new ArrayList<>();

            JSONArray jsonArray = (JSONArray) jsonObjectClient.get("cards");
            for (Object index : jsonArray) {
                JSONObject jsonObjectCard = (JSONObject) index;
                long cardNum = (Long) jsonObjectCard.get("cardNum");
                String cardStatus = (String) jsonObjectCard.get("cardStatus");
                String validTill = (String) jsonObjectCard.get("validTill");
                String product = (String) jsonObjectCard.get("product");
                Card card = new Card((int) cardNum, cardStatus, validTill, product);
                listCard.add(card);
            }
            client = new Client (name, surname, birthDate, listCard);
            System.out.println(listCard);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
