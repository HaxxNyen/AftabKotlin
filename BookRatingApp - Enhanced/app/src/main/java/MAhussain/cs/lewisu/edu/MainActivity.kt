package MAhussain.cs.lewisu.edu

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var button : Button
    private lateinit var bookRating: BookRating
    private lateinit var etRatingInfo: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val intent = intent

        if (intent.hasExtra("obj")) {
            val gson = Gson()
            val strObj = intent.getStringExtra("obj")
            bookRating = gson.fromJson(strObj, BookRating::class.java)


            etRatingInfo = findViewById(R.id.ratingInfo)

            etRatingInfo.text = bookRating.toString()
            etRatingInfo.visibility = View.VISIBLE
            Toast.makeText(this, bookRating.toString(), Toast.LENGTH_SHORT).show()


        }


        button = findViewById(R.id.button)


        button.setOnClickListener {

            val intent = Intent(this, RatingActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}