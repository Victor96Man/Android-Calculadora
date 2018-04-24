package com.example.calculadora;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView displayText;
    private static final String DIGITOS = "0123456789.";
    private Boolean hayOperador = false;

    DecimalFormat df = new DecimalFormat("@###########");

    Calculadora mCalculadora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        mCalculadora = new Calculadora();

        displayText = (TextView) findViewById(R.id.textViewDisplay);

        df.setMinimumFractionDigits(0);
        df.setMinimumIntegerDigits(1);
        df.setMaximumIntegerDigits(8);

        findViewById(R.id.button0).setOnClickListener(this);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button9).setOnClickListener(this);

        findViewById(R.id.buttonSumar).setOnClickListener(this);
        findViewById(R.id.buttonRestar).setOnClickListener(this);
        findViewById(R.id.buttonMultiplicar).setOnClickListener(this);
        findViewById(R.id.buttonDividir).setOnClickListener(this);
        findViewById(R.id.buttonMasMenos).setOnClickListener(this);
        findViewById(R.id.buttonPunto).setOnClickListener(this);
        findViewById(R.id.buttonIgual).setOnClickListener(this);
        findViewById(R.id.buttonLimpiar).setOnClickListener(this);
        /*findViewById(R.id.buttonClearMemory).setOnClickListener(this);
        findViewById(R.id.buttonRecallMemory).setOnClickListener(this);*/

        // The following buttons only exist in layout-land (Landscape mode) and require extra attention.
        // The messier option is to place the buttons in the regular layout too and set android:visibility="invisible".
        if (findViewById(R.id.buttonRaiz) != null) {
            findViewById(R.id.buttonRaiz).setOnClickListener(this);
        }
        if (findViewById(R.id.buttonElevado) != null) {
            findViewById(R.id.buttonElevado).setOnClickListener(this);
        }
        if (findViewById(R.id.buttonInvertir) != null) {
            findViewById(R.id.buttonInvertir).setOnClickListener(this);
        }
        if (findViewById(R.id.buttonSin) != null) {
            findViewById(R.id.buttonSin).setOnClickListener(this);
        }
        if (findViewById(R.id.buttonCos) != null) {
            findViewById(R.id.buttonCos).setOnClickListener(this);
        }
        if (findViewById(R.id.buttonTan) != null) {
            findViewById(R.id.buttonTan).setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {

        String buttonPresionado = ((Button) v).getText().toString();

        if (DIGITOS.contains(buttonPresionado)) {

            if (hayOperador) {

                if (buttonPresionado.equals(".") && displayText.getText().toString().contains(".")) {

                } else {
                    displayText.append(buttonPresionado);
                }

            } else {

                if (buttonPresionado.equals(".")) {
                    displayText.setText(0 + buttonPresionado);
                } else {
                    displayText.setText(buttonPresionado);
                }

                hayOperador = true;
            }

        } else {
            if (hayOperador) {

                mCalculadora.setOperand(Double.parseDouble(displayText.getText().toString()));
                hayOperador = false;
            }

            mCalculadora.performOperation(buttonPresionado);
            displayText.setText(df.format(mCalculadora.getResult()));

        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("OPERAND", mCalculadora.getResult());
        outState.putDouble("MEMORY", mCalculadora.getMemory());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCalculadora.setOperand(savedInstanceState.getDouble("OPERAND"));
        mCalculadora.setMemory(savedInstanceState.getDouble("MEMORY"));
        displayText.setText(df.format(mCalculadora.getResult()));
    }

}