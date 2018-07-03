/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Batata
 */
@Embeddable
public class AluguelHasVeiculoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_aluguel")
    private int idAluguel;
    @Basic(optional = false)
    @Column(name = "veiculo_id_veiculo")
    private int veiculoIdVeiculo;

    public AluguelHasVeiculoPK() {
    }

    public AluguelHasVeiculoPK(int idAluguel, int veiculoIdVeiculo) {
        this.idAluguel = idAluguel;
        this.veiculoIdVeiculo = veiculoIdVeiculo;
    }

    public int getIdAluguel() {
        return idAluguel;
    }

    public void setIdAluguel(int idAluguel) {
        this.idAluguel = idAluguel;
    }

    public int getVeiculoIdVeiculo() {
        return veiculoIdVeiculo;
    }

    public void setVeiculoIdVeiculo(int veiculoIdVeiculo) {
        this.veiculoIdVeiculo = veiculoIdVeiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAluguel;
        hash += (int) veiculoIdVeiculo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AluguelHasVeiculoPK)) {
            return false;
        }
        AluguelHasVeiculoPK other = (AluguelHasVeiculoPK) object;
        if (this.idAluguel != other.idAluguel) {
            return false;
        }
        if (this.veiculoIdVeiculo != other.veiculoIdVeiculo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.AluguelHasVeiculoPK[ idAluguel=" + idAluguel + ", veiculoIdVeiculo=" + veiculoIdVeiculo + " ]";
    }
    
}
