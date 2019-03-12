package ua.com.ehp.tasktest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString(exclude = {"department"})
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String empName;
    String empActive;

    @JsonIgnore
    @ManyToOne(
            cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY)
    Department department;

    public Employee(String empName, String empActive) {
        this.empName = empName;
        this.empActive = empActive;
    }
}
