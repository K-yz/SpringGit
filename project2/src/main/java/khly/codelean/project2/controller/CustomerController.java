package khly.codelean.project2.controller;

import khly.codelean.project2.dtos.CategoryDTO;
import khly.codelean.project2.dtos.CustomerDTO;
import khly.codelean.project2.dtos.ResponseObject;
import khly.codelean.project2.models.CreateCategoryModel;
import khly.codelean.project2.models.CreateCustomerModel;
import khly.codelean.project2.models.UpdateCategoryModel;
import khly.codelean.project2.models.UpdateCustomerModel;
import khly.codelean.project2.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<ResponseObject> createCustomer(@RequestBody CreateCustomerModel createCustomerModel) {
        CustomerDTO customerDTO = customerService.createCustomer(createCustomerModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseObject(true, HttpStatus.CREATED.value(), "Entry created successfully", customerDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> updateCustomer(@PathVariable Long id, @RequestBody UpdateCustomerModel updateCustomerModel) {
        CustomerDTO customerDTO = customerService.updateCustomer(id, updateCustomerModel);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject(true, HttpStatus.OK.value(), "Entry updated successfully", customerDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> deleteCategory(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject(true, HttpStatus.OK.value(), "Entry deleted successfully", null));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getCategoryById(@PathVariable Long id) {
        CustomerDTO customerDTO = customerService.getCustomerById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject(true, HttpStatus.OK.value(), "Entry retrieved successfully", customerDTO));
    }

    @GetMapping
    public ResponseEntity<ResponseObject> getAllCategory() {
        List<CustomerDTO> customers = customerService.getAllCustomers();
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject(true, HttpStatus.OK.value(), "Entries retrieved successfully", customers));
    }
}
