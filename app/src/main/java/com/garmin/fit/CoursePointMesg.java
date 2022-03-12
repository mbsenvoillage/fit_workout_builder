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



public class CoursePointMesg extends Mesg   {

    
    public static final int MessageIndexFieldNum = 254;
    
    public static final int TimestampFieldNum = 1;
    
    public static final int PositionLatFieldNum = 2;
    
    public static final int PositionLongFieldNum = 3;
    
    public static final int DistanceFieldNum = 4;
    
    public static final int TypeFieldNum = 5;
    
    public static final int NameFieldNum = 6;
    
    public static final int FavoriteFieldNum = 8;
    

    protected static final  Mesg coursePointMesg;
    static {
        // course_point
        coursePointMesg = new Mesg("course_point", MesgNum.COURSE_POINT);
        coursePointMesg.addField(new Field("message_index", MessageIndexFieldNum, 132, 1, 0, "", false, Profile.Type.MESSAGE_INDEX));
        
        coursePointMesg.addField(new Field("timestamp", TimestampFieldNum, 134, 1, 0, "", false, Profile.Type.DATE_TIME));
        
        coursePointMesg.addField(new Field("position_lat", PositionLatFieldNum, 133, 1, 0, "semicircles", false, Profile.Type.SINT32));
        
        coursePointMesg.addField(new Field("position_long", PositionLongFieldNum, 133, 1, 0, "semicircles", false, Profile.Type.SINT32));
        
        coursePointMesg.addField(new Field("distance", DistanceFieldNum, 134, 100, 0, "m", false, Profile.Type.UINT32));
        
        coursePointMesg.addField(new Field("type", TypeFieldNum, 0, 1, 0, "", false, Profile.Type.COURSE_POINT));
        
        coursePointMesg.addField(new Field("name", NameFieldNum, 7, 1, 0, "", false, Profile.Type.STRING));
        
        coursePointMesg.addField(new Field("favorite", FavoriteFieldNum, 0, 1, 0, "", false, Profile.Type.BOOL));
        
    }

    public CoursePointMesg() {
        super(Factory.createMesg(MesgNum.COURSE_POINT));
    }

    public CoursePointMesg(final Mesg mesg) {
        super(mesg);
    }


    /**
     * Get message_index field
     *
     * @return message_index
     */
    public Integer getMessageIndex() {
        return getFieldIntegerValue(254, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set message_index field
     *
     * @param messageIndex
     */
    public void setMessageIndex(Integer messageIndex) {
        setFieldValue(254, 0, messageIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get timestamp field
     *
     * @return timestamp
     */
    public DateTime getTimestamp() {
        return timestampToDateTime(getFieldLongValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD));
    }

    /**
     * Set timestamp field
     *
     * @param timestamp
     */
    public void setTimestamp(DateTime timestamp) {
        setFieldValue(1, 0, timestamp.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get position_lat field
     * Units: semicircles
     *
     * @return position_lat
     */
    public Integer getPositionLat() {
        return getFieldIntegerValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set position_lat field
     * Units: semicircles
     *
     * @param positionLat
     */
    public void setPositionLat(Integer positionLat) {
        setFieldValue(2, 0, positionLat, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get position_long field
     * Units: semicircles
     *
     * @return position_long
     */
    public Integer getPositionLong() {
        return getFieldIntegerValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set position_long field
     * Units: semicircles
     *
     * @param positionLong
     */
    public void setPositionLong(Integer positionLong) {
        setFieldValue(3, 0, positionLong, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get distance field
     * Units: m
     *
     * @return distance
     */
    public Float getDistance() {
        return getFieldFloatValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set distance field
     * Units: m
     *
     * @param distance
     */
    public void setDistance(Float distance) {
        setFieldValue(4, 0, distance, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get type field
     *
     * @return type
     */
    public CoursePoint getType() {
        Short value = getFieldShortValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return CoursePoint.getByValue(value);
    }

    /**
     * Set type field
     *
     * @param type
     */
    public void setType(CoursePoint type) {
        setFieldValue(5, 0, type.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get name field
     *
     * @return name
     */
    public String getName() {
        return getFieldStringValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set name field
     *
     * @param name
     */
    public void setName(String name) {
        setFieldValue(6, 0, name, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get favorite field
     *
     * @return favorite
     */
    public Bool getFavorite() {
        Short value = getFieldShortValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return Bool.getByValue(value);
    }

    /**
     * Set favorite field
     *
     * @param favorite
     */
    public void setFavorite(Bool favorite) {
        setFieldValue(8, 0, favorite.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
