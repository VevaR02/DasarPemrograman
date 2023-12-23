package Source.Components;

public class Mahasiswa extends Akun {
    private String passMahasiswa;
    private String nim;
    private String jurusan;

    public String getNim() {
        return nim;
    }

    public Mahasiswa setNim(String nim) {
        this.nim = nim;
        return this;
    }

    public String getJurusan() {
        return jurusan;
    }

    public Mahasiswa setJurusan(String jurusan) {
        this.jurusan = jurusan;
        return this;
    }

    public Mahasiswa setPassMahasiswa(String passMahasiswa) {
        this.passMahasiswa = passMahasiswa;
        return this;
    }

    public String getPassMahasiswa() {
        return this.passMahasiswa;
    }
}
