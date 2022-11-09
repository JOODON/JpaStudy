package study;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main2 {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("JpaStudy");
        //데이터베이스의 정보를 읽어주는 부분!
        EntityManager em=emf.createEntityManager();

        EntityTransaction tx=em.getTransaction();

        try {
            tx.begin();
//            Item item1=new Item();
//            Item item2=new Item();
//            item1.setName("치킨");
//            item2.setName("치즈볼");
//
//            PurchaseOrder order=new PurchaseOrder();
//            order.setUserName("Kim");
//            order.getItems().add(item1);
//            order.getItems().add(item2);
//
//            item1.setOrder(order);
//            item2.setOrder(order);
//            //order부분을 1대다로 쿼리하기 위해서 이거까지 해줌!
//            em.persist(order);
//            em.persist(item1);
//            em.persist(item2);
//            em.flush();
//            em.clear();
            Item findItem=em.find(Item.class,2L);
            System.out.println("findItem.getOrder().getUserName()"+findItem.getOrder().getUserName());
            tx.commit();
//
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
    }

}
