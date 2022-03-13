package workout_builder_gradle;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import com.garmin.fit.DateTime;
import com.garmin.fit.File;
import com.garmin.fit.FileEncoder;
import com.garmin.fit.FileIdMesg;
import com.garmin.fit.Intensity;
import com.garmin.fit.Manufacturer;
import com.garmin.fit.Sport;
import com.garmin.fit.SubSport;
import com.garmin.fit.WktStepDuration;
import com.garmin.fit.WktStepTarget;
import com.garmin.fit.WorkoutMesg;
import com.garmin.fit.WorkoutStepMesg;
import com.garmin.fit.Fit;
import com.garmin.fit.FitRuntimeException;

public class App {
    public static void main(String[] args) throws Exception {

        String example = "{" +
                "\"num_of_steps\": 3," +
                "\"sport_name\": \"cycling\"," +
                "\"workout_name\": \"VO2 Max killer sesh\"," +
                "\"workout_steps\": [" +
                "{" +
                "\"index\": 1," +
                "\"step_name\": \"Warm up\"," +
                "\"duration_type\": \"Time\"," +
                "\"duration_value\": 600000," +
                "\"target_type\": \"Watts\"," +
                "\"target_value\": null," +
                "\"notes\": \"Keep it high rpm\"," +
                "\"range\": [150, 200]" +
                "}," +
                "{" +
                "\"index\": 2," +
                "\"step_name\": \"Tempo for 20 mins\"," +
                "\"duration_type\": \"Time\"," +
                "\"duration_value\": 1200000," +
                "\"target_type\": \"Watts\"," +
                "\"target_value\": null," +
                "\"notes\": \"Keep it around 90/110rpm\"," +
                "\"range\": [220, 250]" +
                "}," +
                "{" +
                "\"index\": 3," +
                "\"step_name\": \"Cool down for 20mins\"," +
                "\"duration_type\": \"Time\"," +
                "\"duration_value\": 1200000," +
                "\"target_type\": \"Watts\"," +
                "\"target_value\": null," +
                "\"notes\": \"Keep it around 90/110rpm\"," +
                "\"range\": [140, 190]" +
                "}" +
                "]" +
                "}";

    }

    private static WorkoutStepMesg CreateWorkoutStep(int messageIndex,
            String name,
            String notes,
            Intensity intensity,
            WktStepDuration durationType,
            Integer durationValue,
            WktStepTarget targetType,
            int targetValue,
            Integer customTargetValueLow,
            Integer customTargetValueHigh) {

        WorkoutStepMesg workoutStepMesg = new WorkoutStepMesg();
        workoutStepMesg.setMessageIndex(messageIndex);

        if (name != null) {
            workoutStepMesg.setWktStepName(name);
        }

        if (notes != null) {
            workoutStepMesg.setNotes(notes);
        }

        if (durationType == WktStepDuration.INVALID) {
            return null;
        }

        workoutStepMesg.setIntensity(intensity);
        workoutStepMesg.setDurationType(durationType);

        if (durationValue != null) {
            workoutStepMesg.setDurationValue((long) durationValue);
        }

        if (targetType != WktStepTarget.INVALID && customTargetValueLow != null && customTargetValueHigh != null) {
            workoutStepMesg.setTargetType(targetType);
            workoutStepMesg.setTargetValue((long) 0);
            workoutStepMesg.setCustomTargetValueLow((long) customTargetValueLow);
            workoutStepMesg.setCustomTargetValueHigh((long) customTargetValueHigh);
        } else if (targetType != WktStepTarget.INVALID) {
            workoutStepMesg.setTargetValue((long) targetValue);
            workoutStepMesg.setTargetType(targetType);
            workoutStepMesg.setCustomTargetValueLow((long) 0);
            workoutStepMesg.setCustomTargetValueHigh((long) 0);
        }

        return workoutStepMesg;
    }

    public static void CreateWorkout(WorkoutMesg workoutMesg, ArrayList<WorkoutStepMesg> workoutSteps) {
        // The combination of file type, manufacturer id, product id, and serial number
        // should be unique.
        // When available, a non-random serial number should be used.
        File filetype = File.WORKOUT;
        short manufacturerId = Manufacturer.DEVELOPMENT;
        short productId = 0;
        Random random = new Random();
        int serialNumber = random.nextInt();

        // Every FIT file MUST contain a File ID message
        FileIdMesg fileIdMesg = new FileIdMesg();
        fileIdMesg.setType(filetype);
        fileIdMesg.setManufacturer((int) manufacturerId);
        fileIdMesg.setProduct((int) productId);
        fileIdMesg.setTimeCreated(new DateTime(new Date()));
        fileIdMesg.setSerialNumber((long) serialNumber);

        // Create the output stream
        FileEncoder encode;
        String filename = workoutMesg.getWktName().replace(" ", "_") + ".fit";

        try {
            encode = new FileEncoder(new java.io.File(filename), Fit.ProtocolVersion.V1_0);
        } catch (FitRuntimeException e) {
            System.err.println("Error opening file " + filename);
            e.printStackTrace();
            return;
        }

        // Write the messages to the file, in the proper sequence
        encode.write(fileIdMesg);
        encode.write(workoutMesg);

        for (WorkoutStepMesg workoutStep : workoutSteps) {
            encode.write(workoutStep);
        }

        // Close the output stream
        try {
            encode.close();
        } catch (FitRuntimeException e) {
            System.err.println("Error closing encode.");
            e.printStackTrace();
            return;
        }

        System.out.println("Encoded FIT Workout File " + filename);
    }

    private static WorkoutStepMesg CreateWorkoutStep(int messageIndex,
            String name,
            String notes,
            Intensity intensity,
            WktStepDuration durationType,
            Integer durationValue,
            WktStepTarget targetType,
            int targetValue) {

        return CreateWorkoutStep(
                messageIndex, name, notes, intensity,
                durationType, durationValue, targetType,
                targetValue, null, null);
    }

    public static void CreateBikeTempoWorkout() {
        ArrayList<WorkoutStepMesg> workoutSteps = new ArrayList<WorkoutStepMesg>();

        // Warm up 10min (60000ms) in Heart Rate Zone 1
        workoutSteps.add(CreateWorkoutStep(
                workoutSteps.size(),
                "Warm up 10min in Heart Rate Zone 1",
                null,
                Intensity.WARMUP,
                WktStepDuration.TIME,
                600000,
                WktStepTarget.HEART_RATE,
                1));

        // Bike 40min (240000ms) Power Zone 3
        workoutSteps.add(CreateWorkoutStep(
                workoutSteps.size(),
                "Bike 40min Power Zone 3",
                null,
                Intensity.ACTIVE,
                WktStepDuration.TIME,
                2400000,
                WktStepTarget.POWER,
                3));

        // Cool Down Until Lap Button Pressed, No Target (0)
        workoutSteps.add(CreateWorkoutStep(
                workoutSteps.size(),
                "Cool Down Until Lap Button Pressed",
                null,
                Intensity.COOLDOWN,
                WktStepDuration.OPEN,
                null,
                WktStepTarget.OPEN,
                0));

        WorkoutMesg workoutMesg = new WorkoutMesg();
        workoutMesg.setWktName("Tempo Bike");
        workoutMesg.setSport(Sport.CYCLING);
        workoutMesg.setSubSport(SubSport.INVALID);
        workoutMesg.setNumValidSteps(workoutSteps.size());

        CreateWorkout(workoutMesg, workoutSteps);
    }

}
