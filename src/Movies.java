import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Movies {
    public Movie[] movies = new Movie[0];
    public int count = 0;

    public void addMovie(Movie m) {
        Movie[] copy = Arrays.copyOf(movies, count + 1);
        copy[count] = m;
        count++;
        movies = copy;
    }

    public void removeMovie(int i) {
        Movie[] arr = new Movie[count - 1];
        System.arraycopy(movies, 0, arr, 0, i);
        if (i != count - 1) {
            System.arraycopy(movies, i + 1, arr, i, count - i - 1);
        }
        movies = arr;
        count--;
    }

    public void printMovie(int i) {
        System.out.println(movies[i].getDetails());
    }

    public void printAllMovies() {
        for (int i = 0; i < count; i++) {
            printMovie(i);
            System.out.println(" ");
        }
    }

    public void printList() {
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + movies[i].getDetailsLine());
        }
    }

    public void sort() {
        boolean swapped = true;
        int n = count - 1;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < n; i++) {
                if (movies[i].filmRating > movies[i + 1].filmRating) {
                    swapped = true;
                    Movie temp = movies[i];
                    movies[i] = movies[i + 1];
                    movies[i + 1] = temp;
                }
            }
            n--;
        }
    }

    public boolean findByTitle(String keyword) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (movies[i].getTitle().contains(keyword)) {
                found = true;
                printMovie(i);
                System.out.println(" ");
            }
        }
        return found;
    }

    public void viewingTime(int i) {
        System.out.println("You may spend "
                + Math.round(movies[i].getViewingTime() / 60.0)
                + " hours for "
                + movies[i].getTitle());
    }

    public boolean findByYearOfRelease(int year) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (movies[i].yearOfRelease == year) {
                found = true;
                printMovie(i);
                System.out.println(" ");
            }
        }
        return found;
    }

    public void saveToFile() throws IOException {
        try (FileWriter fileWriter = new FileWriter("moviesFile.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (int i = 0; i < count; i++) {
                bufferedWriter.write(movies[i].getDetails());
                bufferedWriter.write("\n");
            }
            System.out.println("You successfully added all movies to file");
        }
    }

    public void readFromFile() throws IOException {
        try (FileInputStream MoviesFile = new FileInputStream("moviesFile.txt");
             Scanner myReader = new Scanner(MoviesFile)) {
            while (myReader.hasNextLine()) {
                myReader.nextLine();
                myReader.skip("title: ");
                String title = myReader.nextLine();
                myReader.skip("genre: ");
                String genre = myReader.nextLine();
                myReader.skip("year of release: ");
                int yearOfRelease = myReader.nextInt();
                myReader.nextLine();
                myReader.skip("rating of this movie: ");
                double rating = myReader.nextDouble();
                myReader.nextLine();
                myReader.skip("viewing time in minutes: ");
                int viewingTime = myReader.nextInt();
                myReader.nextLine();
                addMovie(new Movie(title, yearOfRelease, genre, rating, viewingTime));
            }
            System.out.println("End of file");
        }

    }
}
