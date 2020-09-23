//package ru.study.homework.pattern.task1;
//
//import java.util.List;
//import java.util.concurrent.Callable;
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class WorkerSingle implements Callable<Integer> {
//    private AtomicInteger atomicInteger;
//    private List<String> listSingle;
//    private List<Integer> listResult;
//
//    public WorkerSingle(AtomicInteger atomicInteger, List<String> listSingle, List<Integer> listResult){
//        this.atomicInteger = atomicInteger;
//        this.listSingle = listSingle;
//        this.listResult = listResult;
//    }
//
//
//    @Override
//    public List<Integer> call() throws Exception{
//        int sum = 0;
//        int i = 0;
//
//        //while (atomicInteger.get() > 0){
//            Thread.sleep(100);
//            synchronized (atomicInteger){
//                if(atomicInteger.get() > 0){
//                    Thread.currentThread().setName("поток " + sum);
//                    System.out.println(Thread.currentThread().getName());
//                    System.out.println("Рабочий " + listSingle.get(i) + " выполняет заказ ");
//                    sum = sum + 1;
//                    atomicInteger.decrementAndGet();
//                    int temp = listResult.get(i) + 1;
//                    listResult.add(temp);
//                    i = i + 1;
//                    if(i == listSingle.size()){
//                        i = 0;
//                    }
//                }
//            }
//
//        }
//
//        return listResult;
//    }
//
//}
