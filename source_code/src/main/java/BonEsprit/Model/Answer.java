package BonEsprit.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Answer {
    @Id
    Long ID;

    @ManyToOne
    @JoinColumn(name = "ID")
    User user;

    @ManyToOne
    @JoinColumn(name = "ID")
    Quiz quiz;

    @OneToMany(mappedBy = "answer")
    List<AnswerDetail> details;

}
