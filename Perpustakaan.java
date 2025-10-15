import java.util.ArrayList;
class Perpustakaan{
private ArrayList<Buku> daftarBuku = new ArrayList<>();

    public void tambahBuku(Buku b) {
        daftarBuku.add(b);
    }

    public void tampilkanBuku() {
        System.out.println("\n=== Daftar Buku di Perpustakaan ===");
        for (Buku b : daftarBuku) {
            System.out.println("Judul   : " + b.getJudul());
            System.out.println("Penulis : " + b.getPenulis());
            System.out.println("Kategori: " + b.getKategori());
            System.out.println("Stok    : " + b.getStok());
            System.out.println("-----------------------------------");
        }
    }

    public void rekomendasiBuku(String kategori) {
        System.out.println("\n=== Rekomendasi Buku untuk Kategori: " + kategori + " ===");
        boolean ada = false;
        for (Buku b : daftarBuku) {
            if (b.getKategori().equalsIgnoreCase(kategori)) {
                System.out.println("- " + b.getJudul() + " oleh " + b.getPenulis());
                ada = true;
            }
        }
        if (!ada) {
            System.out.println("Tidak ada buku dalam kategori tersebut.");
        }
    }

    public void kurangiStok(String judul) {
        for (Buku b : daftarBuku) {
            if (b.getJudul().equalsIgnoreCase(judul)) {
                if (b.getStok() > 0) {
                    b.setStok(b.getStok() - 1);
                    System.out.println("Buku \"" + b.getJudul() + "\" telah dipinjam. Sisa stok: " + b.getStok());
                } else {
                    System.out.println("Maaf, stok buku \"" + b.getJudul() + "\" habis.");
                }
                return;
            }
        }
        System.out.println("Buku dengan judul \"" + judul + "\" tidak ditemukan.");
    }
}