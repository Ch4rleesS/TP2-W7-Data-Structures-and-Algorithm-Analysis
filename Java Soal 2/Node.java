// Class Node: menyimpan data satu pelanggan/transaksi
public class Node {
    String kode;   // nomor antrian
    String nama;   // nama pelanggan
    int total;     // total belanja
    Node next;

    public Node(String kode, String nama, int total) {
        this.kode = kode;
        this.nama = nama;
        this.total = total;
        this.next = null;
    }
}