package xws.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xws.entity.User;

/**
 * test
 * Created by xws on 5/20/17.
 */

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private DiscoveryClient discoveryClient;


    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public User get() {
        User user = new User();
        user.setAge(12);
        user.setUsername("小明");
        return user;
    }

    @RequestMapping(value = "/insertUser", method = RequestMethod.GET)
    public User insertUser() {
        User user = new User();
        user.setAge(12);
        user.setUsername("小明");
        return user;
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.GET)
    public User registerUser() {
        User user = new User();
        user.setAge(12);
        user.setUsername("小明");
        kafkaTemplate.send("userRegister", JSON.toJSONString(user));
        return user;
    }


}
