package workout_builder_gradle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.garmin.fit.WktStepDuration;
import com.garmin.fit.WorkoutStepMesg;

class WorkoutStepTest {
    @Test
    void workoutStepDurationTimeInputIsTime() {
        WorkoutStepMesg step = WorkoutStep.buildStep(1, "Warmup", "Time", 1200000, "Watts", 300, "130bpm", null);
        WktStepDuration duration_type = step.getDurationType();
        WktStepDuration timeDuration = WktStepDuration.TIME;
        assertEquals(timeDuration, duration_type, "WktStepDuration should be TIME");
    }

    @Test
    void workoutStepDurationTimeInputIsDistance() {
        WorkoutStepMesg step = WorkoutStep.buildStep(1, "Warmup", "Distance", 1200000, "Watts", 300, "130bpm", null);
        WktStepDuration duration_type = step.getDurationType();
        WktStepDuration distanceDuration = WktStepDuration.DISTANCE;
        assertEquals(distanceDuration, duration_type, "WktStepDuration should be DISTANCE");

    }

    @Test
    void workoutStepDurationTimeInputIsOpen() {
        WorkoutStepMesg step = WorkoutStep.buildStep(1, "Warmup", "Open", 1200000, "Watts", 300, "130bpm", null);
        WktStepDuration duration_type = step.getDurationType();
        WktStepDuration openDuration = WktStepDuration.OPEN;
        assertEquals(openDuration, duration_type, "WktStepDuration should be OPEN");

    }

    @Test
    void workoutStepDurationTimeInputIsUnknown() {
        WorkoutStepMesg step = WorkoutStep.buildStep(1, "Warmup", "whatever", 1200000, "Watts", 300, "130bpm", null);
        assertTrue(step == null, "WorkoutStep should return null");
    }
}
