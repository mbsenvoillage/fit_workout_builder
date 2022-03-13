package workout_builder_gradle;

import java.util.HashMap;
import java.util.Map;
import com.garmin.fit.WktStepDuration;
import com.garmin.fit.WktStepTarget;
import com.garmin.fit.WorkoutStepMesg;

public abstract class WorkoutStep {

    public static WorkoutStepMesg buildStep(int index, String stepName, String durationType, long durationValue,
            String targetType,
            int targetValue, String notes, int[] range) {
        WorkoutStepMesg step = new WorkoutStepMesg();

        step.setMessageIndex(index);
        step.setWktStepName(stepName);
        step.setDurationValue(((long) durationValue));
        step.setNotes(notes);

        WktStepDuration formatted_durationType = WorkoutStep.getDurationType(durationType);
        if (formatted_durationType == null) {
            return null;
        }
        step.setDurationType(formatted_durationType);

        WktStepTarget formattedTargetType = WorkoutStep.getTargetType(targetType);
        if (formattedTargetType == null) {
            return null;
        }
        step.setTargetType(formattedTargetType);

        return step;
    }

    private static WktStepDuration getDurationType(String durationType) {
        Map<String, WktStepDuration> enumMap = new HashMap<String, WktStepDuration>();
        enumMap.put("time", WktStepDuration.TIME);
        enumMap.put("distance", WktStepDuration.DISTANCE);
        enumMap.put("open", WktStepDuration.OPEN);
        return enumMap.get(durationType.toLowerCase());
    }

    private static WktStepTarget getTargetType(String targetType) {
        Map<String, WktStepTarget> enumMap = new HashMap<String, WktStepTarget>();
        enumMap.put("power", WktStepTarget.POWER);
        enumMap.put("speed", WktStepTarget.SPEED);
        enumMap.put("cadence", WktStepTarget.CADENCE);
        enumMap.put("hr", WktStepTarget.HEART_RATE);
        return enumMap.get(targetType.toLowerCase());
    }

    private static boolean isWorkoutStepMesgValid(WorkoutStepMesg mesg) {
        return true;
    }

}
