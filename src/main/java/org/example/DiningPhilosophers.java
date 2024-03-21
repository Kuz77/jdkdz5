package org.example;

public class DiningPhilosophers {
    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[5];
        Fork[] forks = new Fork[5];

        for (int i = 0; i < 5; i++) {
            forks[i] = new Fork();
        }

        for (int i = 0; i < 5; i++) {
            philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % 5]);
            philosophers[i].start();
        }

        try {
            for (Philosopher philosopher : philosophers) {
                philosopher.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Philosopher philosopher : philosophers) {
            System.out.println("Philosopher " + philosopher.getId() + " ate " + philosopher.getEatCount() + " times");
        }
    }
}
