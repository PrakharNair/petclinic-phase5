package com.example.petclinic.controller;

import com.example.petclinic.model.Owner;
import com.example.petclinic.service.OwnerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("owner")
public class OwnerController implements BasicController<Owner> {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {

        this.ownerService = ownerService;
    }

    @Override
    @PostMapping(value = "addOwner", produces = "application/json")
    public Owner add(@RequestBody Owner owner) {

        return this.ownerService.add(owner);
    }

    @Override
    @GetMapping(value = "getById/{id}", produces = "application/json")
    public Owner get(@PathVariable("id") Long id) {

        return this.ownerService.get(id);
    }

    @Override
    @PutMapping(value = "updateOwner", produces = "application/json")
    public Owner modify(@RequestBody Owner owner) {

        return this.ownerService.modify(owner);
    }

    @Override
    @RequestMapping(value = "deleteOwner", method = {RequestMethod.DELETE}, produces = "application/json")
    public boolean delete(@RequestBody Owner owner) {

        return this.ownerService.delete(owner);
    }

    @Override
    @GetMapping(value = "getAllOwners", produces = "application/json")
    public List<Owner> getAll() {

        List<Owner> all = this.ownerService.getAll();
        return all;
    }

    @GetMapping(value = "getOwnerByName", produces = "application/json")
    public List<Owner> getOwnerByName(@RequestBody Owner owner) {

        return this.ownerService.getOwnerByName(owner);
    }

}
