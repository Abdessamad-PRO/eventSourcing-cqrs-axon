package com.monprojet.eventsourcingcqrsaxon.commands.aggregates;

import com.monprojet.eventsourcingcqrsaxon.commands.commands.AddAccountCommand;
import com.monprojet.eventsourcingcqrsaxon.commands.enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate @NoArgsConstructor
public class AccountAggregate {
    @AggregateIdentifier
    private String accountId;
    private double balance;
    private String currency;
    private AccountStatus status;

    public AccountAggregate() {
    }
    @CommandHandler
    public AccountAggregate(AddAccountCommand Command) {
        log.info("CreateAccountCommand Received");
        AggregateLifecycle.apply(
                new AccountCreatedEvent(
                        Command.getId(),
                        Command.getBalance(),
                        Command.getCurrency(),
                        AccountStatus.CREATED
                )
        );
    }
}
