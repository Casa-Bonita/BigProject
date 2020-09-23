package ru.study.lesson.json.ex2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        List<Tovar> list = new ArrayList<>();
        try(FileReader fr = new FileReader("src/main/java/ru/study/lesson/json/ex2/jsonFile.json") ){

            JSONArray jsonArray = (JSONArray)parser.parse(fr);
            for(Object val : jsonArray){
                JSONObject jsonObject = (JSONObject)val;
                String tovarName = (String)jsonObject.get("name");
                long price = (Long)jsonObject.get("price");
                Tovar t = new Tovar(tovarName, (int)price);
                list.add(t);
            }

        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println(list);
    }
}
