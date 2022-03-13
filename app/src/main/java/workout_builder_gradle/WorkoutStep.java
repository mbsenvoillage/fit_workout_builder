package workout_builder_gradle;

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
        try {
            return WktStepDuration.valueOf(durationType.toUpperCase());
        } catch (Exception e) {
            System.out.println("No such duration type in Enum");
            return null;
        }
    }

    private static WktStepTarget getTargetType(String targetType) {
        try {
            return WktStepTarget.valueOf(targetType.toUpperCase());
        } catch (Exception e) {
            System.out.println("No such target type in Enum");
            return null;
        }
    }

    private static boolean isWorkoutStepMesgValid(WorkoutStepMesg mesg) {
        return true;
    }

}
