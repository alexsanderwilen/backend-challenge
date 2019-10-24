package com.invillia.acme.service;

import com.invillia.acme.dto.StoreDTO;
import com.invillia.acme.exception.NoContentException;
import com.invillia.acme.model.Store;
import com.invillia.acme.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StroreServiceImpl implements StoreService{

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public List<StoreDTO> getStores() {
        List<Store> stores = storeRepository.findAll();

        if (!stores.isEmpty()){
            List<StoreDTO> storeDTOS = new ArrayList<>();
            stores.forEach( store -> storeDTOS.add(StoreDTO.builder()
                    .id(store.getId())
                    .name(store.getName())
                    .address(store.getAddress())
                    .number(store.getNumber())
                    .neighborhood(store.getNeighborhood())
                    .city(store.getCity()).build()));
            return storeDTOS;
        }else{
            throw new NoContentException("There are no stores");
        }
    }

    @Override
    public StoreDTO getStore(Long id) {
        Store store = storeRepository.getOne(id);

        if (store != null){
            return StoreDTO.builder()
                    .id(store.getId())
                    .name(store.getName())
                    .address(store.getAddress())
                    .number(store.getNumber())
                    .neighborhood(store.getNeighborhood())
                    .city(store.getCity()).build();
        }else{
            throw new NoContentException("Store not found. Id: " + id + Store.class.getName());
        }
    }

    @Override
    public StoreDTO getStoreByName(String name) {
        Store store = storeRepository.getStoreByName(name);

        if (store != null){
            return StoreDTO.builder()
                    .id(store.getId())
                    .name(store.getName())
                    .address(store.getAddress())
                    .number(store.getNumber())
                    .neighborhood(store.getNeighborhood())
                    .city(store.getCity()).build();
        }else{
            throw new NoContentException("Store not found. Name: " + name + Store.class.getName());
        }
    }

    @Override
    public void saveStore(StoreDTO store) {
        storeRepository.save(Store.builder()
            .name(store.getName())
            .address(store.getAddress())
            .number(store.getNumber())
            .neighborhood(store.getNeighborhood())
            .city(store.getCity()).build());
    }

    @Override
    public void updateStore(StoreDTO store) {
        Store storeUpdate = storeRepository.getOne(store.getId());
        storeUpdate.setName(store.getName());
        storeUpdate.setAddress(store.getAddress());
        storeUpdate.setNumber(store.getNumber());
        storeUpdate.setNeighborhood(store.getNeighborhood());
        storeUpdate.setCity(store.getCity());
        storeRepository.save(storeUpdate);
    }

    @Override
    public void deleteStore(Long id) {
        storeRepository.deleteById(id);
    }
}
