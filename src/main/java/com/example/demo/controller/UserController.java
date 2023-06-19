package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.eneity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.JwtUtil;
import com.example.demo.utils.UserUtils;
import com.example.demo.utilsEneity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin()
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody User user){
        user.setUserLevel(2);
        user.setUserScore(100);
        userService.add(user);
        return Result.success("success");
    }
    /**
     *登录
     * @param
     * @return
     */
    @PostMapping("/auth/login")
    public Result login(@RequestBody User user) {
        System.out.println("进入请求");

        User user1 = userService.findUser(user);
        if(user1==null){
            return Result.failure(501,"无当前用户");
        }
        if(!user1.getUserPasswd().equals(user.getUserPasswd())){
            return Result.failure(500,"账号或密码错误");
        }
        //假设数据库中查询到了该用户，这里测试先所及生成一个UUID，作为用户的id
        System.out.println(user1.getId());
        //准备存放在IWT中的自定义数据
        Map<String, Object> info = new HashMap<>();
        //生成JWT字符串
        String token = JwtUtil.sign(String.valueOf(user1.getId()), info);
        Map<String,String> tokenInfo = new HashMap<>();
        tokenInfo.put("token",token);
        tokenInfo.put("effectiveTime","1");
        return Result.success(tokenInfo);
    }
    /**
     * 用户修改
     * @param user
     * @return
     */
    @PostMapping("/user/update")
    public Result update(@RequestBody User user){
        userService.updateById(user);
        return Result.success("success");
    }
    /**
     * 注销账号
     * @param
     * @return
     */
    @GetMapping("/user/delete")
    public Result delete(){
        String userId = UserUtils.getUserId();
        userService.deletedById(Long.valueOf(userId));
        return Result.success("success");
    }

    /**
     * 用户信息展示
     * @return
     */
    @PostMapping("/user/detail")
    public Result getDetail(){
        System.out.println("进入detail");
        String userId = UserUtils.getUserId();
        User user = userService.findById(userId);
        return Result.success(user);
    }

    /**
     * 重新获取token
     * @return
     */
    @PostMapping("/user/getToken")
    public Result getToken(){
        //准备存放在IWT中的自定义数据
        Map<String, Object> info = new HashMap<>();
        String userId = UserUtils.getUserId();
        String token = JwtUtil.sign(userId,info);
        Map<String,String> tokenInfo = new HashMap<>();
        tokenInfo.put("token",token);
        tokenInfo.put("effectiveTime","1");
        return Result.success(tokenInfo);
    }
    @GetMapping("/getAllUser")
    public Result getAll(){
        List<User> userList = userService.getAll();
        return Result.success(userList);
    }
    @PostMapping("update")
    public Result updateBy(@RequestBody User user){
        userService.updateById(user);
        return Result.success("修改成功");
    }


}
