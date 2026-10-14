 public class HomeTheaterFacade {
    private static final int MOVIE_VOLUME = 5;
    private final DvdPlayer dvdPlayer = new DvdPlayer();
    private final Amplifier amplifier = new Amplifier();
    private final Projector projector = new Projector();
    private boolean watchingMovie;

    public void watchMovie(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Movie title must not be blank.");
        }
        if (watchingMovie) {
            throw new IllegalStateException("End the current movie before starting another.");
        }
        try {
            dvdPlayer.on();
            amplifier.on();
            amplifier.setSource(dvdPlayer);
            amplifier.setVolume(MOVIE_VOLUME);
            projector.on();
            projector.setSource(dvdPlayer);
            projector.setWidescreen();
            dvdPlayer.play(title);
            amplifier.playAudio();
            projector.project();
            watchingMovie = true;
            System.out.println("Home theater ready");
        } catch (RuntimeException failure) {
            endMovie();
            throw new IllegalStateException("Unable to start the home theater.", failure);
        }
    }

    public void endMovie() {
        projector.off();
        amplifier.off();
        dvdPlayer.off();
        watchingMovie = false;
        System.out.println("Home theater shut down");
    }
}
