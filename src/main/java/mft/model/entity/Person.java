package mft.model.entity;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder(toBuilder = true)

public class Person {
    private int id;
    private String name;
    private String family;
    private String nationalId;
    private LocalDate birthDate;
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
