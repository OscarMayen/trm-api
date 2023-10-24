
package com.curso.service;

import com.curso.conversion.TRM;
import com.curso.repository.TRMRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

/**
 *
 * @author omayen
 */

@ApplicationScoped
public class ConversionService {
    
    @Inject
    TRMRepository trmRepository;

    public Double conversionDolaAPesos(Double cantidadUSD) {
        TRM ultimoValorTrm = trmRepository.getUltimaTRM();
        return cantidadUSD * Double.parseDouble(ultimoValorTrm.getValor());
    }
}
