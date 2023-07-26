package gabriel.pauletti.oraclehcm_request.amqp;

public record RequestQueue(String user, String password, String endpoint, int offset, String idProcess) {
	
}
