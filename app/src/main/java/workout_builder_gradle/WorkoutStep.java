package workout_builder_gradle;

import java.util.Arrays;
import com.garmin.fit.WktStepDuration;
import com.garmin.fit.WktStepTarget;
import com.garmin.fit.WorkoutStepMesg;

public abstract class WorkoutStep {

    public static WorkoutStepMesg buildStep(int index, String stepName, String durationType, long durationValue,
            String targetType,
            int targetValue, String notes, int[] range) {
        WorkoutStepMesg step = new WorkoutStepMesg();

        WktStepDuration formattedDurationType = WorkoutStep.getDurationType(durationType);
        WktStepTarget formattedTargetType = WorkoutStep.getTargetType(targetType);

        if (cannotBuildValidStep(index, formattedDurationType, formattedTargetType, durationValue, range,
                targetValue)) {
            return null;
        }

        step.setMessageIndex(index);
        step.setWktStepName(stepName);
        step.setDurationValue(((long) durationValue));
        step.setNotes(notes);
        step.setDurationType(formattedDurationType);
        step.setTargetType(formattedTargetType);

        if (targetValue > 0) {
            step.setTargetValue((long) targetValue);
            step.setCustomTargetValueLow((long) 0);
            step.setCustomTargetValueHigh((long) 0);
        }

        if (range != null) {
            Arrays.sort(range);
            step.setTargetValue((long) 0);
            step.setCustomTargetValueLow((long) range[0]);
            step.setCustomTargetValueHigh((long) range[1]);
        }

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

    private static boolean isIndexInvalid(int index) {
        return index < 0;
    }

    private static boolean isDurationTypeInvalid(WktStepDuration durationType) {
        return durationType == null;
    }

    private static boolean isTargetTypeInvalid(WktStepTarget targetType) {
        return targetType == null;
    }

    private static boolean isDurationValueInvalid(long durationValue) {
        return durationValue <= 0;
    }

    private static boolean isWorkoutTargetsInvalid(int[] range, int targetValue) {
        return (range == null && targetValue <= 0)
                || (range != null && (range[0] <= 0 && range[1] <= 0) && targetValue <= 0);
    }

    private static boolean cannotBuildValidStep(int index, WktStepDuration durationType, WktStepTarget targetType,
            long durationValue, int[] range, int targetValue) {
        return isIndexInvalid(index) || isDurationTypeInvalid(durationType)
                || isTargetTypeInvalid(targetType) || isDurationValueInvalid(durationValue)
                || isWorkoutTargetsInvalid(range, targetValue);
    }
}
