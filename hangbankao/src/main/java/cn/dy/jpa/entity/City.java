package cn.dy.jpa.entity;

import javax.persistence.*;

/**
 * author:dingyi
 * time:2019/8/18 0018 15:58
 */
@Entity
@Table(name = "city")
public class City {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cityId")
    private Long cityId;
    @Column(name = "takeOffCity")
    private String takeOffCity;
    @Column(name = "getToCity")
    private String getToCity;
    @Column(name = "filghtId")
    private String filghtId;
    @Column(name = "takeOffTime")
    private String takeOffTime;
    @Column(name = "getTOTime")
    private String getTOTime;

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getTakeOffCity() {
        return takeOffCity;
    }

    public void setTakeOffCity(String takeOffCity) {
        this.takeOffCity = takeOffCity;
    }

    public String getGetToCity() {
        return getToCity;
    }

    public void setGetToCity(String getToCity) {
        this.getToCity = getToCity;
    }

    public String getFilghtId() {
        return filghtId;
    }

    public void setFilghtId(String filghtId) {
        this.filghtId = filghtId;
    }

    public String getTakeOffTime() {
        return takeOffTime;
    }

    public void setTakeOffTime(String takeOffTime) {
        this.takeOffTime = takeOffTime;
    }

    public String getGetTOTime() {
        return getTOTime;
    }

    public void setGetTOTime(String getTOTime) {
        this.getTOTime = getTOTime;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", takeOffCity='" + takeOffCity + '\'' +
                ", getToCity='" + getToCity + '\'' +
                ", filghtId='" + filghtId + '\'' +
                ", takeOffTime='" + takeOffTime + '\'' +
                ", getTOTime='" + getTOTime + '\'' +
                '}';
    }
}
