package playmusic.androidstudio.com.playmusic;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button playMusic;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.song);

        playMusic = (Button) findViewById(R.id.playButton);
        playMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()) {
                    // stop and give option to start again
                    pauseMusic();
                } else {
                    startMusic();
                }
            }
        });
    }

    public void pauseMusic() {
        if(mediaPlayer != null) {
            mediaPlayer.pause();
            playMusic.setText("Play");
        }
    }

    public void startMusic() {
        if(mediaPlayer != null) {
            mediaPlayer.start();
            playMusic.setText("Pause");
        }
    }
}
