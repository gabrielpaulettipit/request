package gabriel.pauletti.oraclehcm_request.personnotes;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "personnotes")
@Entity(name = "personnotes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PersonNotesEntity {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private Long NoteId;
	private String LastUpdateDate;
	private Boolean HiddenFlag;
	private String WorkerName;
	
	public PersonNotesEntity(PersonNotesRecord dados) {
    	this.NoteId = dados.NoteId();
        this.LastUpdateDate = dados.LastUpdateDate();
        this.HiddenFlag = dados.HiddenFlag();
        this.WorkerName = dados.WorkerName();
    }
}
