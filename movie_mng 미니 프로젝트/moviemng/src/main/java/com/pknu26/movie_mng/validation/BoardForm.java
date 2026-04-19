package com.pknu26.movie_mng.validation;

import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
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

    @DecimalMin(value = "0.0", message = "평점은 0.0 이상이어야 합니다")
    @DecimalMax(value = "10.0", message = "평점은 10.0 이하이어야 합니다")
    private Double rating;         // 평점

    
}

