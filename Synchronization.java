[11:40 am, 20/03/2024] Lilli💫: import java.io.*;

class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String contactNo;
    private String address;

    public Customer(int id, String name, String contactNo, String address) {
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        Customer customer = new Customer(1, "John Doe", "1234567890", "123 Main St");

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("JavaObject.txt"))) {
            outputStream.writeObject(customer);
            System.out.println("Customer object serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
[11:48 am, 20/03/2024] Lilli💫: class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized void decrement() {
        count--;
    }

    public synchronized int getCount() {
        return count;
    }
}

class IncrementThread extends Thread {
    private Counter counter;

    public IncrementThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

class DecrementThread extends Thread {
    private Counter counter;

    public DecrementThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.decrement();
        }
    }
}

public class SynchronizationExample {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        IncrementThread incrementThread = new IncrementThread(counter);
        DecrementThread decrementThread = new DecrementThread(counter);

        incrementThread.start();
        decrementThread.start();

        incrementThread.join();
        decrementThread.join();

        System.out.println("Final count: " + counter.getCount());
    }
}