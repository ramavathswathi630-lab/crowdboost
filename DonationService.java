package com.snist.crowdfunding_app.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snist.crowdfunding_app.model.Donation;
import com.snist.crowdfunding_app.repository.DonationRepository;
import com.snist.crowdfunding_app.repository.CampaignRepository;

@Service
public class DonationService {


    @Autowired
    private DonationRepository repo;
    @Autowired
    private CampaignRepository campaignRepo;

    // POST /donations 
    //public Donation addDonation(Donation d) { return repo.save(d); }
    public Donation addDonation(Donation d) {

        Donation saved = repo.save(d);

        if (d.getcampaign() == null) {
            throw new RuntimeException("Campaign is required in request body");
        }

        campaignRepo.addDonationAmount(
            d.getcampaign().getCid(),
            d.getDonatedAmt()
        );

        return saved;
    }
    // GET donation by id
    public List<Donation> getDonationByDid(int did) {
        return repo.getDonationByDid(did);
    }

	public List<Donation> getByCname(String cname) {
		// TODO Auto-generated method stub
		return repo.getDonationsByCampaignName(cname);
	}

	public List<Donation> getByDid(int did) {
		// TODO Auto-generated method stub
		return getDonationByDid(did);
	}
	

}
