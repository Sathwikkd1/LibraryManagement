package com.kdu.JavaAssessment2.model.address;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddressUpdateLatLong {
    @NotNull
    private Long houseId;
    @NotNull
    private String latitude;
    @NotNull
    private String longitude;
}
