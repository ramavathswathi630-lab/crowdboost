package com.snist.crowdfunding_app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.snist.crowdfunding_app.model.Member;
public interface MemberRepository extends JpaRepository<Member, Integer> {
	Member findByEmail(String email);
}
