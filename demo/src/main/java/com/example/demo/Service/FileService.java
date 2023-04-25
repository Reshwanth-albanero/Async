package com.example.demo.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
public class FileService {
    @Autowired
    UserRepository userRepository;
    @Async
    public void doSomething(MultipartFile multipartFile){
        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(multipartFile.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(",");
                userRepository.save(new User(words[1], words[2]));
            }
        }
        catch (Exception e){}
    }
    public String status(String token) {
        return "Ok";
    }
}
