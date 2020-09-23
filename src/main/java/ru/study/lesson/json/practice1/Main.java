package ru.study.lesson.json.practice1;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Считать Json файл, содержаший универститет со студентами
        JSONParser parser = new JSONParser();
        University university=null;
        try(Reader reader = new FileReader("src/main/java/ru/study/lesson/json/practice1/jsonFile.json")){
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            String name = (String)jsonObject.get("name");
            List<Student> studentList = new ArrayList<>();
            JSONArray jsonArray = (JSONArray)jsonObject.get("student");
            for(Object student : jsonArray){
                JSONObject st = (JSONObject) student;
                String str = (String)st.get("studentName");
                long age = (Long)st.get("age");
                Student student1 = new Student(str, (int)age);
                studentList.add(student1);
            }
            university = new University(name, studentList);
        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println(university);
    }
}

