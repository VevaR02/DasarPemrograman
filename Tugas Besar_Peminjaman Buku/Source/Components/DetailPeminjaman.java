package Source.Components;

public class DetailPeminjaman {
    private String idDetailPeminjaman;
    private Peminjaman peminjaman;
    private Buku buku;
    private int hargaDenda;
    private int lamaTelat;
    private int dendaTotal;

    public String getIdDetailPeminjaman() {
        return idDetailPeminjaman;
    }

    public void setIdDetailPeminjaman(String idDetailPeminjaman) {
        this.idDetailPeminjaman = idDetailPeminjaman;
    }

    public Peminjaman getPeminjaman() {
        return peminjaman;
    }

    public void setPeminjaman(Peminjaman peminjaman) {
        this.peminjaman = peminjaman;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public int getHargaDenda() {
        return hargaDenda;
    }

    public void setHargaDenda(int hargaDenda) {
        this.hargaDenda = hargaDenda;
    }

    public int getLamaTelat() {
        return lamaTelat;
    }

    public void setLamaTelat(int lamaTelat) {
        this.lamaTelat = lamaTelat;
    }

    public int getDendaTotal() {
        return dendaTotal;
    }

    public void setDendaTotal(int dendaTotal) {
        this.dendaTotal = dendaTotal;
    }

}
