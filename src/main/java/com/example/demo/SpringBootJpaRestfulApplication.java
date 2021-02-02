package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Address;
import com.example.demo.entity.Student;
import com.example.demo.repository.AddressRepository;
import com.example.demo.service.StudentService;

@SpringBootApplication
public class SpringBootJpaRestfulApplication  implements CommandLineRunner{

	@Autowired
	StudentService studentService;
	@Autowired
	AddressRepository addressRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaRestfulApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//sự khác nhau giữa getOne và findById thấy rõ là :
		//findById :  nó sẽ call sql và gọi để lấy ra 1 trường dữ liệu
		//nếu id truyền vào ko có sẽ trả về null
		
		//getOne : nó sẽ chỉ trả về 1 proxy chứ ko call Sql, và nếu id truyền vào là k có
		// sẽ báo lối entitityNotFound
		
		//Student student = studentService.getById(1);// thấy rõ call sql
		Student student = studentService.getOne(1); // thấy rõ là không call
		Address address = new Address("Dong Hoa", "Phu Yen", student);
		address = addressRepository.save(address);
		//System.out.println(address);
	}

}
