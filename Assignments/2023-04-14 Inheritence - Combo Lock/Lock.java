public class Lock {
    // Instance Variable
    private boolean locked;

    // Default Constructor
    public Lock() {
        locked = true; // lock starts in a closed state
    }

    // Mutator Methods
    public void open() {
        locked = false;
    }

    public void close() {
        locked = true;
    }

    // Accessor Method
    public boolean amILocked() {
        return locked;
    }

    // toString Method
    public String toString() {
        if (locked == false)
            return "Lock is open";
        else
            return "Lock is closed";
    }
}