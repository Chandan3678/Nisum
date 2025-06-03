package day2;

import java.util.*;

class Movie {
    String title;
    String director;
    String genre;
    int releaseYear;
    double rating;

    // Constructor to initialize Movie object
    public Movie(String title, String director, String genre, int releaseYear, double rating) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    // Override toString to display movie details in a formatted way
    @Override
    public String toString() {
        return String.format("| %-20s | %-15s | %-10s | %-12d | %-6.2f |", title, director, genre, releaseYear, rating);
    }
}

public class MovieCollectionManager {

    private static ArrayList<Movie> movieCollection = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

// Sample movies
addMovie("Interstellar", "Christopher Nolan", "Sci-Fi", 2014, 8.6);
addMovie("Pulp Fiction", "Quentin Tarantino", "Crime", 1994, 8.9);
addMovie("The Shawshank Redemption", "Frank Darabont", "Drama", 1994, 9.3);
addMovie("The Matrix", "Lana Wachowski, Lilly Wachowski", "Action", 1999, 8.7);


        while (running) {
            // Show menu
            System.out.println("\nMovie Collection Manager");
            System.out.println("1. View All Movies");
            System.out.println("2. Add Movie");
            System.out.println("3. Remove Movie");
            System.out.println("4. Filter Movies");
            System.out.println("5. Sort Movies");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (choice) {
                case 1 -> viewAllMovies();
                case 2 -> addMovieOption(sc);
                case 3 -> removeMovieOption(sc);
                case 4 -> filterMovies(sc);
                case 5 -> sortMovies(sc);
                case 6 -> running = false;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        sc.close();
    }

    // Method to view all movies
    private static void viewAllMovies() {
        if (movieCollection.isEmpty()) {
            System.out.println("No movies available.");
        } else {
            System.out.println("\nMovie Collection:");
            System.out.println("| Title                | Director        | Genre      | Release Year | Rating |");
            System.out.println("-------------------------------------------------------------------------------");
            for (Movie movie : movieCollection) {
                System.out.println(movie);
            }
        }
    }

    // Method to add a movie
    private static void addMovieOption(Scanner sc) {
        System.out.print("\nEnter movie title: ");
        String title = sc.nextLine();
        System.out.print("Enter director: ");
        String director = sc.nextLine();
        System.out.print("Enter genre: ");
        String genre = sc.nextLine();
        System.out.print("Enter release year: ");
        int releaseYear = sc.nextInt();
        System.out.print("Enter rating (0-10): ");
        double rating = sc.nextDouble();
        sc.nextLine();  // Consume the newline character

        addMovie(title, director, genre, releaseYear, rating);
    }

    // Helper method to add movie to the collection
    private static void addMovie(String title, String director, String genre, int releaseYear, double rating) {
        Movie newMovie = new Movie(title, director, genre, releaseYear, rating);
        movieCollection.add(newMovie);
        System.out.println("Movie added successfully.");
    }

    // Method to remove a movie
    private static void removeMovieOption(Scanner sc) {
        System.out.print("\nEnter the title of the movie to remove: ");
        String title = sc.nextLine();
        boolean found = false;
        Iterator<Movie> iterator = movieCollection.iterator();
        while (iterator.hasNext()) {
            Movie movie = iterator.next();
            if (movie.title.equalsIgnoreCase(title)) {
                iterator.remove();
                found = true;
                System.out.println("Movie removed successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Movie not found.");
        }
    }

    // Method to filter movies
    private static void filterMovies(Scanner sc) {
        System.out.println("\nFilter by:");
        System.out.println("1. Genre");
        System.out.println("2. Director");
        System.out.println("3. Release Year");
        System.out.print("Enter your choice: ");
        int filterChoice = sc.nextInt();
        sc.nextLine();  // Consume the newline character

        switch (filterChoice) {
            case 1 -> {
                System.out.print("Enter genre to filter by: ");
                String genre = sc.nextLine();
                filterByGenre(genre);
            }
            case 2 -> {
                System.out.print("Enter director to filter by: ");
                String director = sc.nextLine();
                filterByDirector(director);
            }
            case 3 -> {
                System.out.print("Enter release year to filter by: ");
                int year = sc.nextInt();
                filterByReleaseYear(year);
            }
            default -> System.out.println("Invalid choice.");
        }
    }

    // Filter movies by genre
    private static void filterByGenre(String genre) {
        System.out.println("\nMovies with genre '" + genre + "':");
        for (Movie movie : movieCollection) {
            if (movie.genre.equalsIgnoreCase(genre)) {
                System.out.println(movie);
            }
        }
    }

    // Filter movies by director
    private static void filterByDirector(String director) {
        System.out.println("\nMovies by director '" + director + "':");
        for (Movie movie : movieCollection) {
            if (movie.director.equalsIgnoreCase(director)) {
                System.out.println(movie);
            }
        }
    }

    // Filter movies by release year
    private static void filterByReleaseYear(int year) {
        System.out.println("\nMovies released in " + year + ":");
        for (Movie movie : movieCollection) {
            if (movie.releaseYear == year) {
                System.out.println(movie);
            }
        }
    }

    // Method to sort movies
    private static void sortMovies(Scanner sc) {
        System.out.println("\nSort by:");
        System.out.println("1. Title");
        System.out.println("2. Release Year");
        System.out.println("3. Rating");
        System.out.print("Enter your choice: ");
        int sortChoice = sc.nextInt();

        switch (sortChoice) {
            case 1 -> movieCollection.sort(Comparator.comparing(movie -> movie.title));
            case 2 -> movieCollection.sort(Comparator.comparingInt(movie -> movie.releaseYear));
            case 3 -> movieCollection.sort(Comparator.comparingDouble(movie -> movie.rating));
            default -> {
                System.out.println("Invalid choice.");
                return;
            }
        }

        System.out.println("\nMovies sorted:");
        viewAllMovies();
    }
}
