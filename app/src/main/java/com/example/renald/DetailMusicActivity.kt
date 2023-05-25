package com.example.renald

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.uts_renald.R


class DetailMusicActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_music)

        val youtube = findViewById<Button>(R.id.youtube)
        youtube.setOnClickListener {
            val url = "https://www.youtube.com/channel/UC9rMiEjNaCSsebs31MRDCRA"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        val wikipedia = findViewById<Button>(R.id.wikipedia)
        wikipedia.setOnClickListener {
            val url = "https://id.wikipedia.org/wiki/Stray_Kids"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val music = intent.getParcelableExtra<Music>(MainActivity.INTENT_PARCELABLE)

        val imgmusic = findViewById<ImageView>(R.id.img_item_photo)
        val namemusic = findViewById<TextView>(R.id.tv_item_name)
        val descmusic = findViewById<TextView>(R.id.tv_item_description)
        val videoView = findViewById<VideoView>(R.id.video_view)
        val uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.trailer1)


        imgmusic.setImageResource(music?.imgmusic!!)
        namemusic.text = music.namemusic
        descmusic.text = music.descmusic
        videoView.setVideoURI(uri)
        videoView.setOnCompletionListener {
            videoView.start()
        }
        videoView.start()

    }

    override fun onSupportNavigateUp(): Boolean {

        onBackPressed()
        return true
    }
}
