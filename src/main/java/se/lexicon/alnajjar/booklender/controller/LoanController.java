package se.lexicon.alnajjar.booklender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.alnajjar.booklender.dto.LoanDto;
import se.lexicon.alnajjar.booklender.service.LoanService;

import java.util.List;

@RestController
@RequestMapping("/api/loan")
public class LoanController {

    LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("/{loanId}")
    public ResponseEntity<LoanDto> findById(@PathVariable("loanId") long loanId) {
        System.out.println(" loanId = " + loanId);
        LoanDto loanDto = loanService.findById(loanId);
        return ResponseEntity.ok(loanDto);
    }

    @GetMapping("/")
    public ResponseEntity<List<LoanDto>> findAll() {
        List<LoanDto> loanDto = loanService.findAll();
        System.out.println("loanDto.toString() = " + loanDto.toString());
        return ResponseEntity.ok(loanDto);
    }

    @PostMapping("/")
    public ResponseEntity<LoanDto> create(@RequestBody LoanDto dto) {
        LoanDto loanDto = loanService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(loanDto);
    }

    @PutMapping("/")
    public ResponseEntity<LoanDto> update(@RequestBody LoanDto dto) {
        LoanDto loanDto = loanService.update(dto);
        return ResponseEntity.ok(loanDto);
    }

}
