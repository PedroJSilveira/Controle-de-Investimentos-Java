package com.investment.investmentApplication.users.infraestructure.api.user.Interfaces;

import com.investment.investmentApplication.users.application.dtos.UserCreate;
import com.investment.investmentApplication.users.application.dtos.UserUpdate;
import com.investment.investmentApplication.users.domain.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@Tag(name= "Users module")
public interface UserController {

    @Operation(
            summary = "Create user",
            responses = {
                    @ApiResponse(description = "The User",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = User.class)
                            )
                    )
            }
    )
    @ApiResponse(responseCode= "201")
    @PostMapping("/create")
    ResponseEntity<User> create(
            @RequestBody UserCreate user
    );

    @Operation(
            summary = "Find user by id",
            responses = {
                    @ApiResponse(description = "The User",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = User.class)
                            )
                    )
            }
    )
    @ApiResponse(responseCode= "201")
    @GetMapping("/find-by-id")
    ResponseEntity<User> findById(
            @RequestParam("id") UUID id
    );

    @Operation(
            summary = "Update user",
            responses = {
                    @ApiResponse(description = "The User",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = User.class)
                            )
                    )
            }
    )
    @ApiResponse(responseCode= "201")
    @PutMapping("/update")
    ResponseEntity<User> update(
            @RequestParam("id") UUID id,
            @RequestBody UserUpdate user
    );

    @Operation(summary = "Delete investment")
    @ApiResponse(responseCode = "204")
    @DeleteMapping("/delete")
    ResponseEntity<Void> delete(
            @RequestParam("id") UUID id
    );
}
