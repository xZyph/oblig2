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
        setEpisodeNo(1);
        setSeasonNo(1);
        setTitle("N/A");
        setPlaytime(new Random().nextInt((30 - 20) + 1) + 20);
    }

    public Episode(int seasonNo) {
        setEpisodeNo(1);
        setSeasonNo(seasonNo);
        setTitle("N/A");
        setPlaytime(new Random().nextInt((30 - 20) + 1) + 20);
    }

    public Episode(int seasonNo, int episodeNo) {
        setEpisodeNo(episodeNo);
        setSeasonNo(seasonNo);
        setTitle("N/A");
        setPlaytime(new Random().nextInt((30 - 20) + 1) + 20);
    }

    public Episode(int episodeNo, int seasonNo, String title, int playtime) {
        setEpisodeNo(episodeNo);
        setSeasonNo(seasonNo);
        setTitle(title);
        setPlaytime(playtime);
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

    /* Overrides */

    @Override
    public String toString() {
        // Using ternary logic to display SXXEXX correctly.
        // Shoutout to Odd Martin Hansen that pointed out that I didn't need to use this. here.
        return getTitle() + " (S" + (seasonNo < 10 ? "0" + seasonNo : seasonNo) + "E" + (episodeNo < 10 ? "0" + seasonNo : seasonNo) + ") " + getPlaytime() + " min";
    }
}

    /* Methods */
