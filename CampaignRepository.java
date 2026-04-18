package com.snist.crowdfunding_app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import com.snist.crowdfunding_app.model.Campaign;
public interface CampaignRepository extends JpaRepository<Campaign, Integer> {
	  @Transactional
	    @Modifying
	    @Query("UPDATE Campaign c SET c.collectedAmt = c.collectedAmt + :amt WHERE c.cid = :cid")
	    int addDonationAmount(@Param("cid") int cid, @Param("amt") double amt);
	
}
