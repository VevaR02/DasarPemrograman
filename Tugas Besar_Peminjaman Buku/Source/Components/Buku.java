package Source.Components;

public class Buku {
    private String idBuku;
    private String namaBuku;
    private int lamaTelat;
    private int hargaDenda;
    private boolean tersedia;

    public Buku setIdBuku(String idBuku) {
        this.idBuku = idBuku;
        return this;
    }

    public Buku setNamaBuku(String namaBuku) {
        this.namaBuku = namaBuku;
        return this;
    }

    public Buku setLamaTelat(int lamaTelat) {
        this.lamaTelat = lamaTelat;
        return this;
    }

    public Buku setHargaDenda(int hargaDenda) {
        this.hargaDenda = hargaDenda;
        return this;
    }

    public Buku setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
        return this;
    }

    public String getIdBuku() {
        return idBuku;
    }

    public String getNamaBuku() {
        return namaBuku;
    }

    public int getLamaTelat() {
        return lamaTelat;
    }

    public int getHargaDenda() {
        return hargaDenda;
    }

    public boolean tersedia() {
        return tersedia;
    }
}
