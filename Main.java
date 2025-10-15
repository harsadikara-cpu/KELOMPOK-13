import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // a. Input beberapa buku menggunakan array
        System.out.print("Masukkan jumlah buku: ");
        int jumlah = input.nextInt();
        input.nextLine(); // membersihkan buffer

        Buku[] daftarBuku = new Buku[jumlah];

        for (int i = 0; i < jumlah; i++) {
            System.out.println("\nData Buku ke-" + (i + 1));
            System.out.print("Judul    : ");
            String judul = input.nextLine();
            System.out.print("Penulis  : ");
            String penulis = input.nextLine();
            System.out.print("Kategori : ");
            String kategori = input.nextLine();
            System.out.print("Stok     : ");
            int stok = input.nextInt();
            input.nextLine(); // clear buffer

            daftarBuku[i] = new Buku(judul, penulis, kategori, stok);
        }

        // b. Input kategori favorit pengguna
        System.out.print("\nMasukkan kategori favorit Anda: ");
        String kategoriFavorit = input.nextLine();

        // c. Tampilkan rekomendasi buku sesuai kategori
        boolean ditemukan = false;
        System.out.println("\n=== Rekomendasi Buku Kategori: " + kategoriFavorit + " ===");
        for (int i = 0; i < daftarBuku.length; i++) {
            if (daftarBuku[i].getKategori().equalsIgnoreCase(kategoriFavorit)) {
                System.out.println("Judul    : " + daftarBuku[i].getJudul());
                System.out.println("Penulis  : " + daftarBuku[i].getPenulis());
                System.out.println("Stok     : " + daftarBuku[i].getStok());
                System.out.println("-------------------------");
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada buku dengan kategori tersebut.");
        }

        input.close();
    }
}
