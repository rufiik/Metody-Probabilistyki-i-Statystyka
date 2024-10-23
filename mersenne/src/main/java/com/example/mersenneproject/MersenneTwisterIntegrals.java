package com.example.mersenneproject;
import org.apache.commons.math3.random.MersenneTwister;


public class MersenneTwisterIntegrals {
    public static void main(String[] args) {
        MersenneTwister mt = new MersenneTwister();
        int a = 0;
        int b = 8;
        int max = 2;
        int k = 5;
        Random.calculateAndWriteIntegrals(mt, a, b, max, k, "wyniki2.txt");
    }




}
