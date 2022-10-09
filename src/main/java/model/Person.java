package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Person")
@Data
@NoArgsConstructor
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "age")
    private int age;
    @Column(name = "names")
    private String names;

    public Person(int age, String names) {
        this.age = age;
        this.names = names;
    }
}
