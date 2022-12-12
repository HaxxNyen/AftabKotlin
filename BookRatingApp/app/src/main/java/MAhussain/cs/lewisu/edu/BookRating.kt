package MAhussain.cs.lewisu.edu

import android.widget.CheckBox

class BookRating(title: String, author: String, comment: String, category: String, rating: String, price: String, content: String){

    var bookName = title
    var authorName = author
    var bookComment = comment
    var bookCategory = category
    var bookRating = rating
    var bookPrice = price
    var bookContent = content


    override fun toString(): String {
        return "title: $bookName \n author: $authorName \n Comment: $bookComment" +
                " \n category: $bookCategory \n rating: $bookRating \n Reasonable Price: $bookPrice \n Concise Content : $bookContent"
    }
}