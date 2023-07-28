package com.scytalys.technikon.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.scytalys.technikon.domain.BaseModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "Reports")
@SequenceGenerator(name = "idGenerator", sequenceName = "report_sequence", initialValue = 1, allocationSize = 1)
public class Report extends BaseModel {

    @JsonFormat(pattern = "DD-MM-YYYY")
    @Column(name = "date")
    private Date reportDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "type of report")
    private ReportType reportType;

    @Column(name = "description")
    private String reportDescription;

    @JsonIgnore
    @ManyToOne()
    private User user;
}