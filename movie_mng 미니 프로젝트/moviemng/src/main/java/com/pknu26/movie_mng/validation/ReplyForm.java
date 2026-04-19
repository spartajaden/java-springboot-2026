package com.pknu26.movie_mng.validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
public class ReplyForm {

    @Size(max = 1000)
    @NotBlank(message = "댓글내용은 필수입니다")
    private String content;
}
