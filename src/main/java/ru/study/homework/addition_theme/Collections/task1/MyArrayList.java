package ru.study.homework.addition_theme.Collections.task1;

public class MyArrayList
{
    private String [] arr = new String[10];
    private int currentIndex;

    public int size(){
        return currentIndex;
    }
    public void add(String val){
        if(currentIndex>=arr.length){
            String[] newArr = new String[size()*3/2];
            System.arraycopy(arr, 0, newArr, 0, size());
            arr = newArr;
        }
        arr[currentIndex++] = val;
    }

    public String get(int index){
        return arr[index];
    }

    public boolean contains(String val){
        return indexOf(val)!=-1;
    }

    public int indexOf(String val){
        for (int i = 0; i < size(); i++) {
            if(arr[i].equals(val)){
                return i;
            }
        }
        return -1;
    }

    public boolean remove(int index){
        if(index>=0 && index < size()){
            for (int i = index; i < size()-1; i++) {
                arr[i] = arr[i+1];
            }
            currentIndex--;
            return true;
        }
        return false;
    }

    public boolean remove(String val){
        return remove(indexOf(val));
    }

}
