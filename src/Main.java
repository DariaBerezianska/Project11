import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Movies movies = new Movies();
        boolean continuing = true;
        do {
            int number = getNumber();
            switch (number) {
                case 0:
                    continuing = false;
                    break;
                case 1:
                    addingMovie(movies);
                    break;
                case 2:
                    removingMovie(movies);
                    break;
                case 3:
                    printAllMovies(movies);
                    break;
                case 4:
                    sort(movies);
                    break;
                case 5:
                    findByTitle(movies);
                    break;
                case 6:
                    findByYear(movies);
                    break;
                case 7:
                    printList(movies);
                    break;
                case 8:
                    savetoFile(movies);
                    break;
                case 9:
                    readFromFile(movies);
                    break;
                case 10:
                    viewingTimeInHours(movies);
                    break;
                default:
                    System.out.println("Enter a correct number from 0 to 10");
            }
        } while (continuing);
        System.out.println("Thank you for using movie database");
    }

    // method to get a number from user
    private static int getNumber() {
        System.out.println("""
                Welcome to the movie database!
                ! first do option 9(read movies from the file) to get access to standard movie collection
                ! than you can do any option
                Choose an option to proceed:
                1 - add movies to collection
                2 - remove movies from collection
                3 - print all movies
                4 - sort movies by rating
                5 - search movie by title
                6 - search movie by year of release
                7 - print detailed movie list
                8 - save movie to the file
                9 - read movies from the file
                10 - convert viewing time in hours
                0 - exit the program""");
        int number = scan.nextInt();
        scan.nextLine();
        return number;
    }

    private static void addingMovie(Movies movies) {
        boolean addingMovie = true;
        do {
            System.out.println("Please enter all information about film\n title: ");
            String userTitle = scan.nextLine();
            System.out.println("year of release: ");
            int userYearOfRelease = scan.nextInt();
            scan.nextLine();
            System.out.println("genre: ");
            String userGenre = scan.nextLine();
            System.out.println("rating: ");
            double userRating = scan.nextDouble();
            scan.nextLine();
            System.out.println("viewing time in minutes: ");
            int userViewingTime = scan.nextInt();
            scan.nextLine();
            Movie userMovie = new Movie(userTitle, userYearOfRelease, userGenre, userRating, userViewingTime);
            movies.addMovie(userMovie); // method to add movie with all details to collection
            System.out.println("You successfully add new movie to movie collection\n Do you want to add one more movie? y/n");
            String answ = scan.nextLine();
            if (answ.equalsIgnoreCase("n")) {
                addingMovie = false;
            }
        } while (addingMovie);
    }

    private static void viewingTimeInHours(Movies movies) {
        System.out.println("Please enter movie index to know how many hours you will spend on watching");
        int index = scan.nextInt();
        scan.nextLine();
        movies.viewingTime(index); // method to convert viewing time from minutes to hours
    }

    private static void removingMovie(Movies movies) {
        System.out.println("Please enter index of movie that you want to remove");
        int index = scan.nextInt();
        scan.nextLine();
        movies.removeMovie(index); // method to remove movie from collection by index
        System.out.println("You successfully remove movie with index: " + index);
    }

    private static void sort(Movies movies) {
        movies.sort(); // method to sort collection by rating
        movies.printAllMovies();
    }

    private static void printAllMovies(Movies movies) {
        movies.printAllMovies(); // method to print details about all movies
    }

    private static void findByYear(Movies movies) {
        System.out.println("Please write year of release of movie that you want to find");
        int userYear = scan.nextInt();
        scan.nextLine();
        // method to find movie into collection by year of release
        if (!movies.findByYearOfRelease(userYear)) {
            // if there will no movie that was released in userYear -> print error message
            System.out.println("There is no movie that was released in " + userYear); //
        }
    }

    private static void findByTitle(Movies movies) {
        System.out.println("Please write title of movie that you want to find");
        String userTitle = scan.nextLine();
        // method to find movie into collection by tittle or some similar part
        if (!movies.findByTitle(userTitle)) {
            //if there will no movie with userTitle -> print error message
            System.out.println("There is no movie with title: " + userTitle);
        }
    }

    private static void printList(Movies movies) {
        movies.printList(); // method to print list of movie with information about each movie in different lines
    }

    private static void savetoFile(Movies movies) throws IOException {
        movies.saveToFile();
    }

    private static void readFromFile(Movies movies) throws IOException {
        movies.readFromFile();
    }
}




