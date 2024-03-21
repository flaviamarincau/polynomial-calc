package datamodels;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Polynomial {
    public Map<Integer, Double> polynomials;
    public int degree;
    private final String POLYNOMIAL_PATTERN = "(-?\\d*\\.?\\d*)?x\\^?(\\d+)?";
    private final Pattern pattern = Pattern.compile(POLYNOMIAL_PATTERN);

    public Polynomial() {
        polynomials = new HashMap<>();
    }

    public void mergeCoefficients(int degree, double coefficient) {
        if (polynomials.containsKey(degree)) {
            double existingCoefficient = polynomials.get(degree);
            polynomials.put(degree, existingCoefficient + coefficient);
        } else {
            polynomials.put(degree, coefficient);
        }
        if (degree>this.degree) {
            this.degree = degree;
        }
    }

    public void clear() {
        polynomials.clear();
    }

    public double getCoefficient(int degree) {
        return polynomials.getOrDefault(degree, 0.0);
    }

    public int getDegree() {
            int maxDegree = 0;
            for (int degree : polynomials.keySet()) {
                if (degree > maxDegree) {
                    maxDegree = degree;
                }
            }
            return maxDegree;
    }

    public String convertString() {
        StringBuilder polynomialBuilt = new StringBuilder();
        TreeMap<Integer, Double> sortedPolynomials = new TreeMap<>(Collections.reverseOrder());
        sortedPolynomials.putAll(polynomials);

        for (int degree : sortedPolynomials.keySet()) {
            double coefficient = sortedPolynomials.get(degree);
            if (coefficient != 0) {
                if (coefficient > 0 && !polynomialBuilt.isEmpty()) {
                    polynomialBuilt.append("+");
                }
                if (coefficient % 1 == 0) {
                    polynomialBuilt.append((int) coefficient); //try to write it as int when you can
                } else {
                    polynomialBuilt.append(coefficient);
                }
                if (degree != 0) {
                    polynomialBuilt.append("x");
                    if (degree != 1) {
                        polynomialBuilt.append("^").append(degree);
                    }
                }
            }
        }
        return polynomialBuilt.toString();
    }

    public void readPolynomialFromUser(String inputPolynom) {
        Matcher matcher = pattern.matcher(inputPolynom);
        while (matcher.find()) {
            String term = matcher.group();
            try {
                parseTerm(term);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
    }

    public void parseTerm(String term) throws IllegalArgumentException {
        int degree = 0;
        double coefficient = 0;

        Pattern pattern = Pattern.compile(POLYNOMIAL_PATTERN);
        Matcher matcher = pattern.matcher(term);

        if (matcher.matches()) {
            String coefficientStr = matcher.group(1);
            String degreeStr = matcher.group(2);

            if (coefficientStr != null && !coefficientStr.isEmpty()) {
                if (coefficientStr.equals("-")) {
                    coefficient = -1.0;
                } else {
                    coefficient = Double.parseDouble(coefficientStr);
                }
            } else {
                coefficient = 1.0;
            }
            if (degreeStr != null && !degreeStr.isEmpty()) {
                degree = Integer.parseInt(degreeStr);
            }
        } else {
            throw new IllegalArgumentException("invalid term: " + term);
            //throw an exception instead of just printing on the screen- good java practice:)
        }
        mergeCoefficients(degree, coefficient);
    }

    public void sortByDegree() {
        TreeMap<Integer, Double> sortedPolynomials = new TreeMap<>(Collections.reverseOrder());
        sortedPolynomials.putAll(this.polynomials);
        this.polynomials = sortedPolynomials;
    }
}
