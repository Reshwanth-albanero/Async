package com.example.demo.Controller;
import com.example.demo.Model.JwtRequest;
import com.example.demo.Service.TokenService;
import com.example.demo.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@RestController
public class UserController {
    @Autowired
    FileService fileService;
    @Autowired
    TokenService tokenService;
    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file")MultipartFile multipartFile,@RequestBody JwtRequest jwtRequest){
        fileService.doSomething(multipartFile);
        String token = tokenService.generateToken(jwtRequest.getName(),jwtRequest.getPass());
        return new ResponseEntity<>(token, HttpStatus.CREATED);
    }
    @GetMapping("/status")
    public ResponseEntity<String> status(@RequestParam("token")String token){
        return new ResponseEntity<>(fileService.status(token),HttpStatus.ACCEPTED);
    }
}
//////////////////