package rc.bootsecurity.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rc.bootsecurity.repositories.ClientRepository;
import rc.bootsecurity.model.Client;

@Service
public class ClientPrincipalDetailsService implements UserDetailsService {

    private ClientRepository clientRepository;

    public ClientPrincipalDetailsService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Client user = clientRepository.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("User was not found!");
        }
        ClientPrincipalDetails clientPrincipalDetails = new ClientPrincipalDetails(user);
        return clientPrincipalDetails;
    }

}
