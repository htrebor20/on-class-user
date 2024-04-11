package usermicroservice.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String name;
    private  String lastName;
    private  Long document;
    private  String cellphone;
    private  String email;
    private  String password;
    private  String country;
    private  String city;
    private  String academicLevel;
    private  String gitUrl;
    private  String linkedinUrl;
    private  String instagramUrl;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private RoleEntity role;
}
