package com.example.calculator_new

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvsec = findViewById<TextView>(R.id.idTVSecondary)
        val tvMain = findViewById<TextView>(R.id.idTVprimary)
        val bac = findViewById<Button>(R.id.bac)
        val bc = findViewById<Button>(R.id.bc)
        val bbrac1 = findViewById<Button>(R.id.bbrac1)
        val bbrac2 = findViewById<Button>(R.id.bbrac2)
        val bsin = findViewById<Button>(R.id.bsin)
        val bcos = findViewById<Button>(R.id.bcos)
        val btan = findViewById<Button>(R.id.btan)
        val blog = findViewById<Button>(R.id.blog)
        val bln = findViewById<Button>(R.id.bln)
        val bfact = findViewById<Button>(R.id.bfact)
        val bsquare = findViewById<Button>(R.id.bsquare)
        val bsqrt = findViewById<Button>(R.id.bsqrt)
        val binv = findViewById<Button>(R.id.binv)
        val b0 = findViewById<Button>(R.id.b0)
        val b9 = findViewById<Button>(R.id.b9)
        val b8 = findViewById<Button>(R.id.b8)
        val b7 = findViewById<Button>(R.id.b7)
        val b6 = findViewById<Button>(R.id.b6)
        val b5 = findViewById<Button>(R.id.b5)
        val b4 = findViewById<Button>(R.id.b4)
        val b3 = findViewById<Button>(R.id.b3)
        val b2 = findViewById<Button>(R.id.b2)
        val b1 = findViewById<Button>(R.id.b1)
        val bpi = findViewById<Button>(R.id.bpi)
        val bmul = findViewById<Button>(R.id.bmul)
        val bminus = findViewById<Button>(R.id.bminus)
        val bplus = findViewById<Button>(R.id.bplus)
        val bequal = findViewById<Button>(R.id.bequal)
        val bdot = findViewById<Button>(R.id.bdot)
        val bdiv = findViewById<Button>(R.id.bdiv)

        b1.setOnClickListener {
            tvMain.text = (tvMain.text.toString() + "1")

        }
        b2.setOnClickListener {
            tvMain.text = (tvMain.text.toString() + "2")

        }
        b3.setOnClickListener {
            tvMain.text = (tvMain.text.toString() + "3")

        }
        b4.setOnClickListener {
            tvMain.text = (tvMain.text.toString() + "4")

        }
        b5.setOnClickListener {
            tvMain.text = (tvMain.text.toString() + "5")

        }
        b6.setOnClickListener {
            tvMain.text = (tvMain.text.toString() + "6")

        }
        b7.setOnClickListener {
            tvMain.text = (tvMain.text.toString() + "7")

        }
        b8.setOnClickListener {
            tvMain.text = (tvMain.text.toString() + "8")

        }
        b9.setOnClickListener {
            tvMain.text = (tvMain.text.toString() + "9")

        }
        b0.setOnClickListener {
            tvMain.text = (tvMain.text.toString() + "0")
        }
        bdot.setOnClickListener {
            tvMain.text = (tvMain.text.toString() + ".")
        }
        bplus.setOnClickListener {
            tvMain.text = (tvMain.text.toString() + "+")
        }
        bdiv.setOnClickListener {
            tvMain.text = (tvMain.text.toString() + "/")
        }
        bbrac1.setOnClickListener {
            tvMain.text = (tvMain.text.toString() + "(")
        }
        bbrac2.setOnClickListener {
            tvMain.text = (tvMain.text.toString() + ")")
        }
        bpi.setOnClickListener {
            tvMain.text=(tvMain.text.toString()+"3.14")
            tvsec.text=(bpi.text.toString())
        }
        bsin.setOnClickListener {
            tvMain.text = (tvMain.text.toString() + "sin")
        }
        bcos.setOnClickListener {
            tvMain.text = (tvMain.text.toString() + "cos")
        }
        btan.setOnClickListener {
            tvMain.text = (tvMain.text.toString() + "tan")
        }
        binv.setOnClickListener {
            tvMain.text = (tvMain.text.toString() + "^" + "(-1)")
        }
        bln.setOnClickListener {
            tvMain.text = (tvMain.text.toString() + "ln")
        }
        blog.setOnClickListener {
            tvMain.text = (tvMain.text.toString() + "log")
        }
        bminus.setOnClickListener {
            val str: String =tvMain.text.toString()
            if (!str.get(index=str.length - 1).equals("-")){
                tvMain.text=(tvMain.text.toString() + "-")
            }
        }
        bmul.setOnClickListener {
            val str: String =tvMain.text.toString()
            if(!str.get(index=str.length-1).equals("*")){
                tvMain.text=(tvMain.text.toString()+"*")
            }
        }
        bsqrt.setOnClickListener {
            if(tvMain.text.toString().isEmpty()) {
                Toast.makeText(this,"Please enter a valid number..", Toast.LENGTH_SHORT).show()
            }
        }

        bequal.setOnClickListener {
            val str: String = tvMain.text.toString()
            val result: Double = evaluate(str)
            val r = result.toString()
            tvMain.text = r
            tvsec.text=str

        }
        bac.setOnClickListener {
            tvMain.text = ""
            tvsec.text=""
        }
        bc.setOnClickListener {
            var str: String =tvMain.text.toString()
            if(!str.equals("")){
                str=str.substring(0, str.length - 1)
                tvMain.text=str
            }
        }
        bsquare.setOnClickListener {
            if(tvMain.text.toString().isEmpty()){
                Toast.makeText(this,"Please enter a valid number..", Toast.LENGTH_SHORT).show()
            }else{
                val d: Double = tvMain.text.toString().toDouble()
                val square = d * d
                val s=square.toString()
                tvMain.text=s
                tvsec.text="$d^2"

            }
        }

        bfact.setOnClickListener {
            if (tvMain.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter a valid number..", Toast.LENGTH_SHORT).show()
            } else {
                val value: Int = tvMain.text.toString().toInt()
                val fact: Int = factorial(value)
                tvMain.text = fact.toString()
                tvsec.text = "$value`!"
            }
        }
    }

    fun factorial(n: Int): Int {
        return if (n == 1 || n == 0) 1 else n * factorial(n - 1)
    }

    fun evaluate(str: String): Double {
        return object : Any() {
            var pos = -1
            var ch = 0

            fun nextChar() {
                ch = if (++pos < str.length) str[pos].toInt() else -1
            }

            fun eat(charToEat: Int): Boolean {
                while (ch == ' '.toInt()) nextChar()
                if (ch == charToEat) {
                    nextChar()
                    return true
                }
                return false
            }

            fun parse(): Double {
                nextChar()
                val x = parseExpression()
                if (pos < str.length) throw RuntimeException("Unexpected: " + ch.toChar())
                return x
            }

            fun parseExpression(): Double {
                var x = parseTerm()
                while (true) {
                    if (eat('+'.toInt())) x += parseTerm()
                    else if (eat('-'.toInt())) x -= parseTerm()
                    else return x
                }
            }

            fun parseTerm(): Double {
                var x = parseFactor()
                while (true) {
                    if (eat('*'.toInt())) x *= parseFactor()
                    else if (eat('/'.toInt())) x /= parseFactor()
                    else return x
                }
            }

            fun parseFactor(): Double {
                if (eat('+'.toInt())) return parseFactor()
                if (eat('-'.toInt())) return -parseFactor()
                var x: Double
                val startPos = pos
                if (eat('('.toInt())) {
                    x = parseExpression()
                    eat(')'.toInt())
                } else if (ch >= '0'.toInt() && ch <= '9'.toInt() || ch == '.'.toInt()) {
                    while (ch >= '0'.toInt() && ch <= '9'.toInt() || ch == '.'.toInt()) nextChar()
                    x = str.substring(startPos, pos).toDouble()
                } else if (ch >= 'a'.toInt() && ch <= 'z'.toInt()) {
                    while (ch >= 'a'.toInt() && ch <= 'z'.toInt()) nextChar()
                    val func = str.substring(startPos, pos)
                    x = parseFactor()
                    x = when {
                        func == "sqrt" -> Math.sqrt(x)
                        func == "sin" -> Math.sin(Math.toRadians(x))
                        func == "cos" -> Math.cos(Math.toRadians(x))
                        func == "tan" -> Math.tan(Math.toRadians(x))
                        func == "log" -> Math.log10(x)
                        func == "ln" -> Math.log(x)
                        else -> throw RuntimeException("Unknown function: $func")
                    }
                } else {
                    throw RuntimeException("Unexpected: " + ch.toChar())
                }
                if (eat('^'.toInt())) x = Math.pow(x, parseFactor())
                return x
            }
        }.parse()
    }
}
