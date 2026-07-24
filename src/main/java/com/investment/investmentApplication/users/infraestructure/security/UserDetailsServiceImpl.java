package com.investment.investmentApplication.users.infraestructure.security;

import com.investment.investmentApplication.users.domain.exception.UsersException;
import com.investment.investmentApplication.users.infraestructure.persistence.UserPostgresRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * The Class UserDetailsServiceImpl
 *
 * @author Pedro Junho Silveira
 * @since 24/07/2026
 */

@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserPostgresRepository repository;

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        return repository.findByEmail(email)
                .map(user -> new User(
                        user.getEmail(), user.getPassword(),
                        Collections.emptyList()
                ))
                .orElseThrow(UsersException.UserNotFoundException::new);
    }
}
