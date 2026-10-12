// Class Queue (FIFO): antrian pelanggan
public class Queue {
    private Node front; // depan antrian (yang dilayani duluan)
    private Node rear;  // belakang antrian (tempat pelanggan baru masuk)
    private int size;
    public static final int MAKS = 5; // batas jumlah antrian

    public int getSize() { return size; }
    public boolean isEmpty() { return front == null; }
    public boolean isFull() { return size >= MAKS; }

    // Enqueue: masukkan pelanggan di belakang antrian
    public void enqueue(String kode, String nama, int total) {
        Node baru = new Node(kode, nama, total);
        if (rear == null) {
            front = rear = baru;
        } else {
            rear.next = baru;
            rear = baru;
        }
        size++;
    }

    // Dequeue: keluarkan pelanggan paling depan, null jika kosong
    public Node dequeue() {
        if (front == null) return null;
        Node keluar = front;
        front = front.next;
        if (front == null) rear = null; // antrian jadi kosong
        keluar.next = null;
        size--;
        return keluar;
    }

    // Cek apakah nomor antrian sudah ada
    public boolean ada(String kode) {
        for (Node b = front; b != null; b = b.next) {
            if (b.kode.equalsIgnoreCase(kode)) return true;
        }
        return false;
    }

    // Tampilkan antrian dari depan ke belakang
    public void display() {
        if (front == null) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Antrian saat ini:");
        int no = 1;
        for (Node b = front; b != null; b = b.next) {
            System.out.println(no++ + ". " + b.kode + " | " + b.nama + " | Rp" + b.total);
        }
        System.out.println("Jumlah antrian: " + size);
    }
}