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
        this.title = "Default title.";
        this.description = "Default description";
        this.releaseDate = LocalDate.now();
        this.episodeList = new ArrayList<Episode>();
    }

    public Series(String title, String description, LocalDate releaseDate) {
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.episodeList = new ArrayList<Episode>();
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
        return this.getTitle() + " " + this.getSeasonSize() + " Seasons (Tot: " + this.getTotalRuntime() + " min | Avg: " + this.getAvgRuntime() + " min)";
    }

    /* Methods */

    public void addEpisode(Episode newEpisode) {
        if(newEpisode.getSeasonNo() > (this.getSeasonSize() + 1)) {
            System.out.println();
            System.out.println("ERROR: Cannot skip seasons.");
        }
        else {
            this.episodeList.add(newEpisode);
            this.seasonSize = newEpisode.getSeasonNo();
            updateAvgRuntime();
        }
    }

    public void listAllEpisodes(int season) {
        System.out.println("=============================================================");
        System.out.println(" Season " + season);
        System.out.println("=============================================================");

        for(int i = 0; i < this.episodeList.size(); i++) {
            if(this.episodeList.get(i).getSeasonNo() == season) {
                System.out.println(" " + this.episodeList.get(i));
            }
        }

        System.out.println("-------------------------------------------------------------");
    }

    public void listAllEpisodes() {
        for(int i = 1; i <= this.seasonSize; i++) {
            listAllEpisodes(i);
        }
    }

    // Returns int minutes
    public int getTotalRuntime() {
        int totalRuntime = 0;

        for(int i = 0; i < this.episodeList.size(); i++) {
            totalRuntime += this.episodeList.get(i).getPlaytime();
        }

        return  totalRuntime;
    }

    // "m" returns String minutes
    // "h" returns String hours and minutes
    public String getTotalRuntime(String mode) {
        int totalRuntime = 0;

        for(int i = 0; i < this.episodeList.size(); i++) {
            totalRuntime += this.episodeList.get(i).getPlaytime();
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

    public void updateAvgRuntime() {
        this.avgRuntime = this.getTotalRuntime() / this.episodeList.size();
    }

    public void createSeasons(int amountOfSeasons, int amountOfEpisodes, int startSeason) {
        for(int s = startSeason; s < (amountOfSeasons + startSeason); s++) {
            for (int e = 1; e < (amountOfEpisodes + 1); e++) {
                this.addEpisode(new Episode(s, e));
            }
        }
    }
}
