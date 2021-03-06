package edu.illinois.cs.cs125.fall2020.mp.models;

//import android.icu.text.IDNA;
//import android.nfc.Tag;
//import android.util.Log;

import androidx.annotation.NonNull;
import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter;

//import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * Model holding the course summary information shown in the course list.
 *
 * <p>You will need to complete this model for MP0.
 */
public class Summary implements SortedListAdapter.ViewModel {
  private String year;

  /**
   * Get the year for this Summary.
   *
   * @return the year for this Summary
   */
  public final String getYear() {
    return year;
  }

  private String semester;

  /**
   * Get the semester for this Summary.
   *
   * @return the semester for this Summary
   */
  public final String getSemester() {
    return semester;
  }

  private String department;

  /**
   * Get the department for this Summary.
   *
   * @return the department for this Summary
   */
  public final String getDepartment() {
    return department;
  }

  private String number;

  /**
   * Get the number for this Summary.
   *
   * @return the number for this Summary
   */
  public final String getNumber() {
    return number;
  }

  private String title;

  /**
   * Get the title for this Summary.
   *
   * @return the title for this Summary
   */
  public final String getTitle() {
    return title;
  }

  /** Create an empty Summary. */
  @SuppressWarnings({"unused", "RedundantSuppression"})
  public Summary() {}

  /**
   * Create a Summary with the provided fields.
   *
   * @param setYear the year for this Summary
   * @param setSemester the semester for this Summary
   * @param setDepartment the department for this Summary
   * @param setNumber the number for this Summary
   * @param setTitle the title for this Summary
   */
  public Summary(
      final String setYear,
      final String setSemester,
      final String setDepartment,
      final String setNumber,
      final String setTitle) {
    year = setYear;
    semester = setSemester;
    department = setDepartment;
    number = setNumber;
    title = setTitle;
  }
  /**
   * Create a Summary with the provided fields.
   *
   * @param setYear the year for this Summary
   * @param setSemester the semester for this Summary
   * @param setDepartment the department for this Summary
   * @param setNumber the number for this Summary
   */
  public Summary(
          final String setYear,
          final String setSemester,
          final String setDepartment,
          final String setNumber) {
    year = setYear;
    semester = setSemester;
    department = setDepartment;
    number = setNumber;
  }
  /** {@inheritDoc} */
  @Override
  public boolean equals(final Object o) {
    if (!(o instanceof Summary)) {
      return false;
    }
    Summary course = (Summary) o;
    return Objects.equals(year, course.year)
        && Objects.equals(semester, course.semester)
        && Objects.equals(department, course.department)
        && Objects.equals(number, course.number);
  }

  /** {@inheritDoc} */
  @Override
  public int hashCode() {
    return Objects.hash(year, semester, department, number);
  }

  /** {@inheritDoc} */
  @Override
  public <T> boolean isSameModelAs(@NonNull final T model) {
    return equals(model);
  }

  /** {@inheritDoc} */
  @Override
  public <T> boolean isContentTheSameAs(@NonNull final T model) {
    return equals(model);
  }

  /** */
  public static final Comparator<Summary> COMPARATOR =
      (courseModel1, courseModel2) -> {
        // sorting the course numbers from least (top) to greatest (bottom)
        if (courseModel1.department.compareTo(courseModel2.department) > 0) {
          return 1;
        } else if (courseModel1.department.compareTo(courseModel2.department) < 0) {
          return -1;
        } else {
          if (courseModel1.number.compareTo(courseModel2.number) > 0) {
            return 1;
          } else if (courseModel1.number.compareTo(courseModel2.number) < 0) {
            return -1;
          } else {
            if (courseModel1.title.compareTo(courseModel2.title) > 0) {
              return 1;
            } else if (courseModel1.title.compareTo(courseModel2.title) < 0) {
              return -1;
            }
          }
          return 0;
        }
      };

  /**
   * @param courses courses for this Summary
   * @param text text for this Summary
   * @return a new set of courses based on search query
   */
  public static List<Summary> filter(
      @NonNull final List<Summary> courses, @NonNull final String text) {
    ArrayList<Summary> newCourses = new ArrayList<Summary>();
    for (int i = 0; i < courses.size(); i++) {
      if ((courses.get(i).getDepartment().toLowerCase()).contains(text.toLowerCase())
              || (courses.get(i).getNumber().toLowerCase()).contains(text.toLowerCase())
              || (text.toLowerCase().contains(courses.get(i).getNumber()))
              || (courses.get(i).getTitle().toLowerCase()).contains(text.toLowerCase())) {
        newCourses.add(courses.get(i));
      }
    }
    return newCourses;
  }
  /**
   * @return the full line of one course
   */
  public String toString() {
    String s = this.getDepartment() + " " + this.getNumber() + ": " + this.getTitle();
    return s;
  }
}
