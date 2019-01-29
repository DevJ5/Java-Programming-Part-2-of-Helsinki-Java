package reference;

import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
//        RatingRegister ratings = new RatingRegister();
//
//        Film goneWithTheWind = new Film("Gone with the Wind");
//        Film eraserhead = new Film("Eraserhead");
//
//        Person matti = new Person("Matti");
//        Person pekka = new Person("Pekka");
//
//        ratings.addRating(matti, goneWithTheWind, Rating.BAD);
//        ratings.addRating(matti, eraserhead, Rating.FINE);
//
//        ratings.addRating(pekka, goneWithTheWind, Rating.GOOD);
//        ratings.addRating(pekka, eraserhead, Rating.GOOD);
//
//        System.out.println("Ratings for Eraserhead: " + ratings.getRatings(eraserhead));
//        System.out.println("Matti's ratings: " + ratings.getPersonalRatings(matti));
//        System.out.println("Reviewers: " + ratings.reviewers());

        Map<String, String> strMap = new HashMap<String, String>();
        System.out.println(strMap.get("one"));
    }
}
