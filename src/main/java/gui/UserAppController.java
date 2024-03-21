package gui;
import datamodels.Polynomial;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import logic.Operations;

public class UserAppController {
    @FXML
    private TextField polynom1TextField;
    @FXML
    private TextField polynom2TextField;
    @FXML
    private Label resultLabel;
    @FXML
    private Label errorLabel;
    public void validatePolynomial(String polynomial) {
        if (polynomial.isEmpty()) {
            errorLabel.setText("Enter a polynomial!");
        }
        else if (!polynomial.matches("^[+-]?(?:(?:\\d*x\\^\\d+|\\d*x|\\d+)(?:[+-](?:\\d*x\\^\\d+|\\d*x|\\d+))*)(?![^\\^\\d\\+\\-])")) {
            errorLabel.setText("Polynomial format: coeff1x^deg1 + coeff2x^deg2 + ... + coeffnx^degn");
        }
        else {
            errorLabel.setText("");
        }
    }
    @FXML
    public void addButtonOnAction() {
        String polynomial1 = polynom1TextField.getText();
        String polynomial2 = polynom2TextField.getText();
        validatePolynomial(polynomial1);
        validatePolynomial(polynomial2);

        if (errorLabel.getText().isEmpty()) {
            try {
                Polynomial p1 = new Polynomial();
                p1.readPolynomialFromUser(polynomial1);
                Polynomial p2 = new Polynomial();
                p2.readPolynomialFromUser(polynomial2);

                Polynomial result = Operations.add(p1, p2);
                resultLabel.setText(result.convertString());
            } catch (IllegalArgumentException e) {
                errorLabel.setText(e.getMessage());
            }
        }
    }
    @FXML
    public void subtractButtonOnAction() {
        String polynomial1 = polynom1TextField.getText();
        String polynomial2 = polynom2TextField.getText();
        validatePolynomial(polynomial1);
        validatePolynomial(polynomial2);
        if (errorLabel.getText().isEmpty()) {
            try {
                Polynomial p1 = new Polynomial();
                p1.readPolynomialFromUser(polynomial1);
                Polynomial p2 = new Polynomial();
                p2.readPolynomialFromUser(polynomial2);
                Polynomial result = Operations.subtract(p1, p2);
                resultLabel.setText(result.convertString());
            } catch (IllegalArgumentException e) {
                errorLabel.setText(e.getMessage());
            }
        }
    }
    @FXML
    public void multiplyButtonOnAction() {
        String polynomial1 = polynom1TextField.getText();
        String polynomial2 = polynom2TextField.getText();
        validatePolynomial(polynomial1);
        validatePolynomial(polynomial2);
        if (errorLabel.getText().isEmpty()) {
            try {
                Polynomial p1 = new Polynomial();
                p1.readPolynomialFromUser(polynomial1);
                Polynomial p2 = new Polynomial();
                p2.readPolynomialFromUser(polynomial2);
                Polynomial result = Operations.multiply(p1, p2);
                resultLabel.setText(result.convertString());
            } catch (IllegalArgumentException e) {
                errorLabel.setText(e.getMessage());
            }
        }
    }
    @FXML
    public void divideButtonOnAction() {
        String polynomial1 = polynom1TextField.getText();
        String polynomial2 = polynom2TextField.getText();
        validatePolynomial(polynomial1);
        validatePolynomial(polynomial2);
        if (errorLabel.getText().isEmpty()) {
            try {
                Polynomial p1 = new Polynomial();
                p1.readPolynomialFromUser(polynomial1);
                Polynomial p2 = new Polynomial();
                p2.readPolynomialFromUser(polynomial2);
               errorLabel.setText("Division is not implemented yet :(");
            } catch (IllegalArgumentException e) {
                errorLabel.setText(e.getMessage());
            }
        }
    }
    @FXML
    public void derivateButtonP1OnAction() {
        String polynomial1 = polynom1TextField.getText();
        validatePolynomial(polynomial1);
        if (errorLabel.getText().isEmpty()) {
            try {
                Polynomial p1 = new Polynomial();
                p1.readPolynomialFromUser(polynomial1);
                Polynomial result = Operations.derivate(p1);
                resultLabel.setText(result.convertString());
            } catch (IllegalArgumentException e) {
                errorLabel.setText(e.getMessage());
            }
        }
    }
    @FXML
    public void derivateButtonP2OnAction() {
        String polynomial2 = polynom2TextField.getText();
        validatePolynomial(polynomial2);
        if (errorLabel.getText().isEmpty()) {
            try {
                Polynomial p2 = new Polynomial();
                p2.readPolynomialFromUser(polynomial2);
                Polynomial result = Operations.derivate(p2);
                resultLabel.setText(result.convertString());
            } catch (IllegalArgumentException e) {
                errorLabel.setText(e.getMessage());
            }
        }
    }
    @FXML
    public void integrateButtonP1OnAction() {
        String polynomial1 = polynom1TextField.getText();
        validatePolynomial(polynomial1);
        if (errorLabel.getText().isEmpty()) {
            try {
                Polynomial p1 = new Polynomial();
                p1.readPolynomialFromUser(polynomial1);
                Polynomial result = Operations.integrate(p1);
                resultLabel.setText(result.convertString());
            } catch (IllegalArgumentException e) {
                errorLabel.setText(e.getMessage());
            }
        }
    }
    @FXML
    public void integrateButtonP2OnAction() {
        String polynomial2 = polynom2TextField.getText();
        validatePolynomial(polynomial2);
        if (errorLabel.getText().isEmpty()) {
            try {
                Polynomial p2 = new Polynomial();
                p2.readPolynomialFromUser(polynomial2);
                Polynomial result = Operations.integrate(p2);
                resultLabel.setText(result.convertString());
            } catch (IllegalArgumentException e) {
                errorLabel.setText(e.getMessage());
            }
        }
    }
    @FXML
    public void clearButtonOnAction() {
        polynom1TextField.clear();
        polynom2TextField.clear();
        errorLabel.setText("");
    }
}
