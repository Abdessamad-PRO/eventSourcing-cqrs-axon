package com.monprojet.eventsourcingcqrsaxon.commands.dtos;

import lombok.Data;

@Data
public record AddNewAccountRequestDTO
 (double initialBalance, String currency)
{ }
