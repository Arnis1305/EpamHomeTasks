package threads;

import java.util.concurrent.Semaphore;

public class Parking extends Thread {
    private Semaphore semaphore;
    private String carName;
    private int waitTime;
    private int parkingTime;
    private boolean busyParking = false;

    Parking(Semaphore semaphore, String carName, int waitTime, int parkingTime) {
        this.semaphore = semaphore;
        this.carName = carName;
        this.waitTime = waitTime;
        this.parkingTime = parkingTime;
    }

    @Override
    public void run(){
        try {
            if (!busyParking) {
                if (semaphore.availablePermits() == 0 && waitTime > 10) {
                    sleep(10000);
                    interrupt();
                }
                semaphore.acquire();
                System.out.println(carName + " enter parking. ");
                sleep(parkingTime * 1000);
                busyParking = true;
                System.out.println(carName + " leaving parking. Parked for: " + parkingTime + " minutes. Waiting time: " + waitTime);
                semaphore.release();
            }
        } catch (InterruptedException e) {
            System.out.println(carName + " can't wait more! Waiting time: " + waitTime);
        }
    }
}