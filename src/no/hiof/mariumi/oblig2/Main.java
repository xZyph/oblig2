package no.hiof.mariumi.oblig2;

/* Imports */
import java.time.LocalDate;

// TODO
// - Add exceptions for error handling.

public class Main {

    public static void main(String[] args) {

        // Firefly Series

        Series firefly = new Series(
                "Firefly",
                "The show explores the lives of a group of people, some of whom fought on the losing side of a civil war...",
                LocalDate.of(2015, 12, 31)
        );

        // Firefly Season 1 - Could have made this shorter, but did it this way to keep it neat and structured.

        Episode theTrainJob = new Episode(1, 1, "The Train Job", 42);
        Episode bushwhacked = new Episode(2, 1, "Bushwhacked", 44);
        Episode ourMrsReynolds = new Episode(3, 1, "Our Mrs Reynolds", 44);
        Episode jaynesTown = new Episode(4, 1, "Jayne's Town", 44);
        Episode outOfGas = new Episode(5, 1, "Out of Gas", 44);
        Episode shindig = new Episode(6, 1, "Shindig", 44);
        Episode safe = new Episode(7, 1, "Safe", 43);
        Episode ariel = new Episode(8, 1, "Ariel", 43);
        Episode warStories = new Episode(9, 1, "War Stories", 43);
        Episode objectsInSpace = new Episode(10, 1, "Objects in Space", 44);
        Episode serenity = new Episode(11, 1, "Serenity", 86);
        Episode heartOfGold = new Episode(12, 1, "Heart of Gold", 42);
        Episode trash = new Episode(13, 1, "Trash", 44);
        Episode theMessage = new Episode(14, 1, "The Message", 44);

        firefly.addEpisode(theTrainJob);
        firefly.addEpisode(bushwhacked);
        firefly.addEpisode(ourMrsReynolds);
        firefly.addEpisode(jaynesTown);
        firefly.addEpisode(outOfGas);
        firefly.addEpisode(shindig);
        firefly.addEpisode(safe);
        firefly.addEpisode(ariel);
        firefly.addEpisode(warStories);
        firefly.addEpisode(objectsInSpace);
        firefly.addEpisode(serenity);
        firefly.addEpisode(heartOfGold);
        firefly.addEpisode(trash);
        firefly.addEpisode(theMessage);

        // Firefly Season 2 - 5
        firefly.createSeasons(4,20,2);

        // Uncomment below to see release date for the series.
        //      System.out.println(firefly.getReleaseDate());

        // Modified toString on each class
        System.out.println("\n=============================================================");
        System.out.println(" Modified toString methods");
        System.out.println("=============================================================");
        System.out.println(" " + firefly.toString());
        System.out.println(" ------------------------------------------------------------");
        System.out.println(" " + theTrainJob.toString());
        System.out.println(" ------------------------------------------------------------\n");

        // Listing all episodes - Commented because wall of text
        //      firefly.listAllEpisodes();

        // Listing all episodes in a specific season
        firefly.listAllEpisodes(1);

        // Adding an episode from a way newer season than previously stored
        Episode test = new Episode(7);
        firefly.addEpisode(test);
    }
}
