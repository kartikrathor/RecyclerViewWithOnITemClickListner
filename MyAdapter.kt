
class MyAdapter(
        val songs: List<Song>, private val onSongItemClickListner: onSongItemClickListner

        ): RecyclerView.Adapter<MyAdapter.myViewHolder>(){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder{
        val inflater:LayoutInflater = LayoutInflater.from(parent.context)
        val view:View = inflater.inflate(R.layout.item_view, parent, false)
        return myViewHolder(view)
    }

    override fun getItemCount(): Int {
        return songs.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {

        val movie = songs[position]

        holder.textTitle.text = songs[position].title
        holder.textDescription.text = songs[position].Description

        holder.itemView.setOnClickListener{
            onSongItemClickListner.onSongItemClicked(position)
        }

        holder.textTitle.setOnClickListener {
            onSongItemClickListner.onTitleClickListner(position)
        }
        holder.textDescription.setOnClickListener {
            onSongItemClickListner.onDescriptionClickLisener(position)
        }
    }

    inner class myViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{

        var textTitle = itemView.findViewById<TextView>(R.id.txtTitle)
        var textDescription = itemView.findViewById<TextView>(R.id.txtDescription)

        init {
            itemView.setOnClickListener {v: View? ->
                val position: Int = adapterPosition
                Toast.makeText(itemView.context,"You clicked on $position",Toast.LENGTH_SHORT).show()
            }
        }

        override fun onClick(v: View?) {

            v
        }

    }



}
