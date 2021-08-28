package com.priyanshuthakuria.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TechnicalSkills {
    List<ProgrammingLanguage> programmingLanguages;
    List<String> frameworks;
    List<String> databases;
    List<String> sourceControl;
    List<String> others;
}
