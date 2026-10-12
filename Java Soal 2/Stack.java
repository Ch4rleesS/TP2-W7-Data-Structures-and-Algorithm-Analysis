// Class Stack (LIFO): riwayat transaksi, yang terbaru di atas
public class Stack {
    private Node top;
    private int size;

    public boolean isEmpty() { return top == null; }

    // Push: simpan transaksi di puncak stack
    public void push(Node data) {
        Node baru = new Node(data.kode, data.nama, data.total);
        baru.next = top;
        top = baru;
        size++;
    }

    // Tampilkan riwayat dari terbaru ke terlama
    public void display() {
        if (top == null) {
            System.out.println("Belum ada riwayat transaksi.");
            return;
        }
        System.out.println("Riwayat Transaksi (terbaru -> lama):");
        int no = 1;
        for (Node b = top; b != null; b = b.next) {
            System.out.println(no++ + ". " + b.kode + " | " + b.nama + " | Rp" + b.total);
        }
        System.out.println("Total transaksi: " + size);
    }
}