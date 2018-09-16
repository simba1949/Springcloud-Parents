package top.simba1949.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import top.simba1949.common.UserCommon;

import java.util.List;

/**
 * @author simba1949@outlook.com
 * @date 2018/9/16 14:27
 */
@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("find")
    public List<UserCommon> findAll(){
        ResponseEntity<List> forEntity = restTemplate.getForEntity("http://HELLO-SERVICE/user/all", List.class);
        List<UserCommon> body = forEntity.getBody();
        return body;
    }

    @RequestMapping("insert")
    public String insert(){
        UserCommon userCommon = new UserCommon();
        userCommon.setUsername("白居易");
        userCommon.setPassword("777");
        String str;
        try {
            str = restTemplate.postForObject("http://HELLO-SERVICE/user/insert", userCommon, String.class);
        } catch (RestClientException e) {
            return "添加失败";
        }
        return str;
    }

    @RequestMapping("delete")
    public String delete(){
        try {
            restTemplate.delete("http://HELLO-SERVICE/user/delete?id={1}",1);
        } catch (RestClientException e) {
            return "失败";
        }
        return "成功";
    }

    @RequestMapping("update")
    public String update(){
        UserCommon userCommon = new UserCommon();
        userCommon.setId(2);
        userCommon.setUsername("白居易");
        userCommon.setPassword("777");
        restTemplate.put("http://HELLO-SERVICE/user/update",userCommon);
        return "更新成功";
    }

    @GetMapping("string")
    public String getString(){
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://HELLO-SERVICE/user/getTwoString?name={1}&nickname={2}", String.class, "李白", "将进酒");
        return forEntity.getBody();
    }
}
