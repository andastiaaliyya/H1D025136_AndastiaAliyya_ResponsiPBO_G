/**
 * Subclass pasien rawat jalan.
 * Ketentuan: 4 (extends), 5 (super chaining), 6 (override), 8 (logika if/else state),
 *            10 (implements dua interface sekaligus).
 */
public class PasienRawatJalan extends Pasien implements DapatDitagih, DapatDijadwalkan {

    public static final double TARIF_KONSULTASI = 75000;

    private String dokter;
    private String jadwal;
    private double biayaObat;

    // Konstruktor overload #1 -> [Ketentuan 5] super(...)
    public PasienRawatJalan(String idPasien, String nama, int umur, String dokter) {
        super(idPasien, nama, umur);
        this.dokter = dokter;
        this.jadwal = "Belum dijadwalkan";
        this.biayaObat = 0;
    }

    // Konstruktor overload #2 -> [Ketentuan 5] super(...)
    public PasienRawatJalan(String idPasien, String nama, String dokter) {
        super(idPasien, nama);
        this.dokter = dokter;
        this.jadwal = "Belum dijadwalkan";
        this.biayaObat = 0;
    }

    public String getDokter() {
        return dokter;
    }

    public void setDokter(String dokter) {
        this.dokter = dokter;
    }

    public double getBiayaObat() {
        return biayaObat;
    }

    public void setBiayaObat(double biayaObat) {
        if (biayaObat >= 0) {
            this.biayaObat = biayaObat;
        }
    }

    // [Ketentuan 8] Implementasi abstract method: if/else membaca & mengubah state
    @Override
    public void prosesPerawatan() {
        if (getStatus().equals("Terdaftar")) {
            setStatus("Sedang Diperiksa");
            System.out.println(getNama() + " mulai diperiksa oleh " + dokter);
        } else if (getStatus().equals("Sedang Diperiksa")) {
            setStatus("Selesai");
            setDiagnosa("Rawat jalan selesai, pasien boleh pulang");
            System.out.println(getNama() + " selesai diperiksa");
        } else {
            System.out.println(getNama() + " sudah selesai, tidak ada proses lagi");
        }
    }

    @Override
    public double hitungBiaya() {
        return TARIF_KONSULTASI + biayaObat;
    }

    @Override
    public void buatJadwal(String hari, String jam) {
        this.jadwal = hari + ", " + jam;
    }

    @Override
    public String getJadwal() {
        return jadwal;
    }

    // [Ketentuan 6 & 5] Override + super.namaMethod()
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("  Jenis    : Rawat Jalan");
        System.out.println("  Dokter   : " + dokter);
        System.out.println("  Jadwal   : " + jadwal);
    }
}