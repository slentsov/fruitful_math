package slentsov.com.fruitfulmath

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    var userAnswer: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        prepareNewCondition()
    }

    fun onNumberButtonClick(view: View) {
        if(view is Button) {
            val buttonValue = Integer.parseInt(view.text.toString())
            userAnswer = userAnswer.plus(buttonValue)
            showUpdatedUserAnswer()
        }

    }

    fun onEnterButtonClick(view: View) {
        val leftNumber : Int = Integer.parseInt((findViewById(R.id.leftNumber) as TextView).text.toString())
        val rightNumber : Int = Integer.parseInt((findViewById(R.id.rightNumber) as TextView).text.toString())
        val result : Int = rightNumber * leftNumber
        val userIsRight : Boolean = result.equals(Integer.parseInt(userAnswer))

        changeFrameColor(userIsRight)
        refreshUserAnswer()
        prepareNewCondition()
    }

    fun onBackspaceButtonClick(view: View) {
        userAnswer = userAnswer.subSequence(0, userAnswer.length - 1).toString()
        (findViewById(R.id.userAnswer) as TextView).text = userAnswer
    }

    private fun prepareNewCondition() {
        (findViewById(R.id.leftNumber) as TextView).text = Random().nextInt(100).toString()
        (findViewById(R.id.rightNumber) as TextView).text = Random().nextInt(100).toString()

    }

    private fun showUpdatedUserAnswer() {
        val resultField : TextView = findViewById(R.id.userAnswer) as TextView
        resultField.text = userAnswer
    }

    private fun changeFrameColor(userIsRight : Boolean) {
        val frame : RelativeLayout = findViewById(R.id.condition) as RelativeLayout

        if (userIsRight) {
            frame.setBackgroundColor(2)
        } else {
            frame.setBackgroundColor(250)
        }
    }

    private fun refreshUserAnswer() {
        userAnswer = ""
        (findViewById(R.id.userAnswer) as TextView).text = ""
    }
}
