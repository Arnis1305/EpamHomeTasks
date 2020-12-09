package threads;

import java.util.concurrent.Semaphore;

public class ParkingMain {
    public static void main(String[] args) {
        Semaphore parkingSemaphore = new Semaphore(3);
        new Parking(parkingSemaphore, "Mercedes s500", (int) (Math.random()*20), (int) (Math.random()*20)).start();
        new Parking(parkingSemaphore, "Kia Soul Ev", (int) (Math.random()*20), (int) (Math.random()*20)).start();
        new Parking(parkingSemaphore, "Porsche Taycan", (int) (Math.random()*20), (int) (Math.random()*20)).start();
        new Parking(parkingSemaphore, "Toyota Camry", (int) (Math.random()*20), (int) (Math.random()*20)).start();
        new Parking(parkingSemaphore, "Honda Accord", (int) (Math.random()*20), (int) (Math.random()*20)).start();
    }
}