/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Alunos
 */
@Entity
@Table(name = "cliente", catalog = "aprender", schema = "")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByCliCod", query = "SELECT c FROM Cliente c WHERE c.clientePK.cliCod = :cliCod")
    , @NamedQuery(name = "Cliente.findByCliNome", query = "SELECT c FROM Cliente c WHERE c.clientePK.cliNome = :cliNome")
    , @NamedQuery(name = "Cliente.findByCliEnd", query = "SELECT c FROM Cliente c WHERE c.cliEnd = :cliEnd")
    , @NamedQuery(name = "Cliente.findByCliEmail", query = "SELECT c FROM Cliente c WHERE c.cliEmail = :cliEmail")
    , @NamedQuery(name = "Cliente.findByCliTel", query = "SELECT c FROM Cliente c WHERE c.cliTel = :cliTel")})
public class Cliente implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClientePK clientePK;
    @Basic(optional = false)
    @Column(name = "cli_end")
    private String cliEnd;
    @Column(name = "cli_email")
    private String cliEmail;
    @Column(name = "cli_tel")
    private BigInteger cliTel;

    public Cliente() {
    }

    public Cliente(ClientePK clientePK) {
        this.clientePK = clientePK;
    }

    public Cliente(ClientePK clientePK, String cliEnd) {
        this.clientePK = clientePK;
        this.cliEnd = cliEnd;
    }

    public Cliente(int cliCod, String cliNome) {
        this.clientePK = new ClientePK(cliCod, cliNome);
    }

    public ClientePK getClientePK() {
        return clientePK;
    }

    public void setClientePK(ClientePK clientePK) {
        this.clientePK = clientePK;
    }

    public String getCliEnd() {
        return cliEnd;
    }

    public void setCliEnd(String cliEnd) {
        String oldCliEnd = this.cliEnd;
        this.cliEnd = cliEnd;
        changeSupport.firePropertyChange("cliEnd", oldCliEnd, cliEnd);
    }

    public String getCliEmail() {
        return cliEmail;
    }

    public void setCliEmail(String cliEmail) {
        String oldCliEmail = this.cliEmail;
        this.cliEmail = cliEmail;
        changeSupport.firePropertyChange("cliEmail", oldCliEmail, cliEmail);
    }

    public BigInteger getCliTel() {
        return cliTel;
    }

    public void setCliTel(BigInteger cliTel) {
        BigInteger oldCliTel = this.cliTel;
        this.cliTel = cliTel;
        changeSupport.firePropertyChange("cliTel", oldCliTel, cliTel);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientePK != null ? clientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.clientePK == null && other.clientePK != null) || (this.clientePK != null && !this.clientePK.equals(other.clientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Cliente[ clientePK=" + clientePK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
