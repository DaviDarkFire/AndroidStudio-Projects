package com.example.davi.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btOk;
        final EditText dx1E, dx2E;
        final EditText x1E, x2E, aE, mE, kE; //declara as variáveis que vão receber os valores direto do EditText
        final double[] x1 = new double[1];  //
        final double[] x2 = new double[1];  //cria as variáveis que vão receber o valor ja convertido do EditText
        final double[] a = new double[1];   //são as variáveis com as quais eu vou fazer as contas do Desvio Padrão
        final double[] m = new double[1];   //
        final double[] k = new double[1];   //
        final double[] dx1 = new double[1];   //
        final double[] dx2 = new double[1];   //

        x1E = (EditText) findViewById(R.id.x1_edit); //
        x2E = (EditText) findViewById(R.id.x2_edit); //
        dx1E = (EditText) findViewById(R.id.dx1_edit); //
        dx2E = (EditText) findViewById(R.id.dx2_edit); //
        aE = (EditText) findViewById(R.id.a_edit);   // Associa as variáveis ao EditText
        kE = (EditText) findViewById(R.id.k_edit);   //
        mE = (EditText) findViewById(R.id.m_edit);   //
        btOk = (Button) findViewById(R.id.btOk);     //

        x1E.setText(String.valueOf(0)); //
        x2E.setText(String.valueOf(0)); //
        dx1E.setText(String.valueOf(0)); //
        dx2E.setText(String.valueOf(0)); //
        aE.setText(String.valueOf(0));  //Inicializa os Edits através das variáveis com zero, (se não fizer isso da pau)
        kE.setText(String.valueOf(0));  //
        mE.setText(String.valueOf(0));  //

        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                x1[0] = Double.parseDouble(x1E.getText().toString()); //
                x2[0] = Double.parseDouble(x2E.getText().toString()); //
                dx1[0] = Double.parseDouble(dx1E.getText().toString()); //
                dx2[0] = Double.parseDouble(dx2E.getText().toString()); //
                a[0] = Double.parseDouble(aE.getText().toString());   // Pega o valor puro dos Edits e joga pras variáveis
                k[0] = Double.parseDouble(kE.getText().toString());   // de fazer as contas
                m[0] = Double.parseDouble(mE.getText().toString());   //

                double resultado, aux1Res, aux2Res;

                aux1Res = k[0]*a[0]*Math.pow(x1[0],k[0]-1)*Math.pow(x2[0], m[0]);
                aux2Res = m[0]*a[0]*Math.pow(x1[0],k[0])*Math.pow(x2[0],m[0]-1);

                resultado = Math.sqrt(Math.pow(aux1Res, 2) * Math.pow(dx1[0], 2) + Math.pow(aux2Res, 2) * Math.pow(dx2[0], 2));

                Toast.makeText(getApplicationContext(), Double.toString(resultado),
                        Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
