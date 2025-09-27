package AdapterDesignPattern;

//Target Interface
interface MediaPlayer {
    void play(String fileName);
}
//Adaptee
class LegacyPlayer {
    public void playFile(String file) {
        System.out.println("Playing legacy file: " + file);
    }
}
//Adapter
class MediaAdapter implements MediaPlayer {
    private final LegacyPlayer legacyPlayer = new LegacyPlayer();

    public void play(String fileName) {
        legacyPlayer.playFile(fileName); // adapts call
    }
}