package ru.study.homework.sql.hw1;

import java.util.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException{

//    Создайте базу данных автомобильного магазина.
//    Создайте таблицу car со столбцами:
//    mark - название марки (audi, bmw...)
//    model - название модели (q7, x5...)
//    count - количество автомобилей на складе
//
//    Создайте класс Car со свойствами:
//    - марка;
//    - модель;
//    - количество.
//
//    Создайте консольное меню просмотра автомобилей на складе в виде таблицы со столбцами: Марка, Модель, Количество.
//    Добавьте возможность увеличивать, уменьшать количество автомобилей на складе и добавлять новые автомобили у пользователя через консольное меню.
//    Также сделайте возможность просмотра всех моделей по одной марке или количество определенной модели на складе (то есть по столбцам mark и model).
//
//    Например, есть следующие автомобили:
//    название марка кол-во
//    audi            q7          3
//    bmw           x5          2
//
//    Пользователь увеличивает кол-во bmw x5 на 1 и файл должен стать:
//    audi            q7          3
//    bmw           x5          3
//
//    Или, например, пользователь добавляет новые автомобиль bwm x6 в количестве 5-ти штук и файл становится:
//    audi           q7          3
//    bmw           x5          2
//    bmw           x6          5

        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cardealership", "root", "");
        Statement stmt = connection.createStatement();

        Scanner scn = new Scanner(System.in);
        String input = "";

        while(!input.equals("8")){
            System.out.println("\n" + "1. Просмотр всех машин в наличии на складе.");
            System.out.println("2. Изменение остатка машин на складе.");
            System.out.println("3. Добавление нового автомобиля.");
            System.out.println("4. Простая сортировка данных.");
            System.out.println("5. Двойная сортировка данных.");
            System.out.println("6. Поиск по произвольному полю.");
            System.out.println("7. Складские остатки машин.");
            System.out.println("8. Выход.");

            input = scn.nextLine();
            if(input.equals("1")){
                System.out.println("1. Просмотр всех машин в наличии на складе.");
                String query = "SELECT * from car";
                ResultSet rs = stmt.executeQuery(query);
                System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");
                while(rs.next()){
                    System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                }

            }else if(input.equals("2")){ // поступление оформляется через занесение в БД нового остатка по определенной позиции
                System.out.println("2. Изменение остатка машин на складе.");
                System.out.println("Введите название автопроизводителя:");
                String automaker = scn.nextLine();
                System.out.println("Введите название модели:");
                String model = scn.nextLine();
                String query = "SELECT * FROM car WHERE automaker = '"+automaker+"' AND model = '"+model+"'";
                ResultSet rs = stmt.executeQuery(query);
                rs.next();
                System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));

                System.out.println("Внесение изменений:");
                System.out.println("1. Занесение нового остатка по выбранной позиции.");
                System.out.println("2. Изменение остатка на определенную величину.");

                String inputTemp = scn.nextLine();

                if(inputTemp.equals("1")){ // занесение нового остатка
                    System.out.println("1. Занесение нового остатка по выбранной позиции.");
                    System.out.println("Введите велчину нового остатка.");
                    int newAmount = Integer.valueOf(scn.nextLine());
                    query = "UPDATE car SET amount = "+newAmount+" WHERE automaker = '"+automaker+"' AND model = '"+model+"'";
                    stmt.executeUpdate(query);

                }else if(inputTemp.equals("2")){ // изменение остатка на дельту
                    System.out.println("2. Изменение остатка на определенную величину");
                    System.out.println("Введите велчину, на которую изменится остаток машин на складе.");
                    int deltaAmount = Integer.valueOf(scn.nextLine());
                    Car car = new Car(rs.getString("automaker"), rs.getString("model"), rs.getInt("amount"));

                    if(deltaAmount > 0){ // увеличение на определенную величину
                        int newAmount = car.getAmount() + deltaAmount;
                        query = "UPDATE car SET amount = "+newAmount+" WHERE automaker = '"+automaker+"' AND model = '"+model+"'";
                        stmt.executeUpdate(query);

                    } else { // уменьшение на определенную величину
                        if(Math.abs(deltaAmount) < car.getAmount()){
                            int newAmount = car.getAmount() + deltaAmount;
                            query = "UPDATE car SET amount = "+newAmount+" WHERE automaker = '"+automaker+"' AND model = '"+model+"'";
                            stmt.executeUpdate(query);

                        } else {
                            System.out.println("Изменение невозможно, т.к. остаток на складе меньше указанного значения.");
                            System.out.println("Введите другое количество машин.");
                        }
                    }

                }else {
                    System.out.println("Некорректный ввод.");
                }

            }else if(input.equals("3")){
                System.out.println("3. Добавление нового автомобиля:");
                System.out.println("1. Добавление полной информации (заполняются поля - автопроизводитель, модель, количество).");
                System.out.println("2. Добавление только модели (заполняются поля - модель, количество).");

                String inputTemp = scn.nextLine();
                if(inputTemp.equals("1")) { // Добавление полной информации о позиции
                    System.out.println("Введите название автопроизводителя:");
                    String automaker = scn.nextLine();
                    System.out.println("Введите название модели:");
                    String model = scn.nextLine();
                    System.out.println("Введите количество:");
                    int amount = Integer.valueOf(scn.nextLine());
                    String query = "INSERT INTO car (automaker, model, amount) VALUES ('" + automaker + "', '" + model + "', " + amount + ")";
                    stmt.executeUpdate(query);

                }else if(inputTemp.equals("2")) { // Добавление информации о модели и количестве (если автопроизводитель уже есть в базе)
                    String query = "SELECT * from car";
                    ResultSet rs = stmt.executeQuery(query);
                    Set<String> list = new TreeSet<>();
                    while(rs.next()){
                        String temp = rs.getString("automaker");
                        list.add(temp);
                    }

                    System.out.println("Имеются следующие автопроизводители:");
                    for(String state : list){
                        System.out.println(state);
                    }

                    System.out.println("Введите название автопроизводителя:");
                    String automaker = scn.nextLine();
                    for(String state : list){
                        if(automaker.equals(state)){
                            System.out.println("Введите название модели:");
                            String model = scn.nextLine();
                            System.out.println("Введите количество:");
                            int amount = Integer.valueOf(scn.nextLine());
                            query = "INSERT INTO car (automaker, model, amount) VALUES ('" + automaker + "', '" + model + "', " + amount + ")";
                            stmt.executeUpdate(query);
                        }
                    }

                }else{
                    System.out.println("Некорректный ввод.");
                }

            }else if(input.equals("4")){
                System.out.println("4. Простая сортировка данных.");
                System.out.println("Выберите номер столбец, по которому будет сортироваться информация:");
                System.out.println("1. Автопроизводитель.");
                System.out.println("2. Модель.");
                System.out.println("3. Количество.");

                String tempInput = scn.nextLine();
                if(tempInput.equals("1")){
                    System.out.println("Сортировка по столбцу \"Автопроизводитель\"");
                    System.out.println("\n" + "Выеберите тип сортировки:");
                    System.out.println("1. по Возрастанию.");
                    System.out.println("2. по Убыванию.");
                    tempInput = scn.nextLine();
                    if(tempInput.equals("1")){
                        String query = "SELECT * FROM car ORDER BY automaker";
                        ResultSet rs = stmt.executeQuery(query);
                        System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");
                        while(rs.next()){
                            System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                        }

                    } else if(tempInput.equals("2")){
                        String query = "SELECT * FROM car ORDER BY automaker DESC";
                        ResultSet rs = stmt.executeQuery(query);
                        System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");
                        while(rs.next()){
                            System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                        }

                    } else{
                        System.out.println("Некорректный ввод.");
                    }

                }else if(tempInput.equals("2")){
                    System.out.println("Сортировка по столбцу \"Модель\"");
                    System.out.println("\n" + "Выеберите тип сортировки:");
                    System.out.println("1. по Возрастанию.");
                    System.out.println("2. по Убыванию.");
                    tempInput = scn.nextLine();
                    if(tempInput.equals("1")){
                        String query = "SELECT * FROM car ORDER BY model";
                        ResultSet rs = stmt.executeQuery(query);
                        System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");
                        while(rs.next()){
                            System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                        }

                    } else if(tempInput.equals("2")){
                        String query = "SELECT * FROM car ORDER BY model DESC";
                        ResultSet rs = stmt.executeQuery(query);
                        System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");
                        while(rs.next()){
                            System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                        }

                    } else {
                        System.out.println("Некорректный ввод.");
                    }

                }else if(tempInput.equals("3")){
                    System.out.println("Сортировка по столбцу \"Количество\"");
                    System.out.println("\n" + "Выеберите тип сортировки:");
                    System.out.println("1. по Возрастанию.");
                    System.out.println("2. по Убыванию.");
                    tempInput = scn.nextLine();
                    if(tempInput.equals("1")){
                        String query = "SELECT * FROM car ORDER BY amount";
                        ResultSet rs = stmt.executeQuery(query);
                        System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");
                        while(rs.next()){
                            System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                        }

                    } else if(tempInput.equals("2")){
                        String query = "SELECT * FROM car ORDER BY amount DESC";
                        ResultSet rs = stmt.executeQuery(query);
                        System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");
                        while(rs.next()){
                            System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                        }

                    } else {
                        System.out.println("Некорректный ввод.");
                    }

                }else{
                    System.out.println("Некорректный ввод.");
                }

            }else if(input.equals("5")){
                System.out.println("5. Двойная сортировка данных.");
                System.out.println("Выберите номер столбца, по которому будет первичная сортировка информации:");
                System.out.println("1. Автопроизводитель.");
                System.out.println("2. Модель.");
                System.out.println("3. Количество.");

                String firstColumn = scn.nextLine();
                if(firstColumn.equals("1")){
                    System.out.println("Сортировка по столбцу \"Автопроизводитель\"");
                    System.out.println("\n" + "Выеберите тип сортировки:");
                    System.out.println("1. по Возрастанию.");
                    System.out.println("2. по Убыванию.");
                    String firstChoice = scn.nextLine();

                    System.out.println("\n" + "Выеберите второй столбец для сортировки:");
                    System.out.println("1. Модель.");
                    System.out.println("2. Количество.");
                    String secondColumn = scn.nextLine();

                    System.out.println("\n" + "Выеберите тип сортировки для второго столбца:");
                    System.out.println("1. по Возрастанию.");
                    System.out.println("2. по Убыванию.");
                    String secondChoice = scn.nextLine();

                    if(firstChoice.equals("1")){ // сортировка главного столбца по Возрастанию
                        if(secondColumn.equals("1")){ // сортировка по второму столбцу

                            if(secondChoice.equals("1")){ // сортировка второго столбца по Возрастанию
                                String query = "SELECT * FROM car ORDER BY automaker, model";
                                ResultSet rs = stmt.executeQuery(query);
                                System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");
                                while(rs.next()){
                                    System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                                }

                            }else if (secondChoice.equals("2")){ // сортировка второго столбца по Убыванию
                                String query = "SELECT * FROM car ORDER BY automaker, model DESC";
                                ResultSet rs = stmt.executeQuery(query);
                                System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");
                                while(rs.next()){
                                    System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                                }

                            }else{
                                System.out.println("Некорректный ввод");
                            }

                        }else if(secondColumn.equals("2")){ // сортировка по второму столбцу

                            if(secondChoice.equals("1")){ // сортировка второго столбца по Возрастанию
                                String query = "SELECT * FROM car ORDER BY automaker, amount";
                                ResultSet rs = stmt.executeQuery(query);
                                System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");
                                while(rs.next()){
                                    System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                                }

                            }else if (secondChoice.equals("2")){ // сортировка второго столбца по Убыванию
                                String query = "SELECT * FROM car ORDER BY automaker, amount DESC";
                                ResultSet rs = stmt.executeQuery(query);
                                System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");
                                while(rs.next()){
                                    System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                                }

                            }else{
                                System.out.println("Некорректный ввод");
                            }

                        }else {
                            System.out.println("Некорректный ввод.");
                        }

                    } else if(firstChoice.equals("2")){ // сортировка главного столбца по Убыванию
                        if(secondColumn.equals("1")){ // сортировка по второму столбцу

                            if(secondChoice.equals("1")){ // сортировка второго столбца по Возрастанию
                                String query = "SELECT * FROM car ORDER BY automaker DESC, model";
                                ResultSet rs = stmt.executeQuery(query);
                                System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");
                                while(rs.next()){
                                    System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                                }

                            }else if (secondChoice.equals("2")){ // сортировка второго столбца по Убыванию
                                String query = "SELECT * FROM car ORDER BY automaker DESC, model DESC";
                                ResultSet rs = stmt.executeQuery(query);
                                System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");
                                while(rs.next()){
                                    System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                                }

                            }else{
                                System.out.println("Некорректный ввод");
                            }

                        }else if(secondColumn.equals("2")){ // сортировка по второму столбцу

                            if(secondChoice.equals("1")){ // сортировка второго столбца по Возрастанию
                                String query = "SELECT * FROM car ORDER BY automaker DESC, amount";
                                ResultSet rs = stmt.executeQuery(query);
                                System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");
                                while(rs.next()){
                                    System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                                }

                            }else if (secondChoice.equals("2")){ // сортировка второго столбца по Убыванию
                                String query = "SELECT * FROM car ORDER BY automaker DESC, amount DESC";
                                ResultSet rs = stmt.executeQuery(query);
                                System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");
                                while(rs.next()){
                                    System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                                }

                            }else{
                                System.out.println("Некорректный ввод");
                            }

                        }else {
                            System.out.println("Некорректный ввод.");
                        }

                    } else{
                        System.out.println("Некорректный ввод.");
                    }

                }else if(firstColumn.equals("2")){
                    System.out.println("Сортировка по столбцу \"Модель\"");
                    System.out.println("\n" + "Выеберите тип сортировки:");
                    System.out.println("1. по Возрастанию.");
                    System.out.println("2. по Убыванию.");
                    String firstChoice = scn.nextLine();

                    System.out.println("\n" + "Выеберите второй столбец для сортировки:");
                    System.out.println("1. Автопроизводитель.");
                    System.out.println("2. Количество.");
                    String secondColumn = scn.nextLine();

                    System.out.println("\n" + "Выеберите тип сортировки для второго столбца:");
                    System.out.println("1. по Возрастанию.");
                    System.out.println("2. по Убыванию.");
                    String secondChoice = scn.nextLine();

                    if(firstChoice.equals("1")){ // сортировка главного столбца по Возрастанию
                        if(secondColumn.equals("1")){ // сортировка по второму столбцу

                            if(secondChoice.equals("1")){ // сортировка второго столбца по Возрастанию
                                String query = "SELECT * FROM car ORDER BY model, automaker";
                                ResultSet rs = stmt.executeQuery(query);
                                System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");
                                while(rs.next()){
                                    System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                                }

                            }else if (secondChoice.equals("2")){ // сортировка второго столбца по Убыванию
                                String query = "SELECT * FROM car ORDER BY model, automaker DESC";
                                ResultSet rs = stmt.executeQuery(query);
                                System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");
                                while(rs.next()){
                                    System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                                }

                            }else{
                                System.out.println("Некорректный ввод");
                            }

                        }else if(secondColumn.equals("2")){ // сортировка по второму столбцу

                            if(secondChoice.equals("1")){ // сортировка второго столбца по Возрастанию
                                String query = "SELECT * FROM car ORDER BY model, amount";
                                ResultSet rs = stmt.executeQuery(query);
                                System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");
                                while(rs.next()){
                                    System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                                }

                            }else if (secondChoice.equals("2")){ // сортировка второго столбца по Убыванию
                                String query = "SELECT * FROM car ORDER BY model, amount DESC";
                                ResultSet rs = stmt.executeQuery(query);
                                System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");
                                while(rs.next()){
                                    System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                                }

                            }else{
                                System.out.println("Некорректный ввод");
                            }

                        }else {
                            System.out.println("Некорректный ввод.");
                        }

                    } else if(firstChoice.equals("2")){ // сортировка главного столбца по Убыванию
                        if(secondColumn.equals("1")){ // сортировка по второму столбцу

                            if(secondChoice.equals("1")){ // сортировка второго столбца по Возрастанию
                                String query = "SELECT * FROM car ORDER BY model DESC, automaker";
                                ResultSet rs = stmt.executeQuery(query);
                                System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");
                                while(rs.next()){
                                    System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                                }

                            }else if (secondChoice.equals("2")){ // сортировка второго столбца по Убыванию
                                String query = "SELECT * FROM car ORDER BY model DESC, automaker DESC";
                                ResultSet rs = stmt.executeQuery(query);
                                System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");
                                while(rs.next()){
                                    System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                                }

                            }else{
                                System.out.println("Некорректный ввод");
                            }

                        }else if(secondColumn.equals("2")){ // сортировка по второму столбцу

                            if(secondChoice.equals("1")){ // сортировка второго столбца по Возрастанию
                                String query = "SELECT * FROM car ORDER BY model DESC, amount";
                                ResultSet rs = stmt.executeQuery(query);
                                System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");
                                while(rs.next()){
                                    System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                                }

                            }else if (secondChoice.equals("2")){ // сортировка второго столбца по Убыванию
                                String query = "SELECT * FROM car ORDER BY model DESC, amount DESC";
                                ResultSet rs = stmt.executeQuery(query);
                                System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");
                                while(rs.next()){
                                    System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                                }

                            }else{
                                System.out.println("Некорректный ввод");
                            }

                        }else {
                            System.out.println("Некорректный ввод.");
                        }

                    } else{
                        System.out.println("Некорректный ввод.");
                    }

                }else if(firstColumn.equals("3")){
                    System.out.println("Сортировка по столбцу \"Количество\"");
                    System.out.println("\n" + "Выеберите тип сортировки:");
                    System.out.println("1. по Возрастанию.");
                    System.out.println("2. по Убыванию.");
                    String firstChoice = scn.nextLine();

                    System.out.println("\n" + "Выеберите второй столбец для сортировки:");
                    System.out.println("1. Автопроизводитель.");
                    System.out.println("2. Модель.");
                    String secondColumn = scn.nextLine();

                    System.out.println("\n" + "Выеберите тип сортировки для второго столбца:");
                    System.out.println("1. по Возрастанию.");
                    System.out.println("2. по Убыванию.");
                    String secondChoice = scn.nextLine();

                    if(firstChoice.equals("1")){ // сортировка главного столбца по Возрастанию
                        if(secondColumn.equals("1")){ // сортировка по второму столбцу

                            if(secondChoice.equals("1")){ // сортировка второго столбца по Возрастанию
                                String query = "SELECT * FROM car ORDER BY amount, automaker";
                                ResultSet rs = stmt.executeQuery(query);
                                System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");
                                while(rs.next()){
                                    System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                                }

                            }else if (secondChoice.equals("2")){ // сортировка второго столбца по Убыванию
                                String query = "SELECT * FROM car ORDER BY amount, automaker DESC";
                                ResultSet rs = stmt.executeQuery(query);
                                System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");
                                while(rs.next()){
                                    System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                                }

                            }else{
                                System.out.println("Некорректный ввод");
                            }

                        }else if(secondColumn.equals("2")){ // сортировка по второму столбцу

                            if(secondChoice.equals("1")){ // сортировка второго столбца по Возрастанию
                                String query = "SELECT * FROM car ORDER BY amount, model";
                                ResultSet rs = stmt.executeQuery(query);
                                System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");
                                while(rs.next()){
                                    System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                                }

                            }else if (secondChoice.equals("2")){ // сортировка второго столбца по Убыванию
                                String query = "SELECT * FROM car ORDER BY amount, model DESC";
                                ResultSet rs = stmt.executeQuery(query);
                                System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");
                                while(rs.next()){
                                    System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                                }

                            }else{
                                System.out.println("Некорректный ввод");
                            }

                        }else {
                            System.out.println("Некорректный ввод.");
                        }

                    } else if(firstChoice.equals("2")){ // сортировка главного столбца по Убыванию
                        if(secondColumn.equals("1")){ // сортировка по второму столбцу

                            if(secondChoice.equals("1")){ // сортировка второго столбца по Возрастанию
                                String query = "SELECT * FROM car ORDER BY amount DESC, automaker";
                                ResultSet rs = stmt.executeQuery(query);
                                System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");
                                while(rs.next()){
                                    System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                                }

                            }else if (secondChoice.equals("2")){ // сортировка второго столбца по Убыванию
                                String query = "SELECT * FROM car ORDER BY amount DESC, automaker DESC";
                                ResultSet rs = stmt.executeQuery(query);
                                System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");
                                while(rs.next()){
                                    System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                                }

                            }else{
                                System.out.println("Некорректный ввод");
                            }

                        }else if(secondColumn.equals("2")){ // сортировка по второму столбцу

                            if(secondChoice.equals("1")){ // сортировка второго столбца по Возрастанию
                                String query = "SELECT * FROM car ORDER BY amount DESC, model";
                                ResultSet rs = stmt.executeQuery(query);
                                System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");
                                while(rs.next()){
                                    System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                                }

                            }else if (secondChoice.equals("2")){ // сортировка второго столбца по Убыванию
                                String query = "SELECT * FROM car ORDER BY amount DESC, model DESC";
                                ResultSet rs = stmt.executeQuery(query);
                                System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");
                                while(rs.next()){
                                    System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                                }

                            }else{
                                System.out.println("Некорректный ввод");
                            }

                        }else {
                            System.out.println("Некорректный ввод.");
                        }

                    } else{
                        System.out.println("Некорректный ввод.");
                    }

                }else{
                    System.out.println("Некорректный ввод.");
                }


            }else if(input.equals("6")) {
                System.out.println("6. Поиск по произвольному полю.");
                System.out.println("\n" + "Введите номер поля, по которому будет произведён поиск.");
                System.out.println("1. Автопроизводитель.");
                System.out.println("2. Модель.");
                System.out.println("3. Количество.");

                String tempInput = scn.nextLine();

                String query = "SELECT * from car";
                ResultSet rs = stmt.executeQuery(query);

                Set<String> listAutomaker = new TreeSet<>();
                Set<String> listModel = new TreeSet<>();
                Set<Integer> listAmount = new TreeSet<>();

                while (rs.next()) {
                    String temp1 = rs.getString("automaker");
                    listAutomaker.add(temp1);
                    String temp2 = rs.getString("model");
                    listModel.add(temp2);
                    int temp3 = rs.getInt("amount");
                    listAmount.add(temp3);
                }

                if (tempInput.equals("1")) {
                    System.out.println("Имеются следующие автопроизводители:");
                    for (String state : listAutomaker) {
                        System.out.println(state);
                    }

                    System.out.println("\n" + "Введите название автопроизводителя:");
                    String inputAutomaker = scn.nextLine();

                    for (String state : listAutomaker) {
                        if (inputAutomaker.equals(state)) {
                            query = "SELECT * FROM car WHERE automaker = '" + inputAutomaker + "'";
                            rs = stmt.executeQuery(query);
                            System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");

                            while (rs.next()) {
                                System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                            }
                        }
                    }

                } else if (tempInput.equals("2")) {
                    System.out.println("Имеются следующие модели автомобилей:");
                    for (String state : listModel) {
                        System.out.println(state);
                    }

                    System.out.println("\n" + "Введите название модели:");
                    String inputModel = scn.nextLine();

                    for (String state : listAutomaker) {
                        if (inputModel.equals(state)) {
                            query = "SELECT * FROM car WHERE model = '" + inputModel + "'";
                            rs = stmt.executeQuery(query);
                            System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");

                            while (rs.next()) {
                                System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                            }
                        }
                    }

                } else if (tempInput.equals("3")) {
                    System.out.println("Имеются следующие количественные остатки на складе:");
                    for (int state : listAmount) {
                        System.out.println(state);
                    }

                    System.out.println("\n" + "Введите остаток:");
                    int inputAmount = Integer.valueOf(scn.nextLine());

                    for (int state : listAmount) {
                        if (inputAmount == state) {
                            query = "SELECT * FROM car WHERE amount = " + inputAmount + "";
                            rs = stmt.executeQuery(query);
                            System.out.println("Марка" + "   " + "Модель" + "   " + "Количество");

                            while (rs.next()) {
                                System.out.println(rs.getString("automaker") + "      " + rs.getString("model") + "      " + rs.getInt("amount"));
                            }
                        }
                    }

                }

            }else if(input.equals("7")){
                System.out.println("7. Складские остатки машин.");
                System.out.println("1. Общий остаток.");
                System.out.println("2. Остаток по автопроизводителю.");
                System.out.println("3. Остаток по модели.");

                String tempInput = scn.nextLine();
                if(tempInput.equals("1")){
                    String query = "SELECT SUM(amount) FROM car";
                    ResultSet rs = stmt.executeQuery(query);
                    System.out.println("Остаток машин на складе:");
                    rs.next();
                    System.out.println(rs.getInt("SUM(amount)"));

                } else if(tempInput.equals("2")){
                    String query = "SELECT * from car";
                    ResultSet rs = stmt.executeQuery(query);
                    Set<String> listAutomaker = new TreeSet<>();

                    while (rs.next()) {
                        String temp = rs.getString("automaker");
                        listAutomaker.add(temp);
                    }

                    System.out.println("Имеются следующие автопроизводители:");
                    for (String state : listAutomaker) {
                        System.out.println(state);
                    }
                    System.out.println("\n" + "Введите название автопроизводителя:");
                    String inputAutomaker = scn.nextLine();

                    for (String state : listAutomaker) {
                        if (inputAutomaker.equals(state)) {
                            query = "SELECT SUM(amount) FROM car WHERE automaker = '" + inputAutomaker + "'";
                            rs = stmt.executeQuery(query);
                            System.out.println("Марка = " + inputAutomaker);

                            rs.next();
                            System.out.println(rs.getInt(1));
                        }
                    }

                } else if(tempInput.equals("3")){
                    String query = "SELECT * from car";
                    ResultSet rs = stmt.executeQuery(query);
                    Set<String> listModel = new TreeSet<>();

                    while (rs.next()) {
                        String temp = rs.getString("model");
                        listModel.add(temp);
                    }

                    System.out.println("Имеются следующие модели автомобилей:");
                    for (String state : listModel) {
                        System.out.println(state);
                    }
                    System.out.println("\n" + "Введите название модели:");
                    String inputModel = scn.nextLine();

                    for (String state : listModel) {
                        if (inputModel.equals(state)) {
                            query = "SELECT SUM(amount) FROM car WHERE model = '" + inputModel + "'";
                            rs = stmt.executeQuery(query);
                            System.out.println("Модель = " + inputModel);

                            rs.next();
                            System.out.println(rs.getInt(1));
                        }
                    }

                }else {
                    System.out.println("Некорректный ввод.");
                }

            }else if(input.equals("8")){
                System.out.println("Программа завершила свою работу.");

            }else{
                System.out.println("Некорректный ввод.");
            }

        }


    }
}
