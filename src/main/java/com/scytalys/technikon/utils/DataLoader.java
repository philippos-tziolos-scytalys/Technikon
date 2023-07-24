package com.scytalys.technikon.utils;

import com.scytalys.technikon.domain.*;
import com.scytalys.technikon.encryption.PasswordEncryption;
import com.scytalys.technikon.repository.RoleRepository;
import com.scytalys.technikon.repository.UserRepository;
import com.scytalys.technikon.service.PropertyService;
import com.scytalys.technikon.service.RepairService;
import com.scytalys.technikon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PropertyService propertyService;
    private final RepairService repairService;
    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {

        Role adminRole = new Role();
        adminRole.setName("ROLE_ADMIN");
        roleRepository.save(adminRole);


        User alex = User.builder()
                .tinNumber(123456789L)
                .name("Alex")
                .lastname("Giounan")
                .address("Omirou 6-8")
                .phoneNumber(123456789L)
                .username("alexG")
                .email("alex@example.com")
                .password(PasswordEncryption.getHashCode("alex123"))
                .build();

        alex.getRoles().add(adminRole);
        userRepository.save(alex);


    }
}
