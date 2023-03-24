package com.payPal.TaskPlanner_Backend.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

	@NotEmpty(message = "Please Enter User Name")
	@NotNull(message = "User Name Should not be null")
    private String userName;

    @Email(message = "Invalid Email...")
    @NotEmpty(message = "Email Required... Please Enter Email")
    private String email;

    private String role;

    @OneToMany(mappedBy = "assignee", cascade = CascadeType.ALL)
    private List<Task> tasks;

}
