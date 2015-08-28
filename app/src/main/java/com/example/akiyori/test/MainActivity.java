package com.example.akiyori.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import jp.hishidama.eval.*;
import java.util.ArrayList;

//Frameに名前変える
//本体処理と設定
public class MainActivity extends AppCompatActivity  implements View.OnClickListener  {
    //ボタン格納用
    Button mButton[];
    //ボタンレイアウトID
    int mId[] = {R.id.button0, R.id.button1, R.id.button2, R.id.button3,
            R.id.button4, R.id.button5, R.id.button6, R.id.button7,
            R.id.button8, R.id.button9, R.id.button_plus, R.id.button_min,
            R.id.button_div, R.id.button_multi, R.id.button_equal, R.id.button_clear
    };
    int result = 0;
    ArrayList<String> symbol = new ArrayList<String>();

    ArrayList<Integer> number = new ArrayList<Integer>();
    int temp = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = new Button[mId.length];
        for (int i = 0; i < mId.length; i++) {
            // buttonを取り込む
            mButton[i] = (Button) findViewById(mId[i]);
            // buttonのイベント処理
            mButton[i].setOnClickListener(this);
        }
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
static final int safeMultiply(int left, int right) throws ArithmeticException {
    if (right > 0 ? left > Integer.MAX_VALUE/right || left < Integer.MIN_VALUE/right :
            (right < -1 ? left > Integer.MIN_VALUE/right || left < Integer.MAX_VALUE/right :
                    right == -1 && left == Integer.MIN_VALUE) ) {
        throw new ArithmeticException("Integer overflow");


    }
    return left * right;
}

