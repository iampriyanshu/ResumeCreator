package com.priyanshuthakuria.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WorkExperience {
    String organization;
    String startDate;
    String endDate;
    String role;
    List<Client> clients;
}
