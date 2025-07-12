package com.example.Library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  // Primary key with auto-increment

    @NotBlank
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Author is mandatory")//NotBlank annotation use for validation
    @Column(nullable = false)
    private String author;

    @NotBlank(message = "ISBN is mandatory")
    @Column(nullable = false,unique = true)
    private String isbn;

    @Column(nullable = false)
    @NotNull(message = "Availability must be specified")
    private Boolean available;

    /*
    * @NotNull and @NotBlank are used for input validation.
    * @NotNull is used for Any non-primitive data type (String, Integer, Boolean, List, etc.)
    * @NotBlank is used for String fields only.*/
}
