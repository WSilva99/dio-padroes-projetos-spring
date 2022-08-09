package silva.walmir.padroesprojetosspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import silva.walmir.padroesprojetosspring.model.Client;
import silva.walmir.padroesprojetosspring.service.ClientService;

@RestController
@RequestMapping("clients")
public class ClientController {
  @Autowired
  private ClientService clientService;

  @GetMapping
  public ResponseEntity<Iterable<Client>> findAll() {
    return ResponseEntity.ok(clientService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Client> findById(@PathVariable Long id) {
    return ResponseEntity.ok(clientService.findById(id));
  }

  @PostMapping
  public ResponseEntity<Client> save(@RequestBody Client client) {
    clientService.save(client);
    return ResponseEntity.ok(client);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client) {
    clientService.update(id, client);
    return ResponseEntity.ok(client);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Client> delete(@PathVariable Long id) {
    clientService.delete(id);
    return ResponseEntity.ok().build();
  }
}
