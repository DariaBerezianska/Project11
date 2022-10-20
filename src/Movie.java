public class Movie {
    private final String title;
    public String genre;
    public int yearOfRelease;
    public double filmRating;
    private int viewingTime;

    public Movie(String title, int yearOfRelease, String genre, double filmRating, int viewingTime) {
        this.title = title;
        this.yearOfRelease = yearOfRelease;
        this.genre = genre;
        this.filmRating = filmRating;
        this.viewingTime = viewingTime;
    }

    public void setViewingTime(int viewingTime) {
        this.viewingTime = viewingTime;
    }

    public int getViewingTime() {
        return viewingTime;
    }


    public String getDetails() {
        return getTitle().toUpperCase()
                + "\ntitle: " + title
                + "\ngenre: " + genre
                + "\nyear of release: " + yearOfRelease
                + "\nrating of this movie: " + filmRating;
    }

    public String getTitle() {
        return title;
    }

    public String getDetailsLine() {
        return "Title: " + title
                + ", genre: " + genre
                + ", year of release: " + yearOfRelease
                + ", rating of this movie: " + filmRating + "/10";
    }

}
