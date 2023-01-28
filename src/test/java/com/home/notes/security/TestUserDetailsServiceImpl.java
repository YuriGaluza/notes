package com.home.notes.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;

public class TestUserDetailsServiceImpl {

    @Autowired
    private UserDetailsService userDetailService;

    @Test
    public void testLoadUserByUsername() {
        userDetailService.loadUserByUsername("ironmike");
    }
}
