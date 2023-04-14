/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Alunos
 */
@Embeddable
public class ClientePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cli_cod")
    private int cliCod;
    @Basic(optional = false)
    @Column(name = "cli_nome")
    private String cliNome;

    public ClientePK() {
    }

    public ClientePK(int cliCod, String cliNome) {
        this.cliCod = cliCod;
        this.cliNome = cliNome;
    }

    public int getCliCod() {
        return cliCod;
    }

    public void setCliCod(int cliCod) {
        this.cliCod = cliCod;
    }

    public String getCliNome() {
        return cliNome;
    }

    public void setCliNome(String cliNome) {
        this.cliNome = cliNome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cliCod;
        hash += (cliNome != null ? cliNome.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientePK)) {
            return false;
        }
        ClientePK other = (ClientePK) object;
        if (this.cliCod != other.cliCod) {
            return false;
        }
        if ((this.cliNome == null && other.cliNome != null) || (this.cliNome != null && !this.cliNome.equals(other.cliNome))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.ClientePK[ cliCod=" + cliCod + ", cliNome=" + cliNome + " ]";
    }
    
}
