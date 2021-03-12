  class WelcomeActivity: AppCompatActivity() , onSongItemClickListner{

//    val TAG: String = WelcomeActivity::class.java.simpleName
//
//    var nav: NavigationView? = null
//    var toggle: ActionBarDrawerToggle? = null
//    var drawerLayout: DrawerLayout? = null

    var songs = ArrayList<Song>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_welcome)

        createDummylist()

        var songAdapter = MyAdapter(songs,this)
        songList.layoutManager = LinearLayoutManager(this)
        songList.adapter = songAdapter
        songAdapter.notifyDataSetChanged()

    }

    override fun onSongItemClicked(position: Int) {

        Toast.makeText(this, "Language " + position +" Clicked",Toast.LENGTH_SHORT).show()

        val intent = Intent(this,SongDetailActivity::class.java)
        intent.putExtra("name",songs[position].title)
        intent.putExtra("Description",songs[position].Description)
        startActivity(intent)
    }

    override fun onTitleClickListner(position: Int) {
        var heading = songs[position].title
        Toast.makeText(this, "Clicked On" + heading,Toast.LENGTH_SHORT).show()
    }

    override fun onDescriptionClickLisener(position: Int) {
        var desc = songs[position].Description
        Toast.makeText(this,"Description is" + desc,Toast.LENGTH_SHORT).show()
    }


    fun createDummylist(){



        songs.add(Song("Kotlin","Kotlin is more faster"))
        songs.add(Song("Java","Java is more easier"))
        songs.add(Song("JavaScript","Java is more Popular"))
        songs.add(Song("Python","Python is more famous"))
        songs.add(Song("Ruby","Ruby is more knowladgable"))
        songs.add(Song("C","Mother Language of all languages"))
        songs.add(Song("C++","Similar to java"))
        songs.add(Song("Android","Always popular"))
        songs.add(Song("Flutter","Build app for ios and android"))
        songs.add(Song("NodeJS","NPM is more powerful"))
        songs.add(Song("HTML","Easy and simple"))

    }


}
