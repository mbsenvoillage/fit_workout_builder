package workout_builder_gradle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.garmin.fit.WktStepDuration;
import com.garmin.fit.WktStepTarget;
import com.garmin.fit.WorkoutStepMesg;

class WorkoutStepTest {
    public static final String STEPNAME = "Warmup";
    public static final long DURATION_VALUE = 1200000;
    public static final String NOTES = "130bpm";
    public static final String TARGET_TYPE_POWER = "power";
    public static final String DURATION_TYPE_OPEN = "open";
    public static final int TARGET_VALUE_POWER = 300;
    public static final int TARGET_LOW = 100;
    public static final int TARGET_HIGH = 200;

    @Test
    void workoutStepDurationTypeInputIsTime() {
        WorkoutStepMesg step = WorkoutStep.buildStep(1, STEPNAME, "Time", DURATION_VALUE, TARGET_TYPE_POWER,
                TARGET_VALUE_POWER, NOTES,
                null);
        WktStepDuration duration_type = step.getDurationType();
        WktStepDuration timeDuration = WktStepDuration.TIME;
        assertEquals(timeDuration, duration_type, "WktStepDuration should be TIME");
    }

    @Test
    void workoutStepDurationTypeInputIsInvalid() {
        WorkoutStepMesg step = WorkoutStep.buildStep(1, STEPNAME, "invalid_duration_type", DURATION_VALUE,
                TARGET_TYPE_POWER,
                TARGET_VALUE_POWER, NOTES,
                null);
        assertEquals(step, null, "WorkoutStepMesg should be null");
    }

    @Test
    void workoutStepDurationTypeInputIsNull() {
        WorkoutStepMesg step = WorkoutStep.buildStep(1, STEPNAME, null, DURATION_VALUE,
                TARGET_TYPE_POWER,
                TARGET_VALUE_POWER, NOTES,
                null);
        assertEquals(step, null, "WorkoutStepMesg should be null");
    }

    @Test
    void workoutStepDurationTypeInputIsDistance() {
        WorkoutStepMesg step = WorkoutStep.buildStep(1, STEPNAME, "Distance", DURATION_VALUE, TARGET_TYPE_POWER,
                TARGET_VALUE_POWER,
                NOTES,
                null);
        WktStepDuration duration_type = step.getDurationType();
        WktStepDuration distanceDuration = WktStepDuration.DISTANCE;
        assertEquals(distanceDuration, duration_type, "WktStepDuration should be DISTANCE");

    }

    @Test
    void workoutStepDurationTypeInputIsOpen() {
        WorkoutStepMesg step = WorkoutStep.buildStep(1, STEPNAME, DURATION_TYPE_OPEN, DURATION_VALUE, TARGET_TYPE_POWER,
                TARGET_VALUE_POWER, NOTES,
                null);
        WktStepDuration duration_type = step.getDurationType();
        WktStepDuration openDuration = WktStepDuration.OPEN;
        assertEquals(openDuration, duration_type, "WktStepDuration should be OPEN");

    }

    @Test
    void workoutStepDurationTypeInputIsUnknown() {
        WorkoutStepMesg step = WorkoutStep.buildStep(1, STEPNAME, "whatever", DURATION_VALUE, TARGET_TYPE_POWER,
                TARGET_VALUE_POWER,
                NOTES,
                null);
        assertTrue(step == null, "WorkoutStep should return null");
    }

    @Test
    void workoutStepIndexIsOne() {
        WorkoutStepMesg step = WorkoutStep.buildStep(1, STEPNAME, DURATION_TYPE_OPEN, DURATION_VALUE, TARGET_TYPE_POWER,
                TARGET_VALUE_POWER, NOTES,
                null);
        WorkoutStepMesg expected = new WorkoutStepMesg();
        expected.setMessageIndex(1);
        assertEquals(expected.getMessageIndex(), step.getMessageIndex(), "messageIndex should be 1");
    }

    @Test
    void workoutStepIndexIsNegativeInteger() {
        WorkoutStepMesg step = WorkoutStep.buildStep(-1, STEPNAME, DURATION_TYPE_OPEN, DURATION_VALUE,
                TARGET_TYPE_POWER,
                TARGET_VALUE_POWER, NOTES,
                null);

        assertEquals(null, step, "WorkoutStepMesg should be null");
    }

