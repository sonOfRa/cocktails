/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.13).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package de.slevermann.cocktails.api;

import java.util.UUID;
import de.slevermann.cocktails.models.UserInfo;
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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-05-27T22:43:36.363649+02:00[Europe/Berlin]")
@Api(value = "users", description = "the users API")
public interface UsersApi {

    Logger log = LoggerFactory.getLogger(UsersApi.class);

    Optional<ObjectMapper> getObjectMapper();

    Optional<HttpServletRequest> getRequest();

    

    @ApiOperation(value = "Get a user's profile information", nickname = "getProfile", notes = "", response = UserInfo.class, tags={ "users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = UserInfo.class) })
    @RequestMapping(value = "/users/info/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<UserInfo> getProfile(@ApiParam(value = "",required=true) @PathVariable("id") UUID id);


    @ApiOperation(value = "Get information about the currently logged in user", nickname = "getUserInfo", notes = "", response = UserInfo.class, authorizations = {
        @Authorization(value = "oauth2", scopes = { 
            @AuthorizationScope(scope = "openid", description = "Default OpenID scope")
            })    }, tags={ "users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = UserInfo.class) })
    @RequestMapping(value = "/users/info",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<UserInfo> getUserInfo();


    @ApiOperation(value = "Set the current user's nickname", nickname = "setNick", notes = "", authorizations = {
        @Authorization(value = "oauth2", scopes = { 
            @AuthorizationScope(scope = "openid", description = "Default OpenID scope")
            })    }, tags={ "users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Success"),
        @ApiResponse(code = 409, message = "Name is taken") })
    @RequestMapping(value = "/users/nick",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> setNick(@ApiParam(value = "" ,required=true )  @Valid @RequestBody String body);

}
