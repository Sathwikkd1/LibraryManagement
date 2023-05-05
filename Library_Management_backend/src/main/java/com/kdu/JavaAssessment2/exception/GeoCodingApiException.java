package com.kdu.JavaAssessment2.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GeoCodingApiException extends Exception{
    public GeoCodingApiException(String message){
        super(message);
        log.error("GeoCodingApiException occurred");
    }
}
