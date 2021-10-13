package com.inerxia.saletrackingapi.service;

import com.inerxia.saletrackingapi.exception.DataConstraintViolationException;
import com.inerxia.saletrackingapi.exception.DataNotFoundException;
import com.inerxia.saletrackingapi.model.User;
import com.inerxia.saletrackingapi.model.UserRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.inerxia.saletrackingapi.util.Constants.ROLE_PREFIX;

@Service
@Transactional
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUserName(String user) {
        System.out.println("user: "+user);
        if (Objects.isNull(user)) {
            throw new ObjectNotFoundException(user, "User not found");
        }
        return userRepository.findByEmail(user)
                .orElseThrow(() -> new DataNotFoundException("User not found"));
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.findByUserName(username);
        List<String> rolesList = new ArrayList<>();
        rolesList.add("ADMIN");//ROL QUEMADO, ASOCIAR A BD

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), getAuthorities( rolesList));
    }



    private Collection<? extends GrantedAuthority> getAuthorities(Collection<String> roles) {

        List<GrantedAuthority> authorities = new ArrayList<>();

        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX+role));
        }

        return authorities;
    }


    public User createUser(User user){
        if(Objects.nonNull(user.getId())){
            Optional<User> userOptional = userRepository.findById(user.getId());
            if(userOptional.isPresent()){
                throw new DataNotFoundException("exception.data_duplicated.user");
            }

        }

        try {
            return userRepository.save(user);
        }catch (DataIntegrityViolationException e) {
            Logger.getGlobal().log(Level.SEVERE, "No se puedo guardar el usuario", e);
            throw new DataConstraintViolationException("exception.data_constraint_violation.user");
        }
    }

}
