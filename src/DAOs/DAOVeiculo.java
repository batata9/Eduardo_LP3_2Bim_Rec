package DAOs;


import Entidades.Veiculo;
import DAOs.DAOGenerico;
import static DAOs.DAOGenerico.em;
import java.util.ArrayList;
import java.util.List;

public class DAOVeiculo extends DAOGenerico<Veiculo> {

    public DAOVeiculo() {
        super(Veiculo.class);
    }

    public int autoIdVeiculo() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idVeiculo) FROM Veiculo e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Veiculo> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Veiculo e WHERE e.precoPorDia LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Veiculo> listById(int id) {
        return em.createQuery("SELECT e FROM Veiculo e WHERE e.idVeiculo = :id").setParameter("id", id).getResultList();
    }

    public List<Veiculo> listInOrderNome() {
        return em.createQuery("SELECT e FROM Veiculo e ORDER BY e.precoPorDia").getResultList();
    }

    public List<Veiculo> listInOrderId() {
        return em.createQuery("SELECT e FROM Veiculo e ORDER BY e.idVeiculo").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Veiculo> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdVeiculo() + "-" + lf.get(i).getPrecoPorDia());
        }
        return ls;
    }
public static void main(String[] args) {
        DAOVeiculo daoVeiculo = new DAOVeiculo();
        List<Veiculo> listaVeiculo = daoVeiculo.list();
        for (Veiculo veiculo : listaVeiculo) {
            System.out.println(veiculo.getIdVeiculo() + "-" + veiculo.getPrecoPorDia());
        }
    }}
