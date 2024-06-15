package mft.model.entity;


import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


import java.time.LocalDate;
import java.util.regex.Pattern;

@NoArgsConstructor
@SuperBuilder(toBuilder = true)

public class Person {
    private int id;
    private String name;
    private String family;
    private String nationalId;
    private LocalDate birthDate;

    public int getId() {
        return id;
    }

    public Person setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) throws Exception {
        if (Pattern.matches("^[a-zA-Z\\s]{2,30}$", name)) {
            this.name = name;
        } else {
            throw new Exception("Invalid Name");
        }
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Person setFamily(String family) throws Exception {
        if (Pattern.matches("^[a-zA-Z\\s]{2,30}$", family)) {
            this.family = family;
        } else {
            throw new Exception("Invalid Family");
        }
        return this;
    }

    public String getNationalId() {
        return nationalId;
    }

    public Person setNationalId(String nationalId) throws Exception {
        if (Pattern.matches("^[\\d]{10}|[\\d]{3}-[\\d]{6}-[\\d]$", nationalId)) { //TODO
            this.nationalId = nationalId;
        } else {
            throw new Exception("Invalid NationalId");
        }
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Person setBirthDate(LocalDate birthDate) throws Exception {
        if (Pattern.matches("^[\\D]{2}-[\\d]{2}-[\\d]{4}$", birthDate.toString())) {    //TODO
            this.birthDate = birthDate;
        } else {
            throw new Exception("Invalid Birth Date");
        }
        return this;
    }
}
