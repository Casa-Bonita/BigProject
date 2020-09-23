package ru.study.lesson.json.ex1;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try(FileReader fr = new FileReader("src/main/java/ru/study/lesson/json/ex1/jsonFile.json") ){
            JSONObject jsonObject = (JSONObject)parser.parse(fr);
            String tovarName = (String)jsonObject.get("name");
            long price = (Long)jsonObject.get("price");
            Tovar t = new Tovar(tovarName, (int)price);
            System.out.println(t);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}


