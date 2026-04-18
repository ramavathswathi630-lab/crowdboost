package com.snist.crowdfunding_app.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snist.crowdfunding_app.model.Campaign;
import com.snist.crowdfunding_app.repository.CampaignRepository;

@Service
public class CampaignService {


    @Autowired
    private CampaignRepository repo;

    // POST /campaigns (create)
    public Campaign create(Campaign c) {
        return repo.save(c);
    }

    // GET /campaigns (list all)
    public List<Campaign> getAll() {
        return repo.findAll();
    }

    // GET /campaigns/:id
    public Campaign getById(int id) {
        return repo.findById(id).orElse(null);
    }

    // PUT /campaigns/:id (edit)
    public Campaign update(int id, Campaign updated) {
        Campaign existing = repo.findById(id).orElse(null);

        if (existing != null) {
            existing.setCname(updated.getCname());
            existing.setDescription(updated.getDescription());
            existing.setTargetAmt(updated.getTargetAmt());
            // add other fields if you have
            return repo.save(existing);
        }

        return null;
    }

    // DELETE /campaigns/:id
   // public void delete(int id) {
        //repo.deleteById(id);
    //}
    public void deleteCampaign(int cid, String role) {

        if (!"admin".equalsIgnoreCase(role)) {
            throw new RuntimeException("Only admin can delete campaigns");
        }

        repo.deleteById(cid);
    }
    
}
