
package com.curso.repository;

import com.curso.conversion.TRM;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import java.io.InputStream;
import java.util.List;

/**
 *
 * @author omayen
 */
@ApplicationScoped
public class TRMRepository {
    
    //Comentario
    public List<TRM> getAllTRMs() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<TRM> trms;

        try (InputStream is = getClass().getResourceAsStream("/trm.json")) {
            trms = objectMapper.readValue(is, new TypeReference<List<TRM>>() {});
            return trms;
        } catch (Exception e) {
            throw new RuntimeException("Error al leer el archivo JSON", e);
        }
    }

    public TRM getUltimaTRM() {
        List<TRM> trms = getAllTRMs();
        if (!trms.isEmpty()) {
            return trms.get(0);
        }
        return null;
    }
    
}