    @Test
    void workoutStepNameIsWarmup() {
        WorkoutStepMesg step = WorkoutStep.buildStep(1, STEPNAME, DURATION_TYPE_OPEN, DURATION_VALUE, TARGET_TYPE_POWER,
                TARGET_VALUE_POWER, NOTES,
                null);
        WorkoutStepMesg expected = new WorkoutStepMesg();
        expected.setWktStepName(STEPNAME);
        assertEquals(expected.getWktStepName(), step.getWktStepName(), "stepName should be \"Warmup\"");
    }

    @Test
    void workoutStepNameIsEmpty() {
        WorkoutStepMesg step = WorkoutStep.buildStep(1, "", DURATION_TYPE_OPEN, DURATION_VALUE, TARGET_TYPE_POWER,
                TARGET_VALUE_POWER,
                NOTES,
                null);
        WorkoutStepMesg expected = new WorkoutStepMesg();
        assertEquals(expected.getWktStepName(), step.getWktStepName(), "stepName should be null");
    }

    @Test
    void workoutStepNameIsNull() {
        WorkoutStepMesg step = WorkoutStep.buildStep(1, null, DURATION_TYPE_OPEN, DURATION_VALUE, TARGET_TYPE_POWER,
                TARGET_VALUE_POWER, NOTES,
                null);
        WorkoutStepMesg expected = new WorkoutStepMesg();
        assertEquals(expected.getWktStepName(), step.getWktStepName(), "stepName should be null");
    }

    @Test
    void workoutDurationValueIsPositiveInt() {
        WorkoutStepMesg step = WorkoutStep.buildStep(1, null, DURATION_TYPE_OPEN, DURATION_VALUE, TARGET_TYPE_POWER,
                TARGET_VALUE_POWER, NOTES,
                null);
        WorkoutStepMesg expected = new WorkoutStepMesg();
        expected.setDurationValue((long) DURATION_VALUE);
        assertEquals(expected.getDurationValue(), step.getDurationValue(), "durationValue should be " + DURATION_VALUE);
    }

    @Test
    void workoutDurationValueIsZero() {
        WorkoutStepMesg step = WorkoutStep.buildStep(1, null, DURATION_TYPE_OPEN, 0, TARGET_TYPE_POWER,
                TARGET_VALUE_POWER, NOTES,
                null);
        assertEquals(null, step, "WorkoutStepMesg should be null");
    }

    @Test
    void workoutTargetTypeIsPower() {
        WorkoutStepMesg step = WorkoutStep.buildStep(1, null, DURATION_TYPE_OPEN, DURATION_VALUE, TARGET_TYPE_POWER,
                TARGET_VALUE_POWER, NOTES,
                null);
        WorkoutStepMesg expected = new WorkoutStepMesg();
        expected.setTargetType(WktStepTarget.POWER);
        assertEquals(expected.getTargetType(), step.getTargetType(), "targetType should be " + TARGET_TYPE_POWER);
    }

    @Test
    void workoutTargetTypeIsNull() {
        WorkoutStepMesg step = WorkoutStep.buildStep(1, null, DURATION_TYPE_OPEN, DURATION_VALUE, null,
                TARGET_VALUE_POWER, NOTES,
                null);
        assertEquals(null, step, "targetType should be " + TARGET_TYPE_POWER);
    }

    @Test
    void workoutTargetTypeIsUnknown() {
        WorkoutStepMesg step = WorkoutStep.buildStep(1, null, DURATION_TYPE_OPEN, DURATION_VALUE, "unkown_target_type",
                TARGET_VALUE_POWER, NOTES,
                null);
        assertEquals(null, step, "targetType should be " + TARGET_TYPE_POWER);
    }

    @Test
    void workoutTargetTypeIsHeartRate() {
        WorkoutStepMesg step = WorkoutStep.buildStep(1, null, DURATION_TYPE_OPEN, DURATION_VALUE, "heart_rate",
                TARGET_VALUE_POWER, NOTES,
                null);
        WorkoutStepMesg expected = new WorkoutStepMesg();
        expected.setTargetType(WktStepTarget.HEART_RATE);
        assertEquals(expected.getTargetType(), step.getTargetType(), "targetType should be heart_rate");
    }

    @Test
    void workoutTargetTypeIsSpeed() {
        WorkoutStepMesg step = WorkoutStep.buildStep(1, null, DURATION_TYPE_OPEN, DURATION_VALUE, "speed",
                TARGET_VALUE_POWER, NOTES,
                null);
        WorkoutStepMesg expected = new WorkoutStepMesg();
        expected.setTargetType(WktStepTarget.SPEED);
        assertEquals(expected.getTargetType(), step.getTargetType(), "targetType should be speed");
    }

