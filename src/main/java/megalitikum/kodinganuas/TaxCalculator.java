/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package megalitikum.kodinganuas;

/**
 *
 * @author Yakup Asmaidy
 */
public class TaxCalculator {
    
    
    // Method untuk menghitung pajak
    public static double calculateTax(double income, double taxRate) {
        return income * taxRate;
    }

    // Method untuk menentukan tarif pajak berdasarkan pekerjaan dan kepemilikan kendaraan
    public static double getTaxRate(String jobType, int carCount, int motorcycleCount) {
        double baseTaxRate = 0.10; // Tarif pajak dasar 10%

        // Menyesuaikan tarif pajak berdasarkan jenis pekerjaan
        switch (jobType.toLowerCase()) {
            case "pegawai":
                baseTaxRate = 0.12;
                break;
            case "wirausaha":
                baseTaxRate = 0.15;
                break;
            case "freelancer":
                baseTaxRate = 0.10;
                break;
            default:
                baseTaxRate = 0.08; // Tarif default untuk pekerjaan lain
        }

        // Menambahkan tarif pajak tambahan berdasarkan jumlah kendaraan
        double vehicleTaxRate = 0.00;
        if (carCount > 0) {
            vehicleTaxRate += carCount * 0.03; // Tambah 3% per mobil
        }
        if (motorcycleCount > 0) {
            vehicleTaxRate += motorcycleCount * 0.01; // Tambah 1% per motor
        }

        return baseTaxRate + vehicleTaxRate;
    }

    // Method untuk mendapatkan jenis pekerjaan berdasarkan input nomor
    public static String getJobType(int jobOption) {
        switch (jobOption) {
            case 1:
                return "Pegawai";
            case 2:
                return "Wirausaha";
            case 3:
                return "Freelancer";
            case 4:
                return "Lainnya";
            default:
                return "Invalid";
        }
    }
}
