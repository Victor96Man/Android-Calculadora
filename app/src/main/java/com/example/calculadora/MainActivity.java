package com.example.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button numero1,numero2,numero3,numero4,numero5,numero6,numero7,numero8,numero9,numero0,BtDel,BtMas,BtMenos,BtDividir,BtMultiplicar,BtComa,BtIgual;
    TextView TxResultado, TxOperacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero0= (Button) findViewById(R.id.numero0);
        numero1= (Button) findViewById(R.id.numero1);
        numero2= (Button) findViewById(R.id.numero2);
        numero3= (Button) findViewById(R.id.numero3);
        numero4= (Button) findViewById(R.id.numero4);
        numero5= (Button) findViewById(R.id.numero5);
        numero6= (Button) findViewById(R.id.numero6);
        numero7= (Button) findViewById(R.id.numero7);
        numero8= (Button) findViewById(R.id.numero8);
        numero9= (Button) findViewById(R.id.numero9);
        BtComa= (Button) findViewById(R.id.BtComa);
        BtDel= (Button) findViewById(R.id.BtDel);
        BtDividir= (Button) findViewById(R.id.BtDividir);
        BtIgual= (Button) findViewById(R.id.BtIgual);
        BtMas= (Button) findViewById(R.id.BtMas);
        BtMenos= (Button) findViewById(R.id.BtMenos);
        BtMultiplicar= (Button) findViewById(R.id.BtMultiplicar);
        TxOperacion= (TextView) findViewById(R.id.TxOperacion);
        TxResultado= (TextView) findViewById(R.id.TxResultado);

        numero0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operacion = TxOperacion.getText().toString();
                TxOperacion.setText(operacion+"0");

            }
        });

        numero1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TxOperacion.setText(TxOperacion.getText().toString()+"1");
            }
        });

        numero2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TxOperacion.setText(TxOperacion.getText().toString()+"2");
            }
        });

        numero3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TxOperacion.setText(TxOperacion.getText().toString()+"3");
            }
        });

        numero4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TxOperacion.setText(TxOperacion.getText().toString()+"4");
            }
        });

        numero5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TxOperacion.setText(TxOperacion.getText().toString()+"5");
            }
        });

        numero6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TxOperacion.setText(TxOperacion.getText().toString()+"6");
            }
        });

        numero7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TxOperacion.setText(TxOperacion.getText().toString()+"7");
            }
        });

        numero8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TxOperacion.setText(TxOperacion.getText().toString()+"8");
            }
        });

        numero9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TxOperacion.setText(TxOperacion.getText().toString()+"9");
            }
        });



        BtComa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TxOperacion.getText().toString().equals("")) {
                    String ultimo = TxOperacion.getText().toString().substring(TxOperacion.getText().toString().length() - 1);
                    if (!ultimo.equals("x") && !ultimo.equals("-") && !ultimo.equals("/") && !ultimo.equals("+") && !ultimo.equals(".")) {
                        TxOperacion.setText(TxOperacion.getText().toString() + ".");
                    }
                }
            }
        });

        BtDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TxOperacion.getText().toString().equals("")) {
                    String ultimo = TxOperacion.getText().toString().substring(0,TxOperacion.getText().toString().length() - 1);
                    TxResultado.setText("");
                    TxOperacion.setText(ultimo);
                }
            }
        });

        BtMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TxOperacion.getText().toString().equals("")) {
                    String ultimo = TxOperacion.getText().toString().substring(TxOperacion.getText().toString().length() - 1);
                    if (!ultimo.equals("x") && !ultimo.equals("-") && !ultimo.equals("/") && !ultimo.equals("+") && !ultimo.equals(".")) {
                        TxOperacion.setText(Calcular() + "+");
                    }
                }
            }
        });

        BtMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TxOperacion.getText().toString().equals("")) {
                    String ultimo = TxOperacion.getText().toString().substring(TxOperacion.getText().toString().length() - 1);
                    if (!ultimo.equals("x") && !ultimo.equals("-") && !ultimo.equals("/") && !ultimo.equals("+") && !ultimo.equals(".")) {
                        TxOperacion.setText(Calcular() + "-");
                    }
                }
            }
        });

        BtDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TxOperacion.getText().toString().equals("")) {
                    String ultimo = TxOperacion.getText().toString().substring(TxOperacion.getText().toString().length() - 1);
                    if (!ultimo.equals("x") && !ultimo.equals("-") && !ultimo.equals("/") && !ultimo.equals("+") && !ultimo.equals(".")) {
                        TxOperacion.setText(Calcular() + "/");
                    }
                }
            }
        });

        BtMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TxOperacion.getText().toString().equals("")) {
                    String ultimo = TxOperacion.getText().toString().substring(TxOperacion.getText().toString().length() - 1);
                    if (!ultimo.equals("x") && !ultimo.equals("-") && !ultimo.equals("/") && !ultimo.equals("+") && !ultimo.equals(".")) {
                        TxOperacion.setText(Calcular() + "x");
                    }

                }
            }
        });

        BtIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TxOperacion.getText().toString().equals("")) {
                    String ultimo = TxOperacion.getText().toString().substring(TxOperacion.getText().toString().length() - 1);
                    if (!ultimo.equals("x") && !ultimo.equals("-") && !ultimo.equals("/") && !ultimo.equals("+") && !ultimo.equals(".")) {
                    TxResultado.setText(Calcular());
                    }
                }
            }
        });


    }

    public String Calcular(){

        String cadena = TxOperacion.getText().toString();
        String resultado= cadena;

        int restar = cadena.indexOf("-");
        if(restar!=-1){
            String[] parts = TxOperacion.getText().toString().split("-");
            float part1 = Float.parseFloat(parts[0]);
            float part2 = Float.parseFloat(parts[1]);
            resultado = Float.toString(part1-part2);
        }

        int sumar = cadena.indexOf("+");
        if(sumar!=-1){
           // char c = (char)43;
            String[] parts = TxOperacion.getText().toString().split("\\+");
            float part1 = Float.parseFloat(parts[0]);
            float part2 = Float.parseFloat(parts[1]);
            resultado = Float.toString(part1+part2);
        }

        int dividir = cadena.indexOf("/");
        if(dividir!=-1){
            String[] parts = TxOperacion.getText().toString().split("/");
            float part1 = Float.parseFloat(parts[0]);
            float part2 = Float.parseFloat(parts[1]);
            resultado = Float.toString(part1/part2);
        }

        int multiplicar = cadena.indexOf("x");
        if(multiplicar!=-1){
            String[] parts = TxOperacion.getText().toString().split("x");
            float part1 = Float.parseFloat(parts[0]);
            float part2 = Float.parseFloat(parts[1]);
            resultado = Float.toString(part1*part2);
        }

        return resultado;
    }
}