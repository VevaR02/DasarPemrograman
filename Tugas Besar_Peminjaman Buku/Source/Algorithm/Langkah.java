package Source.Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import Source.Components.*;

public class Langkah {
    HashMap<String, Buku> bukub = new HashMap();
    ArrayList<Peminjaman> peminjamanb = new ArrayList<>();
    HashMap<String, Mahasiswa> mahasiswab = new HashMap();
    HashMap<String, AdminPerpus> adminPerpusb = new HashMap();

    public void setUp() {
        Buku buku1 = new Buku();
        Buku buku2 = new Buku();
        Buku buku3 = new Buku();
        Buku buku4 = new Buku();

        buku1.setNamaBuku("Harry Potter").setIdBuku("01").setHargaDenda(10000).setTersedia(true);
        buku2.setNamaBuku("Lord Of The Ring").setIdBuku("02").setHargaDenda(50000).setTersedia(true);
        buku3.setNamaBuku("The Hobbit").setIdBuku("03").setHargaDenda(25000).setTersedia(false);
        buku4.setNamaBuku("Mockingjays").setIdBuku("04").setHargaDenda(75000).setTersedia(true);

        bukub.put(buku1.getIdBuku(), buku1);
        bukub.put(buku2.getIdBuku(), buku2);
        bukub.put(buku3.getIdBuku(), buku3);
        bukub.put(buku4.getIdBuku(), buku4);

        Mahasiswa mahasiswa1 = new Mahasiswa();
        Mahasiswa mahasiswa2 = new Mahasiswa();
        Mahasiswa mahasiswa3 = new Mahasiswa();
        mahasiswa1.setPassMahasiswa("veva").setNim("1237050072").setJurusan("Teknik Informatika")
                .setName("Muhamad Veva Ramadhan").setEmail("vevaramadhan@gmail.com");
        mahasiswa2.setPassMahasiswa("ujang").setNim("1237050016").setJurusan("Teknik Informatika")
                .setName("Firman Adi Nugraha").setEmail("nugrahafirmanadi@gmail.com");
        mahasiswa3.setPassMahasiswa("hafiz").setNim("1237050137").setJurusan("Teknik Informatika")
                .setName("Muhammad Hafiz").setEmail("muhammadhafiz2694@gmailcom");
        mahasiswab.put(mahasiswa1.getNim(), mahasiswa1);
        mahasiswab.put(mahasiswa2.getNim(), mahasiswa2);
        mahasiswab.put(mahasiswa3.getNim(), mahasiswa3);

        AdminPerpus adminPerpus1 = new AdminPerpus();
        adminPerpus1.setName("Admin1").setEmail("admin@gmail.com").setIdAdminPerpus("01").setPassAdminPerpus("admin1");
        adminPerpusb.put(adminPerpus1.getIdAdminPerpus(), adminPerpus1);
    }

    public void adminPerpusLogin() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Masukkan Admin ID\t: ");
            String adminId = input.readLine();
            System.out.print("Masukkan Admin Password\t: ");
            String adminPassword = input.readLine();
            AdminPerpus admin = adminPerpusb.get(adminId);

