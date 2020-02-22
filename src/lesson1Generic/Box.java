package lesson1Generic;

import java.util.ArrayList;
import java.util.Collections;

public class Box <T extends Fruit> {
    ArrayList<T> fruitBoxList;

    public Box() {
        this.fruitBoxList = new ArrayList<>();
    }

    public void addFruit (T fruit){
        this.fruitBoxList.add(fruit);
    }

    public void clearBox(){
        fruitBoxList.clear();
        System.out.println("Коробка очищена, фрукты съедены");
    }

    public float getWeight(){
        if (fruitBoxList.size() == 0) return 0.0f;
        return fruitBoxList.size() * fruitBoxList.get(0).getFruitWeight();
    }

    public boolean compare (Box<? extends Fruit> anotherBox){
        return (Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001);
    }

    public void moveFruitsTo (Box<T> anotherBox){
        // Поставил проверку целевой коробки, чтобы Collections.copy работало. А оно не работает...
        if (this == anotherBox) return;
        if (anotherBox.getWeight()>0){
            System.out.println("необходимо освободить целевую коробку... Ну или убрать эту проверку на непустую коробку");
            return;
        }
        anotherBox.fruitBoxList.ensureCapacity(this.fruitBoxList.size());
        Collections.copy(anotherBox.fruitBoxList, this.fruitBoxList);
        // почему-то метод Collections.copy выбрасывает IndexOutOfBoundsException.
        // в описании метода написано, что такой Exception бросается, если не хватает размера dest.
        // а почему его не хватает, если я сделал ensureCapacity по коробке src ?
        // пришлось пересыпать фрукты циклом.

        //for (T o : this.fruitBoxList){
        //    anotherBox.fruitBoxList.add(o);
        //}
        this.fruitBoxList.clear();
    }

}
