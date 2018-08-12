package nl.arjen.udbackend.dao;

import nl.arjen.udbackend.rest.model.TotalItem;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by arjen on 8/12/18.
 */
@Component
public class MonthDao {

    @Autowired
    private Jdbi jdbi;

    private final String SQL_ADDED_BY_MONTH = "SELECT category AS label, SUM(bedrag) AS total " +
            "FROM uitgaven " +
            "WHERE maand = :month AND afbij='Bij' " +
            "GROUP BY category";

    public List<TotalItem> getAddedByMonth(int month) {
        return jdbi.withHandle(handle ->
                handle.createQuery(SQL_ADDED_BY_MONTH)
                      .bind("month", month)
                      .map((rs, ctx) -> new TotalItem(rs.getString("label"), rs.getDouble("total")))
                      .list()
        );
    }

}
