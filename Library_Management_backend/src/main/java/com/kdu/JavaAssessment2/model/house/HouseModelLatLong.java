package com.kdu.JavaAssessment2.model.house;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class HouseModelLatLong {
    @NotNull
    private String latitude;
    @NotNull
    private String longitude;
}
