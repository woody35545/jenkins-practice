package ac.cnu.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final DemoService demoService;

    @GetMapping("/totalAmount")
    public int hello(@RequestParam("deposit") int deposit) {
        return demoService.getExpectedInterest(deposit);
    }

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }
}
