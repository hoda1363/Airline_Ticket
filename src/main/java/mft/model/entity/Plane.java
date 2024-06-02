package mft.model.entity;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import mft.model.entity.enums.Airline;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class Plane {
    private int id;
    private String name;
    private Airline airline;
    private int flightNumber;
    private String aircraftType;
    private String route;
    private int capacity;


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
