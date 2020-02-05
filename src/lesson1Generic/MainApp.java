package lesson1Generic;

import java.util.ArrayList;
import java.util.Arrays;

public class MainApp {

    public static void main(String[] args) {
        //Задание №1
        String[] strArray = new String[]{"one", "two", "three"};
        Integer[] intArray = new Integer[]{1,2,3,4,5};

        changeTwoItems(strArray,0,2);
        changeTwoItems(intArray, 2,4);

        System.out.println(Arrays.asList(strArray));
        System.out.println(Arrays.asList(intArray));

        //Задание №2
        System.out.println(arrayAsList(new Integer[]{5,60,40,30,110}));

        //Задание №3
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();

        Box<Apple> appleBox= new Box<>();
        Box<Orange> orangeBox = new Box<>();

        appleBox.addFruit(apple1);
        appleBox.addFruit(apple2);
        appleBox.addFruit(apple3);

        orangeBox.addFruit(orange1);
        orangeBox.addFruit(orange2);

        System.out.println("коробки с 3 яблоками и 2 апельсинами равны? :" + orangeBox.compare(appleBox));

        Box<Orange> orangeBox2 = new Box<>();
        orangeBox2.addFruit(new Orange());
        System.out.println("orangeBox weight = " + orangeBox.getWeight());
        System.out.println("orangeBox2 weight = " + orangeBox2.getWeight());
        orangeBox.moveFruitsTo(orangeBox2);
        orangeBox2.clearBox();
        orangeBox.moveFruitsTo(orangeBox2);
        System.out.println("После пересыпания апельсинов:");
        System.out.println("orangeBox weight = " + orangeBox.getWeight());
        System.out.println("orangeBox2 weight = " + orangeBox2.getWeight());


    }

    public static <T> T[] changeTwoItems (T[] inputArr, int index1, int index2){
        if (index1 > inputArr.length-1 || index2 > inputArr.length-1){
            System.out.println("один из индексов больше длины массива");
            return inputArr;
        }
        T buffer;
        buffer = inputArr[index1];
        inputArr[index1] = inputArr[index2];
        inputArr[index2] = buffer;
        return inputArr;
    }

    public static <T> ArrayList<T> arrayAsList(T[] inputArr){
        ArrayList<T> arrayList = new ArrayList<T>();
        for (T t : inputArr){
            arrayList.add(t);
        }
        return arrayList;
    }

}
