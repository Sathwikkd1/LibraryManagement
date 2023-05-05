package com.kdu.JavaAssessment2.model.room;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.IOException;

@NoArgsConstructor
@AllArgsConstructor
public class RoomDetails extends JsonSerializer<RoomDetails> {
    private Long roomId;
    private Long houseId;

    @Override
    public void serialize(RoomDetails roomDetails, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

    }
}
