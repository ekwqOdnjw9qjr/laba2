package ru.edu.penzgtu.service;

import ru.edu.penzgtu.service.mapper.CookMapper;
import ru.edu.penzgtu.dto.CookDto;
import ru.edu.penzgtu.entity.Cook;
import org.springframework.stereotype.Service;
import ru.edu.penzgtu.exception.ErrorType;
import ru.edu.penzgtu.exception.PenzGtuException;
import ru.edu.penzgtu.repo.CookRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CookService {
    private final CookRepository cookRepository;
    private final CookMapper cookMapper;

    public List<CookDto> findAllCooks(){
        return cookMapper.toListDto(cookRepository.findAll());
    }

    public CookDto findCookById(Long id)  {
        Cook cook = cookRepository.findById(id)
                .orElseThrow(()-> new PenzGtuException(ErrorType.NOT_FOUND,"Cook with  id " + id + " not found"));
        return cookMapper.toDto(cook);
    }

    public void saveCook(CookDto cookDto){
        Cook cook = cookMapper.toEntity(cookDto);
        cookRepository.save(cook);
    }

    public void updateCook(CookDto newCook) {
        Cook oldCook = cookRepository.findById(newCook.getId())

                .orElseThrow(() ->new RuntimeException("Cook not found"));
        oldCook.setName(newCook.getName());
        cookRepository.save(oldCook);

    }

    public void deleteCookById(Long id ) {
        cookRepository.deleteById(id);
    }

}
