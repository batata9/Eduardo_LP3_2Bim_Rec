/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Batata
 */
@Entity
@Table(name = "aluguel_has_veiculo")
@NamedQueries({
    @NamedQuery(name = "AluguelHasVeiculo.findAll", query = "SELECT a FROM AluguelHasVeiculo a")})
public class AluguelHasVeiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AluguelHasVeiculoPK aluguelHasVeiculoPK;
    @Basic(optional = false)
    @Column(name = "quantidade_dias")
    private int quantidadeDias;
    @Basic(optional = false)
    @Column(name = "valor_dia")
    private double valorDia;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Column(name = "hora_fim")
    @Temporal(TemporalType.TIME)
    private Date horaFim;
    @JoinColumn(name = "veiculo_id_veiculo", referencedColumnName = "id_veiculo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Veiculo veiculo;
    @JoinColumn(name = "id_aluguel", referencedColumnName = "id_aluguel", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aluguel aluguel;

    public AluguelHasVeiculo() {
    }

    public AluguelHasVeiculo(AluguelHasVeiculoPK aluguelHasVeiculoPK) {
        this.aluguelHasVeiculoPK = aluguelHasVeiculoPK;
    }

    public AluguelHasVeiculo(AluguelHasVeiculoPK aluguelHasVeiculoPK, int quantidadeDias, double valorDia, Date data) {
        this.aluguelHasVeiculoPK = aluguelHasVeiculoPK;
        this.quantidadeDias = quantidadeDias;
        this.valorDia = valorDia;
        this.data = data;
    }

    public AluguelHasVeiculo(int idAluguel, int veiculoIdVeiculo) {
        this.aluguelHasVeiculoPK = new AluguelHasVeiculoPK(idAluguel, veiculoIdVeiculo);
    }

    public AluguelHasVeiculoPK getAluguelHasVeiculoPK() {
        return aluguelHasVeiculoPK;
    }

    public void setAluguelHasVeiculoPK(AluguelHasVeiculoPK aluguelHasVeiculoPK) {
        this.aluguelHasVeiculoPK = aluguelHasVeiculoPK;
    }

    public int getQuantidadeDias() {
        return quantidadeDias;
    }

    public void setQuantidadeDias(int quantidadeDias) {
        this.quantidadeDias = quantidadeDias;
    }

    public double getValorDia() {
        return valorDia;
    }

    public void setValorDia(double valorDia) {
        this.valorDia = valorDia;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Date horaFim) {
        this.horaFim = horaFim;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aluguelHasVeiculoPK != null ? aluguelHasVeiculoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AluguelHasVeiculo)) {
            return false;
        }
        AluguelHasVeiculo other = (AluguelHasVeiculo) object;
        if ((this.aluguelHasVeiculoPK == null && other.aluguelHasVeiculoPK != null) || (this.aluguelHasVeiculoPK != null && !this.aluguelHasVeiculoPK.equals(other.aluguelHasVeiculoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.AluguelHasVeiculo[ aluguelHasVeiculoPK=" + aluguelHasVeiculoPK + " ]";
    }
    
}
