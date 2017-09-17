package tianki.helloworld;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tiank on 9/5/2017.
 */

public class ActiviotyCollector {
    private static List<Activity> _activities = new ArrayList<>();

    public static void addActivity(Activity activity) {
        _activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        _activities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : _activities) {
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}

