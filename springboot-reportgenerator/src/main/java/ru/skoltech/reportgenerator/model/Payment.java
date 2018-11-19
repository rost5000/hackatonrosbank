package ru.skoltech.reportgenerator.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author rost.
 */
@Data
@Entity
public class Payment {
    @Id
    private String Id;

    private String name;

    private String operationType;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @NotNull
    @ManyToOne()
    private Customer customer;

    @NotNull
    @ManyToOne()
    private Bank bank;

    @NotNull
    @ManyToOne()
    private ContrAgent contrAgent;

    @NotNull
    private Float summ;

    private String status;
}
