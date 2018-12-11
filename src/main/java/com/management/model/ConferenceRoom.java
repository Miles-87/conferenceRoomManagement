package com.management.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ConferenceRoom {
    @Id
    @Column(unique = true)
    @Length(max = 50)
    private String roomName;
    @Length(max = 256)
    private String description;
    private Boolean projector;
    @Length(max = 100)
    private String phoneNumber;
    private Integer numberOfSeats;
    @OneToMany(mappedBy = "conferenceRoom", fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>();
}
