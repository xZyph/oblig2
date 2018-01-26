package no.hiof.mariumi.oblig2;

/* Imports */
import java.util.ArrayList;
import java.time.LocalDate;

public class Series {
    private String title;
    private String description;
    private LocalDate releaseDate;
    private ArrayList<Episode> episodeList;
    private int avgRuntime;
    private int seasonSize;

    /* Constructors */

    public Series() {
        setTitle("Default title.");
        setDescription("Default description");
        setReleaseDate(LocalDate.now());
        setEpisodeList(new ArrayList<Episode>());
    }

    public Series(String title, String description, LocalDate releaseDate) {
        setTitle(title);
        setDescription(description);
        setReleaseDate(releaseDate);
        setEpisodeList(new ArrayList<Episode>());
    }

    /* Getters */

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public ArrayList<Episode> getEpisodeList() {
        return episodeList;
    }

    public int getAvgRuntime() {
        return avgRuntime;
    }

    public int getSeasonSize() {
        return seasonSize;
    }

    /* Setters */

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setEpisodeList(ArrayList<Episode> episodeList) {
        this.episodeList = episodeList;
    }

    /* Overrides */

    @Override
    public String toString() {
        return getTitle() + " " + getSeasonSize() + " Seasons (Tot: " + getTotalRuntime() + " min | Avg: " + getAvgRuntime() + " min)";
    }

    /* Methods */

    public void addEpisode(Episode newEpisode) {
        try {
            if (newEpisode.getSeasonNo() > (getSeasonSize() + 1)) {
                throw new Error("Cannot add episode from a season higher than " + (getSeasonSize() + 1));
            }
            episodeList.add(newEpisode);
            seasonSize = newEpisode.getSeasonNo();
            updateAvgRuntime();
        }
        catch (Error e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
        }
    }

    public void listAllEpisodes(int season) {
        System.out.println("=============================================================");
        System.out.println(" Season " + season);
        System.out.println("=============================================================");

        for(int i = 0; i < episodeList.size(); i++) {
            if(episodeList.get(i).getSeasonNo() == season) {
                System.out.println(" " + episodeList.get(i));
            }
        }

        System.out.println("-------------------------------------------------------------");
    }

    public void listAllEpisodes() {
        for(int i = 1; i <= seasonSize; i++) {
            listAllEpisodes(i);
        }
    }

    // Returns int minutes
    public int getTotalRuntime() {
        int totalRuntime = 0;

        for(int i = 0; i < episodeList.size(); i++) {
            totalRuntime += episodeList.get(i).getDuration();
        }

        return  totalRuntime;
    }

    // "m" returns String minutes
    // "h" returns String hours and minutes
    public String getTotalRuntime(String mode) {
        int totalRuntime = 0;

        for(int i = 0; i < episodeList.size(); i++) {
            totalRuntime += episodeList.get(i).getDuration();
        }

        switch(mode) {
            case "m":
                return Integer.toString(totalRuntime) + " min";

            case "h":
                int hours = totalRuntime / 60;
                int minutes = totalRuntime % 60;

                return hours + " h " + minutes + " min";

            default:
                return Integer.toString(totalRuntime);
        }
    }

    private void updateAvgRuntime() {
        avgRuntime = getTotalRuntime() / episodeList.size();
    }

    public void createSeasons(int amountOfSeasons, int amountOfEpisodes, int startSeason) {
        for(int s = startSeason; s < (amountOfSeasons + startSeason); s++) {
            for (int e = 1; e < (amountOfEpisodes + 1); e++) {
                addEpisode(new Episode(s, e));
            }
        }
    }
}