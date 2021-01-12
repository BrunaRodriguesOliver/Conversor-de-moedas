package com.example.conversor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.conversor.R.id.button_clear;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Instancia de ViewHolder
    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //inicializa a activity
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValue = findViewById(R.id.edit_value);
        this.mViewHolder.textDolar = findViewById(R.id.text_dolar);
        this.mViewHolder.textEuro = findViewById(R.id.text_euro);
        this.mViewHolder.buttonCalculate = findViewById(R.id.button_calculate);
        this.mViewHolder.buttonClear = findViewById(R.id.button_clear);

        this.mViewHolder.buttonCalculate.setOnClickListener(this);

        this.mViewHolder.buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearValues(v);
            }
        });
    }


    @Override
    public void onClick(View v) {
        //se textEdit for vazia
        if (v.getId() == R.id.button_calculate){
            //busca o valor digitado
            String value = this.mViewHolder.editValue.getText().toString();
            if ("".equals(value)){
                //imprime a notificação: toast notification(contexto, sequencia de chare duração na tela)
                Toast.makeText(this, this.getString(R.string.informe_valor), Toast.LENGTH_LONG).show();
            } else {
                //converte de string para double
                Float real = Float.valueOf(value);
                this.mViewHolder.textDolar.setText(String.format("%.2f", (real * 5.46)));
                this.mViewHolder.textEuro.setText(String.format("%.2f", (real * 6.44)));
            }
        }
    }


    public void clearValues(View v) {
        if (v.getId() == button_clear){
            this.mViewHolder.textDolar.setText("");
            this.mViewHolder.textEuro.setText("");
            this.mViewHolder.editValue.setText("");
        }
    }


    private static class ViewHolder{
        EditText editValue;
        TextView textDolar;
        TextView textEuro;
        Button buttonCalculate;
        Button buttonClear;
    }
}