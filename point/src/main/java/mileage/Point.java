package mileage;

import javax.persistence.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Entity
@Table(name = "Point_table")
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long memberId;
    private Long remainPoint;
    private String memberStatus;
    private Long usePoint;

    @PostPersist
    public void onPostPersist() {
        System.out.println("onPostPersist");
        PointSaved pointSaved = new PointSaved();
        BeanUtils.copyProperties(this, pointSaved);
        pointSaved.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        System.out.println("onPostUpdate");

        if (usePoint <= 0) {
            PointUsed pointUsed = new PointUsed();
            BeanUtils.copyProperties(this, pointUsed);

            pointUsed.setRemainPoint(pointUsed.getRemainPoint() + usePoint);
            pointUsed.publishAfterCommit();


        } else {
            PointSaved pointSaved = new PointSaved();
            BeanUtils.copyProperties(this, pointSaved);

            pointSaved.setRemainPoint(pointSaved.getRemainPoint() + usePoint);
            pointSaved.publishAfterCommit();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getRemainPoint() {
        return remainPoint;
    }

    public void setRemainPoint(Long remainPoint) {
        this.remainPoint = remainPoint;
    }

    public String getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(String memberStatus) {
        this.memberStatus = memberStatus;
    }

    public Long getUsePoint() {
        return usePoint;
    }

    public void setUsePoint(Long usePoint) {
        this.usePoint = usePoint;
    }
}
