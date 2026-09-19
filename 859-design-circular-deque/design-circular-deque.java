class MyCircularDeque {

    int[] q;
    int front;
    int rear;
    int size;
    int capacity;

    public MyCircularDeque(int k) {
        q = new int[k];
        capacity = k;
        front = 0;
        rear = 0;
        size = 0;
    }

    public boolean insertFront(int value) {

        if (size == capacity)
            return false;

        front = (front - 1 + capacity) % capacity;
        q[front] = value;

        size++;
        return true;
    }

    public boolean insertLast(int value) {
        
        if(size == capacity) return false;

        q[rear] = value;
        rear = (rear + 1)%capacity;

        size++;
        return true;
    }

    public boolean deleteFront() {

        if (size == 0)
            return false;

        front = (front + 1) % capacity;

        size--;
        return true;
    }

    public boolean deleteLast() {

        if (size == 0)
            return false;

        rear = (rear - 1 + capacity) % capacity;

        size--;
        return true;
    }

    public int getFront() {

        if (size == 0)
            return -1;

        return q[front];
    }

    public int getRear() {
        if (size == 0)
            return -1;

        return q[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {

        return size == 0;

    }

    public boolean isFull() {
        
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */