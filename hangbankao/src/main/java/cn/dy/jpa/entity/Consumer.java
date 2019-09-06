package cn.dy.jpa.entity;

import javax.persistence.*;

/**
 * author:dingyi
 * time:2019/8/18 0018 15:59
 */
@Entity
@Table(name = "consumer")
public class Consumer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "consumerId")
    private String consumerId;
    @Column(name = "consumerName")
    private String consumerName;

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "consumerId='" + consumerId + '\'' +
                ", consumerName='" + consumerName + '\'' +
                '}';
    }
}
