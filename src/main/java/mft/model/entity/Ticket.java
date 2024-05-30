package mft.model.entity;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import mft.model.entity.enums.Airline;


import java.time.LocalDateTime;
import java.time.LocalTime;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class Ticket {
    private int id;
    private LocalDateTime dateTime;
    private String source;  //manbae
    private String destination; //maghsad
    private LocalTime duration;
    private boolean confirm;
    private Flight flight;
    private Airline airline;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}











