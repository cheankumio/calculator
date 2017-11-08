package klapper.android3kotlintest;

import android.view.View;
import android.widget.TextView;

/**
 * Created by c1103304 on 2017/11/7.
 */

public class cc {
    String numberString = "";
    String Operators = "";
    double block_a = 0;
    double block_b = 0;
    TextView ans;
    public static cc c12;
    public View.OnClickListener click;


    public View.OnClickListener getClickListener() {
        click = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn_0:
                        if (numberString.length() > 0) {
                            numberString += 0;
                        }
                        break;
                    case R.id.btn_1:
                        numberString += "1";
                        ans.setText(numberString);
                        break;
                    case R.id.btn_2:
                        numberString += "2";
                        ans.setText(numberString);
                        break;
                    case R.id.btn_3:
                        numberString += "3";
                        ans.setText(numberString);
                        break;
                    case R.id.btn_4:
                        numberString += "4";
                        ans.setText(numberString);
                        break;
                    case R.id.btn_5:
                        numberString += "5";
                        ans.setText(numberString);
                        break;
                    case R.id.btn_6:
                        numberString += "6";
                        ans.setText(numberString);
                        break;
                    case R.id.btn_7:
                        numberString += "7";
                        ans.setText(numberString);
                        break;
                    case R.id.btn_8:
                        numberString += "8";
                        ans.setText(numberString);
                        break;
                    case R.id.btn_9:
                        numberString += "9";
                        ans.setText(numberString);
                        break;
                    case R.id.btn_pm://+/-

                        break;
                    case R.id.btn_float:// .
                        if (numberString.contains(".") == false)
                            numberString += ".";
                        break;
                    case R.id.btn_add:// +
                        Operators = "add";
                        scalcAns();
                        break;
                    case R.id.btn_sub:// -
                        Operators = "sub";
                        scalcAns();
                        break;
                    case R.id.btn_mul:// *
                        Operators = "mul";
                        scalcAns();
                        break;
                    case R.id.btn_div:// /
                        Operators = "div";
                        scalcAns();
                        break;
                    case R.id.btn_itr:// %
                        Operators = "itr";
                        scalcAns();
                        break;
                    case R.id.btn_ans:
                        scalcAns();
                        break;
                    case R.id.btn_clear:// clear
                        block_a = 0;
                        block_b = 0;
                        break;
                    case R.id.btn_delete:// clear
                        if (numberString.length() > 0) {
                            int size = numberString.length();
                            numberString = numberString.substring(0, size - 1);
                        }
                        break;
                }
            }
        };

        return click;
    }

    private void scalcAns() {
        numberString = numberString.length() > 0 ? numberString : "0";
        block_a = Double.parseDouble(numberString);
        numberString = "";
        if (block_b != 0) {
            // b + a
            switch (Operators) {
                case "add":
                    block_b = block_b + block_a;
                    break;
                case "sub":
                    block_b = block_b - block_a;
                    break;
                case "mul":
                    block_b = block_b * block_a;
                    break;
                case "div":
                    block_b = block_b / block_a;
                    break;
                case "itr":
                    block_b = block_b % block_a;
                    break;
            }
            Operators = "";
        } else {
            block_b = block_a;
            block_a = 0;
        }
        ans.setText("" + block_b);
    }
}
