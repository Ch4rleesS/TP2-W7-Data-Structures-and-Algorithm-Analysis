import java.util.Scanner;

// Program sistem kasir toko menggunakan Queue dan Stack
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue antrian = new Queue();
        Stack riwayat = new Stack();
        int pilih = 0;

        do {
            System.out.println("\n=== SISTEM KASIR TOKO ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Riwayat Transaksi");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            try {
                pilih = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                pilih = 0;
            }

            switch (pilih) {
                case 1: // Enqueue
                    if (antrian.isFull()) { // validasi jumlah data <= 5
                        System.out.println("Antrian penuh (maksimal " + Queue.MAKS + " pelanggan)!");
                        break;
                    }
                    System.out.print("Masukkan Nomor Antrian: ");
                    String kode = sc.nextLine().trim();
                    if (kode.isEmpty() || antrian.ada(kode)) {
                        System.out.println("Nomor antrian kosong atau sudah ada!");
                        break;
                    }
                    System.out.print("Masukkan Nama Pelanggan: ");
                    String nama = sc.nextLine().trim();
                    System.out.print("Masukkan Total Belanja: ");
                    try {
                        int total = Integer.parseInt(sc.nextLine().trim());
                        if (total < 0) throw new NumberFormatException();
                        antrian.enqueue(kode, nama, total);
                        System.out.println("Data pelanggan ditambahkan ke antrian!");
                    } catch (NumberFormatException e) {
                        System.out.println("Total belanja harus berupa angka positif!");
                    }
                    break;
                case 2: // Dequeue + push ke stack
                    Node dilayani = antrian.dequeue();
                    if (dilayani == null) {
                        System.out.println("Tidak ada pelanggan dalam antrian.");
                    } else {
                        System.out.println("Melayani pelanggan " + dilayani.kode + " (" + dilayani.nama + ")");
                        riwayat.push(dilayani);
                        System.out.println("Transaksi disimpan ke riwayat.");
                    }
                    break;
                case 3:
                    antrian.display();
                    break;
                case 4:
                    riwayat.display();
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