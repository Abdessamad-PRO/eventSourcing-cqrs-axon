package com.monprojet.eventsourcingcqrsaxon.commands.dtos;

import lombok.Data;


public record AddNewAccountRequestDTO
 (double initialBalance, String currency)
{ }
