package com.kdu.JavaAssessment2.model.house;

import com.kdu.JavaAssessment2.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseModel {
    @NotNull
    private String address;
}
