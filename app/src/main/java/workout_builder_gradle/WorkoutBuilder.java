package workout_builder_gradle;

import java.util.ArrayList;

import org.json.JSONObject;

public class WorkoutBuilder {

    private String sport_name;
    private int num_of_steps;
    private String workout_name;

    public WorkoutBuilder(String json) {
        JSONObject jo = new JSONObject(json);
        this.sport_name = jo.getString("sport_name");
        this.num_of_steps = (int) jo.getLong("num_of_steps");
    }

    public Integer getNumOfSteps() {
        return this.num_of_steps;
    }

    public String getSportName() {
        return this.sport_name;
    }
}
