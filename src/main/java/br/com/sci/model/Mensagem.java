/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sci.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author italo
 */

@Entity
@Getter 
@Setter
@EqualsAndHashCode
public class Mensagem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String titulo;
    
    private String conteudo;
    
        @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "destinatario_mensagem",
            joinColumns = {
                @JoinColumn(name = "mensagem_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "destinatario_id")})
    private Set<Destinatario> destinatarios = new HashSet<>();

    public Mensagem() {
    }

    public Mensagem(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
       
    }
    
    public void addDestinatario(Destinatario d){
        this.destinatarios.add(d);
    }
    
    
}
