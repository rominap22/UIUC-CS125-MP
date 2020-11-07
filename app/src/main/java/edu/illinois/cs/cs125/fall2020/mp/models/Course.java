package edu.illinois.cs.cs125.fall2020.mp.models;

/** Course class for a single course. */
public class Course extends Summary {
  private String description;
  /** Course default constructor. */
  public Course() {}

  /**
   * Course constructor for setting description.
   *
   * @param des is the description.
   */
  public Course(final String des) {
    description = des;
  }

  /**
   * Course method for getting its description.
   *
   * @return description for the Course
   */
  public String getDescription() {
    return description;
  }
}
