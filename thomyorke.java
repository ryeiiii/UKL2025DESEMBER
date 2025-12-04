import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Locale;
import java.text.NumberFormat;

public class thomyorke {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("-------------Soal 1-------------");
        int n;
        while (true) {
            System.out.print("Masukkan bilangan: ");
            n = input.nextInt();
            if (n < 100) {
                System.out.println("harus lebih dari 100 :< ");
            } else if (n > 150) {
                System.err.println("Harus dibawah 150 :< ");
            } else {
                break;
            }
        }

        boolean prima = true;
        if (n < 2) {
            prima = false;
        } else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    prima = false;
                    break;
                }
            }
        }
        if (prima) {
            System.out.println(n + " bilangan prima.");
        } else {
            System.out.println(n + " bukan bilangan prima.");
        }
        
        System.out.println("-------------Soal 2-------------");
        int[] pecahan = {100000, 50000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100};
        System.out.print("Masukkan jumlah uang: ");
        int uang = input.nextInt();
        boolean outpuT = false;

        for (int p : pecahan) {
            int lembar = uang / p;
            if (lembar > 0) {
                System.out.println(lembar + " Lembar " + p);
                outpuT = true;
            }
            uang = uang % p;
        }
        while (!outpuT) {
            System.out.println("cannot be counted.. put above 100");
            break;
        }
        
        System.out.println("-------------Soal 3-------------");
        while (true) {
            System.out.print("\nmulai kuis? (y/n): ");
            String lanjut = input.next();
            if (lanjut.equalsIgnoreCase("n")) {
                System.out.println("aww..");
                break;
            }
            int a = rand.nextInt(10) + 1;
            int b = rand.nextInt(10) + 1;

            char[] ops = {'*', '/', '%'};
            char op = ops[rand.nextInt(3)];

            System.out.print(a + " " + op + " " + b + " = ");
            int jawabanUser = input.nextInt();
            int hasil = 0;

            if (op == '*') {
                hasil = a * b;
            } else if (op == '/') {
                hasil = a / b;
            } else if (op == '%') {
                hasil = a % b;
            }

            if (jawabanUser == hasil) {
                System.out.println("congratsss: " + hasil);
            } else {
                System.out.println("awww salah: " + hasil);
            }
        }
        
        System.out.println("-------------Soal 4-------------");
        int[] array = {1, 2, 3, 4, 2, 5, 5, 5, 9, 7, 8, 4, 1, 0};
        boolean duuuplikat = false;
        int duplikat = -1;
        
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    duuuplikat = true;
                    duplikat = array[i];
                    break;
                }
            }
            if (duuplikat) break;
        }
        if (duuuplikat) {
            System.out.println("Array memiliki duplikat: " + duplikat);
        } else {
            System.out.println("Array tidak duplikat");
        }
        
        System.out.println("-------------Soal 5-------------");
        ArrayList<Integer> riwayatKomputer = new ArrayList<>();
        ArrayList<Integer> riwayatPemain = new ArrayList<>();

        int kemenanganKomputer = 0;
        int kemenanganPemain = 0;
        int ronde = 0;
        
        System.out.println("lempar dadu game");
        System.out.println("enter for lempar (q to stop the game).");
        input.nextLine();

        while (kemenanganKomputer < 5 && kemenanganPemain < 5) {
            System.out.print("\nRonde " + (ronde + 1) + " - enter untuk melempar dadu: ");
            String line = input.nextLine();
            if (line.equalsIgnoreCase("q")) {
                System.out.println("Permainan dihentikan.");
                break;
            }

            int daduKomputer = rand.nextInt(6) + 1;
            int daduPemain = rand.nextInt(6) + 1;

            riwayatKomputer.add(daduKomputer);
            riwayatPemain.add(daduPemain);

            System.out.println("Komputer melempar: " + daduKomputer);
            System.out.println("Pemain melempar   : " + daduPemain);

            if (daduKomputer > daduPemain) {
                kemenanganKomputer++;
                System.out.println("Hasil ronde: Komputer menang di ronde ini.");
            } else if (daduPemain > daduKomputer) {
                kemenanganPemain++;
                System.out.println("Hasil ronde: Pemain menang di ronde ini.");
            } else {
                System.out.println("Hasil ronde: Seri.");
            }

            ronde++;
            System.out.println("Skor -> Komputer: " + kemenanganKomputer + " | Pemain: " + kemenanganPemain);
        }

        if (kemenanganKomputer >= 5) {
            System.out.println("\nPermainan selesai, pemenangnya adalah: Komputer");
        } else if (kemenanganPemain >= 5) {
            System.out.println("\nPermainan selesai, pemenangnya adalah: Pemain");
        } else {
            System.out.println("\nPermainan berakhir sebelum ada pemenang mencapai 5 kemenangan.");
        }

        System.out.println("\nhistory lemparan");
        System.out.println("Ronde | Komputer | Pemain");
        for (int i = 0; i < riwayatKomputer.size(); i++) {
            System.out.printf("%5d | %8d | %6d%n", i + 1, riwayatKomputer.get(i), riwayatPemain.get(i));
        }

        System.out.println("\nTotal kemenangan:");
        System.out.println("Komputer: " + kemenanganKomputer);
        System.out.println("Pemain  : " + kemenanganPemain);
        
        System.out.println("-------------Soal 6-------------");
        System.out.print("Nama peminjam: ");
        String nama = input.nextLine();
        System.out.print("Judul buku: ");
        String judul = input.nextLine();
        String kategori;
        while (true) {
            System.out.print("Kategori buku (A/B/C): ");
            kategori = input.next().trim().toUpperCase();
            if (kategori.equals("A") || kategori.equals("B") || kategori.equals("C")) break;
            System.out.println("Nope. Masukkan A, B, atau C.");
        }

        System.out.print("Lama peminjaman (hari): ");
        int hari = input.nextInt();
        int tarifPerHari;
        switch (kategori) {
            case "A": tarifPerHari = 2000; break;
            case "B": tarifPerHari = 1500; break;
            default:  tarifPerHari = 1000; break;
        }
        int biayaAwal = tarifPerHari * hari;
        int denda = 0;
        if (hari > 7) {
            int hariTelat = hari - 7;
            denda = 500 * hariTelat;
        }

        int total = biayaAwal + denda;
        System.out.println("\n--- Rincian Peminjaman ---");
        System.out.println("Nama peminjam   : " + nama);
        System.out.println("Judul buku      : " + judul);
        System.out.println("Kategori buku   : " + kategori);
        System.out.println("Lama peminjaman : " + hari + " hari");
        System.out.println("Biaya awal      : Rp " + biayaAwal);
        System.out.println("Denda keterlambatan: Rp " + denda);
        System.out.println("Total biaya akhir: Rp " + total);
        
        System.out.println("-------------Soal 7-------------");
        class Cookie {
            String nama;
            long hargaProduksi;
            long hargaJual;
            long jumlahTerjual;
            Cookie(String nama, long hp, long hj, long jt) {
                this.nama = nama;
                this.hargaProduksi = hp;
                this.hargaJual = hj;
                this.jumlahTerjual = jt;
            }
            long totalBiaya() { return hargaProduksi * jumlahTerjual; }
            long totalPendapatan() { return hargaJual * jumlahTerjual; }
            long labaRugi() { return totalPendapatan() - totalBiaya(); }
            String status() {
                long lr = labaRugi();
                if (lr > 0) return "Laba";
                if (lr < 0) return "Rugi";
                return "Impas";
            }
        }
        
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        nf.setMaximumFractionDigits(0);
        System.out.print("Masukkan jumlah jenis cookies: ");
        int jumlah = input.nextInt();
        input.nextLine();
        ArrayList<Cookie> daftar = new ArrayList<>();

        for (int i = 1; i <= jumlah; i++) {
            System.out.println("\nCookies ke-" + i + ":");
            System.out.print("Nama cookies: ");
            String namaCookie = input.nextLine();
            System.out.print("Harga produksi per bungkus: ");
            long hp = input.nextLong();
            System.out.print("Harga jual per bungkus: ");
            long hj = input.nextLong();
            System.out.print("Jumlah terjual: ");
            long jt = input.nextLong();
            input.nextLine();
            daftar.add(new Cookie(namaCookie, hp, hj, jt));
        }
        System.out.println("\n--------------------------------------------------------------");
        System.out.println("Nama Cookies\t\tBiaya Total\tPendapatan\tLaba/Rugi\tStatus");
        System.out.println("--------------------------------------------------------------");
        long totalSemua = 0;
        long maxLaba = Long.MIN_VALUE;
        String maxNama = "-";
        for (Cookie c : daftar) {
            long biaya = c.totalBiaya();
            long pendapatan = c.totalPendapatan();
            long laba = c.labaRugi();
            if (laba > maxLaba) {
                maxLaba = laba;
                maxNama = c.nama;
            }
            totalSemua += laba;

            String labaStr = (laba < 0)
                ? "-" + nf.format(Math.abs(laba))
                : nf.format(laba);
            System.out.println(
                c.nama + "\t\t" +
                nf.format(biaya) + "\t" +
                nf.format(pendapatan) + "\t" +
                labaStr + "\t" +
                c.status()
            );
        }

        System.out.println("--------------------------------------------------------------");
        String totalStr = (totalSemua < 0)
                ? "-" + nf.format(Math.abs(totalSemua))
                : nf.format(totalSemua);
        System.out.println("Total Laba/Rugi Keseluruhan: " + totalStr);
        System.out.println("Cookies dengan laba tertinggi: " + maxNama + " (" + nf.format(maxLaba) + ")");

        input.close();
    }
}