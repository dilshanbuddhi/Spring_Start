package org.example.contraller;

import org.example.DTO.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/formdata")
@RestController
public class FormData {

    @PostMapping
    public String sayHello(@ModelAttribute CustomerDTO dto) {
        return dto.toString();
    }

}
