package com.example.SpringDBDay1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Movie {
    @Id
    @Column(unique = true)
    @Size(min = 4, message = "Length id should be more than 3")
    private Integer ID;

    @NotEmpty(message = "Name is required")
    @Column(unique = true)
    @Size(min = 3, message = "Length name should be more than 3")
    private String name;

    @Column(nullable = false)
    @NotEmpty(message = "Genre is required")
    @Pattern(regexp = "(Drama | Action | Comedy)")
    private String genre;

    @NotNull(message = "Rating is required")
    @Range(min = 1, max = 5, message = "Rating must be between 1 - 5")
    @Positive
    private Integer rating;

    @NotNull (message = "Duration can not be null")
    @Min(value = 60)
    @Positive
    private String duration;

    @NotEmpty(message = "LaunchDate is required")
    @Pattern(regexp = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$", message = "launchDate must be  dd/mm/yyyy")
    private String launchDate;
}
