package rc.bootsecurity.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DbInit implements CommandLineRunner {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // $2a$10$nLMb8emexE4wp5RDgROHjOIIPduq.waYZcmrq7BFTOm3CQqyRl5om
//        userRepository.deleteAll();
//        User slava = new User("slava", passwordEncoder.encode("slava123"), "ADMIN", "ACCESS_TEST1, ACCESS_TEST2", new BigDecimal(1200));
//        User admin = new User("admin", passwordEncoder.encode("admin123"), "ADMIN", "ACCESS_TEST1, ACCESS_TEST2", new BigDecimal(750));
//        User manager = new User("manager", passwordEncoder.encode("manager123"), "MANAGER", "ACCESS_TEST1", new BigDecimal(1430));
//        List<User> users = Arrays.asList(slava, admin, manager);
//        userRepository.saveAll(users);
    }
}
