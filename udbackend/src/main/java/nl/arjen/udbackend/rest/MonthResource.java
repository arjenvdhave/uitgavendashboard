package nl.arjen.udbackend.rest;

import nl.arjen.udbackend.dao.MonthDao;
import nl.arjen.udbackend.rest.model.TotalItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by arjen on 8/12/18.
 */
@RestController
public class MonthResource {

    @Autowired
    private MonthDao monthDao;

    @RequestMapping(path = "month", method = RequestMethod.GET)
    @ResponseBody
    public List<TotalItem> getAddedByMonth(@RequestParam(name = "month", required = true) int month) {
        return monthDao.getAddedByMonth(month);
    }
}
