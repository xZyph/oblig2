package no.hiof.mariumi.oblig2;

/* Imports */
import java.util.Random;

public class Episode {
    private int episodeNo;
    private int seasonNo;
    private String title;
    private int playtime;

    /* Constructors */

    public Episode() {
        this.episodeNo = 1;
        this.seasonNo = 1;
        this.title = "N/A";
        this.playtime = new Random().nextInt((30 - 20) + 1) + 20;
    }

    public Episode(int seasonNo) {
        this.episodeNo = 1;
        this.seasonNo = seasonNo;
        this.title = "N/A";
        this.playtime = new Random().nextInt((30 - 20) + 1) + 20;
    }

    public Episode(int seasonNo, int episodeNo) {
        this.episodeNo = episodeNo;
        this.seasonNo = seasonNo;
        this.title = "N/A";
        this.playtime = new Random().nextInt((30 - 20) + 1) + 20;
    }

    public Episode(int episodeNo, int seasonNo, String title, int playtime) {
        this.episodeNo = episodeNo;
        this.seasonNo = seasonNo;
        this.title = title;
        this.playtime = playtime;
    }

    /* Getters */

    public int getEpisodeNo() {
        return episodeNo;
    }

    public int getSeasonNo() {
        return seasonNo;
    }

    public String getTitle() {
        return title;
    }

    public int getPlaytime() {
        return playtime;
    }

    /* Setters */

    public void setEpisodeNo(int episodeNo) {
        this.episodeNo = episodeNo;
    }

    public void setSeasonNo(int seasonNo) {
        this.seasonNo = seasonNo;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPlaytime(int playtime) {
        this.playtime = playtime;
    }

    /* Methods */

    public String toString() {
        // Using ternary logic to display SXXEXX correctly.
        String episode = (this.getEpisodeNo() < 10 ? "0" + this.getEpisodeNo() : Integer.toString(this.getEpisodeNo()));
        String season = (this.getSeasonNo() < 10 ? "0" + this.getSeasonNo() : Integer.toString(this.getSeasonNo()));
        return this.getTitle() + " (S" + season + "E" + episode + ") " + this.getPlaytime() + " min";
    }
}
