package ru.study.homework.inputoutput;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.io.IOException;
import java.io.BufferedWriter;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static javax.swing.UIManager.get;

public class Main{

    public static void main(String[] args) throws IOException, ParseException {

        Charset win1251 = Charset.forName("Windows-1251");

//// Task 1 - START
////1. Запись в файл через байтовый поток вывода FileOutputStream текст "hello java".
//// Считать из файла через байтовый поток ввода FileInputStream первые 5 символов и вывести на консоль. Должно получиться слово hello.
//// Считать из файла отдельно пробел и отдельно слово java и вывести слово java на консоль без пробела.
//
//        String pathFile1 = "src/ru/study/homework/inputoutput/test1.txt";
//        char symbol = 0;
//
//        FileOutputStream fos = new FileOutputStream(pathFile1);
//        OutputStreamWriter osw = new OutputStreamWriter(fos, win1251);
//        BufferedWriter bw = new BufferedWriter(osw);
//
//        bw.write("hello java");
//        bw.newLine();
//        bw.close();
//
//        FileInputStream fis = new FileInputStream(pathFile1);
//        InputStreamReader isr = new InputStreamReader(fis);
//        BufferedReader br1 = new BufferedReader(isr);
//
//        System.out.println("1. Считывание первых 5-ти символов:");
//        int i = 1;
//        while(i != 6){
//            symbol = (char)br1.read();
//            System.out.print(symbol);
//            i++;
//        }
//        System.out.println();
//        br1.close();
//
//        symbol = 0;
//        System.out.println("\n" + "2. Отдельное считывание знака пробел:");
//        BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(pathFile1)));
//        while(symbol == ' '){
//            symbol = (char)br2.read();
//        }
//        System.out.print("Знак" + symbol + "пробел" + "\n");
//        br2.close();
//
//        System.out.println("\n" + "3. Отдельное считывание слова java:");
//        BufferedReader br3 = new BufferedReader(new InputStreamReader(new FileInputStream(pathFile1)));
//        while(true){
//            symbol = (char)br3.read();
//            if(symbol == 'j'){
//                System.out.println("считываение символа = " + symbol);
//                symbol = (char)br3.read();
//                if(symbol == 'a'){
//                    System.out.println("считываение символа = " + symbol);
//                    symbol = (char)br3.read();
//                    if(symbol == 'v'){
//                        System.out.println("считываение символа = " + symbol);
//                        symbol = (char)br3.read();
//                        if(symbol == 'a'){
//                            System.out.println("считываение символа = " + symbol);
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//        br3.close();
//// Task 1 - END
//
//
//// Task 2 - START
////2. Записать в файл строки с помощью PrintWriter:
//// 1
//// hello java
//// 10
//// -3
//// Считать этот файл, используя в основе байтовый поток ввода FileInputStream. Чтобы считывание было удобным, нужно обернуть объект FileInputStream в объект класса
//// BufferedReader и считать файл. Для конвертации из байтового потока в символьный понадобится класс InputStreamReader.
//// Найти максимальное число в файле. Файл содержит текстовые символы, при поиске максимального числа нужно сделать проверку на то, что считанное значение является числом.
//
//        String pathFile2 = "src/ru/study/homework/inputoutput/test2.txt";
//
//        PrintWriter pw = new PrintWriter(pathFile2);
//        pw.println("1");
//        pw.println("hello java");
//        pw.println("10");
//        pw.print("-3");
//        pw.close();
//
//        FileInputStream fis = new FileInputStream(pathFile2);
//        InputStreamReader isr = new InputStreamReader(fis, win1251);
//        BufferedReader br = new BufferedReader (isr);
//
//        String line = "";
//        int symbolInt = br.read();
//        while(symbolInt != -1){
//            char symbolChar = (char) symbolInt;
//            line = line + symbolChar;
//            System.out.print(symbolChar);
//            symbolInt = br.read();
//        }
//        br.close();
//        System.out.println("\n");
//
//        ArrayList<String> listSeparate = new ArrayList<>(); // список после разделения строки на элементы
//        listSeparate.addAll(Arrays.asList(line.split("\\s+")));
//
//        ArrayList<Integer> listNumber = new ArrayList<>(); // список с числовыми значениями
//        for(int i = 0; i < listSeparate.size(); i++){
//            try{
//                listNumber.add(Integer.valueOf(listSeparate.get(i)));
//            }catch (NumberFormatException e) {
//                System.out.println(listSeparate.get(i) + " - не является числом");
//            }
//        }
//
//        int max = listNumber.get(0); // поиск максимума
//        for (int i = 0; i < listNumber.size(); i++) {
//            if(max < listNumber.get(i)){
//                max = listNumber.get(i);
//            }
//        }
//
//        System.out.println("\n" + "Максимальное число = " + max);
//
//// Task 2 - END
//
//
//// Task 3 - START
//// 3. Создать конвертер валют из долларов в рубли и обратно.
//// Создать консольное меню:
//// 1. Конвертировать рубли в доллары
//// 2. Конвертировать доллары в рубли (при выборе пользователь вводит с консоли доллары в
//// формате целая_часть.дробная_часть $: 3.1 $)
//// 3. Выход
////
//// При выборе пункта 1 пользователь вводит с консоли рубли в формате
//// целая_часть.дробная_часть руб (например: 2.234 руб), программа с помощью регулярного выражения проверяет, что пользователь ввел именно рубли,
//// конвертирует их в доллары и выводит доллары на консоль вместе со знаком доллара $.
////
//// При выборе пункта 2 пользователь вводит с консоли доллары в формате
//// целая_часть.дробная_часть $ (например: 2.234 $), программа с помощью регулярного выражения проверяет, что пользователь ввел именно доллары,
//// конвертирует их в рубли и  выводит рубли на консоль вместе со знаком рублей руб. (нужно учесть, что символ $
//// является служебным и для его использования в качестве строки нужно экранирование)
////
//
//        Scanner scn = new Scanner(System.in);
//
//        final String REGEX = "\\d{1,}[.]\\d{3}\\s(\\bруб\\b|[$])";
//        final double RATE = 63.7675;
//        String input = "";
//
//
//        String usd; // регулярное выражение для ввода долларов
//
//        System.out.println("Выберите пункт меню:" + "\n");
//        while(!input.equals("3")){
//            System.out.println("1. Конвертировать рубли в доллары.");
//            System.out.println("2. Конвертировать доллары в рубли.");
//            System.out.println("3. Выход.");
//            input = scn.nextLine();
//            if (input.equals("1")){
//
//                System.out.println("\n" + "Введите сумму в рублях, в формате:");
//                System.out.println("целая_часть.дробная_часть руб (например: 2.234 руб)" + "\n");
//                String amount = scn.nextLine();
//
//                //String regex = "\\d{1,}[.]\\d{3}\\s[р][у][б]";
//
//                Pattern pattern = Pattern.compile(REGEX);
//                Matcher matcher = pattern.matcher(amount);
//
//                if(matcher.matches()){
//                    System.out.println("введены символы = " + amount);
//                    pattern = Pattern.compile("[ ]");
//                    String[] separate = pattern.split(amount);
//
//                    double result = Double.parseDouble(separate[0]) / RATE;
//                    System.out.println("На " + separate[0] + " рублей, можно купить " + result + " $ долларов США" + "\n");
//
//                }else {
//                    System.out.println("Введена некорректная сумма. Повторите ввод" + "\n");
//                }
//
//            }else if(input.equals("2")) {
//
//                System.out.println("\n" + "Введите сумму в долларах, в формате:");
//                System.out.println("целая_часть.дробная_часть $ (например: 2.234 $)" + "\n");
//                String amount = scn.nextLine();
//
//                // String regex = "\\d{1,}[.]\\d{3}\\s[$]";
//
//                Pattern pattern = Pattern.compile(REGEX);
//                Matcher matcher = pattern.matcher(amount);
//
//                if(matcher.matches()){
//                    System.out.println("введены символы = " + amount);
//                    pattern = Pattern.compile("[ ]");
//                    String[] separate = pattern.split(amount);
//
//                    double result = Double.parseDouble(separate[0]) * RATE;
//                    System.out.println("За " + separate[0] + " долларов США, можно получить " + result + " рублей" + "\n");
//
//                }else {
//                    System.out.println("Введена некорректная сумма. Повторите ввод" + "\n");
//
//                }
//
//            }else if(input.equals("3")){
//                System.out.println("Программа завершила свою работу.");
//                break;
//
//            }else {
//                System.out.println("Выполнен некорректный ввод данных. Повторите ввод." + "\n");
//
//            }
//        }
//// Task 3 - END
//
//
//// Task 4 - START
//// 4. Сделать проверку строки с помощью регулярного выражения на то, что она содержит
//// число (как положительное, так и отрицательное с не более, чем одним знаком минуса)
//
//        ArrayList<String> listSuit = new ArrayList(); // позитивные тесты
//
//        listSuit.add("try home -25");
//        listSuit.add("try home 25");
//        listSuit.add("time 25 summer");
//        listSuit.add("time -25 summer");
//        listSuit.add("15 year soon");
//        listSuit.add("-15 year soon");
//
//        ArrayList<String> listNotSuit = new ArrayList(); // негативные тесты
//
//        listNotSuit.add("try 25 home -25");
//        listNotSuit.add("try -15 home 25");
//        listNotSuit.add("15 time summer 15");
//        listNotSuit.add("-15 time summer 15");
//        listNotSuit.add("15 moon 30 guard");
//        listNotSuit.add("-15 moon 30 guard");
//        listNotSuit.add("year --15 soon");
//        listNotSuit.add("year 10 20 soon");
//        listNotSuit.add("year @ # $ % ^ soon");
//        listNotSuit.add("year @#$%^ soon");
//
//        // число - текст
//        //final String REGEX = "^[-]?\\d+[\\s\\<[a-zA-Z]\\>]+$";
//
//        // текст - число
//        //final String REGEX = "^[\\<[a-zA-Z]\\>\\s]+[-]?\\d+$";
//
//        // текст - число - текст
//        //final String REGEX = "^[\\<[a-zA-Z]\\>\\s]+[-]?\\d+[\\s\\<[a-zA-Z]\\>]+$";
//
//        // общая конструкция: (число - текст) или (текст - число - текст) или (текст - число)
//        final String REGEX = "(^[-]?\\d+[\\s\\<[a-zA-Z]\\>]+$|^[\\<[a-zA-Z]\\>\\s]+[-]?\\d+[\\s\\<[a-zA-Z]\\>]+$|^[\\<[a-zA-Z]\\>\\s]+[-]?\\d+$)";
//
//        Pattern pattern = Pattern.compile(REGEX);
//        System.out.println("Позитивные тесты" + "\n");
//        for (int i = 0; i < listSuit.size(); i++) {
//            Matcher matcher = pattern.matcher(listSuit.get(i));
//            if (matcher.matches()) {
//                System.out.println("Выражение:" + "\n" + listSuit.get(i) + "\n" + "соответствует REGEX" + "\n");
//            } else {
//                System.out.println("Выражение:" + "\n" + listSuit.get(i) + "\n" + "НЕ соответствует REGEX" + "\n");
//            }
//        }
//
//        System.out.println("Негативные тесты" + "\n");
//        for (int i = 0; i < listNotSuit.size(); i++) {
//            Matcher matcher = pattern.matcher(listNotSuit.get(i));
//            if (matcher.matches()) {
//                System.out.println("Выражение:" + "\n" + listNotSuit.get(i) + "\n" + "соответствует REGEX" + "\n");
//            } else {
//                System.out.println("Выражение:" + "\n" + listNotSuit.get(i) + "\n" + "НЕ соответствует REGEX" + "\n");
//            }
//        }
//
//
//// Task 4 - END
//
//
// Task 5 - START
// 5. На странице википедии есть таблица со сроками правления американских президентов.
// https://ru.wikipedia.org/wiki/%D0%A1%D0%BF%D0%B8%D1%81%D0%BE%D0%BA_%D0%BF%D1%80%D0%B5%D0%B7%D0%B8%D0%B4%D0%B5%D0%BD%D1%82%D0%BE%D0%B2_%D0%A1%D0%A8%D0%90
// Нужно создать файл (вручную) с 10-ю президентами из этого списка. Файл должен включать столбцы: Президент, Начало срока, Конец срока, Партийная принадлежность.
// Для считывания и записи файлов использовать библиотеку nio.
// Если пользователь вводит с консоли дату в неверном формате (не в формате dd.mm.yyyy), программа должна сгенерировать исключение DateInvalidFormat.
// Данный класс исключения нужно предварительно создать вручную.
//
// В программе составить консольное меню:
// 1. Вывести имена президентов и сроки их правления в порядке возрастания столбца "начало срока";
// 2. Вывести имена президентов и сроки их правления в обратном порядке;
// 3. Найти президента, который правил в определенную дату (с консоли вводится дата, программа ищет президента, в чей срок правления попадает эта дата);
// 4. Добавить нового президента (добавляются значения для всех столбцов);
// 5. Выход (при выборе файл обновляется, если были изменения).
//
//5-ю задачу разберем на занятии, а пока можно подготовить файл и его считывание через nio для этой задачи.

        Path path = Paths.get("src/ru/study/homework/inputoutput/Presidents.csv");
        List<String> listInput = new ArrayList<>(Files.readAllLines(path)); // listInput - список со всеми входными данными

        ArrayList<String> column = new ArrayList<>(); // column - список с названиями столбцов
        String [] columnTemp = listInput.get(0).split(";");
        for (int i = 0; i < columnTemp.length; i++) {
            column.add(columnTemp[i]);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        ArrayList<PresidentsInfo> list = new ArrayList<>(); // list - список с объектами Data (данные без названия столбцов и без номеров строк)

        ArrayList<Integer> number = new ArrayList<>(); // number - список с номерами строк
        for (int i = 1; i < listInput.size(); i++) {
            String [] line = listInput.get(i).split(";");
            number.add(Integer.parseInt(line[0]));
            Date dateStart = sdf.parse(line[2]);
            Date dateEnd = sdf.parse(line[3]);
            PresidentsInfo president = new PresidentsInfo(line[1], dateStart, dateEnd, line[4]);
            list.add(president);
        }

        Scanner scn = new Scanner(System.in);
        String input = "";
        System.out.println("Выберите пункт меню:");
        while(!input.equals("6")){
            System.out.println("1. Вывести содержимое исходных данных.");
            System.out.println("2. Вывести имена президентов и сроки их правления в порядке возрастания столбца \"начало срока\".");
            System.out.println("3. Вывести имена президентов и сроки их правления в порядке убывания столбца \"начало срока\".");
            System.out.println("4. Найти президента, который правил в определенную дату.");
            System.out.println("5. Добавить нового президента (добавляются значения для всех столбцов).");
            System.out.println("6. Выход (при выборе файл обновляется, если были изменения).");
            input = scn.nextLine();

            if (input.equals("1")) {
                System.out.println();
                for (int i = 0; i < column.size(); i++) {
                    System.out.print(column.get(i)  + "  ");
                }
                System.out.println();

                PresidentsInfo pr = new PresidentsInfo();
                for(int i = 0; i < list.size(); i++){
                    pr = list.get(i);
                    sdf = new SimpleDateFormat("dd.MM.yyyy");
                    String dateFormatStart = sdf.format(pr.getStart());
                    String dateFormatEnd = sdf.format(pr.getEnd());
                    System.out.println(number.get(i) + "  " + pr.getName() + "  " + dateFormatStart + "  " + dateFormatEnd + "  " + pr.getParty());
                }
                System.out.println();

            }
            else if (input.equals("2")){

                Comparator<PresidentsInfo> com1 = new Comparator<PresidentsInfo>() {
                    @Override
                    public int compare(PresidentsInfo o1, PresidentsInfo o2) {
                        return o1.getStart().compareTo(o2.getStart());
                    }
                };
                Collections.sort(list, com1);
//                for(int i = 0; i < list.size(); i++){
//                    PresidentsInfo prMin = list.get(i);
//                    int indexMin = i;
//                    for(int j = i; j < list.size(); j++){
//                        PresidentsInfo prCurrent = list.get(j);
//                        int result = prMin.getStart().compareTo(prCurrent.getStart());
//                        if(result > 0){
//                            prMin = prCurrent;
//                            indexMin = j;
//                        }
//                    }
//                    PresidentsInfo temp = list.get(i);
//                    list.set(i, prMin);
//                    list.set(indexMin, temp);
//                }

                System.out.println();
                for (int i = 0; i < column.size(); i++) {
                    System.out.print(column.get(i) + "  ");
                }
                System.out.println();

                PresidentsInfo pr = new PresidentsInfo();
                for(int i = 0; i < list.size(); i++){
                    pr = list.get(i);
                    sdf = new SimpleDateFormat("dd.MM.yyyy");
                    String dateFormatStart = sdf.format(pr.getStart());
                    String dateFormatEnd = sdf.format(pr.getEnd());
                    System.out.println(i + "  " + pr.getName() + "  " + dateFormatStart + "  " + dateFormatEnd + "  " + pr.getParty());
                }
                System.out.println();

            }
            else if(input.equals("3")){

                Comparator<PresidentsInfo> com1 = new Comparator<PresidentsInfo>() {
                    @Override
                    public int compare(PresidentsInfo o1, PresidentsInfo o2) {
                        return o2.getStart().compareTo(o1.getStart());
                    }
                };
                Collections.sort(list, com1);


                for(int i = 0; i < list.size(); i++){
                    PresidentsInfo prMin = list.get(i);
                    int indexMin = i;
                    for(int j = i; j < list.size(); j++){
                        PresidentsInfo prCurrent = list.get(j);
                        int result = prMin.getStart().compareTo(prCurrent.getStart());
                        if(result < 0){
                            prMin = prCurrent;
                            indexMin = j;
                        }
                    }
                    PresidentsInfo temp = list.get(i);
                    list.set(i, prMin);
                    list.set(indexMin, temp);
                }

                System.out.println();
                for (int i = 0; i < column.size(); i++) {
                    System.out.print(column.get(i) + "  ");
                }
                System.out.println();

                PresidentsInfo pr = new PresidentsInfo();
                int j = list.size() - 1;
                for(int i = 0; i < list.size(); i++){
                    pr = list.get(i);
                    sdf = new SimpleDateFormat("dd.MM.yyyy");
                    String dateFormatStart = sdf.format(pr.getStart());
                    String dateFormatEnd = sdf.format(pr.getEnd());
                    System.out.println(j + "  " + pr.getName() + "  " + dateFormatStart + "  " + dateFormatEnd + "  " + pr.getParty());
                    j--;
                }
                System.out.println();

            }
            else if(input.equals("4")){
                System.out.println("Введите дату в формате \"дд.мм.гггг\", в диапазоне от 30.04.1789 до 04.03.1845");
                String inputDate = scn.nextLine();
                sdf = new SimpleDateFormat("dd.MM.yyyy");
                Date dateinput = sdf.parse(inputDate);
                PresidentsInfo pr = new PresidentsInfo();
                for (int i = 0; i < list.size(); i++) {
                    pr = list.get(i);
                    int resultStart = dateinput.compareTo(pr.getStart());
                    int resultEnd = dateinput.compareTo(pr.getEnd());
                    if (resultStart == 1 && resultEnd == -1){
                        sdf = new SimpleDateFormat("dd.MM.yyyy");
                        String dateFormatInput = sdf.format(dateinput);
                        String dateFormatStart = sdf.format(pr.getStart());
                        String dateFormatEnd = sdf.format(pr.getEnd());
                        System.out.println("В дату = " + dateFormatInput + " Президентом США был " + pr.getName() + "  " + dateFormatStart + "  " + dateFormatEnd);
                    }
                }
                System.out.println();

            }
            else if(input.equals("5")){
                int newNumber = number.size() + 1;
                number.add(newNumber);

                System.out.println("Добавление информации о новом Президенте.");
                System.out.println("1. Введите Имя, Фамилию Президета.");
                String inputName = scn.nextLine();
                System.out.println("2. Введите дату избрания в формате \"дд.мм.гггг\".");
                String inputDateStart = scn.nextLine();
                System.out.println("3. Введите дату окончания деятельности на посту в формате \"дд.мм.гггг\".");
                String inputDateEnd = scn.nextLine();
                sdf = new SimpleDateFormat("dd.MM.yyyy");
                Date dateStart = sdf.parse(inputDateStart);
                Date dateEnd = sdf.parse(inputDateEnd);
                System.out.println("4. Введите партийную принадлежность.");
                String inputParty = scn.nextLine();
                PresidentsInfo president = new PresidentsInfo(inputName, dateStart, dateEnd, inputParty);
                list.add(president);

                System.out.println("\n" + "Новый Президент успешно добавлен.");
                System.out.println("Для корректного отображения списка выполните п.2 или п.3 консольного меню." + "\n");

            }
            else if(input.equals("6")){
                System.out.println("Программа завершила свою работу.");
                path = Paths.get("src/ru/study/homework/inputoutput/PresidentsOutput.csv");
                BufferedWriter bw = Files.newBufferedWriter(path, StandardOpenOption.CREATE);

                for (int i = 0; i < column.size(); i++) {
                    if(i != (column.size() - 1)){
                        bw.write(column.get(i));
                        bw.write(";");
                    }else {
                        bw.write(column.get(i));
                        bw.write("\n");
                    }
                }

                PresidentsInfo pr = new PresidentsInfo();
                for(int i = 0; i < list.size(); i++){
                    pr = list.get(i);
                    sdf = new SimpleDateFormat("dd.MM.yyyy");
                    String dateFormatStart = sdf.format(pr.getStart());
                    String dateFormatEnd = sdf.format(pr.getEnd());
                    bw.write(i);
                    bw.write(";");
                    bw.write(pr.getName());
                    bw.write(";");
                    bw.write(dateFormatStart);
                    bw.write(";");
                    bw.write(dateFormatEnd);
                    bw.write(";");
                    bw.write(pr.getParty());
                    bw.write("\n");
                }
                bw.close();
                break;

            }else {
                System.out.println("Некорректный ввод.");

            }
        }
    }
}


