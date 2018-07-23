package api;

import model.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiDemo {
    @RequestMapping(value = "/object", method = RequestMethod.POST)
    @ResponseBody
    public String object(@RequestBody User user) {
        return user.toString();
    }

    @RequestMapping(value = "/map", method = RequestMethod.POST)
    @ResponseBody
    public String map(@RequestBody Map<String, String> map) {
        String createBy = map.get("createBy");
        return createBy;
    }

    @RequestMapping(value = "/date", method = RequestMethod.POST)
    @ResponseBody
    public String map(@RequestBody Date date) {
        return date.toString();
    }

    @RequestMapping(value = "/test_object")
    @ResponseBody
    public String callWsObject() {
        try {
            RestTemplate template = new RestTemplate();
            String url = "http://localhost:9090/object";
            User user = new User();
            user.setId("2");
            user.setName("3");
            String result = template.postForObject(url, user, String.class);
            return "Result: " + result;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @RequestMapping(value = "/test_map")
    @ResponseBody
    public String callWsMap() {
        try {
            RestTemplate template = new RestTemplate();
            String url = "http://localhost:9090/map";
            Map<String, String> map = new HashMap<String, String>();
            map.put("createBy", "xiaohong");
            String result = template.postForObject(url, map, String.class);
            return "Result: " + result;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @RequestMapping(value = "/test_date")
    @ResponseBody
    public String callWsDate() {
        try {
            RestTemplate template = new RestTemplate();
            String url = "http://localhost:9090/date";
            return template.postForObject(url, new Date(), String.class);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return e.getMessage();
        }
    }

}
