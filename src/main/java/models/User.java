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

    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "passport_id", referencedColumnName = "id")
    @ToString.Exclude
    private Passport passport;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_card",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id")
    )
    private List<Card> cards;

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
