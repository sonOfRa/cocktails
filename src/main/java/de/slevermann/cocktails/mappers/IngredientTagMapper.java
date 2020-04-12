package de.slevermann.cocktails.mappers;

import de.slevermann.cocktails.models.IngredientTag;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

@Mapper
public class IngredientTagMapper implements RowMapper<IngredientTag> {
    @Override
    public IngredientTag map(ResultSet rs, StatementContext ctx) throws SQLException {
        IngredientTag tag = new IngredientTag();
        tag.setId(rs.getLong("id"));
        tag.setTag(rs.getString("tag"));
        return tag;
    }
}
