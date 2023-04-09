package com.app.travel.models.additionaldata;

import com.app.travel.util.GenericCaster;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class TripRoutesData extends AdditionalData {
    @Getter
    @Setter
    private Integer num_of_stops;

    public static AdditionalData CastFromMap(Map<String, Object> kvp) {
        return GenericCaster.mapToType(kvp, TripRoutesData.class, new TripRoutesData());
    }

    public static AdditionalData CastFromString(String json) {
        return GenericCaster.mapToType(json, TripRoutesData.class);
    }
}
