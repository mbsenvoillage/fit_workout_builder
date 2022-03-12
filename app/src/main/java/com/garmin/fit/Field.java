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

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.DataInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.io.OutputStreamWriter;

public class Field extends FieldBase {
    protected String name;
    protected int num;
    protected int type;
    protected double scale;
    protected double offset;
    protected String units;
    protected boolean isAccumulated;
    protected ArrayList<FieldComponent> components;
    protected ArrayList<SubField> subFields;

    private Profile.Type profileType;
    private boolean isExpandedField;

    public Field(final Field field) {
        super(field);
        if (field == null) {
            this.name = "unknown";
            this.num = Fit.FIELD_NUM_INVALID;
            this.type = 0;
            this.profileType = Profile.Type.ENUM;
            this.scale = 1;
            this.offset = 0;
            this.units = "";
            this.isAccumulated = false;
            this.values = new ArrayList<Object>();
            this.components = new ArrayList<FieldComponent>();
            this.subFields = new ArrayList<SubField>();
            this.isExpandedField = false;
            return;
        }

        this.name = new String(field.name);
        this.num = field.num;
        this.type = field.type;
        this.profileType = field.profileType;
        this.scale = field.scale;
        this.offset = field.offset;
        this.units = new String(field.units);
        this.isAccumulated = field.isAccumulated;
        this.components = field.components;
        this.subFields = field.subFields;
        this.isExpandedField = field.isExpandedField;
    }

    protected Field(String name, int num, int type, double scale, double offset, String units, boolean accumulated, Profile.Type profileType) {
        this.name = new String(name);
        this.num = num;
        this.type = type;
        this.profileType = profileType;
        this.scale = scale;
        this.offset = offset;
        this.units = new String(units);
        this.isAccumulated = accumulated;
        this.components = new ArrayList<FieldComponent>();
        this.subFields = new ArrayList<SubField>();
        this.isExpandedField = false;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String getUnits() {
        return this.units;
    }

    @Override
    public int getType() {
        return this.type;
    }

    public Profile.Type getProfileType() {
        return this.profileType;
    }

    @Override
    protected double getOffset() {
        return offset;
    }

    @Override
    protected double getScale() {
        return scale;
    }

    @Override
    protected String getFieldName() {
        return name;
    }

    public boolean getIsAccumulated() {
        return this.isAccumulated;
    }

    protected void setIsExpanded(boolean newValue) {
        isExpandedField = newValue;
    }

    protected boolean getIsExpanded() {
        return isExpandedField;
    }

    @Override
    protected SubField getSubField(String subFieldName) {
        for (int i = 0; i < subFields.size(); i++) {
            if (subFields.get(i).name.equals(subFieldName)) {
                return subFields.get(i);
            }
        }

        return null;
    }

    @Override
    protected SubField getSubField(int subFieldIndex) {
        if ((subFieldIndex >= 0) && (subFieldIndex < subFields.size())) {
            return subFields.get(subFieldIndex);
        } else {
            return null;
        }
    }
}
