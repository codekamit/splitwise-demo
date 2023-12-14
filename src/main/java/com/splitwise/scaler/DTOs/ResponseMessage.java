package com.splitwise.scaler.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

@Getter
public class ResponseMessage {
    private LocalDateTime timeStamp;
    private HttpStatus httpStatus;
    private String path;
    private String message;
    private HttpStatusCode httpStatusCode;

    private ResponseMessage(LocalDateTime timeStamp, HttpStatus httpStatus, HttpStatusCode httpStatusCode, String message, String path) {
        this.timeStamp = timeStamp;
        this.httpStatus = httpStatus;
        this.httpStatusCode = httpStatusCode;
        this.message = message;
        this.path = path;
    }

    public static class Builder {
        private LocalDateTime timeStamp;
        private HttpStatus httpStatus;
        private String path;
        private String message;
        private HttpStatusCode httpStatusCode;

        public Builder TimeStamp(LocalDateTime timeStamp) {
            this.timeStamp = timeStamp;
            return this;
        }

        public Builder HttpStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public Builder HttpStatusCode(HttpStatusCode httpStatusCode) {
            this.httpStatusCode = httpStatusCode;
            return this;
        }

        public Builder Path(String path) {
            this.path = path;
            return this;
        }

        public Builder Message(String message) {
            this.message = message;
            return this;
        }

        public ResponseMessage build() {
            return new ResponseMessage(this.timeStamp, this.httpStatus, this.httpStatusCode, this.message, this.path);
        }
    }
}
