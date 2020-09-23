package ru.study.homework.atomic.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static String code = "";
    static boolean isFinish = false;

    public static void main(String[] args) {

//    TASK 2.
//    Создать систему авторизации с смс подтверждением.
//    На многих сайтах и сервисах существует двойная авторизация: по логину с паролем и кодом подтверждения. Когда пользователь вводит правильный логин и пароль
//    программа отправляет смс сообщение с кодом подтверждения. Пользователь должен ввести код до истечения обозначенного времени.
//    Делается это из соображения, что логином и паролем пользователя может завладеть злоумышленник и войти в систему.
//
//    Что нужно сделать:
//    Консольное меню:
//    1. Регистрация;
//    2. Вход в систему;
//    3. Выход.
//    При регистрации пользователь вводит логин, пароль. Также у пользователя есть выбор: он может ввести свой номер, а может оставить его пустым.
//    Если пользователь оставит номер пустым, проверка будет осуществляться только по логину и паролю.
//    При выборе пункта 2 пользователь вводит логин и пароль. Программа проверяет правильность данных. Если логин или пароль неправильный,
//    программа выводит текст "Неправильный логин или пароль" и возвращается в главное меню.
//    Если логин и пароль правильный, то:
//    1. Если пользователь не указал номер, программа не высылает сообщение;
//    2. Если пользователь указал номер телефона, программа имитирует отправку смс сообщения на его номер с кодом подтверждения.
//    Этот код пользователь должен ввести в течении 10 секунд. Программа должна выводить оставшееся время с интервалом в 2 секунды.
//    Если пользователь успел до истечения времени ввести правильный код, программа выводит текст приветствия.
//    Если время закончилось, тогда программа выводит текст о том, что нужно выполнить новую попытку авторизации и выходит в Главное меню.
//
//    Пример работы не успешного входа в систему:
//    1. Регистрация;
//    2. Авторизация;
//    3. Выход.
//
//    Выбор пункта меню:
//    2
//    Введите логин:
//    ivan
//    Введите пароль:
//    123
//    Вам было отправлено смс сообщение с кодом 4576
//    Введите код
//    Осталось 10 секунд
//    46
//    Введите код
//    Осталось 8 секунд
//    89879
//    Введите код
//    Осталось 6 секунд
//    4574
//    Осталось 4 секунд
//    Осталось 2 секунд
//    4
//    Осталось 0 секунд
//    sdf
//    Время вышло. Повторите попытку
//
//    Обратите внимание, что возможна ситуация, когда метод считывания с консоли начал работу, а время закончилась. Как раз это произошло в примере выше.
//    В этом случае, не смотря на окончание времени, программа будет ждать ввода текста и клавиши enter. Это менять не нужно.
//
//
//    Пример успешного входа
//    1. Регистрация
//    2. Авторизация
//    3. Выход
//
//    Выбор пункта меню:
//    2
//    Введите логин:
//    ivan
//    Введите пароль:
//    123
//    Вам было отправлено смс сообщение с кодом 4576.
//    Введите код:
//    Осталось 10 секунд
//    Осталось 8 секунд
//    4576
//    Добро пожаловать в систему, Иван!


        List<User> list = new ArrayList<>();
        Scanner scn = new Scanner(System.in);
        String input = "";
        while (!input.equals("3")){
            System.out.println("Выберите пункт меню:");
            System.out.println("1. Регистрация.");
            System.out.println("2. Авторизация.");
            System.out.println("3. Выход.");

            input = scn.nextLine();

            if (input.equals("1")){
                System.out.println("Регистрация нового пользователя:");
                System.out.println("1. Введите логин:");
                String login = scn.nextLine();
                System.out.println("2. Введите пароль:");
                String password = scn.nextLine();
                System.out.println("3. Введите контактный номер (необязательное поле):");
                String number = scn.nextLine();

                User user = new User(login, password, number);
                list.add(user);

            }
            else if (input.equals("2")){
                User temp = new User();
                System.out.println("Авторизация зарегистрированного пользователя.");
                System.out.println("1. Введите логин:");
                String login = scn.nextLine();
                for (int i = 0; i < list.size(); i++) {
                    temp = list.get(i);
                    if(login.equals(temp.getLogin())){
                        System.out.println("2. Введите пароль:");
                        String password = scn.nextLine();
                        if (password.equals(temp.getPassword())){
                            if(!temp.getNumber().equals("")){
                                GeneratingSMS tempSMS = new GeneratingSMS();
                                String sms = tempSMS.generate();
                                System.out.println("На номер " + temp.getNumber() + " выслано смс с кодом подтверждения." + sms);
                                System.out.println("Код подтверждения = " + sms);
                                System.out.println("Введите код из смс в течение 10 секунд." + "\n");

                                Runnable runnable1 = () ->{
                                    int count = 0;
                                    while(count <= 10 && !isFinish){
                                        int countDown = 10 - count;
                                        System.out.println("Осталось " + countDown + " секунд");
                                        count = count + 2;
                                        try{
                                            Thread.sleep(2000);
                                        }catch(InterruptedException e){
                                            e.printStackTrace();
                                        }
                                    }
                                };
                                Thread t = new Thread(runnable1);
                                t.start();
//                                Runnable runnable2 = () ->{
                                    System.out.println(Thread.currentThread().getName());
                                    System.out.println("Введите код:");
                                    code = scn.nextLine();
                                    while (!code.equals(sms) && t.isAlive()){
                                        System.out.println("Введите код:");
                                        code = scn.nextLine();
                                        System.out.println("вы ввели "+code);
                                    }
                                    isFinish = true;
//                                };
                                    if(code.equals(sms)){
                                        System.out.println("Вы успешно выполнили авторизацию!");
                                        System.out.println("Вход в систему выполнен!" + "\n");
                                    }
                                    else{
                                        System.out.println("Время истекло. Вход в систему не выполнен!" + "\n");
                                    }

                            }
                            else{
                                System.out.println("В связи с отсутствием контактного номера смс-подтверждение не используется.");
                                System.out.println("Вы авторизированы в системе!" + "\n");
                            }
                        }
                        else{
                            System.out.println("Некорректный пароль!");
                        }
                    } else{
                        System.out.println("Некорректный логин!");
                    }

                }

            }
            else if (input.equals("3")){
                System.out.println("Выход.");

            }
            else{
                System.out.println("Некорректный ввод.");

            }
        }





    }
}
