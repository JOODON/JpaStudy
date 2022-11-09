package study;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie{
    @Id
    @Column(name = "MOVIE_ID")
    private Long moveid;
    @Column(name = "NAME")
    private String movieName;

    public Long getMoveid() {
        return moveid;
    }

    public void setMoveid(Long moveid) {
        this.moveid = moveid;
    }

    public String getMovieName() {
        return movieName;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "moveid=" + moveid +
                ", movieName='" + movieName + '\'' +
                '}';
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
