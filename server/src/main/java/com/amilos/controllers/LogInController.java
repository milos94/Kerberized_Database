package com.amilos.controllers;

import com.amilos.models.User;
import com.amilos.services.ResponseService;
import com.amilos.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Milos on 12.06.2017..
 */

@RestController
public class LogInController {

    private UserService userService;

    private ResponseService responseService;

    public LogInController(UserService userService, ResponseService responseService) {
        this.userService = userService;
        this.responseService = responseService;
    }

    @RequestMapping(method = RequestMethod.POST,value = {"/","/login"},produces = MediaType.APPLICATION_JSON_VALUE)
    byte[] logIn(@RequestBody Long ID){
        try {
            User user = userService.getFirsByUserId(ID);
            return responseService.generateLogInResponse(user);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
