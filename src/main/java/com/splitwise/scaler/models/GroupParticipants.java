package com.splitwise.scaler.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class GroupParticipants extends BaseModel {
    @ManyToMany
    private List<User> participants;
    @OneToOne
    private Group group;
}
