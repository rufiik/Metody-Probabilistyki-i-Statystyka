package com.example.mersenneproject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.math3.random.MersenneTwister;

public class Random {
    public static void calculateAndWriteIntegrals(MersenneTwister mt, int a, int b, int max, int k, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("Funkcja f(x)=cbrt(x) dla x∈[0,8]");
            writer.newLine();
            for (int n = 50; n <= 5000; n += 50) {
                for (int j = 0; j < k; j++) {
                    int C = 0;
                    for (int i = n; i > 0; i--) {
                        double randomValueX = mt.nextDouble() * b;
                        double randomValueY = mt.nextDouble() * max;
                        double function = Math.cbrt(randomValueX);
                        if (randomValueY <= function) {
                            C++;
                        }
                    }
                    writer.write("n=" + n + ";");
                    double result = (double) C / n;
                    double integral = result * (b - a) * max;
                    writer.write(String.valueOf(integral));
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}