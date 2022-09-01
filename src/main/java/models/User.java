package models;




import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ElementCollection(fetch = FetchType.LAZY)
    private List<String> skills;

    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "passport_id", referencedColumnName = "id")
    private Passport passport;

    public User(String name) {
        this.name = name;
    }

    public User(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public User(String name, Gender gender, List<String> skills) {
        this.name = name;
        this.gender = gender;
        this.skills = skills;
    }

    public User(String name, Gender gender, List<String> skills, Passport passport) {
        this.name = name;
        this.gender = gender;
        this.skills = skills;
        this.passport = passport;
    }
}
