package DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    public int id;
    public String name;
    public String username;
    public String email;
    public AddressDTO address;
    public String phone;
    public String website;
    public CompanyDTO company;
}
