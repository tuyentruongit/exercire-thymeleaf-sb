package demoday03.demo.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString

public class Person {
    int id;
    String fullName;
    String job;
    String gender;
    String city;
    int salary;
    LocalDate birthday;


}
