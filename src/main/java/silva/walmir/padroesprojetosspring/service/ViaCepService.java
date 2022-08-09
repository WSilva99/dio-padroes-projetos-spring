package silva.walmir.padroesprojetosspring.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import silva.walmir.padroesprojetosspring.model.Address;

/**
 * Client HTTP para acessar o serviço de busca de endereço por CEP.
 *
 * @see <a href="https://spring.io/projects/spring-cloud-examples/spring-cloud-openfeign">Spring Cloud OpenFeign</a>
 * @see <a href="https://viacep.com.br/">ViaCep</a>
 *
 * @author Walmir Silva
 */

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws/")
public interface ViaCepService {
    @GetMapping("{cep}/json")
    Address findCep(@PathVariable("cep") String cep);
}
