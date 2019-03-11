package ua.com.ehp.tasktest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString(exclude = {"employee"})
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String dpName;

    @JsonIgnore
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "department"
    )
    List<Employee> employees;

    public Department(String dpName) {
        this.dpName = dpName;
    }
}
