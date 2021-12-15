package pl.szymonleyk.spotifypartyapp.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.szymonleyk.spotifypartyapp.model.Role;
import pl.szymonleyk.spotifypartyapp.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Slf4j
public class MyUserDetails implements UserDetails {

    private User user;

    public MyUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role role: Role.values()) {
            authorities.add(new SimpleGrantedAuthority(role.toString()));
            log.info("Role "+role+" added.");
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        //return user.isEnabled();
        return true;
    }

}
