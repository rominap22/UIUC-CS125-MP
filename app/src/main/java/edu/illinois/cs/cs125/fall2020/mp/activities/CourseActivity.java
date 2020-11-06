package edu.illinois.cs.cs125.fall2020.mp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

import edu.illinois.cs.cs125.fall2020.mp.models.Summary;

/**
 * Retrieve course activity.
 *
 */
public class CourseActivity extends AppCompatActivity {
    private static final String TAG = CourseActivity.class.getSimpleName();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Intent intent = getIntent();

        /*take smt like "COURSE", deserialize it to a Summary and use that with the client we just
        completed to retrieve information about the course (flow will be v similar to Main Activity)
        take Intent, pull out information, deserialize it to a Summary, use that in getClient method to
        retrieve information about that course, register a callback (could be courseActivity itself like
        we do with the Main Activity, network request completes and have full Course object from getCourse method
        from Client, use that Course obj info to update UI (information will have title w/ dept, number, colon,
        title + description)
        */
    }
    /**
     * Callback called when the client has retrieved the list of courses for this component to
     * display.
     *
     * @param year the year that was retrieved
     * @param courses the semester that was retrieved
     * @param setSummaries the summaries returned from the course API client
     */
    /*@Override
    public void courseResponse(
            final Summary s, final Course c) {
        courses = Arrays.asList(setSummaries);
        listAdapter.edit().replaceAll(courses).commit();
    }*/
}
