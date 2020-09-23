package ru.study.homework.differenttasks.task2;

public class Main {
    public static void main(String[] args) {

//    2. TASK 2
//    Написать метод compareTo таким образом, чтобы программа умела сортировать объекты по возрастанию оценки студента(rating)
//    и хранить студентов с одинаковыми оценками в множестве TreeSet.
//    Вставить в код класс, описывающий студента с полями фамилия и оценка.
//
//    class Student implements Comparable<Student>{
//        String surname;
//        int mark;
//
//        public Student(String surname, int mark) {
//            this.surname = surname;
//            this.mark = mark;
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            Student st = (Student)obj;
//            return st.surname.equals(surname) && mark ==st.mark;
//        }
//
//        @Override
//        public int hashCode() {
//            int f = surname.charAt(0);
//            int k = surname.charAt(surname.length()-1);
//            return f+k;
//        }
//
//        public int compareTo(Student o) {
//        //нужно изменить реализацию метода
//           return mark - o.mark;
//        }
//    }
//
//    Реализацию метода equals и hashCode менять нельзя.
//    На данный момент метод equals умеет определять одинаковые объекты класса Student, метод hashCode возвращает хэш код объекта
//    на основе суммы кодов первого и последнего символа, а метод compareTo упорядочивает объекты по возрастанию оценки.
//    Казалось бы, что все уже сделано, но в реализации метода compareTo есть недостатки.
//    При добавлении в TreeSet следующих объектов программа добавляет только первый из них, а второй принимает за дубликат.
//
//    TreeSet<Student> tree = new TreeSet<Student>();
//    Student st = new Student("Ivan", 5);
//    Student st2 = new Student("Iva1n", 5);
//    tree.add(st);
//    tree.add(st2);
//    System.out.println("Сравнение: "+st.equals(st2));
//    System.out.println("hash code: "+st.hashCode());
//    System.out.println("hash code: "+st2.hashCode());
//    System.out.println("Список студентов:");
//    for(Student val : tree){
//        System.out.println(val.surname +" "+val.mark);
//    }
//
//    Вывод программы:
//    Сравнение: false
//    hash code: 183
//    hash code: 183
//    Список студентов:
//    Ivan 5
//
//    Но фамилия студента st2 отличается от фамилии студента st, следовательно, эти объекты не являются дубликатами.
//    Не смотря на наличие equals и hashCode программа смотрит только на то, что compareTo возвращает число 0.
//    Нужно исправить реализацию метода compareTo таким образом, чтобы tree умел сохранять все уникальные значения и сортировал их в порядке возрастания оценки.
//    К примеру, следующий код
//
//    TreeSet<Student> tree = new TreeSet<Student>();
//    Student st = new Student("Ivan", 5);
//    Student st2 = new Student("Iva1n", 5);
//    Student st3 = new Student("Iva2n", 4);
//    tree.add(st);
//    tree.add(st2);
//    tree.add(st3);
//    System.out.println("Сравнение: "+st.equals(st2));
//    System.out.println("hash code: "+st.hashCode());
//    System.out.println("hash code: "+st2.hashCode());
//    System.out.println("Список студентов:");
//    for(Student val : tree){
//        System.out.println(val.surname +" "+val.mark);
//    }
//
//    Должен вывести:
//    Сравнение: false
//    hash code: 183
//    hash code: 183
//    Список студентов:
//    Iva2n 4
//    Iva1n 5
//    Ivan 5
//
//    (порядок студентов с одинаковой оценкой может отличаться от примера)





    }
}
