package ru.nsu.ccfit.g20202.vartazaryan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.nsu.ccfit.g20202.vartazaryan.dto.RegistrationDTO;
import ru.nsu.ccfit.g20202.vartazaryan.entities.Role;
import ru.nsu.ccfit.g20202.vartazaryan.entities.User;
import ru.nsu.ccfit.g20202.vartazaryan.repositories.RoleRepository;
import ru.nsu.ccfit.g20202.vartazaryan.repositories.UserRepository;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userRepository.findByUsername(username);
        if (user == null)
        {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public void saveUser(RegistrationDTO dto)
    {
        User userFromDB = userRepository.findByUsername(dto.getUsername());

        if (userFromDB != null) {
            return;
        }

        User user = new User();

        user.setUsername(dto.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        Set<Role> roles = new HashSet<>();
        var role = roleRepository.findByName("ROLE_USER");
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
    }
}
