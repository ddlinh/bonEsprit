package BonEsprit.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Quiz implements Cloneable {
    @Id
    Long ID;
    String name;

    @ManyToOne
    @JoinColumn(name = "ID")
    Problem problem;

    @ManyToOne
    @JoinColumn(name = "ID")
    User author;

    @OneToMany(mappedBy = "quiz")
    List<Question> questions;

    @OneToMany(mappedBy = "quiz")
    List<Answer> answers;

    @ManyToMany(mappedBy = "quizzes")
    List<User> users;

    Date date;

    public Quiz(long l) {
        this.ID = l;
    }
}
