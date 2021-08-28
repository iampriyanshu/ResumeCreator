package com.priyanshuthakuria.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Client {
    String name;
    List<Project> projects;
}
