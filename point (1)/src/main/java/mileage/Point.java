package mileage;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name="Point_table")
public class Point {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long memberId;
    private Long remainPoint;
    private String memberStatus;
    private Long usePoint;

    @PostPersist
    public void onPostPersist(){
        PointSaved pointSaved = new PointSaved();
        BeanUtils.copyProperties(this, pointSaved);
        pointSaved.publishAfterCommit();


    }

    @PostUpdate
    public void onPostUpdate(){
        PointForfeited pointForfeited = new PointForfeited();
        BeanUtils.copyProperties(this, pointForfeited);
        pointForfeited.publishAfterCommit();


        PointUsed pointUsed = new PointUsed();
        BeanUtils.copyProperties(this, pointUsed);
        pointUsed.publishAfterCommit();


    }

       /*
        if ("WITHDRAWN".equals(memberStatus)) {
            PointForfeited pointForfeited = new PointForfeited();
            BeanUtils.copyProperties(this, pointForfeited);

            pointForfeited.setRemainPoint((long)0);
            pointForfeited.publishAfterCommit();

        }else {
            PointUsed pointUsed = new PointUsed();
            BeanUtils.copyProperties(this, pointUsed);


            pointUsed.publishAfterCommit();
        }

        */



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

    public void setUsePoint(Long usePoint) {this.usePoint = usePoint; }
    public Long getUsePoint() {return usePoint; }


}
