/**
 * Subclass pasien rawat inap.
 * Ketentuan: 4, 5, 6, 8, 10 (implements dua interface).
 */
public class PasienRawatInap extends Pasien implements DapatDitagih, DapatDijadwalkan {

    public static final double TARIF_KAMAR_PER_HARI = 350000;

    private String nomorKamar;
    private int jumlahHari;
    private String jadwal;

    // Konstruktor overload #1 -> super(...)
    public PasienRawatInap(String idPasien, String nama, int umur, String nomorKamar) {
        super(idPasien, nama, umur);
        this.nomorKamar = nomorKamar;
        this.jumlahHari = 0;
        this.jadwal = "Visite dokter belum dijadwalkan";
    }

    // Konstruktor overload #2 -> super(...)
    public PasienRawatInap(String idPasien, String nama, String nomorKamar) {
        super(idPasien, nama);
        this.nomorKamar = nomorKamar;
        this.jumlahHari = 0;
        this.jadwal = "Visite dokter belum dijadwalkan";
    }

    public String getNomorKamar() {
        return nomorKamar;
    }

    public void setNomorKamar(String nomorKamar) {
        this.nomorKamar = nomorKamar;
    }

    public int getJumlahHari() {
        return jumlahHari;
    }

    public void setJumlahHari(int jumlahHari) {
        if (jumlahHari >= 0) {
            this.jumlahHari = jumlahHari;
        }
    }

    // Overloading method: tambah 1 hari / tambah n hari
    public void tambahHari() {
        jumlahHari++;
    }

    public void tambahHari(int n) {
        if (n > 0) {
            jumlahHari += n;
        }
    }

    // [Ketentuan 8] if/else membaca & mengubah state internal
    @Override
    public void prosesPerawatan() {
        if (getStatus().equals("Terdaftar")) {
            setStatus("Menunggu Kamar");
            System.out.println(getNama() + " menunggu kamar " + nomorKamar);
        } else if (getStatus().equals("Menunggu Kamar")) {
            setStatus("Dirawat");
            setDiagnosa("Dalam observasi rawat inap");
            System.out.println(getNama() + " mulai dirawat di kamar " + nomorKamar);
        } else if (getStatus().equals("Dirawat")) {
            tambahHari();
            if (jumlahHari >= 3) {
                setStatus("Boleh Pulang");
                setDiagnosa("Kondisi stabil setelah " + jumlahHari + " hari");
                System.out.println(getNama() + " dinyatakan boleh pulang");
            } else {
                System.out.println(getNama() + " dirawat hari ke-" + jumlahHari);
            }
        } else {
            System.out.println(getNama() + " sudah boleh pulang, tidak ada proses lagi");
        }
    }

    @Override
    public double hitungBiaya() {
        return TARIF_KAMAR_PER_HARI * jumlahHari;
    }

    @Override
    public void buatJadwal(String hari, String jam) {
        this.jadwal = "Visite dokter " + hari + ", " + jam;
    }

    @Override
    public String getJadwal() {
        return jadwal;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("  Jenis    : Rawat Inap");
        System.out.println("  Kamar    : " + nomorKamar + " (" + jumlahHari + " hari)");
        System.out.println("  Jadwal   : " + jadwal);
    }
}