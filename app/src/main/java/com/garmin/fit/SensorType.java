////////////////////////////////////////////////////////////////////////////////
// The following FIT Protocol software provided may be used with FIT protocol
// devices only and remains the copyrighted property of Garmin Canada Inc.
// The software is being provided on an "as-is" basis and as an accommodation,
// and therefore all warranties, representations, or guarantees of any kind
// (whether express, implied or statutory) including, without limitation,
// warranties of merchantability, non-infringement, or fitness for a particular
// purpose, are specifically disclaimed.
//
// Copyright 2021 Garmin International, Inc.
////////////////////////////////////////////////////////////////////////////////
// ****WARNING****  This file is auto-generated!  Do NOT edit this file.
// Profile Version = 21.67Release
// Tag = production/akw/21.67.00-0-gd790f76b
////////////////////////////////////////////////////////////////////////////////


package com.garmin.fit;


public enum SensorType  {
    ACCELEROMETER((short)0),
    GYROSCOPE((short)1),
    COMPASS((short)2),
    BAROMETER((short)3),
    INVALID((short)255);

    protected short value;

    private SensorType(short value) {
        this.value = value;
    }

    public static SensorType getByValue(final Short value) {
        for (final SensorType type : SensorType.values()) {
            if (value == type.value)
                return type;
        }

        return SensorType.INVALID;
    }

    /**
     * Retrieves the String Representation of the Value
     * @return The string representation of the value
     */
    public static String getStringFromValue( SensorType value ) {
        return value.name();
    }

    public short getValue() {
        return value;
    }


}
