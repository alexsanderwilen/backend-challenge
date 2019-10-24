package com.invillia.acme.model;


import com.invillia.acme.model.enums.Profile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final String uri = "invilliastore.us-east-2.elasticbeanstalk.com:8080/customers/activate/";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(length = 80)
    private String name;

    @Column(length = 11, unique = true)
    @CPF
    private String cpf;

    @Column(length = 80)
    private String adress;

    @Column(length = 10)
    private String number;

    @Column(length = 80)
    private String neighborhood;

    @Column(length = 80)
    private String city;

    @Column(length = 100, unique = true)
    @Email
    private String email;

    @Column(length = 80)
    private String password;

    private boolean active;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id_store", referencedColumnName = "store_id")
    private Store store;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Profile")
    private Set<Integer> profiles = new HashSet<>();

    public Customer() {
        this.active = false;
        addProfile(Profile.CUSTOMER);
    }

    public Customer(String name, String cpf, String adress, String number, String neighborhood, String city, String email, String password) {
        this.name = name;
        this.cpf = cpf;
        this.adress = adress;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.email = email;
        this.password = password;
        this.active = false;
        addProfile(Profile.CUSTOMER);
    }

    public Set<Profile> getProfiles() {
        return profiles.stream().map(x -> Profile.toEnum(x)).collect(Collectors.toSet());
    }

    public void addProfile(Profile profile) {
        profiles.add(profile.getCod());
    }

    @Override
    public String toString() {
        return " Hi! ".concat(name).concat("\n").concat("\n")
                .concat("Thank you for signing up for our store").concat("\n")
                .concat("Below is your registered information.").concat("\n").concat("\n")
                .concat("Name: ").concat(name).concat("\n")
                .concat("CPF: ").concat(cpf).concat("\n")
                .concat("Adress: ").concat(adress).concat("\n")
                .concat("Number: ").concat(number).concat("\n")
                .concat("Neighborhood: ").concat(neighborhood).concat("\n")
                .concat("City: ").concat(city).concat("\n")
                .concat("Email: ").concat(email).concat("\n")
                .concat("Password: ").concat("*********").concat("\n")
                .concat("Profile: ").concat(profiles.toString()).concat("\n").concat("\n").concat("\n")
                .concat("Please click the link below to confirm your account and complete your registration.").concat("\n").concat("\n")
                .concat(uri).concat(id.toString());
    }

}