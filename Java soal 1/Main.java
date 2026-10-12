import java.util.Scanner;

// Program pengelolaan daftar buku perpustakaan (Single Linked List)
public class Main {
    static final int MIN_BUKU = 5;   // jumlah minimal data buku
    static final int MAX_KODE = 5;   // panjang maksimal kodeBuku

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList daftar = new LinkedList();
        int pilih = 0;

        do {
            System.out.println("\n===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            try {
                pilih = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                pilih = 0; // input bukan angka -> menu tidak valid
            }

            switch (pilih) {
                case 1: // Tambah buku
                    System.out.print("Masukkan Kode Buku: ");
                    String kode = sc.nextLine().trim();
                    // Validasi: tidak kosong, maksimal 5 karakter, tidak boleh kembar
                    if (kode.isEmpty() || kode.length() > MAX_KODE) {
                        System.out.println("Kode buku harus 1-" + MAX_KODE + " karakter!");
                    } else if (daftar.cari(kode) != null) {
                        System.out.println("Kode buku sudah digunakan!");
                    } else {
                        System.out.print("Masukkan Judul: ");
                        String judul = sc.nextLine().trim();
                        System.out.print("Masukkan Penulis: ");
                        String penulis = sc.nextLine().trim();
                        daftar.push(kode, judul, penulis);
                        System.out.println("Data berhasil ditambahkan!");
                    }
                    break;
                case 2: // Hapus buku terakhir
                    if (daftar.pop()) {
                        System.out.println("Buku terakhir berhasil dihapus.");
                    } else {
                        System.out.println("Tidak ada data untuk dihapus.");
                    }
                    break;
                case 3: // Cari buku
                    System.out.print("Masukkan Kode Buku yang dicari: ");
                    Node hasil = daftar.cari(sc.nextLine().trim());
                    if (hasil != null) {
                        System.out.println("Buku ditemukan!");
                        System.out.println("Kode: " + hasil.kodeBuku + " | Judul: " + hasil.judul
                                + " | Penulis: " + hasil.penulis);
                    } else {
                        System.out.println("Buku tidak ditemukan.");
                    }
                    break;
                case 4: // Tampilkan semua
                    daftar.tampil();
                    if (daftar.getSize() < MIN_BUKU) {
                        System.out.println("(Catatan: data minimal " + MIN_BUKU + " buku)");
                    }
                    break;
                case 5:
                    System.out.println("Terima kasih, program selesai.");
                    break;
                default:
                    System.out.println("Menu tidak valid!");
            }
        } while (pilih != 5);

        sc.close();
    }
}