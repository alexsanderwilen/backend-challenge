package com.invillia.acme.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.invillia.acme.model.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreDTO {

    private Long id;

    private String name;

    private String address;

    private String number;

    private String neighborhood;

    private String city;

    //private List<Order> orders;
}
