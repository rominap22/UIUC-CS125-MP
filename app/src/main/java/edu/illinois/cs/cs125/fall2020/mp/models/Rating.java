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
   * Default constructor for Jackson purposes.
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
   * @return string of the id
   */
  public String getId() {
    //throw new IllegalStateException("Not yet implemented Rominaaaa");
    return "";
  }
  /**
   * Getting the rating itself.
   * @return string of the rating
   */
  public String getRating() {
    //throw new IllegalStateException("Not yet implemented Rominaaaa");
    return "";
  }
}
