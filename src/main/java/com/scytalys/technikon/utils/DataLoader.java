package com.scytalys.technikon.utils;

import com.scytalys.technikon.repository.RoleRepository;
import com.scytalys.technikon.repository.UserRepository;
import com.scytalys.technikon.service.PropertyService;
import com.scytalys.technikon.service.RepairService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PropertyService propertyService;
    private final RepairService repairService;
    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {


    }
}
