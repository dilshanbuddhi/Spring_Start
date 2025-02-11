package org.example.contraller;

import org.example.DTO.CustomerDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("JSON")

public class JSONController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO postUser(@RequestBody CustomerDTO dto) {
        return dto;
    }

    @GetMapping(path = "/getUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<CustomerDTO> getUser() {
        ArrayList<CustomerDTO> list = new ArrayList<>();
        list.add(new CustomerDTO(1L, "dila", "dila@mail"));
        list.add(new CustomerDTO(2L, "dila", "dila@mail"));
        list.add(new CustomerDTO(3L, "dila", "dila@mail"));
        list.add(new CustomerDTO(4L, "dila", "dila@mail"));
        list.add(new CustomerDTO(5L, "dila", "dila@mail"));
        list.add(new CustomerDTO(6L, "dila", "dila@mail"));
        list.add(new CustomerDTO(7L, "dila", "dila@mail"));
        list.add(new CustomerDTO(8L, "dila", "dila@mail"));
        list.add(new CustomerDTO(9L, "dila", "dila@mail"));
        list.add(new CustomerDTO(10L, "dila", "dila@mail"));
        return list;

    }
}
