package cn.dy.jpa.entity;

import javax.persistence.*;

/**
 * author:dingyi
 * time:2019/8/18 0018 15:59
 */
@Entity
@Table(name = "provicer")
public class Provider {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "provicerId")
    private Long provicerId;
    @Column(name = "provicerName")
    private Long provicerName;

    public Long getProvicerId() {
        return provicerId;
    }

    public void setProvicerId(Long provicerId) {
        this.provicerId = provicerId;
    }

    public Long getProvicerName() {
        return provicerName;
    }

    public void setProvicerName(Long provicerName) {
        this.provicerName = provicerName;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "provicerId=" + provicerId +
                ", provicerName=" + provicerName +
                '}';
    }
}
