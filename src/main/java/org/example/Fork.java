package org.example;


class Fork {
    private boolean inUse;

    public Fork() {
        this.inUse = false;
    }

    public synchronized boolean pickUp() {
        if (!inUse) {
            inUse = true;
            return true;
        }
        return false;
    }

    public synchronized void putDown() {
        inUse = false;
    }
}

