package logic;
import java.util.HashMap;
import java.util.Map;
import datamodels.Polynomial;

public class Operations {

    public static Polynomial add(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();

        Map<Integer, Double> polynomials1 = new HashMap<>(p1.polynomials);
        Map<Integer, Double> polynomials2 = new HashMap<>(p2.polynomials);

        for (int degree : polynomials1.keySet()) {
            result.mergeCoefficients(degree, polynomials1.get(degree));
        }

        for (int degree : polynomials2.keySet()) {
            result.mergeCoefficients(degree, polynomials2.get(degree));
        }
        return result;
    }


    public static Polynomial subtract(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();

        Map<Integer, Double> polynomials1 = new HashMap<>(p1.polynomials);
        Map<Integer, Double> polynomials2 = new HashMap<>(p2.polynomials);

        for (int degree : polynomials1.keySet()) {
            result.mergeCoefficients(degree, polynomials1.get(degree));
        }

        for (int degree : polynomials2.keySet()) {
            result.mergeCoefficients(degree, -polynomials2.get(degree));
        }
        return result;
    }

    public static Polynomial multiply(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        for (int degree1 : p1.polynomials.keySet()) {
            for (int degree2 : p2.polynomials.keySet()) {
                int degree = degree1 + degree2;
                double coefficient = p1.polynomials.get(degree1) * p2.polynomials.get(degree2);
                result.mergeCoefficients(degree, coefficient);
            }
        }
        return result;
    }

    public static Polynomial derivate(Polynomial p1) {
        Polynomial result = new Polynomial();
        for (int degree : p1.polynomials.keySet()) {
            if (degree != 0) {
                double coefficient = p1.polynomials.get(degree) * degree;
                result.mergeCoefficients(degree - 1, coefficient);
            }
        }
        return result;
    }

    public static Polynomial integrate(Polynomial p1) {
        Polynomial result = new Polynomial();
        for (int degree : p1.polynomials.keySet()) {
            double coefficient = p1.polynomials.get(degree) / (degree + 1);
            coefficient = Math.round(coefficient * 1000.0) / 1000.0; //show output with 3 decimals, for period numbers
            result.mergeCoefficients(degree + 1, coefficient);
        }
        return result;
    }
}



