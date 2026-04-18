package com.snist.crowdfunding_app.model;
import jakarta.persistence.*;
import java.time.*;
@Entity
@Table(name="campaign")
@NamedQueries({
	@NamedQuery(
		    name = "Campaign.addDonationAmount",
		    query = "UPDATE Campaign c SET c.collectedAmt = c.collectedAmt + :amt WHERE c.cid = :cid"
		)
})
public class Campaign {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "cid")
private int cid;
@Column(name = "cname")
private String cname;
@Column(name = "description")
private String description;
@Column(name = "targetAmt")
private double targetAmt;
@Column(name = "collectedAmt")
private double collectedAmt;
@Column(name = "endDate")
private LocalDate endDate;
public int getCid() { return cid; }
@ManyToOne
@JoinColumn(name = "mid")
private Member member;

public String getCname() { return cname; }
public void setCname(String cname) { this.cname = cname; }

public String getDescription() { return description; }
public void setDescription(String description ) { this.description = description; }

public double getTargetAmt() { return targetAmt; }
public void setTargetAmt(double targetAmt) { this.targetAmt = targetAmt; }

public double getCollectedAmt() { return collectedAmt; }
public void setCollectedAmt(double collectedAmt) { this.collectedAmt = collectedAmt; }

public LocalDate getEndDate() { return endDate; }
public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

public Member getMember() {
    return member;
}

public void setMember(Member member) {
    this.member = member;
}
}


