# Home Theater Facade

Assignment 4, option B. A console simulation with three stateful components:
DVD playback, audio amplification, and video projection. No packages or external libraries.

## Run

Requires JDK 17 or newer. From the project folder:

```sh
javac --release 17 -d out Amplifier.java DvdPlayer.java Projector.java HomeTheaterFacade.java Main.java
java -cp out Main
java -cp out Main "The Lord of the Rings"
```

The demo starts a movie and shuts down the theater. `Main` only uses the facade.
`watchMovie(title)` configures and starts the components; `endMovie()` shuts them down.
Subsystem classes remain independently usable.

## Files

- `Amplifier.java`, `DvdPlayer.java`, `Projector.java`: subsystem classes.
- `HomeTheaterFacade.java`: coordination and simplified API.
- `Main.java`: client and live demonstration.
- `Report.md`: introduction, UML, five annotated Clean Code examples, conclusion, and repository link.

For the defense, explain startup order, the dependency on DVD playback, and failure cleanup.
