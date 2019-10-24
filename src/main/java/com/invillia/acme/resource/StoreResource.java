package com.invillia.acme.resource;

import com.invillia.acme.dto.StoreDTO;
import com.invillia.acme.service.StroreServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("stores")
public class StoreResource {

    @Autowired
    private StroreServiceImpl storeService;


    @ApiOperation(value="Returns the list of stores present in the database.")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StoreDTO> getStores(){
        return storeService.getStores();
    }


    @ApiOperation(value="Returns a store based on the given id.")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StoreDTO getStore(@PathVariable("id") Long id){
        return storeService.getStore(id);
    }

    @ApiOperation(value="Returns a store based on the name you entered.")
    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public StoreDTO getStoreByName(@PathVariable("name") String name){
        return storeService.getStoreByName(name);
    }


    @ApiOperation(value="Receives data from a store, performs the registration of this information.")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStore(@RequestBody StoreDTO store ){
        storeService.saveStore(store);
    }


    @ApiOperation(value="Receives data from a store, updates this information.")
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateStore(@RequestBody StoreDTO store){
        storeService.updateStore(store);
    }


    @ApiOperation(value="Deletes a store based on the id entered.")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStore(@PathVariable("id") Long id){
        storeService.deleteStore(id);
    }
}
