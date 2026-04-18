package com.snist.crowdfunding_app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.*;
import com.snist.crowdfunding_app.model.Donation;
public interface DonationRepository extends JpaRepository<Donation, Integer> {


    @Query(name = "Donation.findByCampaignName")
    List<Donation> getDonationsByCampaignName(@Param("cname") String cname);

    @Query(name = "Donation.findByDid")
    List<Donation> getDonationByDid(@Param("did") int did);
}
