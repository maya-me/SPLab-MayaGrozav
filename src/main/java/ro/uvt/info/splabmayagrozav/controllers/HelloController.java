package ro.uvt.info.splabmayagrozav.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.uvt.info.splabmayagrozav.difexamples.ClientComponent;

@RestController
public class HelloController {
    private final ClientComponent c1;
    private final ClientComponent c2;

    public HelloController(ClientComponent c1, ClientComponent c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    @GetMapping("/")
    public String hello() {
        return "c1 = " + c1 + "<br>c2 = " + c2 + "<br>same = " + (c1 == c2);
    }
}