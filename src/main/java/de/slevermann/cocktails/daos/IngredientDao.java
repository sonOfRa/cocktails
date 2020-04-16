package de.slevermann.cocktails.daos;

import de.slevermann.cocktails.models.GetIngredient;
import de.slevermann.cocktails.models.Locale;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

@UseClasspathSqlLocator
public interface IngredientDao {

    @SqlQuery
    GetIngredient findByIdAndLocale(@Bind Long id, @Bind String language, @Bind String country);

    @SqlQuery
    List<Locale> findLocalesForIngredient(@Bind Long id);
}
