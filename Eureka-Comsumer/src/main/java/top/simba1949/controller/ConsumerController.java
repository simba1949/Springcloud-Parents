package top.simba1949.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author simba1949@outlook.com
 * @date 2018/9/16 10:42
 */
@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("ribbon-consumer")
    public String helloConsumer(){
        String string = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
        return string;
    }
}
