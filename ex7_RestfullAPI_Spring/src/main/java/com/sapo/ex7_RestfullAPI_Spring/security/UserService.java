package com.sapo.ex7_RestfullAPI_Spring.security;

import org.springframework.stereotype.Service;

import com.sapo.ex7_RestfullAPI_Spring.entity.User;
import com.sapo.ex7_RestfullAPI_Spring.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Service
public class UserService implements UserDetailsService{
    @Autowired
    UserRepository userRepository;
    //spring security kiem tra thong tin truoc khi dang nhap
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findUserByUsername(username);
        if (user==null) throw new UsernameNotFoundException(username);
        // Mã hóa mật khẩu với BCrypt trước khi trả về CustomUserDetails
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        return new CustomUserDetails(user);
	}
	public UserDetails loadUserById(int id) {
        User user = userRepository.findById(id);
        if (user==null) throw new UsernameNotFoundException(user.getUsername());
        // Mã hóa mật khẩu với BCrypt trước khi trả về CustomUserDetails
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        return new CustomUserDetails(user);
    }
    
	
	
}
