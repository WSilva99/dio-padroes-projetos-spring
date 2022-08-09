package silva.walmir.padroesprojetosspring.service;

import silva.walmir.padroesprojetosspring.model.Client;

/**
 * Interface <b>Strategy</b> para o domínio de Cliente.
 * Podemos ter várias implementações dessa interface.
 *
 * @author Walmir Silva
 *
 */

public interface ClientService {
    Iterable<Client> findAll();
    Client findById(Long id);
    void save(Client client);
    void update(long id, Client client);
    void delete(long id);
}
