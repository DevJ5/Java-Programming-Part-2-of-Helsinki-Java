package reference.comparator;

import reference.domain.Film;
import reference.domain.Rating;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class FilmComparator implements Comparator<Film> {
    private Map<Film, List<Rating>> ratings;

    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = ratings;
    }

    public int compare(Film film1, Film film2) {
        List<Rating> listRatingsFilm1 = ratings.get(film1);
        int sumRatingsFilm1 = 0;
        for (Rating rating : listRatingsFilm1) {
            sumRatingsFilm1 += rating.getValue();
        }
        int avgFilm1 = sumRatingsFilm1 / listRatingsFilm1.size();


        List<Rating> listRatingsFilm2 = ratings.get(film2);
        int sumRatingsFilm2 = 0;
        for (Rating rating : listRatingsFilm2) {
            sumRatingsFilm2 += rating.getValue();
        }
        int avgFilm2 = sumRatingsFilm2 / listRatingsFilm2.size();

        return avgFilm2 - avgFilm1;
    }

}
