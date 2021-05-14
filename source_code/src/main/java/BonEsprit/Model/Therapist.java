package BonEsprit.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Therapist extends User {
    public Therapist(User a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	Integer exp;
    String workingPlace;

    @OneToMany(mappedBy = "author")
    List<Problem> problems;

    @OneToMany(mappedBy = "author")
    List<Quiz> quizzes;
}
