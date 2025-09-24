package HouseWork.Elf.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/line/webhook")
public class WebhookController {

    @GetMapping
    public ResponseEntity<String> verify() {
        return ResponseEntity.ok("ok");
    }

    @PostMapping
    public ResponseEntity<String> handleWebhook(@RequestBody(required = false) String body) {
        System.out.println("收到 LINE Webhook 事件: " + body);
        return ResponseEntity.ok("ok");
    }
}
