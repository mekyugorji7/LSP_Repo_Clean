package org.howard.edu.lsp.midterm.question5;

/**
 * Interface representing common behaviors for all streamable content.
 */
interface Streamable {
    /**
     * Play the content.
     */
    void play();

    /**
     * Pause the content.
     */
    void pause();

    /**
     * Stop the content.
     */
    void stop();
}

public class StreamingServiceDriver {
    /**
     * Main method to run the streaming service driver.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        // Create instances of different media types
        Streamable music = new Music("Still a Friend - Incognito");
        Streamable movie = new Movie("Avengers EndGame");
        Streamable audiobook = new Audiobook("A Promised Land – Barack Obama");

        // Test the common behaviors for all media types
        System.out.println("Testing common behaviors for all media types:\n");

        // Test Music
        System.out.println("Testing Music:");
        music.play();
        music.pause();
        music.stop();
        System.out.println();

        // Test Movie
        System.out.println("Testing Movie:");
        movie.play();
        movie.pause();
        movie.stop();
        System.out.println();

        // Test Audiobook
        System.out.println("Testing Audiobook:");
        audiobook.play();
        audiobook.pause();
        audiobook.stop();
        System.out.println();

        // Test Movie-specific behavior (rewind)
        Movie movieWithRewind = (Movie) movie;
        movieWithRewind.rewind(30);
        System.out.println();

        // Test Audiobook-specific behavior (setPlaybackSpeed)
        Audiobook audiobookWithSpeed = (Audiobook) audiobook;
        audiobookWithSpeed.setPlaybackSpeed(1.5);
        System.out.println();

        // Test Music-specific behavior (addToPlaylist)
        Music musicWithPlaylist = (Music) music;
        musicWithPlaylist.addToPlaylist("Favorites");
        System.out.println();
    }
}
