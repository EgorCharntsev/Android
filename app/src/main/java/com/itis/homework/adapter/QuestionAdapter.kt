import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itis.homework.databinding.QuestionItemBinding
import com.itis.homework.fragments.holder.QuestionHolder
import com.itis.homework.model.Answer

class QuestionAdapter(
    val answers: List<Answer>,
    private val onItemChecked: ((Int) -> Unit)? = null,
    private val onRootClicked: ((Int) -> Unit)? = null,
) : RecyclerView.Adapter<QuestionHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionHolder {
        return QuestionHolder(
            QuestionItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            onItemChecked,
            onRootClicked,
        )
    }

    override fun getItemCount(): Int = answers.count()

    override fun onBindViewHolder(holder: QuestionHolder, position: Int) {
        holder.bindItem(answer = answers[position])
    }
}