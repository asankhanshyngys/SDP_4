public class DvdPlayer {
    private boolean poweredOn;
    private String movie;

    public void on() {
        poweredOn = true;
        System.out.println("DVD player on");
    }

    public void play(String title) {
        if (!poweredOn) {
            throw new IllegalStateException("Turn on the DVD player before playing a movie.");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Movie title must not be blank.");
        }
        if (movie != null) {
            throw new IllegalStateException("Stop the current movie first.");
        }
        movie = title.strip();
        System.out.println("Playing: " + movie);
    }

    public boolean isPlaying() {
        return poweredOn && movie != null;
    }

    public void stop() {
        movie = null;
        System.out.println("DVD playback stopped");
    }

    public void off() {
        stop();
        poweredOn = false;
        System.out.println("DVD player off");
    }
}
