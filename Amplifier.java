public class Amplifier {
    private boolean poweredOn;
    private DvdPlayer source;
    private int volume;

    public void on() {
        poweredOn = true;
        System.out.println("Amplifier on");
    }

    public void setSource(DvdPlayer player) {
        if (player == null) {
            throw new IllegalArgumentException("Audio source is required.");
        }
        source = player;
    }

    public void setVolume(int level) {
        if (level < 0 || level > 10) {
            throw new IllegalArgumentException("Volume must be between 0 and 10.");
        }
        volume = level;
    }

    public void playAudio() {
        if (!poweredOn || source == null || !source.isPlaying()) {
            throw new IllegalStateException("Audio requires power and a playing DVD source.");
        }
        System.out.println("Movie audio at volume " + volume);
    }

    public void off() {
        poweredOn = false;
        source = null;
        volume = 0;
        System.out.println("Amplifier off");
    }
}
