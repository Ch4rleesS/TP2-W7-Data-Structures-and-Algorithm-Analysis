// Class Node: satu elemen (simpul) pada Single Linked List
public class Node {
    String kodeBuku;
    String judul;
    String penulis;
    Node next; // penunjuk ke node berikutnya

    public Node(String kodeBuku, String judul, String penulis) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.next = null;
    }
}