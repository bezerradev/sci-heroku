/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sci.repository;

import br.com.sci.model.Destinatario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author italo
 */
public interface DestinatarioRepositiry extends JpaRepository<Destinatario, Long> {
    
}
