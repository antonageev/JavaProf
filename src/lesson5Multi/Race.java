package lesson5Multi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class Race {
    private boolean winFlag = false;
    static CountDownLatch cdlRaceStart = new CountDownLatch(MainClass.CARS_COUNT);
    static CountDownLatch cdlRaceFinish = new CountDownLatch(MainClass.CARS_COUNT);
    private ArrayList<Stage> stages;
    public ArrayList<Stage> getStages() { return stages; }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
        raceStart();
    }

    public boolean getWinFlag() {
        return winFlag;
    }

    public void setWinFlag(boolean winFlag) {
        this.winFlag = winFlag;
    }

    public void raceStart(){
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Car[] cars = new Car[MainClass.CARS_COUNT];
        //Car.cdlReadyToStart = new CountDownLatch(MainClass.CARS_COUNT);
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(this, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        try {
            cdlRaceStart.await(); //почему бы не использовать один и тот же статический CountDownLatch в нескольких местах для синхронизации потоков...
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            cdlRaceFinish.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
