package lk.ijse.dep.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "order")
public class Order implements SuperEntity {

    @Id
    private String id;
    private Date date;
    private String customerId;
}
