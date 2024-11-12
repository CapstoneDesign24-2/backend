package errorcode.backend.apipayload.code;

public interface BaseErrorCode {
    public ErrorReasonDTO getReason();

    public ErrorReasonDTO getReasonHttpStatus();
}