    public void onClick(View view) {
        TextView textView = (TextView) findViewById(R.id.count_text);
        // 押されたボタンがどのボタンかを判定
        // CLEAR
        if (view == mButton[15]) {
            textView.setText("");
            result = 0;
            temp = 0;
            symbol.clear();
            number.clear();
        }
        // =
        else if (view == mButton[14]) {
            number.add(temp);
            StringBuilder buf = new StringBuilder();
            for (int j = 0; j < symbol.size(); j++) {
                if (symbol.isEmpty()) {
                    textView.setText("error");
                } else {
                    buf.append(Integer.toString(number.get(j)));
                    buf.append(symbol.get(j));
                }
            }

            buf.append(number.get(symbol.size()));

            Rule rule = ExpRuleFactory.getDefaultRule();
            Expression exp = rule.parse(buf.toString());    //解析
            textView.setText(buf.toString());
            long result = exp.evalLong();        //計算実施

            textView.setText(Long.toString(result));
        }
        // *
        else if (view == mButton[13]) {
            textView.setText("*");
            number.add(temp);
            symbol.add("*");
            temp = 0;

        }
        // /
        else if (view == mButton[12]) {
            textView.setText("/");
            number.add(temp);
            symbol.add("/");
            temp = 0;
        }
        // -
        else if (view == mButton[11]) {

            textView.setText("-");
            number.add(temp);
            symbol.add("-");




            temp = 0;


        }
        // +
        else if (view == mButton[10]) {
            textView.setText("+");
            number.add(temp);
            symbol.add("+");
            temp = 0;
        }
        // 数字
        else {
            switch (view.getId()) {
                case R.id.button0:
                    String value0 = mButton[0].getText().toString();
                    textView.setText(value0);
                    if (temp == 0 && number.isEmpty()) {
                        temp =  0;
                    } else {
                        if (!symbol.isEmpty()) {
                            if(temp!=0){
                                try
                                {
                                    temp=safeMultiply(temp,10)+0;
                                }
                                catch (Exception ex)
                                {
                                    textView.setText("error");
                                }
                                textView.setText(Integer.toString(temp));
                            }else{
                                temp =  0;
                            }
                        } else {
                            try
                            {
                                temp=safeMultiply(temp,10)+0;
                            }
                            catch (Exception ex)
                            {
                                textView.setText("error");
                            }
                            textView.setText(Integer.toString(temp));
                        }
                    }
                    break;
                case R.id.button1:
                    String value1 = mButton[1].getText().toString();
                    textView.setText(value1);
                    if (temp == 0 && number.isEmpty()) {
                        temp =  1;
                    } else {
                        if (!symbol.isEmpty()) {
                            if(temp!=0){
                                try
                                {
                                    temp=safeMultiply(temp,10)+1;
                                }
                                catch (Exception ex)
                                {
                                    textView.setText("error");
                                }
                                textView.setText(Integer.toString(temp));
                            }else{
                                temp =  1;
                            }
                        } else {
                            try
                            {
                                temp=safeMultiply(temp,10)+1;
                            }
                            catch (Exception ex)
                            {
                                textView.setText("error");
                            }
                            textView.setText(Integer.toString(temp));
                        }
                    }
                    break;
                case R.id.button2:
                    String value2 = mButton[2].getText().toString();
                    textView.setText(value2);
                    if (temp == 0 && number.isEmpty() ) {
                        temp =  2;
                    } else {
                        if (!symbol.isEmpty()) {
                            if(temp!=0){
                                try
                                {
                                    temp=safeMultiply(temp,10)+2;
                                }
                                catch (Exception ex)
                                {
                                    textView.setText("error");
                                }
                                textView.setText(Integer.toString(temp));
                            }else{
                                temp =  2;
                            }
                        } else {
                            try
                            {
                                temp=safeMultiply(temp,10)+2;
                            }
                            catch (Exception ex)
                            {
                                textView.setText("error");
                            }
                                textView.setText(Integer.toString(temp));
                        }
                    }
                    break;
                case R.id.button3:
                    String value3 = mButton[3].getText().toString();
                    textView.setText(value3);
                    if (temp == 0 && number.isEmpty()) {
                        temp =  3;
                    } else {
                        if (!symbol.isEmpty()) {
                            if(temp!=0){
                                try
                                {
                                    temp=safeMultiply(temp,10)+3;
                                }
                                catch (Exception ex)
                                {
                                    textView.setText("error");
                                }
                                textView.setText(Integer.toString(temp));
                            }else{
                                temp =  3;
                            }
                        } else {
                            try
                            {
                                temp=safeMultiply(temp,10)+3;
                            }
                            catch (Exception ex)
                            {
                                textView.setText("error");
                            }
                            textView.setText(Integer.toString(temp));
                        }
                    }
                    break;
                case R.id.button4:
                    String value4 = mButton[4].getText().toString();
                    textView.setText(value4);
                    if (temp == 0 && number.isEmpty()) {
                        temp = 4;
                    } else {
                        if (!symbol.isEmpty()) {
                            if(temp!=0){
                                try
                                {
                                    temp=safeMultiply(temp,10)+4;
                                }
                                catch (Exception ex)
                                {
                                    textView.setText("error");
                                }
                                textView.setText(Integer.toString(temp));
                            }else{
                                temp =  4;
                            }
                        } else {
                            try
                            {
                                temp=safeMultiply(temp,10)+4;
                            }
                            catch (Exception ex)
                            {
                                textView.setText("error");
                            }
                            textView.setText(Integer.toString(temp));
                        }
                    }
                    break;
                case R.id.button5:
                    String value5 = mButton[5].getText().toString();
                    textView.setText(value5);
                    if (temp == 0 && number.isEmpty()) {
                        temp =  5;
                    } else {
                        if (!symbol.isEmpty()) {
                            if(temp!=0){
                                try
                                {
                                    temp=safeMultiply(temp,10)+5;
                                }
                                catch (Exception ex)
                                {
                                    textView.setText("error");
                                }
                                textView.setText(Integer.toString(temp));
                            }else{
                                temp =  5;
                            }
                        } else {
                            try
                            {
                                temp=safeMultiply(temp,10)+5;
                            }
                            catch (Exception ex)
                            {
                                textView.setText("error");
                            }
                            textView.setText(Integer.toString(temp));
                        }
                    }
                    break;
                case R.id.button6:
                    String value6 = mButton[6].getText().toString();
                    textView.setText(value6);
                    if (temp == 0 && number.isEmpty()) {
                        temp =  6;
                    } else {
                        if (!symbol.isEmpty()) {
                            if(temp!=0){
                                try
                                {
                                    temp=safeMultiply(temp,10)+6;
                                }
                                catch (Exception ex)
                                {
                                    textView.setText("error");
                                }
                                textView.setText(Integer.toString(temp));
                            }else{
                                temp =  6;
                            }
                        } else {
                            try
                            {
                                temp=safeMultiply(temp,10)+6;
                            }
                            catch (Exception ex)
                            {
                                textView.setText("error");
                            }
                            textView.setText(Integer.toString(temp));
                        }
                    }
                    break;
                case R.id.button7:
                    String value7 = mButton[7].getText().toString();
                    textView.setText(value7);
                    if (temp == 0 && number.isEmpty()) {
                        temp =  7;
                    } else {
                        if (!symbol.isEmpty()) {
                            if(temp!=0){
                                try
                                {
                                    temp=safeMultiply(temp,10)+7;
                                }
                                catch (Exception ex)
                                {
                                    textView.setText("error");
                                }
                                textView.setText(Integer.toString(temp));
                            }else {
                                temp = 7;
                            }
                        } else {
                            try
                            {
                                temp=safeMultiply(temp,10)+7;
                            }
                            catch (Exception ex)
                            {
                                textView.setText("error");
                            }
                            textView.setText(Integer.toString(temp));
                        }
                    }
                    break;
                case R.id.button8:
                    String value8 = mButton[8].getText().toString();
                    textView.setText(value8);
                    if (temp == 0 && number.isEmpty()) {
                        temp =  8;
                    } else {
                        if (!symbol.isEmpty()) {
                            if(temp!=0){
                                try
                                {
                                    temp=safeMultiply(temp,10)+8;
                                }
                                catch (Exception ex)
                                {
                                    textView.setText("error");
                                }
                                textView.setText(Integer.toString(temp));
                            }else{
                                temp =  8;
                            }
                        } else {
                            try
                            {
                                temp=safeMultiply(temp,10)+8;
                            }
                            catch (Exception ex)
                            {
                                textView.setText("error");
                            }
                            textView.setText(Integer.toString(temp));
                        }
                    }
                    break;
                case R.id.button9:
                    String value9 = mButton[9].getText().toString();
                    textView.setText(value9);
                    if (temp == 0 && number.isEmpty()) {
                        temp =  9;
                    } else {
                        if (!symbol.isEmpty()) {
                            if(temp!=0){
                                try
                                {
                                    temp=safeMultiply(temp,10)+9;
                                }
                                catch (Exception ex)
                                {
                                    textView.setText("error");
                                }
                                textView.setText(Integer.toString(temp));
                            }else{
                                temp =  9;
                            }
                        } else {
                            try
                            {
                                temp=safeMultiply(temp,10)+9;
                            }
                            catch (Exception ex)
                            {
                                textView.setText("error");
                            }
                            textView.setText(Integer.toString(temp));
                        }
                    }
                    break;
            }
        }
    }
}

