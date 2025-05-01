// Playable interface definition
interface Playable {
    void play();  // Method to play music
    void pause(); // Method to pause music
    void stop();  // Method to stop music
}

// MusicPlayer class implementing Playable interface
class MusicPlayer implements Playable {

    // Implementing the play method
    @Override
    public void play() {
        System.out.println("Music is playing.");
    }

    // Implementing the pause method
    @Override
    public void pause() {
        System.out.println("Music is paused.");
    }

    // Implementing the stop method
    @Override
    public void stop() {
        System.out.println("Music is stopped.");
    }
}

// TestPlayer class to test MusicPlayer functionality
public class TestPlayer {
    public static void main(String[] args) {
        // Create a MusicPlayer object
        MusicPlayer player = new MusicPlayer();

        // Call the play, pause, and stop methods to test
        player.play();  // Output: Music is playing.
        player.pause(); // Output: Music is paused.
        player.stop();  // Output: Music is stopped.
    }
}
