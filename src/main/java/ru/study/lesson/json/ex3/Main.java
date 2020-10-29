package ru.study.lesson.json.ex3;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileWriter;
import java.io.Writer;

public class Main {
    public static void main(String[] args) {
        //Запись в json
        Tovar tovar = new Tovar("Tovar1", 100);


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tovarName", tovar.tovarName);
        jsonObject.put("price", tovar.price);

        String jsonString = jsonObject.toJSONString();
        System.out.println(jsonString);
        try(Writer writer = new FileWriter("src/main/java/ru/study/lesson/json/ex3/jsonFile.json")){
            writer.write(jsonString);
            writer.close();
        }catch(Exception e){
            System.out.println(e);
        }

    }
}
