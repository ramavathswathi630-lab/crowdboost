
package com.snist.crowdfunding_app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.snist.crowdfunding_app.model.Donation;
import com.snist.crowdfunding_app.service.DonationService;

@RestController
@RequestMapping("/donations")
@CrossOrigin
public class DonationController {

    @Autowired
    private DonationService service;
    
 // POST /donations (add donation)
    @PostMapping("/adddonation")
    public Donation addDonation(@RequestBody Donation d) {
        return service.addDonation(d);
    }

    // GET /donations/campaign/{camp_name}
    @GetMapping("/campaign/{cname}")
    public List<Donation> getByCname(@PathVariable String cname) {
        return service.getByCname(cname);
    }

    // GET /donations/user/{donar_id}
    @GetMapping("/{did}")
    public List<Donation> getByDid(@PathVariable int did) {
        return service.getByDid(did);
    }
}

