/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package megalitikum.kodinganuas;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Yakup Asmaidy
 */
public class TaxCalculatorTest {
    
    @Test
    public void testCalculateTax() {
        // Test calculateTax method
        assertEquals(100.0, TaxCalculator.calculateTax(1000.0, 0.10), 0.01);
        assertEquals(150.0, TaxCalculator.calculateTax(1000.0, 0.15), 0.01);
    }

    @Test
    public void testGetTaxRate() {
        // Test getTaxRate method for different job types and vehicle counts
        assertEquals(0.12, TaxCalculator.getTaxRate("pegawai", 0, 0), 0.01);
        assertEquals(0.16, TaxCalculator.getTaxRate("pegawai", 1, 1), 0.01);
        assertEquals(0.19, TaxCalculator.getTaxRate("wirausaha", 1, 1), 0.01);
        assertEquals(0.16, TaxCalculator.getTaxRate("freelancer", 1, 2), 0.01);
        assertEquals(0.13, TaxCalculator.getTaxRate("lainnya", 1, 2), 0.01);
    }

    @Test
    public void testGetJobType() {
        // Test getJobType method for valid inputs
        assertEquals("Pegawai", TaxCalculator.getJobType(1));
        assertEquals("Wirausaha", TaxCalculator.getJobType(2));
        assertEquals("Freelancer", TaxCalculator.getJobType(3));
        assertEquals("Lainnya", TaxCalculator.getJobType(4));

        // Test getJobType method for invalid input
        assertEquals("Invalid", TaxCalculator.getJobType(0));
        assertEquals("Invalid", TaxCalculator.getJobType(5));
    }
}
