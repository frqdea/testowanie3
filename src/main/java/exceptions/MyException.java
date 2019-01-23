package exceptions;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class MyException extends RuntimeException {
    private String exceptionName;
    private LocalDateTime exceptionDateTime;

    @Override
    public String getMessage() {
        return "[ " + exceptionDateTime + " ]: " + exceptionName;
    }
}
