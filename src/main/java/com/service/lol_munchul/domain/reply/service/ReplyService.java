package com.service.lol_munchul.domain.reply.service;

import com.service.lol_munchul.domain.agenda.entity.Agenda;
import com.service.lol_munchul.domain.agenda.repository.AgendaRepository;
import com.service.lol_munchul.domain.reply.dto.ReplyCreateRequest;
import com.service.lol_munchul.domain.reply.dto.ReplyDeleteRequest;
import com.service.lol_munchul.domain.reply.dto.ReplyEditRequest;
import com.service.lol_munchul.domain.reply.dto.ReplyResponse;
import com.service.lol_munchul.domain.reply.entity.Reply;
import com.service.lol_munchul.domain.reply.repository.ReplyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Transactional
@Service
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final AgendaRepository agendaRepository;

    public Long createReply(ReplyCreateRequest replyCreateRequest) {

        Agenda agenda = agendaRepository.findById(replyCreateRequest.agendaId()).orElseThrow(
                IllegalArgumentException::new);

        Reply reply = Reply.builder().agenda(agenda)
                .replyCreateRequest(replyCreateRequest).build();

        return replyRepository.save(reply).getId();
    }

    public Long editReply(ReplyEditRequest replyEditRequest){
        Reply targetReply = replyRepository.findById(replyEditRequest.replyId()).orElseThrow(
                IllegalAccessError::new);

        if(!Objects.equals(targetReply.getPassword(), replyEditRequest.password())){
            throw new RuntimeException("비밀번호가 다릅니다.");
        }

        targetReply.updateReply(replyEditRequest);
        return targetReply.getId();
    }

    public void deleteReply(ReplyDeleteRequest replyDeleteRequest){
        Reply targetReply = replyRepository.findById(replyDeleteRequest.replyId()).orElseThrow(IllegalAccessError::new);

        if(!Objects.equals(targetReply.getPassword(), replyDeleteRequest.password())){
            throw new RuntimeException("비밀번호가 다릅니다.");
        }

        replyRepository.delete(targetReply);
    }

    public List<ReplyResponse> getAllReplies(Long agendaId){
        List<Reply> replies = replyRepository.findAllByAgendaId(agendaId);

        return replies.stream().map(reply -> reply.from(reply)).toList();
    }

    public Long increaseLikeCount(Long replyId){
        Reply targetReply = replyRepository.findById(replyId).orElseThrow(IllegalAccessError::new);
        targetReply.increaseLikeCount();
        return targetReply.getLikeCount();
    }

    public Long increaseHateCount(Long replyId){
        Reply targetReply = replyRepository.findById(replyId).orElseThrow(IllegalAccessError::new);
        targetReply.increaseHateCount();
        return targetReply.getHateCount();
    }
}