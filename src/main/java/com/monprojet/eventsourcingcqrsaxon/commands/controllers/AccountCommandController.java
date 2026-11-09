package com.monprojet.eventsourcingcqrsaxon.commands.controllers;

import com.monprojet.eventsourcingcqrsaxon.commands.dtos.AddNewAccountRequestDTO;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="/commands/accounts")
public class AccountCommandController {
    @PostMapping(path = "/add")
    public String addNewAccount(@RequestBody AddNewAccountRequestDTO request){

    }

}