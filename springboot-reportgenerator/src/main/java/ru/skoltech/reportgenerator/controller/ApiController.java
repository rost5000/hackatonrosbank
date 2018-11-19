package ru.skoltech.reportgenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.skoltech.reportgenerator.model.Payment;
import ru.skoltech.reportgenerator.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author rost.
 */
@Controller
@RequestMapping("/api")
public class ApiController {
    private CrudRepository<User, String> userRepo;
    private CrudRepository<Payment, String>paymentRepo;

    @Autowired
    public ApiController(CrudRepository<User, String>userRepo,
                         CrudRepository<Payment, String>paymentRepo){
        this.userRepo = userRepo;
        this.paymentRepo = paymentRepo;
    }

    @RequestMapping(value = "/log", method = RequestMethod.GET)
    public  ResponseEntity log(@RequestParam("username") String username,
                                 @RequestParam("password") String password){
        User user = userRepo.findById(username).get();
        if( user == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        if( user.getPassword().equals(password) ) {
            //TODO save token
            String token = UUID.randomUUID().toString();
            return ResponseEntity.status(HttpStatus.OK).body(token);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @ResponseBody
    @RequestMapping(value = "/list_payment", method = RequestMethod.GET)
    public List<Payment> getLists(@RequestParam("token")String token){
        ArrayList<Payment> result = new ArrayList<Payment>();
        paymentRepo.findAll().forEach(p->{
            result.add(p);
        });
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/list_needed_payment", method = RequestMethod.GET)
    public List<Payment> getListsNeeded(@RequestParam("token")String token){
        ArrayList<Payment> result = new ArrayList<Payment>();
        paymentRepo.findAll().forEach(p->{
            if(p.getStatus().equals("wait"))
                result.add(p);
        });
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/list_users", method = RequestMethod.GET)
    public List<User> getUser(@RequestParam("token")String token){
        ArrayList<User> result = new ArrayList<User>();
        userRepo.findAll().forEach(p->{
            result.add(p);
        });
        return result;
    }

}
