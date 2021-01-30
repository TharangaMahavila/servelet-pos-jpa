package lk.ijse.dep.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "order_detail")
public class OrderDetail implements SuperEntity {

    @EmbeddedId
    private OrderDetailPK orderDetailPK;
    private int qty;
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
}
