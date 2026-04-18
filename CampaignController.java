
package com.snist.crowdfunding_app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.snist.crowdfunding_app.model.Campaign;
import com.snist.crowdfunding_app.service.CampaignService;

@RestController
@RequestMapping("/campaigns")
@CrossOrigin
public class CampaignController {

    @Autowired
    private CampaignService service;
    
    // POST /campaigns (create)
    @PostMapping
    public Campaign create(@RequestBody Campaign c) {
        return service.create(c);
    }

    // GET /campaigns (list all)
    @GetMapping
    public List<Campaign> getAll() {
        return service.getAll();
    }

    // GET /campaigns/:id
    @GetMapping("/{id}")
    public Campaign getById(@PathVariable int id) {
        return service.getById(id);
    }

    // PUT /campaigns/:id
    @PutMapping("/{id}")
    public Campaign update(@PathVariable int id, @RequestBody Campaign c) {
        return service.update(id, c);
    }

    // DELETE /campaigns/:id
  
    //public void delete(@PathVariable int id) {
        //service.delete(id);}
    @DeleteMapping("/campaign/{id}")
    public String deleteCampaign(
            @PathVariable int cid,
            @RequestParam String role) {

        service.deleteCampaign(cid, role);
        return "Deleted successfully";
    }
    

}

