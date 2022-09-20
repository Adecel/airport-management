package za.ac.cput.service.passenger.Impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.passenger.Passengers;
import za.ac.cput.factory.passenger.PassengersFactory;
import za.ac.cput.service.passenger.Impl.PassengersServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)

class PassengersServiceImplTest {
    @Autowired
   private PassengersServiceImpl passengersService;
   Passengers passengers = PassengersFactory.createPassengers("219383448", "Sandra", "Nyota","32");

   @Test
 void a_save() {
       Passengers temp = passengersService.save(passengers);
      assertNotNull(temp);
  }

    @Test
   void b_read() {
       Optional<Passengers> read = this.passengersService.read("219383448");
       assertNotNull(read);
       System.out.println(read);
    }

    @Test
    void d_deleteByID() {
      this.passengersService.deleteByID("219383448");
   }

    @Test
   void c_findById() {
        Optional<Passengers> saveEmp = this.passengersService.findById("219383448");
      assertNotNull(saveEmp);
       System.out.println(saveEmp);
       assertAll(
                () -> assertEquals("219383448", passengers.getPassengerID())
        );
  }

}