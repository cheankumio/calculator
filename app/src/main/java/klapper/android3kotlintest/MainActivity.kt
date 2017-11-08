package klapper.android3kotlintest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*
import klapper.android3kotlintest.cc;

class MainActivity : AppCompatActivity() {
    var numberString = ""
    var Operators = ""
    var oldOperators = ""
    var block_a = 0.0
    var block_b = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()


    }

    private fun initView() {
        btn_0.setOnClickListener(click)
        btn_1.setOnClickListener(click)
        btn_2.setOnClickListener(click)
        btn_3.setOnClickListener(click)
        btn_4.setOnClickListener(click)
        btn_5.setOnClickListener(click)
        btn_6.setOnClickListener(click)
        btn_7.setOnClickListener(click)
        btn_8.setOnClickListener(click)
        btn_9.setOnClickListener(click)
        btn_add.setOnClickListener(click)
        btn_sub.setOnClickListener(click)
        btn_mul.setOnClickListener(click)
        btn_div.setOnClickListener(click)
        btn_itr.setOnClickListener(click)
        btn_ans.setOnClickListener(click)
        btn_pm.setOnClickListener(click)
        btn_float.setOnClickListener(click)
        btn_clear.setOnClickListener(click)
        btn_delete.setOnClickListener(click)
    }

    val click = View.OnClickListener { view ->
        when (view.id) {
            R.id.btn_0 -> if (numberString.length > 0) {
                numberString += 0
                scale_view!!.text = numberString
                scale_view.text = numberString
            }
            R.id.btn_1 -> {
                numberString += "1"
                scale_view!!.text = numberString
            }
            R.id.btn_2 -> {
                numberString += "2"
                scale_view!!.text = numberString
            }
            R.id.btn_3 -> {
                numberString += "3"
                scale_view!!.text = numberString
            }
            R.id.btn_4 -> {
                numberString += "4"
                scale_view!!.text = numberString
            }
            R.id.btn_5 -> {
                numberString += "5"
                scale_view!!.text = numberString
            }
            R.id.btn_6 -> {
                numberString += "6"
                scale_view!!.text = numberString
            }
            R.id.btn_7 -> {
                numberString += "7"
                scale_view!!.text = numberString
            }
            R.id.btn_8 -> {
                numberString += "8"
                scale_view!!.text = numberString
            }
            R.id.btn_9 -> {
                numberString += "9"
                scale_view!!.text = numberString
            }
            R.id.btn_pm -> {
            }
            R.id.btn_float -> if (numberString.contains(".") == false)
                numberString += "."
            R.id.btn_add -> {
                Operators = "add"
                scalcAns()
            }
            R.id.btn_sub -> {
                Operators = "sub"
                scalcAns()
            }
            R.id.btn_mul -> {
                Operators = "mul"
                scalcAns()
            }
            R.id.btn_div -> {
                Operators = "div"
                scalcAns()
            }
            R.id.btn_itr -> {
                Operators = "itr"
                scalcAns()
            }
            R.id.btn_ans -> scalcAns()
            R.id.btn_clear -> {
                block_a = 0.0
                block_b = 0.0
                oldOperators =""
                Operators = ""
                numberString = ""
                scale_view!!.text = "0"
            }
            R.id.btn_delete -> if (numberString.length > 1) {
                val size = numberString.length
                numberString = numberString.substring(0, size - 1)
                scale_view!!.text = numberString
            } else {
                numberString = ""
                scale_view!!.text = "0"
            }
        }
    }

    private fun scalcAns() {
        numberString = if (numberString.length > 0) numberString else "0"
        block_a = java.lang.Double.parseDouble(numberString)
        Log.d("MYLOG", "a: " + block_a + ", b: " + block_b + ", String: " + numberString);
        numberString = ""
        if (block_b != 0.0) {
            // b + a
            when (oldOperators) {
                "add" -> block_b = block_b + block_a
                "sub" -> block_b = block_b - block_a
                "mul" -> block_b = block_b * block_a
                "div" -> block_b = block_b / block_a
                "itr" -> block_b = block_b % block_a
            }
            oldOperators = Operators;
            Operators = ""
        } else {
            oldOperators = Operators
            block_b = block_a
            block_a = 0.0
        }
        scale_view!!.text = "" + block_b
    }


}
