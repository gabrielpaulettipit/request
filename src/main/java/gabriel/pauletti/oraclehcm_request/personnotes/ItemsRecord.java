package gabriel.pauletti.oraclehcm_request.personnotes;

import java.util.List;

public record ItemsRecord(List<PersonNotesRecord> items, int totalResults, int count, int limit, boolean hasMore) {

}
