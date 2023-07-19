package com.scytalys.technikon.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "idGenerator", sequenceName = "roles_seq", initialValue = 1, allocationSize = 1)
@Table(name = "roles")
public class Role extends BaseModel {

    @Column(nullable = false, length = 45)
    private String name;

}
