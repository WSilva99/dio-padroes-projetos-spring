package silva.walmir.padroesprojetosspring.service.impl;

import org.springframework.stereotype.Service;
import silva.walmir.padroesprojetosspring.model.Address;
import silva.walmir.padroesprojetosspring.model.AddressRepository;
import silva.walmir.padroesprojetosspring.model.Client;
import silva.walmir.padroesprojetosspring.model.ClientRepository;
import silva.walmir.padroesprojetosspring.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import silva.walmir.padroesprojetosspring.service.ViaCepService;

import java.util.Optional;

/**
 * Implementação da <b>Strategy</b> {@link ClientService},
 * injetável pelo Spring (via {@link Autowired}).
 * Tornand-se um {@link Service} e será tratada como um <b>Singleton</b>
 *
 * @author Walmir Silva
 */

@Service
public class ClientServiceImpl implements ClientService {
    // Singleton: Injetar os componentes do Spring com @Autowired
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ViaCepService viaCepService;

    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.get();
    }

    @Override
    public void save(Client client) {
        saveClientWithCep(client);
    }

    @Override
    public void update(long id, Client client) {
        Optional<Client> clientSaved = clientRepository.findById(id);
        if(clientSaved.isPresent()) {
            saveClientWithCep(client);
        }
    }

    @Override
    public void delete(long id) {
        clientRepository.deleteById(id);
    }

    private void saveClientWithCep(Client client) {
        String cep = client.getAddress().getCep();
        Address address = addressRepository.findById(cep).orElseGet(() -> {
            Address newAddress = viaCepService.findCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        client.setAddress(address);
        clientRepository.save(client);
    }
}
