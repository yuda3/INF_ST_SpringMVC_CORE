package springmvc_core.basic.requestMapping;

import org.springframework.web.bind.annotation.*;

@RestController
public class MappingClassController {

    @GetMapping("/mapping/users")
    public String user() {
        return "get users";
    }

    @PostMapping("/mapping/users")
    public String addUser() {
        return "post user";
    }

    @PatchMapping("/mapping/users/{userId}")
    public String updateUser(@PathVariable("userId") String userId) {
        return "update User =" + userId;
    }


    @DeleteMapping("/mapping/users/{userId}")
    public String deleteUser(@PathVariable("userId") String userId) {
        return "delete User =" + userId;
    }
}
