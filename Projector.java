public class Projector {
    private boolean poweredOn;
    private DvdPlayer source;
    private boolean widescreen;

    public void on() {
        poweredOn = true;
        System.out.println("Projector on");
    }

    public void setSource(DvdPlayer player) {
        if (player == null) {
            throw new IllegalArgumentException("Video source is required.");
        }
        source = player;
    }

    public void setWidescreen() {
        widescreen = true;
    }

    public void project() {
        if (!poweredOn || source == null || !source.isPlaying()) {
            throw new IllegalStateException("Projection requires power and a playing DVD source.");
        }
        System.out.println("Projecting movie in " + (widescreen ? "16:9" : "4:3"));
    }

    public void off() {
        poweredOn = false;
        source = null;
        widescreen = false;
        System.out.println("Projector off");
    }
}
