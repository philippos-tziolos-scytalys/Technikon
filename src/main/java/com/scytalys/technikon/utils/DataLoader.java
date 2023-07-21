//package com.scytalys.technikon.utils;
//
//import com.scytalys.technikon.domain.*;
//import com.scytalys.technikon.service.PropertyService;
//import com.scytalys.technikon.service.RepairService;
//import com.scytalys.technikon.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.math.BigDecimal;
//import java.time.Instant;
//import java.util.Date;
//
//@Component
//@RequiredArgsConstructor
//public class DataLoader implements CommandLineRunner {
//
//    private final UserService userService;
//    private final PropertyService propertyService;
//    private final RepairService repairService;
//
//    @Override
//    public void run(String... args) throws Exception {
//        Role role = new Role();
//        role.setName("ADMIN");
//
//        User user = User.builder()
//                .phoneNumber(123456789L)
//                .name("Alex").tinNumber(55555555L).email("alex@example.com")
//                .address("Omirou 6-8").username("alex").password("alex123").build();
//
//
//        userService.createUser(user);
//
//
//        Property property = Property.builder()
//                .user(user)
//                .address(user.getAddress())
//                .activeState(true)
//                .pinNumber(24124512341L)
//                .propertyCoordinatesLong(124230L)
//                .propertyCoordinatesLat(235241L)
//                .propertyType(PropertyType.DETACHED_HOUSE)
//                .build();
//
//        propertyService.createProperty(property);
//
//        Repair repair = Repair.builder()
//                .property(property)
//                .description("Repairing done")
//                .cost(BigDecimal.valueOf(5000))
//                .repairDate(Date.from(Instant.now()))
//                .repairStatus(RepairStatus.COMPLETED)
//                .repairType(RepairType.INSULATION)
//                .build();
//
//        Repair repair2 = Repair.builder()
//                .property(property)
//                .description("Repairing soon")
//                .cost(BigDecimal.valueOf(789))
//                .repairDate(Date.from(Instant.now()))
//                .repairStatus(RepairStatus.SCHEDULED)
//                .repairType(RepairType.PAINTING)
//                .build();
//
//        repairService.create(repair);
//        repairService.create(repair2);
//
//        System.out.println(user.getId());
//        System.out.println(property.getId());
//        System.out.println(repair.getId());
//    }
//}
