package net.noideal.godel;

import java.text.DecimalFormat;

/**
 * Created by Jesse Daniels on 4/11/2015.
 */
public class GodelFunction {
    // add different systems - (Godel, Goldfarb, Quine)
    final static String[] symbol = {"0","S","+","*","=","~","⊃","∀","(",")","x","y","z"};
    final static int[] symNumber = {1,2,3,4,5,6,7,8,9,10,17,19,21};

    // ## Goldfarb
    static String s_bigG(String s_bigGin){
        String s_bigGout = "";
        String[] a_bigGin = s_bigGin.split("");

        for (int i = 0; i < a_bigGin.length; i++) {
            for (int n = 0; n < symbol.length; n++) {
                if (symbol[n].equals(a_bigGin[i])) {
                    s_bigGout += symNumber[n] + ",";
                }
            }
        }
        return s_bigGout.substring(0, s_bigGout.length() - 1);
    }

    static String s_littleG(String s_littleGin){
        String s_littleGout = "";
        String[] a_littleGin = s_littleGin.split(",");

        // to be replaced by a method
        final int[] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59}; // first 17 primes
        //

        for (int i = 0; i < a_littleGin.length; i++) {
            s_littleGout += "(" + primes[i] + "^" + a_littleGin[i] + ")";
        }
        return s_littleGout;
    }

    static String s_funOut(String s_funOutin){
        String[] a_funOutin = s_funOutin.substring(1, s_funOutin.length()-1).split("\\)\\(");
        double num = 1;
        DecimalFormat format = new DecimalFormat("0.#");

        for (int i = 0; i < a_funOutin.length; i++){
            String[] ints = a_funOutin[i].split("\\^");
            num *= Math.pow(Double.parseDouble(ints[0]), Double.parseDouble(ints[1]));
        }
        return format.format(num);
    }

}