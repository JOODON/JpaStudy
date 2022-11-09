package study;

import javax.persistence.*;

@Entity
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ITEM_ID")
    private Long id;
    private String name;
    private int price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public PurchaseOrder getOrder() {
        return order;
    }

    public void setOrder(PurchaseOrder order) {
        this.order = order;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    //연관된 엔티티는 가져오지 않음!
    @JoinColumn(name = "PURCHASE_ORDER_ID")
    //FK로 사용되는 컬럼임을 명시한다
    //조인할떄 쓰는 컬럼을 확인
    private PurchaseOrder order;
}
