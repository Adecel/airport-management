package za.ac.cput.service.passenger.Impl;
/*Author: Hilary Cassidy Nguepi Nangmo (220346887)
        Date: 2022/08/07
        */
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.passenger.PassengerGender;
import za.ac.cput.repository.passenger.PassengerGenderRepository;
import za.ac.cput.service.passenger.PassengerGenderService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PassengerGenderServiceImpl implements PassengerGenderService{

    private final PassengerGenderRepository repository;


    @Override
    public PassengerGender save(PassengerGender passengerGender) {
        return this.repository.save(passengerGender);
    }

    @Override
    public Optional<PassengerGender> read(String s) {
        return this.repository.findById(s);
    }

    @Override
    public void delete(String passengerGender)
    {
        this.repository.delete(passengerGender);

    }
}
