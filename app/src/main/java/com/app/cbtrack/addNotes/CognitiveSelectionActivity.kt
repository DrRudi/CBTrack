package com.app.cbtrack.addNotes

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import com.app.cbtrack.R

class CognitiveSelectionActivity : AppCompatActivity() {

    private lateinit var saveCognitive: Button
    private lateinit var infoCognitive: Button
    private lateinit var checkBox2: CheckBox
    private lateinit var checkBox3: CheckBox
    private lateinit var checkBox4: CheckBox
    private lateinit var checkBox5: CheckBox
    private lateinit var checkBox6: CheckBox
    private lateinit var checkBox7: CheckBox
    private lateinit var checkBox8: CheckBox
    private lateinit var checkBox9: CheckBox
    private lateinit var checkBox10: CheckBox
    private lateinit var checkBox11: CheckBox
    private lateinit var checkBox12: CheckBox
    private lateinit var checkBox13: CheckBox
    private lateinit var checkBox14: CheckBox
    private lateinit var checkBox15: CheckBox
    private lateinit var checkBox16: CheckBox
    private lateinit var checkBox17: CheckBox
    private lateinit var checkBox18: CheckBox
    private var str: String? = ""


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cognitive_selection)

        saveCognitive = findViewById(R.id.save_cognitive_button)
        infoCognitive = findViewById(R.id.cognitive_info_button)
        checkBox2 = findViewById(R.id.checkBox2)
        checkBox3 = findViewById(R.id.checkBox3)
        checkBox4 = findViewById(R.id.checkBox4)
        checkBox5 = findViewById(R.id.checkBox5)
        checkBox6 = findViewById(R.id.checkBox6)
        checkBox7 = findViewById(R.id.checkBox7)
        checkBox8 = findViewById(R.id.checkBox8)
        checkBox9 = findViewById(R.id.checkBox9)
        checkBox10 = findViewById(R.id.checkBox10)
        checkBox11 = findViewById(R.id.checkBox11)
        checkBox12 = findViewById(R.id.checkBox12)
        checkBox13 = findViewById(R.id.checkBox13)
        checkBox14 = findViewById(R.id.checkBox14)
        checkBox15 = findViewById(R.id.checkBox15)
        checkBox16 = findViewById(R.id.checkBox16)
        checkBox17 = findViewById(R.id.checkBox17)
        checkBox18 = findViewById(R.id.checkBox18)

        saveCognitive.setOnClickListener {

            if (checkBox2.isChecked) {
                str += "Чтение мыслей. "
            }
            if (checkBox3.isChecked) {
                str += "Предсказание будущего. "
            }
            if (checkBox4.isChecked) {
                str += "Катастрофизация. "
            }
            if (checkBox5.isChecked) {
                str += "Наклеивание ярлыков. "
            }
            if (checkBox6.isChecked) {
                str += "Девальвация позитива. "
            }
            if (checkBox7.isChecked) {
                str += "Негативный фильтр. "
            }
            if (checkBox8.isChecked) {
                str += "Сверхгенерализация. "
            }
            if (checkBox9.isChecked) {
                str += "Дихотомическое мышление. "
            }
            if (checkBox10.isChecked) {
                str += "Долженствование. "
            }
            if (checkBox11.isChecked) {
                str += "Персонализация. "
            }
            if (checkBox12.isChecked) {
                str += "Обвинение. "
            }
            if (checkBox13.isChecked) {
                str += "Неадекватные сравнения. "
            }
            if (checkBox14.isChecked) {
                str += "Ориентация сожаления. "
            }
            if (checkBox15.isChecked) {
                str += "Что если? "
            }
            if (checkBox16.isChecked) {
                str += "Эмоциональное мышление. "
            }
            if (checkBox17.isChecked) {
                str += "Невозможность опровержения. "
            }
            if (checkBox18.isChecked) {
                str += "Фокусирование на оценке. "
            }
            val replyIntent = Intent()
            replyIntent.putExtra("cognitive", str)
            setResult(Activity.RESULT_OK, replyIntent)
            finish()
        }

        infoCognitive.setOnClickListener {
            val intent = Intent(this@CognitiveSelectionActivity, CognitiveInfoActivity::class.java)
            startActivity(intent)
        }
    }
}