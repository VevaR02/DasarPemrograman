package Source.Components;

public class AdminPerpus extends Akun {
    private String idAdminPerpus;
    private String passAdminPerpus;

    public String getPassAdminPerpus() {
        return passAdminPerpus;
    }

    public AdminPerpus setPassAdminPerpus(String passAdminPerpus) {
        this.passAdminPerpus = passAdminPerpus;
        return this;
    }

    public AdminPerpus setIdAdminPerpus(String idAdminPerpus) {
        this.idAdminPerpus = idAdminPerpus;
        return this;
    }

    public String getIdAdminPerpus() {
        return this.idAdminPerpus;
    }
}
