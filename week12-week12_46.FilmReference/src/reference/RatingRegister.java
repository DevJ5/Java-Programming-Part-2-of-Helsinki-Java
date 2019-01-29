package reference;

import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RatingRegister {
    private Map<Film, List<Rating>> ratingsPerFilm;
    private Map<Person, Map<Film, Rating>> ratingsPerPerson;

    public RatingRegister() {
        this.ratingsPerFilm = new HashMap<Film, List<Rating>>();
        this.ratingsPerPerson = new HashMap<Person, Map<Film, Rating>>();
    }

    public void addRating(Film film, Rating rating) {
        System.out.println(ratingsPerFilm.get(film));
        List<Rating> list;
        if (ratingsPerFilm.get(film) == null) {
            list = new ArrayList<Rating>();
            ratingsPerFilm.put(film, list);
        } else {
            list = ratingsPerFilm.get(film);
        }
        list.add(rating);
    }

    public void addRating(Person person, Film film, Rating rating) {
        addRating(film, rating);
        System.out.println("here....");
        System.out.println(ratingsPerPerson.containsKey(person));

        Map<Film, Rating> map;
        if (ratingsPerPerson.containsKey(person)) map = ratingsPerPerson.get(person);
        else {
            map = new HashMap<Film, Rating>();
            ratingsPerPerson.put(person, map);
        }
        map.put(film, rating);
    }

    public Rating getRating(Person person, Film film) {
        if (ratingsPerPerson.get(person) == null) return null;
        if (ratingsPerPerson.get(person).get(film) == null) return Rating.NOT_WATCHED;

        return ratingsPerPerson.get(person).get(film);
    }

    public Map<Film, Rating> getPersonalRatings(Person person) {
        if(ratingsPerPerson.get(person) == null) return new HashMap<Film, Rating>();
        return ratingsPerPerson.get(person);
    }

    public List<Person> reviewers() {
        List<Person> allReviewersList = new ArrayList<Person>();
        allReviewersList.addAll(ratingsPerPerson.keySet());
        return allReviewersList;
    }

    public List<Rating> getRatings(Film film) {
        return ratingsPerFilm.get(film);
    }

    public Map<Film, List<Rating>> filmRatings() {
        return ratingsPerFilm;
    }

}
