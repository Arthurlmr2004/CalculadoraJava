package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.security.Key;

public class CalculatorController {
    // Elementos FXML
    @FXML
    private Label output;
    @FXML
    private Label output_calc;
    @FXML
    private Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_dot, btn_plus, btn_subtraction, btn_equals, backSpace, delete, division, multiplication, module;

    // Variáveis
    private boolean calculating = false;
    private boolean hasDot = false;
    private String operator = "";
    private double number1 = 0.0;
    private double number2 = 0.0;
    private boolean outputClean = false;

    // Objetos
    CalculatorModel model = new CalculatorModel();

    // Métodos FXML
    @FXML
    protected void onProcessNumber(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();

        if (!calculating) {
            calculating = true;
            output.setText("0");
            output_calc.setText("0");
            outputClean = true;
        }

        if (outputClean) {
            output.setText("");
            outputClean = false;
        }

        output.setText(output.getText() + value);
    }

    @FXML
    protected void onProcessOperator(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();

        if (value.equals("+/-")) {
            double number = Double.parseDouble(output.getText());
            double result = model.Calculate(number, 0.0, value);
            String sResult;

            // Verifica se o resultado é inteiro
            if ((int) result - result == 0) {
                sResult = Integer.toString((int)result);
            }
            else {
                sResult = Double.toString(result);
            }

            output.setText(sResult);
            return;
        }

        if (!value.equals("=")) {
            if (operator.isEmpty()) {
                operator = value;
                number1 = Double.parseDouble(output.getText());
                output_calc.setText(output.getText() + " " + value);
                outputClean = true;
                hasDot = false;
                if (!calculating) {
                    calculating = true;
                }
            }
        }

        else {
            number2 = Double.parseDouble(output.getText());
            output_calc.setText(output_calc.getText() + " " + output.getText() + " =");

            double result = model.Calculate(number1, number2, operator);
            String sResult;

            // Verifica se o resultado é inteiro
            if ((int) result - result == 0) {
                sResult = Integer.toString((int)result);
            }
            else {
                sResult = Double.toString(result);
            }

            output.setText(sResult);
            calculating = false;
            operator = "";
            hasDot = false;
        }
    }

    @FXML
    protected void onProcessAllClean(ActionEvent event) {
        calculating = false;
        operator = "";
        output.setText("0");
        output_calc.setText("0");
        number1 = 0.0;
        number2 = 0.0;
        hasDot = false;
    }

    @FXML
    protected void onProcessClean(ActionEvent event) {
        int textLenght = output.getText().length();

        if (textLenght > 0) {
            output.setText(output.getText().substring(0, --textLenght));
        }

        if (textLenght == 0) {
            output.setText("0");
            outputClean = true;
        }
    }

    @FXML
    protected void onProcessDot(ActionEvent event) {
        String value = ((Button) event.getSource()) .getText();

        if (hasDot) {
            return ;
        }

        output.setText(output.getText() + value);
        hasDot = true;
    }

    @FXML
    protected void onProcessKeyPress(KeyEvent event) {
        System.out.println(event.getCode());

        // Número 0
        if (event.getCode().equals(KeyCode.DIGIT0) || event.getCode().equals(KeyCode.NUMPAD0)) {
            btn_0.fire();
            return;
        }

        // Número 1
        if (event.getCode().equals(KeyCode.DIGIT1) || event.getCode().equals(KeyCode.NUMPAD1)) {
            btn_1.fire();
            return;
        }

        // Número 2
        if (event.getCode().equals(KeyCode.DIGIT2) || event.getCode().equals(KeyCode.NUMPAD2)) {
            btn_2.fire();
            return;
        }

        // Número 3
        if (event.getCode().equals(KeyCode.DIGIT3) || event.getCode().equals(KeyCode.NUMPAD3)) {
            btn_3.fire();
            return;
        }

        // Número 4
        if (event.getCode().equals(KeyCode.DIGIT4) || event.getCode().equals(KeyCode.NUMPAD4)) {
            btn_4.fire();
            return;
        }

        // Número 5
        if (event.getCode().equals(KeyCode.DIGIT5) || event.getCode().equals(KeyCode.NUMPAD5)) {
            btn_5.fire();
            return;
        }

        // Número 6
        if (event.getCode().equals(KeyCode.DIGIT6) || event.getCode().equals(KeyCode.NUMPAD6)) {
            btn_6.fire();
            return;
        }

        // Número 7
        if (event.getCode().equals(KeyCode.DIGIT7) || event.getCode().equals(KeyCode.NUMPAD7)) {
            btn_7.fire();
            return;
        }

        // Número 8
        if (event.getCode().equals(KeyCode.DIGIT8) || event.getCode().equals(KeyCode.NUMPAD8)) {
            btn_8.fire();
            return;
        }

        // Número 9
        if (event.getCode().equals(KeyCode.DIGIT9) || event.getCode().equals(KeyCode.NUMPAD9)) {
            btn_9.fire();
            return;
        }

        // Ponto ou vírgula
        if (event.getCode().equals(KeyCode.PERIOD)
                || event.getCode().equals(KeyCode.COMMA)
                || event.getCode().equals(KeyCode.DECIMAL)
                || event.getCode().equals(KeyCode.UNDEFINED)) {
            btn_dot.fire();
            return;
        }

        // Soma
        if (event.getCode().equals(KeyCode.ADD)) {
            btn_plus.fire();
            return;
        }

        // Subtração
        if (event.getCode().equals(KeyCode.SUBTRACT)) {
            btn_subtraction.fire();
            return;
        }

        // Resultado
        if (event.getCode().equals(KeyCode.EQUALS)) {
            btn_equals.fire();
            return;
        }

        // Apagar um de cada vez
        if (event.getCode().equals(KeyCode.BACK_SPACE)) {
            backSpace.fire();
        }

        // Apagar tudo
        if (event.getCode().equals(KeyCode.DELETE) || event.getCode().equals(KeyCode.ESCAPE)) {
            delete.fire();
        }

        // Divisão
        if (event.getCode().equals(KeyCode.DIVIDE)) {
            division.fire();
        }

        // Multiplicação
        if (event.getCode().equals(KeyCode.MULTIPLY)) {
            multiplication.fire();
        }
    }
}