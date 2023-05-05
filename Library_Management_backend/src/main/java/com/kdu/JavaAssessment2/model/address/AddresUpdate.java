package com.kdu.JavaAssessment2.model.address;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;

@Data
public class AddresUpdate {
    @NotNull
    private Long houseId;
    @NotNull
    private String address;

}
