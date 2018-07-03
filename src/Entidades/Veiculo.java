/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Batata
 */
@Entity
@Table(name = "veiculo")
@NamedQueries({
    @NamedQuery(name = "Veiculo.findAll", query = "SELECT v FROM Veiculo v")})
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_veiculo")
    private Integer idVeiculo;
    @Basic(optional = false)
    @Column(name = "preco_por_dia")
    private double precoPorDia;
    @Basic(optional = false)
    @Column(name = "placa_veiculo")
    private String placaVeiculo;
    @Basic(optional = false)
    @Column(name = "caminho")
    private String caminho;
    @JoinColumn(name = "cor_id_cor", referencedColumnName = "id_cor")
    @ManyToOne(optional = false)
    private Cor corIdCor;
    @JoinColumn(name = "marca_id_marca", referencedColumnName = "id_marca")
    @ManyToOne(optional = false)
    private Marca marcaIdMarca;
    @JoinColumn(name = "modelo_id_modelo", referencedColumnName = "id_modelo")
    @ManyToOne(optional = false)
    private Modelo modeloIdModelo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "veiculo")
    private List<AluguelHasVeiculo> aluguelHasVeiculoList;

    public Veiculo() {
    }

    public Veiculo(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Veiculo(Integer idVeiculo, double precoPorDia, String placaVeiculo, String caminho) {
        this.idVeiculo = idVeiculo;
        this.precoPorDia = precoPorDia;
        this.placaVeiculo = placaVeiculo;
        this.caminho = caminho;
    }

    public Integer getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public double getPrecoPorDia() {
        return precoPorDia;
    }

    public void setPrecoPorDia(double precoPorDia) {
        this.precoPorDia = precoPorDia;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public Cor getCorIdCor() {
        return corIdCor;
    }

    public void setCorIdCor(Cor corIdCor) {
        this.corIdCor = corIdCor;
    }

    public Marca getMarcaIdMarca() {
        return marcaIdMarca;
    }

    public void setMarcaIdMarca(Marca marcaIdMarca) {
        this.marcaIdMarca = marcaIdMarca;
    }

    public Modelo getModeloIdModelo() {
        return modeloIdModelo;
    }

    public void setModeloIdModelo(Modelo modeloIdModelo) {
        this.modeloIdModelo = modeloIdModelo;
    }

    public List<AluguelHasVeiculo> getAluguelHasVeiculoList() {
        return aluguelHasVeiculoList;
    }

    public void setAluguelHasVeiculoList(List<AluguelHasVeiculo> aluguelHasVeiculoList) {
        this.aluguelHasVeiculoList = aluguelHasVeiculoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVeiculo != null ? idVeiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Veiculo)) {
            return false;
        }
        Veiculo other = (Veiculo) object;
        if ((this.idVeiculo == null && other.idVeiculo != null) || (this.idVeiculo != null && !this.idVeiculo.equals(other.idVeiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idVeiculo + "-" + marcaIdMarca.getNome() + "-" + modeloIdModelo.getNomeModelo();
    }
    
}
