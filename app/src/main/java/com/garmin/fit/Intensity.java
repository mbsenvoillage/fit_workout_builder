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


public enum Intensity  {
    ACTIVE((short)0),
    REST((short)1),
    WARMUP((short)2),
    COOLDOWN((short)3),
    RECOVERY((short)4),
    INTERVAL((short)5),
    OTHER((short)6),
    INVALID((short)255);

    protected short value;

    private Intensity(short value) {
        this.value = value;
    }

    public static Intensity getByValue(final Short value) {
        for (final Intensity type : Intensity.values()) {
            if (value == type.value)
                return type;
        }

        return Intensity.INVALID;
    }

    /**
     * Retrieves the String Representation of the Value
     * @return The string representation of the value
     */
    public static String getStringFromValue( Intensity value ) {
        return value.name();
    }

    public short getValue() {
        return value;
    }


}
