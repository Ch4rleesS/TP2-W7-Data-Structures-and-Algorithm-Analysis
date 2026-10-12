// Class LinkedList: Single Linked List untuk data buku perpustakaan
public class LinkedList {
    private Node head; // node pertama
    private int size;  // jumlah data

    public LinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    // Push: tambah buku baru di AKHIR daftar
    public void push(String kode, String judul, String penulis) {
        Node baru = new Node(kode, judul, penulis);
        if (head == null) {
            head = baru;                 // daftar kosong -> node baru jadi head
        } else {
            Node bantu = head;
            while (bantu.next != null) { // telusuri sampai node terakhir
                bantu = bantu.next;
            }
            bantu.next = baru;           // sambungkan di akhir
        }
        size++;
    }

    // Pop: hapus buku TERAKHIR, return false jika daftar kosong
    public boolean pop() {
        if (head == null) {
            return false;
        }
        if (head.next == null) {         // hanya satu data
            head = null;
        } else {
            Node bantu = head;
            while (bantu.next.next != null) { // berhenti di node sebelum terakhir
                bantu = bantu.next;
            }
            bantu.next = null;           // putuskan node terakhir
        }
        size--;
        return true;
    }

    // Cari buku berdasarkan kode, return null jika tidak ada
    public Node cari(String kode) {
        Node bantu = head;
        while (bantu != null) {
            if (bantu.kodeBuku.equalsIgnoreCase(kode)) {
                return bantu;
            }
            bantu = bantu.next;
        }
        return null;
    }

    // Tampilkan semua buku sesuai urutan input + total buku
    public void tampil() {
        if (head == null) {
            System.out.println("Daftar buku masih kosong.");
        } else {
            System.out.println("Daftar Buku:");
            Node bantu = head;
            while (bantu != null) {
                System.out.println("Kode: " + bantu.kodeBuku + " | Judul: " + bantu.judul
                        + " | Penulis: " + bantu.penulis);
                bantu = bantu.next;
            }
        }
        System.out.println("Total Buku: " + size);
    }
}