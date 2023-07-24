package com.scytalys.technikon.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "report")
@SequenceGenerator(name = "idGenerator", sequenceName = "report_seq", initialValue = 1, allocationSize = 1)
public class Report extends BaseModel {

    @Column(name = "date")
    private Date reportDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "report_type")
    private ReportType reportType;

    @Column(name = "description")
    private String reportDescription;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;
}