package workout_builder_gradle;

import java.util.HashMap;
import java.util.Map;
import com.garmin.fit.WktStepDuration;
import com.garmin.fit.WorkoutStepMesg;

public abstract class WorkoutStep {

    public static WorkoutStepMesg buildStep(int index, String step_name, String duration_type, long duration_value,
            String target_type,
            int target_value, String notes, int[] range) {
        WorkoutStepMesg step = new WorkoutStepMesg();

        WktStepDuration formatted_duration_type = WorkoutStep.getDurationType(duration_type);
        if (formatted_duration_type == null) {
            return null;
        }
        step.setDurationType(formatted_duration_type);

        return step;
    }

    private static WktStepDuration getDurationType(String duration_type) {
        Map<String, WktStepDuration> enumMap = new HashMap<String, WktStepDuration>();
        enumMap.put("time", WktStepDuration.TIME);
        enumMap.put("distance", WktStepDuration.DISTANCE);
        enumMap.put("open", WktStepDuration.OPEN);
        return enumMap.get(duration_type.toLowerCase());
    }

    private static boolean isWorkoutStepMesgValid(WorkoutStepMesg mesg) {
        return true;
    }

}
