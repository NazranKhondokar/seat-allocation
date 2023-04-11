class Seat {

    int id;
    int capacity;
    int allocated;

    public Seat(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.allocated = 0;
    }

    public boolean isAvailable() {
        return allocated < capacity;
    }

    public void allocate() {
        allocated++;
    }
}