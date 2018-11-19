package ru.skoltech.reportgenerator.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author rost.
 */
@Data
@Entity
public class Bank {
    @Id
    private String id;

    private String name;
}
