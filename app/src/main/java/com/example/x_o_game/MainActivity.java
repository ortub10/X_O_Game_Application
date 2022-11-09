package com.example.x_o_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.MessageFormat;

public class MainActivity extends AppCompatActivity {
    int num = 9;
    String current = "X";
    TextView turnTv;
    TextView winnerTv;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button resetBtn = findViewById(R.id.reset_btn);
        resetBtn.setOnClickListener(view -> {
            num = 9;
            current = "X";
            turnTv.setText(getString(R.string.x_it_is_your_turn));
            winnerTv.setText("");
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            b9.setText("");
        });

        turnTv = findViewById(R.id.turn_text);
        winnerTv = findViewById(R.id.winner_tv);
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        b4 = findViewById(R.id.btn4);
        b5 = findViewById(R.id.btn5);
        b6 = findViewById(R.id.btn6);
        b7 = findViewById(R.id.btn7);
        b8 = findViewById(R.id.btn8);
        b9 = findViewById(R.id.btn9);

        chane cg = new chane();
        b1.setOnClickListener(cg);
        b2.setOnClickListener(cg);
        b3.setOnClickListener(cg);
        b4.setOnClickListener(cg);
        b5.setOnClickListener(cg);
        b6.setOnClickListener(cg);
        b7.setOnClickListener(cg);
        b8.setOnClickListener(cg);
        b9.setOnClickListener(cg);
    }
    private class chane implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if(num>0) {
                if (!((Button) v).getText().toString().equals("X") && !((Button) v).getText().toString().equals("O")) {
                    ((Button) v).setText(current);
                    String temp  = current;
                    current = current.equals("X")?"O":"X";
                    turnTv.setText(MessageFormat.format("{0} {1}", current, getString(R.string.it_is_your_turn)));
                    num--;

                   if (checkWin(temp)){
                       num = -1;
                       winnerTv.setText(MessageFormat.format("{0} {1}", temp, getString(R.string.you_won)));
                       turnTv.setText(getString(R.string.game_over));
                   }

                    if (num == 0){
                        winnerTv.setText(getString(R.string.drew));
                        turnTv.setText(getString(R.string.game_over));
                    }

                }
            }
        }

        private boolean checkWin(String sign){
            return  (b1.getText().toString().equals(b2.getText().toString()) && b2.getText().toString().equals(b3.getText().toString()) && b3.getText().toString().equals(sign)
            || b4.getText().toString().equals(b5.getText().toString()) && b5.getText().toString().equals(b6.getText().toString()) && b6.getText().toString().equals(sign)
            || b7.getText().toString().equals(b8.getText().toString()) && b8.getText().toString().equals(b9.getText().toString()) && b9.getText().toString().equals(sign)
            || b1.getText().toString().equals(b4.getText().toString()) && b4.getText().toString().equals(b7.getText().toString()) && b7.getText().toString().equals(sign)
            || b2.getText().toString().equals(b5.getText().toString()) && b5.getText().toString().equals(b8.getText().toString()) && b8.getText().toString().equals(sign)
            || b3.getText().toString().equals(b6.getText().toString()) && b6.getText().toString().equals(b9.getText().toString()) && b9.getText().toString().equals(sign)
            || b1.getText().toString().equals(b5.getText().toString()) && b5.getText().toString().equals(b9.getText().toString()) && b9.getText().toString().equals(sign)
            || b3.getText().toString().equals(b5.getText().toString()) && b5.getText().toString().equals(b7.getText().toString()) && b7.getText().toString().equals(sign));

        }
    }
}