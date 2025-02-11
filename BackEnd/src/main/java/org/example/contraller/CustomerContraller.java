package org.example.contraller;

import org.example.DTO.CustomerDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerContraller {

    private ArrayList<CustomerDTO> customerList = new ArrayList<>();


    @GetMapping(path = "/getAll")
    public ArrayList<CustomerDTO> getCustomer(){
        return customerList;
    }

    @PostMapping(path = "/save" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )
    public CustomerDTO postCustomer(@RequestBody CustomerDTO customerDTO){
        System.out.println("save called");
        customerList.add(customerDTO);

        return customerDTO;
    }

    @PutMapping(path = "/update")
    public CustomerDTO putCustomer(@RequestBody CustomerDTO customerDTO) {
        System.out.println(customerDTO.getId() + " " + customerDTO.getName() + " " + customerDTO.getEmail());
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId().equals(customerDTO.getId())) {
                customerList.set(i,customerDTO);
                return customerDTO;
            }
        }
        return customerDTO;
    }

    @DeleteMapping(path = "/delete/{id}")
    public boolean deleteCustomer(@PathVariable("id") String id) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId().equals(id)) {
                customerList.remove(i);
                return true;
            }
        }
        return false;
    }

}
