package gabriel.pauletti.oraclehcm_request.personnotes;

import java.time.LocalDateTime;

public record PersonNotesRecord(Long NoteId, String LastUpdateDate, Boolean HiddenFlag, String WorkerName) {

}
