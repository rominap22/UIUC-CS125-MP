package edu.illinois.cs.cs125.fall2020.mp.models;
/**
 * Rating class for storing client ratings of courses.
 */
public class Rating {
  /** Rating indicating that the course has not been rated yet. */
  public static final double NOT_RATED = -1.0;
  private String id;
  private double rating;
  /**
   * Default constructor for being serialized and deserialized by Jackson.
   */
  public Rating() {  }
  /**
   * Constructor for setting id and rating.
   * @param setId is the id
   * @param setRating is the rating
   */
  public Rating(final String setId, final double setRating) {
    id = setId;
    rating = setRating;
  }
  /**
   * Getting the id of the rating.
   * @return UUID as a String for this Rating object
   */
  public String getId() {
    //throw new IllegalStateException("Not yet implemented Rominaaaa");
    return id;
  }
  /**
   * Getting the rating itself.
   * @return numeric rating as a double for this Rating object
   */
  public double getRating() {
    //throw new IllegalStateException("Not yet implemented Rominaaaa");
    //valid ratings are 0 to 5

    //if client has not set the rating, set rating = NOT_RATED and return rating.
    return rating;
  }
}
