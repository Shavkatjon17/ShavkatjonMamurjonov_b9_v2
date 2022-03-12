package uz.pdp.ShavkatjonMamurjonov_b9_v2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private String name;
    private String phoneNumber;
    private String password;
}
