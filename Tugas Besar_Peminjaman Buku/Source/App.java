package Source;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import Source.Algorithm.Langkah;

public class App {

    public static void main(String[] args) throws Exception {

        try (Scanner input = new Scanner(System.in)) {
            Langkah library = new Langkah();
            library.setUp();
            boolean keluar = false;
            do {
                System.out.println("");
                System.out.println("=============== Perpustakaan ===============");
                System.out.print("Pilih Peran Perpustakaan Anda, \n1. Admin 2. Mahasiswa 3. Batal: ");
                String peran = input.next();
                switch (peran) {
                    case "1":
                        System.out.println("Jika anda adalah admin, masukkan akun admin anda!");
                        library.adminPerpusLogin();

                        boolean lanjut = true;
                        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                        while (lanjut) {
                            tampilkanMenuAdmin();
                            System.out.print("Pilih menu : ");
                            String pilihan = reader.readLine();
                            switch (pilihan) {
                                case "1":
                                    library.lihatDaftarbuku();
                                    break;
                                case "2":
                                    library.tambahBuku();
                                    break;
                                case "3":
                                    library.hapusBuku();
                                    break;
                                case "4":
                                    library.pengembalidanDanDenda();
                                    break;
                                case "5":
                                    library.tampilkanLaporanPengembalian();
                                    break;
                                case "6":
                                    lanjut = false;
                                    break;
                                default:
                                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
                                    break;
                            }
                        }

                        System.out.println("Sampai jumpa lagi Admin!");
                        break;
                    case "2":
                        System.out.println("Jika anda mahasiswa, masukkan akun mahasiswa anda!");
                        library.mahasiswaLogin();
                        boolean notLanjut = false;
                        BufferedReader baca = new BufferedReader(new InputStreamReader(System.in));
                        while (!notLanjut) {
                            tampilkanMenuMahasiswa();
                            System.out.print("Pilih menu : ");
                            String pilihan = baca.readLine();
                            switch (pilihan) {
                                case "1":
                                    library.lihatDaftarbuku();
                                    break;
                                case "2":
                                    library.peminjaman();
                                    break;
                                case "3":
                                    library.mahasiswaKembalikanBuku();
                                    break;
                                case "4":
                                    library.tampilkanLaporanPeminjaman();
                                    break;
                                case "5":
                                    notLanjut = true;
                                    break;
                                default:
                                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
                                    break;
                            }
                        }

                        System.out.println("Sampai jumpa lagi Mahasiswa!");
                        break;

                    case "3":
                        keluar = true; // Keluar dari program jika bukan admin
                        break;
                    default:
                        System.out.println("Pilihan Tidak Valid.");
                        break;
                }
            } while (!keluar);
        }
    }

    public static void tampilkanMenuAdmin() {
        System.out.println("");
        System.out.println("=============== Menu Admin ===============");
        System.out.println("1. Lihat Daftar Buku");
        System.out.println("2. Menambah Buku ke Daftar");
        System.out.println("3. Menghapus Buku dari Daftar");
        System.out.println("4. Konfirmasi Pengembalian dan Denda");
        System.out.println("5. Laporan Pengembalian");
        System.out.println("6. Keluar");
    }

    public static void tampilkanMenuMahasiswa() {
        System.out.println("");
        System.out.println("=============== Menu ===============");
        System.out.println("1. Lihat Daftar Buku");
        System.out.println("2. Meminjam Buku");
        System.out.println("3. Mengembalikan Buku");
        System.out.println("4. Laporan Pinjaman Buku");
        System.out.println("5. Keluar");
    }
}
