package com.wildcodeschool.doctor.controller;

import com.wildcodeschool.doctor.model.Doctor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class DoctorController {

    @GetMapping("/doctor/{number}")
    @ResponseBody
    public Doctor doctor(@PathVariable int number) {
        if (number == 13) {
            Doctor thirteen;
            thirteen = new Doctor(13, "Jodie Whittaker");
            return thirteen;
        }
        else if (1 <= number && number <= 12)
            throw new ResponseStatusException(HttpStatus.SEE_OTHER, "One of us is still here, you will find. Good luck ;)");
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "" +
                    "Please, wait for me. I'm coming, but you need to live a long life and be patient to see me :)");
    }


}
