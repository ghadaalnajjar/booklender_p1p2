package se.lexicon.alnajjar.booklender.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.alnajjar.booklender.dto.LoanDto;
import se.lexicon.alnajjar.booklender.entity.Loan;
import se.lexicon.alnajjar.booklender.repository.LoanRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanServiceImpl implements LoanService {

    LoanRepository loanRepository;
    ModelMapper mapper;

    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository, ModelMapper mapper) {
        this.loanRepository = loanRepository;
        this.mapper = mapper;
    }

    @Override
    public LoanDto findById(long loanId) {
        return mapper.map(findById(loanId), LoanDto.class);
    }

    @Override
    public List<LoanDto> findByBookId(int bookId) {
        List<Loan> loanList = (List<Loan>) loanRepository.findByBookBookId(bookId);
        List<LoanDto> loanDtoList = loanList.stream().map(loan -> mapper.map(loanRepository, LoanDto.class)).collect(Collectors.toList());
        return loanDtoList;
    }

    @Override
    public List<LoanDto> findByUserId(int userId) {
        List<Loan> loanList = (List<Loan>) loanRepository.findByLoanTakerUserId(userId);
        List<LoanDto> loanDtoList = loanList.stream().map(loan -> mapper.map(loanRepository, LoanDto.class)).collect(Collectors.toList());
        return loanDtoList;
    }

    @Override
    public List<LoanDto> findByTerminate(boolean terminate) {
        List<Loan> loanList = (List<Loan>) loanRepository.findByTerminate(terminate);
        List<LoanDto> loanDtoList = loanList.stream().map(loan -> mapper.map(loanRepository, LoanDto.class)).collect(Collectors.toList());
        return loanDtoList;
    }

    @Override
    public List<LoanDto> findAll() {
        List<Loan> loanList = (List<Loan>) loanRepository.findAll();
        //stream get object - mapper
        List<LoanDto> loanDtoList = loanList.stream().map(loan -> mapper.map(loanRepository ,LoanDto.class)).collect(Collectors.toList());
        return loanDtoList;
    }

    @Override
    public LoanDto create(LoanDto loandto) {
        Loan entityLoan = mapper.map(loandto, Loan.class);
        Loan saveLoan = loanRepository.save(entityLoan);
        return mapper.map(saveLoan, LoanDto.class);
    }

    @Override
    public LoanDto update(LoanDto loanDto) {
        return mapper.map(loanDto.getLoanId(), LoanDto.class);
    }

    @Override
    public boolean delete(long loanId) {
        mapper.map(delete(loanId), LoanDto.class);
        return false;
    }
}
