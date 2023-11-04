package com.example.smartdumbbell.Manager.Security;

import com.example.smartdumbbell.Manager.Domain.Manager;
import com.example.smartdumbbell.Manager.Model.Role;
import com.example.smartdumbbell.Manager.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Manager member = memberRepository.findById(username)
                .orElseThrow(()-> new UsernameNotFoundException("등록되지 않은 사용자 입니다"));

        return new UserDetailsImpl(member, member.isApproved());
    }
}