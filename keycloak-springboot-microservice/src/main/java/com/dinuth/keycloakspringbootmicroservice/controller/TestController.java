package com.dinuth.keycloakspringbootmicroservice.controller;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Set;

@RestController
@RequestMapping("/test")
public class TestController {



    //dev, superadmin, user
    @RequestMapping(value = "/anonymous", method = RequestMethod.GET)
    public ResponseEntity<String> getAnonymous(Principal principal) {


        KeycloakAuthenticationToken keycloakAuthenticationToken = (KeycloakAuthenticationToken) principal;
        AccessToken accessToken = keycloakAuthenticationToken.getAccount().getKeycloakSecurityContext().getToken();



//        AccessToken.Access access = accessToken.getResourceAccess("backend-service");
//        Set<String> roles = access.getRoles();

        AccessToken.Access access1 = accessToken.getRealmAccess();
        Set<String> roles1 = access1.getRoles();


        return ResponseEntity.ok(" realm roles: " + roles1 + " resource roles: "+roles1+" Hello Anonymous\n");
    }

   // @RolesAllowed("user")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<String> getUser(@RequestHeader String Authorization) {
        return ResponseEntity.ok("Hello User\n");
    }

   // @RolesAllowed("superadmin")
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ResponseEntity<String> getAdmin(@RequestHeader String Authorization) {
        return ResponseEntity.ok("Hello Admin\n");
    }

   // @RolesAllowed({ "superadmin", "user" })
    @RequestMapping(value = "/all-user", method = RequestMethod.GET)
    public ResponseEntity<String> getAllUser(@RequestHeader String Authorization) {
        return ResponseEntity.ok("Hello All User\n");
    }

}