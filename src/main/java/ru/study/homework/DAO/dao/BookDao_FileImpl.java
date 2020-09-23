package ru.study.homework.DAO.dao;

import ru.study.homework.DAO.model.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao_FileImpl implements DAO<Book>{

    private String pathFile;
    private List<Book> listBook = new ArrayList<>();

    public BookDao_FileImpl(String pathFile) {
        this.pathFile = pathFile;
    }

    @Override
    public void save(Book book) {

    }

    @Override
    public void save(List<Book> listBook) {
        BufferedWriter bw = null;
        Book tempBook = new Book();
        try{
            bw = new BufferedWriter(new FileWriter(pathFile));

            for (int i = 0; i < listBook.size(); i++) {
                tempBook = listBook.get(i);
                String line = tempBook.getId() + ";" + tempBook.getName() + ";" + tempBook.getAuthor() + ";";
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }finally{
            if(bw != null){
                try{
                    bw.close();
                } catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Book> getAll() {
        List<Book> listBook = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        try{
            br = new BufferedReader(new FileReader(pathFile));
            line = br.readLine();
            while(line != null){
                String[] lineSplit = line.split(";");
                Book book = new Book(Integer.parseInt(lineSplit[0]), lineSplit[1], lineSplit[2]);
                listBook.add(book);
                line = br.readLine();
            }
            br.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }

        return listBook;
    }

    @Override
    public Book getById(int id) {
        BufferedReader br = null;
        String line = "";
        try{
            br = new BufferedReader(new FileReader(pathFile));
            line = br.readLine();
            while(line != null){
                String[] lineSplit = line.split(";");
                if(Integer.parseInt(lineSplit[0]) == id){
                    Book book = new Book(Integer.parseInt(lineSplit[0]), lineSplit[1], lineSplit[2]);
                    br.close();
                    return book;
                }
                line = br.readLine();
            }
            br.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public void update(Book oldT, Book newT) {
        if(listBook.size()==0){
            listBook = getAll();
        }
        listBook.remove(oldT);
        listBook.add(newT);
        save(listBook);
    }

    @Override
    public void delete(Book book) {

    }
}