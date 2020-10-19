package mileage;

public class PointForfeited extends AbstractEvent {

    private Long id;
    private Long memberId;
    private Long remainPoint;
    private Long usePoint;

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

    public void setUsePoint(Long usePoint) {this.usePoint = usePoint; }
    public Long getUsePoint() {return usePoint; }
}
