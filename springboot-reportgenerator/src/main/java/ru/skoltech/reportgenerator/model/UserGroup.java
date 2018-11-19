package ru.skoltech.reportgenerator.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author rost.
 */
@Data
@Entity
public class UserGroup {
    @Id
    private Long id;
    private String name;

}
