
package mileage.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="point", url="${api.point.url}")
public interface PointService {

    @RequestMapping(method= RequestMethod.POST, path="/forfeitures")
    public void forfeit(@RequestBody Point point);

}