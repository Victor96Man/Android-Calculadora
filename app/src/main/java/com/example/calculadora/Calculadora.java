package com.example.calculadora;


public class Calculadora {
   
    private double mOperado;
    private double mEsperaOperado;
    private String mEsperaOperador;
    private double mCalculatorMemory;

    private static final String SUMAR = "+";
    private static final String RESTAR = "-";
    private static final String MULTIPLICAR = "*";
    private static final String DIVIDIR = "/";

    private static final String LIMPIAR = "C";
    private static final String RAIZ = "√";
    private static final String ELEVADO = "x²";
    private static final String INVERTIR = "1/x";
    private static final String MASMENOS = "+/-";
    private static final String SIN = "sin";
    private static final String COS = "cos";
    private static final String TAN = "tan";

    protected Calculadora() {
        mOperado = 0;
        mEsperaOperado = 0;
        mEsperaOperador = "";
        mCalculatorMemory = 0;
    }

    public void setOperand(double operand) {
        mOperado = operand;
    }

    public double getResult() {
        return mOperado;
    }

    public void setMemory(double calculatorMemory) {
        mCalculatorMemory = calculatorMemory;
    }

    public double getMemory() {
        return mCalculatorMemory;
    }

    public String toString() {
        return Double.toString(mOperado);
    }

    protected double performOperation(String operator) {

        switch (operator) {
            case LIMPIAR:
                mOperado = 0;
                mEsperaOperador = "";
                mEsperaOperado = 0;
                break;
            case RAIZ:
                mOperado = Math.sqrt(mOperado);
                break;
            case ELEVADO:
                mOperado = mOperado * mOperado;
                break;
            case INVERTIR:
                if (mOperado != 0) {
                    mOperado = 1 / mOperado;
                }
                break;
            case MASMENOS:
                mOperado = -mOperado;
                break;
            case SIN:
                mOperado = Math.sin(Math.toRadians(mOperado));
                break;
            case COS:
                mOperado = Math.cos(Math.toRadians(mOperado));
                break;
            case TAN:
                mOperado = Math.tan(Math.toRadians(mOperado));
                break;
            default:
                performWaitingOperation();
                mEsperaOperador = operator;
                mEsperaOperado = mOperado;
                break;
        }

        return mOperado;
    }

    private void performWaitingOperation() {

        switch (mEsperaOperador) {
            case SUMAR:
                mOperado = mEsperaOperado + mOperado;
                break;
            case RESTAR:
                mOperado = mEsperaOperado - mOperado;
                break;
            case MULTIPLICAR:
                mOperado = mEsperaOperado * mOperado;
                break;
            case DIVIDIR:
                if (mOperado != 0) {
                    mOperado = mEsperaOperado / mOperado;
                }
                break;
        }

    }

}
