package mileage;

public class PointSaved extends AbstractEvent {

    private Long id;
    private Long memberId;
    private Long remainPoint;
    private String memberStatus;
    private Long usePoint;

    public PointSaved(){
        super();
    }
    public PointSaved(Point point){
        this();
        this.setId(point.getId());
        this.setMemberId(point.getMemberId());
        this.setRemainPoint(point.getRemainPoint());
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

    public void setUsePoint(Long usePoint) {this.usePoint = usePoint; }
    public Long getUsePoint() {return usePoint; }
}
