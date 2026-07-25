package com.prateek.pagepulse.exception;

import com.prateek.pagepulse.dto.ErrorData;
import com.prateek.pagepulse.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidUrlException.class)
    public ResponseEntity<ErrorResponse> handleInvalidUrlException(InvalidUrlException ex) {

        ErrorResponse response = new ErrorResponse(
                false,
                new ErrorData(
                        "INVALID_URL",
                        ex.getMessage()
                )
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler(TimeoutException.class)
    public ResponseEntity<ErrorResponse> handleTimeoutException(TimeoutException ex) {

        ErrorResponse response = new ErrorResponse(
                false,
                new ErrorData(
                        "TIMEOUT",
                        ex.getMessage()
                )
        );

        return ResponseEntity
                .status(HttpStatus.REQUEST_TIMEOUT)
                .body(response);
    }

    @ExceptionHandler(NonHtmlException.class)
    public ResponseEntity<ErrorResponse> handleNonHtmlException(NonHtmlException ex) {

        ErrorResponse response = new ErrorResponse(
                false,
                new ErrorData(
                        "NON_HTML_PAGE",
                        ex.getMessage()
                )
        );

        return ResponseEntity
                .status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
                .body(response);
    }

    @ExceptionHandler(FetchFailedException.class)
    public ResponseEntity<ErrorResponse> handleFetchFailedException(FetchFailedException ex) {

        ErrorResponse response = new ErrorResponse(
                false,
                new ErrorData(
                        "FETCH_FAILED",
                        ex.getMessage()
                )
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {

        ErrorResponse response = new ErrorResponse(
                false,
                new ErrorData(
                        "INTERNAL_SERVER_ERROR",
                        "Something went wrong while processing the request."
                )
        );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}