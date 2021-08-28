package com.priyanshuthakuria.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Project {
    String projectName;
    String startDate;
    String endDate;
    String role;
    String location;
    List<String> technologies;
    String description;
    int teamSize;
    String duration;
}
