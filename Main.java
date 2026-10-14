public class Main {
    public static void main(String[] args) {
        HomeTheaterFacade theater = new HomeTheaterFacade();
        String movie = args.length == 0 ? "Interstellar" : String.join(" ", args);
        try {
            theater.watchMovie(movie);
        } catch (IllegalArgumentException | IllegalStateException failure) {
            System.err.println(failure.getMessage());
        } finally {
            theater.endMovie();
        }
    }
}
