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
public class Problem implements Cloneable {
    @Id
    Long ID;
    String name;

    @ManyToOne
    @JoinColumn(name = "ID", nullable = false)
    User author;

    @OneToMany(mappedBy = "problem")
    List<Quiz> quizzes;

    Long date;
    String description;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable (
            name = "problem_symptom",
            joinColumns = {@JoinColumn(name = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ID")}

    )
    List<Symptom> symptoms;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable (
            name = "problem_treatment",
            joinColumns = {@JoinColumn(name = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ID")}

    )
    List<Treatment> treatments;

    public Problem(Long i) {
        this.ID = i;
    }
}
