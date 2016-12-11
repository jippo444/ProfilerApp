package wepa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import wepa.domain.Account;
import wepa.repository.AccountRepository;

import javax.annotation.PostConstruct;
import java.util.Arrays;


@Service
public class DefaultUserInitService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AccountRepository userDetailsRepository;
    @PostConstruct
    public void initDefaultUsers() {
        if (userDetailsRepository.findByUsername("reino") == null) {
            Account user = new Account();
            user.setUsername("reino");
            user.setPassword("$2a$10$3fT4VDT7t7N4bUtdajXa4ekC6NzAj9EO/08u920sR66wDFonlV.au");
            user.setAuthorities(Arrays.asList("ADMIN"));
            user = userDetailsRepository.save(user);
        }
        if (userDetailsRepository.findByUsername("maxwell") == null) {
            Account user2 = new Account();
            user2.setUsername("maxwell");
            user2.setPassword("$2a$10$HOenmXvSwgDYdJLt5mvYoelgKWRem9UcFf.yTUOjal7aoOsvf2SWi");
            user2.setAuthorities(Arrays.asList("USER"));
            user2 = userDetailsRepository.save(user2);
            System.out.println(user2.getPassword());
        }
    }
}