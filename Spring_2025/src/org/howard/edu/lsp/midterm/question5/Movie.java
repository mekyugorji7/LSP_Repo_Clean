package org.howard.edu.lsp.midterm.question5;

class Movie implements Streamable {
    private String title;

    public Movie(String title) {
        this.title = title;
    }

    @Override
    public void play() {
        System.out.println("Playing movie: " + title);
    }

    @Override
    public void pause() {
        System.out.println("Paused movie: " + title);
    }

    @Override
    public void stop() {
        System.out.println("Stopped movie: " + title);
    }

    /**
     * Rewind the movie by a number of seconds.
     * @param seconds Number of seconds to rewind.
     */
    public void rewind(int minutes) {
        System.out.println("Rewinding movie: " + title + " by " + minutes + " minutes");
    }
}
