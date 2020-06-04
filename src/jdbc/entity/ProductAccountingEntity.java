package jdbc.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="PRODUCTACCOUNTING")
public class ProductAccountingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productAccountingId;

    private String productAccountingType;

    private String productAccountingStatus;

    private BigDecimal amount;

    private String currency;

    public Long getProductAccountingId() {
        return productAccountingId;
    }

    public void setProductAccountingId(Long productAccountingId) {
        this.productAccountingId = productAccountingId;
    }

    public String getProductAccountingType() {
        return productAccountingType;
    }

    public void setProductAccountingType(String productAccountingType) {
        this.productAccountingType = productAccountingType;
    }

    public String getProductAccountingStatus() {
        return productAccountingStatus;
    }

    public void setProductAccountingStatus(String productAccountingStatus) {
        this.productAccountingStatus = productAccountingStatus;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    private Date createDate;

    @Override
    public String toString() {
        return "ProductAccountingEntity{" +
                "productAccountingId=" + productAccountingId +
                ", productAccountingType='" + productAccountingType + '\'' +
                ", productAccountingStatus='" + productAccountingStatus + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}