package com.pknu26.movie_mng.validation;

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
}
