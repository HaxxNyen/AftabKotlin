package MAhussain.cs.lewisu.edu

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson

class RatingActivity : AppCompatActivity() {


    private lateinit var rGroup: RadioGroup
    private lateinit var button : Button
    private lateinit var etTitle : EditText
    private lateinit var etAuthor : EditText
    private lateinit var etComment : EditText
    private lateinit var category : String
    private lateinit var ratingBar : RatingBar
    private var ratingMsg : String = "5.0";
    private  var price : Boolean = false
    private  var content : Boolean = false
    lateinit var cbPrice: CheckBox
    lateinit var cbContent: CheckBox




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating)



        button = findViewById(R.id.button)
        etTitle = findViewById(R.id.etBookName)
        etAuthor = findViewById(R.id.etAuthorName)
        etComment = findViewById(R.id.etComments)
        rGroup = findViewById(R.id.rGroup)
        ratingBar = findViewById(R.id.ratingBar)
        cbPrice = findViewById(R.id.cbPrice)
        cbContent = findViewById(R.id.cbContent)

        ratingBar.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener{
                ratingBar: RatingBar, _, _ ->


            ratingMsg = ratingBar.rating.toString()



        }


        rGroup.setOnCheckedChangeListener { _, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            category = radio.text.toString()

        }
        button.setOnClickListener {

            val title = etTitle.text.toString()
            val author = etAuthor.text.toString()
            val comment = etComment.text.toString()

            if (cbPrice.isChecked){
                price = true
            }

            if (cbContent.isChecked){
                content = true
            }
            if(ratingMsg.isEmpty()){
                Toast.makeText(this, "please select rating", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val bookRating = BookRating(title ,author, comment, category, ratingMsg, price.toString(), content.toString())


            val intent = Intent(this, MainActivity::class.java)
            val gson = Gson()

            intent.putExtra("obj", gson.toJson(bookRating))
            startActivity(intent)
            Toast.makeText(this,  "Rated Successfully", Toast.LENGTH_LONG).show()
            finish()
        }

    }
}