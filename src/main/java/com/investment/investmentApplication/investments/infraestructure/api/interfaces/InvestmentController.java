package com.investment.investmentApplication.investments.infraestructure.api.interfaces;

import com.investment.investmentApplication.investments.domain.investment.Investment;
import com.investment.investmentApplication.investments.infraestructure.intvestment.persistence.InvestmentPostgresEntity;
import io.swagger.v3.oas.annotations.Operation;
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


    @Operation(description = "Create investment")
    @ApiResponse(responseCode= "201")
    @PostMapping("/create")
    ResponseEntity<InvestmentPostgresEntity> create(
            @RequestBody @Valid Investment investmentCreate
    );

    @Operation(description = "Find all investment")
    @ApiResponse(responseCode = "200")
    @GetMapping("/find-all")
    ResponseEntity<List<InvestmentPostgresEntity>> findAll();

    @Operation(description = "Find investment")
    @ApiResponse(responseCode = "200")
    @GetMapping("/find-by-id")
    ResponseEntity<InvestmentPostgresEntity> findById(
            @RequestParam UUID id
    );

    @Operation(description = "Update investment")
    @ApiResponse(responseCode = "200")
    @PatchMapping("/update")
    ResponseEntity<InvestmentPostgresEntity> update(
            @RequestParam UUID id,
            @RequestBody @Valid Investment investmentUpdate
    );

    @Operation(description = "Delete investment")
    @ApiResponse(responseCode = "204")
    @DeleteMapping("/delete")
    ResponseEntity<Void> delete(
            @RequestParam UUID id
    );

}
