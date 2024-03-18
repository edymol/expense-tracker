//package xyz.deved.expeapinew.controler;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import xyz.deved.expeapinew.dto.UserRegistrationDto;
//import xyz.deved.expeapinew.service.UserService;
//
//@RestController
//@RequestMapping("/api/admin")
//public class AdminController {
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/register")
//    public ResponseEntity<String> registerAdmin(@RequestBody UserRegistrationDto registrationDto) {
//        userService.registerAdmin(registrationDto);
//        return ResponseEntity.status(HttpStatus.CREATED).body("Admin registered successfully");
//    }
//}
