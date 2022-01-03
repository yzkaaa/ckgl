package com.example.sys.common;


        import com.example.sys.entity.User;
        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

        import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActiverUser {
    private User user;
    private List<String> roles;
    private List<String> permissions;
}
