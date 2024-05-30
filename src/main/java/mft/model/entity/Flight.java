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


public class Flight {
    private int id;
    private String name;
    private int flightNumber;
    private String companyName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Plane plane;



    @Override
    public String toString() {
        return new Gson().toJson(this);}}