            if (admin != null && admin.getPassAdminPerpus().equals(adminPassword)) {
                System.out.println("Admin Login Berhasil.");
                // Add your admin functionality here...
            } else {
                System.out.println("");
                System.out.println("Admin tidak sesuai, login gagal! Coba kembali.");
                adminPerpusLogin();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String nimMahasiswaLogin; // Tambahkan variabel nimMahasiswaLogin

    public void mahasiswaLogin() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Masukkan NIM Mahasiswa\t: ");
            nimMahasiswaLogin = input.readLine();
            System.out.print("Masukkan Password\t: ");
            String mahasiswaPassword = input.readLine();
            Mahasiswa mahasiswa = mahasiswab.get(nimMahasiswaLogin);

            if (mahasiswa != null && mahasiswa.getPassMahasiswa().equals(mahasiswaPassword)) {
                System.out.println("Mahasiswa Login Berhasil.");
                tampilkanLaporanPeminjaman();
                // Add your mahasiswa functionality here...
            } else {
                System.out.println("");
                System.out.println("Mahasiswa tidak sesuai, login gagal! Coba kembali.");
                mahasiswaLogin();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void lihatDaftarbuku() {
        System.out.println();
        System.out.println("=============== Daftar Buku ===============");
        for (Entry<String, Buku> buku : bukub.entrySet()) {
            String key = buku.getKey();
            Buku tbuku = buku.getValue();
            if (tbuku.tersedia()) {
                System.out.println("Kode Buku\t :" + key);
                System.out.println("Judul Buku\t :" + tbuku.getNamaBuku());
                System.out.println("Harga Denda\t :" + tbuku.getHargaDenda());
                System.out.println("=========================================");
            }

        }
    }

    public Buku getbuku(String IdBuku) {
        return bukub.get(IdBuku);
    }

    public AdminPerpus getaAdminPerpus(String idAdminPerpus) {
        return adminPerpusb.get(idAdminPerpus);
    }

    public Mahasiswa getMahasiswa(String nim) {
        return mahasiswab.get(nim);
    }

    public void tambahBuku() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            Buku buku = new Buku();

            System.out.print("Masukkan Nama Buku\t: ");
            String namaBuku = input.readLine();
            System.out.print("Masukkan ID Buku\t: ");
            String idBuku = input.readLine();
            System.out.print("Masukkan Harga Denda\t: ");
            int hargaDenda = Integer.parseInt(input.readLine());
            System.out.print("Apakah buku tersedia? (true/false)\t: ");
            boolean tersedia = Boolean.parseBoolean(input.readLine());

            buku.setNamaBuku(namaBuku).setIdBuku(idBuku).setHargaDenda(hargaDenda).setTersedia(tersedia);
            bukub.put(buku.getIdBuku(), buku);

            System.out.println("Buku berhasil ditambahkan.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hapusBuku() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Masukkan ID Buku yang akan dihapus\t: ");
            String idBuku = input.readLine();

            Buku buku = bukub.remove(idBuku);

            if (buku != null) {
                System.out.println("Buku dengan ID " + idBuku + " berhasil dihapus.");
            } else {
                System.out.println("Buku dengan ID " + idBuku + " tidak ditemukan.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pengembalidanDanDenda() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<DetailPeminjaman> tDetailPeminjamanb = new ArrayList<>();
        int increment = 0;
        String lanjut = "";
        try {
            do {
                increment++;
                System.out.println();
                System.out.print("Silahkan masukkan kode buku\t: ");
                String kodeBuku = input.readLine();
                System.out.print("Lama telat\t\t\t: ");
                int jumlah = Integer.valueOf(input.readLine());
                System.out.print("Kembali konfirmasi (Y/N)?\t: ");
                lanjut = input.readLine();

                DetailPeminjaman dp = new DetailPeminjaman();
                Buku tBuku = getbuku(kodeBuku);
                dp.setIdDetailPeminjaman("dp" + increment);
                dp.setBuku(tBuku);
                dp.setHargaDenda(tBuku.getHargaDenda());
                dp.setLamaTelat(jumlah);
                dp.setDendaTotal(tBuku.getHargaDenda() * jumlah);
                tDetailPeminjamanb.add(dp);

            } while (lanjut.equalsIgnoreCase("Y"));

            System.out.println("");
            System.out.println("=== Berikut Daftar Konfirmasi Anda ===");
            tampilkanDaftarPeminjaman(tDetailPeminjamanb);
            System.out.println("Total Denda: " + hitungTotalDenda(tDetailPeminjamanb));
            BufferedReader inputKonfirmasi = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Konfirmasi Pengembalian dan Denda (Y/N)?");
            String konfirm = "n";
            konfirm = inputKonfirmasi.readLine();
            if (konfirm.equalsIgnoreCase("y")) {
                Peminjaman peminjaman = new Peminjaman();
                peminjaman.setDetailPeminjamanb(tDetailPeminjamanb)
                        .setIdPeminjaman("PD" + peminjamanb.size() + 1)
                        .setAdminPerpus(getaAdminPerpus("01"))
                        .setWaktu(LocalTime.now())
                        .setTotal(hitungTotalDenda(tDetailPeminjamanb));
                peminjamanb.add(peminjaman);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private ArrayList<DetailPeminjaman> bukuDipinjam = new ArrayList<>();

    public void peminjaman() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<DetailPeminjaman> tDetailPeminjamanb = new ArrayList<>();
        int tambah = 0;
        String lanjut = "";

        try {
            do {
                tambah++;
                System.out.println();
                System.out.print("Silahkan masukkan kode buku\t: ");
                String kodebuku = input.readLine();

                // Periksa apakah buku tersedia sebelum dipinjam
                Buku tbuku = getbuku(kodebuku);
                if (tbuku != null && tbuku.tersedia()) {
                    tbuku.setTersedia(false); // Ubah status ketersediaan buku
                    DetailPeminjaman dp = new DetailPeminjaman();
                    dp.setIdDetailPeminjaman("dp" + tambah);
                    dp.setBuku(tbuku);
                    dp.setHargaDenda(tbuku.getHargaDenda());
                    tDetailPeminjamanb.add(dp);

                    // Tambahkan buku ke daftar sementara yang dipinjam
                    bukuDipinjam.add(dp);
                } else {
                    System.out.println("Buku dengan kode " + kodebuku + " tidak tersedia atau tidak valid.");
                }

                System.out.print("Meminjam lainnya (Y/N)?\t: ");
                lanjut = input.readLine();

            } while (lanjut.equalsIgnoreCase("Y"));
            System.out.println("");
            System.out.println("===============Berikut Daftar Peminjaman===============");
            tampilkanDaftarPeminjaman(tDetailPeminjamanb);
            BufferedReader inputKonfirmasi = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Konfirmasi Peminjaman (Y/N)?");
            String konfirm = "n";
            konfirm = inputKonfirmasi.readLine();
            if (konfirm.equalsIgnoreCase("y")) {
                Peminjaman peminjaman = new Peminjaman();
                peminjaman.setDetailPeminjamanb(tDetailPeminjamanb)
                        .setIdPeminjaman("P" + peminjamanb.size() + 1)
                        .setAdminPerpus(getaAdminPerpus("01"))
                        .setMahasiswa(getMahasiswa(nimMahasiswaLogin)) // Ganti dengan NIM yang diinput pada saat login
                        .setWaktu(LocalTime.now());
                peminjamanb.add(peminjaman);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void mahasiswaKembalikanBuku() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int tambah = 0;
        String lanjut = "";

        try {
            do {
                tambah++;
                System.out.println();
                System.out.print("Silahkan masukkan kode buku yang ingin dikembalikan\t: ");
                String kodebuku = input.readLine();

                // Periksa apakah buku ada dalam daftar peminjaman oleh mahasiswa
                DetailPeminjaman dp = bukuDipinjam.stream()
                        .filter(detailPeminjaman -> detailPeminjaman.getBuku().getIdBuku().equals(kodebuku))
                        .findFirst().orElse(null);

                if (dp != null) {
                    // Ubah status ketersediaan buku menjadi true saat pengembalian oleh mahasiswa
                    dp.getBuku().setTersedia(true);

                    // Hapus buku dari daftar sementara yang dipinjam
                    bukuDipinjam.remove(dp);

                    System.out.println("Buku dengan kode " + kodebuku + " berhasil dikembalikan.");
                } else {
                    System.out.println("Buku dengan kode " + kodebuku + " tidak ada dalam daftar peminjaman.");
                }

                System.out.print("Mengembalikan buku lainnya (Y/N)?\t\t: ");
                lanjut = input.readLine();

            } while (lanjut.equalsIgnoreCase("Y"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void tampilkanDaftarPengembalian(ArrayList<DetailPeminjaman> dp) {
        for (DetailPeminjaman detailPeminjaman : dp) {
            System.out.println("Judul Buku \t :" + detailPeminjaman.getBuku().getNamaBuku());
            System.out.println("Harga Denda \t :" + detailPeminjaman.getHargaDenda());
            System.out.println("Lama Telat \t :" + detailPeminjaman.getLamaTelat());
            System.out.println("");
        }
    }

    public void tampilkanDaftarPeminjaman(ArrayList<DetailPeminjaman> dp) {
        for (DetailPeminjaman detailPeminjaman : dp) {
            System.out.println("Judul Buku \t :" + detailPeminjaman.getBuku().getNamaBuku());
            System.out.println("Harga Denda \t :" + detailPeminjaman.getHargaDenda());
            System.out.println("");
        }
    }

    public int hitungTotalDenda(ArrayList<DetailPeminjaman> dp) {
        int total = 0;
        for (DetailPeminjaman detailPeminjaman : dp) {
            total += detailPeminjaman.getDendaTotal();
        }
        return total;
    }

    public void tampilkanLaporanPengembalian() {
        for (Peminjaman peminjaman : peminjamanb) {
            System.err.println();
            System.out.println("========================== Laporan ==========================");
            System.out.println("Kode Peminjaman \t : " + peminjaman.getIdPeminjaman());
            System.out.println("Tanggal Pengembalian \t : " + peminjaman.getWaktu());
            System.out.println("Admin \t\t\t : " + peminjaman.getAdminPerpus().getName());
            System.out.println("==========================================================");
            ArrayList<DetailPeminjaman> detailPeminjamanb = peminjaman.getDetailPeminjamanb();
            for (DetailPeminjaman dp : detailPeminjamanb) {
                System.out.println("Judul Buku \t : " + dp.getBuku().getNamaBuku());
                System.out.println("Lama Telat \t : " + dp.getLamaTelat());
                System.out.println("Harga Denda \t : " + dp.getDendaTotal());
                System.out.println("==========================================================");
            }
            System.out.println("==========================================================");
            System.out.println("Total Denda \t \t : " + peminjaman.getTotal());
            System.out.println("==========================================================");
        }
    }

    public void tampilkanLaporanPeminjaman() {
        for (Peminjaman peminjaman : peminjamanb) {
            System.err.println();
            System.out.println("========================== Laporan ==========================");
            System.out.println("Kode Peminjaman \t : " + peminjaman.getIdPeminjaman());
            System.out.println("Tanggal Peminjaman \t : " + peminjaman.getWaktu());
            System.out.println("Admin \t\t\t : " + peminjaman.getAdminPerpus().getName());
            System.out.println("Mahasiswa \t\t : " + mahasiswab.get(nimMahasiswaLogin).getName()); // Ganti dengan nama
                                                                                                   // mahasiswa yang
                                                                                                   // sesuai dengan NIM
                                                                                                   // login
            System.out.println("==========================================================");
            ArrayList<DetailPeminjaman> detailPeminjamanb = peminjaman.getDetailPeminjamanb();
            for (DetailPeminjaman dp : detailPeminjamanb) {
                System.out.println("Judul Buku \t\t : " + dp.getBuku().getNamaBuku());
                System.out.println("Harga Denda \t\t : " + dp.getDendaTotal());
                System.out.println("==========================================================");
            }
            System.out.println("==========================================================");
        }
    }

}
