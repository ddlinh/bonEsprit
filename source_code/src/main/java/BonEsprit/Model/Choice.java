package BonEsprit.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Choice {
    @Id
    Long ID;

    String content;
    int score;

    @ManyToOne
    @JoinColumn(name = "ID")
    Question question;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "choice")
    List<AnswerDetail> answerDetails;
}
