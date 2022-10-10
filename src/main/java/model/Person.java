package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.List;

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

    @OneToMany(mappedBy = "owner")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Item> items;

    public Person(int age, String names) {
        this.age = age;
        this.names = names;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", names='" + names + '\'' +
                '}';
    }
}
