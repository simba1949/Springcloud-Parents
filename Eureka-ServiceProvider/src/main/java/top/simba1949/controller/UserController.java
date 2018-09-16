package top.simba1949.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.simba1949.common.UserCommon;
import top.simba1949.service.UserService;

import java.util.List;

/**
 * @author simba1949@outlook.com
 * @date 2018/9/16 15:25
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("all")
    public List<UserCommon> findAll(){
        return userService.findAll();
    }

    @RequestMapping("insert")
    public String insert(@RequestBody UserCommon userCommon){

        try {
            userService.insert(userCommon);
        } catch (Exception e) {
            return "添加失败";
        }
        return "添加成功";
    }

    @RequestMapping("delete")
    public void delete(@RequestParam Integer id){
        try {
            userService.delete(id);
        } catch (Exception e) {

        }
    }

    @RequestMapping("update")
    public String update(@RequestBody UserCommon userCommon){
        try {
            userService.update(userCommon);
        } catch (Exception e) {
            return "更新失败";
        }
        return "更新成功";
    }

    @RequestMapping("getTwoString")
    public String getTwoString(@RequestParam String name,@RequestParam String nickname){
        return name + "     " + nickname;
    }


}
