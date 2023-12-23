package Source.Components;

import java.time.LocalTime;
import java.util.ArrayList;

public class Peminjaman {
    private String idPeminjaman;
    private Mahasiswa mahasiswa;
    private AdminPerpus adminPerpus;
    private int total;
    private LocalTime waktu;
    private ArrayList<DetailPeminjaman> detailPeminjamanb;

    public String getIdPeminjaman() {
        return idPeminjaman;
    }

    public Peminjaman setIdPeminjaman(String idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
        return this;
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public Peminjaman setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
        return this;
    }

    public AdminPerpus getAdminPerpus() {
        return adminPerpus;
    }

    public Peminjaman setAdminPerpus(AdminPerpus adminPerpus) {
        this.adminPerpus = adminPerpus;
        return this;
    }

    public int getTotal() {
        return total;
    }

    public Peminjaman setTotal(int total) {
        this.total = total;
        return this;
    }

    public LocalTime getWaktu() {
        return waktu;
    }

    public Peminjaman setWaktu(LocalTime waktu) {
        this.waktu = waktu;
        return this;
    }

    public ArrayList<DetailPeminjaman> getDetailPeminjamanb() {
        return detailPeminjamanb;
    }

    public Peminjaman setDetailPeminjamanb(ArrayList<DetailPeminjaman> detailPeminjamanb) {
        this.detailPeminjamanb = detailPeminjamanb;
        return this;
    }

}
