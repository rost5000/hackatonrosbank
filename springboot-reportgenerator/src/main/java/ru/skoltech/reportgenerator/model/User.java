package ru.skoltech.reportgenerator.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author rost.
 */
@Data
@Entity
public class User {
    @Id
    private String login;
    private String password;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<UserGroup> listGroups;
}
