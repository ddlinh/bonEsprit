package BonEsprit.Model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User implements Cloneable {
    @Id
    Long ID;
    String userName;
    String passWord;
    String firstName;
    String lastName;
    String email;
    String workingPlace;
    int experiences;

    @OneToMany(mappedBy = "therapist")
    List<Certificate> certificates;
    Integer typeUser;

    public User(Long id) {
        this.ID = id;
    }

    public User(User a) {
        this.ID = a.ID;
        this.userName = a.userName;
        this.passWord = a.passWord;
        this.firstName = a.firstName;
        this.lastName = a.lastName;
        this.email = a.email;

        for(int i = 0; i < a.certificates.size(); i++)
            this.certificates.set(i, a.certificates.get(i));

        this.typeUser = a.typeUser;
    }

    @OneToMany(mappedBy = "user")
    List<Answer> answers;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable (
            name = "user_quiz_answer",
            joinColumns = {@JoinColumn(name = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ID")}

    )
    List<Quiz> quizzes;

    @Override
    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }
}
