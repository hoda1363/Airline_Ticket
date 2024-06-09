package mft.model.entity;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

@NoArgsConstructor
@SuperBuilder(toBuilder = true)


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

    public void setId(int id) {
        this.id = id;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public Flight setFlightNumber(int flightNumber) throws Exception {
        if (!Pattern.matches("^[\\d]{4}$", flightNumber)) {
            this flightNumber = flightNumber
        } else {
            throw new Exception("Invalid flight number");
        }
        return this;
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }








