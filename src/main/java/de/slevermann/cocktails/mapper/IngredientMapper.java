package de.slevermann.cocktails.mapper;

import de.slevermann.cocktails.model.db.DbCreateIngredient;
import de.slevermann.cocktails.model.db.DbIngredient;
import de.slevermann.cocktails.model.db.DbUserInfo;
import de.slevermann.cocktails.model.CreateIngredient;
import de.slevermann.cocktails.model.Ingredient;
import org.springframework.stereotype.Component;

@Component
public class IngredientMapper {

    private final UserInfoMapper userInfoMapper;

    private final IngredientTypeMapper ingredientTypeMapper;

    private final TranslatedStringMapper translatedStringMapper;

    public IngredientMapper(UserInfoMapper userInfoMapper, IngredientTypeMapper ingredientTypeMapper, TranslatedStringMapper translatedStringMapper) {
        this.userInfoMapper = userInfoMapper;
        this.ingredientTypeMapper = ingredientTypeMapper;
        this.translatedStringMapper = translatedStringMapper;
    }

    public Ingredient dbIngredientToIngredient(DbIngredient dbIngredient) {
        Ingredient ingredient = new Ingredient()
                .id(dbIngredient.getUuid())
                .type(ingredientTypeMapper.dbIngredientTypetoIngredientType(dbIngredient.getType()))
                .names(translatedStringMapper.mapToTranslatedStrings(dbIngredient.getNames()))
                .descriptions(translatedStringMapper.mapToTranslatedStrings(dbIngredient.getDescriptions()))
                ._public(dbIngredient.isPublic());
        DbUserInfo userInfo = dbIngredient.getUserInfo();
        if (userInfo != null) {
            ingredient.owner(userInfoMapper.dbUserInfoToUserInfo(userInfo));
        }
        return ingredient;
    }

    public DbCreateIngredient createIngredientToDbCreateIngredient(CreateIngredient ingredient) {
        return DbCreateIngredient.builder()
                .typeId(ingredient.getTypeId())
                .names(translatedStringMapper.translatedStringsToMap(ingredient.getNames()))
                .descriptions(translatedStringMapper.translatedStringsToMap(ingredient.getDescriptions()))
                .build();
    }
}
