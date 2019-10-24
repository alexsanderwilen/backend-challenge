package com.invillia.acme.service;

import com.invillia.acme.dto.StoreDTO;

import java.util.List;

public interface StoreService {

    List<StoreDTO> getStores();

    StoreDTO getStore(Long id);

    StoreDTO getStoreByName(String name);

    void saveStore(StoreDTO store);

    void updateStore(StoreDTO store);

    void deleteStore(Long id);

}
