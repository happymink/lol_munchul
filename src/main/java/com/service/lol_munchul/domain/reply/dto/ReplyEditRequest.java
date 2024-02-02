package com.service.lol_munchul.domain.reply.dto;

public record ReplyEditRequest(
        Long replyId,
        String author,
        String content,
        String password
) {
}
