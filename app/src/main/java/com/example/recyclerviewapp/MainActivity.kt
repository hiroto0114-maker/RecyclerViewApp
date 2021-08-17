package com.example.recyclerviewapp
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    /**
     * 表示させるポケモンの文字列のリスト
     */
    fun createPokemonList(): List<String>{
        val pokemonList = listOf(
            "ピカチュウ",
            "カイリュー",
            "ヤドラン",
            "ピジョン",
            "コダック",
            "コラッタ",
            "ズバット",
            "ギャロップ",
            "サンダース",
            "メノクラゲ",
            "パウワウ",
            "カラカラ",
            "タマタマ",
            "ガラガラ",
            "フシギダネ"
        )
        return pokemonList
    }
    lateinit var recyclerView: RecyclerView
    val pokemonList = createPokemonList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MyRecyclerViewAdapter(pokemonList)
        recyclerView.adapter = adapter
    }

    /**
     *
     */
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val positionText: TextView
        val titleText: TextView
        val pokemonButton: TextView
        init {
            positionText = itemView.findViewById(R.id.position)
            titleText = itemView.findViewById(R.id.title)
            pokemonButton = itemView.findViewById(R.id.pokemon_button)
        }
    }

    /**
     *
     */
    private inner class MyRecyclerViewAdapter(val list: List<String>) : RecyclerView.Adapter<MyViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val itemView = LayoutInflater.from(this@MainActivity).inflate(R.layout.item_recycler_view, parent, false)
            // val pokemonButton=itemView.findViewById(R.id.pokemon_button)
            //val pokemonButton = itemView.findViewById(R.id.pokemon_button)
            itemView.setOnClickListener(ItemClickListener())
            return MyViewHolder(itemView)
        }
        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.positionText.text = position.toString()
            holder.titleText.text = list[position]
        }
        override fun getItemCount(): Int = list.size

    }
    /**
     * リストをタップした時のリスナクラス。
     */
    private inner class ItemClickListener : View.OnClickListener {
        override fun onClick(view: View) {
            // タップされたLinearLayout内にあるメニュー名表示TextViewを取得。
            val tvMenuName = view.findViewById<TextView>(R.id.title)
            // メニュー名表示TextViewから表示されているメニュー名文字列を取得。
            val menuName = tvMenuName.text.toString()
            // トースト表示。
            Toast.makeText(this@MainActivity, menuName, Toast.LENGTH_SHORT).show()
        }
    }

}


