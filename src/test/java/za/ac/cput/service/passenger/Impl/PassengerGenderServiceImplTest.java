package za.ac.cput.service.passenger.Impl;
/*Author: Hilary Cassidy Nguepi Nangmo (220346887)
  Date: 2022/08/07
        */
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.passenger.PassengerGender;
import za.ac.cput.factory.passenger.PassengerGenderFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@RequiredArgsConstructor
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PassengerGenderServiceImplTest {

    private PassengerGenderServiceImpl service;

    PassengerGender passengerGender ;
    @BeforeAll
    void BEFORE(){
        passengerGender= PassengerGenderFactory.getPassengerGender("12345","23452");
    }
    @Test
    void save() {
        PassengerGender S=this.service.save(passengerGender);
        assertEquals(S,passengerGender);
        assertNotNull(S);
        System.out.println(S.toString());

    }

    @Test
    void read() {
        Optional<PassengerGender> ID=this.service.read("");
        assertNotNull(ID);
        System.out.println(ID.toString());
    }

    @Test
    void delete() {
        this.service.delete(passengerGender);
    }
}