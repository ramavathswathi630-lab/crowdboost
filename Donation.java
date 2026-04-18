package com.snist.crowdfunding_app.model;
import jakarta.persistence.*;
import java.util.*;
@Entity
@Table(name="donation")
@NamedQueries({
    @NamedQuery(
        name = "Donation.findByCampaignName",
        query = "SELECT d FROM Donation d WHERE d.campaign.cname = :cname"
    ),
    @NamedQuery(
        name = "Donation.findByDid",
        query = "SELECT d FROM Donation d WHERE d.did = :did"
    )
})
public class Donation {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "did")
private Integer did;
@Column(name = "donarName")
private String donarName;
//@Column(name = "cname")
//private String cname;
@Column(name = "donatedAmt")
private double donatedAmt;
@Column(name = "donatedDate")
private Date donatedDate;
//foreign key
//@ManyToOne
//@JoinColumn(name = "m_id", referencedColumnName = "m_id")
//private Member member;
@ManyToOne
@JoinColumn(name = "cid")
private Campaign campaign;


public int getDid() { return did; }

public String getDonarName() { return donarName; }
public void setDonarName(String donarName) { this.donarName = donarName; }

public double getDonatedAmt() { return donatedAmt; }
public void setDonatedAmt(double donatedAmt) { this.donatedAmt = donatedAmt; }

public Date getDonatedDate() { return donatedDate; }
public void setDonatedDate(Date donatedDate ) { this.donatedDate = donatedDate; }

//public Member getMember() {
    //return member;
//}

//public void setMember(Member member) {
    //this.member = member;
//}

public Campaign getcampaign() {
    return campaign;
}

public void setcampaign(Campaign campaign) {
    this.campaign = campaign;
}

}



