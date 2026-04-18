package com.snist.crowdfunding_app.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snist.crowdfunding_app.model.Member;
import com.snist.crowdfunding_app.repository.MemberRepository;

@Service
public class MemberService {

    @Autowired
    private MemberRepository repo;
    public Member save(Member m) {
        return repo.save(m);
    }
    
    public List<Member> getAll() {
        return repo.findAll();
    }
    //REgister
    public Member register(Member m) {
        return repo.save(m);
    }

    // LOGIN
    public Member login(String email, String password) {
        Member member = repo.findByEmail(email);
        if (member != null && member.getPassword().equals(password)) {
            return member;
        }
        return null;
    }

    // GET MEMBER BY ID
    public Member getById(int id) {
        return repo.findById(id).orElse(null);
    }

    // UPDATE MEMBER
    public Member update(int id, Member updated) {
        Member existing = repo.findById(id).orElse(null);
        if (existing != null) {
            existing.setUsername(updated.getUsername());
            existing.setEmail(updated.getEmail());
            existing.setPassword(updated.getPassword());
            return repo.save(existing);
        }
        return null;
    }

    // DELETE MEMBER
    public void delete(int id) {
        repo.deleteById(id);
    }
    
}
