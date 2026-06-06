package com.investment.investmentApplication.investments.infraestructure.api.interfaces;

import com.investment.investmentApplication.investments.application.dto.InvestmentCreate;
import com.investment.investmentApplication.investments.domain.Investment;
import com.investment.investmentApplication.investments.application.dto.InvestmentUpdate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * The Class InvestmentController
 *
 * @author Pedro Junho Silveira
 * @since 29/10/2025
 */

@RestController
@RequestMapping("/investment")
@Tag(name = "Investment module")
public interface InvestmentController {


    @Operation(
            summary = "Create investment",
            responses = {
                    @ApiResponse(description = "The Investment",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Investment.class)
                            )
                    )
            }
    )
    @ApiResponse(responseCode= "201")
    @PostMapping("/create")
    ResponseEntity<Investment> create(
            @RequestBody @Valid InvestmentCreate investmentCreate
    );

    @Operation(
            summary = "Find all investment",
            responses = {
                    @ApiResponse(description = "All investments",
                        content = @Content(mediaType = "application/json",
                                array = @ArraySchema(schema =  @Schema(implementation = Investment.class))
                        )
                    ),
            }
    )
    @ApiResponse(responseCode = "200")
    @GetMapping("/find-all")
    ResponseEntity<List<Investment>> findAll();

    @Operation(
            summary = "Find investment",
            responses = {
                    @ApiResponse(description = "All investments",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Investment.class)
                            )
                    ),
            }
    )
    @ApiResponse(responseCode = "200")
    @GetMapping("/find-by-id")
    ResponseEntity<Investment> findById(
            @RequestParam(value = "investmentId") final UUID investmentId
    );

    @Operation(
            summary = "Update investment",
            responses = {
                    @ApiResponse(description = "The Investment",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Investment.class)
                            )
                    )
            }
    )
    @ApiResponse(responseCode = "200")
    @PatchMapping("/update")
    ResponseEntity<Investment> update(
            @RequestParam(value = "investmentId") UUID investmentId,
            @RequestBody @Valid InvestmentUpdate investmentUpdate
    );

    @Operation(summary = "Delete investment")
    @ApiResponse(responseCode = "204")
    @DeleteMapping("/delete")
    ResponseEntity<Void> delete(
            @RequestParam(value = "investmentId") UUID investmentId
    );

}
