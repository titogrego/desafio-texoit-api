package Data;

import DTO.AddressDTO;
import DTO.CompanyDTO;
import DTO.GeoDTO;
import DTO.UserDTO;
import Helpers.BaseTest;
public class UsersData extends BaseTest {
    public static UserDTO retornaUser(){
        return UserDTO.builder()
                .name(faker.name().fullName())
                .username(faker.name().username())
                .email(faker.internet().emailAddress())
                .address(AddressDTO.builder()
                        .street(faker.address().streetAddress())
                        .suite("ap 201")
                        .city(faker.address().city())
                        .zipcode(faker.address().zipCode())
                        .geo(GeoDTO.builder()
                                .lat(faker.address().latitude())
                                .lng(faker.address().longitude())
                                .build())
                        .build())
                .phone(faker.phoneNumber().cellPhone())
                .website(faker.internet().domainName())
                .company(CompanyDTO.builder()
                        .name(faker.company().name())
                        .catchPhrase(faker.company().catchPhrase())
                        .bs(faker.company().bs())
                        .build())
                .build();
    }
}
