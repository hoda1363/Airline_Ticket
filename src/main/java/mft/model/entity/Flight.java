package mft.model.entity;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

@NoArgsConstructor
@SuperBuilder

public class Flight {
    private int id;
    private String name;
    private int flightNumber;
    private String companyName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Plane plane;

    public int getId() {
        return id;
    }

    public Flight setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Flight setName(String name) {
        Pattern.matches("^[a-zA-Z//s]{3,30}$",name);
        this.name = name;
        return this;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public Flight setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Flight setCompanyName(String companyName) {
        Pattern.matches("^[a-zA-Z//s]{3,30}$", companyName);
        this.companyName = companyName;
        return this;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public Flight setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Flight setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
        return this;
    }

    public Plane getPlane() {
        return plane;
    }

    public Flight setPlane(Plane plane) {
        this.plane = plane;
        return this;
    }
}
