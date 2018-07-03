package DAOs;


import Entidades.Aluguel;
import DAOs.DAOGenerico;
import static DAOs.DAOGenerico.em;
import java.util.ArrayList;
import java.util.List;

public class DAOAluguel extends DAOGenerico<Aluguel> {

    public DAOAluguel() {
        super(Aluguel.class);
    }

    public int autoIdAluguel() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idAluguel) FROM Aluguel e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Aluguel> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Aluguel e WHERE e.clienteLoginK LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Aluguel> listById(int id) {
        return em.createQuery("SELECT e FROM Aluguel e WHERE e.idAluguel = :id").setParameter("id", id).getResultList();
    }

    public List<Aluguel> listInOrderNome() {
        return em.createQuery("SELECT e FROM Aluguel e ORDER BY e.clienteLoginK").getResultList();
    }

    public List<Aluguel> listInOrderId() {
        return em.createQuery("SELECT e FROM Aluguel e ORDER BY e.idAluguel").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Aluguel> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdAluguel() + "-" + lf.get(i).getClienteLogin());
        }
        return ls;
    }
public static void main(String[] args) {
        DAOAluguel daoAluguel = new DAOAluguel();
        List<Aluguel> listaAluguel = daoAluguel.list();
        for (Aluguel aluguel : listaAluguel) {
            System.out.println(aluguel.getIdAluguel() + "-" + aluguel.getClienteLogin());
        }
    }}
