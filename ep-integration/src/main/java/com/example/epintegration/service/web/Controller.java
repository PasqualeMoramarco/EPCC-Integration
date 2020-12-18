package com.example.epintegration.service.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class Controller {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @GetMapping("/ready")
    public ResponseEntity<String> getReady() {
        logger.info("Start getReady");
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

}
