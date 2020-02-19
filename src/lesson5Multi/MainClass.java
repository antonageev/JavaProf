package lesson5Multi;

import java.util.concurrent.CountDownLatch;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {

        new Race(new Road(60), new Tunnel(), new Road(40));

    }
}

