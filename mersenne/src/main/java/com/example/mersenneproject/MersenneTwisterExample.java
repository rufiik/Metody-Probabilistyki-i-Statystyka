package com.example.mersenneproject;
import org.apache.commons.math3.random.MersenneTwister;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MersenneTwisterExample {
    public static void main(String[] args) {
        // Tworzenie instancji MersenneTwister
        MersenneTwister mt = new MersenneTwister();
        int a = 0;
        int b = 8;
        // Losowanie liczby z przedziału a=0, b=8
        double randomValueX;
        double randomValueY;
        double function;
        // Losowanie liczby z przedziału 0 M=sup{f(x): x ∈ [a, b]} f(x)= cbrt(x)
        int k = 50;
        int C = 0;
        int max=2;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("wyniki1.txt",true))) {
            writer.write("Funkcja f(x)=cbrt(x) dla x∈[0,8]");
            writer.newLine();
            for (int n = 50; n <= 5000; n += 50) {
            for(int j=0;j<k;j++){
            for (int i = n; i > 0; i--) {
                randomValueX = mt.nextDouble() * b;
                randomValueY = mt.nextDouble() * max;
                function = Math.cbrt(randomValueX);
                if (randomValueY <= function) {
                    C++;
                }
            }
            writer.write("n=" + n+";");
            double result = (double)C/n;
            double integral = result * (b - a)*max;
            writer.write(String.valueOf(integral));
            writer.newLine();
            integral=0;
            result=0;
            C=0;
        }
    }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    
}
