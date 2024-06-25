package com.example.demo.domain.health.controller.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Health", description = "Health Check 관련 API입니다.")
public interface HealthControllerDocs {

    @Operation(summary = "서버 상태 확인", description = "서버 상태를 확인합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "상태 체크 성공")})
    public ResponseEntity<String> healthCheck();
}
