package com.cg.addressbook.model;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import com.cg.addressbook.dto.UserDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_tb")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String gender;
    private String mobileNumber;

    public User(UserDTO userDTO) {
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.email = userDTO.getEmail();
        this.mobileNumber = userDTO.getMobileNumber();
        this.gender = userDTO.getGender();
        this.password = userDTO.getPassword();
    }
}
