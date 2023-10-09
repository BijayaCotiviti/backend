package com.task.backend.controller;

import com.task.backend.dto.LoginDto;
import com.task.backend.dto.SignUpDto;
import com.task.backend.models.User;
import com.task.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;


    @RestController
    @RequestMapping("users")
    public class UserController {
//        @Autowired
//        private AuthenticationManager authenticationManager;
        @Autowired
        private UserRepository userRepository;

//        @Autowired
//        private RoleRepository roleRepository;
//
//        @Autowired
//        private PasswordEncoder passwordEncoder;

//        @Autowired
//        private JwtTokenUtil jwtTokenUtil;

//        @Autowired
//        private JwtUserDetailsService userDetailsService;

        @RequestMapping(value = "/login", method = RequestMethod.POST)
        public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto) {
//
//            Authentication authentication = authenticationManager
//                    .authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            final UserDetails userDetails = userDetailsService
//                    .loadUserByUsername(loginDto.getUsername());
//
//            final String token = jwtTokenUtil.generateToken(userDetails);
//
//            return ResponseEntity.ok(new LoginResponseDto(token).toString());

            return new ResponseEntity<String>("User registration successful", HttpStatus.OK);
        }


        @PostMapping("/signup")
        public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){
            // checking for username exists in a database
            if(userRepository.existsByName(signUpDto.getUsername())){
                return new ResponseEntity<>("Username is already exist!", HttpStatus.BAD_REQUEST);
            }
            // checking for email exists in a database
            if(userRepository.existsByEmail(signUpDto.getEmail())){
                return new ResponseEntity<>("Email is already exist!", HttpStatus.BAD_REQUEST);
            }
            // creating user object
            User user = new User();
            user.setName(signUpDto.getName());
            user.setEmail(signUpDto.getEmail());
            user.setPassword(
            signUpDto.getPassword()
//                    passwordEncoder.encode(signUpDto.getPassword())
            );

//            Role roles = roleRepository.findByName("ROLE_ADMIN");
//            user.setRoles((List<Role>) Collections.singleton(roles));
            userRepository.save(user);
            return new ResponseEntity<>("User is registered successfully!", HttpStatus.OK);
        }
    }

