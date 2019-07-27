package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    TextView text1;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,ba,be,bd,bm, bs ;
    boolean flag;
    boolean opFlag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        call();
        text1.setText("");
        handle();


    }
    void call(){
        text1 =findViewById(R.id.txt);
        flag = false;
        opFlag = false;
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
        b0 = findViewById(R.id.button0);
        ba = findViewById(R.id.add);
        bs = findViewById(R.id.sub);
        be = findViewById(R.id.eval);
        bd = findViewById(R.id.division);
        bm = findViewById(R.id.multiply);
    }
    void handle(){

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) {
                    clearText();
                    flag = false;
                    opFlag = false;
                }
                text1.setText(text1.getText() + "1");

            }

        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) {
                    clearText();
                    flag = false;
                    opFlag = false;
                }
                text1.setText(text1.getText() + "2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag){
                    clearText();
                    flag = false;
                    opFlag = false;
                }
                text1.setText(text1.getText() + "3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag){
                    clearText();
                    flag = false;
                    opFlag = false;
                }
                text1.setText(text1.getText() + "4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) {
                    clearText();
                    flag = false;
                    opFlag = false;
                }
                text1.setText(text1.getText() + "5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) {
                    clearText();
                    flag = false;
                    opFlag = false;
                }
                text1.setText(text1.getText() + "6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) {
                    clearText();
                    flag = false;
                    opFlag = false;
                }
                text1.setText(text1.getText() + "7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag){
                    clearText();
                    flag = false;
                    opFlag = false;
                }

                text1.setText(text1.getText() + "8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) {
                    clearText();
                    flag = false;
                    opFlag = false;
                }
                text1.setText(text1.getText() + "9");
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) {
                    clearText();
                    flag = false;
                    opFlag = false;
                }
                text1.setText(text1.getText() + "0");
            }
        });
        ba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text1.getText() != "" && !flag && !opFlag)
                {
                    text1.setText(text1.getText() + "+");
                    opFlag = true;
                }
            }
        });
        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text1.getText() != "" && !flag && !opFlag)
                    text1.setText(text1.getText() + "-");
                opFlag = true;
            }
        });
        bm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text1.getText() != "" && !flag && !opFlag)
                    text1.setText(text1.getText() + "*");
                opFlag = true;
            }
        });
        bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text1.getText() != "" && !flag && !opFlag)
                    text1.setText(text1.getText() + "/");
                opFlag = true;
            }
        });
        be.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text1.getText() != "") {
                    double ans = eval(text1.getText().toString());
                    text1.setText(Double.toString(ans));
                    flag = true;
                }
            }
        });
    }



    void clearText(){
        text1.setText("");
    }




    public double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                }  else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }
                return x;
            }
        }.parse();
    }




}
