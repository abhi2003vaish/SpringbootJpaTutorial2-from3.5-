package com.codingshuttle.jpaTutorial2.hospitalManagementSystem.dto;


import com.codingshuttle.jpaTutorial2.hospitalManagementSystem.entity.type.BloodGroupType;
import lombok.Data;

@Data
public class BloodGroupStats {

    private final BloodGroupType bloodGroupType;

    private final Long count;
}
