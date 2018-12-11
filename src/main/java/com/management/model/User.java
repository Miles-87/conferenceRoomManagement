package com.management.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {
    @Length(max = 100)
    @Column(unique = true)
    @Id
    private String login;
    @Length(max = 50)
    private String username;
    @Length(max = 100)
    private String surname;
    @Length(max = 100)
    private String password;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "roomName")
    private ConferenceRoom conferenceRoom;

}
