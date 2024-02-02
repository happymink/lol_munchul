package com.service.lol_munchul.domain.reply.dto;

import java.time.LocalDateTime;

public record ReplyResponse(
        Long replyId,
        String author,
        String content,
        Long likeCount,
        Long hateCount,
        LocalDateTime createdDate
) {
}
