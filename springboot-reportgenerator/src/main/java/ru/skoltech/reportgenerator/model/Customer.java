package ru.skoltech.reportgenerator.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author rost.
 * Person who recieve money
 */
@Data
@Entity
public class Customer {
    @Id
    private String id;
    private String name;
}
