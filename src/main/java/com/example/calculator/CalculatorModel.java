package com.example.calculator;

public class CalculatorModel {
    // Campos ou propriedades

    // Método construtor

    // Métodos da classe ou comportamentos
    public double Calculate(double numerOne, double numberTwo, String operator) {
        switch (operator ) {
            case "+":
                return calculateAddition(numerOne, numberTwo);

            case "-":
                return calculateSubtraction(numerOne, numberTwo);

            case "X":
                return calculateMultiplication(numerOne, numberTwo);

            case "÷":
                return calculateDivision(numerOne, numberTwo);

            case "%":
                return calculateModule(numerOne, numberTwo);

            case "+/-":
                return calculateNegate(numerOne);

            default:
                System.out.println("Operador desconhecido!");
                return 0;
        }
    }

    private double calculateAddition(double num, double num2) {
        return num + num2;
    }

    private double calculateSubtraction(double num, double num2) {
        return num - num2;
    }

    private double calculateDivision(double num, double num2) {
        return (num2 == 0) ? 0 : (num / num2);
    }

    private double calculateMultiplication(double num, double num2) {
        return num * num2;
    }

    private double calculateModule(double num, double num2) {
        return num % num2;
    }

    private double calculateNegate(double num) {
        return num * (-1);
    }
}
