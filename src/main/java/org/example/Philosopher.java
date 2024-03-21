package org.example;



class Philosopher extends Thread {
    private int id;
    private Fork leftFork;
    private Fork rightFork;
    private int eatCount;

    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.eatCount = 0;
    }

    public void eat() {
        synchronized (leftFork) {
            synchronized (rightFork) {
                System.out.println("Philosopher " + id + " is eating");
                eatCount++;
            }
        }
    }

    public void think() {
        System.out.println("Philosopher " + id + " is thinking");
    }

    public int getEatCount() {
        return eatCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            think();
            eat();
        }
    }
}
