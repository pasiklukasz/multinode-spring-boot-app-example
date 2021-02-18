package pl.lpasik.multinode.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/logging")
public class LoggingController {

    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        logger.info("Test log called");
        return ResponseEntity.ok("ResponseEntityCalled");
    }

    @GetMapping("/session-test")
    public ResponseEntity<String> sessionTest(HttpSession httpSession) {
        logger.info(httpSession.toString());
        Integer counter = (Integer) httpSession.getAttribute("counter");
        counter = counter == null ? 0 : counter;
        httpSession.setAttribute("counter", counter + 1);
        logger.info(httpSession.getAttribute("counter").toString());
        return ResponseEntity.ok("ResponseEntityCalled");
    }

}
