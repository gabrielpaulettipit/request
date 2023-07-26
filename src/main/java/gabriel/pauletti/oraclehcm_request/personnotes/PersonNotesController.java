package gabriel.pauletti.oraclehcm_request.personnotes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/personNotes")
public class PersonNotesController {

	@Autowired
	private PersonNotesRepository repository;
	
	@GetMapping
	@Transactional
    public String listar() {
//		System.out.println("entrou no listar");
/*		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println("Hora Início -> "+dtf.format(LocalDateTime.now()));
        
		String url = "https://fa-eqjz-dev20-saasfademo1.ds-fa.oraclepdemos.com/hcmRestApi/resources/11.13.18.05/grades";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders header = new HttpHeaders();
		header.setBasicAuth("Gabriel.Pauletti", "E%5ABq2?");
		HttpEntity<String> entity = new HttpEntity<>("body", header);

		ResponseEntity<ItemsRecord> resp = restTemplate.exchange(url, HttpMethod.GET, entity, ItemsRecord.class);
		for (GradeRecord grade : resp.getBody().items()) {
			repository.save(new GradesEntity(grade));
		}
        System.out.println("Hora Fim -> "+dtf.format(LocalDateTime.now()));
		// return resp.getBody();
		return "deu certo";*/
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println("Hora Início -> "+dtf.format(LocalDateTime.now()));
        
		String url = "https://fa-eqjz-dev20-saasfademo1.ds-fa.oraclepdemos.com/hcmRestApi/resources/11.13.18.05/grades";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders header = new HttpHeaders();
		header.setBasicAuth("Gabriel.Pauletti", "E%5ABq2?");
		HttpEntity<String> entity = new HttpEntity<>("body", header);

		ResponseEntity<ItemsRecord> resp = restTemplate.exchange(url, HttpMethod.GET, entity, ItemsRecord.class);
		
		
		
        System.out.println("Hora Fim -> "+dtf.format(LocalDateTime.now()));
		 return resp.getBody().toString();
//		return "deu certo";
    }
}
