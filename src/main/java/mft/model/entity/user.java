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

public class user{
    private int id;
    private String username;
    private String password;
    private boolean enabled;


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
