/**
 * Superclass abstrak untuk semua jenis pasien rumah sakit.
 * Ketentuan: 1 (state & behavior), 2 (immutability), 3 (enkapsulasi & overloading),
 *            4 (inheritance), 7 (abstract class).
 */
public abstract class Pasien {

    // [Ketentuan 2] Konstanta global
    public static final String NAMA_RS = "RS Harapan Sehat";

    // [Ketentuan 2] Atribut instans kekal (tidak bisa diubah setelah dibuat)
    private final String idPasien;

    // [Ketentuan 1 & 3] State: atribut private
    private String nama;
    private int umur;
    private String status;
    private String diagnosa;

    // [Ketentuan 3] Konstruktor overload #1
    public Pasien(String idPasien, String nama, int umur) {
        this.idPasien = idPasien;
        this.nama = nama;
        this.umur = umur;
        this.status = "Terdaftar";
        this.diagnosa = "Belum diperiksa";
    }

    // [Ketentuan 3] Konstruktor overload #2 (umur belum diketahui)
    public Pasien(String idPasien, String nama) {
        this(idPasien, nama, 0);
    }

    // [Ketentuan 3] Getter & setter (idPasien hanya getter karena final)
    public String getIdPasien() {
        return idPasien;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        if (umur >= 0) {
            this.umur = umur;
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDiagnosa() {
        return diagnosa;
    }

    public void setDiagnosa(String diagnosa) {
        this.diagnosa = diagnosa;
    }

    // [Ketentuan 1] Behavior: method prosedur (void)
    public void tampilkanInfo() {
        System.out.println("[" + NAMA_RS + "] Pasien " + idPasien);
        System.out.println("  Nama     : " + nama + " (" + umur + " tahun)");
        System.out.println("  Status   : " + status);
        System.out.println("  Diagnosa : " + diagnosa);
    }

    // [Ketentuan 1] Behavior: method fungsi (return value)
    public String getRingkasan() {
        return idPasien + " - " + nama + " [" + status + "]";
    }

    // [Ketentuan 7] Abstract method, wajib diimplementasi subclass
    public abstract void prosesPerawatan();
}