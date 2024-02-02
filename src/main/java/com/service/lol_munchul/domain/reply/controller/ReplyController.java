package com.service.lol_munchul.domain.reply.controller;

import com.service.lol_munchul.domain.reply.dto.ReplyCreateRequest;
import com.service.lol_munchul.domain.reply.dto.ReplyDeleteRequest;
import com.service.lol_munchul.domain.reply.dto.ReplyEditRequest;
import com.service.lol_munchul.domain.reply.dto.ReplyResponse;
import com.service.lol_munchul.domain.reply.service.ReplyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/replies")
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping("/create")
    public Long createReply(@RequestBody @Valid ReplyCreateRequest replyCreateRequest) {
        return replyService.createReply(replyCreateRequest);
    }

    @PatchMapping("/edit")
    public Long editReply(@RequestBody @Valid ReplyEditRequest replyEditRequest) {
        return replyService.editReply(replyEditRequest);
    }

    @DeleteMapping("/delete")
    public void deleteReply(@RequestBody @Valid ReplyDeleteRequest replyDeleteRequest) {
        replyService.deleteReply(replyDeleteRequest);
    }

    @GetMapping("/{agendaId}")
    public List<ReplyResponse> getAllReplies(@PathVariable Long agendaId) {
        return replyService.getAllReplies(agendaId);
    }

    @PostMapping("/like/{replyId}")
    public void increaseLikeCount(@PathVariable Long replyId) {
        replyService.increaseLikeCount(replyId);
    }

    @PostMapping("/hate/{replyId}")
    public void increaseHateCount(@PathVariable Long replyId) {
        replyService.increaseHateCount(replyId);
    }

}