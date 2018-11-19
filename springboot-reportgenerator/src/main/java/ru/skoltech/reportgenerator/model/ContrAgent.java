package ru.skoltech.reportgenerator.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author rost.
 * Person who sends money
 */
@Data
@Entity
public class ContrAgent {
    @Id
    private String id;

    private String name;
}
