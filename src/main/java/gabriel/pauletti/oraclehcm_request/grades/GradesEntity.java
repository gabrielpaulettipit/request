package gabriel.pauletti.oraclehcm_request.grades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "grades")
@Entity(name = "grades")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class GradesEntity {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private Long GradeId;
	private String GradeName;
	private String GradeCode;
	private String ActiveStatus;
	
	public GradesEntity(GradeRecord dados) {
    	this.GradeId = dados.GradeId();
        this.GradeName = dados.GradeName();
        this.GradeCode = dados.GradeCode();
        this.ActiveStatus = dados.ActiveStatus();
    }
}
