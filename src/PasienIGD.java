/**
 * Subclass pasien Instalasi Gawat Darurat (IGD).
 * Ketentuan: 4, 5, 6, 8.
 */
public class PasienIGD extends Pasien implements DapatDitagih {

    public static final double BIAYA_DASAR_IGD = 200000;

    // Tingkat keparahan 1 (ringan) sampai 5 (sangat kritis)
    private int tingkatKeparahan;

    // Konstruktor overload #1 -> super(...)
    public PasienIGD(String idPasien, String nama, int umur, int tingkatKeparahan) {
        super(idPasien, nama, umur);
        this.tingkatKeparahan = tingkatKeparahan;
    }

    // Konstruktor overload #2 -> super(...)
    public PasienIGD(String idPasien, String nama, int tingkatKeparahan) {
        super(idPasien, nama);
        this.tingkatKeparahan = tingkatKeparahan;
    }

    public int getTingkatKeparahan() {
        return tingkatKeparahan;
    }

    public void setTingkatKeparahan(int tingkatKeparahan) {
        if (tingkatKeparahan >= 1 && tingkatKeparahan <= 5) {
            this.tingkatKeparahan = tingkatKeparahan;
        }
    }

    // [Ketentuan 8] if/else membaca & mengubah state internal
    @Override
    public void prosesPerawatan() {
        if (getStatus().equals("Terdaftar")) {
            if (tingkatKeparahan >= 4) {
                setStatus("Penanganan Darurat - ICU");
                setDiagnosa("Kondisi kritis, dipindahkan ke ICU");
                System.out.println(getNama() + " langsung ditangani tim darurat dan masuk ICU");
            } else {
                setStatus("Observasi IGD");
                setDiagnosa("Kondisi stabil, dalam observasi");
                System.out.println(getNama() + " diobservasi di IGD");
            }
        } else if (getStatus().equals("Observasi IGD")) {
            setStatus("Selesai");
            setDiagnosa("Observasi selesai, pasien dipulangkan");
            System.out.println(getNama() + " selesai observasi IGD");
        } else {
            System.out.println(getNama() + " sedang/sudah ditangani: " + getStatus());
        }
    }

    @Override
    public double hitungBiaya() {
        return BIAYA_DASAR_IGD + (tingkatKeparahan * 150000);
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("  Jenis    : IGD (keparahan " + tingkatKeparahan + "/5)");
    }
}