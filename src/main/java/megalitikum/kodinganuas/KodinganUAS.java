/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package megalitikum.kodinganuas;
import java.util.Scanner;

/**
 *
 * @author Yakup Asmaidy
 */
public class KodinganUAS {

     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Memeriksa apakah pengguna memiliki KTP
        System.out.print("Apakah Anda memiliki KTP? (ya/tidak): ");
        String hasKTP = scanner.next();

        if (!hasKTP.equalsIgnoreCase("ya")) {
            System.out.println("Anda harus memiliki KTP untuk menghitung pajak.");
            scanner.close();
            return;
        }

        // Menampilkan opsi pekerjaan
        System.out.println("Pilih jenis pekerjaan Anda:");
        System.out.println("1. Pegawai");
        System.out.println("2. Wirausaha");
        System.out.println("3. Freelancer");
        System.out.println("4. Lainnya");

        // Meminta input jenis pekerjaan
        System.out.print("Masukkan nomor pilihan pekerjaan Anda: ");
        int jobOption = scanner.nextInt();
        String jobType = TaxCalculator.getJobType(jobOption);

        if (jobType.equals("Invalid")) {
            System.out.println("Pilihan pekerjaan tidak valid.");
            scanner.close();
            return;
        }

        // Memeriksa apakah pengguna memiliki kendaraan
        System.out.print("Apakah Anda memiliki kendaraan? (ya/tidak): ");
        String hasVehicle = scanner.next();

        int carCount = 0;
        int motorcycleCount = 0;
        if (hasVehicle.equalsIgnoreCase("ya")) {
            // Meminta jumlah mobil
            System.out.print("Berapa jumlah mobil yang Anda miliki? ");
            carCount = scanner.nextInt();
            
            // Meminta jumlah motor
            System.out.print("Berapa jumlah motor yang Anda miliki? ");
            motorcycleCount = scanner.nextInt();
        }

        // Minta input pendapatan dari pengguna
        System.out.print("Masukkan pendapatan Anda: ");
        double income = scanner.nextDouble();

        // Tentukan tarif pajak berdasarkan pekerjaan
        double taxRate = TaxCalculator.getTaxRate(jobType, carCount, motorcycleCount);

        // Hitung pajak
        double tax = TaxCalculator.calculateTax(income, taxRate);

        // Tampilkan hasilnya
        System.out.println("Pendapatan Anda: " + income);
        System.out.println("Pekerjaan Anda: " + jobType);
        System.out.println("Pajak yang harus dibayar: " + tax);

        scanner.close();
    }
}
