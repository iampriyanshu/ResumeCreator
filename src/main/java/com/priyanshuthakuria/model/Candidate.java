package com.priyanshuthakuria.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Candidate {
    String name;
    String email;
    List<String> phoneNumber;
    String overview;
    TechnicalSkills technicalSkills;
    String totalExperience;
    List<WorkExperience> workExperiences;
    List<String> proofOfConcepts;
    List<Education> educationDetails;
    List<Language> languages;
    List<String> hobbies;
}
