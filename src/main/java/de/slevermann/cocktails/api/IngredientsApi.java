/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.13).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package de.slevermann.cocktails.api;

import de.slevermann.cocktails.models.CreateIngredient;
import de.slevermann.cocktails.models.Ingredient;
import de.slevermann.cocktails.models.IngredientType;
import de.slevermann.cocktails.models.LocalizedIngredient;
import de.slevermann.cocktails.models.LocalizedIngredientType;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-17T18:13:03.596+02:00[Europe/Berlin]")
@Api(value = "ingredients", description = "the ingredients API")
public interface IngredientsApi {

    Logger log = LoggerFactory.getLogger(IngredientsApi.class);

    Optional<ObjectMapper> getObjectMapper();

    Optional<HttpServletRequest> getRequest();

    

    @ApiOperation(value = "Create a new ingredient in the database", nickname = "createIngredient", notes = "", response = Ingredient.class, tags={ "ingredients", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Retrieve the created ingredient", response = Ingredient.class),
        @ApiResponse(code = 400, message = "Invalid ingredient data") })
    @RequestMapping(value = "/ingredients",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Ingredient> createIngredient(@ApiParam(value = "The ingredient to create" ,required=true )  @Valid @RequestBody CreateIngredient body);


    @ApiOperation(value = "Get a single ingredient by its ID", nickname = "getIngredientById", notes = "", response = Ingredient.class, tags={ "ingredients", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Found ingredient", response = Ingredient.class),
        @ApiResponse(code = 404, message = "Ingredient not found") })
    @RequestMapping(value = "/ingredients/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Ingredient> getIngredientById(@ApiParam(value = "",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "Get an ingredient type by its ID", nickname = "getIngredientTypeById", notes = "", response = IngredientType.class, responseContainer = "List", tags={ "ingredients", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = IngredientType.class, responseContainer = "List"),
        @ApiResponse(code = 404, message = "Ingredient Type not found") })
    @RequestMapping(value = "/ingredients/types/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<IngredientType>> getIngredientTypeById(@ApiParam(value = "",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "Get a list of ingredient types on the server", nickname = "getIngredientTypes", notes = "", response = LocalizedIngredientType.class, tags={ "ingredients", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = LocalizedIngredientType.class) })
    @RequestMapping(value = "/ingredients/types",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<LocalizedIngredientType> getIngredientTypes();


    @ApiOperation(value = "Get all ingredients", nickname = "getIngredients", notes = "", response = LocalizedIngredient.class, responseContainer = "List", tags={ "ingredients", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = LocalizedIngredient.class, responseContainer = "List") })
    @RequestMapping(value = "/ingredients",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<LocalizedIngredient>> getIngredients();


    @ApiOperation(value = "Update the ingredient with the specified ID", nickname = "updateIngredient", notes = "", response = Ingredient.class, tags={ "ingredients", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Updated successfully", response = Ingredient.class),
        @ApiResponse(code = 400, message = "Invalid ingredient data"),
        @ApiResponse(code = 404, message = "Ingredient not found") })
    @RequestMapping(value = "/ingredients/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Ingredient> updateIngredient(@ApiParam(value = "The ingredient data to update with" ,required=true )  @Valid @RequestBody CreateIngredient body,@ApiParam(value = "",required=true) @PathVariable("id") Long id);

}
