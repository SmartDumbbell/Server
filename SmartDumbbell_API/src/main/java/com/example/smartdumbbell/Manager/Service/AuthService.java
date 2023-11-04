package com.example.smartdumbbell.Manager.Service;



import com.example.smartdumbbell.Manager.DTO.JwtRequestDTO;
import com.example.smartdumbbell.Manager.DTO.JwtResponseDTO;
import com.example.smartdumbbell.Manager.DTO.MemberSignupRequestDTO;
import com.example.smartdumbbell.Manager.Domain.Manager;
import com.example.smartdumbbell.Manager.Model.Role;
import com.example.smartdumbbell.Manager.Repository.MemberRepository;
import com.example.smartdumbbell.Manager.Security.JwtTokenProvider;
import com.example.smartdumbbell.Manager.Security.UserDetailsImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public JwtResponseDTO login(JwtRequestDTO request) throws Exception{

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        return createJwtToken(authentication);
    }

    private JwtResponseDTO createJwtToken(Authentication authentication) {
        UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();
        String token = jwtTokenProvider.generateToken(principal);


        return new JwtResponseDTO(token);
    }

    public boolean signup(MemberSignupRequestDTO request) {
        //중복 유저 점검
        boolean existMember = memberRepository.existsByEmail(request.getEmail());

        if (existMember)
            return false;

        Manager member = new Manager(request);

        if(request.getRole().equals("USER")){
            member.setRole(Role.USER);
        }else{
            return false;
        }

        member.encryptPassword(passwordEncoder);

        memberRepository.save(member);

        return true;
    }

    public Manager userDetailInfo(String email){
        return memberRepository.findByEmail(email);
    }

    public Manager updateMember(Manager updatedMember){

        Manager updatedInfo = Manager.builder()
                .email(updatedMember.getEmail())
                .password(updatedMember.getPassword())
                .name(updatedMember.getName())
                .birth(updatedMember.getBirth())
                .gender(updatedMember.getGender())
                .phone(updatedMember.getPhone())
                .build();

        return memberRepository.save(updatedMember);
    }

}