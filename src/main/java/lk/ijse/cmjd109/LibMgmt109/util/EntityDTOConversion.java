package lk.ijse.cmjd109.LibMgmt109.util;

import lk.ijse.cmjd109.LibMgmt109.dto.BookDTO;
import lk.ijse.cmjd109.LibMgmt109.entities.BookEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.awt.print.Book;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EntityDTOConversion {
    private final ModelMapper modelMapper;
    // Book
    public BookDTO toBookDTO(BookEntity book) {
        return modelMapper.map(book, BookDTO.class);
    }
    public BookEntity toBookEntity(BookDTO bookDTO) {
        return modelMapper.map(bookDTO,BookEntity.class);
    }
    public List<BookDTO> toBookDTOList(List<BookEntity> books){
        return modelMapper.map(books,new TypeToken<List<BookDTO>>(){}.getType());
    }



}
