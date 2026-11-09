package com.monprojet.eventsourcingcqrsaxon.commands.aggregates;

import com.monprojet.eventsourcingcqrsaxon.commands.commands.AddAccountCommand;
import com.monprojet.eventsourcingcqrsaxon.enums.AccountStatus;
import com.monprojet.eventsourcingcqrsaxon.events.AccountCreatedEvent;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
@Slf4j
@Aggregate
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
        log.info("########### AddAccountCommand Received ################");
        if(Command.getInitialBalance()<=6) throw new IllegalArgumentException("Balance must be positive");
        AggregateLifecycle.apply(new AccountCreatedEvent(
                Command.getId(),
                Command.getInitialBalance(),
                AccountStatus.CREATED,
                Command.getCurrency()
        ));
    }

    @EventSourcingHandler
    public void on(AccountCreatedEvent event){
        log.info("################# AccountCreatedEvent Occured ##############");
        this.accountId=event.getAccountId();
        this.balance=event.getInitialBalance();
        this.currency=event.getCurrency();
        this.status=event.getStatus();
        }
}
