package pl.lpasik.multinode.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logging")
public class LoggingController {

    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        logger.info("Test log called");
        return ResponseEntity.ok("ResponseEntityCalled");
    }

}
