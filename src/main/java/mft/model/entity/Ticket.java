package mft.model.entity;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class Ticket {
    private int id;
    private LocalDateTime dateTime;
    private String source;
    private String destination;
    private int duration;
    private boolean confirm;
    private Flight flight;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}











