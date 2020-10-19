package mileage;

public class PointForfeited extends AbstractEvent {

    private Long id;
    private Long memberId;
    private Long remainPoint;

    public PointForfeited(){
        super();
    }
    public PointForfeited(Point point) {
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
}
