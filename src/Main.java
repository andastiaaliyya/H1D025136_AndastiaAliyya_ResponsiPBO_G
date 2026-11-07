public class Main {
    public static void main(String[] args) {
        System.out.println("===== SISTEM PASIEN " + Pasien.NAMA_RS.toUpperCase() + " =====\n");

        // [Ketentuan 9] Variabel referensi bertipe interface = new Subclass();
        DapatDitagih tagihanJalan = new PasienRawatJalan("RJ-001", "Budi Santoso", 25, "dr. Ayu");
        DapatDitagih tagihanInap = new PasienRawatInap("RI-001", "Siti Aminah", 40, "A-201");
        DapatDitagih tagihanIgd = new PasienIGD("IGD-001", "Joko Widodo", 55, 5);

        DapatDijadwalkan jadwalJalan = new PasienRawatJalan("RJ-002", "Dewi Lestari", "dr. Hendra");
        DapatDijadwalkan jadwalInap = new PasienRawatInap("RI-002", "Agus Salim", "B-105");

        // Penjadwalan lewat interface
        jadwalJalan.buatJadwal("Senin", "09.00");
        jadwalInap.buatJadwal("Selasa", "10.30");
        System.out.println("Jadwal Dewi : " + jadwalJalan.getJadwal());
        System.out.println("Jadwal Agus : " + jadwalInap.getJadwal());
        System.out.println();

        // Proses perawatan (polimorfisme lewat superclass abstrak)
        Pasien[] daftarPasien = {
                (Pasien) tagihanJalan,
                (Pasien) tagihanInap,
                (Pasien) tagihanIgd
        };

        System.out.println("--- Proses perawatan (4 tahap) ---");
        for (int tahap = 1; tahap <= 4; tahap++) {
            System.out.println("Tahap " + tahap + ":");
            for (Pasien p : daftarPasien) {
                p.prosesPerawatan();
            }
            System.out.println();
        }

        // Informasi lengkap (method yang di-override)
        System.out.println("--- Informasi pasien ---");
        for (Pasien p : daftarPasien) {
            p.tampilkanInfo();
            System.out.println();
        }

        // Tagihan lewat interface
        System.out.println("--- Tagihan ---");
        DapatDitagih[] semuaTagihan = {tagihanJalan, tagihanInap, tagihanIgd};
        double total = 0;
        for (DapatDitagih t : semuaTagihan) {
            double biaya = t.hitungBiaya();
            total += biaya;
            System.out.println(((Pasien) t).getRingkasan() + " -> Rp" + String.format("%,.0f", biaya));
        }
        System.out.println("Total pendapatan: Rp" + String.format("%,.0f", total));
    }
}