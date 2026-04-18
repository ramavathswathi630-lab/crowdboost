
package com.snist.crowdfunding_app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.snist.crowdfunding_app.model.Member;
import com.snist.crowdfunding_app.service.MemberService;

@RestController
@RequestMapping("/members")
@CrossOrigin
public class MemberController {

    @Autowired
    private MemberService service;

    // POST /members/register
    @PostMapping("/register")
    public Member register(@RequestBody Member m) {
        return service.register(m);
    }

    // POST /members/login
    @PostMapping("/login")
    public Member login(@RequestBody Member m) {
        return service.login(m.getEmail(), m.getPassword());
    }

    // GET /members/:id
    @GetMapping("/{id}")
    public Member getById(@PathVariable int id) {
        return service.getById(id);
    }

    // PUT /members/:id
    @PutMapping("/{id}")
    public Member update(@PathVariable int id, @RequestBody Member m) {
        return service.update(id, m);
    }

    // DELETE /members/:id
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}

