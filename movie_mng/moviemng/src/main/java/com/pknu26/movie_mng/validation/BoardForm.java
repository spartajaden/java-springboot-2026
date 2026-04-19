package com.pknu26.movie_mng.validation;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardForm {
    
    @Size(max = 250)
    @NotBlank(message = "제목은 필수입니다")
    private String title;
    
    @Size(max = 8000)
    @NotBlank(message = "내용을 작성하세요")
    private String content;

    private String genre;          // 장르

    private LocalDate releaseDate; // 개봉일

    private Integer duration;      // 영화시간 (분)

    public void setGenre(Object genre) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setGenre'");
    }

    public void setReleaseDate(Object releaseDate) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setReleaseDate'");
    }

    public void setDuration(Object duration) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setDuration'");
    }

    public void setRating(Object rating) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setRating'");
    }

    public Double getRating() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getRating'");
    }
}