    @Test
    void workoutTargetTypeIsCadence() {
        WorkoutStepMesg step = WorkoutStep.buildStep(1, null, DURATION_TYPE_OPEN, DURATION_VALUE, "cadence",
                TARGET_VALUE_POWER, NOTES,
                null);
        WorkoutStepMesg expected = new WorkoutStepMesg();
        expected.setTargetType(WktStepTarget.CADENCE);
        assertEquals(expected.getTargetType(), step.getTargetType(), "targetType should be cadence");
    }

    @Test
    void workoutTargetValueIsPositiveInt() {
        WorkoutStepMesg step = WorkoutStep.buildStep(1, null, DURATION_TYPE_OPEN, DURATION_VALUE, "cadence",
                TARGET_VALUE_POWER, NOTES,
                null);
        WorkoutStepMesg expected = new WorkoutStepMesg();
        expected.setTargetValue((long) TARGET_VALUE_POWER);
        assertEquals(expected.getTargetValue(), step.getTargetValue(), "target value should be " + TARGET_VALUE_POWER);
    }

    @Test
    void workoutTargetValueIsZero() {
        WorkoutStepMesg step = WorkoutStep.buildStep(1, null, DURATION_TYPE_OPEN, DURATION_VALUE, "cadence",
                0, NOTES,
                null);
        assertEquals(null, step, "WorkoutStepMesg should be null");
    }

    @Test
    void workoutNotesIsAdvice() {
        String notes = "Some good piece of advice";
        WorkoutStepMesg step = WorkoutStep.buildStep(1, null, DURATION_TYPE_OPEN, DURATION_VALUE, "cadence",
                TARGET_VALUE_POWER, notes,
                null);
        WorkoutStepMesg expected = new WorkoutStepMesg();
        expected.setNotes(notes);
        assertEquals(expected.getNotes(), step.getNotes(), "notes should be " + "'" + notes + "'");
    }

    @Test
    void workoutNotesIsEmpty() {
        String notes = "";
        WorkoutStepMesg step = WorkoutStep.buildStep(1, null, DURATION_TYPE_OPEN, DURATION_VALUE, "cadence",
                TARGET_VALUE_POWER, notes,
                null);
        WorkoutStepMesg expected = new WorkoutStepMesg();
        expected.setNotes(notes);
        assertEquals(expected.getNotes(), step.getNotes(), "notes should be " + "'" + notes + "'");
    }

    @Test
    void workoutNotesIsNull() {
        String notes = null;
        WorkoutStepMesg step = WorkoutStep.buildStep(1, null, DURATION_TYPE_OPEN, DURATION_VALUE, "cadence",
                TARGET_VALUE_POWER, notes,
                null);
        WorkoutStepMesg expected = new WorkoutStepMesg();
        expected.setNotes(notes);
        assertEquals(expected.getNotes(), step.getNotes(), "notes should be " + "'" + notes + "'");
    }

    @Test
    void workoutRangeIsAscending() {
        int[] range = { TARGET_LOW, TARGET_HIGH };
        WorkoutStepMesg step = WorkoutStep.buildStep(1, null, DURATION_TYPE_OPEN, DURATION_VALUE, "cadence",
                TARGET_VALUE_POWER, NOTES,
                range);
        WorkoutStepMesg expected = new WorkoutStepMesg();
        expected.setCustomTargetValueLow((long) TARGET_LOW);
        expected.setCustomTargetValueHigh((long) TARGET_HIGH);
        assertEquals(expected.getCustomTargetValueLow(), step.getCustomTargetValueLow(),
                "Low target value should be " + TARGET_LOW);
        assertEquals(expected.getCustomTargetValueHigh(), step.getCustomTargetValueHigh(),
                "High target value should be " + TARGET_HIGH);

    }

    @Test
    void workoutRangeIsDescending() {
        int[] range = { TARGET_HIGH, TARGET_LOW };
        WorkoutStepMesg step = WorkoutStep.buildStep(1, null, DURATION_TYPE_OPEN, DURATION_VALUE, "cadence",
                TARGET_VALUE_POWER, NOTES,
                range);
        WorkoutStepMesg expected = new WorkoutStepMesg();
        expected.setCustomTargetValueLow((long) TARGET_LOW);
        expected.setCustomTargetValueHigh((long) TARGET_HIGH);
        assertEquals(expected.getCustomTargetValueLow(), step.getCustomTargetValueLow(),
                "Low target value should be " + TARGET_LOW);
        assertEquals(expected.getCustomTargetValueHigh(), step.getCustomTargetValueHigh(),
                "High target value should be " + TARGET_HIGH);

    }
}
