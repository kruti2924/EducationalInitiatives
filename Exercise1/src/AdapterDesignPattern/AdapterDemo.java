package AdapterDesignPattern;

public class AdapterDemo {
    public static void main(String[] args) {
        //using adapter
        MediaPlayer player = new MediaAdapter();
        player.play("song.mp3");
    }
}
