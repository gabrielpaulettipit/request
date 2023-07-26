package gabriel.pauletti.oraclehcm_request.workload;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "workload")
@Entity(name = "workload")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class WorkloadEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String idProcess;
	@Column(columnDefinition = "int default 0")
	private int offset;
	@Column(columnDefinition = "int default 0")
	private int quantityRows;
	private String container;
	private LocalDateTime startRequest;
	private LocalDateTime endRequest;
	private LocalDateTime startProcess;
	private LocalDateTime endProcess;
	

//	public WorkloadEntity(EndpointRecord dados) {
//		this.tag = dados.tag();
//		this.endpoint = dados.endpoint();
//	}
//
//	public void atualizarInformacoes(EndpointRecord dados) {
//		if (dados.tag() != null) {
//			this.tag = dados.tag();
//		}
//
//		if (dados.endpoint() != null) {
//			this.endpoint = dados.endpoint();
//		}
//	}
}
