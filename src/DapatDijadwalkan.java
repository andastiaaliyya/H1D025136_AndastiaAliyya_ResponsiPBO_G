/**
 * Interface untuk objek yang memiliki jadwal pemeriksaan/perawatan.
 * Ketentuan: 9 & 10 (interface).
 */
public interface DapatDijadwalkan {
    void buatJadwal(String hari, String jam);

    String getJadwal();
}