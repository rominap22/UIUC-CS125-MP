package edu.illinois.cs.cs125.fall2020.mp.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.illinois.cs.cs125.fall2020.mp.R;
import edu.illinois.cs.cs125.fall2020.mp.application.CourseableApplication;
import edu.illinois.cs.cs125.fall2020.mp.databinding.ActivityCourseBinding;
import edu.illinois.cs.cs125.fall2020.mp.models.Course;
import edu.illinois.cs.cs125.fall2020.mp.models.Rating;
import edu.illinois.cs.cs125.fall2020.mp.models.Summary;
import edu.illinois.cs.cs125.fall2020.mp.network.Client;

/** Retrieve course activity. */
public class CourseActivity extends AppCompatActivity implements Client.CourseClientCallbacks {
  private static final String TAG = CourseActivity.class.getSimpleName();
  // Binding to the layout in activity_main.xml
  private ActivityCourseBinding binding;
  /** onCreate for deserializing String to Summary and getting callbacks. */
  @Override
  public void onCreate(@Nullable final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Intent intent = getIntent();
    String json = intent.getStringExtra("COURSE");
    binding = DataBindingUtil.setContentView(this, R.layout.activity_course);

    // deserialize here from String to a Summary
    ObjectMapper mapper = new ObjectMapper();
    Summary s = new Summary();
    try {
      // deserialize here from String to a Summary
      s = mapper.readValue(json, Course.class);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    // get course from client
    CourseableApplication application = (CourseableApplication) getApplication();
    application.getCourseClient().getCourse(s, this); // this = courseResponse below
  }
  /**
   * Callback called when the client has retrieved the list of courses for this component to
   * display.
   */
  @Override
  public void courseResponse(final Summary s, final Course c) {
    // title (dept, number, title), description
    binding.header.setText(s.toString());
    binding.description.setText(c.getDescription());
  }
  /**
   * Callback called when the client has retrieved the list of courses for this component to
   * display.
   */
  @Override
  public void yourRating(final Summary s, final Rating r) {
    binding.rating.setRating((float) r.getRating());
  }
}
