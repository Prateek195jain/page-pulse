package com.prateek.pagepulse.controller;

import com.prateek.pagepulse.dto.AuditRequest;
import com.prateek.pagepulse.dto.AuditResponse;
import com.prateek.pagepulse.service.AuditService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/audit")
public class AuditController {

    private final AuditService auditService;

    public AuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    @PostMapping
    public AuditResponse audit(@Valid @RequestBody AuditRequest request) {
        return auditService.audit(request.getUrl());
    }
}