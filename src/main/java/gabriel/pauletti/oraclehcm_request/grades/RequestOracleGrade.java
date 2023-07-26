package gabriel.pauletti.oraclehcm_request.grades;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Optional;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import gabriel.pauletti.oraclehcm_request.amqp.RequestQueue;
import gabriel.pauletti.oraclehcm_request.workload.WorkloadEntity;
import gabriel.pauletti.oraclehcm_request.workload.WorkloadRepository;

@Component
public class RequestOracleGrade {
	
	@Value("${KEY_CONTAINER_NAME}")
	private String containerName;
	
	@Autowired
	private GradesRepository gradesRepository;
	
	@Autowired
	private WorkloadRepository workloadRepository;
	
	@Transactional
	@RabbitListener(queues = "Grades")
	public void recebeMensagem(RequestQueue requestQueue) {
//		System.out.println("print 1");
		
		WorkloadEntity workloadEntity = new WorkloadEntity();
		workloadEntity.setOffset(requestQueue.offset());
		workloadEntity.setContainer(containerName);
		workloadEntity.setIdProcess(requestQueue.idProcess());
		
//		System.out.println("print 2");
		
//		String mensgem = """
//				User: %s 
//				Password: %s
//				Endpoint: %s
//				""".formatted(requestQueue.user(), requestQueue.password(), requestQueue.endpoint());
//		System.out.println("Recebi a mensagem: " + mensgem.toString());

		workloadEntity.setStartRequest(LocalDateTime.now());
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders header = new HttpHeaders();
		header.setBasicAuth(requestQueue.user(), requestQueue.password());
		HttpEntity<String> entity = new HttpEntity<>("body", header);
		ResponseEntity<ItemsRecord> resp = restTemplate.exchange(requestQueue.endpoint(), HttpMethod.GET, entity, ItemsRecord.class);
		workloadEntity.setEndRequest(LocalDateTime.now());
//		System.out.println("print 3");
		
		workloadEntity.setStartProcess(LocalDateTime.now());
		workloadEntity.setQuantityRows(resp.getBody().count());
		for (GradeRecord gradeRecord : resp.getBody().items()) {
			gradesRepository.save(new GradesEntity(gradeRecord));
		}
		workloadEntity.setEndProcess(LocalDateTime.now());
		workloadRepository.save(workloadEntity);
//		System.out.println("print 4");
	}
}
