package study;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("JpaStudy");
        //데이터베이스의 정보를 읽어주는 부분!
        EntityManager em=emf.createEntityManager();

        EntityTransaction tx=em.getTransaction();

        try {
            tx.begin();
//          Movie movie=new Movie();
//          movie.setMoveid(2L);
//          movie.setMovieName("오징어게임");

            Movie fineMv=em.find(Movie.class,1L);
            //식별자를 이용하여 찾기!
//          System.out.println("FindMv="+fineMv);

//         fineMv.setMovieName("로미오와줄리엣");
            //수정앞에다가 찾는거를 지정해주어야됨!

            em.remove(fineMv);
            //제거 메소드

            //em.persist(movie);
            //등록

            tx.commit();
            //실제로 데이터베이스의 커밋해주는 부분!
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
    }
}
