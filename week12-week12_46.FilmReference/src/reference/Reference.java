package reference;

import reference.comparator.FilmComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

import java.util.*;

public class Reference {
    private RatingRegister ratingRegister;

    public Reference(RatingRegister ratingRegister) {
        this.ratingRegister = ratingRegister;
    }

    public Film recommendFilm(Person person) {
        // If person hasn't recommended any films yet.
        if(ratingRegister.getPersonalRatings(person).isEmpty()) {
            List<Film> films = new ArrayList<Film>(ratingRegister.filmRatings().keySet());
            Collections.sort(films, new FilmComparator(ratingRegister.filmRatings()));
            return films.get(0);
        }

        Map<Film, Rating> map = ratingRegister.getPersonalRatings(person);

        Film bestFilm = new Film("");
        int rating = -6;
        for(Film film : map.keySet()) {
            if(rating < map.get(film).getValue()) {
                bestFilm = film;
                rating = map.get(film).getValue();
            }
        }
        return bestFilm;
    }
}
